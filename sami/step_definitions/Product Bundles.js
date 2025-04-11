Given('I am a registered customer', () => {
  cy.login();
});

Given('I am logged into the e-commerce platform', () => {
  cy.visit('/login');
  cy.get('#username').type('registeredUser');
  cy.get('#password').type('password');
  cy.get('#loginButton').click();
});

Given('I navigate to the "Product Bundles" section', () => {
  cy.visit('/product-bundles');
});

When('I select multiple products to create a bundle', () => {
  cy.get('.product-checkbox').check();
});

And('I apply a discount to the bundle', () => {
  cy.get('#discountField').type('20');
  cy.get('#applyDiscountButton').click();
});

Then('I should see the total price of the bundle reflecting the discount', () => {
  cy.get('#totalPrice').should('contain', 'Discounted Price');
});

And('the bundle should be added to my cart', () => {
  cy.get('#cart').should('contain', 'Product Bundle');
});

When('I browse through the available bundles', () => {
  cy.get('.bundle-list').should('be.visible');
});

Then('I should see a list of product bundles with their respective discounts', () => {
  cy.get('.bundle-discount').should('contain', 'Discount');
});

Given('I have a product bundle in my cart', () => {
  cy.get('#cart').should('contain', 'Product Bundle');
});

When('I choose to edit the bundle', () => {
  cy.get('#editBundleButton').click();
});

And('I add or remove products from the bundle', () => {
  cy.get('.product-checkbox').uncheck();
  cy.get('.product-checkbox').check();
});

And('I update the discount if necessary', () => {
  cy.get('#discountField').clear().type('15');
  cy.get('#applyDiscountButton').click();
});

Then('the updated product bundle should reflect the changes', () => {
  cy.get('#updatedBundle').should('contain', 'Updated Products');
});

And('the new total price should be displayed', () => {
  cy.get('#newTotalPrice').should('contain', 'New Price');
});

When('I choose to remove the bundle from my cart', () => {
  cy.get('#removeBundleButton').click();
});

Then('the product bundle should no longer appear in my cart', () => {
  cy.get('#cart').should('not.contain', 'Product Bundle');
});

Given('I have a discounted product bundle in my cart', () => {
  cy.get('#cart').should('contain', 'Discounted Product Bundle');
});

When('I proceed to checkout', () => {
  cy.get('#checkoutButton').click();
});

And('I complete the payment process', () => {
  cy.get('#paymentForm').submit();
});

Then('I should receive a confirmation of my purchase', () => {
  cy.get('#confirmationMessage').should('contain', 'Purchase Confirmed');
});

And('the product bundle should be marked as purchased', () => {
  cy.get('#purchasedBundles').should('contain', 'Purchased Bundle');
});