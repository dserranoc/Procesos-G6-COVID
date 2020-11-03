package com.gsix.covid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gsix.covid.application.android.task.GetCovidDataTask;
import com.gsix.covid.infrastructure.runner.TaskRunner;

import java.text.SimpleDateFormat;

public class CovidDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_data);
        refreshData();
        // switchToChosenLang()
    }

    public void refreshData() {
        try {
            new TaskRunner().executeAsync(new GetCovidDataTask(), (data) -> {
                TextView country = (TextView) findViewById(R.id.country);
                country.setText(data.getCountry());

                TextView activeCases = findViewById(R.id.activeCases);
                activeCases.setText(String.valueOf(data.getActiveCases()));

                TextView criticalCases = findViewById(R.id.criticalCases);
                criticalCases.setText(String.valueOf(data.getCriticalCases()));

                TextView recovered = findViewById(R.id.recovered);
                recovered.setText(String.valueOf(data.getRecoveredCases()));

                TextView totalCases = findViewById(R.id.totalCases);
                totalCases.setText(String.valueOf(data.getTotalCases()));

                TextView todayCases = findViewById(R.id.todayCases);
                todayCases.setText(String.valueOf(data.getTodayCases()));

                TextView deceases = findViewById(R.id.deceases);
                deceases.setText(String.valueOf(data.getTotalDeceases()));

                TextView population = findViewById(R.id.population);
                population.setText(String.valueOf(data.getPopulation()));

                TextView lastUpdated = findViewById(R.id.lastUpdated);
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM, YYYY");
                lastUpdated.setText(formatter.format(data.getLastUpdated()));
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}