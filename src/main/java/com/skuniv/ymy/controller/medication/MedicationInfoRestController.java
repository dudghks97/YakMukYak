package com.skuniv.ymy.controller.medication;

import com.skuniv.ymy.dtos.medication.MedicationInfoSaveRequestDto;
import com.skuniv.ymy.service.MedicationInfoService;
import lombok.RequiredArgsConstructor;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MedicationInfoRestController {

    private final MedicationInfoService medicationInfoService;

    /* 의약품 API 데이터 저장 */
    /* 전체 데이터 저장 코드 */
    @GetMapping("/api/medication/save")
    public String saveMedication() {
        String result = "";
        String jsonPrintString = "";

        for (int i = 1; i <= 521; i++) {
            try {
                /* API 호출 */
                String urlBuilder = "http://apis.data.go.kr/1471000/DrugPrdtPrmsnInfoService02/getDrugPrdtPrmsnDtlInq01" + "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=v3Z3f%2FSzidiBv4M4fvV3G1CdLwvpePyKorJv5GDRz4kFglFZEg00xQZrPZicEEusfOLI%2FLzszRM0LTU8vCfSeQ%3D%3D" +
                        "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(i), "UTF-8") + /*페이지번호*/
                        "&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8") + /*한 페이지 결과 수*/
                        "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"); /*응답데이터 형식(xml/json) Default:xml*/

                // API 연결
                URL url = new URL(urlBuilder);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-type", "application/json");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                result = bufferedReader.readLine();

                // JSON Parsing
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

                // result 의 body
                JSONObject body = (JSONObject) jsonObject.get("body");
                // body 의 items
                JSONArray items = (JSONArray) body.get("items");

                // JsonArray 내부의 값 -> 내가 사용할 엔티티의 칼럼
                for (Object item : items) {
                    JSONObject object = (JSONObject) item;                // get() -> 단일 객체 정보 획득
                    String itemSeq = String.valueOf(object.get("ITEM_SEQ"));
                    String itemName = String.valueOf(object.get("ITEM_NAME"));
                    String enterpriseName = String.valueOf(object.get("ENTP_NAME"));
                    String permitDate = String.valueOf(object.get("ITEM_PERMIT_DATE"));
                    String classCode = String.valueOf(object.get("ETC_OTC_CODE"));
                    String chart = String.valueOf(object.get("CHART"));
                    String materialName = String.valueOf(object.get("MATERIAL_NANE"));
                    String efficacy = String.valueOf(object.get("EE_DOC_DATA"));
                    String useMethod = String.valueOf(object.get("UD_DOC_DATA"));
                    String generalPrecaution = String.valueOf(object.get("NB_DOC_DATA"));
                    String professionalPrecaution = String.valueOf(object.get("PN_DOC_DATA"));
                    String storageMethod = String.valueOf(object.get("STORAGE_METHOD"));
                    String validTerm = String.valueOf(object.get("VALID_TERM"));
                    String permitKindName = String.valueOf(object.get("PERMIT_KIND_NAME"));
                    String categoryType = String.valueOf(object.get("INDUTY_TYPE"));
                    String cancelName = String.valueOf(object.get("CANCEL_NAME"));
                    String cancelDate = String.valueOf(object.get("CANCEL_DATE"));
                    String changeDate = String.valueOf(object.get("CHANGE_DATE"));
                    String totalContent = String.valueOf(object.get("TOTAL_CONTENT"));
                    String mainIngredient = String.valueOf(object.get("MAIN_ITEM_INGR"));
                    String ingredientName = String.valueOf(object.get("INGR_NAME"));

                    // requestDto 생성
                    MedicationInfoSaveRequestDto requestDto = new MedicationInfoSaveRequestDto(
                            itemSeq, itemName, enterpriseName, permitDate, classCode, chart, materialName,
                            efficacy, useMethod, professionalPrecaution, generalPrecaution, storageMethod, validTerm,
                            permitKindName, categoryType, cancelName, cancelDate, changeDate, totalContent, mainIngredient, ingredientName
                    );

                    // DB insert
                    medicationInfoService.save(requestDto);
                    jsonPrintString = "Insertion Successfully Completed!";
                }

            } catch (Exception e) {
                e.printStackTrace();
                jsonPrintString = String.valueOf(e);
            }
        }
        return jsonPrintString;
    }

    @GetMapping("api/medication/read")
    public String read() {
        String result = "";
        String jsonPrintString = "";
        try{
            /* API 호출 */
            String urlBuilder = "http://apis.data.go.kr/1471000/DrugPrdtPrmsnInfoService02/getDrugPrdtPrmsnDtlInq01" + "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=v3Z3f%2FSzidiBv4M4fvV3G1CdLwvpePyKorJv5GDRz4kFglFZEg00xQZrPZicEEusfOLI%2FLzszRM0LTU8vCfSeQ%3D%3D" +
                    "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8") + /*페이지번호*/
                    "&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8") + /*한 페이지 결과 수*/
                    "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8"); /*응답데이터 형식(xml/json) Default:xml*/

            // API 연결
            URL url = new URL(urlBuilder);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/xml");
            conn.connect();

            // XML Parsing
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(conn.getInputStream());

            Element root = document.getRootElement();
            Element body = root.getChild("body");
            Element items = body.getChild("items");
            List<Element> item = items.getChildren("item");

            for (Element element : item) {
                jsonPrintString = element.getName();
                jsonPrintString += element.getChild("ITEM_NAME").getText();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPrintString;
    }
}
