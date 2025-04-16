describe('Verify No Refund Policy on Digital Products', () => {
  const digitalProductsPage = new DigitalProductsPage();
  const productDetailPage = new ProductDetailPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();
  const orderConfirmationPage = new OrderConfirmationPage();
  const emailPage = new EmailPage();
  const customerServicePage = new CustomerServicePage();
  const userAccountPage = new UserAccountPage();

  before(() => {
    cy.login('Alice Johnson');
  });

  it('Navigate to digital products section', () => {
    digitalProductsPage.visit();
    digitalProductsPage.verifyPageLoaded();
  });

  it('Select a digital product to view its details', () => {
    digitalProductsPage.selectProduct('E-book');
    productDetailPage.verifyNoRefundPolicyVisible();
  });

  it('Add the digital product to the cart', () => {
    productDetailPage.addToCart();
    cartPage.verifyProductAddedWithNoRefundPolicy();
  });

  it('Proceed to checkout and review the order summary', () => {
    cartPage.proceedToCheckout();
    checkoutPage.verifyNoRefundPolicyInOrderSummary();
  });

  it('Complete the purchase of the digital product', () => {
    checkoutPage.completePurchase();
    orderConfirmationPage.verifyNoRefundPolicyReiterated();
  });

  it('Check the email confirmation for the purchase', () => {
    emailPage.verifyNoRefundPolicyInEmail();
  });

  it('Attempt to request a refund for the digital product', () => {
    customerServicePage.requestRefund('E-book');
    customerServicePage.verifyRefundDeniedDueToPolicy();
  });

  it('Verify no refund policy is visible before adding a product to the cart', () => {
    productDetailPage.verifyNoRefundPolicyVisible();
  });

  it('Check the no refund policy during a guest checkout', () => {
    checkoutPage.verifyNoRefundPolicyForGuestCheckout();
  });

  it('Review no refund policy on a mobile device', () => {
    cy.viewport('iphone-6');
    digitalProductsPage.visit();
    digitalProductsPage.verifyNoRefundPolicyVisible();
  });

  it('Ensure no refund policy is consistent across different digital products', () => {
    digitalProductsPage.verifyNoRefundPolicyConsistency();
  });

  it('Verify if the no refund policy is available in multiple languages', () => {
    digitalProductsPage.verifyNoRefundPolicyInMultipleLanguages();
  });

  it('Check the no refund policy visibility during promotional offers', () => {
    digitalProductsPage.verifyNoRefundPolicyDuringPromotions();
  });

  it('Attempt to return the digital product through customer service', () => {
    customerServicePage.requestReturn('E-book');
    customerServicePage.verifyReturnDeniedDueToPolicy();
  });

  it('Review the digital product purchase in the user account order history', () => {
    userAccountPage.visitOrderHistory();
    userAccountPage.verifyNoRefundPolicyInOrderHistory();
  });
});