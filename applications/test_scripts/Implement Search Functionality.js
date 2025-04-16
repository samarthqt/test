describe('Search Functionality', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUser', 'validPassword');
  });

  it('should display relevant content for various search keywords', () => {
    const searchPage = new SearchPage();
    const keywords = ['Privacy Settings', 'Instant Activation', 'Login History'];
    keywords.forEach(keyword => {
      searchPage.search(keyword);
      searchPage.verifyResults(keyword);
    });
  });

  it('should display no results for non-existent keyword', () => {
    const searchPage = new SearchPage();
    searchPage.search('NonExistentKeyword');
    searchPage.verifyNoResults();
  });

  it('should support partial keyword matches', () => {
    const searchPage = new SearchPage();
    searchPage.search('Priv');
    searchPage.verifyPartialMatches();
  });

  it('should have sorting and filtering options', () => {
    const searchPage = new SearchPage();
    searchPage.verifySortingAndFilteringOptions();
  });

  it('should handle special characters in the keyword', () => {
    const searchPage = new SearchPage();
    searchPage.search('@Privacy!');
    searchPage.verifyResultsHandlingSpecialCharacters();
  });

  it('should be accessible on both desktop and mobile', () => {
    cy.viewport('iphone-6');
    const searchPage = new SearchPage();
    searchPage.verifySearchAccessibility();
    cy.viewport('macbook-15');
    searchPage.verifySearchAccessibility();
  });

  it('should handle very long keywords', () => {
    const searchPage = new SearchPage();
    searchPage.search('a'.repeat(500));
    searchPage.verifyResultsForLongKeywords();
  });

  it('should be responsive and provide results in real-time', () => {
    const searchPage = new SearchPage();
    searchPage.search('Privacy Settings');
    searchPage.verifyRealTimeResults();
  });
});