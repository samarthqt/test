describe('Credit Score Monitoring and Alerts', () => {
  const creditPage = new CreditScorePage();

  before(() => {
    cy.login('validUser', 'validPassword');
  });

  after(() => {
    cy.logout();
  });

  it('should navigate to Credit Score section', () => {
    creditPage.navigateToCreditScoreSection();
    creditPage.verifyCreditScoreSectionDisplayed();
  });

  it('should view current credit score', () => {
    creditPage.viewCurrentCreditScore();
    creditPage.verifyCreditScoreDisplayed();
  });

  it('should review credit score history', () => {
    creditPage.reviewCreditScoreHistory();
    creditPage.verifyCreditScoreHistoryDisplayed();
  });

  it('should set up alerts for significant changes', () => {
    creditPage.setupCreditScoreAlerts(20);
    creditPage.verifyAlertSetupConfirmation();
  });

  it('should simulate a credit score change exceeding threshold', () => {
    creditPage.simulateCreditScoreChange(25);
    creditPage.verifyAlertNotificationReceived();
  });

  it('should access alert notification details', () => {
    creditPage.accessAlertNotification();
    creditPage.verifyCreditScoreChangeDetails();
  });

  it('should verify credit score alerts after re-login', () => {
    cy.logout();
    cy.login('validUser', 'validPassword');
    creditPage.verifyCreditScoreAlertsActive();
  });

  it('should modify credit score alert threshold', () => {
    creditPage.modifyAlertThreshold(30);
    creditPage.verifyAlertThresholdModification();
  });

  it('should simulate a credit score change below new threshold', () => {
    creditPage.simulateCreditScoreChange(15);
    creditPage.verifyNoAlertGenerated();
  });

  it('should verify periodic update of credit score details', () => {
    creditPage.verifyCreditScoreDetailsUpdated();
  });

  it('should check documentation of credit score monitoring feature', () => {
    creditPage.verifyFeatureDocumentation();
  });

  it('should deny access to credit score details without login', () => {
    cy.logout();
    creditPage.accessCreditScoreWithoutLogin();
    creditPage.verifyAccessDenied();
  });
});