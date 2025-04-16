describe('Invalid Credit Card Number Test', () => {
  const purchasePage = new PurchasePage();

  beforeEach(() => {
    cy.visit('/course-purchase');
  });

  it('should display an error message for invalid credit card number', () => {
    purchasePage.selectPaymentMethod('Credit Card');
    purchasePage.enterCreditCardDetails('1234567890123456', '12/25', '123');
    purchasePage.clickPayNow();
    purchasePage.verifyInvalidCardErrorMessage();
  });
});