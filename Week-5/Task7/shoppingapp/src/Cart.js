import React from 'react';

export class Cart extends React.Component {
  render() {
    return (
      <table style={{ margin: '20px auto', borderCollapse: 'collapse', fontFamily: 'Arial, sans-serif', border: '2px solid #556b2f' }}>
        <thead>
          <tr>
            <th style={{ color: 'green', padding: '8px 20px', border: '1px solid #9acd32' }}>Name</th>
            <th style={{ color: 'green', padding: '8px 20px', border: '1px solid #9acd32' }}>Price</th>
          </tr>
        </thead>
        <tbody>
          {this.props.item.map((item, index) => {
            return (
              <tr key={index}>
                <td style={{ color: '#556b2f', padding: '8px 20px', border: '1px solid #9acd32' }}>{item.itemname}</td>
                <td style={{ color: '#556b2f', padding: '8px 20px', border: '1px solid #9acd32' }}>{item.price}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    );
  }
}
