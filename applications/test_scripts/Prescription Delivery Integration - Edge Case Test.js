describe('Prescription Delivery Integration - Edge Case Test', () => {
  const loginPage = new LoginPage();
  const prescriptionsPage = new PrescriptionsPage();
  const deliveryOptionsPage = new DeliveryOptionsPage();

  beforeEach(() => {
    cy.visit('/');
    loginPage.login('username', 'password');
  });

  it('should handle edge cases in delivery address input', () => {
    prescriptionsPage.navigateToPrescriptions();
    prescriptionsPage.selectPrescriptionById('RX001');
    deliveryOptionsPage.clickDeliveryOptions();
    deliveryOptionsPage.selectHomeDelivery();

    // Test with 1 character address
    deliveryOptionsPage.enterDeliveryAddress('A');
    deliveryOptionsPage.verifyAddressError('Address is too short');

    // Test with maximum allowed characters
    const maxAddress = 'A'.repeat(100); // Assuming 100 is the max length
    deliveryOptionsPage.enterDeliveryAddress(maxAddress);
    deliveryOptionsPage.verifyAddressAccepted();

    // Test exceeding maximum character limit
    const longAddress = 'A'.repeat(101); // Assuming 101 exceeds the limit
    deliveryOptionsPage.enterDeliveryAddress(longAddress);
    deliveryOptionsPage.verifyCharacterLimitWarning();
  });
});