describe('Course Search with Invalid Keyword', () => {
  beforeEach(() => {
    // Assuming user is already logged in
    cy.visit('/course-management');
  });

  it('should handle invalid keyword gracefully', () => {
    const coursePage = new CoursePage();

    // Step 2: Enter invalid keyword
    coursePage.enterSearchKeyword('#$%^&*');
    // Step 3: Click search button
    coursePage.clickSearchButton();
    // Assertion: Verify no courses found message
    coursePage.verifyNoCoursesFoundMessage();

    // Step 4: Enter an empty string
    coursePage.enterSearchKeyword('');
    // Step 5: Click search button
    coursePage.clickSearchButton();
    // Assertion: Verify prompt to enter valid search term
    coursePage.verifyEnterValidSearchTermMessage();
  });
});