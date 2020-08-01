import React from 'react';
import 'bootstrap/dist/css/bootstrap.css'
import './App.css';
import {BrowserRouter} from 'react-router-dom';
import Main from './components/MainComponent' 

function App() {
  return (
    <BrowserRouter>
      <div>
        <Main />
      </div>
    </BrowserRouter>
  );
}

export default App;
