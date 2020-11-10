package com.gsix.covid.infrastructure.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class UrlJsonFetcher {

    private static final Charset CHARSET = Charset.forName("UTF-8");

    public JSONObject fetchObjectFromUrl(String url) throws Exception {
        return new JSONObject(readJsonToStringFromUrl(url));
    }

    public JSONArray fetchArrayFromUrl(String url) throws Exception {
        return new JSONArray(readJsonToStringFromUrl(url));
    }

    private String readJsonToStringFromUrl(String url) throws Exception {
        try (InputStream input = new URL(url).openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, CHARSET));
            return readString(reader);
        }
    }

    private String readString(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        int character;
        while ((character = reader.read()) != -1) {
            builder.append((char) character);
        }
        return builder.toString();
    }

}
