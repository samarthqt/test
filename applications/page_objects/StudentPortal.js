class StudentPortal {
  login(studentId, password) {
    cy.get('#student-id').type(studentId);
    cy.get('#password').type(password);
    cy.get('#login-button').click();
  }

  verifyDashboard() {
    cy.url().should('include', '/dashboard');
  }

  verifySubmittedProjects() {
    cy.get('#submitted-projects').should('contain', 'AI Research');
  }

  logout() {
    cy.get('#logout-button').click();
    cy.url().should('include', '/login');
  }
}

class ProjectsSection {
  navigateToProjects() {
    cy.get('#menu-projects').click();
  }

  verifyProjectsSection() {
    cy.url().should('include', '/projects');
  }

  createGroup() {
    cy.get('#create-group-button').click();
  }

  submitProject(deadline) {
    cy.get('#submit-project-button').click();
    cy.get('#submission-confirmation').should('contain', 'Successfully submitted');
  }

  verifySubmission() {
    cy.get('#submitted-projects').should('contain', 'AI Research');
  }
}

class GroupCreation {
  enterGroupName(groupName) {
    cy.get('#group-name').type(groupName);
  }

  addMember(studentId) {
    cy.get('#add-member').type(studentId);
    cy.get('#add-member-button').click();
  }

  verifyGroupCreated() {
    cy.get('#group-confirmation').should('contain', 'Group created successfully');
  }
}

class CollaborationTools {
  verifyToolsAccessible() {
    cy.get('#collaboration-tools').should('be.visible');
  }

  completeProject() {
    cy.get('#complete-project').click();
  }
}