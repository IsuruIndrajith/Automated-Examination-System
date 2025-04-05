import React from "react";
import { GiMechanicGarage } from "react-icons/gi";

const Department = ({ onDepartmentSelect, onSemesterSelect, onLecturerSelect, onStudentSelect }) => {
  return (
    <div className="department-container">
      <h2 className="title">SELECT DEPARTMENT</h2>
      <div className="department-buttons">
        <button onClick={() => onDepartmentSelect("Electrical & Electronics Engineering")}>
          ELECTRICAL & ELECTRONICS ENGINEERING
        </button>
        <button onClick={() => onDepartmentSelect("Computer Engineering")}>
          COMPUTER ENGINEERING
        </button>
        <button onClick={() => onDepartmentSelect("Civil Engineering")}>
          CIVIL ENGINEERING
        </button>
        <button onClick={() => onDepartmentSelect("Mechanical Engineering")}>
          <GiMechanicGarage size={30} color="black" style={{ marginRight: "10px" }} />
          MECHANICAL ENGINEERING
        </button>
      </div>

      <h2 className="title">SELECT SEMESTER</h2>
      <div className="semester-buttons">
        <button onClick={() => onSemesterSelect("Semester 1")}>SEMESTER 1</button>
        <button onClick={() => onSemesterSelect("Semester 2")}>SEMESTER 2</button>
        <button onClick={() => onSemesterSelect("Semester 3")}>SEMESTER 3</button>
        <button onClick={() => onSemesterSelect("Semester 4")}>SEMESTER 4</button>
        <button onClick={() => onSemesterSelect("Semester 5")}>SEMESTER 5</button>
        <button onClick={() => onSemesterSelect("Semester 6")}>SEMESTER 6</button>
        <button onClick={() => onSemesterSelect("Semester 7")}>SEMESTER 7</button>
        <button onClick={() => onSemesterSelect("Semester 8")}>SEMESTER 8</button>
      </div>

      {/* Lecturer Section */}
      <h2 className="title">SELECT LECTURER</h2>
      <div className="lecturer-buttons">
        <button onClick={() => onLecturerSelect("Dr. John Smith")}>
          Dr. John Smith
        </button>
        <button onClick={() => onLecturerSelect("Prof. Jane Doe")}>
          Prof. Jane Doe
        </button>
        <button onClick={() => onLecturerSelect("Dr. Emily Davis")}>
          Dr. Emily Davis
        </button>
        <button onClick={() => onLecturerSelect("Dr. Michael Brown")}>
          Dr. Michael Brown
        </button>
      </div>

      {/* Student Section */}
      <h2 className="title">SELECT STUDENT</h2>
      <div className="student-buttons">
        <button onClick={() => onStudentSelect("Student A")}>Student A</button>
        <button onClick={() => onStudentSelect("Student B")}>Student B</button>
        <button onClick={() => onStudentSelect("Student C")}>Student C</button>
        <button onClick={() => onStudentSelect("Student D")}>Student D</button>
      </div>

      {/* CSS for styling */}
      <style>{`
        .department-container {
          text-align: center;
          padding: 20px;
          background: linear-gradient(to bottom, #eef2f3, #cfd9df);
          border-radius: 8px;
          max-width: 600px;
          margin: auto;
          box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        .title {
          font-size: 18px;
          font-weight: bold;
          margin-bottom: 10px;
        }

        .department-buttons, .semester-buttons, .lecturer-buttons, .student-buttons {
          display: flex;
          flex-wrap: wrap;
          justify-content: center;
          gap: 10px;
          margin-bottom: 20px;
        }

        button {
          padding: 10px 15px;
          border: none;
          background: #007bff;
          color: white;
          font-weight: bold;
          cursor: pointer;
          border-radius: 5px;
          transition: background 0.3s ease;
          min-width: 150px;
          text-transform: uppercase;
          display: flex;
          align-items: center;
          justify-content: center;
        }

        button svg {
          margin-right: 10px; /* Adds space between the icon and the text */
        }

        button:hover {
          background: #0056b3;
        }
      `}</style>
    </div>
  );
};

export default Department;
