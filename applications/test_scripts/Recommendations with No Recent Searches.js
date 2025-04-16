describe('TC-585 451 Recommendations with No Recent Searches', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const recommendationsPage = new RecommendationsPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the system with valid credentials', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyUserLoggedIn();
  });

  it('should navigate to the property recommendations page', () => {
    dashboardPage.goToRecommendations();
    recommendationsPage.verifyPageLoaded();
  });

  it('should display recommendations based solely on current location', () => {
    recommendationsPage.verifyRecommendationsBasedOnLocation('City Center');
  });

  it('should not display any error messages about lack of recent searches', () => {
    recommendationsPage.verifyNoErrorMessages();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyUserLoggedOut();
  });
});