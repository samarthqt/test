class PostExamResultsPage {
  accessResultsSection() {
    cy.visit('/post-exam-results');
  }

  verifyDetailedReport() {
    cy.get('.detailed-report').should('be.visible');
  }

  viewResults() {
    cy.get('.results-view').should('be.visible');
  }

  analyzeResults() {
    cy.get('.analyze-button').click();
  }

  verifyStrengths() {
    cy.get('.strengths').should('be.visible');
  }

  verifyImprovements() {
    cy.get('.improvements').should('be.visible');
  }

  selectSpecificQuestion() {
    cy.get('.question-list .question-item').first().click();
  }

  verifyQuestionAnalysis() {
    cy.get('.question-analysis').should('be.visible');
  }

  verifyCorrectAnswerAndExplanations() {
    cy.get('.correct-answer').should('be.visible');
    cy.get('.explanations').should('be.visible');
  }

  filterResults() {
    cy.get('.filter-button').click();
  }

  filterBySubject() {
    cy.get('.filter-subject').select('Math');
  }

  filterByTopic() {
    cy.get('.filter-topic').select('Algebra');
  }

  verifyPastResultsAvailable() {
    cy.get('.past-results').should('exist');
  }

  compareWithPastResults() {
    cy.get('.compare-button').click();
  }

  verifyComparisonChart() {
    cy.get('.comparison-chart').should('be.visible');
  }

  verifyPerformanceTrends() {
    cy.get('.performance-trends').should('be.visible');
  }

  analyzedResults() {
    cy.get('.results-analyzed').should('exist');
  }

  requestSummaryReport() {
    cy.get('.summary-report-button').click();
  }

  verifySummaryReport() {
    cy.get('.summary-report').should('be.visible');
  }

  verifyRecommendations() {
    cy.get('.recommendations').should('be.visible');
  }
}

export default PostExamResultsPage;