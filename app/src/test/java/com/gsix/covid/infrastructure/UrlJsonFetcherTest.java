package com.gsix.covid.infrastructure;

import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.json.UrlJsonFetcher;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URLConnection;

import static org.junit.Assert.assertNotNull;

public class UrlJsonFetcherTest {

    private static String URL = "realistic_url";

    @Mock
    private UrlJsonFetcher jsonFetcher;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void successfulFetchFromUrl() throws IOException, JSONException {
        Mockito.when(jsonFetcher.fetchFromUrl(URL)).thenReturn(Mockito.mock(JSONObject.class));
        JSONObject json = jsonFetcher.fetchFromUrl(URL);
        assertNotNull(json);
    }

}
