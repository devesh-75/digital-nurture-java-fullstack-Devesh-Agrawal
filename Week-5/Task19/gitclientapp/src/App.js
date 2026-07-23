import React, { Component } from 'react';
import GitClient from './GitClient';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      repositories: []
    };
    this.gitClient = new GitClient();
  }

  componentDidMount() {
    this.gitClient.getRepositories('techiesyed').then((repositories) => {
      this.setState({ repositories });
    });
  }

  render() {
    return (
      <div>
        <h2>Repositories</h2>
        <ul>
          {this.state.repositories.map((repo) => (
            <li key={repo}>{repo}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;
