class FAQPage {
  navigateToFAQ() {
    cy.get('#supportModule').click();
    cy.get('#faqSection').click();
  }

  verifyFAQSection() {
    cy.url().should('include', '/faq');
  }

  search(term) {
    cy.get('#faqSearchBar').type(term);
    cy.get('#faqSearchButton').click();
  }

  verifySearchResults(term) {
    cy.get('.search-results').should('contain', term);
  }

  clickTopSearchResult() {
    cy.get('.search-results > :first-child').click();
  }

  verifyArticleContent(title) {
    cy.get('.faq-article').should('contain', title);
  }

  navigateBackToMain() {
    cy.get('#backToMain').click();
  }

  verifyFAQMainPage() {
    cy.url().should('include', '/faq/main');
  }

  browseCategories() {
    cy.get('.faq-categories').click();
  }

  verifyCategories() {
    cy.get('.category-list').should('be.visible');
  }

  selectCategory() {
    cy.get('.category-item:first').click();
  }

  verifyCategoryArticles() {
    cy.get('.category-articles').should('be.visible');
  }

  provideFeedback() {
    cy.get('.feedback-button').click();
    cy.get('.feedback-form').type('Great article!');
    cy.get('.submit-feedback').click();
  }

  verifyFeedbackSubmission() {
    cy.get('.feedback-confirmation').should('be.visible');
  }

  attemptAccessWithoutLogin() {
    cy.get('.faq-article-link').click();
  }

  verifyLoginPrompt() {
    cy.get('.login-prompt').should('be.visible');
  }

  reaccessArticle() {
    cy.get('.faq-article-link').click();
  }

  verifyArticleAccess() {
    cy.get('.faq-article').should('be.visible');
  }

  resolveSampleIssue() {
    cy.get('.sample-issue').click();
    cy.get('.resolve-button').click();
  }

  verifyIssueResolution() {
    cy.get('.resolution-confirmation').should('be.visible');
  }

  checkForUpdates() {
    cy.get('#checkUpdates').click();
  }

  verifyNewUpdates() {
    cy.get('.new-updates').should('be.visible');
  }
}