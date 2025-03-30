import React, { useState, useEffect } from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "../StudentHomePage.css"; // Reusing Student styles
import NavbarLecturer from "../../components/NavbarLecturer"; 

const LecturerHomePage = () => {

  const [events, setEvents] = useState([]);
  const [specialDates, setSpecialDates] = useState({});

  useEffect(()=>{
    fetch("/lecturer-events.json")
    .then((res)=> res.json())
    .then((data)=> {setEvents(data);
      console.log(data.events);
    })
    .catch((err)=> console.log("Error fetching events: ", err));
  },[]);

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
      <NavbarLecturer />
      <div className="student-homepage">
        {/* Calendar Section */}
        <div className="calendar-section">
          <h2 className="event-cal">Event Calendar</h2>
          <Calendar tileClassName={tileClassName} />
        </div>

        {/* Events Section */}
        <div className="tasks-section">
          <h2 className="ongoing-tasks-title">Upcoming Events</h2>
          <div className="task-cards">
            {events.length > 0 ? (
              events.map((event, index) => (
                <div key={index} className="task-card">
                  <h3>{event.task}</h3>
                  <p className="task-card-{event.type.toLowerCase()}"></p>
                  <p>Time: {event.time}</p>
                </div>
              ))
            ) : (
              <p>No upcoming events.</p>
            )}
          </div>
        </div>
      </div>
    </>
  );
};

export default LecturerHomePage;