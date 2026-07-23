import React from 'react';
import { useParams } from 'react-router-dom';

export default function TrainerDetail({ trainers }) {
  const { id } = useParams();
  const trainer = trainers.find(t => t.TrainerId === parseInt(id));

  if (!trainer) {
    return <h2>Trainer Not Found</h2>;
  }

  return (
    <div>
      <h2>Trainers Details</h2>
      <h3>{trainer.Name} ({trainer.Technology})</h3>
      <p>{trainer.Email}</p>
      <p>{trainer.Phone}</p>
      <ul>
        {trainer.Skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}
