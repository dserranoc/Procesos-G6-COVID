package application.service;

import domain.CovidData;
import infrastructure.CovidDataGateway;
import infrastructure.CovidDataGatewayImpl;

public class GetCovidDataServiceImpl implements GetCovidDataService {

    private CovidDataGateway gateway;

    public GetCovidDataServiceImpl() {
        this.gateway = new CovidDataGatewayImpl();
    }

    public CovidData getCovidData() {
        return gateway.fetchCovidData();
    }

}
