describe('Product Recommendations Update After New Purchase', () => {
  const homepage = new HomePage();
  const loginPage = new LoginPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('username', 'password');
  });

  it('should display the homepage after login', () => {
    homepage.verifyHomePageDisplayed();
  });

  it('should navigate to the recommendations section', () => {
    homepage.navigateToRecommendations();
    homepage.verifyRecommendationsSectionVisible();
  });

  it('should display MacBook Accessories in recommendations', () => {
    homepage.verifyRecommendedProducts('MacBook Accessories');
  });
});