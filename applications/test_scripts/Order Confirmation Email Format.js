describe('Order Confirmation Email Format', () => {
  const orderPage = new OrderPage();
  const emailPage = new EmailPage();

  before(() => {
    // Setup: Place an order on the e-commerce platform
    orderPage.visit();
    orderPage.placeOrder();
  });

  it('should verify that the order confirmation email is in the correct format', () => {
    // Check the customer's email inbox for a new email
    emailPage.visitInbox('customer@example.com');
    emailPage.checkForEmail('Order Confirmation');

    // Open the order confirmation email
    emailPage.openEmail('Order Confirmation');

    // Assertions to verify the email format
    emailPage.verifyEmailContent({
      orderId: '12345',
      orderDetails: ['Item A', 'Item B'],
      shippingInfo: 'Standard Shipping',
      supportDetails: true
    });
  });
});