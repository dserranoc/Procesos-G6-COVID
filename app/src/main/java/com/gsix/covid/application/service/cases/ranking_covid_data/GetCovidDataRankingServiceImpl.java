package com.gsix.covid.application.service.cases.ranking_covid_data;

import com.gsix.covid.application.service.cases.get_covid_data.GetCovidDataService;
import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.cases.get_covid_data.CovidDataGateway;
import com.gsix.covid.infrastructure.cases.get_covid_data.CovidDataGatewayImpl;
import com.gsix.covid.infrastructure.cases.ranking_covid_data.CovidDataRankingGateway;
import com.gsix.covid.infrastructure.cases.ranking_covid_data.CovidDataRankingGatewayImpl;

import java.util.List;

public class GetCovidDataRankingServiceImpl implements GetCovidDataRankingService {

    private final CovidDataRankingGateway gateway;

    public GetCovidDataRankingServiceImpl() {
        this.gateway = new CovidDataRankingGatewayImpl();
    }

    public List<CovidData> getCovidRankingData() {
        return gateway.fetchCovidDataRanking();
    }

}
