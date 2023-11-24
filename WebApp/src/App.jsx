import './App.css'
import { Router, Route, Routes } from 'react-router-dom';
import Dashboard from './components/Dashboard';
import HeaderComponent from './components/Header';
import Profile from './components/Profile';

function App() {

  return (
    <div className="App">
      <Router>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </Router>
    </div>
  )
}

export default App
