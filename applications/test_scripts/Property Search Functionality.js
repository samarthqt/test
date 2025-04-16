describe('Property Search Functionality', () => {
  const propertySearchPage = new PropertySearchPage();

  before(() => {
    cy.login(); // Custom command to log in the user
  });

  it('should allow users to search for properties based on filters', () => {
    propertySearchPage.navigateToSearchPage();
    propertySearchPage.enterLocation('New York');
    propertySearchPage.setPriceRange('$500,000', '$750,000');
    propertySearchPage.selectPropertyType('Apartment');
    propertySearchPage.applyAdditionalFilters(['Pool', 'Garage']);
    propertySearchPage.clickSearchButton();

    propertySearchPage.verifyAllPropertiesLocation('New York');
    propertySearchPage.verifyAllPropertiesPriceRange(500000, 750000);
    propertySearchPage.verifyAllPropertiesType('Apartment');
    propertySearchPage.verifyPropertiesWithAmenities(['Pool', 'Garage']);
    propertySearchPage.checkNumberOfResults();
    propertySearchPage.sortResultsByPriceAscending();
    propertySearchPage.selectPropertyFromResults();
    propertySearchPage.verifyPropertyDetailsMatchFilters();
    propertySearchPage.checkPropertyAvailability();
  });
});