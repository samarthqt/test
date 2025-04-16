describe('Negative Test: Fee-Free Account Selection Without Option', () => {
  const accountOpeningPage = new AccountOpeningPage();

  before(() => {
    cy.visit('/account-opening');
  });

  it('should display the account opening page with available options', () => {
    accountOpeningPage.verifyPageDisplayed();
  });

  it('should enter user details successfully', () => {
    accountOpeningPage.enterUserDetails('Jane Smith', 'janesmith@example.com');
  });

  it('should not allow selection of fee-free account option', () => {
    accountOpeningPage.selectAccountType('Fee-Free');
    accountOpeningPage.verifyFeeFreeOptionUnavailable();
  });

  it('should display error message when submitting form', () => {
    accountOpeningPage.submitForm();
    accountOpeningPage.verifyErrorMessageDisplayed();
  });

  after(() => {
    accountOpeningPage.logout();
  });
});