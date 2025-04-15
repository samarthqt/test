describe('Email Marketing Signup - Valid Email', () => {
  const emailMarketingPage = new EmailMarketingPage();

  it('should successfully sign up with a valid email address', () => {
    cy.visit('/email-signup');
    emailMarketingPage.enterEmail('user@example.com');
    emailMarketingPage.clickSignUp();
    emailMarketingPage.verifySuccessMessage();
  });
});