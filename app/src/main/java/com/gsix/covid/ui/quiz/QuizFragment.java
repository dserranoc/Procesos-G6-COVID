package com.gsix.covid.ui.quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gsix.covid.R;
import com.gsix.covid.domain.Question;
import com.gsix.covid.infrastructure.cases.get_questions.QuestionGatewayImpl;

public class QuizFragment extends Fragment {

    public int computeScore(Question question, )
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);

        QuestionGatewayImpl questionGateway = new QuestionGatewayImpl();



        return root;
    }

}