describe('Course Search by Category', () => {
  const courseManagementPage = new CourseManagementPage();
  before(() => {
    cy.login();
  });
  it('should search for courses under Technology category', () => {
    courseManagementPage.navigate();
    courseManagementPage.selectCategory('Technology');
    courseManagementPage.clickSearch();
    courseManagementPage.verifyCoursesUnderCategory('Technology');
  });
  it('should search for courses under Business category', () => {
    courseManagementPage.selectCategory('Business');
    courseManagementPage.clickSearch();
    courseManagementPage.verifyCoursesUnderCategory('Business');
  });
});