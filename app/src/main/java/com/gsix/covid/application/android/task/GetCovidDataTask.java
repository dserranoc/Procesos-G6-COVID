package com.gsix.covid.application.android.task;

import android.os.AsyncTask;

import com.gsix.covid.application.service.GetCovidDataService;
import com.gsix.covid.application.service.GetCovidDataServiceImpl;
import com.gsix.covid.domain.CovidData;

public class GetCovidDataTask extends AsyncTask<Void, Integer, CovidData> {

    private GetCovidDataService getCovidDataService;

    public GetCovidDataTask() {
        this.getCovidDataService = new GetCovidDataServiceImpl();
    }

    @Override
    protected CovidData doInBackground(Void... voids) {
        return getCovidDataService.getCovidData();
    }

}
