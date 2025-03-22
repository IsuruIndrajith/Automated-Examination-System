package com.auto.exam.service;


import com.auto.exam.Dto.ExamRequest;
import com.auto.exam.Dto.MarkQuestions;
import com.auto.exam.Dto.ProvideQuestion;
import com.auto.exam.Model.*;
import com.auto.exam.repo.*;
import com.auto.exam.util.SecurityUtil;

import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class examService {
    private examRepo examRepo;
    private courseRegisterRepo courseRegisterRepo;
    private userRepo userRepo;
    private studentDetailsService studentDetailsService;
    private questionRepo questionRepo;
    private attemptRepo attemptRepo;
    private studentRepo studentRepo;
    private examanalysisRepo examanalysisRepo;
    private courseOfferingRepo courseOfferingRepo;

    private long ExamId;
  
    @Autowired
    public examService(examRepo examRepo, courseRegisterRepo courseRegisterRepo,questionRepo questionRepo,
                        userRepo userRepo,studentDetailsService studentDetailsService,attemptRepo attemptRepo,
                        studentRepo studentRepo,examanalysisRepo examanalysisRepo, courseOfferingRepo courseOfferingRepo) {
        this.examRepo=examRepo;
        this.courseRegisterRepo=courseRegisterRepo;
        this.questionRepo = questionRepo;
        this.userRepo = userRepo;
        this.studentDetailsService = studentDetailsService;
        this.attemptRepo = attemptRepo;
        this.studentRepo = studentRepo;
        this.examanalysisRepo = examanalysisRepo;
        this.courseOfferingRepo = courseOfferingRepo;
    }
    
    public List<SendingExam> getExamsUsingDateAndLecture(ExamRequest request){
        UserPrincipal userPrincipal = SecurityUtil.getAuthenticatedUser();

        Date date;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = formatter.parse(request.getDate());
        } catch (ParseException e) {
            return null;
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String user_name = userPrincipal.getUsername();
        List<Exam> exams = examRepo.findLectureExamByUser(user_name);
        List<Exam> return_exams=exams.stream().filter(exam -> exam.getStartDateTime().toString().equals(outputFormat.format(date))).toList();
        List<SendingExam> sendingExams = return_exams.stream().map(exam -> new SendingExam(exam.getExamId(), exam.getStartDateTime(), exam.getDuration(), exam.getPassingCriteria(), exam.getType(), exam.getTotalMarks(), exam.getCourseOffering().getCourse().getCourseId(), exam.getCourseOffering().getCourse().getCourseName(), exam.getCourseOffering().getCourse().getCourseCode())).collect(Collectors.toList());

        return sendingExams;
    }
    

    public List<SendingExam> getExamsUsingDateAndStudent(ExamRequest request){
        UserPrincipal userPrincipal = SecurityUtil.getAuthenticatedUser();    

        Date date;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = formatter.parse(request.getDate());
        } catch (ParseException e) {
            return null;
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String user_name = userPrincipal.getUsername();

        List<Exam> exams = examRepo.findStudentExamByUser(user_name);
        List<Exam> return_exams=exams.stream().filter(exam -> exam.getStartDateTime().toString().equals(outputFormat.format(date))).toList();
        List<SendingExam> sendingExams = return_exams.stream().map(exam -> new SendingExam(exam.getExamId(), exam.getStartDateTime(), exam.getDuration(), exam.getPassingCriteria(), exam.getType(), exam.getTotalMarks(), exam.getCourseOffering().getCourse().getCourseId(), exam.getCourseOffering().getCourse().getCourseName(), exam.getCourseOffering().getCourse().getCourseCode())).collect(Collectors.toList());
        return sendingExams;
    }

    public List<ProvideQuestion> getQuestions(long examID) {

     /*   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        String user  = userRepo.findByUsername(userPrincipal.getUsername());
        Student student = studentRepo.findByUser(user.getUsername());
        */

        this.ExamId=examID;
        return questionRepo.findQuestionById(examID).stream()
                .map(q -> new ProvideQuestion(q.getQuestionId(), q.getQuestion(), q.getMarks()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MarkQuestions> markQuestions(List<MarkQuestions> markQuestions) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        int TotalMarks = 0;
        Attempt attempt = new Attempt();

        User user = userRepo.findByUsername(userPrincipal.getUsername());
        Student student = studentRepo.findByUser(user);

        Exam exam = examRepo.findExamByExamId(ExamId);

        for (MarkQuestions question : markQuestions) {
            String correctAnswer = questionRepo.findAnswerByQuestionId((long) question.getQuestionId());
            int retrievedMarks = questionRepo.findMarksByQuestionId((long) question.getQuestionId());

            // Save Exam Analysis (User's Answer)
            ExamAnalysis examAnalysis = new ExamAnalysis();
            examAnalysis.setExam(exam);
            examAnalysis.setQuestion(questionRepo.findById((long)question.getQuestionId()).orElse(null));
            examAnalysis.setStudentAnswer(question.getAnswer()); // Save user-provided answer

            examanalysisRepo.save(examAnalysis); // Save the entry into the exam_analysis table

            // Compare the given answer with the correct answer
            if (question.getAnswer().equalsIgnoreCase(correctAnswer)) {
                question.setMarks(retrievedMarks); // Full marks for correct answer
            } else {
                question.setMarks(0); // Assign 0 marks for incorrect answers
            }
            TotalMarks += question.getMarks();
        }

        attempt.setMarks(TotalMarks);
        attempt.setExam(exam);
        attempt.setGrade(getGrade(TotalMarks));
        attempt.setStudent(student);

        try {
            attemptRepo.save(attempt);
        } catch (Exception e) {
            System.out.println("Cannot Attempt More Than One Time " + e);
        }

        return markQuestions;
    }



    public Character getGrade(int totalMarks) {
        if (totalMarks >= 90) return 'A';
        else if (totalMarks >= 80) return 'B';
        else if (totalMarks >= 70) return 'C';
        else if (totalMarks >= 60) return 'D';
        else if (totalMarks >= 50) return 'E';
        else return 'F';
    }

	public Long addExam( Map<String, Object> payload) {
        
        Long offeringId = Long.valueOf(payload.get("Offering_ID").toString());
        LocalDateTime startDateTime = LocalDateTime.parse(payload.get("startDateTime").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Integer duration = Integer.valueOf(payload.get("duration").toString());
        Integer passingCriteria = Integer.valueOf(payload.get("passingCriteria").toString());
        Integer type = Integer.valueOf(payload.get("type").toString());
        Integer totalMarks = Integer.valueOf(payload.get("totalMarks").toString());

            // Fetch the CourseOffering entity
        CourseOffering courseOffering = courseOfferingRepo.findById(offeringId).orElseThrow(() -> new IllegalArgumentException("Invalid Offering_ID"));

            // Create the Exam object
        Exam exam = new Exam();
        exam.setCourseOffering(courseOffering);
        exam.setStartDateTime(startDateTime);
        exam.setDuration(duration);
        exam.setPassingCriteria(passingCriteria);
        exam.setType(type);
        exam.setTotalMarks(totalMarks);

            // Save the Exam object

        examRepo.save(exam);
        return exam.getExamId();
    }
}
