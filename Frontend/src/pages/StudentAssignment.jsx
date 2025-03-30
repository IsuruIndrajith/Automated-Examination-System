import React, { useState, useEffect } from "react";
import './StudentAssignment.css';
import Navbar from "../components/Navbar";

const StudentAssignment = () => {
  const [assignments, setAssignments] = useState([]);
  const [currentAssignment, setCurrentAssignment] = useState(null);
  const [answers, setAnswers] = useState({});
  const [submitted, setSubmitted] = useState(false);

  // Fetch assignments
  useEffect(() => {
    fetch("/assignment.json") 
      .then((res) => res.json())
      .then((data) => {
        setAssignments(data);
        console.log(data);
      })
      .catch((err) => console.error("Error fetching assignments:", err));
  }, []);

  // Start an assignment
  const startAssignment = (assignment) => {
    setCurrentAssignment(assignment);
    setSubmitted(false);
    setAnswers({});
  };

  // Handle answer change (for MCQ)
  const handleAnswerChange = (questionId, selectedOption) => {
    setAnswers((prev) => ({ ...prev, [questionId]: selectedOption }));
  };

  // Handle text answer (for writing assignments)
  const handleTextAnswerChange = (questionId, textAnswer) => {
    setAnswers((prev) => ({ ...prev, [questionId]: textAnswer }));
  };

  // Submit the assignment
  const submitAssignment = () => {
    console.log("Submitting Assignment:", answers);
    setSubmitted(true);

    // Send data to backend or update the JSON file
    fetch("/api/submit-assignment", {
      method: "POST",
      body: JSON.stringify({ assignmentId: currentAssignment.id, answers }),
      headers: { "Content-Type": "application/json" },
    })
      .then((res) => res.json())
      .then((result) => console.log("Assignment Result:", result))
      .catch((err) => console.error("Error submitting assignment:", err));
  };

  return (
    <>
    <Navbar/>
      <div className="student-assignment-container">
      <h2 className="av-as">Available Assignments</h2>
      {!currentAssignment ? (
        // Show available assignments
        <div className="assignment-list">
          
          {assignments.length > 0 ? (
            assignments.map((assignment) => (
              <div key={assignment.id} className="assignment-card">
                <h3>{assignment.title}</h3>
                <p>Subject: {assignment.subject}</p>
                <p>Deadline: {assignment.deadline}</p>
                <button onClick={() => startAssignment(assignment)}>Start Assignment</button>
              </div>
            ))
          ) : (
            <p>No assignments available</p>
          )}
        </div>
      ) : (
        // Show assignment interface
        <div className="assignment-container">
          <h2 style={{display: 'flex', justifyContent: 'center'}}>{currentAssignment.title}</h2>
          {currentAssignment.questions.map((q) => (
            <div key={q.id} className="question">
              <p>{q.questionText}</p>
              {q.type === "mcq" ? (
                // Multiple choice question
                <div className="mcq-options">
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
              ) : (
                // Writing question
                <textarea className="text-assign"
                  rows="5"
                  placeholder="Type your answer here..."
                  onChange={(e) => handleTextAnswerChange(q.id, e.target.value)}
                />
              )}
            </div>
          ))}
          <button className="sub-btn-assign" onClick={submitAssignment} disabled={submitted}>
            Submit Assignment
          </button>
        </div>
      )}
    </div>
    </>
  );
};

export default StudentAssignment;
