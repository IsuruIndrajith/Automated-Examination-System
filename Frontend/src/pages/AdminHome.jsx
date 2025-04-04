import React, { useState, useEffect } from 'react';
import NavbarAdminHome from "../components/NavbarAdminHome";
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import './AdminHome.css';

function AdminHome() {
  const [examEvents, setExamEvents] = useState([]);

  useEffect(() => {
    // Simulate fetching JSON data
    const fetchData = async () => {
      const response = await fetch('/Admin/AdminHome.json'); // Adjust the path as necessary
      const data = await response.json();
      setExamEvents(data);
    };
    fetchData();
  }, []);

  const upcomingExams = examEvents
    .filter(event => new Date(event.date) > new Date()) 
    .sort((a, b) => new Date(a.date) - new Date(b.date)) // Sort by date
    .slice(0, 3);

  return (
    <>
      <NavbarAdminHome />
      <div style={styles.container}>
        <h1 style={styles.heading}>Admin Dashboard</h1>

        {/* Calendar Section */}
        <div style={styles.calendarContainer}>
          <h2 style={styles.subHeading}>Upcoming Exams Calendar</h2>
          <Calendar
            tileContent={({ date }) => {
              const event = examEvents.find(event => new Date(event.date).toDateString() === date.toDateString());
              return event ? <span style={styles.eventDot}></span> : null;
            }}
          />
        </div>

        {/* Upcoming Exams Section */}
        <div style={styles.upcomingExamsContainer}>
          <h2 style={styles.subHeading}>Upcoming Exams</h2>
          {upcomingExams.length > 0 ? (
            <ul style={styles.examList}>
              {upcomingExams.map((exam, index) => (
                <li key={index} style={styles.examItem}>
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
          ) : (
            <p style={styles.noExamsText}>No upcoming exams.</p>
          )}
        </div>
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
    borderBottom: '1px solid #ccc',
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
  noExamsText: {
    fontSize: '1rem',
    color: '#555',
  },
};

export default AdminHome;