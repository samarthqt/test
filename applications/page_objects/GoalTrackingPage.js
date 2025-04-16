class GoalTrackingPage {
  navigateToGoalTrackingPage() {
    cy.visit('/health-tools/goal-tracking');
  }

  verifyGoalTrackingPageDisplayed() {
    cy.contains('Goal Tracking').should('be.visible');
  }

  clickSetNewGoal() {
    cy.get('button').contains('Set New Goal').click();
  }

  verifyNewGoalFormDisplayed() {
    cy.get('form').should('be.visible');
  }

  setGoalType(goalType) {
    cy.get('select[name="goalType"]').select(goalType);
  }

  verifyGoalTypeSelected(goalType) {
    cy.get('select[name="goalType"]').should('have.value', goalType);
  }

  setTargetWeightLoss(target) {
    cy.get('input[name="targetWeightLoss"]').type(target);
  }

  verifyTargetWeightLossSet(target) {
    cy.get('input[name="targetWeightLoss"]').should('have.value', target);
  }

  setGoalDuration(duration) {
    cy.get('input[name="goalDuration"]').type(duration);
  }

  verifyGoalDurationSet(duration) {
    cy.get('input[name="goalDuration"]').should('have.value', duration);
  }

  clickSaveGoal() {
    cy.get('button').contains('Save Goal').click();
  }

  verifyGoalSavedOnDashboard() {
    cy.contains('Your goal has been saved').should('be.visible');
  }

  verifyGoalTrackingOnDashboard() {
    cy.contains('Weight Loss Progress').should('be.visible');
  }
}