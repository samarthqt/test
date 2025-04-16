describe('Warehouse Worker Task Assignment', () => {
  const managerId = 'MGR001';
  const workerId = 'WRK001';
  const taskDescription = 'Restocking shelves';
  const taskDeadline = '2023-11-01';

  before(() => {
    cy.visit('/login');
    cy.get('#managerId').type(managerId);
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Task Management module', () => {
    cy.get('#taskManagementModule').click();
    cy.url().should('include', '/task-management');
  });

  it('should display task assignment form', () => {
    cy.get('#assignTaskOption').click();
    cy.get('#taskAssignmentForm').should('be.visible');
  });

  it('should enter worker details and task information', () => {
    cy.get('#workerIdField').type(workerId);
    cy.get('#workerDetails').should('contain', workerId);
    cy.get('#taskDescriptionField').type(taskDescription);
    cy.get('#taskDeadlineField').type(taskDeadline);
  });

  it('should assign the task successfully', () => {
    cy.get('#assignTaskButton').click();
    cy.get('#confirmationMessage').should('contain', 'Task assigned successfully');
  });

  it('should verify task assignment in Task Monitoring', () => {
    cy.get('#taskMonitoringSection').click();
    cy.get('#taskList').should('contain', taskDescription);
    cy.get('#taskList').should('contain', taskDeadline);
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});