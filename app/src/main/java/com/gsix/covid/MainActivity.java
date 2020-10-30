package com.gsix.covid;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.gsix.covid.application.android.task.GetCovidDataTask;
import com.gsix.covid.application.service.GetCovidDataServiceImpl;
import com.gsix.covid.domain.CovidData;
import com.gsix.covid.infrastructure.CovidDataGatewayImpl;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshData();
    }

    public void refreshData() {
        try {
            CovidData data = new GetCovidDataTask().execute().get();

            TextView country = (TextView) findViewById(R.id.country);
            country.setText(data.getCountry());

            TextView activeCases = (TextView) findViewById(R.id.activeCases);
            activeCases.setText(String.valueOf(data.getActiveCases()));

            TextView criticalCases = (TextView) findViewById(R.id.criticalCases);
            criticalCases.setText(String.valueOf(data.getCriticalCases()));

            TextView recovered = (TextView) findViewById(R.id.recovered);
            recovered.setText(String.valueOf(data.getRecoveredCases()));

            TextView totalCases = (TextView) findViewById(R.id.totalCases);
            totalCases.setText(String.valueOf(data.getTotalCases()));

            TextView todayCases = (TextView) findViewById(R.id.todayCases);
            todayCases.setText(String.valueOf(data.getTodayCases()));

            TextView deceases = (TextView) findViewById(R.id.deceases);
            deceases.setText(String.valueOf(data.getTotalDeceases()));

            TextView population = (TextView) findViewById(R.id.population);
            population.setText(String.valueOf(data.getPopulation()));

            TextView lastUpdated = (TextView) findViewById(R.id.lastUpdated);
            SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM, YYYY");
            lastUpdated.setText(formatter.format(data.getLastUpdated()));

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

}