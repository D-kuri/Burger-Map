package com.burger.domain;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class GeoCoder {
    private static final String API_KEY = "fbbdb9c3c1c0626801bbf5ffa4ee1aa8";
    private static final String GEO_CODER_URL = "https://dapi.kakao.com/v2/local/search/address.json?query=";
    private static final String CHARSET = "UTF-8";

    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }


    private GeoCoder(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static GeoCoder of(String fullAddress)  {
        ObjectMapper objectMapper = new ObjectMapper(); // can reuse, share globally

        String addressInfo = getKakaoApiFromAddress(fullAddress);

        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, false);
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(addressInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode address = rootNode.get("documents").get(0);
        String latitude = address.get("x").asText();
        String longitude = address.get("y").asText();


        return new GeoCoder(latitude, longitude);
    }

    public static String getKakaoApiFromAddress(String fullAddress) {
        String jsonString = null;

        try {
            fullAddress = URLEncoder.encode(fullAddress, CHARSET);

            String addr = GEO_CODER_URL + fullAddress;

            URL url = new URL(addr);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

            jsonString = getJsonString(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;

    }

    private static String getJsonString(InputStream addressInfo) throws IOException {
        BufferedReader rd = null;
        rd = new BufferedReader(new InputStreamReader(addressInfo, CHARSET));
        StringBuffer docJson = new StringBuffer();

        String line;
        while ((line=rd.readLine()) != null) {
            docJson.append(line);
        }

        rd.close();

        return docJson.toString();
    }
}
