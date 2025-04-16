describe('Course Progress Tracking - View Progress', () => {
  const courseName = 'Introduction to Dynamics 365';
  let courseProgressPage;

  before(() => {
    // Assuming user is already logged in
    courseProgressPage = new CourseProgressPage();
  });

  it('should navigate to course progress page', () => {
    courseProgressPage.visit();
    courseProgressPage.verifyPageIsDisplayed();
  });

  it(`should select '${courseName}' from enrolled courses`, () => {
    courseProgressPage.selectCourse(courseName);
    courseProgressPage.verifyCourseDetailsAreDisplayed(courseName);
  });

  it('should verify completed lessons, assignments, and quizzes are listed', () => {
    courseProgressPage.verifyCompletedItemsAreListed();
  });

  it('should check percentage progress in the course', () => {
    courseProgressPage.verifyPercentageProgress();
  });
});