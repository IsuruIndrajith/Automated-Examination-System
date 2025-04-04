import React, { useState } from 'react';
import NavbarAdminHome from '../../components/NavbarAdminHome';

function Manage() {
  const [viewMode, setViewMode] = useState('default'); // 'default', 'students', 'lecturers'
  const [students, setStudents] = useState([]); // Stores student data as JSON objects
  const [lecturers, setLecturers] = useState([]); // Stores lecturer data as JSON objects
  const [newStudent, setNewStudent] = useState({
    id: '',
    fullName: '',
    nic: '',
    nationality: '',
    photoLink: '',
    address: '',
    gender: '',
    phoneNo: '',
    password: '',
    username: '',
    departmentId: '',
    lecturerId: '',
  });
  const [newLecturer, setNewLecturer] = useState({
    id: '',
    fullName: '',
    department: '',
    email: '',
    username: '',
    password: '',
    nic: '',
    phoneNo: '',
  });

  // Add a new student
  const handleAddStudent = () => {
    const {
      id,
      fullName,
      nic,
      nationality,
      photoLink,
      address,
      gender,
      phoneNo,
      password,
      username,
      departmentId,
      lecturerId,
    } = newStudent;

    if (
      id &&
      fullName &&
      nic &&
      nationality &&
      photoLink &&
      address &&
      gender &&
      phoneNo &&
      password &&
      username &&
      departmentId &&
      lecturerId
    ) {
      const studentJson = {
        id,
        fullName,
        nic,
        nationality,
        photoLink,
        address,
        gender,
        phoneNo,
        password,
        username,
        departmentId,
        lecturerId,
      };

      setStudents([...students, studentJson]); // Add the JSON object to the students array
      setNewStudent({
        id: '',
        fullName: '',
        nic: '',
        nationality: '',
        photoLink: '',
        address: '',
        gender: '',
        phoneNo: '',
        password: '',
        username: '',
        departmentId: '',
        lecturerId: '',
      });
    } else {
      alert('Please fill in all fields.');
    }
  };

  // Add a new lecturer
  const handleAddLecturer = () => {
    const { id, fullName, department, email, username, password, nic, phoneNo } = newLecturer;

    if (id && fullName && department && email && username && password && nic && phoneNo) {
      const lecturerJson = {
        id,
        fullName,
        department,
        email,
        username,
        password,
        nic,
        phoneNo,
      };

      setLecturers([...lecturers, lecturerJson]); // Add the JSON object to the lecturers array
      setNewLecturer({
        id: '',
        fullName: '',
        department: '',
        email: '',
        username: '',
        password: '',
        nic: '',
        phoneNo: '',
      });
    } else {
      alert('Please fill in all fields.');
    }
  };

  // Remove a student
  const handleRemoveStudent = (index) => {
    const updatedStudents = students.filter((_, i) => i !== index);
    setStudents(updatedStudents);
  };

  // Remove a lecturer
  const handleRemoveLecturer = (index) => {
    const updatedLecturers = lecturers.filter((_, i) => i !== index);
    setLecturers(updatedLecturers);
  };

  return (
    <>
      <NavbarAdminHome />
      <div style={styles.container}>
        <h1 style={styles.heading}>Manage Students and Lecturers</h1>

        {/* Default View */}
        {viewMode === 'default' && (
          <div style={styles.content}>
            <button style={styles.button} onClick={() => setViewMode('students')}>
              Manage Students
            </button>
            <button style={styles.button} onClick={() => setViewMode('lecturers')}>
              Manage Lecturers
            </button>
          </div>
        )}

        {/* Manage Students */}
        {viewMode === 'students' && (
          <div>
            <h2 style={styles.subHeading}>Manage Students</h2>
            <div style={styles.form}>
              <input
                type="text"
                placeholder="Student ID"
                value={newStudent.id}
                onChange={(e) => setNewStudent({ ...newStudent, id: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Full Name"
                value={newStudent.fullName}
                onChange={(e) => setNewStudent({ ...newStudent, fullName: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="NIC"
                value={newStudent.nic}
                onChange={(e) => setNewStudent({ ...newStudent, nic: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Nationality"
                value={newStudent.nationality}
                onChange={(e) => setNewStudent({ ...newStudent, nationality: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Photo Link"
                value={newStudent.photoLink}
                onChange={(e) => setNewStudent({ ...newStudent, photoLink: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Address"
                value={newStudent.address}
                onChange={(e) => setNewStudent({ ...newStudent, address: e.target.value })}
                style={styles.input}
              />
              <select
                value={newStudent.gender}
                onChange={(e) => setNewStudent({ ...newStudent, gender: e.target.value })}
                style={styles.input}
              >
                <option value="">Select Gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </select>
              <input
                type="text"
                placeholder="Phone Number"
                value={newStudent.phoneNo}
                onChange={(e) => setNewStudent({ ...newStudent, phoneNo: e.target.value })}
                style={styles.input}
              />
              <input
                type="password"
                placeholder="Password"
                value={newStudent.password}
                onChange={(e) => setNewStudent({ ...newStudent, password: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Username"
                value={newStudent.username}
                onChange={(e) => setNewStudent({ ...newStudent, username: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Department ID"
                value={newStudent.departmentId}
                onChange={(e) => setNewStudent({ ...newStudent, departmentId: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Lecturer ID"
                value={newStudent.lecturerId}
                onChange={(e) => setNewStudent({ ...newStudent, lecturerId: e.target.value })}
                style={styles.input}
              />
              <button style={styles.button} onClick={handleAddStudent}>
                Add Student
              </button>
            </div>
            <ul style={styles.list}>
              {students.map((student, index) => (
                <li key={index} style={styles.listItem}>
                  <p>
                    <strong>ID:</strong> {student.id} | <strong>Full Name:</strong> {student.fullName} |{' '}
                    <strong>NIC:</strong> {student.nic} | <strong>Nationality:</strong> {student.nationality} |{' '}
                    <strong>Address:</strong> {student.address} | <strong>Gender:</strong> {student.gender} |{' '}
                    <strong>Phone No:</strong> {student.phoneNo} | <strong>Username:</strong> {student.username} |{' '}
                    <strong>Department ID:</strong> {student.departmentId} |{' '}
                    <strong>Lecturer ID:</strong> {student.lecturerId}
                  </p>
                  <button style={styles.deleteButton} onClick={() => handleRemoveStudent(index)}>
                    Remove
                  </button>
                </li>
              ))}
            </ul>
            <button style={styles.button} onClick={() => setViewMode('default')}>
              Back
            </button>
          </div>
        )}

        {/* Manage Lecturers */}
        {viewMode === 'lecturers' && (
          <div>
            <h2 style={styles.subHeading}>Manage Lecturers</h2>
            <div style={styles.form}>
              <input
                type="text"
                placeholder="Lecturer ID"
                value={newLecturer.id}
                onChange={(e) => setNewLecturer({ ...newLecturer, id: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Full Name"
                value={newLecturer.fullName}
                onChange={(e) => setNewLecturer({ ...newLecturer, fullName: e.target.value })}
                style={styles.input}
              />
              <select
                value={newLecturer.department}
                onChange={(e) => setNewLecturer({ ...newLecturer, department: e.target.value })}
                style={styles.input}
              >
                <option value="">Select Department</option>
                <option value="Computer">Computer</option>
                <option value="Electrical">Electrical</option>
                <option value="Mechanical">Mechanical</option>
                <option value="Civil">Civil</option>
              </select>
              <input
                type="email"
                placeholder="Email"
                value={newLecturer.email}
                onChange={(e) => setNewLecturer({ ...newLecturer, email: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Username"
                value={newLecturer.username}
                onChange={(e) => setNewLecturer({ ...newLecturer, username: e.target.value })}
                style={styles.input}
              />
              <input
                type="password"
                placeholder="Password"
                value={newLecturer.password}
                onChange={(e) => setNewLecturer({ ...newLecturer, password: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="NIC"
                value={newLecturer.nic}
                onChange={(e) => setNewLecturer({ ...newLecturer, nic: e.target.value })}
                style={styles.input}
              />
              <input
                type="text"
                placeholder="Phone Number"
                value={newLecturer.phoneNo}
                onChange={(e) => setNewLecturer({ ...newLecturer, phoneNo: e.target.value })}
                style={styles.input}
              />
              <button style={styles.button} onClick={handleAddLecturer}>
                Add Lecturer
              </button>
            </div>
            <ul style={styles.list}>
              {lecturers.map((lecturer, index) => (
                <li key={index} style={styles.listItem}>
                  <p>
                    <strong>ID:</strong> {lecturer.id} | <strong>Full Name:</strong> {lecturer.fullName} |{' '}
                    <strong>Department:</strong> {lecturer.department} | <strong>Email:</strong> {lecturer.email} |{' '}
                    <strong>Username:</strong> {lecturer.username} | <strong>NIC:</strong> {lecturer.nic} |{' '}
                    <strong>Phone No:</strong> {lecturer.phoneNo}
                  </p>
                  <button style={styles.deleteButton} onClick={() => handleRemoveLecturer(index)}>
                    Remove
                  </button>
                </li>
              ))}
            </ul>
            <button style={styles.button} onClick={() => setViewMode('default')}>
              Back
            </button>
          </div>
        )}
      </div>
    </>
  );
}

const styles = {
  container: {
    padding: '20px',
    textAlign: 'center',
    minHeight: '100vh',
  },
  heading: {
    fontSize: '2rem',
    color: '#333',
    marginBottom: '20px',
  },
  subHeading: {
    fontSize: '1.5rem',
    color: '#333',
    marginBottom: '15px',
  },
  content: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    gap: '15px',
  },
  form: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    gap: '10px',
    marginBottom: '20px',
  },
  input: {
    padding: '10px',
    fontSize: '1rem',
    width: '300px',
    border: '1px solid #ccc',
    borderRadius: '5px',
  },
  button: {
    padding: '10px 20px',
    fontSize: '1rem',
    color: '#fff',
    backgroundColor: '#007bff',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    transition: 'background-color 0.3s',
  },
  list: {
    listStyleType: 'none',
    padding: 0,
    marginTop: '20px',
  },
  listItem: {
    marginBottom: '10px',
    padding: '10px',
    borderBottom: '1px solid #ccc',
  },
  deleteButton: {
    padding: '5px 10px',
    fontSize: '0.9rem',
    color: '#fff',
    backgroundColor: '#dc3545',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    transition: 'background-color 0.3s',
  },
};

export default Manage;