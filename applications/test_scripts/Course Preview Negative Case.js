describe('Course Preview Negative Case', () => {
  const courseID = '103';
  const userID = 'U003';

  beforeEach(() => {
    // Assuming a function loginAsUser is defined to handle user login
    cy.loginAsUser(userID);
    cy.visit('/course-management-dashboard');
  });

  it('should display a permission error when trying to preview a course without enrollment privileges', () => {
    cy.getCourseManagementPage().selectCourseById(courseID);
    cy.getCourseDetailsPage().clickPreviewButton();
    cy.get('.alert-message').should('contain.text', 'You do not have the necessary permissions to view preview content.');
  });
});