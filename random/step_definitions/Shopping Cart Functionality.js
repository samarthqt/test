const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');

Given('a user is on the product page', () => {
  cy.visit('/product-page');
});

When('the user selects a product to add to the shopping cart', () => {
  cy.get('.product-item').first().click();
  cy.get('.add-to-cart-button').click();
});

Then('the product is added to the shopping cart', () => {
  cy.get('.shopping-cart').should('contain', 'Product Name');
});

Then('the shopping cart displays the product name, price, quantity, and subtotal', () => {
  cy.get('.shopping-cart').within(() => {
    cy.get('.product-name').should('be.visible');
    cy.get('.product-price').should('be.visible');
    cy.get('.product-quantity').should('be.visible');
    cy.get('.product-subtotal').should('be.visible');
  });
});

Then('a notification confirms the successful addition', () => {
  cy.get('.notification').should('contain', 'Product added successfully');
});

Given('a user has products in their shopping cart', () => {
  cy.visit('/shopping-cart');
  cy.get('.shopping-cart').should('not.be.empty');
});

When('the user selects a product to remove from the shopping cart', () => {
  cy.get('.remove-product-button').first().click();
});

Then('the product is removed from the shopping cart', () => {
  cy.get('.shopping-cart').should('not.contain', 'Product Name');
});

Then('the shopping cart updates immediately', () => {
  cy.get('.shopping-cart-updated').should('be.visible');
});

Then('a notification confirms the successful removal', () => {
  cy.get('.notification').should('contain', 'Product removed successfully');
});

When('the user modifies the quantity of a product in the shopping cart', () => {
  cy.get('.product-quantity-input').clear().type('2');
  cy.get('.update-quantity-button').click();
});

Then('the shopping cart updates the quantity and subtotal immediately', () => {
  cy.get('.product-quantity').should('contain', '2');
  cy.get('.product-subtotal').should('contain', 'Updated Subtotal');
});

Then('a notification confirms the successful modification', () => {
  cy.get('.notification').should('contain', 'Quantity updated successfully');
});

When('the user views the shopping cart', () => {
  cy.visit('/shopping-cart');
});

Then('the shopping cart displays each product's name, price, quantity, and subtotal', () => {
  cy.get('.shopping-cart').within(() => {
    cy.get('.product-name').should('be.visible');
    cy.get('.product-price').should('be.visible');
    cy.get('.product-quantity').should('be.visible');
    cy.get('.product-subtotal').should('be.visible');
  });
});

Given('a user is attempting to modify the shopping cart', () => {
  cy.visit('/shopping-cart');
});

When('the user performs an invalid operation', () => {
  cy.get('.invalid-operation-button').click();
});

Then('an error message is displayed', () => {
  cy.get('.error-message').should('be.visible');
});

Given('a user makes changes to their shopping cart', () => {
  cy.visit('/shopping-cart');
  cy.get('.product-quantity-input').clear().type('3');
  cy.get('.update-quantity-button').click();
});

When('the changes are saved', () => {
  cy.get('.save-changes-button').click();
});

Then('the changes are logged for tracking purposes', () => {
  cy.get('.log-entry').should('contain', 'Changes saved');
});