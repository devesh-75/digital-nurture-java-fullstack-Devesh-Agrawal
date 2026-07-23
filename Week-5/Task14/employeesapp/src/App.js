import React, { Component } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      theme: 'dark',
      employees: [
        { id: 1, name: 'John Doe', position: 'Software Engineer', department: 'IT' },
        { id: 2, name: 'Jane Smith', position: 'Project Manager', department: 'Operations' },
        { id: 3, name: 'Alex Johnson', position: 'UI/UX Designer', department: 'Design' }
      ]
    };
  }

  toggleTheme = () => {
    this.setState(prevState => ({
      theme: prevState.theme === 'light' ? 'dark' : 'light'
    }));
  };

  render() {
    return (
      <ThemeContext.Provider value={this.state.theme}>
        <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
          <h1>Employees List</h1>
          <button onClick={this.toggleTheme} style={{ marginBottom: '20px', padding: '8px 16px' }}>
            Toggle Theme ({this.state.theme})
          </button>
          <EmployeesList employees={this.state.employees} />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;
