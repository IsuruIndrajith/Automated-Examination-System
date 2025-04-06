import React, { useState, useEffect } from 'react';
import './Reschedule.css';

const Reschedule = () => {
  const [exams, setExams] = useState([]);
  const [selectedExam, setSelectedExam] = useState(null);
  const [newDate, setNewDate] = useState('');
  const [newTime, setNewTime] = useState('');
  const [newLocation, setNewLocation] = useState('');

  useEffect(() => {
    // Load static mock data
    fetch('/mockExam.json')
      .then((response) => response.json())
      .then((data) => setExams(data))
      .catch((error) => console.error('Error loading exam data:', error));
  }, []);

  const handleExamChange = (event) => {
    const examId = event.target.value;
    const exam = exams.find(ex => ex.examId === examId);
    setSelectedExam(exam);
    setNewDate(exam.date);
    setNewTime(exam.time);
    setNewLocation(exam.location);
  };

  const handleReschedule = () => {
    if (!selectedExam) {
      alert('Please select an exam to reschedule.');
      return;
    }

    const updatedExam = {
      ...selectedExam,
      date: newDate,
      time: newTime,
      location: newLocation,
    };

    const updatedExams = exams.map(ex =>
      ex.examId === selectedExam.examId ? updatedExam : ex
    );

    setExams(updatedExams);
    setSelectedExam(null);
    setNewDate('');
    setNewTime('');
    setNewLocation('');
    alert('Exam rescheduled successfully.');
  };

  return (
    <div className="reschedule-container">
      <h2>Reschedule Exam</h2>
      <div className="form-group">
        <label>Select Exam:</label>
        <select onChange={handleExamChange} value={selectedExam?.examId || ''}>
          <option value="">--Select an Exam--</option>
          {exams.map((exam) => (
            <option key={exam.examId} value={exam.examId}>
              {exam.subject} - {exam.date} at {exam.time}
            </option>
          ))}
        </select>
      </div>

      {selectedExam && (
        <>
          <div className="form-group">
            <label>New Date:</label>
            <input
              type="date"
              value={newDate}
              onChange={(e) => setNewDate(e.target.value)}
            />
          </div>
          <div className="form-group">
            <label>New Time:</label>
            <input
              type="time"
              value={newTime}
              onChange={(e) => setNewTime(e.target.value)}
            />
          </div>
          <div className="form-group">
            <label>New Location:</label>
            <input
              type="text"
              value={newLocation}
              onChange={(e) => setNewLocation(e.target.value)}
            />
          </div>
          <button onClick={handleReschedule}>Reschedule Exam</button>
        </>
      )}
    </div>
  );
};

export default Reschedule;
