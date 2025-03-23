import React from "react";
import "./LecturerCreate.css";
import NavbarLecturer from "../../components/NavbarLecturer";
import { useState, useEffect } from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";

const CreateEvent = () => {
    const [specialDates, setSpecialDates] = useState({});

    useEffect(() => {
        fetch("/special-dates.json")
          .then((res) => res.json())
          .then((data) => setSpecialDates(data))
          .catch((err) => console.error("Error fetching special dates:", err));
      }, []);

      const tileClassName = ({ date, view }) => {
        if (view === "month") {
          const dateString = `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, "0")}-${String(date.getDate()).padStart(2, "0")}`;
          if (specialDates[dateString]) {
            return `highlight-${specialDates[dateString]}`;
          }
        }
        return "";
      };


  return (
    <>
    <NavbarLecturer/>
    <div className="lecturer-create-container">
        {/* Calendar Section */}
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
        
        {/* Events Section */}
        <div className="events-section">
        <h2 className="title">Create Event</h2>
        <div className="create-event-container">
            <div className="event-options">
                <button className="event-button">Quizzes</button>
                <button className="event-button">Assignments</button>
                <button className="event-button">Exams</button>
                <button className="event-button">Quick Quizzes</button>
                <button className="event-button">Reschedule</button>
            </div>
        </div>
        </div>
    </div>
    </>
  );
};

export default CreateEvent;
