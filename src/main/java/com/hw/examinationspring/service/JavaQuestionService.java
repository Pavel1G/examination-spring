package com.hw.examinationspring.service;

import com.hw.examinationspring.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

// Пакет и класс, в котором хранятся сами объекты класса Employee.
// Здесь будет храниться коллекция объектов Employee, и методы работы с ними.

//Аннотация @Service - показывает что этот класс может использоваться только в единственном
// экземпляре и показывает нам, что тут хранится сервисы по обработке объектов.
@Service
public class JavaQuestionService implements QuestionService {

    final Set<Question> questionStorage = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question questionInStorage = new Question(question, answer);
        questionStorage.add(questionInStorage);
        return questionInStorage;
    }

    @Override
    public Question add(Question question) {
        questionStorage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionStorage.contains(question)) {
            questionStorage.remove(question);
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionStorage.stream()
                .collect(Collectors.toList());
    }

    @Override
    public Question getRandomQuestion() {
        int randomInt = new Random().nextInt(questionStorage.size());
        List<Question> questionList = questionStorage.stream().toList();
        return questionList.get(randomInt);
    }
}
