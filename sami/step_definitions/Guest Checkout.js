Given('I have items in my shopping cart', () => {
  cy.visit('/cart');
  cy.get('.cart-item').should('exist');
});

When('I proceed to checkout', () => {
  cy.get('.checkout-button').click();
});

And('I select the option to checkout as a guest', () => {
  cy.get('.guest-checkout-option').click();
});

And('I enter my shipping and payment information', () => {
  cy.get('#shipping-address').type('123 Cypress Lane');
  cy.get('#payment-info').type('4111111111111111');
});

And('I enter invalid payment information', () => {
  cy.get('#payment-info').type('1234567890123456');
});

And('I leave the shipping information blank', () => {
  cy.get('#shipping-address').clear();
});

And('I enter an invalid email format', () => {
  cy.get('#email').type('invalid-email');
});

And('I review my order', () => {
  cy.get('.review-order').click();
});

And('I confirm the order', () => {
  cy.get('.confirm-order').click();
});

And('I attempt to confirm the order', () => {
  cy.get('.confirm-order').click();
});

And('I choose to create an account with the provided information', () => {
  cy.get('.create-account-checkbox').check();
});

Then('I should see a confirmation message', () => {
  cy.get('.confirmation-message').should('contain', 'Thank you for your order');
});

Then('I should receive an order confirmation email', () => {
  cy.get('.email-confirmation').should('contain', 'Order Confirmation');
});

Then('I should see an error message indicating payment failure', () => {
  cy.get('.error-message').should('contain', 'Payment failed');
});

Then('I should see an error message indicating missing shipping information', () => {
  cy.get('.error-message').should('contain', 'Shipping information required');
});

Then('I should see an error message indicating invalid email format', () => {
  cy.get('.error-message').should('contain', 'Invalid email format');
});

Then('I should receive an account creation confirmation email', () => {
  cy.get('.email-confirmation').should('contain', 'Account Creation Confirmation');
});