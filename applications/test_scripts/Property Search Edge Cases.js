describe('Property Search Edge Cases', () => {
  const propertySearchPage = new PropertySearchPage();

  beforeEach(() => {
    cy.login();
    propertySearchPage.visit();
  });

  it('should prompt for location when location field is empty', () => {
    propertySearchPage.clearLocation();
    propertySearchPage.clickSearch();
    propertySearchPage.verifyLocationPrompt();
  });

  it('should search properties within extreme price range', () => {
    propertySearchPage.setPriceRange('0', '1000000000');
    propertySearchPage.clickSearch();
    propertySearchPage.verifyPropertiesListed();
  });

  it('should prompt with message for single character property type', () => {
    propertySearchPage.setPropertyType('A');
    propertySearchPage.clickSearch();
    propertySearchPage.verifyPropertyTypeTooShort();
  });

  it('should search properties with all additional filters checked', () => {
    propertySearchPage.checkAllAdditionalFilters();
    propertySearchPage.clickSearch();
    propertySearchPage.verifyPropertiesListed();
  });

  it('should handle maximum allowed characters in location field', () => {
    propertySearchPage.setLocation('A'.repeat(256));
    propertySearchPage.clickSearch();
    propertySearchPage.verifyTruncatedSearch();
  });

  it('should process maximum allowed price range', () => {
    propertySearchPage.setPriceRange('0', '1000000000');
    propertySearchPage.clickSearch();
    propertySearchPage.verifyPropertiesListed();
  });

  it('should prompt for uncommon single-character property types', () => {
    propertySearchPage.setPropertyType('Z');
    propertySearchPage.clickSearch();
    propertySearchPage.verifyPropertyTypeNotFound();
  });

  it('should remain responsive with maximum filters applied', () => {
    propertySearchPage.checkAllAdditionalFilters();
    propertySearchPage.clickSearch();
    propertySearchPage.verifySystemResponsive();
  });

  it('should prompt with message for minimum input values', () => {
    propertySearchPage.clearAllFilters();
    propertySearchPage.clickSearch();
    propertySearchPage.verifyPleaseEnterValidFilters();
  });

  it('should process extremely high values in price range fields', () => {
    propertySearchPage.setPriceRange('999999999', '1000000000');
    propertySearchPage.clickSearch();
    propertySearchPage.verifyPropertiesListed();
  });

  it('should prompt for non-standard characters in property type', () => {
    propertySearchPage.setPropertyType('@!');
    propertySearchPage.clickSearch();
    propertySearchPage.verifyInvalidCharactersInPropertyType();
  });

  it('should ensure system stability with extreme search inputs', () => {
    propertySearchPage.setLocation('A'.repeat(256));
    propertySearchPage.setPriceRange('0', '1000000000');
    propertySearchPage.setPropertyType('Z');
    propertySearchPage.checkAllAdditionalFilters();
    propertySearchPage.clickSearch();
    propertySearchPage.verifySystemStable();
  });

  it('should log errors for edge case search attempts', () => {
    propertySearchPage.clearLocation();
    propertySearchPage.setPriceRange('999999999', '1000000000');
    propertySearchPage.setPropertyType('@!');
    propertySearchPage.clickSearch();
    propertySearchPage.verifyErrorLogged();
  });
});