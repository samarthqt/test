describe('Service Compatibility Check', () => {
    const serviceActivationPage = new ServiceActivationPage();

    beforeEach(() => {
        cy.visit('/service-activation');
    });

    it('should navigate to the service activation page', () => {
        serviceActivationPage.verifyPageDisplayed();
    });

    it('should initiate the service compatibility check', () => {
        serviceActivationPage.initiateCompatibilityCheck();
        serviceActivationPage.verifyCheckingDeviceSpecifications();
    });

    it('should verify the device operating system', () => {
        serviceActivationPage.verifyOSCompatibility('Android 10');
    });

    it('should verify the device RAM', () => {
        serviceActivationPage.verifyRAMCompatibility('4GB');
    });

    it('should verify the device processor', () => {
        serviceActivationPage.verifyProcessorCompatibility('Quad-core 2.0 GHz');
    });

    it('should complete the compatibility check', () => {
        serviceActivationPage.completeCompatibilityCheck();
        serviceActivationPage.verifyDeviceIsCompatible();
    });

    it('should proceed with service activation', () => {
        serviceActivationPage.activateService();
        serviceActivationPage.verifyServiceActivated();
    });
});