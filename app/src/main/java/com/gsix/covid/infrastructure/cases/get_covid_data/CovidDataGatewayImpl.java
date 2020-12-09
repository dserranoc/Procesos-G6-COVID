package com.gsix.covid.infrastructure.cases.get_covid_data;

import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.cases.CovidDataNotFetchedException;
import com.gsix.covid.infrastructure.json.UrlJsonFetcher;

import org.json.JSONObject;

import java.util.Date;

public class CovidDataGatewayImpl implements CovidDataGateway {

    private static final String REQUEST_URL = "https://disease.sh/v3/covid-19/countries/spain";

    private final UrlJsonFetcher jsonFetcher;

    public CovidDataGatewayImpl() {
        this.jsonFetcher = new UrlJsonFetcher();
    }

    public CovidData fetchCovidData() throws CovidDataNotFetchedException {
        try {
            JSONObject json = jsonFetcher.fetchObjectFromUrl(REQUEST_URL);
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
            throw new CovidDataNotFetchedException(exception);
        }
    }

}
