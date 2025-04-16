describe('Physical Inventory Count Reconciliation', () => {
  const loginPage = new LoginPage();
  const inventoryManagementPage = new InventoryManagementPage();
  const physicalCountPage = new PhysicalCountPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Dynamics 365 system', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Inventory Management module', () => {
    inventoryManagementPage.navigateToInventoryManagement();
    cy.url().should('include', '/inventory-management');
  });

  it('should select the Physical Count sub-module', () => {
    inventoryManagementPage.selectPhysicalCountSubModule();
    cy.url().should('include', '/physical-count');
  });

  it('should initiate a new physical count session for Item ID: I98765', () => {
    physicalCountPage.initiateNewSession('I98765');
    physicalCountPage.verifySessionInitiated('I98765');
  });

  it('should enter the physical count quantity as 98', () => {
    physicalCountPage.enterPhysicalCountQuantity(98);
    physicalCountPage.verifyPhysicalCountQuantity(98);
  });

  it('should submit the physical count for reconciliation', () => {
    physicalCountPage.submitPhysicalCount();
    physicalCountPage.verifyReconciliation();
  });

  it('should verify that the system updates the inventory records to reflect the physical count', () => {
    physicalCountPage.verifyInventoryRecordsUpdated('I98765', 98);
  });

  it('should generate a reconciliation report for the inventory count', () => {
    physicalCountPage.generateReconciliationReport();
    physicalCountPage.verifyReconciliationReportGenerated();
  });

  it('should export the reconciliation report to an Excel file', () => {
    physicalCountPage.exportReportToExcel();
    physicalCountPage.verifyReportExported();
  });

  it('should log out of the Dynamics 365 system', () => {
    loginPage.logout();
    cy.url().should('include', '/login');
  });
});