package com.gsix.covid.infrastructure.cases.get_questions;

import com.gsix.covid.domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class QuestionGatewayImpl implements QuestionGateway {

    private List<Question> questions;

    public QuestionGatewayImpl() {
        this.questions = new ArrayList<Question>();
    }


    public Question getById(UUID questionId) {
        for (Question question : this.questions) {
            if (question.getId().equals(questionId)) {
                return question;
            }
        }
        return null;
    }


    public List<Question> getAll() {
        return this.questions;
    }


    public void addQuestion(String question, List<String> answers, String correctAnswer) {
        questions.add(new Question(question, answers, correctAnswer));
    }
}
