package com.gsix.covid.ui.scores;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        params.setMargins(50, 50, 50, 24);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params2.setMargins(70, 20, 20, 20);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params3.setMargins(470, 20, 0, 20);
        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params4.setMargins(50,50,50,60);

        for (Pair<String, String> pair : scores) {
            CardView card = new CardView(getContext());

//            card.setCardBackgroundColor(getResources().getColor(R.color.design_default_color_on_primary));

//            card.setBackground(getResources().getDrawable(R.drawable.gradientcards));
            card.setElevation(10);
            card.setRadius(20);

            TextView text = new TextView(getContext());
            TextView text2 = new TextView(getContext());
            text.setText(pair.second + "/8");
            text2.setText(pair.first);
            if (Integer.parseInt(pair.second) >= 8 / 2) {
                card.setBackground(getResources().getDrawable(R.drawable.cardpassed));
            } else {
                card.setBackground(getResources().getDrawable(R.drawable.cardfailed));
            }

            text.setTextSize(16);
            text.setId(pair.hashCode());
            text2.setTextSize(16);
            text2.setId(pair.hashCode());
            if (pair.equals(scores.get(scores.size()-1))){
                card.setLayoutParams(params4);
            } else {
                card.setLayoutParams(params);
            }

            text.setLayoutParams(params2);
            text2.setLayoutParams(params3);
            card.addView(text);
            card.addView(text2);
            lLayout.addView(card);
        }
    }


}