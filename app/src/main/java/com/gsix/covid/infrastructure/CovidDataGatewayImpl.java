package infrastructure;

import domain.CovidData;
import infrastructure.util.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CovidDataGatewayImpl implements CovidDataGateway {

    private static final String REQUEST_URL = "https://disease.sh/v3/covid-19/countries/spain";

    public CovidData fetchCovidData() throws CovidDataNotFetchedException {
        try {
            JSONObject json = JsonUtil.readJsonFromUrl(REQUEST_URL);
            return new CovidData(
                json.getString("country"),
                json.getInt("critical"),
                json.getInt("active"),
                json.getInt("recovered"),
                json.getInt("cases"),
                json.getInt("todayCases"),
                json.getInt("deaths"),
                json.getInt("population"),
                new Date(json.getLong("updated"))
            );
        } catch (Exception exception) {
            throw new CovidDataNotFetchedException("Could not fetch covid data", exception);
        }
    }

}
