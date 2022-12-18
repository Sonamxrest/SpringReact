import React from 'react';
import Recieve from './Recieve';
import Send from './Send';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './components/Login';
import Register from './components/Register';
import Nav from './components/Nav';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'
import UserList from './components/UserList';
const App = () => {

  return (
    <div className='App'>
      <BrowserRouter>
      <ToastContainer/>
        {localStorage.getItem('token') ? <Nav /> : <></>}
      <Routes>
          <Route path="recieve" element={<Recieve />} />
          <Route path="" element={<Login />} />
          <Route path="chat/:id" element={<Send />} />
          <Route path="users" element={<UserList />} />

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;