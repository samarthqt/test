describe('Warehouse Worker Task Assignment - Maximum Task Load', () => {
  const managerId = 'MGR001';
  const workerId = 'WRK001';
  const taskDeadline = '2023-11-03';

  before(() => {
    cy.visit('/login');
    cy.login(managerId);
  });

  it('should navigate to Task Management module', () => {
    cy.get('.dashboard').contains('Task Management').click();
    cy.url().should('include', '/task-management');
  });

  it('should display task assignment form', () => {
    cy.get('.task-management').contains('Assign Task').click();
    cy.get('.task-form').should('be.visible');
  });

  it('should enter Worker ID and display worker details', () => {
    cy.get('#workerId').type(workerId);
    cy.get('.worker-details').should('contain', workerId);
  });

  it('should assign maximum number of tasks to a worker', () => {
    const maxTasks = 100; // Assume 100 is the max capacity
    for (let i = 0; i < maxTasks; i++) {
      cy.assignTask(workerId, taskDeadline);
    }
  });

  it('should not allow assigning more than maximum capacity', () => {
    cy.assignTask(workerId, taskDeadline);
    cy.get('.error-message').should('contain', 'task overload');
  });

  it('should verify assigned tasks in Task Monitoring section', () => {
    cy.get('.task-monitoring').click();
    cy.get('.task-list').should('have.length', 100);
  });

  after(() => {
    cy.logout();
  });
});