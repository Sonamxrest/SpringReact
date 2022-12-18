import React from 'react';
import Recieve from './Recieve';
import Send from './Send';
import { BrowserRouter, Routes, Route, Router } from "react-router-dom";
import Login from './components/Login';
import Register from './components/Register';
import Nav from './components/Nav';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'
import UserList from './components/UserList';
import PrivateAuthRoute from './service/PrivateAuthRoute';
import PrivateDeAuthRoute from './service/PrivateDeAuthRoute';
const App = () => {

  return (
    <div className='App'>
      <BrowserRouter>
        <ToastContainer />
        {localStorage.getItem('token') ? <Nav /> : <></>}
        <Routes>
          <Route exact path='/' element={<PrivateDeAuthRoute auth={localStorage.getItem('token')} />}>
            <Route path="" element={<Login />} />
          </Route>
          <Route exact path='/' element={<PrivateAuthRoute auth={localStorage.getItem('token')} />}>
            <Route path="recieve" element={<Recieve />} />
            <Route path="chat/:id" element={<Send />} />
            <Route path="users" element={<UserList />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;