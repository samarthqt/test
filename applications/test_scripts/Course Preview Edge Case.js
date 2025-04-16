describe('TC-352 265 Course Preview Edge Case', () => {
  before(() => {
    // Assuming user is already logged in
    cy.visit('/dashboard');
  });

  it('should navigate to the course management dashboard', () => {
    cy.url().should('include', '/dashboard');
  });

  it('should select a course with ID 102 from the course list', () => {
    const courseManagementPage = new CourseManagementPage();
    courseManagementPage.selectCourseById('102');
    cy.url().should('include', '/course-details/102');
  });

  it('should display a message indicating no preview content is available', () => {
    const courseDetailsPage = new CourseDetailsPage();
    courseDetailsPage.clickPreviewButton();
    courseDetailsPage.getNoPreviewMessage().should('be.visible').and('contain', 'No preview content is available for this course.');
  });
});