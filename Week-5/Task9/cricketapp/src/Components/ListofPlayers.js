import React from 'react';

export function ListofPlayers({ players }) {
  return (
    <div>
      {players.map((item, index) => (
        <div key={index}>
          <li>Mr. {item.name} {item.score}</li>
        </div>
      ))}
    </div>
  );
}

export function Scorebelow70({ players }) {
  const players70 = players.filter(item => item.score <= 70);
  return (
    <div>
      {players70.map((item, index) => (
        <div key={index}>
          <li>Mr. {item.name} {item.score}</li>
        </div>
      ))}
    </div>
  );
}
