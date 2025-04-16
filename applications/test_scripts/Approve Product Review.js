describe('Approve Product Review', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const reviewModerationPage = new ReviewModerationPage();
  const productPage = new ProductPage();

  before(() => {
    cy.visit('/');
  });

  it('should allow moderator to approve a product review', () => {
    // Step 1: Log in to the system using moderator credentials
    loginPage.login('mod1', 'pass123');
    dashboardPage.verifyRedirection();

    // Step 2: Navigate to the 'Review Moderation' section
    dashboardPage.goToReviewModeration();
    reviewModerationPage.verifyPageLoaded();

    // Step 3: Select the review with ID 101 from the list
    reviewModerationPage.selectReviewById(101);
    reviewModerationPage.verifyReviewDetails(101);

    // Step 4: Click on the 'Approve' button
    reviewModerationPage.approveReview();
    reviewModerationPage.verifyReviewApproved();

    // Step 5: Verify that the review is now visible to customers on the product page
    productPage.navigateToProduct(101);
    productPage.verifyReviewVisible(101);
  });
});