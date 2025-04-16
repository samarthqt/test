describe('Automatic Bill Payment Setup', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const automaticBillPayPage = new AutomaticBillPayPage();

  before(() => {
    cy.visit('/login');
  });

  it('should login and navigate to the payment dashboard', () => {
    loginPage.login('validUser', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should set up automatic bill payment for Electricity', () => {
    dashboardPage.navigateToAutomaticBillPay();
    automaticBillPayPage.verifyAutomaticBillPayPage();
    automaticBillPayPage.selectBillType('Electricity');
    automaticBillPayPage.enterPaymentDate('5th of every month');
    automaticBillPayPage.enterPaymentAmount('100');
    automaticBillPayPage.confirmSetup();
    automaticBillPayPage.verifySuccessMessage();
  });
});