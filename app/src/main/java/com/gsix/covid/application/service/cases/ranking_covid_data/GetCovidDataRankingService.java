package com.gsix.covid.application.service.cases.ranking_covid_data;

import com.gsix.covid.domain.CovidData;

import java.util.List;

public interface GetCovidDataRankingService {

    List<CovidData> getCovidRankingData();

}
