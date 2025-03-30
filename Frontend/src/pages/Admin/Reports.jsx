import React, { useState, useEffect } from 'react';
import NavbarAdminHome from '../../components/NavbarAdminHome';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

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
      <div style={styles.container}>
        <h1 style={styles.heading}>Generate Exam Reports</h1>

        {/* Calendar Section */}
        <div style={styles.calendarContainer}>
          <h2 style={styles.subHeading}>Select an Exam from the Calendar</h2>
          <Calendar
            tileContent={({ date }) => {
              const event = examEvents.find(event => new Date(event.date).toDateString() === date.toDateString());
              return event ? <span style={styles.eventDot}></span> : null;
            }}
            onClickDay={(date) => {
              const event = examEvents.find(event => new Date(event.date).toDateString() === date.toDateString());
              if (event) handleSelectExam(event);
            }}
          />
        </div>

        {/* Upcoming Exams Section */}
        <div style={styles.upcomingExamsContainer}>
          <h2 style={styles.subHeading}>Upcoming Exams</h2>
          <ul style={styles.examList}>
            {examEvents.map((exam, index) => (
              <li
                key={index}
                style={{
                  ...styles.examItem,
                  backgroundColor: selectedExam?.title === exam.title ? '#e0f7fa' : '#fff',
                }}
                onClick={() => handleSelectExam(exam)}
              >
                <h3 style={styles.examTitle}>{exam.title}</h3>
                <p style={styles.examDetails}>
                  <strong>Date:</strong> {new Date(exam.date).toDateString()}
                </p>
                <p style={styles.examDetails}>
                  <strong>Time:</strong> {exam.time}
                </p>
              </li>
            ))}
          </ul>
        </div>

        {/* Generate Report Button */}
        <button style={styles.button} onClick={handleGenerateReport}>
          Generate Report
        </button>
      </div>
    </>
  );
}

const styles = {
  container: {
    padding: '20px',
    textAlign: 'center',
    minHeight: '100vh',
  },
  heading: {
    fontSize: '2rem',
    color: '#333',
    marginBottom: '20px',
  },
  subHeading: {
    fontSize: '1.5rem',
    color: '#333',
    marginBottom: '15px',
  },
  calendarContainer: {
    marginBottom: '40px',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    gap: '15px',
    marginTop: '20px',
  },
  eventDot: {
    display: 'block',
    width: '8px',
    height: '8px',
    backgroundColor: '#007bff',
    borderRadius: '50%',
    margin: '0 auto',
    marginTop: '5px',
  },
  upcomingExamsContainer: {
    textAlign: 'left',
    margin: '0 auto',
    maxWidth: '600px',
    backgroundColor: '#fff',
    padding: '20px',
    borderRadius: '10px',
    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
  },
  examList: {
    listStyleType: 'none',
    padding: 0,
  },
  examItem: {
    marginBottom: '20px',
    padding: '10px',
    border: '1px solid #ccc',
    borderRadius: '5px',
    cursor: 'pointer',
    transition: 'background-color 0.3s',
  },
  examTitle: {
    fontSize: '1.2rem',
    fontWeight: 'bold',
    marginBottom: '5px',
  },
  examDetails: {
    fontSize: '1rem',
    marginBottom: '5px',
  },
  button: {
    padding: '10px 20px',
    fontSize: '1rem',
    color: '#fff',
    backgroundColor: '#007bff',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    transition: 'background-color 0.3s',
    marginTop: '20px',
  },
};

export default Reports;