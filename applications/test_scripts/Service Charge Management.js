describe('Service Charge Management Test Suite', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const financialManagementPage = new FinancialManagementPage();
  const serviceChargePage = new ServiceChargePage();

  before(() => {
    cy.visit('/');
  });

  it('Logs into the system and accesses the dashboard', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboardAccess();
  });

  it('Navigates to the Financial Management module', () => {
    dashboardPage.navigateToFinancialManagement();
    financialManagementPage.verifyFinancialManagementAccess();
  });

  it('Selects Service Charge Management', () => {
    financialManagementPage.selectServiceChargeManagement();
    serviceChargePage.verifyServiceChargeManagementAccess();
  });

  it('Enters service charge details and submits', () => {
    serviceChargePage.enterServiceChargeDetails('P12345', 'Utilities', 100, 'Monthly');
    serviceChargePage.submitServiceCharge();
    serviceChargePage.verifyServiceChargeSubmission();
  });

  it('Verifies total service charge calculation', () => {
    serviceChargePage.verifyTotalServiceChargeCalculation();
  });

  it('Checks service charge on tenant billing statement', () => {
    serviceChargePage.verifyServiceChargeOnBillingStatement();
  });

  it('Attempts invalid service charge entries', () => {
    serviceChargePage.enterInvalidPropertyID('InvalidID');
    serviceChargePage.verifyInvalidPropertyIDError();

    serviceChargePage.enterNegativeChargeAmount(-100);
    serviceChargePage.verifyNegativeAmountError();

    serviceChargePage.enterUnsupportedChargeType('UnsupportedType');
    serviceChargePage.verifyUnsupportedChargeTypeError();
  });

  it('Verifies service charge entry logging for audit', () => {
    serviceChargePage.verifyServiceChargeLogging();
  });

  it('Generates and reviews service charge report', () => {
    serviceChargePage.generateServiceChargeReport('specificPeriod');
    serviceChargePage.verifyServiceChargeReportAccuracy();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});