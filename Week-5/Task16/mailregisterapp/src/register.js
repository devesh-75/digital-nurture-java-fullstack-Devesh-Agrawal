import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: 'ADITYA',
      email: '',
      password: 'ay5155',
      errors: {}
    };
    this.handleNameChange = this.handleNameChange.bind(this);
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleNameChange(event) {
    this.setState({ name: event.target.value });
  }

  handleEmailChange(event) {
    this.setState({ email: event.target.value });
  }

  handlePasswordChange(event) {
    this.setState({ password: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const errors = {};
    const { name, email, password } = this.state;

    if (name.length < 5) {
      errors.name = 'Name should have atleast 5 characters';
    }

    if (!email.includes('@') || !email.includes('.')) {
      errors.email = 'Email should contain @ and .';
    }

    if (password.length < 8) {
      errors.password = 'Password should have atleast 8 characters';
    }

    this.setState({ errors });

    if (Object.keys(errors).length === 0) {
      alert('Registration successful');
    }
  }

  render() {
    const { name, email, password, errors } = this.state;
    return (
      <form onSubmit={this.handleSubmit}>
        <div>
          <label>Name</label>
          <input type="text" value={name} onChange={this.handleNameChange} />
          {errors.name && <span>{errors.name}</span>}
        </div>
        <div>
          <label>Email</label>
          <input type="text" value={email} onChange={this.handleEmailChange} />
          {errors.email && <span>{errors.email}</span>}
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            value={password}
            onChange={this.handlePasswordChange}
          />
          {errors.password && <span>{errors.password}</span>}
        </div>
        <button type="submit">Register</button>
      </form>
    );
  }
}

export default Register;
