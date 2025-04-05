package com.auto.exam.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.exam.Model.Question;
import com.auto.exam.Dto.GenQuestion;
import com.auto.exam.Model.Exam;
import com.auto.exam.repo.questionRepo;
import com.auto.exam.repo.examRepo;

@Service
public class questionService {
    private final questionRepo questionRepo;
    private final examRepo examRepo;

    @Autowired
    public questionService(questionRepo questionRepo, examRepo examRepo) {
        this.questionRepo = questionRepo;
        this.examRepo = examRepo;
    }

    public List<Long> addQuestions(Map<String, Object> payload) {
        Long examId = Long.valueOf(payload.get("examId").toString());
        List<Map<String, Object>> questions = (List<Map<String, Object>>) payload.get("questions");

        // Retrieve the Exam entity
        Exam exam = examRepo.findExamByExamId(examId);
        if (exam == null) {
            throw new IllegalArgumentException("Invalid Exam ID");
        }
        // Map the questions to Question entities and save them
        List<Question> questionEntities = questions.stream().map(questionData -> {
            Question question = new Question();
            question.setQuestion(questionData.get("question").toString());
            question.setMarks(Integer.valueOf(questionData.get("marks").toString()));
            question.setAnswer(questionData.get("answer").toString());
            question.setExam(exam);
            return question;
        }).collect(Collectors.toList());

        // Save all questions to the database
        List<Question> savedQuestions = questionRepo.saveAll(questionEntities);

        // Return the IDs of the saved questions
        return savedQuestions.stream().map(Question::getQuestionId).collect(Collectors.toList());
    }

    public List<GenQuestion> generateQuestions(Map<String, Object> payload) {

        
        
        String prompt = payload.get("prompt").toString();
        return null;
    }

    public List<Question> getAll() {
        return questionRepo.findAll();
    }
}
