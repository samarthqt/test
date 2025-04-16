class BudgetManagementPage {
  navigateToBudgetManagement() {
    cy.visit('/budget-management');
  }

  createNewBudget() {
    cy.get('#create-new-budget').click();
  }

  enterBudgetName(name) {
    cy.get('#budget-name').type(name);
  }

  enterBudgetAmount(amount) {
    cy.get('#budget-amount').clear().type(amount);
  }

  saveBudget() {
    cy.get('#save-budget').click();
  }

  verifyErrorMessage(message) {
    cy.get('.error-message').should('contain', message);
  }

  verifyBudgetSaved(amount) {
    cy.get('.budget-amount').should('contain', amount);
  }
}