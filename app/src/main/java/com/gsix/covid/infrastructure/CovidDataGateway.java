package infrastructure;

import domain.CovidData;

public interface CovidDataGateway {

    CovidData fetchCovidData() throws CovidDataNotFetchedException;

}
