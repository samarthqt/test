describe('Location-Based Property Recommendations', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const recommendationsPage = new RecommendationsPage();
  const propertyDetailsPage = new PropertyDetailsPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('validUser', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should display property recommendations based on current location', () => {
    dashboardPage.navigateToRecommendations();
    recommendationsPage.verifyPageLoaded();
    recommendationsPage.verifyRecommendationsForLocation('City Center');
  });

  it('should include properties from recent searches in recommendations', () => {
    recommendationsPage.verifyRecommendationsForRecentSearch('Suburban Area');
  });

  it('should display property details when a recommended property is selected', () => {
    recommendationsPage.selectRecommendedProperty();
    propertyDetailsPage.verifyPropertyDetailsPage();
    propertyDetailsPage.verifyLocationDetails('City Center');
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});