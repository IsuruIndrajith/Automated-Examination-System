import React, { useState } from "react";
import "./LecturerNotify.css";
import NavbarLecturer from "../../components/NavbarLecturer";

const LecturerNotify = () => {
  const [emailRecipient, setEmailRecipient] = useState("all");
  const [customEmail, setCustomEmail] = useState("");
  const [emailSubject, setEmailSubject] = useState("");
  const [emailMessage, setEmailMessage] = useState("");
  const [error, setError] = useState("");

  const handleSendEmail = () => {
    if (!emailSubject || !emailMessage) {
      setError("Please fill in all fields before sending.");
      return;
    }

    if (emailRecipient === "individual" && !customEmail) {
      setError("Please enter the student's email address.");
      return;
    }

    setError("");
    const recipient = emailRecipient === "all" ? "All Students" : customEmail;

    alert(`Notification Sent To: ${recipient}\nSubject: ${emailSubject}\nMessage: ${emailMessage}`);
    
    // Replace with API request to send email
  };

  return (
    <>
    <NavbarLecturer/>
    <h2 className="notify-title">Send Notifications</h2>
    <div className="notify-container">
      {error && <p className="error-message">{error}</p>}

      {/* Select recipient type */}
      <div className="form-group">
        <label>Send To:</label>
        <select value={emailRecipient} onChange={(e) => setEmailRecipient(e.target.value)}>
          <option value="all">All Students</option>
          <option value="individual">Individual Student</option>
        </select>
      </div>

      {/* Individual student email input */}
      {emailRecipient === "individual" && (
        <div className="form-group">
          <label>Student Email:</label>
          <input
            type="email"
            placeholder="Enter student email..."
            value={customEmail}
            onChange={(e) => setCustomEmail(e.target.value)}
          />
        </div>
      )}

      {/* Email subject */}
      <div className="form-group">
        <label>Subject:</label>
        <input
          type="text"
          placeholder="Enter email subject..."
          value={emailSubject}
          onChange={(e) => setEmailSubject(e.target.value)}
        />
      </div>

      {/* Email message */}
      <div className="form-group">
        <label>Message:</label>
        <textarea
          rows="5"
          placeholder="Write your message here..."
          value={emailMessage}
          onChange={(e) => setEmailMessage(e.target.value)}
        ></textarea>
      </div>

      {/* Send button */}
      <button className="send-btn" onClick={handleSendEmail}>
        Send Notification
      </button>
    </div>
    </>
  );
};

export default LecturerNotify;
