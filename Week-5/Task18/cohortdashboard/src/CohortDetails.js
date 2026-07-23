import React, { Component } from 'react';

class CohortDetails extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cohort: this.props.cohort
    };
  }

  render() {
    const { cohort } = this.state;
    return (
      <div>
        <h3>{cohort.cohortCode}</h3>
        <p>{cohort.cohortName}</p>
        <p>{cohort.startDate}</p>
        <p>{cohort.endDate}</p>
        <p>{cohort.status}</p>
      </div>
    );
  }
}

export default CohortDetails;
