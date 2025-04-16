describe('Warehouse Worker Task Assignment - Incorrect Worker ID', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const taskManagementPage = new TaskManagementPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as manager and navigate to task management', () => {
    loginPage.login('MGR001');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToTaskManagement();
  });

  it('should attempt to assign a task with an incorrect worker ID', () => {
    taskManagementPage.selectAssignTask();
    taskManagementPage.enterWorkerID('INVALID_WRK');
    taskManagementPage.verifyInvalidWorkerIDError();
    taskManagementPage.enterTaskDescription('Packing orders');
    taskManagementPage.setTaskDeadline('2023-11-02');
    taskManagementPage.clickAssignTask();
    taskManagementPage.verifyTaskAssignmentFailure();
  });

  after(() => {
    dashboardPage.logout();
  });
});