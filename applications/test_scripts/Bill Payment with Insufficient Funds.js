describe('Bill Payment with Insufficient Funds', () => {
  const billPaymentPage = new BillPaymentPage();

  beforeEach(() => {
    cy.visit('/bill-payment');
  });

  it('should handle bill payment attempts with insufficient funds', () => {
    billPaymentPage.selectBiller('Water Company');
    billPaymentPage.enterPaymentAmount('200');
    billPaymentPage.selectBankAccount('987654321');
    billPaymentPage.confirmPayment();
    billPaymentPage.verifyInsufficientFundsError();
  });
});