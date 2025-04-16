describe('Asset Configuration Change Tracking', () => {
  const assetId = 'A78901';
  const changeType = 'Software Upgrade';
  const changeDetails = 'OS version update';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type('validUsername');
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('Navigates to Asset Management module', () => {
    cy.get('#assetManagementLink').click();
    cy.url().should('include', '/assetManagement');
  });

  it('Selects the Configuration sub-module', () => {
    cy.get('#configurationSubModuleLink').click();
    cy.url().should('include', '/configuration');
  });

  it('Searches for the asset using Asset ID', () => {
    cy.get('#assetSearchInput').type(assetId);
    cy.get('#searchButton').click();
    cy.get('#assetDetails').should('contain', assetId);
  });

  it('Initiates a configuration change for the asset', () => {
    cy.get('#changeTypeDropdown').select(changeType);
    cy.get('#initiateChangeButton').click();
    cy.get('#changeSession').should('be.visible');
  });

  it('Enters the change details', () => {
    cy.get('#changeDetailsInput').type(changeDetails);
    cy.get('#submitChangeButton').click();
    cy.get('#changeLogConfirmation').should('contain', 'Change submitted');
  });

  it('Verifies system logs the configuration change with a timestamp', () => {
    cy.get('#logSection').should('contain', changeDetails);
    cy.get('#logSection').should('contain', 'Timestamp');
  });

  it('Generates a configuration change report', () => {
    cy.get('#generateReportButton').click();
    cy.get('#reportSection').should('be.visible');
  });

  it('Exports the configuration change report to PDF', () => {
    cy.get('#exportPdfButton').click();
    cy.get('#pdfConfirmation').should('contain', 'Export successful');
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});