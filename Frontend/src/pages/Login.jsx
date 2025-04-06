import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import "./login.css";
import { UserContext } from "../components/userContext";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState("");
  const navigate = useNavigate();
  const { setUser } = useContext(UserContext);

  const BASE_URL = "http://10.102.18.163:8080";
  //const token = localStorage.getItem("token");

  const handleLogin = async (e) => {
    e.preventDefault();
  
    if (!username || !password) {
      setErrors("Please enter both username and password");
      return;
    }
  
    try {
      const response = await fetch(`${BASE_URL}/login`, {
        method: "POST",
        headers: {
          //"Authorization": `Bearer ${token}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, password }),
      });
  
      const text = await response.text();
      const data = text ? JSON.parse(text) : {};
  
      if (response.ok) {
        setUser(data);
        localStorage.setItem("user", JSON.stringify(data));
        localStorage.setItem("token", data.tocken);
        localStorage.setItem("role", data.role);
  
        console.log("Login Successful!", data);
        console.log("Role:", data.role);
  
        switch (data.role) {
          case "[ROLE_STUDENT]":
            navigate("/student");
            break;
          case "[ROLE_LECTURE]":
            navigate("/lecturer");
            break;
          case "[ROLE_AR]":
            navigate("/admin");
            break;
          default:
            setErrors("Invalid role detected!");
        }
      } else {
        setErrors(data.message || "Invalid username or password");
      }
    } catch (error) {
      console.error("Error in login:", error);
      setErrors("Something went wrong! Please try again.");
    }
  };
  

  return (
    <div className="login-container">
      <div className="login-box">
        <h1 className="login-title">AUTOMATED EXAMINER LOGIN</h1>
        <form onSubmit={handleLogin}>
          <div className="user-username">
            <label>USERNAME</label>
            <input
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>
          <div className="user-password">
            <label>PASSWORD</label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit" className="login-submit-btn">
            Login
          </button>
        </form>
        {errors && <p style={{ color: "red" }}>{errors}</p>}
      </div>
    </div>
  );
};

export default Login;
