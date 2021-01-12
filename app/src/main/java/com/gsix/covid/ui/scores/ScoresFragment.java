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
import androidx.cardview.widget.CardView;
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
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(50,50,50,25);
        LinearLayout lLayout = (LinearLayout) this.getActivity().findViewById(R.id.scores_layout);
        QuizSQLiteHelper dbHelper = new QuizSQLiteHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params2.setMargins(50,20,20,20);
        for(Pair<String, String> pair : dbHelper.getAll(db)) {
            CardView card = new CardView(getContext());
            card.setRadius(50);
            card.setCardBackgroundColor(getResources().getColor(R.color.design_default_color_on_primary));
            card.setElevation(10);
            card.setLayoutParams(params);

            TextView text = new TextView(getContext());
            String icon = (Integer.parseInt(pair.second) >= 8/2)?"✅":"❌";
            text.setText(pair.second + "/8      " + pair.first + icon);
            text.setId(pair.hashCode());
            text.setLayoutParams(params2);
            card.addView(text);
            lLayout.addView(card);
        }

    }

}