Given('I am on the homepage of the e-commerce site', () => {
    cy.visit('/');
});

When('I navigate to the footer section', () => {
    cy.get('footer').scrollIntoView();
});

Then('I should see a link to {string}', (linkText) => {
    cy.get('footer').contains(linkText).should('be.visible');
});

When('I click on the {string} link in the footer', (linkText) => {
    cy.get('footer').contains(linkText).click();
});

Then('I should be redirected to the {string} page', (pageTitle) => {
    cy.url().should('include', '/return-policy');
    cy.get('h1').should('contain', pageTitle);
});

And('I should see the return policy details clearly displayed', () => {
    cy.get('.return-policy-content').should('be.visible');
});

Given('I am on a product page', () => {
    cy.visit('/product-page');
});

When('I scroll to the bottom of the page', () => {
    cy.scrollTo('bottom');
});

Given('I am on the {string} page', (pageTitle) => {
    cy.visit('/return-policy');
    cy.get('h1').should('contain', pageTitle);
});

Then('I should see information about:', (dataTable) => {
    dataTable.hashes().forEach(row => {
        cy.contains(row.Topic).should('be.visible');
    });
});

Given('I am using a mobile device', () => {
    cy.viewport('iphone-6');
});

When('I navigate to the {string} page', (pageTitle) => {
    cy.visit('/return-policy');
    cy.get('h1').should('contain', pageTitle);
});

Then('the return policy details should be clearly visible and readable', () => {
    cy.get('.return-policy-content').should('be.visible');
});

And('the page layout should be responsive', () => {
    cy.get('.responsive-layout').should('be.visible');
});

When('I change the site language to Spanish', () => {
    cy.get('#language-selector').select('Spanish');
});

Then('the return policy details should be displayed in Spanish', () => {
    cy.get('.return-policy-content').should('contain', 'Política de devoluciones');
});