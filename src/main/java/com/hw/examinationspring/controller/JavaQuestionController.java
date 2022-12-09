package com.hw.examinationspring.controller;

import com.hw.examinationspring.model.Question;
import com.hw.examinationspring.service.JavaQuestionService;
import com.hw.examinationspring.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/exam/java")
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/exam/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/exam/java/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question temp = new Question(question, answer);
        return javaQuestionService.remove(temp);
    }
}
