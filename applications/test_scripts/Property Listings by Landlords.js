describe('Property Listings by Landlords', () => {
  const landlord = new LandlordPage();

  before(() => {
    cy.visit('/login');
    landlord.login('landlord@example.com', 'password');
  });

  it('should allow landlord to list a property with details', () => {
    landlord.navigateToListings();
    landlord.clickAddNewProperty();
    landlord.enterPropertyDescription('2-bedroom apartment');
    landlord.uploadPhotos(['Image1.jpg', 'Image2.jpg']);
    landlord.enterRentDetails('$1500/month');
    landlord.setAvailabilityDate('2023-12-01');
    landlord.submitPropertyListing();
    landlord.verifyListingDetails('P001', {
      description: '2-bedroom apartment',
      photos: ['Image1.jpg', 'Image2.jpg'],
      rent: '$1500/month',
      availability: '2023-12-01'
    });
  });

  after(() => {
    landlord.logout();
  });
});