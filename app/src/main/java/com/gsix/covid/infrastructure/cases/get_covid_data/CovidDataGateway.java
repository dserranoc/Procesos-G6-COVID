package com.gsix.covid.infrastructure.cases.get_covid_data;

import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.cases.CovidDataNotFetchedException;

public interface CovidDataGateway {

    CovidData fetchCovidData() throws CovidDataNotFetchedException;

}
