package com.gsix.covid.application.android.task;

import com.gsix.covid.application.service.GetCovidDataService;
import com.gsix.covid.application.service.GetCovidDataServiceImpl;
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
