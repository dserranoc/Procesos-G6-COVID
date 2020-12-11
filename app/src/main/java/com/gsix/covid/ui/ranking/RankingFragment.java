package com.gsix.covid.ui.ranking;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gsix.covid.HomeActivity;
import com.gsix.covid.R;
import com.gsix.covid.application.android.task.GetCovidDataRankingTask;
import com.gsix.covid.infrastructure.runner.TaskRunner;
import com.orhanobut.hawk.Hawk;

public class RankingFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ranking, container, false);


        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        refreshData();
    }

    public void refreshData() {
        try {
            new TaskRunner().executeAsync(new GetCovidDataRankingTask(), (data) -> {
                TextView first_country = getView().findViewById(R.id.first_country);
                first_country.setText(data.get(0).getCountry());

                TextView first_amount = getView().findViewById(R.id.first_amount);
                first_amount.setText(String.valueOf(data.get(0).getTotalCases()));

                TextView second_country = getView().findViewById(R.id.second_country);
                second_country.setText(data.get(1).getCountry());

                TextView second_amount = getView().findViewById(R.id.second_amount);
                second_amount.setText(String.valueOf(data.get(1).getTotalCases()));

                TextView third_country = getView().findViewById(R.id.third_country);
                third_country.setText(data.get(2).getCountry());

                TextView third_amount = getView().findViewById(R.id.third_amount);
                third_amount.setText(String.valueOf(data.get(2).getTotalCases()));

                TextView fourth_country = getView().findViewById(R.id.fourth_country);
                fourth_country.setText(data.get(3).getCountry());

                TextView fourth_amount = getView().findViewById(R.id.fourth_amount);
                fourth_amount.setText(String.valueOf(data.get(3).getTotalCases()));

                TextView fifth_country = getView().findViewById(R.id.fifth_country);
                fifth_country.setText(data.get(4).getCountry());

                TextView fifth_amount = getView().findViewById(R.id.fifth_amount);
                fifth_amount.setText(String.valueOf(data.get(4).getTotalCases()));

                Hawk.put("lang", "es");
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}