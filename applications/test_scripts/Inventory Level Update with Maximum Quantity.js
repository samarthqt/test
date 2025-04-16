describe('Inventory Level Update with Maximum Quantity', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const goodsReceiptPage = new GoodsReceiptPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in and update inventory with maximum quantity', () => {
    loginPage.login('username', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToGoodsReceipt();

    goodsReceiptPage.verifyGoodsReceiptPage();
    goodsReceiptPage.enterProductId('12345');
    goodsReceiptPage.enterReceivedQuantity('100000');
    goodsReceiptPage.submitGoodsReceipt();

    goodsReceiptPage.verifyConfirmationMessage();
    goodsReceiptPage.verifyInventoryLevel('12345', '100000');
  });
});