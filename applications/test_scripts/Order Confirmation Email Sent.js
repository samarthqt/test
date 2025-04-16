describe('Order Confirmation Email Test Suite', () => {
  const customerEmail = 'customer@example.com';
  const orderId = '12345';

  before(() => {
    cy.visit('/');
    cy.login(); // Assuming a custom command for login
  });

  it('should place an order successfully', () => {
    cy.placeOrder(); // Assuming a custom command for placing an order
    cy.getOrderID().then((id) => {
      expect(id).to.exist;
    });
  });

  it('should verify the order confirmation email is received', () => {
    cy.checkEmailInbox(customerEmail).then((emails) => {
      const confirmationEmail = emails.find(email => email.subject.includes('Order Confirmation'));
      expect(confirmationEmail).to.exist;
      expect(confirmationEmail.body).to.include(orderId);
    });
  });

  it('should verify the email contains correct order details and shipping information', () => {
    cy.checkEmailInbox(customerEmail).then((emails) => {
      const confirmationEmail = emails.find(email => email.subject.includes('Order Confirmation'));
      expect(confirmationEmail.body).to.include('Item A');
      expect(confirmationEmail.body).to.include('Item B');
      expect(confirmationEmail.body).to.include('Standard Shipping');
    });
  });
});