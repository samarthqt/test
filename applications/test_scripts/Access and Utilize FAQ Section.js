describe('FAQ Section Tests', () => {
  const faqPage = new FAQPage();

  beforeEach(() => {
    cy.login('67890');
  });

  it('should navigate to the FAQ section', () => {
    faqPage.navigateToFAQ();
    faqPage.verifyFAQSection();
  });

  it('should search for Password Reset', () => {
    faqPage.search('Password Reset');
    faqPage.verifySearchResults('Password Reset');
  });

  it('should display the Password Reset article', () => {
    faqPage.clickTopSearchResult();
    faqPage.verifyArticleContent('Password Reset');
  });

  it('should navigate back to the main FAQ page', () => {
    faqPage.navigateBackToMain();
    faqPage.verifyFAQMainPage();
  });

  it('should browse through different FAQ categories', () => {
    faqPage.browseCategories();
    faqPage.verifyCategories();
  });

  it('should select a category and view its articles', () => {
    faqPage.selectCategory();
    faqPage.verifyCategoryArticles();
  });

  it('should provide feedback on an article', () => {
    faqPage.provideFeedback();
    faqPage.verifyFeedbackSubmission();
  });

  it('should prompt login when accessing an article without logging in', () => {
    cy.logout();
    faqPage.attemptAccessWithoutLogin();
    faqPage.verifyLoginPrompt();
  });

  it('should access the article after logging in', () => {
    cy.login('67890');
    faqPage.reaccessArticle();
    faqPage.verifyArticleAccess();
  });

  it('should resolve a sample issue using the FAQ section', () => {
    faqPage.resolveSampleIssue();
    faqPage.verifyIssueResolution();
  });

  it('should check for new updates in the FAQ section', () => {
    faqPage.checkForUpdates();
    faqPage.verifyNewUpdates();
  });

  afterEach(() => {
    cy.logout();
  });
});