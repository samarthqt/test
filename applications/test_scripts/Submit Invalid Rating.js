describe('Submit Invalid Rating', () => {
  const loginPage = new LoginPage();
  const coursePage = new CoursePage();

  before(() => {
    loginPage.navigate();
    loginPage.login('testuser', 'password123');
  });

  it('should not allow selection of more than 5 stars', () => {
    coursePage.navigateToCompletedCourse();
    coursePage.verifyRatingSectionVisible();
    coursePage.selectRating(6);
    coursePage.verifyInvalidRatingMessage();
  });
});