describe('Order Confirmation Email Edge Case', () => {
  const orderPage = new OrderPage();
  const emailPage = new EmailPage();

  it('should place an order with maximum allowable items', () => {
    orderPage.visit();
    orderPage.addMaxItemsToCart();
    orderPage.placeOrder();
    orderPage.verifyOrderSuccess();
  });

  it('should receive an order confirmation email', () => {
    emailPage.login('customer@example.com');
    emailPage.checkInbox();
    emailPage.verifyEmailReceived('Order Confirmation', '12345');
  });

  it('should verify the order confirmation email details', () => {
    emailPage.openEmail('Order Confirmation');
    emailPage.verifyOrderDetailsNotTruncated();
  });
});