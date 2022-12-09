package com.hw.examinationspring.service;

import com.hw.examinationspring.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
