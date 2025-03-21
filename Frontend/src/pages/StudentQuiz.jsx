import React, { useState, useEffect } from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./StudentHomePage.css"; 
import Navbar from "../components/Navbar"; 

const StudentQuiz = () => {
  const [tasks, setTasks] = useState([]);
  const [specialDates, setSpecialDates] = useState({});

  useEffect(() => {
    fetch("/tasks.json")
      .then((res) => res.json())
      .then((data) => setTasks(data))
      .catch((err) => console.error("Error fetching tasks:", err));
  }, []);

  useEffect(() => {
    fetch("/special-dates.json")
      .then((res) => res.json())
      .then((data) =>  {console.log("Fetched Special Dates: ", data); 
        setSpecialDates(data);})
      .catch((err) => console.error("Error fetching special dates:", err));
  }, []);

  const tileClassName = ({ date, view }) => {
    return "";
  };

  return (
    <>
      <Navbar />
      <div className="student-homepage">
        {/* Calendar*/}
        <div className="calendar-section">
          <h2 className="event-cal">Event Calendar</h2>
          <Calendar tileClassName={tileClassName} />
          <div className="calendar-legend">
              <div className="legend-item">
                <span className="legend-color assignment"></span> Assignment
              </div>
              <div className="legend-item">
                <span className="legend-color quiz"></span> Quiz
              </div>
              <div className="legend-item">
                <span className="legend-color exam"></span> Exam
              </div>
              <div className="legend-item">
                <span className="legend-color today"></span> Today
              </div>
          </div>
        </div>

        {/* Ongoing Tasks*/}
        <div className="tasks-section">
          <h2 className="ongoing-tasks-title">Ongoing Tasks</h2>
          <div className="task-cards">
            {tasks.length > 0 ? (
              tasks.map((task) => (
                <div key={task.id} className="task-card">
                  <h3>{task.title}</h3>
                  <p>Type: {task.type}</p>
                  <p>Due Date: {task.dueDate}</p>
                </div>
              ))
            ) : (
              <p>No ongoing tasks available.</p>
            )}
          </div>
        </div>
      </div>
    </>
  );
};

export default StudentQuiz;
