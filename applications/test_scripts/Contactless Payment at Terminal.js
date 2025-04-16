describe('Contactless Payment at Terminal', () => {
  const paymentTerminal = new PaymentTerminalPage();
  const smartphone = new SmartphonePage();

  before(() => {
    cy.visit('/payment-terminal');
  });

  it('should ensure users can make payments at supported terminals using NFC-enabled devices', () => {
    paymentTerminal.isReadyToAcceptPayments();
    smartphone.activateNFC();
    smartphone.holdNearTerminal();
    paymentTerminal.detectNFCSignal();
    smartphone.authorizePayment();
    paymentTerminal.verifyPaymentConfirmation();
  });
});