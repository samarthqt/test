describe('Patient Feedback Submission', () => {
  before(() => {
    // Assuming a login function is available
    cy.login('P001');
  });

  it('should allow patients to submit feedback and rate their healthcare providers', () => {
    const feedbackPage = new FeedbackPage();
    const providerProfilePage = new ProviderProfilePage();

    // Step 1: Navigate to the 'Feedback' module
    feedbackPage.navigateToFeedbackModule();
    feedbackPage.verifyFeedbackModulePageDisplayed();

    // Step 2: Select 'Submit Feedback' option
    feedbackPage.selectSubmitFeedbackOption();
    feedbackPage.verifyFeedbackFormDisplayed();

    // Step 3: Enter Provider ID 'D001'
    feedbackPage.enterProviderID('D001');
    feedbackPage.verifyProviderDetailsDisplayed();

    // Step 4: Select a rating of '4'
    feedbackPage.selectRating(4);
    feedbackPage.verifyRatingSelected(4);

    // Step 5: Enter feedback text
    feedbackPage.enterFeedbackText('Great service, very attentive.');

    // Step 6: Click 'Submit'
    feedbackPage.clickSubmit();
    feedbackPage.verifyConfirmationMessage();

    // Step 7: Navigate to the provider's profile page
    providerProfilePage.navigateToProviderProfile('D001');
    providerProfilePage.verifyProviderProfilePageDisplayed();

    // Step 8: Verify the feedback and rating are visible to other users
    providerProfilePage.verifyFeedbackAndRatingVisible('Great service, very attentive.', 4);
  });
});