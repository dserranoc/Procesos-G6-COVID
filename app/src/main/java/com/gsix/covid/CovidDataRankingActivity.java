package com.gsix.covid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gsix.covid.application.android.task.GetCovidDataRankingTask;
import com.gsix.covid.application.android.task.GetCovidDataTask;
import com.gsix.covid.infrastructure.runner.TaskRunner;

import java.text.SimpleDateFormat;

public class CovidDataRankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_data_ranking);
        refreshData();
        // switchToChosenLang()
    }

    public void refreshData() {
        try {
            new TaskRunner().executeAsync(new GetCovidDataRankingTask(), (data) -> {

                TextView first_country = findViewById(R.id.first_country);
                first_country.setText(data.get(0).getCountry());

                TextView first_amount = findViewById(R.id.first_amount);
                first_amount.setText(String.valueOf(data.get(0).getTotalCases()));

                TextView second_country = findViewById(R.id.second_country);
                second_country.setText(data.get(1).getCountry());

                TextView second_amount = findViewById(R.id.second_amount);
                second_amount.setText(String.valueOf(data.get(1).getTotalCases()));

                TextView third_country = findViewById(R.id.third_country);
                third_country.setText(data.get(2).getCountry());

                TextView third_amount = findViewById(R.id.third_amount);
                third_amount.setText(String.valueOf(data.get(2).getTotalCases()));

                TextView fourth_country = findViewById(R.id.fourth_country);
                fourth_country.setText(data.get(3).getCountry());

                TextView fourth_amount = findViewById(R.id.fourth_amount);
                fourth_amount.setText(String.valueOf(data.get(3).getTotalCases()));

                TextView fifth_country = findViewById(R.id.fifth_country);
                fifth_country.setText(data.get(4).getCountry());

                TextView fifth_amount = findViewById(R.id.fifth_amount);
                fifth_amount.setText(String.valueOf(data.get(4).getTotalCases()));

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