package com.gsix.covid.application.service;

import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.CovidDataGateway;
import com.gsix.covid.infrastructure.CovidDataGatewayImpl;

public class GetCovidDataServiceImpl implements GetCovidDataService {

    private CovidDataGateway gateway;

    public GetCovidDataServiceImpl() {
        this.gateway = new CovidDataGatewayImpl();
    }

    public CovidData getCovidData() {
        return gateway.fetchCovidData();
    }

}
