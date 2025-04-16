describe('Property Search with Invalid Location', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const propertySearchPage = new PropertySearchPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('validUsername', 'validPassword');
  });

  it('should navigate to the property search page', () => {
    dashboardPage.navigateToPropertySearch();
    propertySearchPage.verifyPageLoaded();
  });

  it('should enter invalid location and search', () => {
    propertySearchPage.enterLocation('Atlantis');
    propertySearchPage.clickSearchButton();
  });

  it('should verify no results found message', () => {
    propertySearchPage.verifyNoResultsMessage();
  });

  it('should check for no unexpected error messages', () => {
    propertySearchPage.verifyNoUnexpectedErrors();
  });

  after(() => {
    dashboardPage.logout();
  });
});