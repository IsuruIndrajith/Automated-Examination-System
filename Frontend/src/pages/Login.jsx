import { useState, useEffect, useContext } from "react";
import { useNavigate } from "react-router-dom";
import "./login.css";
import { UserContext } from "../components/userContext";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [users, setUsers] = useState([]);
  const [errors, setErrors] = useState("");
  const navigate = useNavigate();
  const { setUser } = useContext(UserContext);

  useEffect(() => {
    fetch("/users.json")
      .then((res) => res.json())
      .then((data) => {
        setUsers(data.users);
        console.log("Fetched Users: ", data.users);
      })
      .catch((err) => console.error("Error in fetching users: ", err));
  }, []);

  const handleLogin = (e) => {
    e.preventDefault();

    if (!email || !password) {
      setErrors("Please enter both email and password");
      return;
    }
    console.log("Checking credentials for:", email, password);

    const user = users.find(
      (u) => u.email.toLowerCase() === email.toLowerCase() && u.password === password
    );

    if (user) {
      setUser(user);
      localStorage.setItem("user", JSON.stringify(user));
      console.log("Login Successful!", user);

      switch (user.role) {
        case "student":
          navigate("/student");
          break;
        case "lecturer":
          navigate("/lecturer");
          break;
        case "admin":
          navigate("/admin");
          break;
        default:
          setErrors("Invalid role detected!");
      }
    } else {
      console.log("Invalid credentials");
      setErrors("Invalid email or password");
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h1 className="login-title">AUTOMATED EXAMINER LOGIN</h1>
        <form onSubmit={handleLogin}>
          <div className="user-email">
            <label>USER EMAIL</label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="user-password">
          <label>USER PASSWORD</label>
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
