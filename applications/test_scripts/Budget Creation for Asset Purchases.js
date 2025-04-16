describe('Budget Creation for Asset Purchases', () => {
  const budgetName = 'Asset Purchase 2023';
  const budgetAmount = '$100,000';
  const startDate = '01/01/2023';
  const endDate = '12/31/2023';

  before(() => {
    cy.login(); // Assume a custom command for logging in
  });

  it('should navigate to Budget Management module', () => {
    cy.visit('/budget-management');
    cy.url().should('include', '/budget-management');
  });

  it('should create a new budget', () => {
    const budgetPage = new BudgetPage();
    budgetPage.clickCreateNewBudget();
    budgetPage.enterBudgetName(budgetName);
    budgetPage.enterBudgetAmount(budgetAmount);
    budgetPage.selectStartDate(startDate);
    budgetPage.selectEndDate(endDate);
    budgetPage.clickSave();
    cy.contains('Budget is saved successfully').should('be.visible');
  });

  it('should verify the budget in Budget Overview', () => {
    cy.visit('/budget-overview');
    cy.url().should('include', '/budget-overview');
    cy.get('input[name="search"]').type(budgetName);
    cy.contains(budgetName).should('be.visible').click();
    cy.get('.budget-details').within(() => {
      cy.contains(budgetName).should('be.visible');
      cy.contains(budgetAmount).should('be.visible');
      cy.contains(startDate).should('be.visible');
      cy.contains(endDate).should('be.visible');
    });
  });
});