class InvestmentPage {
  navigateToInvestmentModule() {
    cy.visit('/investment');
    cy.contains('Investment module is displayed').should('be.visible');
  }

  selectInvestmentType(type) {
    cy.contains(type).click();
    cy.contains('list of available mutual fund investment options').should('be.visible');
  }

  selectSpecificMutualFund() {
    cy.get('.mutual-fund-option').first().click();
    cy.contains('mutual fund details page').should('be.visible');
  }

  enterInvestmentAmount(amount) {
    cy.get('#investment-amount').type(amount);
    cy.get('#investment-amount').should('have.value', amount);
  }

  initiateInvestment() {
    cy.get('#initiate-investment').click();
    cy.contains('confirmation dialog').should('be.visible');
  }

  confirmInvestment() {
    cy.get('#confirm-investment').click();
    cy.contains('investment is successfully initiated').should('be.visible');
  }

  verifyAccountBalance(expectedBalance) {
    cy.get('#account-balance').should('contain.text', expectedBalance);
  }
}