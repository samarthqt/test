describe('TC-321 244 Course Progress Tracking - Incorrect Progress Display', () => {
  const courseName = 'Introduction to Dynamics 365';
  beforeEach(() => {
    cy.login();
    cy.visit('/course-progress');
  });
  it('should display the course progress page', () => {
    cy.get(CourseProgressPage.title).should('contain', 'Course Progress');
  });
  it('should select the course and display progress details', () => {
    CourseProgressPage.selectCourse(courseName);
    cy.get(CourseProgressPage.courseDetails).should('contain', courseName);
  });
  it('should verify completed lessons, assignments, and quizzes', () => {
    CourseProgressPage.verifyCompletedItems();
  });
});