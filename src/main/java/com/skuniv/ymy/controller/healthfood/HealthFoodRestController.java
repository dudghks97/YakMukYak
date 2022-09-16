package com.skuniv.ymy.controller.healthfood;

import com.skuniv.ymy.dtos.healthfood.HealthFoodInfoSaveRequestDto;
import com.skuniv.ymy.service.HealthFoodInfoService;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@RestController
public class HealthFoodRestController {
    private final HealthFoodInfoService healthFoodInfoService;

    /* 건강기능식품 API 데이터 저장 */
    /* 전체 데이터 저장 코드 */
    @GetMapping("/api/healthFood/save")
    public String saveHealthFood() {
        String result = "";
        String jsonPrintString = "";

        for (int i = 1; i <= 351; i++){
            try {
                StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/HtfsInfoService2/getHtfsItem"); /*URL*/
                urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=v3Z3f%2FSzidiBv4M4fvV3G1CdLwvpePyKorJv5GDRz4kFglFZEg00xQZrPZicEEusfOLI%2FLzszRM0LTU8vCfSeQ%3D%3D"); /*Service Key*/
                urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(i), "UTF-8")); /*페이지번호*/
                urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
                urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default: xml*/

                // API 연결
                URL url = new URL(urlBuilder.toString());
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
                jsonPrintString = String.valueOf(body);

                // body 의 items
                JSONArray items = (JSONArray) body.get("items");

                // JSON parsing
                for (int j = 0; j < items.size(); j++) {
                    JSONObject object = (JSONObject) items.get(j);

                    String enterpriseName = String.valueOf(object.get("ENTRPS"));
                    String itemName = String.valueOf(object.get("PRDUCT"));
                    String itemSeq = String.valueOf(object.get("STTEMNT_NO"));
                    String registeredDate = String.valueOf(object.get("REGIST_DT"));
                    String validDate = String.valueOf(object.get("DISTB_PD"));
                    String chart = String.valueOf(object.get("SUNGSANG"));
                    String useMethod = String.valueOf(object.get("SRV_USE"));
                    String precaution = String.valueOf(object.get("INTAKE_HINT1"));
                    String mainFunction = String.valueOf(object.get("MAIN_FNCTN"));
                    String baseStandard = String.valueOf(object.get("BASE_STANDARD"));

                    /* requestDto 생성 */
                    HealthFoodInfoSaveRequestDto requestDto = new HealthFoodInfoSaveRequestDto(
                            enterpriseName, itemName, itemSeq, registeredDate, validDate,
                            chart, useMethod, precaution, mainFunction, baseStandard
                    );

                    // DB insert
                    healthFoodInfoService.save(requestDto);
                }
                jsonPrintString = "Insertion Successfully Completed!";
            } catch (Exception e) {
                e.printStackTrace();
                jsonPrintString = String.valueOf(e);
            }
        }

        return jsonPrintString;
    }
}
