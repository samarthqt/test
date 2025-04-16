describe('Invalid Email Subscription Handling', () => {
  const invalidEmails = ['user@@example.com', 'user.com', '@example.com', 'user@.com', 'user@domain'];

  beforeEach(() => {
    cy.visit('/email-subscription');
  });

  invalidEmails.forEach((email) => {
    it(`should display error for invalid email: ${email}`, () => {
      const emailSubscriptionPage = new EmailSubscriptionPage();
      emailSubscriptionPage.enterEmail(email);
      emailSubscriptionPage.clickSubscribe();
      emailSubscriptionPage.verifyErrorMessage('Please enter a valid email address.');
    });
  });
});