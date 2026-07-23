import React from 'react';

export const blogs = [
  { id: 1, title: 'React Learning', author: 'Stephen Biz', content: 'Welcome to learning React!' },
  { id: 2, title: 'Installation', author: 'Schewzdenier', content: 'You can install React from npm.' }
];

export function BlogDetails({ blogs, showBlogs = true }) {
  if (!showBlogs) {
    return null;
  }

  const content = (
    <ul style={{ listStyleType: 'none', padding: 0 }}>
      {blogs.map((blog) => (
        <div key={blog.id} style={{ marginBottom: '20px' }}>
          <h2>{blog.title}</h2>
          <p><b>{blog.author}</b></p>
          <p>{blog.content}</p>
        </div>
      ))}
    </ul>
  );

  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {content}
    </div>
  );
}
