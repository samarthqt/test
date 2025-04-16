describe('Subscribe to Maintenance Plans', () => {
  const subscriptionPage = new SubscriptionPage();

  before(() => {
    cy.login();
  });

  it('should navigate to Subscription module', () => {
    subscriptionPage.navigateToSubscriptionModule();
    subscriptionPage.verifySubscriptionScreen();
  });

  it('should select Premium plan type', () => {
    subscriptionPage.selectPlanType('Premium');
    subscriptionPage.verifySelectedPlanType('Premium');
  });

  it('should enter payment details using Credit Card', () => {
    subscriptionPage.enterPaymentDetails('Credit Card');
    subscriptionPage.verifyPaymentDetailsAccepted();
  });

  it('should subscribe to the plan', () => {
    subscriptionPage.clickSubscribeButton();
    subscriptionPage.verifySubscriptionProcessed();
  });

  it('should display subscription confirmation message', () => {
    subscriptionPage.verifySubscriptionConfirmationMessage();
  });

  it('should not display any error messages or warnings', () => {
    subscriptionPage.verifyNoErrorMessagesOrWarnings();
  });

  after(() => {
    cy.logout();
  });
});