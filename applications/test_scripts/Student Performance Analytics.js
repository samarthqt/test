describe('Student Performance Analytics', () => {
  const studentId = 'STU12345';
  const courseId = 'CSE101';

  before(() => {
    cy.visit('/login');
    cy.login(studentId);
  });

  it('should navigate to Analytics section', () => {
    cy.getDashboard().navigateToAnalytics();
    cy.verifyAnalyticsSectionDisplayed();
  });

  it('should select course and display detailed analytics', () => {
    cy.getAnalyticsPage().selectCourse(courseId);
    cy.verifyCourseAnalyticsDisplayed(courseId);
  });

  it('should check assignment and quiz scores', () => {
    cy.verifyScores({ assignments: [85, 90, 78], quizzes: [80, 75] });
  });

  it('should review course completion time', () => {
    cy.verifyCompletionTime('40 hours');
  });

  it('should identify areas for improvement', () => {
    cy.verifyImprovementAreasHighlighted();
  });

  it('should verify analytics data accuracy', () => {
    cy.verifyAnalyticsDataAccuracy();
  });

  after(() => {
    cy.logout();
    cy.verifyRedirectedToLoginPage();
  });
});