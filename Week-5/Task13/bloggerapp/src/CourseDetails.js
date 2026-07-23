import React from 'react';

export const courses = [
  { id: 1, name: 'Angular', date: '4/5/2021' },
  { id: 2, name: 'React', date: '6/3/20201' }
];

export function CourseDetails({ courses }) {
  const coursedet = courses && courses.length > 0 ? (
    <ul style={{ listStyleType: 'none', padding: 0 }}>
      {courses.map((course) => (
        <div key={course.id} style={{ marginBottom: '20px' }}>
          <h2>{course.name}</h2>
          <p>{course.date}</p>
        </div>
      ))}
    </ul>
  ) : <p>No courses available</p>;

  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {coursedet}
    </div>
  );
}
