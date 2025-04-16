class InvestmentManagementPage {
  navigateToInvestmentManagement() {
    cy.visit('/investment-management');
    cy.contains('Investment Management Dashboard').should('be.visible');
  }

  selectProperty(propertyName) {
    cy.get('.property-list').contains(propertyName).click();
    cy.get('.property-details').should('contain', propertyName);
  }

  enterMarketTrendData(data) {
    cy.get('#market-trend-data').type(data);
    cy.get('#market-trend-data').should('have.value', data);
  }

  enterLocationRiskFactors(factors) {
    cy.get('#location-risk-factors').type(factors);
    cy.get('#location-risk-factors').should('have.value', factors);
  }

  calculateRisk() {
    cy.get('#calculate-risk-button').click();
    cy.get('#risk-score').should('be.visible');
  }

  verifyRiskScore() {
    cy.get('#risk-score').then(($score) => {
      const riskScore = parseFloat($score.text());
      expect(riskScore).to.be.within(expectedMin, expectedMax); // Replace with actual expected values
    });
  }

  saveRiskAnalysisReport() {
    cy.get('#save-report-button').click();
    cy.contains('Report saved successfully').should('be.visible');
  }
}