package com.gsix.covid.domain;

import java.util.List;
import java.util.UUID;

public class Question {

    private final UUID id;
    private final String question;
    private final List<String> possibleAnswers;
    private final String correctAnswer;

    public Question(String question, List<String> possibleAnswers, String correctAnswer) {
        this.id = UUID.randomUUID();
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }

    public UUID getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Boolean isCorrectAnswer(String answer) {
        return answer.equals(this.correctAnswer);
    }

}
