describe('Prescription Delivery Integration - Positive Test', () => {
  const loginPage = new LoginPage();
  const prescriptionsPage = new PrescriptionsPage();
  const deliveryOptionsPage = new DeliveryOptionsPage();
  const checkoutPage = new CheckoutPage();
  const orderHistoryPage = new OrderHistoryPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the application with valid credentials', () => {
    loginPage.login('12345', 'password');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Prescriptions section', () => {
    prescriptionsPage.navigateToPrescriptions();
    cy.url().should('include', '/prescriptions');
  });

  it('should select a prescription with ID RX001', () => {
    prescriptionsPage.selectPrescription('RX001');
    prescriptionsPage.verifyPrescriptionDetails('RX001');
  });

  it('should select Home Delivery as the preferred delivery method', () => {
    prescriptionsPage.clickDeliveryOptions();
    deliveryOptionsPage.selectHomeDelivery();
  });

  it('should enter delivery address and proceed to checkout', () => {
    deliveryOptionsPage.enterDeliveryAddress('123 Main St, City, Country');
    deliveryOptionsPage.confirmDeliveryDetails();
    cy.url().should('include', '/checkout');
  });

  it('should place the order successfully', () => {
    checkoutPage.reviewOrderSummary();
    checkoutPage.placeOrder();
    checkoutPage.verifyOrderConfirmation();
  });

  it('should display the new order in order history with Home Delivery status', () => {
    orderHistoryPage.checkOrderHistory('RX001', 'Home Delivery');
  });

  it('should verify email confirmation for the placed order', () => {
    cy.task('checkEmail', { subject: 'Order Confirmation', to: 'user@example.com' }).then(email => {
      expect(email).to.include('Your order has been placed successfully.');
    });
  });
});