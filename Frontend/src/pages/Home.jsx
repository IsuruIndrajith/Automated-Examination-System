import { Button, Container, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  return (
    <Container maxWidth="sm">
      <Typography variant="h4" gutterBottom>
        Welcome to Home Page
      </Typography>
      <Button variant="contained" color="secondary" onClick={() => navigate("/login")}>
        Logout
      </Button>
    </Container>
  );
};

export default Home;
