import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from 'react-router-dom';
import Login from './pages/Login';
import StudentHomepage from './pages/StudentHomePage';

const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route path="/" element={<Login />} />
      <Route path="/student" element={<StudentHomepage />} />
    </>
  )
);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
