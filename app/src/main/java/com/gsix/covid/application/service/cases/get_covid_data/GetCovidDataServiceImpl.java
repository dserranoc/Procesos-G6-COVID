package com.gsix.covid.application.service.cases.get_covid_data;

import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.cases.get_covid_data.CovidDataGateway;
import com.gsix.covid.infrastructure.cases.get_covid_data.CovidDataGatewayImpl;

public class GetCovidDataServiceImpl implements GetCovidDataService {

    private final CovidDataGateway gateway;

    public GetCovidDataServiceImpl() {
        this.gateway = new CovidDataGatewayImpl();
    }

    public CovidData getCovidData() {
        return gateway.fetchCovidData();
    }

}
