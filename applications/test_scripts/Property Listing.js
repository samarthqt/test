describe('Property Listing', () => {
  const loginPage = new LoginPage();
  const listingsPage = new ListingsPage();
  const newListingPage = new NewListingPage();

  before(() => {
    cy.visit('/');
    loginPage.login('user_with_listing_privileges', 'password');
  });

  it('should allow a user to create a new property listing', () => {
    listingsPage.navigateToListings();
    listingsPage.clickCreateNewListing();

    newListingPage.enterPropertyDetails({
      id: 'P890',
      price: '$250,000',
      location: 'Uptown',
      description: '3-bedroom house with garden'
    });

    newListingPage.uploadImages(['image1.jpg', 'image2.jpg']);
    newListingPage.selectListingType('For Sale');
    newListingPage.reviewDetails();
    newListingPage.submitListing();
  });

  after(() => {
    loginPage.logout();
  });
});