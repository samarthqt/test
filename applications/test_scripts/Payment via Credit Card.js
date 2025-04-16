describe('Payment via Credit Card', () => {
  const coursePurchasePage = new CoursePurchasePage();

  beforeEach(() => {
    cy.login(); // Assuming a custom command for login
    coursePurchasePage.navigateToCoursePurchasePage();
  });

  it('should allow users to pay for courses using a credit card', () => {
    coursePurchasePage.selectPaymentMethod('Credit Card');
    coursePurchasePage.enterCreditCardDetails('4111111111111111', '12/25', '123');
    coursePurchasePage.clickPayNow();
    coursePurchasePage.verifyPaymentConfirmation();
  });
});