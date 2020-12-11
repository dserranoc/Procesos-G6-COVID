package com.gsix.covid.ui.scores;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gsix.covid.R;
import com.gsix.covid.infrastructure.cases.get_questions.QuizSQLiteHelper;
import com.orhanobut.hawk.Hawk;

public class ScoresFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View root = inflater.inflate(R.layout.scores_fragment, container, false);
        return root;
    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(100,50,10,10);
        LinearLayout lLayout = (LinearLayout) this.getActivity().findViewById(R.id.scores_layout);
        QuizSQLiteHelper dbHelper = new QuizSQLiteHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        for(Pair<String, String> pair : dbHelper.getAll(db)) {
            TextView text = new TextView(getContext());
            text.setLayoutParams(params);
            text.setText(pair.second + "/8      " + pair.first);
            text.setId(pair.hashCode());
            lLayout.addView(text);
        }

    }

}