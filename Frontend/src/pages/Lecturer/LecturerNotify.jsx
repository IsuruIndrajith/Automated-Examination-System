import React, { useState } from "react";
import emailjs from "emailjs-com";
import "./LecturerNotify.css";
import NavbarLecturer from "../../components/NavbarLecturer";

// Initialize EmailJS with your User ID (Public Key)
emailjs.init("8OQU0P-Oa-0BEAkRO");

const LecturerNotify = () => {
  // State variables for form inputs and error messages
  const [emailRecipient, setEmailRecipient] = useState("all");
  const [customEmail, setCustomEmail] = useState("");
  const [emailSubject, setEmailSubject] = useState("");
  const [emailMessage, setEmailMessage] = useState("");
  const [error, setError] = useState("");

  // Function to send emails using EmailJS
  const sendEmail = (recipientEmail, subject, message) => {
    const templateParams = {
      to_email: recipientEmail,
      subject: subject,
      message: message,
    };

    emailjs
    .send("AutomatedExaminer", "template_q0n7qtn", templateParams)
      .then(
        (response) => {
          console.log("Email successfully sent!", response.status, response.text);
          alert("Email successfully sent!");
        },
        (error) => {
          console.error("Failed to send email:", error);
          alert("Failed to send email. Please try again.");
        }
      );
  };

  // Handle the email submission
  const handleSendEmail = () => {
    // Basic validation for required fields
    if (!emailSubject || !emailMessage) {
      setError("Please fill in both the subject and message fields before sending.");
      return;
    }

    // If sending to an individual, ensure the email field is not empty
    if (emailRecipient === "individual" && !customEmail) {
      setError("Please enter the student's email address.");
      return;
    }

    setError(""); // Clear any existing errors
    const recipientEmail =
      emailRecipient === "all" ? "all_students@example.com" : customEmail;

    // Call the sendEmail function with provided input
    sendEmail(recipientEmail, emailSubject, emailMessage);
  };

  return (
    <>
      <NavbarLecturer />
      <h2 className="notify-title">Send Notifications</h2>
      <div className="notify-container">
        {error && <p className="error-message">{error}</p>}

        <div className="form-group">
          <label>Send To:</label>
          <select
            value={emailRecipient}
            onChange={(e) => setEmailRecipient(e.target.value)}
          >
            <option value="all">All Students</option>
            <option value="individual">Individual Student</option>
          </select>
        </div>

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

        <div className="form-group">
          <label>Subject:</label>
          <input
            type="text"
            placeholder="Enter email subject..."
            value={emailSubject}
            onChange={(e) => setEmailSubject(e.target.value)}
          />
        </div>

        <div className="form-group">
          <label>Message:</label>
          <textarea
            rows="5"
            placeholder="Write your message here..."
            value={emailMessage}
            onChange={(e) => setEmailMessage(e.target.value)}
          ></textarea>
        </div>

        <button className="send-btn" onClick={handleSendEmail}>
          Send Notification
        </button>
      </div>
    </>
  );
};

export default LecturerNotify;
