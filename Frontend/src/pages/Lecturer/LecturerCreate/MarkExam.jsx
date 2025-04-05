import React, { useState, useEffect } from 'react';
import Select from 'react-select';
import './MarkExam.css'; // Import the CSS file for styling

const MarkExam = () => {
  const [subjects, setSubjects] = useState([]);
  const [selectedSubject, setSelectedSubject] = useState(null);
  const [students, setStudents] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState(null);
  const [essayAnswers, setEssayAnswers] = useState([]);
  const [mcqResults, setMcqResults] = useState([]);

  const BASE_URL = "http://192.168.68.73:8080";

  useEffect(() => {
    const token = localStorage.getItem("token");
  
    fetch(`${BASE_URL}/lecturer/subjects`, {
      method: 'GET',
      headers: {
        "Authorization": `Bearer ${token}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        setSubjects(data);
      })
      .catch((err) => console.error('Error fetching subjects:', err));
  }, []);
  

  const handleSubjectChange = (selectedOption) => {
    setSelectedSubject(selectedOption);
    const token = localStorage.getItem("token");
  
    fetch(`${BASE_URL}/lecturer/markExam`, {
      headers: {
        "Authorization": `Bearer ${token}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        setStudents(data);
      })
      .catch((err) => console.error('Error fetching students:', err));
  };
  

  const handleStudentChange = (selectedOption) => {
    setSelectedStudent(selectedOption);
    const token = localStorage.getItem("token");
  
    fetch(`${BASE_URL}/lecturer/students/${selectedOption.value}/answers`, {
      headers: {
        "Authorization": `Bearer ${token}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        setEssayAnswers(data.essayAnswers);
        setMcqResults(data.mcqResults);
      })
      .catch((err) => console.error('Error fetching answers:', err));
  };
  

  const handleEssayMarkChange = (index, marks) => {
    const updatedAnswers = [...essayAnswers];
    updatedAnswers[index].marks = marks;
    setEssayAnswers(updatedAnswers);
  };

  const handleSubmitMarks = () => {
    const payload = {
      studentId: selectedStudent.value,
      essayMarks: essayAnswers.map((answer) => ({
        questionId: answer.questionId,
        marks: answer.marks,
      })),
    };
    const token = localStorage.getItem("token");
    console.log("token------");
    fetch(`${BASE_URL}/lecturer/submit-marks`, {
      method: 'POST',
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    })
      .then((res) => {
        if (!res.ok) throw new Error('Failed to submit marks.');
        alert('Marks submitted successfully!');
      })
      .catch((err) => {
        console.error('Error submitting marks:', err);
        alert('There was an error submitting the marks.');
      });
  };

  return (
    <div className="mark-exam-container">
      <h2>Mark Exams</h2>

      <div className="dropdown-container">
        <label>Select Subject:</label>
        <Select
          options={subjects.map((subject) => ({
            value: subject.id,
            label: subject.name,
          }))}
          onChange={handleSubjectChange}
        />
      </div>

      {selectedSubject && (
        <div className="dropdown-container">
          <label>Select Student:</label>
          <Select
            options={students.map((student) => ({
              value: student.id,
              label: student.name,
            }))}
            onChange={handleStudentChange}
          />
        </div>
      )}

      {selectedStudent && (
        <div className="marking-sections">
          <div className="essay-marking">
            <h3>Essay Questions</h3>
            {essayAnswers.map((answer, index) => (
              <div key={answer.questionId} className="essay-question">
                <p>
                  <strong>Q{index + 1}:</strong> {answer.question}
                </p>
                <p>
                  <strong>Student's Answer:</strong> {answer.answer}
                </p>
                <input
                  type="number"
                  placeholder="Marks"
                  value={answer.marks || ''}
                  onChange={(e) =>
                    handleEssayMarkChange(index, e.target.value)
                  }
                />
              </div>
            ))}
          </div>

          <div className="mcq-results">
            <h3>MCQ Results</h3>
            {mcqResults.map((result, index) => (
              <p key={index}>
                <strong>Q{index + 1}:</strong> {result.question} -{' '}
                {result.isCorrect ? 'Correct' : 'Incorrect'}
              </p>
            ))}
          </div>

          <button onClick={handleSubmitMarks}>Submit Marks</button>
        </div>
      )}
    </div>
  );
};

export default MarkExam;
