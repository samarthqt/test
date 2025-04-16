describe('Credit Card Limit Inquiry', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const creditCardPage = new CreditCardPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the account management system', () => {
    loginPage.enterUserId('67890');
    loginPage.enterPassword('your_password');
    loginPage.clickLogin();
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to Credit Cards section', () => {
    dashboardPage.goToCreditCardsSection();
    creditCardPage.verifyCreditCardsSectionIsDisplayed();
  });

  it('should view credit card details', () => {
    creditCardPage.selectCreditCard('98765');
    creditCardPage.verifyCreditCardDetailsPageIsDisplayed();
  });

  it('should check the credit limit displayed for the card', () => {
    creditCardPage.verifyCreditLimitIsMaximum();
  });

  it('should verify no error messages are shown for maximum limit', () => {
    creditCardPage.verifyNoErrorMessagesForMaximumLimit();
  });
});