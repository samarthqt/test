describe('Invalid Credit Card Payment Test', () => {  beforeEach(() => {    cy.visit('/payment');  });  it('should display error for invalid credit card details', () => {    const paymentPage = new PaymentPage();    paymentPage.selectCreditCardPaymentMethod();    paymentPage.enterCreditCardNumber('0000 0000 0000 0000');    paymentPage.enterExpiryDate('01/20');    paymentPage.enterCVV('000');    paymentPage.submitPayment();    paymentPage.getCardNumberError().should('contain', 'invalid card number');    paymentPage.getExpiryDateError().should('contain', 'invalid expiry date');    paymentPage.getCVVError().should('contain', 'invalid CVV');    paymentPage.getPaymentError().should('be.visible');  });});