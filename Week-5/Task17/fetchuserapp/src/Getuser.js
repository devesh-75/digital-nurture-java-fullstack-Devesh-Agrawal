import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: '',
      firstName: '',
      picture: ''
    };
  }

  componentDidMount() {
    fetch('https://api.randomuser.me/')
      .then((response) => response.json())
      .then((data) => {
        const user = data.results[0];
        this.setState({
          title: user.name.title,
          firstName: user.name.first,
          picture: user.picture.large
        });
      });
  }

  render() {
    return (
      <div>
        <h2>
          {this.state.title} {this.state.firstName}
        </h2>
        {this.state.picture && <img src={this.state.picture} alt="user" />}
      </div>
    );
  }
}

export default Getuser;
