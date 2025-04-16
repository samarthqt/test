describe('Personal Loan Eligibility Checker', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const loanManagementPage = new LoanManagementPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should allow user to check personal loan eligibility', () => {
    loginPage.login('username', 'password');
    dashboardPage.verifyUserIsLoggedIn();
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectPersonalLoan();
    loanManagementPage.enterAnnualIncome('50000');
    loanManagementPage.enterCreditScore('720');
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyEligibilityStatus();
    loanManagementPage.downloadEligibilityReport();
    loanManagementPage.verifyDownloadedReport();
  });

  it('should not allow access to eligibility checker without login', () => {
    cy.visit('/loan-management');
    loginPage.verifyLoginPrompt();
  });

  it('should handle invalid financial data input', () => {
    loginPage.login('username', 'password');
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectPersonalLoan();
    loanManagementPage.enterAnnualIncome('invalid');
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyInvalidDataPrompt();
  });

  it('should handle invalid credit score input', () => {
    loginPage.login('username', 'password');
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectPersonalLoan();
    loanManagementPage.enterCreditScore('invalid');
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyInvalidDataPrompt();
  });

  it('should handle incomplete data input', () => {
    loginPage.login('username', 'password');
    dashboardPage.navigateToLoanManagement();
    loanManagementPage.selectPersonalLoan();
    loanManagementPage.checkEligibility();
    loanManagementPage.verifyIncompleteDataPrompt();
  });

  afterEach(() => {
    dashboardPage.logout();
    loginPage.verifyUserIsLoggedOut();
  });
});