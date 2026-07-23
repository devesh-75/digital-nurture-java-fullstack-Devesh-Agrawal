import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

export function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div style={{ border: '1px solid #ccc', padding: '15px', margin: '10px', borderRadius: '8px', width: '250px', display: 'inline-block' }}>
      <h3>{employee.name}</h3>
      <p>Position: {employee.position}</p>
      <p>Department: {employee.department}</p>
      <button className={theme} style={{ padding: '8px 16px', cursor: 'pointer' }}>
        View Details ({theme})
      </button>
    </div>
  );
}

export default EmployeeCard;
