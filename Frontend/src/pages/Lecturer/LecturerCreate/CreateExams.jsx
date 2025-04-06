import React, { useState } from "react";
import "./CreateExams.css"; // Optional styling file
import NavbarLecturer from "../../../components/NavbarLecturer";

const CreateExams = () => {
  const [examType, setExamType] = useState(""); // "mcq" or "essay"
  const [mcqQuestions, setMcqQuestions] = useState([]);
  const [essayQuestions, setEssayQuestions] = useState([]);
  const [examInfo, setExamInfo] = useState({
    startDateTime: "",
    duration: "",
    passingCriteria: 1,
    type: 1, // Assuming '1' represents 'Exam'
    totalMarks: "",
    courseOfferingId: "", // Ensure this is included
  });  

  const BASE_URL = "http://192.168.147.57:8080";

  const handleAddMcq = () => {
    setMcqQuestions([
      ...mcqQuestions,
      {
        question: "",
        marks: 0,
        answer: "",
        questionType: 1,
        mcqOptionsList: [
          { optionText: "", isCorrect: false },
          { optionText: "", isCorrect: false },
          { optionText: "", isCorrect: false },
          { optionText: "", isCorrect: false },
        ],
      },
    ]);
  };
  
  const handleMcqChange = (qIndex, field, value) => {
    const updatedMcqs = mcqQuestions.map((q, index) => {
      if (index === qIndex) {
        if (field === "question" || field === "answer") {
          return { ...q, [field]: value };
        } else if (field === "marks") {
          return { ...q, marks: parseInt(value, 10) };
        } else if (field.startsWith("option")) {
          const optIndex = parseInt(field.slice(-1), 10);
          const updatedOptions = q.mcqOptionsList.map((opt, i) =>
            i === optIndex ? { ...opt, optionText: value } : opt
          );
          return { ...q, mcqOptionsList: updatedOptions };
        } else if (field === "correctAnswer") {
          const updatedOptions = q.mcqOptionsList.map((opt, i) => ({
            ...opt,
            isCorrect: i === parseInt(value, 10),
          }));
          return { ...q, mcqOptionsList: updatedOptions };
        }
      }
      return q;
    });
    setMcqQuestions(updatedMcqs);
  };
  
  const handleAddEssay = () => {
    setEssayQuestions([
      ...essayQuestions,
      {
        question: "",
        marks: 0,
        answer: "",
        questionType: 2
      }
    ]);
  };  
  
  const handleEssayChange = (index, value) => {
    const updated = [...essayQuestions];
    updated[index] = {
      ...updated[index],
      question: value,
      marks: updated[index].marks || 0,
      answer: updated[index].answer || "",
      questionType: 2
    };
    setEssayQuestions(updated);
  };
  
  const handleExamInfoChange = (e) => {
    const { name, value } = e.target;
    setExamInfo((prev) => ({
      ...prev,
      [name]: name === "duration" || name === "courseOfferingId" ? parseInt(value, 10) : value,
    }));
  };
  

  const token = localStorage.getItem("token");
  console.log("Token:", token);
  console.log("Exam Info:", examInfo);

  const handleSubmit = () => {
    const questions =
      examType === "mcq"
        ? mcqQuestions.map((q) => ({
            question: q.question,
            marks: q.marks,
            answer: q.answer,
            questionType: q.questionType,
            mcqOptionsList: q.mcqOptionsList,
          }))
        : essayQuestions.map((q) => ({
            question: q.question,
            marks: q.marks,
            answer: q.answer,
            questionType: q.questionType,
          }));
  
    const payload = {
      ...examInfo,
      questions,
    };
  
    fetch(`${BASE_URL}/lecturer/addExam`, {
      method: "POST",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to create exam.");
        return res.json();
      })
      .then((data) => {
        alert("Exam created successfully!");
        console.log("Response:", data);
      })
      .catch((err) => {
        console.error("Error:", err);
        alert("There was an error submitting the exam.");
      });
  };
  

  return (
    <>
      <NavbarLecturer />
      <div className="exam-create-container">
        <h2>Create Exam</h2>

        <div className="exam-meta">
          
          <input
            type="text"
            name="courseOfferingId"
            placeholder="Course Offering ID"
            value={examInfo.courseOfferingId}
            onChange={handleExamInfoChange}
          />
          <input
            type="text"
            name="offeringId"
            placeholder="Offering ID"
            value={examInfo.offeringId}
            onChange={handleExamInfoChange}
          />
          <input
            type="datetime-local"
            name="startDateTime"
            value={examInfo.startDateTime}
            onChange={handleExamInfoChange}
          />
          <input
            type="text"
            name="duration"
            placeholder="Duration (e.g., 90min)"
            value={examInfo.duration}
            onChange={handleExamInfoChange}
          />
          <input
            type="number"
            name="totalMarks"
            placeholder="Total Marks"
            value={examInfo.totalMarks}
            onChange={handleExamInfoChange}
          />

          <div className="exam-type-select">
            <label>Select Exam Type:</label>
            <select value={examType} onChange={(e) => setExamType(e.target.value)}>
              <option value="">-- Select --</option>
              <option value="mcq">MCQs</option>
              <option value="essay">Essays</option>
            </select>
          </div>
        </div>

        {examType === "mcq" && (
          <div className="mcq-section">
            <h3>MCQ Questions</h3>
            {mcqQuestions?.map((q, index) => (
  <div key={index} className="question-block">
    <input
      type="text"
      placeholder={`Question ${index + 1}`}
      value={q.question}
      onChange={(e) => handleMcqChange(index, "question", e.target.value)}
    />
    <input
      type="number"
      placeholder="Marks"
      value={q.marks}
      onChange={(e) => handleMcqChange(index, "marks", e.target.value)}
    />
    <input
      type="text"
      placeholder="Correct Answer"
      value={q.answer}
      onChange={(e) => handleMcqChange(index, "answer", e.target.value)}
    />
      {q.mcqOptionsList?.map((opt, i) => (
        <input
          key={i}
          type="text"
          placeholder={`Option ${i + 1}`}
          value={opt.optionText}
          onChange={(e) => handleMcqChange(index, `option${i}`, e.target.value)}
        />
      ))}
          <select
            onChange={(e) => handleMcqChange(index, "correctAnswer", e.target.value)}
          >
            <option value={0}>Correct Option: 1</option>
            <option value={1}>Correct Option: 2</option>
            <option value={2}>Correct Option: 3</option>
            <option value={3}>Correct Option: 4</option>
          </select>
        </div>
      ))}

          <button onClick={handleAddMcq}>+ Add MCQ</button>
        </div>
      )}

        {examType === "essay" && (
          <div className="essay-section">
            <h3>Essay Questions</h3>
            {essayQuestions.map((q, index) => (
              <div key={index} className="essay-block">
                <textarea
                  placeholder={`Essay Question ${index + 1}`}
                  value={q.question || ""}
                  onChange={(e) => handleEssayChange(index, e.target.value)}
              />
            </div>
          ))}

            <button onClick={handleAddEssay}>+ Add Essay</button>
          </div>
        )}

        <button className="submit-btn" onClick={handleSubmit}>
          Submit Exam
        </button>
      </div>
    </>
  );
};

export default CreateExams;
