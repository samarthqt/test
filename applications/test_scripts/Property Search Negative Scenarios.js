describe('Property Search Negative Scenarios', () => {
  beforeEach(() => {
    cy.login(); // Assume a custom command for login
    cy.visit('/property-search');
  });

  it('should display error for invalid location', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('XYZ');
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'Invalid location');
  });

  it('should display error for invalid price range', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.setPriceRange('-100000', '0');
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'Invalid price range');
  });

  it('should display error for non-existent property type', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.selectPropertyType('Castle');
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'Property type not found');
  });

  it('should display error for additional filters with no match', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.checkAdditionalFilters(['Helipad', 'Cinema']);
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'No properties match these filters');
  });

  it('should display no properties found message for all invalid inputs', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('XYZ');
    propertySearchPage.setPriceRange('-100000', '0');
    propertySearchPage.selectPropertyType('Castle');
    propertySearchPage.checkAdditionalFilters(['Helipad', 'Cinema']);
    propertySearchPage.clickSearch();
    propertySearchPage.getSearchResultMessage().should('contain', 'No properties found');
  });

  it('should prompt to enter at least one filter when none is entered', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'Please enter at least one filter');
  });

  it('should display error for special characters in location', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('!@#$%^&*()');
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'Invalid characters in location');
  });

  it('should display no properties found for unrealistic price range', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.setPriceRange('1', '2');
    propertySearchPage.clickSearch();
    propertySearchPage.getSearchResultMessage().should('contain', 'No properties found in this price range');
  });

  it('should display error for multiple non-existent property types', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.selectMultiplePropertyTypes(['Castle', 'Mansion']);
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'No properties match these types');
  });

  it('should truncate and display error for extremely long location input', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('A'.repeat(256));
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('contain', 'Location too long');
  });

  it('should display properties for valid filters with combination of valid and invalid filters', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('Valid Location');
    propertySearchPage.setPriceRange('-100000', '0');
    propertySearchPage.selectPropertyType('Castle');
    propertySearchPage.clickSearch();
    propertySearchPage.getSearchResultMessage().should('not.contain', 'No properties found');
  });

  it('should remain responsive and display errors promptly', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('XYZ');
    propertySearchPage.setPriceRange('-100000', '0');
    propertySearchPage.selectPropertyType('Castle');
    propertySearchPage.checkAdditionalFilters(['Helipad', 'Cinema']);
    propertySearchPage.clickSearch();
    propertySearchPage.getErrorMessage().should('be.visible');
  });

  it('should generate error logs for invalid search attempts', () => {
    // This test assumes there is a way to check logs, e.g., via network requests
    cy.intercept('POST', '/api/logs', (req) => {
      expect(req.body).to.include('Invalid input');
    });
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('XYZ');
    propertySearchPage.clickSearch();
  });

  it('should display no properties when all filters are invalid', () => {
    const propertySearchPage = new PropertySearchPage();
    propertySearchPage.enterLocation('XYZ');
    propertySearchPage.setPriceRange('-100000', '0');
    propertySearchPage.selectPropertyType('Castle');
    propertySearchPage.checkAdditionalFilters(['Helipad', 'Cinema']);
    propertySearchPage.clickSearch();
    propertySearchPage.getSearchResultMessage().should('contain', 'No properties found');
  });
});