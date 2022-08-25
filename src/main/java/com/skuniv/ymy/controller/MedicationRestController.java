package com.skuniv.ymy.controller;

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
public class MedicationRestController {

    @GetMapping("/test")
    public String test() {
        String result = "";
        String jsonPrintString = null;

        try {
            /* API 호출 */
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=v3Z3f%2FSzidiBv4M4fvV3G1CdLwvpePyKorJv5GDRz4kFglFZEg00xQZrPZicEEusfOLI%2FLzszRM0LTU8vCfSeQ%3D%3D");
            // urlBuilder.append("&" + URLEncoder.encode("itemName", "UTF-8") + "=" + URLEncoder.encode("한미아스피린장용정100밀리그램", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/

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

            // body 의 items
            JSONArray items = (JSONArray) body.get("items");
            // jsonPrintString = items.toString();

            // JsonArray 내부의 값 -> 내가 사용할 엔티티의 칼럼
//            for (int i = 0; i < items.size(); i++) {
//                JSONObject temp = (JSONObject) items.get(i);
//            }
            
            JSONObject temp = (JSONObject) items.get(0);
            jsonPrintString = temp.get("itemName").toString();
//             jsonPrintString = items.get(0).toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonPrintString;
    }
}
