import React, { useState, useEffect } from "react";
import "./LecturerReport.css";
import NavbarLecturer from "../../components/NavbarLecturer";

const LecturerReports = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedStudent, setSelectedStudent] = useState(null);
  const [students, setStudents] = useState([]);
  const [classReport, setClassReport] = useState(null);

  useEffect(() => {
    fetch("/mockReportData.json")
      .then((res) => res.json())
      .then((data) => {
        setStudents(data.students || []);
        setClassReport(data.classReport || null);
      })
      .catch((err) => console.error("Error fetching students:", err));
  }, []);

  // Handles student search
  const handleSearch = () => {
    const foundStudent = students.find(
      (student) =>
        student.id.toLowerCase() === searchTerm.toLowerCase() ||
        student.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setSelectedStudent(foundStudent || null);
  };

  return (
    <>
    <NavbarLecturer/>
    <h2 className="reports-title">Reports</h2>
    <div className="reports-container">
      

      {/* Class Report Section */}
      {classReport && (
        <div className="class-report">
          <h3>Class Report</h3>
          <p><strong>Total Students:</strong> {classReport.totalStudents}</p>
          <p><strong>Average Score:</strong> {classReport.averageScore}%</p>
          <p><strong>Highest Score:</strong> {classReport.highestScore}%</p>
          <p><strong>Lowest Score:</strong> {classReport.lowestScore}%</p>
          <p><strong>Pass Rate:</strong> {classReport.passRate}</p>
        </div>
      )}

      {/* Student Report Section */}
      <div className="student-report">
        <h3  className="student-repo-title">Student Reports</h3>
        <div className="search-box">
          <input
            type="text"
            placeholder="Search by Student ID or Name..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <button onClick={handleSearch}>Search</button>
        </div>

        {/* Display Student Details */}
        {selectedStudent ? (
          <div className="student-details">
            <h4>📄 {selectedStudent.name}'s Report</h4>
            <p><strong>ID:</strong> {selectedStudent.id}</p>
            <p><strong>Email:</strong> {selectedStudent.email}</p>
            <p><strong>Assignments:</strong> {selectedStudent.assignments}%</p>
            <p><strong>Quizzes:</strong> {selectedStudent.quizzes}%</p>
            <p><strong>Exams:</strong> {selectedStudent.exams}%</p>
            <p><strong>Final Grade:</strong> {selectedStudent.finalGrade}</p>
          </div>
        ) : searchTerm ? (
          <p className="no-student">No student found with the given details.</p>
        ) : null}
      </div>
    </div>
    </>
  );
};

export default LecturerReports;
