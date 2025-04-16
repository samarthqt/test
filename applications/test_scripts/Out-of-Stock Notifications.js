describe('Out-of-Stock Notifications', () => {
  const productID = '77889';
  const notificationPreference = 'Email';

  before(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
  });

  it('Should log in and navigate to the home page', () => {
    cy.url().should('include', '/home');
  });

  it('Should search for the out-of-stock product', () => {
    cy.get('#search-input').type(productID);
    cy.get('#search-button').click();
    cy.get('.product-status').should('contain', 'Out of Stock');
  });

  it('Should opt-in for restock notifications via email', () => {
    cy.get('.notification-opt-in').click();
    cy.get('.notification-preference').select(notificationPreference);
    cy.get('.save-preference').click();
    cy.get('.success-message').should('contain', 'Opt-in successful');
  });

  it('Should verify the notification preference in user account settings', () => {
    cy.visit('/account/settings');
    cy.get('.notification-preference-display').should('contain', notificationPreference);
  });

  it('Should restock the product in the system', () => {
    cy.restockProduct(productID);
    cy.visit(`/product/${productID}`);
    cy.get('.product-status').should('contain', 'In Stock');
  });

  it('Should check the user's email for restock notification', () => {
    cy.checkEmailForNotification('Your product is back in stock');
  });

  after(() => {
    cy.logout();
    cy.url().should('include', '/login');
  });
});