describe('Credit Card Management Error Handling', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const creditCardPage = new CreditCardPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('54321', 'validPassword');
  });

  it('should navigate to Credit Cards section', () => {
    dashboardPage.navigateToCreditCards();
    creditCardPage.verifyCreditCardsSectionDisplayed();
  });

  it('should display error when submitting incomplete credit card application', () => {
    creditCardPage.applyForNewCreditCard();
    creditCardPage.submitApplicationFormIncomplete();
    creditCardPage.verifyErrorMessageDisplayed();
  });

  it('should persist error message on retry with incomplete fields', () => {
    creditCardPage.retrySubmitApplicationFormIncomplete();
    creditCardPage.verifyErrorMessageDisplayed();
  });
});