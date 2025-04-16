describe('Submit Course Rating', () => {
  const loginPage = new LoginPage();
  const coursePage = new CoursePage();

  before(() => {
    cy.visit('/login');
    loginPage.login('testuser', 'password');
  });

  it('should submit a 5-star rating and feedback for a course', () => {
    coursePage.navigateToCompletedCourse();
    coursePage.verifyCoursePageDisplayed();
    coursePage.selectRating(5);
    coursePage.enterFeedback('Excellent course with comprehensive material.');
    coursePage.submitRatingAndFeedback();
    coursePage.verifySubmissionSuccess();
  });
});