import React from 'react';
import Recieve from './Recieve';
import Send from './Send';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './components/Login';
import Register from './components/Register';
import Dashboard from './components/Dashboard';
const App = () => {

  return (
    <div className='App'>
      <BrowserRouter>
        <Routes>
          <Route path="recieve" element={<Recieve />} />
          <Route path="" element={<Login />} />
          <Route path="send" element={<Send />} />
          <Route path="register" element={<Register />} />
          <Route path="home" element={<Dashboard />} />

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;