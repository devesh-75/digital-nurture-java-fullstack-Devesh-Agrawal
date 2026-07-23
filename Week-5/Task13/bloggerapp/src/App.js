import React from 'react';
import { CourseDetails, courses } from './CourseDetails';
import { BookDetails, books } from './BookDetails';
import { BlogDetails, blogs } from './BlogDetails';
import './App.css';

function App() {
  const showContent = true;

  return (
    <div className="container">
      <div className="col">
        <CourseDetails courses={courses} />
      </div>
      <div className="divider"></div>
      <div className="col">
        <BookDetails books={books} />
      </div>
      <div className="divider"></div>
      <div className="col">
        {showContent && <BlogDetails blogs={blogs} />}
      </div>
    </div>
  );
}

export default App;
