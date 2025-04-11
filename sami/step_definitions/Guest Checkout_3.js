Given('the online store is open', () => {
  cy.visit('/store');
});

Given('the user is on the shopping cart page with items added', () => {
  cy.visit('/cart');
  cy.get('.cart-item').should('exist');
});

Given('the user opts for guest checkout', () => {
  cy.get('#guestCheckoutButton').click();
});

When('the user enters valid shipping information', () => {
  cy.get('#shippingForm').within(() => {
    cy.get('#name').type('John Doe');
    cy.get('#address').type('123 Main St');
    cy.get('#city').type('Anytown');
    cy.get('#zip').type('12345');
  });
});

When('the user enters invalid shipping information', () => {
  cy.get('#shippingForm').within(() => {
    cy.get('#name').type('');
    cy.get('#address').type('');
    cy.get('#city').type('');
    cy.get('#zip').type('');
  });
});

When('the user enters valid payment information', () => {
  cy.get('#paymentForm').within(() => {
    cy.get('#cardNumber').type('4111111111111111');
    cy.get('#expiryDate').type('12/23');
    cy.get('#cvv').type('123');
  });
});

When('the user enters invalid payment information', () => {
  cy.get('#paymentForm').within(() => {
    cy.get('#cardNumber').type('');
    cy.get('#expiryDate').type('');
    cy.get('#cvv').type('');
  });
});

When('the user leaves mandatory fields empty', () => {
  cy.get('#shippingForm').within(() => {
    cy.get('#name').type('');
    cy.get('#address').type('');
  });
});

When('the user fills in only the mandatory fields', () => {
  cy.get('#shippingForm').within(() => {
    cy.get('#name').type('John Doe');
    cy.get('#address').type('123 Main St');
  });
});

When('the user enters a valid promotional code', () => {
  cy.get('#promoCode').type('SAVE20');
  cy.get('#applyPromo').click();
});

When('the user enters an expired promotional code', () => {
  cy.get('#promoCode').type('EXPIRED20');
  cy.get('#applyPromo').click();
});

When('the user reviews the order summary', () => {
  cy.get('#orderSummary').should('be.visible');
});

Then('the user should be able to place the order successfully', () => {
  cy.get('#placeOrderButton').click();
  cy.get('#orderConfirmation').should('contain', 'Order placed successfully');
});

Then('the user receives an order confirmation with details', () => {
  cy.get('#orderConfirmation').should('contain', 'Order ID:');
});

Then('the user should see an error message for invalid shipping details', () => {
  cy.get('#shippingError').should('contain', 'Invalid shipping details');
});

Then('the user should not be able to proceed to payment', () => {
  cy.get('#paymentSection').should('not.exist');
});

Then('the user should see an error message for invalid payment details', () => {
  cy.get('#paymentError').should('contain', 'Invalid payment details');
});

Then('the user should not be able to place the order', () => {
  cy.get('#placeOrderButton').should('be.disabled');
});

Then('the user should see an error message indicating the required fields', () => {
  cy.get('#formError').should('contain', 'Required fields missing');
});

Then('the user should not be able to proceed to the next step', () => {
  cy.get('#nextStepButton').should('be.disabled');
});

Then('the user should be able to proceed with the checkout', () => {
  cy.get('#nextStepButton').click();
});

Then('the user should not be prompted to fill optional fields', () => {
  cy.get('#optionalFields').should('not.be.visible');
});

Then('the discount should be applied to the order total', () => {
  cy.get('#orderTotal').should('contain', 'Discount applied');
});

Then('the user should see the updated order total', () => {
  cy.get('#orderTotal').should('contain', '$80');
});

Then('the user should see an error message for the expired code', () => {
  cy.get('#promoError').should('contain', 'Expired promotional code');
});

Then('the order total should not reflect any discount', () => {
  cy.get('#orderTotal').should('contain', '$100');
});