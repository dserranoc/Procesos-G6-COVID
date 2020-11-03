package com.gsix.covid.infrastructure.cases.ranking_covid_data;


import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.cases.CovidDataNotFetchedException;

import java.util.List;

public interface CovidDataRankingGateway {

    List<CovidData> fetchCovidDataRanking() throws CovidDataNotFetchedException;

}
