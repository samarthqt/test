describe('Asset Maintenance Tracking - Negative Test', () => {
  const assetManagement = new AssetManagementPage();

  before(() => {
    cy.login();
  });

  it('should navigate to the Asset Management module', () => {
    assetManagement.navigateToModule();
    assetManagement.verifyModuleAccess();
  });

  it('should select the asset with ID A123', () => {
    assetManagement.selectAssetByID('A123');
    assetManagement.verifyAssetDetails('A123');
  });

  it('should display error for empty maintenance task and due date fields', () => {
    assetManagement.clickAddMaintenanceTask();
    assetManagement.verifyMaintenanceTaskScreen();
    assetManagement.leaveMaintenanceTaskFieldEmpty();
    assetManagement.leaveDueDateFieldEmpty();
    assetManagement.attemptToSaveTask();
    assetManagement.verifyErrorMessageForMissingFields();
  });

  it('should reject invalid date format in Due Date field', () => {
    assetManagement.enterInvalidDateFormat();
    assetManagement.verifyInvalidDateFormatError();
  });

  it('should warn for past date in Due Date field', () => {
    assetManagement.enterPastDate();
    assetManagement.verifyPastDateWarning();
  });

  it('should allow saving task with alerts disabled and verify no logging', () => {
    assetManagement.saveTaskWithAlertsDisabled();
    assetManagement.verifyAlertsDisabledNotification();
    assetManagement.verifyTaskNotLoggedInHistory();
  });

  it('should log out and log back into the system', () => {
    cy.logout();
    cy.login();
  });

  it('should verify no alerts are scheduled or received', () => {
    assetManagement.navigateToAlertsSection();
    assetManagement.verifyNoAlertsScheduledOrReceived();
  });

  after(() => {
    assetManagement.verifySystemIntegrity();
  });
});