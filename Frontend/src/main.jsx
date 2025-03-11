import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import App from "./App";
import Login from "./pages/Login";
import Home from "./pages/Home";
import StudentHome from "./pages/StudentHome";
import LecturerHome from "./pages/LecturerHome";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/student-home" element={<StudentHome />} />
        <Route path="/lecturer-home" element={<LecturerHome />} />
      </Routes>
    </Router>
  </React.StrictMode>
);
