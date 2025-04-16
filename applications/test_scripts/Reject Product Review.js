describe('Reject Product Review', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const reviewModerationPage = new ReviewModerationPage();
  const productPage = new ProductPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow moderator to reject a product review', () => {
    // Step 1: Log in to the system using moderator credentials
    loginPage.login('mod2', 'pass456');
    dashboardPage.verifyDashboard();

    // Step 2: Navigate to the 'Review Moderation' section
    dashboardPage.goToReviewModeration();
    reviewModerationPage.verifyReviewModerationPage();

    // Step 3: Select the review with ID 102 from the list
    reviewModerationPage.selectReviewById(102);
    reviewModerationPage.verifyReviewDetails(102);

    // Step 4: Click on the 'Reject' button
    reviewModerationPage.rejectReview();
    reviewModerationPage.verifyReviewRejected();

    // Step 5: Verify that the review is not visible to customers on the product page
    productPage.visitProductPage();
    productPage.verifyReviewNotVisible(102);
  });
});