describe('Verify No Discount Applied When Not Eligible', () => {
  it('should navigate to the checkout page and verify no discount applied', () => {
    const checkoutPage = new CheckoutPage();
    checkoutPage.navigate();
    checkoutPage.verifyCartTotal('$40');
    checkoutPage.proceedToPayment();
    checkoutPage.verifyFinalCartTotal('$40');
  });
});