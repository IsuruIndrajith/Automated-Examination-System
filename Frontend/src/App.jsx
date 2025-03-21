import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from 'react-router-dom';
import Login from './pages/Login';
import StudentHomepage from './pages/StudentHomePage';
import AdminHome from './pages/AdminHome';
<<<<<<< HEAD
=======

>>>>>>> 97396686aa32552f05488ed25f526f48d153d683
const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route path="/" element={<Login />} />
      <Route path="/student" element={<StudentHomepage />} />
      <Route path="/admin" element={<AdminHome />} />
    </>
  )
);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
