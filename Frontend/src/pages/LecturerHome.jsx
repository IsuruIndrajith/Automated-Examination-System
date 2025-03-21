import React from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./LecturerHome.css"; // Create this CSS file for custom styles

const LecturerHome = () => {
  const events = [
    { time: "8 AM", task: "EC4040 ASSIGNMENT" },
    { time: "10 AM", task: "EC4050 QUIZ" },
    { time: "10:30 AM", task: "EC4060 QUIZ" },
  ];

  return (
    <div className="lecturer-dashboard">
      <header className="dashboard-header">
        <span className="lecturer-title">Lecturer</span>
        <span className="homepage-title">LECTURER HOMEPAGE</span>
        <span className="logout">LOG OUT</span>
      </header>

      <div className="dashboard-body">
        {/* Sidebar */}
        <nav className="sidebar">
          <button className="sidebar-button">HOME</button>
          <button className="sidebar-button">CREATE</button>
          <button className="sidebar-button">NOTIFY</button>
          <button className="sidebar-button">REPORTS</button>
          <button className="sidebar-button">NOTES</button>
          <button className="sidebar-button">RESCHEDULE</button>
        </nav>

        {/* Main Calendar and Events */}
        <div className="calendar-section">
          <Calendar className="custom-calendar" />
          <div className="events-list">
            {events.map((event, index) => (
              <div key={index} className="event-item">
                <span className="event-time">{event.time}</span>
                <span className="event-task">{event.task}</span>
              </div>
            ))}
          </div>
        </div>

        {/* Right Section - Select Lecture */}
        <div className="select-lecture-section">
          <button className="select-lecture-button">SELECT LECTURE</button>
        </div>
      </div>
    </div>
  );
};

export default LecturerHome;
