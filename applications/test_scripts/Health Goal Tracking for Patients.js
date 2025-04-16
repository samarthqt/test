describe('Health Goal Tracking for Patients', () => {
  before(() => {
    cy.login(); // Assuming there is a custom command for logging in
  });

  it('should allow patients to set and track health and wellness goals', () => {
    const goalTrackingPage = new GoalTrackingPage();

    goalTrackingPage.navigateToGoalTrackingPage();
    goalTrackingPage.verifyGoalTrackingPageDisplayed();

    goalTrackingPage.clickSetNewGoal();
    goalTrackingPage.verifyNewGoalFormDisplayed();

    goalTrackingPage.setGoalType('Weight Loss');
    goalTrackingPage.verifyGoalTypeSelected('Weight Loss');

    goalTrackingPage.setTargetWeightLoss('10 lbs');
    goalTrackingPage.verifyTargetWeightLossSet('10 lbs');

    goalTrackingPage.setGoalDuration('3 months');
    goalTrackingPage.verifyGoalDurationSet('3 months');

    goalTrackingPage.clickSaveGoal();
    goalTrackingPage.verifyGoalSavedOnDashboard();

    goalTrackingPage.verifyGoalTrackingOnDashboard();
  });
});