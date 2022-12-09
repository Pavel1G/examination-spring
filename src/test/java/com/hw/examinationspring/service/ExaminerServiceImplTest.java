package com.hw.examinationspring.service;

import com.hw.examinationspring.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private Set<Question> actualSetQuestions;

    @BeforeEach
    void setUp() {

        Question question = new Question("questionString", "answerString");
        Question question1 = new Question("questionString1", "answerString1");
        Question question2 = new Question("questionString2", "answerString2");
        Question question3 = new Question("questionString3", "answerString3");

        actualSetQuestions = Set.of(question, question1, question2, question3);

        Set<Question> questionsForRandom = Set.of(question, question1, question2, question3);

//        Подумать над тем, как правильно "замокать"
        when(javaQuestionService.getAll()).thenReturn(actualSetQuestions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(question, question1, question2, question3);
    }

    @Test
    void shouldCheckCountReturnerQuestions() {
        assertEquals(examinerService.getQuestions(4), actualSetQuestions);
    }
}