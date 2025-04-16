describe('Order History Access', () => {
  before(() => {
    // Assuming a login function exists that logs in the user
    cy.login('test_user');
  });

  it('should navigate to the account page and display order history options', () => {
    const accountPage = new AccountPage();
    accountPage.navigateToAccountPage();
    accountPage.verifyOrderHistoryOption();
  });

  it('should display past orders when Order History is clicked', () => {
    const accountPage = new AccountPage();
    accountPage.clickOrderHistory();
    accountPage.verifyOrderHistoryPage();
  });

  it('should display detailed view of Order ID 54321', () => {
    const orderHistoryPage = new OrderHistoryPage();
    orderHistoryPage.selectOrderById('54321');
    orderHistoryPage.verifyOrderDetails('54321', '01/01/2023');
  });
});