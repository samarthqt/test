describe('Course Search with Edge Case Keyword', () => {
  before(() => {
    cy.login(); // Assuming there's a custom command for logging in
  });

  it('should search with edge case keywords', () => {
    const courseManagementPage = new CourseManagementPage();
    courseManagementPage.navigateToCourseManagement();

    // Test with single character 'A'
    courseManagementPage.enterSearchKeyword('A');
    courseManagementPage.clickSearchButton();
    courseManagementPage.verifySearchResults('A');

    // Test with long keyword
    courseManagementPage.enterSearchKeyword('LongKeywordExceedingNormalLength');
    courseManagementPage.clickSearchButton();
    courseManagementPage.verifySearchResults('LongKeywordExceedingNormalLength');
  });
});