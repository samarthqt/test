import LoginPage from '../pageObjects/LoginPage';
import HomePage from '../pageObjects/HomePage';

describe('Personalized Recommendations Test', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();

  before(() => {
    cy.visit('/');
  });

  it('should log in and display personalized recommendations', () => {
    loginPage.login('user@example.com', 'password123');
    homePage.verifyHomePageDisplayed();
    homePage.navigateToRecommendationsSection();
    homePage.verifyRecommendationDisplayed('Samsung Galaxy S21');
  });
});