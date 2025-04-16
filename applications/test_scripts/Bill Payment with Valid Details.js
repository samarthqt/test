describe('Bill Payment with Valid Details', () => {
  const billPaymentPage = new BillPaymentPage();

  beforeEach(() => {
    cy.visit('/bill-payment');
  });

  it('should allow user to pay bills successfully', () => {
    billPaymentPage.selectBiller('Electricity Company');
    billPaymentPage.enterPaymentAmount('100');
    billPaymentPage.selectBankAccount('123456789');
    billPaymentPage.confirmPayment();
    billPaymentPage.verifyPaymentConfirmation();
  });
});