describe('Vehicle Service Rating Submission', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ratingsPage = new RatingsPage();
  const providerProfilePage = new ProviderProfilePage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should allow users to rate their experience with service providers', () => {
    // Step 1: Log in to the Service Feedback module
    loginPage.login('U123456', 'password');
    dashboardPage.verifyDashboardIsDisplayed();

    // Step 2: Navigate to the 'Ratings' section
    dashboardPage.navigateToRatings();
    ratingsPage.verifyRatingsSectionIsDisplayed();

    // Step 3: Select the service provider from the list
    ratingsPage.selectServiceProvider('SP001');
    ratingsPage.verifyServiceProviderDetails('SP001');

    // Step 4: Click on 'Rate Service'
    ratingsPage.clickRateService();
    ratingsPage.verifyRatingPromptIsDisplayed();

    // Step 5: Enter the rating and feedback, then submit
    ratingsPage.enterRating(4);
    ratingsPage.enterFeedback('Great service!');
    ratingsPage.submitRating();
    ratingsPage.verifyRatingSubmissionSuccess();

    // Step 6: Verify the rating is updated in the provider's profile
    providerProfilePage.navigateToProviderProfile('SP001');
    providerProfilePage.verifyRatingAndFeedback(4, 'Great service!');
  });
});