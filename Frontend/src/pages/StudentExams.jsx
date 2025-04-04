import React, { useState, useEffect } from "react";
import './StudentQuiz.css';
import Navbar from "../components/Navbar";

const StudentExams = () => {
  const [quizzes, setQuizzes] = useState([]);
  const [currentQuiz, setCurrentQuiz] = useState(null);
  const [answers, setAnswers] = useState({});
  const [submitted, setSubmitted] = useState(false);

  // Fetch quizzes from backend
  useEffect(() => {
    const token = localStorage.getItem("token"); // Retrieve token
    console.log("Token:", token); // Log token for debugging
    fetch("http://192.168.147.57:8080/student/exam/getAll", {
      method: "POST",
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((data) => {
        console.log("Fetched Data:", data);
        // Map backend data to frontend format
        const formattedQuizzes = data.map((quiz) => ({
          id: quiz.examId,
          title: quiz.courseName,
          subject: quiz.courseCode,
          duration: quiz.duration,
          passingCriteria: quiz.passingCriteria,
          totalMarks: quiz.totalMarks,
          startDateTime: quiz.startDateTime,
          type: quiz.type,
        }));
        setQuizzes(formattedQuizzes);
      })
      .catch((err) => console.error("Error fetching quizzes:", err));
  }, []);

  // Start a quiz
  const startQuiz = (quiz) => {
    setCurrentQuiz(quiz);
    setSubmitted(false);
    setAnswers({});
  };

  // Handle answer selection
  const handleAnswerChange = (questionId, selectedOption) => {
    setAnswers((prev) => ({ ...prev, [questionId]: selectedOption }));
  };

  // Submit quiz to backend
  const submitQuiz = () => {
    console.log("Submitting Answers:", answers);
    setSubmitted(true);

    const token = localStorage.getItem("token"); // Retrieve token

    fetch(`http://192.168.147.57:8080/student/exam/${currentQuiz.id}/submit`, {
      method: "POST",
      body: JSON.stringify({ quizId: currentQuiz.id, answers }),
      headers: {
        "Authorization": `Bearer ${token}`, // Attach token
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((result) => console.log("Quiz Result:", result))
      .catch((err) => console.error("Error submitting quiz:", err));
  };

  return (
    <>
      <Navbar />
      <div className="student-quiz-container">
        <h2 className="ava-qz">Available Quizzes</h2>
        {!currentQuiz ? (
          // Show available quizzes
          <div className="quiz-list">
            {quizzes.length > 0 ? (
              quizzes.map((quiz) => (
                <div key={quiz.id} className="quiz-card">
                  <h3>{quiz.title}</h3>
                  <p>Subject: {quiz.subject}</p>
                  <p>Duration: {quiz.duration} mins</p>
                  <p>Passing Criteria: {quiz.passingCriteria}%</p>
                  <p>Total Marks: {quiz.totalMarks}</p>
                  <p>Start Date: {new Date(quiz.startDateTime).toLocaleString()}</p>
                  <button onClick={() => startQuiz(quiz)}>Start Quiz</button>
                </div>
              ))
            ) : (
              <p>No quizzes available</p>
            )}
          </div>
        ) : (
          // Show quiz interface
          <div className="quiz-container">
            <h2>{currentQuiz.title}</h2>
            {currentQuiz.questions.map((q, index) => (
              <div key={q.id} className="question">
                <p>
                  {index + 1}. {q.questionText}
                </p>
                {q.options.map((option, i) => (
                  <label key={i}>
                    <input
                      type="radio"
                      name={`question-${q.id}`}
                      value={option}
                      onChange={() => handleAnswerChange(q.id, option)}
                    />
                    {option}
                  </label>
                ))}
              </div>
            ))}
            <button onClick={submitQuiz} disabled={submitted}>
              Submit Quiz
            </button>
          </div>
        )}
      </div>
    </>
  );
};

export default StudentExams;
