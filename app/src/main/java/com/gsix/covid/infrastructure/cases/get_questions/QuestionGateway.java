package com.gsix.covid.infrastructure.cases.get_questions;
import com.gsix.covid.domain.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionGateway {
    Question getById(UUID questionId);
    List<Question> getAll();
    Question addQuestion(String question, List<String> answers, String correctAnswer);
}
