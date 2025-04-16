export class ToolsPage {
  navigateToToolsSection() {
    cy.get('[data-cy=tools-section]').click();
  }

  verifyToolsSectionAccessible() {
    cy.url().should('include', '/tools');
  }

  verifyInToolsSection() {
    cy.url().should('include', '/tools');
  }

  verifyPresenceOfTools(dataTable) {
    dataTable.hashes().forEach((tool) => {
      cy.contains(tool.name).should('be.visible');
    });
  }

  accessKnowledgeBaseTool() {
    cy.get('[data-cy=knowledge-base-tool]').click();
  }

  verifyKnowledgeBaseAccessible() {
    cy.url().should('include', '/knowledge-base');
  }

  verifyInKnowledgeBaseTool() {
    cy.url().should('include', '/knowledge-base');
  }

  performSearchInKnowledgeBase(topic) {
    cy.get('[data-cy=search-input]').type(topic);
    cy.get('[data-cy=search-button]').click();
  }

  verifySearchResults() {
    cy.get('[data-cy=search-results]').should('be.visible');
  }

  accessCallRecordingTool() {
    cy.get('[data-cy=call-recording-tool]').click();
  }

  verifyCallRecordingAccessible() {
    cy.url().should('include', '/call-recording');
  }

  verifyInCallRecordingTool() {
    cy.url().should('include', '/call-recording');
  }

  playRecordedCall() {
    cy.get('[data-cy=play-button]').click();
  }

  verifyRecordedCallPlayed() {
    cy.get('[data-cy=audio-player]').should('have.attr', 'playing');
  }

  accessCustomerFeedbackTool() {
    cy.get('[data-cy=customer-feedback-tool]').click();
  }

  verifyCustomerFeedbackAccessible() {
    cy.url().should('include', '/customer-feedback');
  }

  verifyInCustomerFeedbackTool() {
    cy.url().should('include', '/customer-feedback');
  }

  reviewCustomerFeedbackAndRatings() {
    cy.get('[data-cy=feedback-list]').should('be.visible');
  }

  verifyFeedbackAndRatingsVisible() {
    cy.get('[data-cy=feedback-list]').should('be.visible');
  }

  accessPerformanceMetricsTool() {
    cy.get('[data-cy=performance-metrics-tool]').click();
  }

  verifyPerformanceMetricsAccessible() {
    cy.url().should('include', '/performance-metrics');
  }

  verifyInPerformanceMetricsTool() {
    cy.url().should('include', '/performance-metrics');
  }

  reviewPerformanceMetrics() {
    cy.get('[data-cy=metrics-list]').should('be.visible');
  }

  verifyPerformanceMetricsVisible() {
    cy.get('[data-cy=metrics-list]').should('be.visible');
  }

  performTaskUsingTools() {
    cy.get('[data-cy=perform-task-button]').click();
  }

  verifyTaskPerformedSuccessfully() {
    cy.get('[data-cy=task-result]').should('be.visible');
  }

  verifyUsingTools() {
    cy.url().should('include', '/tools');
  }

  verifyToolsDataAccuracy() {
    cy.get('[data-cy=data-accuracy]').should('contain', 'accurate');
  }

  verifyDataIsAccurate() {
    cy.get('[data-cy=data-accuracy]').should('contain', 'accurate');
  }

  tryAccessToolsSection() {
    cy.visit('/tools');
  }

  verifyUnauthorizedAccessDenied() {
    cy.get('[data-cy=login-prompt]').should('be.visible');
  }
}