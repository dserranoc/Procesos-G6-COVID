package com.gsix.covid.application.android.task;

import com.gsix.covid.application.service.cases.ranking_covid_data.GetCovidDataRankingService;
import com.gsix.covid.application.service.cases.ranking_covid_data.GetCovidDataRankingServiceImpl;
import com.gsix.covid.domain.CovidData;

import java.util.List;
import java.util.concurrent.Callable;

public class GetCovidDataRankingTask implements Callable<List<CovidData>> {

    private final GetCovidDataRankingService service;

    public GetCovidDataRankingTask() {
        this.service = new GetCovidDataRankingServiceImpl();
    }

    @Override
    public List<CovidData> call() {
        return service.getCovidRankingData();
    }

}
