package com.gsix.covid.infrastructure.cases.get_questions;

import com.gsix.covid.domain.Question;

import java.util.List;
import java.util.UUID;



public class QuestionGatewayImpl implements QuestionGateway {

    private List<Question> questions;
    @Override
    public Question getById(UUID questionId) {
        for (Question question: questions) {
            if (question.getId().equals(questionId)) {
                return question;
            }
        }
        return null;
    }

    @Override
    public List<Question> getAll() {
        return this.questions;
    }

    @Override
    public Question addQuestion(String question, List<String> answers, String correctAnswer) {
        return new Question(question, answers, correctAnswer);
    }
}
