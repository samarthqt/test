describe('Order Confirmation Email Not Sent for Invalid Email', () => {
  const orderPage = new OrderPage();
  const emailPage = new EmailPage();

  it('should prevent order placement with invalid email', () => {
    cy.visit('/order');
    orderPage.placeOrder('invalid_email', 'Item A', 'Item B', 'Standard Shipping');
    orderPage.verifyInvalidEmailNotification();
  });

  it('should not send order confirmation email to invalid email address', () => {
    emailPage.checkInbox('invalid_email');
    emailPage.verifyNoOrderConfirmationEmail('12345');
  });
});