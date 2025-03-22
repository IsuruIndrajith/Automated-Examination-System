import React from 'react';
import { useState, useEffect } from "react";
import './StudentReports.css';
import Navbar from '../components/Navbar';

const StudentReport = () => {
  const [reportData, setReportData] = useState([]);
  const [loading, setLoading] = useState(true);

  // Fetch 
  useEffect(() => {
    fetch("/studentreport.json")
      .then((res) => res.json())
      .then((data) => {
        setReportData(data);
        setLoading(false);
      })
      .catch((err) => console.error("Error fetching report data:", err));
  }, []);

  // Download JSON file
  const downloadReport = () => {
    const dataStr = JSON.stringify(reportData, null, 2);
    const blob = new Blob([dataStr], { type: "application/json" });
    const link = document.createElement("a");
    link.href = URL.createObjectURL(blob);
    link.download = "student_report.json";
    link.click();
  };

  return (
    <>
    <Navbar/>
    <div className="student-report-container">
      {loading ? (
        <p>Loading your report...</p>
      ) : (
        <><h2 className='stu-header'>Student Reports</h2>
          <div className="report-content">
            {reportData.length > 0 ? (
              reportData.map((subject) => (
                <div key={subject.id} className="subject-report">
                  <h3>{subject.name}</h3>
                  <p>Last Attempt: {subject.lastAttempt}</p>
                  <p>Marks Obtained: {subject.marksObtained}/{subject.totalMarks}</p>
                  <p>Overall Progress: {subject.progress}%</p>
                  <p>Last time marks: {subject.lastTimeMarks}/{subject.totalMarks}</p>
                  <button onClick={downloadReport} className="download-button">
                    Download Report
                  </button>
                </div>
              ))
            ) : (
              <p>No report data available.</p>
            )}
          </div>
        </>
      )}
    </div>
    </>
  );
};

export default StudentReport;
