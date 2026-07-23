import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', () => {
    const dummyData = {
      data: [
        { name: 'repo-one' },
        { name: 'repo-two' },
        { name: 'repo-three' }
      ]
    };

    axios.get.mockResolvedValue(dummyData);

    const gitClient = new GitClient();
    return gitClient.getRepositories('techiesyed').then((repositories) => {
      expect(repositories).toEqual(['repo-one', 'repo-two', 'repo-three']);
    });
  });
});
