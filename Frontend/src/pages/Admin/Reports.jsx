import React, { useState, useEffect } from 'react';
import NavbarAdminHome from '../../components/NavbarAdminHome';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import './Reports.css';

function Reports() {
  const [examEvents, setExamEvents] = useState([]); // State to store exam events
  const [selectedExam, setSelectedExam] = useState(null); // State to store the selected exam

  useEffect(() => {
    // Fetch JSON data
    const fetchData = async () => {
      const response = await fetch('/Admin/AdminHome.json'); // Replace with the actual path
      const data = await response.json();
      setExamEvents(data);
    };
    fetchData();
  }, []);

  const handleSelectExam = (exam) => {
    setSelectedExam(exam);
  };

  const handleGenerateReport = () => {
    if (selectedExam) {
      alert(`Generating report for ${selectedExam.title}`);
    } else {
      alert('Please select an exam to generate a report.');
    }
  };

  return (
    <>
      <NavbarAdminHome />
      <div className="calendarContainer">
      <h2 className="subHeading">Select an Exam from the Calendar</h2>
      <div className="calendarWrapper">
      <Calendar
  className="custom-calendar"
  tileContent={({ date }) => {
    const event = examEvents.find(event => new Date(event.date).toDateString() === date.toDateString());
    return event ? <span className="eventDot"></span> : null;
  }}
  onClickDay={(date) => {
    const event = examEvents.find(event => new Date(event.date).toDateString() === date.toDateString());
    if (event) handleSelectExam(event);
  }}
/>
  </div>


        {/* Upcoming Exams Section */}
        <div className="upcomingExamsContainer">
        <h2 className="subHeading">Upcoming Exams</h2>
        <ul className="examList">
          {examEvents.map((exam, index) => (
            <li
              key={index}
              className={`examItem ${selectedExam?.title === exam.title ? 'selected' : ''}`}
              onClick={() => handleSelectExam(exam)}
            >
              <h3 className="examTitle">{exam.title}</h3>
              <p className="examDetails">
                <strong>Date:</strong> {new Date(exam.date).toDateString()}
              </p>
              <p className="examDetails">
                <strong>Time:</strong> {exam.time}
              </p>
            </li>
          ))}
        </ul>
      </div>

      <button className="button" onClick={handleGenerateReport}>
        Generate Report
      </button>
    </div>
  </>
);
         
}



export default Reports;