import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { signInWithGoogle, signInWithFacebook } from "../firebase";
import "./Login.css"; // Import CSS file

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    if (email === "admin@example.com" && password === "password") {
      alert("Login successful!");
      navigate("/home");
    } else {
      alert("Invalid credentials!");
    }
  };

  const handleGoogleLogin = async () => {
    try {
      await signInWithGoogle();
      alert("Google login successful!");
      navigate("/home");
    } catch (error) {
      alert(error.message);
    }
  };

  const handleFacebookLogin = async () => {
    try {
      await signInWithFacebook();
      alert("Facebook login successful!");
      navigate("/home");
    } catch (error) {
      alert(error.message);
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>AUTOMATED EXAMINATION SYSTEM - LOGIN</h2>
        <form onSubmit={handleLogin}>
          <label htmlFor="email">USER NAME / USER EMAIL</label>
          <input
            id="email"
            type="email"
            placeholder="Enter email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <label htmlFor="password">PASSWORD</label>
          <input
            id="password"
            type="password"
            placeholder="Enter password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit" className="login-button">LOGIN</button>
        </form>

        <p>Or continue with</p>

        <button onClick={handleFacebookLogin} className="social-button facebook-button">
          <img src="https://upload.wikimedia.org/wikipedia/commons/5/51/Facebook_f_logo_%282019%29.svg" alt="Facebook" />
          Continue with Facebook
        </button>

        <button onClick={handleGoogleLogin} className="social-button google-button">
          <img src="https://upload.wikimedia.org/wikipedia/commons/0/09/IOS_Google_icon.png" alt="Google" />
          Continue with Google
        </button>
      </div>
    </div>
  );
};

export default Login;
