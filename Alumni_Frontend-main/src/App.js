import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './component/Home';
import LoginPage from './component/LoginPage';
import EditProfile from './component/EditProfile';
import AddOrg from './component/AddOrg';
import UpdateOrgs from './component/UpdateOrgs';


const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginPage/>} />
        <Route path="/home" element={<Home/>} />
        <Route path="/editProfile" element={<EditProfile/>}/>
        <Route path="/addOrg" element={<AddOrg/>}/>
        <Route path="/editOrg" element={<UpdateOrgs/>}/>
      </Routes>
    </Router>
  );
};

export default App;
