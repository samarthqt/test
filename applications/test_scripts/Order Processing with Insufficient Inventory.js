describe('Order Processing with Insufficient Inventory', () => {
  const loginPage = new LoginPage();
  const orderProcessingPage = new OrderProcessingPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should handle orders with insufficient inventory', () => {
    // Step 1: Log in
    loginPage.login('validUsername', 'validPassword');
    cy.url().should('include', '/dashboard');

    // Step 2: Navigate to Order Processing
    orderProcessingPage.navigateToOrderProcessing();
    cy.get(orderProcessingPage.orderProcessingInterface).should('be.visible');

    // Step 3: Enter Customer ID and retrieve details
    orderProcessingPage.enterCustomerId('C1234');
    cy.get(orderProcessingPage.customerDetails).should('contain', 'C1234');

    // Step 4: Enter Product SKU and Quantity
    orderProcessingPage.enterProductDetails('P002', 10);

    // Step 5: Check Product Availability
    orderProcessingPage.checkProductAvailability('P002');
    cy.get(orderProcessingPage.errorMessage).should('contain', 'Insufficient stock');

    // Step 6: Verify error message
    cy.get(orderProcessingPage.errorMessage).should('contain', 'Insufficient stock');
    cy.get(orderProcessingPage.adjustOrderOptions).should('be.visible');

    // Step 7: Attempt to submit order
    orderProcessingPage.submitOrder();
    cy.get(orderProcessingPage.errorMessage).should('contain', 'Cannot submit order');

    // Step 8: Log out
    loginPage.logout();
    cy.url().should('include', '/login');
  });
});