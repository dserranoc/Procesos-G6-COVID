package com.gsix.covid.infrastructure;

import com.gsix.covid.domain.CovidData;

public interface CovidDataGateway {

    CovidData fetchCovidData() throws CovidDataNotFetchedException;

}
