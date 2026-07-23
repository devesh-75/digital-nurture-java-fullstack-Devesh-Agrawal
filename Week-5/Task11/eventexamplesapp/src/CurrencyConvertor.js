import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: ''
    };
  }

  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value
    });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const amountVal = parseFloat(this.state.amount) || 0;
    const convertedAmount = amountVal * 80;
    alert(`Converting to  Euro Amount is ${convertedAmount}`);
  };

  render() {
    return (
      <div>
        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <table cellPadding="5">
            <tbody>
              <tr>
                <td>Amount:</td>
                <td>
                  <input
                    type="text"
                    name="amount"
                    value={this.state.amount}
                    onChange={this.handleChange}
                  />
                </td>
              </tr>
              <tr>
                <td>Currency:</td>
                <td>
                  <input
                    type="text"
                    name="currency"
                    value={this.state.currency}
                    onChange={this.handleChange}
                  />
                </td>
              </tr>
              <tr>
                <td></td>
                <td style={{ textAlign: 'center' }}>
                  <button type="submit">Submit</button>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
