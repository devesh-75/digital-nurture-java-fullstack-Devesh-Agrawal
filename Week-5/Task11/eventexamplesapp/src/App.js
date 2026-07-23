import React, { Component } from 'react';
import './App.css';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 5
    };
  }

  handleIncrement = () => {
    this.setState(prevState => ({ counter: prevState.counter + 1 }));
    this.sayHello();
  };

  sayHello = () => {
    alert("Hello! Member1");
  };

  handleDecrement = () => {
    this.setState(prevState => ({ counter: prevState.counter - 1 }));
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  handleClickOnMe = (e) => {
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ padding: '30px', fontFamily: 'Arial, sans-serif' }}>
        <div style={{ marginBottom: '10px' }}>{this.state.counter}</div>
        <div style={{ display: 'flex', flexDirection: 'column', width: '120px', gap: '5px', marginBottom: '30px' }}>
          <button onClick={this.handleIncrement}>Increment</button>
          <button onClick={this.handleDecrement}>Decrement</button>
          <button onClick={() => this.sayWelcome('welcome')}>Say welcome</button>
          <button onClick={this.handleClickOnMe}>Click on me</button>
        </div>
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
