describe('Credit Card Application', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const creditCardPage = new CreditCardPage();

  before(() => {
    cy.visit('/login');
  });

  it('should allow a user to apply for a new credit card', () => {
    loginPage.login('12345', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToCreditCards();
    creditCardPage.verifyCreditCardsSection();
    creditCardPage.applyForNewCard();
    creditCardPage.fillApplicationForm({
      name: 'John Doe',
      address: '123 Main St',
      income: '50000'
    });
    creditCardPage.submitApplication();
    creditCardPage.verifyApplicationSubmitted();
    dashboardPage.verifyApplicationStatus('submitted');
  });
});