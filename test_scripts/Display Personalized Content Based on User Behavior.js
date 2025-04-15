import LoginPage from '../pageObjects/LoginPage';
import HomePage from '../pageObjects/HomePage';
import CategoryPage from '../pageObjects/CategoryPage';

describe('Personalized Content Display', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const categoryPage = new CategoryPage();

  it('should display personalized content for user U12345', () => {
    loginPage.login('U12345');
    homePage.verifyPersonalizedContent(['electronics', 'smartphones']);
    homePage.verifyBanners(['electronics', 'smartphones']);
    homePage.verifyPromotions(['electronics', 'smartphones']);
    categoryPage.navigateToCategory();
    categoryPage.verifyRecommendations(['electronics', 'smartphones']);
  });

  it('should display personalized content for user U67890', () => {
    loginPage.logout();
    loginPage.login('U67890');
    homePage.verifyPersonalizedContent(['home appliances', 'vacuum cleaners']);
    homePage.verifyBanners(['home appliances', 'vacuum cleaners']);
    homePage.verifyPromotions(['home appliances', 'vacuum cleaners']);
    categoryPage.navigateToCategory();
    categoryPage.verifyRecommendations(['home appliances', 'vacuum cleaners']);
  });

  it('should display generic content for user U12345 after clearing history', () => {
    homePage.clearBrowsingHistory('U12345');
    loginPage.logout();
    loginPage.login('U12345');
    homePage.verifyGenericContent();
    homePage.verifyNoPersonalizedContent();
  });
});