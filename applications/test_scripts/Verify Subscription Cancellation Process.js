describe('Subscription Cancellation Process', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const subscriptionPage = new SubscriptionPage();
  const emailPage = new EmailPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.login('Mark Brown', 'password');
  });

  it('should cancel the subscription successfully', () => {
    dashboardPage.navigateToSubscriptionManagement();
    subscriptionPage.selectActiveSubscription();
    subscriptionPage.clickCancelSubscription();
    subscriptionPage.confirmCancellation();
    subscriptionPage.verifyCancellationMessage();
    emailPage.verifyEmailConfirmation();
    dashboardPage.verifySubscriptionStatus('cancelled');
    subscriptionPage.attemptAccessServicePostCancellation();
  });

  it('should prompt for cancellation reason', () => {
    subscriptionPage.clickCancelSubscription();
    subscriptionPage.verifyCancellationReasonPrompt();
  });

  it('should work on mobile devices', () => {
    cy.viewport('iphone-6');
    dashboardPage.navigateToSubscriptionManagement();
    subscriptionPage.selectActiveSubscription();
    subscriptionPage.clickCancelSubscription();
    subscriptionPage.confirmCancellation();
  });

  it('should allow cancellation for all subscription types', () => {
    dashboardPage.navigateToSubscriptionManagement();
    subscriptionPage.verifyCancellationOptionForAllTypes();
  });

  it('should allow cancellation during free trial', () => {
    dashboardPage.navigateToSubscriptionManagement();
    subscriptionPage.selectFreeTrialSubscription();
    subscriptionPage.clickCancelSubscription();
    subscriptionPage.confirmCancellation();
  });

  it('should revoke all benefits post-cancellation', () => {
    dashboardPage.verifyNoSubscriptionBenefits();
  });

  it('should provide reactivation option', () => {
    subscriptionPage.verifyReactivationOption();
  });

  it('should reflect cancellation in billing cycle', () => {
    subscriptionPage.verifyBillingCycleUpdate();
  });
});