class DataManagementPage {
  verifyDashboardDisplayed() {
    cy.get('.dashboard').should('be.visible');
  }

  selectAuditTrailSubModule() {
    cy.get('.menu-item-audit-trail').click();
  }
}

class AuditTrailPage {
  verifyAuditTrailPageDisplayed() {
    cy.get('.audit-trail-page').should('be.visible');
  }

  searchChangesByTrialDataIDs(trialDataIDs) {
    cy.get('.search-input').type(trialDataIDs);
    cy.get('.search-button').click();
  }

  verifyChangesDisplayedForTrialDataIDs(trialDataIDs) {
    cy.get('.changes-list').should('contain', trialDataIDs);
  }

  verifyChangeDescriptionForEntries(description) {
    cy.get('.change-description').each(($el) => {
      cy.wrap($el).should('contain', description);
    });
  }

  verifyUserForEntries(user) {
    cy.get('.user-field').each(($el) => {
      cy.wrap($el).should('contain', user);
    });
  }

  verifyReasonForEntries(reason) {
    cy.get('.reason-field').each(($el) => {
      cy.wrap($el).should('contain', reason);
    });
  }

  generateBulkReportForTrialDataIDs(trialDataIDs) {
    cy.get('.generate-report-button').click();
  }

  verifyBulkReportGenerated() {
    cy.get('.bulk-report').should('be.visible');
  }
}