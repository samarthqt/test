describe('Order Processing with Edge Case Quantities', () => {
  const orderPage = new OrderPage();

  before(() => {
    cy.visit('https://orderfulfillment.example.com');
    orderPage.login('validUsername', 'validPassword');
  });

  it('should navigate to Order Processing section', () => {
    orderPage.navigateToOrderProcessing();
    orderPage.verifyOrderProcessingInterface();
  });

  it('should enter customer ID and retrieve details', () => {
    orderPage.enterCustomerId('C1234');
    orderPage.verifyCustomerDetails();
  });

  it('should process order with zero quantity', () => {
    orderPage.createOrder('P003', 0);
    orderPage.verifyZeroQuantityResponse();
  });

  it('should process order with extremely large quantity', () => {
    orderPage.createOrder('P003', 1000000);
    orderPage.verifyLargeQuantityResponse();
  });

  after(() => {
    orderPage.logout();
  });
});