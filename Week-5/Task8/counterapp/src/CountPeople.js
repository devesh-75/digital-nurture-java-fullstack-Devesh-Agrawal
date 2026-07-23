import React, { Component } from 'react';
import './CountPeople.css';

export class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  UpdateEntry = () => {
    this.setState(prevState => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  UpdateExit = () => {
    this.setState(prevState => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div className="container">
        <div className="entry">
          <button className="btn" onClick={this.UpdateEntry}>Login</button>
          <span>{this.state.entrycount} People Entered!!!</span>
        </div>
        <div className="exit">
          <button className="btn" onClick={this.UpdateExit}>Exit</button>
          <span>{this.state.exitcount} People Left!!!</span>
        </div>
      </div>
    );
  }
}

export default CountPeople;
