describe('Course Search by Skill Level', () => {
  const coursePage = new CoursePage();

  beforeEach(() => {
    cy.login();
    coursePage.navigateToCourseManagement();
  });

  it('should search for Beginner skill level courses', () => {
    coursePage.selectSkillLevel('Beginner');
    coursePage.clickSearchButton();
    coursePage.verifyCoursesForSkillLevel('Beginner');
  });

  it('should search for Advanced skill level courses', () => {
    coursePage.selectSkillLevel('Advanced');
    coursePage.clickSearchButton();
    coursePage.verifyCoursesForSkillLevel('Advanced');
  });
});