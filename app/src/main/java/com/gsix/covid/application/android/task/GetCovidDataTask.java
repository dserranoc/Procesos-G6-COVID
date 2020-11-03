package com.gsix.covid.application.android.task;

import com.gsix.covid.application.service.cases.get_covid_data.GetCovidDataService;
import com.gsix.covid.application.service.cases.get_covid_data.GetCovidDataServiceImpl;
import com.gsix.covid.domain.CovidData;

import java.util.concurrent.Callable;

public class GetCovidDataTask implements Callable<CovidData> {

    private final GetCovidDataService getCovidDataService;

    public GetCovidDataTask() {
        this.getCovidDataService = new GetCovidDataServiceImpl();
    }

    @Override
    public CovidData call() {
        return getCovidDataService.getCovidData();
    }

}
