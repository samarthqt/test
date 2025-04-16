describe('Automated Rent Increases', () => {
  const financialManagementPage = new FinancialManagementPage();
  const loginPage = new LoginPage();
  const reportPage = new ReportPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the system with valid credentials', () => {
    loginPage.login('validUser', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Financial Management module', () => {
    financialManagementPage.navigateToFinancialManagement();
    cy.url().should('include', '/financial-management');
  });

  it('should select Rent Increases Management', () => {
    financialManagementPage.selectRentIncreasesManagement();
    cy.contains('Rent Increases Management').should('be.visible');
  });

  it('should enter Lease ID and view current rent details', () => {
    financialManagementPage.enterLeaseID('L12345');
    financialManagementPage.verifyCurrentRentDetails('$1000');
  });

  it('should verify predefined increase percentage', () => {
    financialManagementPage.verifyIncreasePercentage('5%');
  });

  it('should simulate the lease renewal process', () => {
    financialManagementPage.simulateLeaseRenewal();
  });

  it('should verify the new rent amount is calculated correctly', () => {
    financialManagementPage.verifyNewRentAmount('$1050');
  });

  it('should confirm the rent increase and save changes', () => {
    financialManagementPage.confirmRentIncrease();
    financialManagementPage.saveChanges();
  });

  it('should check updated rent amount on tenant's new lease agreement', () => {
    financialManagementPage.verifyUpdatedRentOnLeaseAgreement('$1050');
  });

  it('should display error for invalid Lease ID', () => {
    financialManagementPage.enterLeaseID('INVALID');
    financialManagementPage.verifyInvalidLeaseIDError();
  });

  it('should not allow rent increase without predefined rules', () => {
    financialManagementPage.verifyNoIncreaseWithoutRules();
  });

  it('should log rent increase activity for audit', () => {
    financialManagementPage.verifyRentIncreaseLogged();
  });

  it('should generate rent increase report for a specific period', () => {
    reportPage.generateRentIncreaseReport('01/01/2024', '12/31/2024');
    reportPage.verifyReportGeneration();
  });

  it('should review report for accuracy and completeness', () => {
    reportPage.reviewReportAccuracy();
  });

  it('should log out of the system', () => {
    loginPage.logout();
    cy.url().should('include', '/login');
  });
});