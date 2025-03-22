import React, { useState, useEffect } from "react";
import './StudentQuiz.css';
import Navbar from "../components/Navbar";

const StudentQuiz = () => {
  
  const [quizzes, setQuizzes] = useState([]);
  const [currentQuiz, setCurrentQuiz] = useState(null);
  const [answers, setAnswers] = useState({});
  const [submitted, setSubmitted] = useState(false);

  // quiz fetch
  useEffect(() => {
    fetch("/quiz.json")
      .then((res) => res.json())
      .then((data) => {
        console.log("Fetched Data:", data);
        setQuizzes(data.quizzes);
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

  // Submit
  const submitQuiz = () => {
    console.log("Submitting Answers:", answers);
    setSubmitted(true);

    // Send data to backend
    fetch("/submitQz.json", {
      method: "POST",
      body: JSON.stringify({ quizId: currentQuiz.id, answers }),
      headers: { "Content-Type": "application/json" },
    })
      .then((res) => res.json())
      .then((result) => console.log("Quiz Result:", result))
      .catch((err) => console.error("Error submitting quiz:", err));
  };

  return (
    <>
    <Navbar/>
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

export default StudentQuiz;
