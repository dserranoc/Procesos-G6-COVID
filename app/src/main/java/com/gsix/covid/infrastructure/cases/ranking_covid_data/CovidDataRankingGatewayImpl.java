package com.gsix.covid.infrastructure.cases.ranking_covid_data;

import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.cases.CovidDataNotFetchedException;
import com.gsix.covid.infrastructure.json.UrlJsonFetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CovidDataRankingGatewayImpl implements CovidDataRankingGateway {

    private static final String REQUEST_URL = "https://disease.sh/v3/covid-19/countries?sort=cases&allowNull=false";

    private final UrlJsonFetcher jsonFetcher;

    public CovidDataRankingGatewayImpl() {
        this.jsonFetcher = new UrlJsonFetcher();
    }

    public List<CovidData> fetchCovidDataRanking() throws CovidDataNotFetchedException {
        List<CovidData> covidDataGroup = new ArrayList<>();
        try {
            JSONArray array = jsonFetcher.fetchArrayFromUrl(REQUEST_URL);
            for (int counter = 0; counter < array.length(); counter++) {
                JSONObject json = array.getJSONObject(counter);
                covidDataGroup.add(
                    new CovidData(
                        json.getString("country"),
                        json.getInt("critical"),
                        json.getInt("active"),
                        json.getInt("recovered"),
                        json.getInt("cases"),
                        json.getInt("todayCases"),
                        json.getInt("deaths"),
                        json.getInt("population"),
                        new Date(json.getLong("updated"))
                    )
                );
            }
            return covidDataGroup;
        } catch (Exception exception) {
            throw new CovidDataNotFetchedException(exception);
        }
    }

}
