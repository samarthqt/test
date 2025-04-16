describe('TC-119 94 Fee-Free Account Selection', () => {
  const accountPage = new AccountPage();

  before(() => {
    cy.visit('/account-opening');
  });

  it('should display account opening page with available options', () => {
    accountPage.verifyPageLoaded();
  });

  it('should enter user details', () => {
    accountPage.enterUserDetails('John Doe', 'johndoe@example.com');
  });

  it('should select fee-free account option', () => {
    accountPage.selectAccountType('Fee-Free');
  });

  it('should submit the account opening form', () => {
    accountPage.submitForm();
  });

  it('should verify the account type in the confirmation', () => {
    accountPage.verifyConfirmationAccountType('Fee-Free');
  });

  it('should log out of the account creation process', () => {
    accountPage.logout();
  });
});