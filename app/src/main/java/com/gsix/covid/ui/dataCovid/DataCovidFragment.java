package com.gsix.covid.ui.dataCovid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.gsix.covid.R;
import com.gsix.covid.application.service.GetCovidDataServiceImpl;

public class DataCovidFragment extends Fragment {

    private DataCovidViewModel dataCovidViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dataCovidViewModel =
                new ViewModelProvider(this).get(DataCovidViewModel.class);


        View root = inflater.inflate(R.layout.fragment_datacovid, container, false);
        GetCovidDataServiceImpl service = new GetCovidDataServiceImpl();
//      TextViews
        TextView countryTextView = root.findViewById(R.id.country_textView);
        TextView activeCasesTextView = root.findViewById(R.id.activeCases_textView);
        TextView criticalCasesTextView = root.findViewById(R.id.criticalCases_textView);
        TextView recoveredCasesTextView = root.findViewById(R.id.recoveredCases_textView);
        TextView totalCasesTextView = root.findViewById(R.id.totalCases_textView);
        TextView todayCasesTextView = root.findViewById(R.id.todayCases_textView);

        countryTextView.setText(countryTextView.getText() + " " + service.getCovidData().getCountry());
        activeCasesTextView.setText(activeCasesTextView.getText() + " " + service.getCovidData().getActiveCases());
        criticalCasesTextView.setText(criticalCasesTextView.getText() + " " + service.getCovidData().getCriticalCases());
        recoveredCasesTextView.setText(recoveredCasesTextView.getText() + " " + service.getCovidData().getRecoveredCases());
        totalCasesTextView.setText(totalCasesTextView.getText() + " " + service.getCovidData().getTotalCases());
        todayCasesTextView.setText(todayCasesTextView.getText() + " " + service.getCovidData().getTodayCases());


        return root;
    }
}