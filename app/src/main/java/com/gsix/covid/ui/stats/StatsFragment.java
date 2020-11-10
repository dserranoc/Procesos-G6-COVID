package com.gsix.covid.ui.stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.gsix.covid.R;
import com.gsix.covid.application.android.task.GetCovidDataTask;
import com.gsix.covid.infrastructure.runner.TaskRunner;

import java.text.SimpleDateFormat;

public class StatsFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stats, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        statsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        refreshData();
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        refreshData();
    }

    public void refreshData() {
        try {
            new TaskRunner().executeAsync(new GetCovidDataTask(), (data) -> {
                TextView country = (TextView) getView().findViewById(R.id.country);
                country.setText(data.getCountry());

                TextView activeCases = getView().findViewById(R.id.activeCases);
                activeCases.setText(String.valueOf(data.getActiveCases()));

                TextView criticalCases = getView().findViewById(R.id.criticalCases);
                criticalCases.setText(String.valueOf(data.getCriticalCases()));

                TextView recovered = getView().findViewById(R.id.recovered);
                recovered.setText(String.valueOf(data.getRecoveredCases()));

                TextView totalCases = getView().findViewById(R.id.totalCases);
                totalCases.setText(String.valueOf(data.getTotalCases()));

                TextView todayCases = getView().findViewById(R.id.todayCases);
                todayCases.setText(String.valueOf(data.getTodayCases()));

                TextView deceases = getView().findViewById(R.id.deceases);
                deceases.setText(String.valueOf(data.getTotalDeceases()));

                TextView population = getView().findViewById(R.id.population);
                population.setText(String.valueOf(data.getPopulation()));

                TextView lastUpdated = getView().findViewById(R.id.lastUpdated);
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM, YYYY");
                lastUpdated.setText(formatter.format(data.getLastUpdated()));
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}