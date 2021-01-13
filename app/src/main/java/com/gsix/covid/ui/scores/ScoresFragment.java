package com.gsix.covid.ui.scores;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.gsix.covid.R;
import com.gsix.covid.infrastructure.cases.get_questions.QuizSQLiteHelper;

import java.util.List;

public class ScoresFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_scores, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        TextView toolbarTitle = getActivity().findViewById(R.id.toolbar_title);

        toolbarTitle.setText(navController.getCurrentDestination().getLabel());
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        QuizSQLiteHelper dbHelper = new QuizSQLiteHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Pair<String, String>> scores = dbHelper.getAll(db);
        LinearLayout lLayout = (LinearLayout) this.getActivity().findViewById(R.id.scores_layout);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 50, 50, 50);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params2.setMargins(50, 20, 20, 20);

        for (Pair<String, String> pair : scores) {
            CardView card = new CardView(getContext());

            card.setCardBackgroundColor(getResources().getColor(R.color.design_default_color_on_primary));
//            card.setBackground(getResources().getDrawable(R.drawable.gradientcards));
            card.setElevation(10);
            card.setRadius(20);
//            if (pair.equals(scores.get(0))){
//                params.setMargins(50,0,50,20);
//            }

            card.setLayoutParams(params);

            TextView text = new TextView(getContext());
            String icon = (Integer.parseInt(pair.second) >= 8 / 2) ? "✅" : "❌";
            text.setText(pair.second + "/8      " + pair.first + icon);
            text.setTextSize(16);
            text.setId(pair.hashCode());
            text.setLayoutParams(params2);
            card.addView(text);
            lLayout.addView(card);
        }
    }


}