describe('Fee-Free Account Selection with Invalid Data', () => {
  const accountPage = new AccountPage();

  before(() => {
    cy.visit('/account-opening');
  });

  it('should display the account opening page', () => {
    accountPage.verifyPageDisplayed();
  });

  it('should highlight invalid fields on entering invalid data', () => {
    accountPage.enterUserName('!@#$%^&*()');
    accountPage.enterEmail('invalidemail.com');
    accountPage.verifyInvalidFieldsHighlighted();
  });

  it('should block form submission with invalid data', () => {
    accountPage.selectFeeFreeAccount();
    accountPage.verifyFormSubmissionBlocked();
  });

  it('should submit the form successfully after correcting data', () => {
    accountPage.enterUserName('ValidName');
    accountPage.enterEmail('validemail@example.com');
    accountPage.submitForm();
    accountPage.verifyFormSubmitted();
  });

  it('should display Fee-Free as account type in confirmation', () => {
    accountPage.verifyAccountTypeInConfirmation('Fee-Free');
  });

  it('should log out successfully', () => {
    accountPage.logout();
    accountPage.verifyLogoutSuccessful();
  });
});