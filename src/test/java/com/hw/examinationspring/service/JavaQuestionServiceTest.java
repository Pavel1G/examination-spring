package com.hw.examinationspring.service;

import com.hw.examinationspring.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    Collection<Question> actualQuestionCollection = new HashSet<>();

    private Question question;
    private Question question1;
    private Question question2;
    private Question question3;

    @BeforeEach
    public void setUp() {
        String questionString = "questionString";
        String answerString = "answerString";
        question = new Question(questionString, answerString);

        question1 = new Question("questionString1", "answerString1");
        question2 = new Question("questionString2", "answerString2");
        question3 = new Question("questionString3", "answerString3");

        javaQuestionService.add(question);
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);
    }

    @Test
    void shouldAddingQuestionWithParamStrings() {
        javaQuestionService.add("questionString5", "answerString5");
        assertEquals(5, javaQuestionService.getAll().size());
    }

    @Test
    void shouldAddingQuestion() {
        javaQuestionService.add(question);
        javaQuestionService.add(question1);
        assertEquals(4, javaQuestionService.getAll().size());
    }

    @Test
    void shouldRemoveQuestionFromSetQuestions() {
        javaQuestionService.remove(question1);
        assertEquals(3, javaQuestionService.getAll().size());
    }
}
