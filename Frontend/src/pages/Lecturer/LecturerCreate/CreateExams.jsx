import React from 'react'

const CreateExams = () => {
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
                <button className="event-button" onClick={()=> navigate("/quiz-create")} >Quizzes</button>
                <button className="event-button" onClick={()=> navigate("/assignment-create")} >Assignments</button>
                <button className="event-button" onClick={()=> navigate("/exams-create")} >Exams</button>
                <button className="event-button" onClick={()=> navigate("/reschedule")} >Reschedule</button>
            </div>
        </div>
        </div>
    </div>
    </>
  );
}

export default CreateExams