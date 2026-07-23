import React from 'react';
import CohortDetails from './CohortDetails';
import CohortData from './Cohort';

function App() {
  return (
    <div>
      {CohortData.map((cohort) => (
        <CohortDetails key={cohort.cohortCode} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
