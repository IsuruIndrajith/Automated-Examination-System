import React, { useState } from "react";
import "./Scomplains.css";
import Navbar from "../components/Navbar";

const Scomplains = () => {
  const [complaint, setComplaint] = useState({
    title: "",
    category: "",
    description: "",
    file: null,
  });

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setComplaint((prev) => ({ ...prev, [name]: value }));
  };

  // Handle file upload
  const handleFileChange = (e) => {
    setComplaint((prev) => ({ ...prev, file: e.target.files[0] }));
  };

  // Submit complaint
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Complaint Submitted:", complaint);

    // Code to send data to the database (commented for now)
    /*
    fetch("/api/complaints", {
      method: "POST",
      body: JSON.stringify(complaint),
      headers: { "Content-Type": "application/json" },
    })
      .then((res) => res.json())
      .then((data) => console.log("Complaint submitted successfully", data))
      .catch((err) => console.error("Error submitting complaint:", err));
    */
  };

  return (
    <>
      <Navbar />
      <div className="complaints-container">
        <h2 className="submit-head">Submit a Complaint</h2>
        <form onSubmit={handleSubmit} className="complaint-form">
          <label>Complaint Title</label>
          <input type="text" name="title" value={complaint.title} onChange={handleChange} required />

          <label>Category</label>
          <select name="category" value={complaint.category} onChange={handleChange} required>
            <option value="">Select Category</option>
            <option value="Lecturer">Lecturer</option>
            <option value="Lecture Time">Lecture Time</option>
            <option value="Syllabus">Syllabus</option>
            <option value="Other">Other</option>
          </select>

          <label>Description</label>
          <textarea name="description" value={complaint.description} onChange={handleChange} required />

          <label>Attach File (Optional)</label>
          <input type="file" onChange={handleFileChange} />

          <button type="submit">Submit Complaint</button>
        </form>
      </div>
    </>
  );
};

export default Scomplains;
