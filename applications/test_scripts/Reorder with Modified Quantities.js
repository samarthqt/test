describe('Reorder with Modified Quantities', () => {
  it('should reorder with modified quantities', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const orderHistoryPage = new OrderHistoryPage();
    const orderDetailsPage = new OrderDetailsPage();
    const cartPage = new CartPage();
    const checkoutPage = new CheckoutPage();

    cy.visit('/login');
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyUserLoggedIn();

    dashboardPage.goToOrderHistory();
    orderHistoryPage.verifyOrderHistoryDisplayed();

    orderHistoryPage.selectOrder('12345');
    orderDetailsPage.verifyOrderDetailsDisplayed();

    orderDetailsPage.clickReorderButton();
    cartPage.verifyProductsInCart();

    cartPage.modifyProductQuantity('222', 5);
    cartPage.verifyProductQuantityUpdated('222', 5);

    cartPage.proceedToCheckout();
    checkoutPage.verifyCheckoutPageDisplayed();

    checkoutPage.completeCheckout('Credit Card');
    checkoutPage.verifyOrderConfirmation();
  });
});