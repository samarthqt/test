class PropertySearchPage {
  visit() {
    cy.visit('/property-search');
  }

  clearLocation() {
    cy.get('#location').clear();
  }

  setLocation(location) {
    cy.get('#location').type(location);
  }

  setPriceRange(min, max) {
    cy.get('#price-min').clear().type(min);
    cy.get('#price-max').clear().type(max);
  }

  setPropertyType(type) {
    cy.get('#property-type').clear().type(type);
  }

  checkAllAdditionalFilters() {
    cy.get('.additional-filters input[type="checkbox"]').check();
  }

  clearAllFilters() {
    cy.get('.filters input').clear();
  }

  clickSearch() {
    cy.get('#search-button').click();
  }

  verifyLocationPrompt() {
    cy.contains('Please enter a location').should('be.visible');
  }

  verifyPropertiesListed() {
    cy.get('.property-listing').should('exist');
  }

  verifyPropertyTypeTooShort() {
    cy.contains('Property type too short').should('be.visible');
  }

  verifyTruncatedSearch() {
    cy.get('.search-result').should('contain', 'Truncated');
  }

  verifyPropertyTypeNotFound() {
    cy.contains('Property type not found').should('be.visible');
  }

  verifySystemResponsive() {
    cy.get('body').should('not.have.class', 'loading');
  }

  verifyPleaseEnterValidFilters() {
    cy.contains('Please enter valid filters').should('be.visible');
  }

  verifyInvalidCharactersInPropertyType() {
    cy.contains('Invalid characters in property type').should('be.visible');
  }

  verifySystemStable() {
    cy.get('body').should('not.have.class', 'unstable');
  }

  verifyErrorLogged() {
    cy.task('readErrorLogs').should('contain', 'edge case');
  }
}