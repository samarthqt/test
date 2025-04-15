describe('Submit Product Review', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const productPage = new ProductPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in, navigate to product page, and submit a review', () => {
    loginPage.login('user123', 'password');
    dashboardPage.verifyUserLoggedIn();
    dashboardPage.navigateToProduct('987654');
    productPage.verifyOnProductPage('987654');
    productPage.submitReview('Great product!', 5);
    productPage.verifyReviewSubmitted('Great product!', 5);
  });
});