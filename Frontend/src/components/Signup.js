import React, { useState } from 'react';

const Signup = () => {
    const [formData, setFormData] = useState({
        username: '',
        role: 'student',
        password: '',
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:2005/api/users/signup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                alert('Sign-up successful!');
                window.location.href = '/login'; // Redirect to login
            } else {
                alert('Sign-up failed. Please try again.');
            }
        } catch (error) {
            console.error('Error during sign-up:', error);
        }
    };

    return (
        <div style={styles.container}>
            <h2>Sign Up</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    value={formData.username}
                    onChange={handleChange}
                    required
                    style={styles.input}
                />
                <select
                    name="role"
                    value={formData.role}
                    onChange={handleChange}
                    style={styles.input}
                >
                    <option value="student">Student</option>
                    <option value="faculty">Faculty</option>
                </select>
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={formData.password}
                    onChange={handleChange}
                    required
                    style={styles.input}
                />
                <button type="submit" style={styles.button}>Sign Up</button>
            </form>
        </div>
    );
};

const styles = {
    container: {
        width: '300px',
        margin: '50px auto',
        padding: '20px',
        textAlign: 'center',
        border: '1px solid #ccc',
        borderRadius: '10px',
        boxShadow: '0 4px 8px rgba(0,0,0,0.1)',
    },
    input: {
        width: '100%',
        padding: '10px',
        margin: '10px 0',
        borderRadius: '5px',
        border: '1px solid #ddd',
    },
    button: {
        padding: '10px',
        backgroundColor: '#4caf50',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
    },
};

export default Signup;