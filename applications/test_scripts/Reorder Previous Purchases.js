describe('Reorder Previous Purchases', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const orderHistoryPage = new OrderHistoryPage();
  const orderDetailsPage = new OrderDetailsPage();
  const shoppingCartPage = new ShoppingCartPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in and navigate to the account dashboard', () => {
    loginPage.login('user123', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Order History and select a previous order', () => {
    dashboardPage.goToOrderHistory();
    orderHistoryPage.selectOrder('67890');
    orderDetailsPage.verifyOrderDetails('111');
  });

  it('should reorder the selected order', () => {
    orderDetailsPage.clickReorderButton();
    shoppingCartPage.verifyCartItems('111', 2);
  });

  it('should proceed to checkout and complete the order', () => {
    shoppingCartPage.proceedToCheckout();
    checkoutPage.completeCheckout('Credit Card');
    checkoutPage.verifyOrderConfirmation();
  });
});