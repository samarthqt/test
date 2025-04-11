Given('the user is on the checkout page', () => {
  cy.visit('/checkout');
});

When('the user selects {string} as the payment method', (method) => {
  cy.get('#payment-method').select(method);
});

And('the user enters valid credit card details', () => {
  cy.get('#card-number').type('4111111111111111');
  cy.get('#expiry-date').type('12/25');
  cy.get('#cvv').type('123');
});

And('the user enters valid debit card details', () => {
  cy.get('#card-number').type('5500000000000004');
  cy.get('#expiry-date').type('12/25');
  cy.get('#cvv').type('123');
});

And('the user enters invalid credit card details', () => {
  cy.get('#card-number').type('1234567890123456');
  cy.get('#expiry-date').type('12/25');
  cy.get('#cvv').type('123');
});

And('the user enters invalid debit card details', () => {
  cy.get('#card-number').type('1234567890123456');
  cy.get('#expiry-date').type('12/25');
  cy.get('#cvv').type('123');
});

And('the user submits the payment', () => {
  cy.get('#submit-payment').click();
});

And('the user is redirected to the PayPal login page', () => {
  cy.url().should('include', 'paypal.com');
});

And('the user logs in with valid PayPal credentials', () => {
  cy.get('#paypal-email').type('user@example.com');
  cy.get('#paypal-password').type('password');
  cy.get('#paypal-login').click();
});

And('the user confirms the payment', () => {
  cy.get('#confirm-payment').click();
});

And('the user cancels the payment', () => {
  cy.get('#cancel-payment').click();
});

Then('the payment should be processed successfully', () => {
  cy.get('.confirmation-message').should('contain', 'Payment successful');
});

Then('the payment should be declined', () => {
  cy.get('.error-message').should('contain', 'Invalid card details');
});

Then('the user should be redirected back to the confirmation page', () => {
  cy.url().should('include', '/confirmation');
});

Then('the user should be redirected back to the checkout page', () => {
  cy.url().should('include', '/checkout');
});

Then('the payment should not be processed', () => {
  cy.get('.error-message').should('contain', 'Payment not processed');
});