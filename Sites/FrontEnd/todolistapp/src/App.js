
import './App.css';
import React, {useState} from 'react';
import Todolist from './components/Todolist'
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Tabs from'@mui/material/Tabs';
import Tab from'@mui/material/Tab';

function App() {
  
  const [value, setValue] = useState('Home');

  const handleChange = (event, value) => {
    setValue(value);};

  return (
    <div className="App">
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6">Todo-list</Typography>
        </Toolbar>
      </AppBar>
    
    <Tabs value={value} onChange={handleChange}>
       <Tab value="Home"label="Home" />
       <Tab value="Todos"label="Todos" />
    </Tabs>
      {value === 'Home' && <div> <h2>Welcome to my Todo-list page!</h2></div>}
      {value === 'Todos' && <div><Todolist/></div>}   
   
    </div>
  );
}

export default App;
