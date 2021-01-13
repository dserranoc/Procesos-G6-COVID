package com.gsix.covid.ui.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.gsix.covid.R;
import com.gsix.covid.application.android.task.GetCovidDataTask;
import com.gsix.covid.infrastructure.runner.TaskRunner;

import java.text.SimpleDateFormat;

public class TestFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        TextView toolbarTitle = getActivity().findViewById(R.id.toolbar_title);

        toolbarTitle.setText(navController.getCurrentDestination().getLabel());
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ;
    }



}