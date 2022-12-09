package com.hw.examinationspring.service;

import com.hw.examinationspring.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount > questionService.getAll().size()){
            throw new IllegalArgumentException("Слишком большое количество запросов.");
        }
        Collection<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
