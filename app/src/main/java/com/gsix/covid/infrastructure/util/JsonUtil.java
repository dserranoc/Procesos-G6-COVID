package com.gsix.covid.infrastructure.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonUtil {

    private static final Charset CHARSET = Charset.forName("UTF-8");

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream input = new URL(url).openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, CHARSET));
            String jsonText = readAll(reader);
            return new JSONObject(jsonText);
        }
    }

    private static String readAll(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        int character;
        while ((character = reader.read()) != -1) {
            builder.append((char) character);
        }
        return builder.toString();
    }

}
