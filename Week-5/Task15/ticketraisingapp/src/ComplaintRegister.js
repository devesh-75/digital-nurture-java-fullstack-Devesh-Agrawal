import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeName: '',
      complaint: ''
    };
    this.handleNameChange = this.handleNameChange.bind(this);
    this.handleComplaintChange = this.handleComplaintChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleNameChange(event) {
    this.setState({ employeeName: event.target.value });
  }

  handleComplaintChange(event) {
    this.setState({ complaint: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const refNumber = Math.floor(100000 + Math.random() * 900000);
    alert(
      'Complaint registered successfully.\nEmployee Name: ' +
        this.state.employeeName +
        '\nReference Number: ' +
        refNumber
    );
    this.setState({ employeeName: '', complaint: '' });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div>
          <label>Employee Name</label>
          <input
            type="text"
            value={this.state.employeeName}
            onChange={this.handleNameChange}
          />
        </div>
        <div>
          <label>Complaint</label>
          <textarea
            value={this.state.complaint}
            onChange={this.handleComplaintChange}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    );
  }
}

export default ComplaintRegister;
