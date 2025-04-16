describe('Order Processing from Entry to Shipping', () => {
  const loginPage = new LoginPage();
  const orderProcessingPage = new OrderProcessingPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the order fulfillment system', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.clickLoginButton();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Order Processing section', () => {
    orderProcessingPage.navigateToOrderProcessing();
    orderProcessingPage.verifyOrderProcessingInterface();
  });

  it('should retrieve customer details', () => {
    orderProcessingPage.enterCustomerId('C1234');
    orderProcessingPage.verifyCustomerDetails();
  });

  it('should create a new order with specified product and quantity', () => {
    orderProcessingPage.enterProductDetails('P001', 2);
    orderProcessingPage.verifyOrderCreation();
  });

  it('should confirm product availability', () => {
    orderProcessingPage.checkProductAvailability('P001');
    orderProcessingPage.verifyProductAvailability();
  });

  it('should select the shipping address for the order', () => {
    orderProcessingPage.selectShippingAddress('123 Main St, City, Country');
    orderProcessingPage.verifyShippingAddress();
  });

  it('should submit the order for processing', () => {
    orderProcessingPage.submitOrder();
    orderProcessingPage.verifyOrderSubmission();
  });

  it('should verify automatic shipping label creation', () => {
    orderProcessingPage.verifyShippingLabelCreation();
  });

  it('should check the order status to ensure it progresses to Shipped', () => {
    orderProcessingPage.checkOrderStatus('Shipped');
    orderProcessingPage.verifyOrderStatus();
  });

  it('should log out of the order fulfillment system', () => {
    loginPage.clickLogoutButton();
    cy.url().should('include', '/login');
  });
});