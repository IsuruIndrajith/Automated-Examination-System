import React, { useState } from "react";
import "./StudentNotes.css";
import Navbar from "../components/Navbar";

const StudentNotes = () => {
  const [notes, setNotes] = useState([]);
  const [newNote, setNewNote] = useState("");
  const [selectedSubject, setSelectedSubject] = useState("");

  const subjects = ["Math", "Science", "History", "English", "Computer Science"];

  const addNote = () => {
    if (!newNote.trim() || !selectedSubject) return;
    setNotes([...notes, { subject: selectedSubject, content: newNote }]);
    setNewNote("");
  };

  return (
    <>
      <Navbar />
      <div className="student-notes-container">
        <h2>My Notes</h2>
        <div className="note-input-section">
        <div>
              <select value={selectedSubject} onChange={(e) => setSelectedSubject(e.target.value)}>
                <option value="">Select Subject</option>
                {subjects.map((sub, index) => (
                  <option key={index} value={sub}>{sub}</option>
                ))}
              </select>
              <textarea
                placeholder="Write your note here..."
                value={newNote}
                onChange={(e) => setNewNote(e.target.value)}
              ></textarea>
              <button onClick={addNote}>+ Create</button>
        </div>
        </div> 
        <div className="notes-list">
          {notes.length > 0 ? (
            subjects.map((sub, index) => (
              <div key={index} className="subject-notes">
                <h3>{sub}</h3>
                {notes.filter(note => note.subject === sub).map((note, i) => (
                  <div key={i} className="note-card">{note.content}</div>
                ))}
              </div>
            ))
          ) : (
            <p>No notes added yet.</p>
          )}
        </div>
      </div>
    </>
  );
};

export default StudentNotes;
