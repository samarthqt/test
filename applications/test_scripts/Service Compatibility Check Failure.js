describe('Service Compatibility Check Failure', () => {
  const serviceActivationPage = new ServiceActivationPage();

  beforeEach(() => {
    cy.visit('/service-activation');
  });

  it('should correctly identify incompatible devices', () => {
    serviceActivationPage.initiateCompatibilityCheck();
    serviceActivationPage.verifyOSIncompatibility();
    serviceActivationPage.verifyRAMIncompatibility();
    serviceActivationPage.verifyProcessorIncompatibility();
    serviceActivationPage.completeCompatibilityCheck();
    serviceActivationPage.attemptServiceActivation();
  });
});