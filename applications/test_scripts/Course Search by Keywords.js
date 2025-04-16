describe('Course Search by Keywords', () => {
  const courseManagement = new CourseManagementPage();

  beforeEach(() => {
    // Assuming user is already logged in
    cy.visit('/course-management');
  });

  it('should search for courses using the keyword Data Science', () => {
    courseManagement.enterSearchKeyword('Data Science');
    courseManagement.clickSearchButton();
    courseManagement.verifyCourseTitlesContainKeyword('Data Science');
  });

  it('should search for courses using the keyword Machine Learning', () => {
    courseManagement.enterSearchKeyword('Machine Learning');
    courseManagement.clickSearchButton();
    courseManagement.verifyCourseTitlesContainKeyword('Machine Learning');
  });
});