describe('Secure Payment Information Storage', () => {
  const loginPage = new LoginPage();
  const profilePage = new ProfilePage();
  const paymentPage = new PaymentPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('user1001', 'password');
    cy.url().should('include', '/homepage');
  });

  it('should navigate to payment information section', () => {
    profilePage.navigateToPaymentInfo();
    paymentPage.verifyPaymentInfoSection();
  });

  it('should enter and save valid payment information', () => {
    paymentPage.enterPaymentInformation('4111111111111111', '12/25', '123');
    paymentPage.savePaymentInformation();
  });

  it('should verify payment information is encrypted in the database', () => {
    paymentPage.verifyPaymentInfoEncryption();
  });

  it('should verify payment information remains saved after re-login', () => {
    profilePage.logout();
    loginPage.login('user1001', 'password');
    profilePage.verifySavedPaymentInfo();
  });

  it('should complete a purchase using saved payment information', () => {
    paymentPage.purchaseWithSavedPaymentInfo();
  });

  it('should remove saved payment information', () => {
    paymentPage.removePaymentInformation();
  });

  it('should verify removed payment information is no longer available for transactions', () => {
    paymentPage.verifyRemovalOfPaymentInfo();
  });
});