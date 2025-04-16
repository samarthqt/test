describe('Auto-Loan Eligibility Checker', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const loanManagementPage = new LoanManagementPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in and check auto loan eligibility', () => {
    loginPage.login('12345', 'password');
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectAutoLoan();
    loanManagementPage.enterFinancialData('60000');
    loanManagementPage.enterCreditScore('750');
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyEligibilityStatus();
    loanManagementPage.downloadEligibilityReport();
    loanManagementPage.verifyDownloadedReport();
  });

  it('should not allow access to eligibility checker without login', () => {
    loanManagementPage.attemptAccessWithoutLogin();
  });

  it('should handle invalid financial data', () => {
    loginPage.login('12345', 'password');
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectAutoLoan();
    loanManagementPage.enterFinancialData('invalid');
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyInvalidDataPrompt();
  });

  it('should handle invalid credit score', () => {
    loginPage.login('12345', 'password');
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectAutoLoan();
    loanManagementPage.enterCreditScore('invalid');
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyInvalidDataPrompt();
  });

  it('should handle incomplete data', () => {
    loginPage.login('12345', 'password');
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectAutoLoan();
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyIncompleteDataPrompt();
  });

  afterEach(() => {
    dashboardPage.logout();
  });
});