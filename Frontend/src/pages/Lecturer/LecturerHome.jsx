import React, { useState, useEffect } from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "../StudentHomePage.css"; // Reusing Student styles
import NavbarLecturer from "../../components/NavbarLecturer";

const LecturerHomePage = () => {
  const [events, setEvents] = useState([]);
  const [specialDates, setSpecialDates] = useState({});
  const [isLoading, setIsLoading] = useState(true); // Add loading state
  const [error, setError] = useState(null); // Add error state

  const BASE_URL = "http://10.102.18.163:8080";

  useEffect(() => {
    const token = localStorage.getItem("token");

    if (!token) {
      setError("Authentication token missing.");
      setIsLoading(false);
      return;
    }

    setIsLoading(true); // Set loading to true before fetch
    setError(null)

    fetch(`${BASE_URL}/lecturer/getAllExam`, {
      method: "POST",
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then((res) => {
        if (!res.ok) {
          throw new Error("Network response was not ok " + res.statusText);
        }
        return res.json();
      })
      .then((data) => {
        console.log("Raw API Response:", data);

        if (!data.events || !Array.isArray(data.events)) {
          console.error("Expected an array but got:", data);
          setIsLoading(false);
          return;
        }

        // Convert numeric type to meaningful string
        const typeMapping = {
          1: "Exam",
          2: "Quiz",
          3: "Assignment",
        };

        // Format event data
        const formattedEvents = data.events.map((event) => ({
          id: event.id,
          type: typeMapping[event.type] || "Unknown",
          date: new Date(event.date).toISOString().split("T")[0], // YYYY-MM-DD
          time: new Date(event.date).toLocaleTimeString(),
          subject: event.subject,
          code: event.code,
        }));

        setEvents(formattedEvents);

        // Extract unique dates for calendar highlights
        const dateHighlightMap = {};
        formattedEvents.forEach((event) => {
          dateHighlightMap[event.date] = event.type; // Store type of event for highlighting
        });

        setSpecialDates(dateHighlightMap);
        setIsLoading(false); // Set loading to false after successful fetch
      })
      .catch((err) => console.error("Error fetching events: ", err));
      setIsLoading(false); // Set loading to false on error
  }, []);

  const tileClassName = ({ date, view }) => {
    if (view === "month") {
      const dateString = `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, "0")}-${String(date.getDate()).padStart(2, "0")}`;
      if (specialDates[dateString]) {
        return `highlight-${specialDates[dateString].toLowerCase()}`;
      }
    }
    return "";
  };

  return (
    <>
      <NavbarLecturer />
      <div className="student-homepage">
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
        <div className="tasks-section">
          <h2 className="ongoing-tasks-title">Upcoming Events</h2>
          {isLoading && <p>Loading events...</p>}
          {error && <p style={{ color: "red" }}>{error}</p>}
          <div className="task-cards">
          {!isLoading && !error && events.length > 0 ? (
              events.map((event, index) => (
                <div key={index} className="task-card">
                  <h3>{event.subject}</h3>
                  <p className={`task-card-${event.type.replace(/\s+/g, "-").toLowerCase()}`}>
                    Type: {event.type}
                  </p>
                  <p>Date: {event.date}</p>
                  <p>Time: {event.time}</p>
                  <p>Code: {event.code}</p>
                </div>
              ))
            ) : (!isLoading && !error && <p>No upcoming events.</p>)}
          </div>
        </div>
      </div>
    </>
  );
};

export default LecturerHomePage;
