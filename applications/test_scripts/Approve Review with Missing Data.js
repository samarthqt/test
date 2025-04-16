describe('Approve Review with Missing Data', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const reviewModerationPage = new ReviewModerationPage();

    beforeEach(() => {
        cy.visit('/login');
    });

    it('should not approve a review with missing data', () => {
        loginPage.login('moderator', 'password');
        dashboardPage.verifyDashboard();
        dashboardPage.navigateToReviewModeration();

        reviewModerationPage.verifyReviewModerationPage();
        reviewModerationPage.selectReviewById(104);
        reviewModerationPage.attemptToApproveReview();
        reviewModerationPage.verifyErrorMessageForMissingData();
    });
});