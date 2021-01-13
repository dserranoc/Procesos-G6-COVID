package com.gsix.covid.ui.lang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.Fragment;

import com.gsix.covid.R;
import com.orhanobut.hawk.Hawk;

public class LangFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View root = inflater.inflate(R.layout.fragment_lang, container, false);
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(true) {
            final Button button = this.getActivity().findViewById(R.id.spanish_lang);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Hawk.put("lang", "es");
                    restartActivity(getActivity());
                }
            });
        }
        if(true) {
            final Button button = this.getActivity().findViewById(R.id.english_lang);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Hawk.put("lang", "en");
                    restartActivity(getActivity());
                }
            });
        }
        if(true) {
            final Button button = this.getActivity().findViewById(R.id.french_lang);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Hawk.put("lang", "fr");
                    restartActivity(getActivity());
                }
            });
        }
        if(true) {
            final Button button = this.getActivity().findViewById(R.id.deustch_lang);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Hawk.put("lang", "de");
                    restartActivity(getActivity());
                }
            });
        }
        if(true) {
            final Button button = this.getActivity().findViewById(R.id.japanese_lang);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Hawk.put("lang", "jp");
                    restartActivity(getActivity());
                }
            });
        }
        if(true) {
            final Button button = this.getActivity().findViewById(R.id.portuguese_lang);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Hawk.put("lang", "pg");
                    restartActivity(getActivity());
                }
            });
        }
    }


    public static void restartActivity(Activity activity){
        if (Build.VERSION.SDK_INT >= 11) {
            activity.recreate();
        } else {
            activity.finish();
            activity.startActivity(activity.getIntent());
        }
    }
}