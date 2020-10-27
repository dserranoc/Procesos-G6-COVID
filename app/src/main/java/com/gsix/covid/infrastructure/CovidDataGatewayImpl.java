package infrastructure;

import domain.CovidData;
import infrastructure.util.JsonUtil;
import org.json.JSONObject;

import java.util.Date;

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
