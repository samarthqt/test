describe('Maintenance Request Tracking', () => {
  const tenantCredentials = { username: 'tenant', password: 'tenant123' };
  const managerCredentials = { username: 'manager', password: 'manager123' };
  const requestDescription = 'Leaking faucet in kitchen';

  beforeEach(() => {
    cy.visit('/login');
  });

  it('Tenant submits a maintenance request', () => {
    cy.login(tenantCredentials);
    cy.get(TenantDashboard.requestsModule).click();
    cy.get(RequestsPage.submitNewRequestButton).click();
    cy.get(RequestsPage.requestDescriptionInput).type(requestDescription);
    cy.get(RequestsPage.submitRequestButton).click();
    cy.contains('Request Status: Submitted').should('be.visible');
  });

  it('Property manager tracks and updates the request', () => {
    cy.login(managerCredentials);
    cy.get(ManagerDashboard.requestsModule).click();
    cy.contains('Tenant ID: T001').click();
    cy.contains(requestDescription).should('be.visible');
    cy.get(RequestDetailsPage.statusDropdown).select('In Progress');
    cy.get(RequestDetailsPage.saveButton).click();
    cy.contains('Request Status: In Progress').should('be.visible');
  });

  afterEach(() => {
    cy.logout();
  });
});