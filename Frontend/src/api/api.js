import axios from 'axios';

const API = axios.create({
    baseURL: 'http://localhost:2005/api', // Your backend base URL
    headers: {
        'Content-Type': 'application/json', // Optional headers
    },
});

export default API;
