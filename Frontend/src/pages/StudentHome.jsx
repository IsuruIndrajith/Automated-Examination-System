import React from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css"; // Import calendar styles
import "./StudentHome.css"; // Create this CSS file for custom styles

const StudentHome = () => {
  const events = [
    { time: "8 AM", task: "EC4040 ASSIGNMENT" },
    { time: "10 AM", task: "EC4050 QUIZ" },
    { time: "10:30 AM", task: "EC4060 QUIZ" },
  ];

  return (
    <div className="dashboard-container">
      <header className="dashboard-header">STUDENT HOMEPAGE</header>
      <div className="dashboard-content">
        {/* Sidebar */}
        <nav className="sidebar">
          <ul>
            <li>HOME</li>
            <li>EXAM</li>
            <li>QUIZ</li>
            <li>ASSIGNMENT</li>
            <li>REPORTS</li>
            <li>NOTES</li>
            <li>COMPLAIN</li>
          </ul>
        </nav>

        {/* Main Content */}
        <main className="main-content">
          <Calendar />
          <div className="events">
            {events.map((event, index) => (
              <div key={index} className="event">
                <span>{event.time}</span> - <span>{event.task}</span>
              </div>
            ))}
          </div>
        </main>

        {/* Ongoing Section */}
        <aside className="ongoing-section">
          <h3>ONGOING</h3>
          <p>XXXXXXXXXXXXXXXXX</p>
          <p>XXXXXXXXXXXXXXXXX</p>
          {/* Add more as needed */}
        </aside>
      </div>
    </div>
  );
};

export default StudentHome;
