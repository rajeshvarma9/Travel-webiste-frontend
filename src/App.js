import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import NavigationHome from './layout/NavigationHome';
import AddUser from './Users/AddUser';
import LoginPage from './Users/LoginPage';


function App() {
  return (
    <div className='TRAVEL EASY'>
      <Router>
        <NavigationHome />
        <Routes>
          <Route exact path="/register" element={<AddUser />} />
          <Route exact path="/loginuser" element={<LoginPage />} />
          <Route exact path="/" element={<LoginPage />} />
        </Routes>
      </Router>

    </div>

  );
}

export default App;