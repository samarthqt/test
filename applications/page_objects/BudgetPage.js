class BudgetPage {
  clickCreateNewBudget() {
    cy.get('button').contains('Create New Budget').click();
  }

  enterBudgetName(name) {
    cy.get('input[name="budgetName"]').type(name);
  }

  enterBudgetAmount(amount) {
    cy.get('input[name="budgetAmount"]').type(amount);
  }

  selectStartDate(date) {
    cy.get('input[name="startDate"]').type(date);
  }

  selectEndDate(date) {
    cy.get('input[name="endDate"]').type(date);
  }

  clickSave() {
    cy.get('button').contains('Save').click();
  }
}

export default BudgetPage;