package com.gsix.covid.ui.quiz;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gsix.covid.R;
import com.gsix.covid.domain.Question;
import com.gsix.covid.domain.contracts.ScoreContract;
import com.gsix.covid.infrastructure.cases.get_questions.QuestionGatewayImpl;
import com.gsix.covid.infrastructure.cases.get_questions.QuizSQLiteHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class QuizFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        QuestionGatewayImpl questionGateway = new QuestionGatewayImpl();

        String q1 = (String) getString(R.string.quiz_q1);
        String q1A1 = (String) getString(R.string.quiz_yes);
        String q1A2 = (String) getString(R.string.quiz_no);

        String q2 = (String) getString(R.string.quiz_q2);
        String q2A1 = (String) getString(R.string.quiz_q2_a1);
        String q2A2 = (String) getString(R.string.quiz_q2_a2);
        String q2A3 = (String) getString(R.string.quiz_q2_a3);
        String q2A4 = (String) getString(R.string.quiz_q2_a4);

        String q3 = (String) getString(R.string.quiz_q3);
        String q3A1 = (String) getString(R.string.quiz_q3_a1);
        String q3A2 = (String) getString(R.string.quiz_q3_a2);
        String q3A3 = (String) getString(R.string.quiz_q3_a3);
        String q3A4 = (String) getString(R.string.quiz_q3_a4);

        String q4 = (String) getString(R.string.quiz_q4);
        String q4A1 = (String) getString(R.string.quiz_q4_a1);
        String q4A2 = (String) getString(R.string.quiz_q4_a2);
        String q4A3 = (String) getString(R.string.quiz_q4_a3);
        String q4A4 = (String) getString(R.string.quiz_q4_a4);

        String q5 = (String) getString(R.string.quiz_q5);
        String q5A1 = (String) getString(R.string.quiz_q5_a1);
        String q5A2 = (String) getString(R.string.quiz_q5_a2);
        String q5A3 = (String) getString(R.string.quiz_q5_a3);

        String q6 = (String) getString(R.string.quiz_q6);
        String q6A1 = (String) getString(R.string.quiz_yes);
        String q6A2 = (String) getString(R.string.quiz_no);

        String q7 = (String) getString(R.string.quiz_q7);
        String q7A1 = (String) getString(R.string.quiz_yes);
        String q7A2 = (String) getString(R.string.quiz_no);

        String q8 = (String) getString(R.string.quiz_q8);
        String q8A1 = (String) getString(R.string.quiz_yes);
        String q8A2 = (String) getString(R.string.quiz_no);

        List<RadioGroup>  radioGroups = new ArrayList<RadioGroup>();
        RadioGroup q1Rg = (RadioGroup) root.findViewById(R.id.quiz_q1_rg);
        questionGateway.addQuestion(q1, Arrays.asList(q1A1, q1A2), q1A1);
        radioGroups.add(q1Rg);

        RadioGroup q2Rg = (RadioGroup) root.findViewById(R.id.quiz_q2_rg);
        questionGateway.addQuestion(q2, Arrays.asList(q2A1, q2A2, q2A3, q2A4), q2A3);
        radioGroups.add(q2Rg);

        RadioGroup q3Rg = (RadioGroup) root.findViewById(R.id.quiz_q3_rg);
        questionGateway.addQuestion(q3, Arrays.asList(q3A1, q3A2, q3A3, q3A4), q3A1);
        radioGroups.add(q3Rg);

        RadioGroup q4Rg = (RadioGroup) root.findViewById(R.id.quiz_q4_rg);
        questionGateway.addQuestion(q4, Arrays.asList(q4A1, q4A2, q4A3, q4A4), q4A4);
        radioGroups.add(q4Rg);

        RadioGroup q5Rg = (RadioGroup) root.findViewById(R.id.quiz_q5_rg);
        questionGateway.addQuestion(q5, Arrays.asList(q5A1, q5A2, q5A3), q5A2);
        radioGroups.add(q5Rg);

        RadioGroup q6Rg = (RadioGroup) root.findViewById(R.id.quiz_q6_rg);
        questionGateway.addQuestion(q6, Arrays.asList(q6A1, q6A2), q6A1);
        radioGroups.add(q6Rg);

        RadioGroup q7Rg = (RadioGroup) root.findViewById(R.id.quiz_q7_rg);
        questionGateway.addQuestion(q7, Arrays.asList(q7A1, q7A2), q7A1);
        radioGroups.add(q7Rg);

        RadioGroup q8Rg = (RadioGroup) root.findViewById(R.id.quiz_q8_rg);
        questionGateway.addQuestion(q8, Arrays.asList(q8A1, q8A2), q8A1);
        radioGroups.add(q8Rg);

        List <Question> questionsList = questionGateway.getAll();

        Button submitBtn = (Button) root.findViewById(R.id.quiz_send_btn);



        submitBtn.setOnClickListener(v -> {
            int score = 0;
            TextView scoreText = (TextView) root.findViewById(R.id.score);

            for (int i=0;i<8;i++){
                RadioGroup curRg = radioGroups.get(i);
                if (curRg.getCheckedRadioButtonId() == -1) {
                    scoreText.setText(R.string.quiz_error);
                    return;
                }
                AppCompatRadioButton checkedButton = (AppCompatRadioButton) root.findViewById(curRg.getCheckedRadioButtonId());

                Question question = (Question)questionsList.get(i);
                if (question.isCorrectAnswer(checkedButton.getText().toString())) {
                    score++;
                }

            }
            scoreText.setText(getString(R.string.quiz_score, score));

            QuizSQLiteHelper dbHelper = new QuizSQLiteHelper(getContext());
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ScoreContract.ScoreEntry.COLUMN_NAME, "CovidInfo");
            SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
            values.put(ScoreContract.ScoreEntry.COLUMN_DATE, dt.format(new Date()));
            values.put(ScoreContract.ScoreEntry.COLUMN_SCORE, score);
            long newRowId = db.insert(ScoreContract.ScoreEntry.TABLE_NAME, null, values);


            submitBtn.setEnabled(false);

        });


        return root;
    }

}