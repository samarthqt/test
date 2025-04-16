class CypressProject {
  navigateToProjectDirectory() {
    cy.exec('cd my-project-directory');
  }

  verifyCurrentDirectory() {
    cy.exec('pwd').its('stdout').should('contain', 'my-project-directory');
  }

  openCypressConfigFile(fileName) {
    cy.readFile(fileName).should('exist');
  }

  verifyCypressSettings() {
    cy.readFile('cypress.json').its('baseUrl').should('contain', 'http://localhost');
  }

  createTestFile(fileName, directory) {
    cy.writeFile(`${directory}/${fileName}`, 'describe('User Flow', () => {});');
  }

  verifyTestFileCreation() {
    cy.readFile('cypress/integration/userFlow.spec.js').should('exist');
  }

  writeLoginTestCase() {
    cy.writeFile('cypress/integration/userFlow.spec.js', `
describe('User Login', () => {
  it('should login with valid credentials', () => {
    cy.visit('/login');
    cy.get('#username').type('testuser');
    cy.get('#password').type('password');
    cy.get('button[type=submit]').click();
    cy.url().should('include', '/dashboard');
  });
});
`, { flag: 'a' });
  }

  verifyLoginTestCase() {
    cy.readFile('cypress/integration/userFlow.spec.js').should('contain', 'should login with valid credentials');
  }

  writeDataRetrievalTestCase() {
    cy.writeFile('cypress/integration/userFlow.spec.js', `
describe('User Data Retrieval', () => {
  it('should retrieve user data after login', () => {
    cy.get('#user-profile').should('contain', 'testuser');
  });
});
`, { flag: 'a' });
  }

  verifyDataRetrievalTestCase() {
    cy.readFile('cypress/integration/userFlow.spec.js').should('contain', 'should retrieve user data after login');
  }

  runCypressTestSuite(command) {
    cy.exec(command);
  }

  verifyCypressTestRunner() {
    cy.get('.reporter').should('be.visible');
  }

  executeTestFile(fileName) {
    cy.exec(`npx cypress run --spec cypress/integration/${fileName}`);
  }

  verifyTestExecution() {
    cy.get('.runnable').should('have.length.greaterThan', 0);
  }

  verifyTestResults() {
    cy.get('.test').should('have.class', 'passed');
  }

  verifyAllTestCasesPassed() {
    cy.get('.test.pass').should('have.length', 2);
  }

  reviewScreenshotsAndVideos() {
    cy.exec('ls cypress/screenshots').its('stdout').should('contain', 'userFlow.spec.js');
    cy.exec('ls cypress/videos').its('stdout').should('contain', 'userFlow.spec.js');
  }

  verifyScreenshotsAndVideos() {
    cy.readFile('cypress/screenshots/userFlow.spec.js').should('exist');
    cy.readFile('cypress/videos/userFlow.spec.js').should('exist');
  }

  commitTestFile() {
    cy.exec('git add cypress/integration/userFlow.spec.js');
    cy.exec('git commit -m "Add user flow test"');
  }

  verifyCommit() {
    cy.exec('git log -1 --pretty=%B').its('stdout').should('contain', 'Add user flow test');
  }

  pushToRemoteRepository() {
    cy.exec('git push');
  }

  verifyPush() {
    cy.exec('git ls-remote --heads origin').its('stdout').should('contain', 'refs/heads/main');
  }

  verifyRemoteRepository() {
    cy.exec('git ls-remote --heads origin').its('stdout').should('contain', 'refs/heads/main');
  }

  checkCommitLogs() {
    cy.exec('git log -1 --pretty=%B').its('stdout').should('contain', 'Add user flow test');
  }

  ensureNoMergeConflicts() {
    cy.exec('git status').its('stdout').should('not.contain', 'conflict');
  }

  verifyStableState() {
    cy.exec('git status').its('stdout').should('contain', 'working tree clean');
  }

  conductCodeReview() {
    cy.exec('npm run lint').its('stdout').should('not.contain', 'error');
  }

  verifyCodeQuality() {
    cy.exec('npm run lint').its('stdout').should('not.contain', 'error');
  }
}

export default CypressProject;