describe('Subscription Option for Regular Product Deliveries', () => {
  beforeEach(() => {
    cy.visit('/subscription-page');
  });

  it('User subscribes to a product for regular delivery', () => {
    cy.selectProductForSubscription();
    cy.chooseSubscriptionFrequency();
    cy.providePaymentDetails();
    cy.confirmSubscription();
    cy.receiveConfirmationEmail();
  });

  it('User modifies an existing subscription', () => {
    cy.visit('/subscription-management-page');
    cy.modifySubscription();
    cy.changeSubscriptionDetails();
    cy.updateSubscriptionDetails();
    cy.receiveUpdateConfirmationEmail();
  });

  it('User cancels an existing subscription', () => {
    cy.visit('/subscription-management-page');
    cy.cancelSubscription();
    cy.confirmCancellation();
    cy.receiveCancellationConfirmationEmail();
  });

  it('User views subscription details', () => {
    cy.visit('/subscription-management-page');
    cy.viewSubscriptionDetails();
  });

  it('User encounters an error during subscription', () => {
    cy.selectProductForSubscription();
    cy.enterInvalidPaymentDetails();
    cy.displayErrorMessage();
    cy.ensureSubscriptionNotProcessed();
  });
});