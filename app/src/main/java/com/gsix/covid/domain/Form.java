package com.gsix.covid.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Form {

    // QuestionRepository repository = ....
        /*

        #### AÃ±adir una respuesta a la pregunta 1:


        List<Question> questions = repository.findAll();
        Form form = new Form(questions);

        #### Al darle click a una respuesta

        String questionId = ...;
        String proposedAnswer = ...;

        form.addProposedAnswer(UUID.fromString(questionId), proposedAnswer);

        #### Obtener resultados

        form.computeResult(); <Question,Boolean>

         */

    private final UUID id;
    private final List<Question> questions;
    private final Map<UUID, String> questionIdToProposedAnswer;

    public Form(List<Question> questions) {
        this.id = UUID.randomUUID();
        this.questions = questions;
        this.questionIdToProposedAnswer = new HashMap<>();
    }

    public UUID getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addProposedAnswer(UUID questionId, String proposedAnswer) {
        questionIdToProposedAnswer.put(questionId, proposedAnswer);
    }

    public Map<Question, Boolean> computeResult() {
        Map<Question, Boolean> correctionGroup = new HashMap<>();
        for(Question question : questions) {
            if(questionIdToProposedAnswer.containsKey(question.getId())) {
                String proposedAnswer = questionIdToProposedAnswer.get(question.getId());
                boolean answerCorrect = question.getCorrectAnswer().equals(proposedAnswer);
                correctionGroup.put(question, answerCorrect);
            } else {
                correctionGroup.put(question, false);
            }
        }
        return correctionGroup;
    }

    public int computePoints() {
        int total = questions.size();
        // Compute mean...
        return 0;
    }

}