import React, { useState, useEffect } from 'react';
import Select from 'react-select';
import './MarkExam.css';
import NavbarLecturer from '../../../components/NavbarLecturer';

const MarkExam = () => {
  const [subjects, setSubjects] = useState([]);
  const [selectedSubject, setSelectedSubject] = useState(null);
  const [students, setStudents] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState(null);
  const [essayAnswers, setEssayAnswers] = useState([]);
  const BASE_URL = "http://192.168.147.57:8080";

  // Load subjects on component mount
  useEffect(() => {
    const token = localStorage.getItem("token");
    fetch(`${BASE_URL}/lecturer/markExam`, {
      method: 'POST',
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`,
      },
    })
      .then((res) => res.json())
      .then((data) => setSubjects(data))
      .catch((err) => console.error('Error fetching subjects:', err));
  }, []);

  const handleSubjectChange = (selectedOption) => {
    setSelectedSubject(selectedOption);
    setSelectedStudent(null);
    setEssayAnswers([]);

    const token = localStorage.getItem("token");
    fetch(`${BASE_URL}/lecturer/markExam/${selectedOption.value}`, {
      method: 'POST',
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((data) => setStudents(data))
      .catch((err) => console.error('Error fetching students:', err));
  };

  const handleStudentChange = (selectedOption) => {
    setSelectedStudent(selectedOption);

    const token = localStorage.getItem("token");
    fetch(`${BASE_URL}/lecturer/markExam/${selectedSubject.value}/${selectedOption.value}`, {
      method: 'POST',
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((data) => setEssayAnswers(data))
      .catch((err) => console.error('Error fetching answers:', err));
  };

  const handleEssayMarkChange = (index, marks) => {
    const updatedAnswers = [...essayAnswers];
    updatedAnswers[index].marks = marks;
    setEssayAnswers(updatedAnswers);
  };

  const handleSubmitMarks = () => {
    const token = localStorage.getItem("token");
  
    const payload = essayAnswers.map((answer) => ({
        questionId: answer.questionId,
        marks: answer.marks,
        answer: answer.studentAnswer, // Send the actual student response
      }));
  
    fetch(`${BASE_URL}/lecturer/markExam/${selectedSubject.value}/${selectedStudent.value}/submit`, {
      method: 'POST',
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    })
      .then((res) => {
        if (!res.ok) throw new Error('Failed to submit marks.');
        alert('Marks and answers submitted successfully!');
      })
      .catch((err) => {
        console.error('Error submitting marks and answers:', err);
        alert('There was an error submitting the marks and answers.');
      });
  };
  

  return (
    <>
    <NavbarLecturer/>
    <div className="mark-exam-container">
      <h2>Mark Exams</h2>

      <div className="dropdown-container">
        <label>Select Subject:</label>
        <Select
          options={subjects.map(subject => ({
            value: subject.id,
            label: subject.code,
          }))}
          placeholder="Select a subject"
          onChange={handleSubjectChange}
        />
      </div>

      {selectedSubject && (
        <div className="dropdown-container">
          <label>Select Student:</label>
          <Select
            options={students.map(student => ({
              value: student.studentId,
              label: student.studentId,
            }))}
            placeholder="Select a student"
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
                <p><strong>Q{index + 1}:</strong> {answer.question}</p>
                <p><strong>Student's Answer:</strong> {answer.studentAnswer}</p>
                <input
                type="number"
                placeholder="Marks"
                value={answer.marks || ''}
                onChange={(e) => handleEssayMarkChange(index, e.target.value)}
                />
            </div>
))}
          </div>

          <button onClick={handleSubmitMarks}>Submit Marks</button>
        </div>
      )}
    </div>
    </>
  );
};

export default MarkExam;
