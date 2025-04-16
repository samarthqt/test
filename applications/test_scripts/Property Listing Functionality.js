describe('Property Listing Functionality', () => {
  before(() => {
    cy.login();
  });

  it('should allow users to list properties for sale or rent', () => {
    const propertyPage = new PropertyPage();

    propertyPage.navigateToListingPage();
    propertyPage.selectPropertyType('Apartment');
    propertyPage.enterLocation('Los Angeles');
    propertyPage.enterPrice('$650,000');
    propertyPage.enterDescription('Modern apartment with city view');
    propertyPage.uploadImages(['image1.jpg', 'image2.jpg']);
    propertyPage.setAvailabilityStatus('For Sale');
    propertyPage.clickListPropertyButton();

    cy.verifyPropertyInSearchResults('Los Angeles', '$650,000');
    cy.verifyPropertyDetailsPage('Modern apartment with city view', 'For Sale');

    propertyPage.changeListingStatus('For Rent');
    cy.verifyPropertyInRentalSearchResults('Los Angeles');

    propertyPage.editPropertyDetails({
      description: 'Updated modern apartment with city view',
      price: '$700,000'
    });
    cy.verifyUpdatedPropertyDetails('Updated modern apartment with city view', '$700,000');

    propertyPage.checkListingExpirationSettings();
  });
});