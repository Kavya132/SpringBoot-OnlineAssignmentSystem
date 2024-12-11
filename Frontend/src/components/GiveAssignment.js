import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios'; // Import axios for making HTTP requests

const GiveAssignment = () => {
    const [assignmentId, setAssignmentId] = useState('');
    const [assignmentTitle, setAssignmentTitle] = useState('');
    const [description, setDescription] = useState('');
    const [dueDate, setDueDate] = useState('');
    const navigate = useNavigate();

    // Handle form submission
    const handleAssignment = async (event) => {
        event.preventDefault(); // Prevent form submission

        // Create the assignment data object
        const assignmentData = {
            assignmentId,
            assignmentTitle,
            description,
            dueDate,
        };

        try {
            // Make a POST request to your backend API (replace with actual URL)
            await axios.post('http://localhost:8080/api/assignments', assignmentData);
            alert("Assignment given successfully!");
            navigate('/FacultyDashboard'); // Redirect to faculty dashboard after submission
        } catch (error) {
            console.error("Error giving assignment:", error);
            alert("There was an error giving the assignment.");
        }
    };

    return (
        <div style={styles.body}>
            <header style={styles.header}>
                <h1 style={styles.headerTitle}>Give Assignment</h1>
                <nav>
                    <ul style={styles.navList}>
                        <li style={styles.navItem}>
                            <a href="/FacultyDashboard" style={styles.navLink}>Back to Dashboard</a>
                        </li>
                    </ul>
                </nav>
            </header>

            <section style={styles.assignmentContainer}>
                <h2 style={styles.assignmentTitle}>Assign a New Assignment</h2>
                <form id="give-assignment-form" onSubmit={handleAssignment} style={styles.form}>
                    <label htmlFor="assignment-id" style={styles.label}>Assignment ID:</label>
                    <input 
                        type="text" 
                        id="assignment-id" 
                        value={assignmentId} 
                        onChange={(e) => setAssignmentId(e.target.value)} 
                        placeholder="Enter assignment ID" 
                        required 
                        style={styles.input} 
                    />

                    <label htmlFor="assignment-title" style={styles.label}>Assignment Title:</label>
                    <input 
                        type="text" 
                        id="assignment-title" 
                        value={assignmentTitle} 
                        onChange={(e) => setAssignmentTitle(e.target.value)} 
                        placeholder="Enter assignment title" 
                        required 
                        style={styles.input} 
                    />

                    <label htmlFor="assignment-description" style={styles.label}>Description:</label>
                    <textarea 
                        id="assignment-description" 
                        value={description} 
                        onChange={(e) => setDescription(e.target.value)} 
                        placeholder="Enter assignment description" 
                        required 
                        style={styles.textarea}
                    ></textarea>

                    <label htmlFor="due-date" style={styles.label}>Due Date:</label>
                    <input 
                        type="date" 
                        id="due-date" 
                        value={dueDate} 
                        onChange={(e) => setDueDate(e.target.value)} 
                        required 
                        style={styles.input} 
                    />

                    <button type="submit" style={styles.button}>Give Assignment</button>
                </form>
            </section>

            <footer style={styles.footer}>
                <p>&copy; 2024 Online Assignment Submission & Grading System</p>
            </footer>
        </div>
    );
};

// Styles for the component
const styles = {
    body: {
        fontFamily: 'Arial, sans-serif',
        backgroundColor: '#e0f7fa',
        color: '#333',
        lineHeight: 1.6,
        margin: 0,
        padding: 0
    },
    header: {
        backgroundColor: '#00796b',
        padding: '20px',
        textAlign: 'center',
        color: 'white'
    },
    headerTitle: {
        margin: 0
    },
    navList: {
        listStyle: 'none',
        padding: 0,
        textAlign: 'center',
        margin: '10px 0'
    },
    navItem: {
        display: 'inline-block',
        marginRight: '20px'
    },
    navLink: {
        color: 'white',
        textDecoration: 'none',
        fontWeight: 'bold',
        fontSize: '16px'
    },
    assignmentContainer: {
        backgroundColor: 'white',
        width: '90%',
        maxWidth: '600px',
        margin: '40px auto',
        padding: '20px',
        borderRadius: '8px',
        boxShadow: '0 0 15px rgba(0, 0, 0, 0.1)',
        textAlign: 'center'
    },
    assignmentTitle: {
        color: '#4caf9b',
        marginBottom: '20px'
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        textAlign: 'left'
    },
    label: {
        marginBottom: '5px',
        fontWeight: 'bold'
    },
    input: {
        padding: '10px',
        marginBottom: '15px',
        border: '1px solid #ccc',
        borderRadius: '5px',
        fontSize: '16px',
        width: '100%'
    },
    textarea: {
        padding: '10px',
        marginBottom: '15px',
        border: '1px solid #ccc',
        borderRadius: '5px',
        fontSize: '16px',
        width: '100%',
        height: '150px',
        resize: 'vertical'
    },
    button: {
        padding: '10px',
        backgroundColor: '#4caf9b',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        fontSize: '18px',
        cursor: 'pointer',
        transition: 'background-color 0.3s'
    },
    buttonHover: {
        backgroundColor: '#45a095'
    },
    footer: {
        textAlign: 'center',
        backgroundColor: '#333',
        color: 'white',
        padding: '10px',
        position: 'fixed',
        bottom: 0,
        width: '100%'
    }
};

export default GiveAssignment;
