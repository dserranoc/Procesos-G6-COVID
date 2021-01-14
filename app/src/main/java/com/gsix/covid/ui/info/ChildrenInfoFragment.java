package com.gsix.covid.ui.info;

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

public class ChildrenInfoFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_children_info, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        TextView toolbarTitle = getActivity().findViewById(R.id.toolbar_title);

        toolbarTitle.setText(navController.getCurrentDestination().getLabel());
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

    }
}