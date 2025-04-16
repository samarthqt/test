describe('Prescription Delivery Integration - Negative Test', () => {
  const loginPage = new LoginPage();
  const prescriptionsPage = new PrescriptionsPage();
  const deliveryOptionsPage = new DeliveryOptionsPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.login('validUsername', 'validPassword');
  });

  it('should handle errors when invalid delivery details are provided', () => {
    prescriptionsPage.navigateToPrescriptions();
    prescriptionsPage.selectPrescription('RX001');
    deliveryOptionsPage.clickDeliveryOptions();
    deliveryOptionsPage.selectHomeDelivery();
    deliveryOptionsPage.enterDeliveryAddress('999 Unknown St, Nonexistent City');
    deliveryOptionsPage.proceedWithInvalidAddress();
    deliveryOptionsPage.verifyErrorMessage('Invalid address');
    deliveryOptionsPage.correctAddress('123 Valid St, Real City');
    deliveryOptionsPage.proceedWithValidAddress();
  });
});