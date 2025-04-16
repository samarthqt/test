class InstructorManagementPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  navigateToProfileSection() {
    cy.get('#profileSection').click();
  }

  createNewProfile() {
    cy.get('#createProfileButton').click();
  }

  submitProfileForm() {
    cy.get('#submitProfileForm').click();
  }

  verifyErrorMessages() {
    cy.get('#errorInstructorName').should('contain', 'Instructor Name is required');
    cy.get('#errorBio').should('contain', 'Bio is required');
    cy.get('#errorTeachingExpertise').should('contain', 'Teaching Expertise is required');
    cy.get('#errorCoursesTaught').should('contain', 'Courses Taught is required');
  }

  logout() {
    cy.get('#logoutButton').click();
  }
}