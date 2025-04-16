describe('Instant Service Activation upon Subscription', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const subscriptionPage = new SubscriptionPage();
  const paymentPage = new PaymentPage();
  const contentPage = new ContentPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in and subscribe to a service', () => {
    loginPage.login('user67890', 'password');
    dashboardPage.verifyLoginSuccess();
    dashboardPage.navigateToSubscription();

    subscriptionPage.selectService('Premium Streaming Service');
    subscriptionPage.chooseSubscriptionPlan('Monthly');
    subscriptionPage.proceedToPayment();

    paymentPage.enterPaymentDetails('4111111111111111', '12/23', '123');
    paymentPage.confirmTransaction();

    subscriptionPage.verifyServiceActivation('Premium Streaming Service');
  });

  it('should verify service activation persistence after re-login', () => {
    dashboardPage.logout();
    loginPage.login('user67890', 'password');
    subscriptionPage.verifyServiceActivation('Premium Streaming Service');
  });

  it('should access premium content', () => {
    contentPage.accessPremiumContent();
    contentPage.verifyAccessGranted();
  });

  it('should verify subscription status and cancel subscription', () => {
    subscriptionPage.checkSubscriptionStatus('Active');
    subscriptionPage.cancelSubscription();
    subscriptionPage.verifyServiceDeactivation('Premium Streaming Service');
  });

  it('should deny access to premium content after cancellation', () => {
    contentPage.accessPremiumContent();
    contentPage.verifyAccessDenied();
  });

  it('should re-subscribe and verify immediate reactivation', () => {
    subscriptionPage.reSubscribeService('Premium Streaming Service', 'Monthly');
    subscriptionPage.verifyServiceActivation('Premium Streaming Service');
  });

  it('should verify updated subscription details', () => {
    subscriptionPage.checkSubscriptionDetails();
  });
});