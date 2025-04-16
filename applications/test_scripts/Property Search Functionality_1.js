describe('Property Search Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const propertySearchPage = new PropertySearchPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('validUser', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should search for properties in Downtown and verify results', () => {
    dashboardPage.navigateToPropertySearch();
    propertySearchPage.verifyPropertySearchPage();
    propertySearchPage.enterLocation('Downtown');
    propertySearchPage.selectPropertyType('Apartment');
    propertySearchPage.clickSearchButton();
    propertySearchPage.verifySearchResults('Downtown');
    propertySearchPage.checkForErrors();
    propertySearchPage.selectPropertyFromResults();
    propertySearchPage.verifySelectedPropertyLocation('Downtown');
  });

  after(() => {
    dashboardPage.logout();
  });
});