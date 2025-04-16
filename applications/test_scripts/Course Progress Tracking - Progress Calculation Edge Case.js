describe('Course Progress Tracking - Progress Calculation Edge Case Test', () => {
  const courseProgressPage = new CourseProgressPage();

  before(() => {
    // Assume user is already logged in
    cy.visit('/course-progress');
  });

  it('should display the course progress page', () => {
    courseProgressPage.verifyPageLoaded();
  });

  it('should select Introduction to Dynamics 365 course', () => {
    courseProgressPage.selectCourse('Introduction to Dynamics 365');
    courseProgressPage.verifyCourseDetailsDisplayed('Introduction to Dynamics 365');
  });

  it('should verify progress calculation for edge cases', () => {
    courseProgressPage.verifyProgressCalculationEdgeCases();
  });
});