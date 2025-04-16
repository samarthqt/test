class InstructorLoginPage {
  visit() {
    cy.visit('/instructor/login');
  }
  login(instructorId) {
    cy.get('#instructorId').type(instructorId);
    cy.get('#loginButton').click();
  }
}

class CourseManagementPage {
  navigateToCourse(courseId) {
    cy.get(`#course-${courseId}`).click();
  }
  uploadMaterials() {
    cy.get('#uploadMaterials').attachFile('course-materials.pdf');
  }
  submitForApproval() {
    cy.get('#submitForApproval').click();
  }
  attemptPublishWithoutApproval() {
    cy.get('#publishButton').click();
    cy.contains('Please submit for approval first').should('be.visible');
  }
  modifyAndResubmit() {
    cy.get('#editMaterials').click();
    cy.get('#uploadMaterials').attachFile('updated-materials.pdf');
    cy.get('#submitForApproval').click();
  }
  reviseAndResubmit() {
    cy.get('#reviseMaterials').click();
    cy.get('#uploadMaterials').attachFile('revised-materials.pdf');
    cy.get('#submitForApproval').click();
  }
}

class AdminLoginPage {
  visit() {
    cy.visit('/admin/login');
  }
  login(adminId) {
    cy.get('#adminId').type(adminId);
    cy.get('#loginButton').click();
  }
}

class CourseApprovalPage {
  selectPendingApproval(courseId) {
    cy.get(`#pending-course-${courseId}`).click();
  }
  reviewAndApprove() {
    cy.get('#approveButton').click();
    cy.contains('Course approved successfully').should('be.visible');
  }
}

class CourseCatalogPage {
  visit() {
    cy.visit('/course-catalog');
  }
  verifyCourseIsLive(courseId) {
    cy.contains(`#course-${courseId}`).should('be.visible');
  }
}

class NotificationsPage {
  verifyNotificationReceived(courseId) {
    cy.get('#notifications').should('contain', `Course ${courseId} approved`);
  }
}

class CollaborativePage {
  checkCollaborationSupport(courseId) {
    cy.get(`#collaborate-course-${courseId}`).should('exist');
  }
}

class AuditPage {
  verifyWorkflowLogging() {
    cy.get('#auditLog').should('contain', 'Course approval logged');
  }
}

class SecurityPage {
  attemptUnauthorizedAccess() {
    cy.visit('/unauthorized');
    cy.contains('Access denied').should('be.visible');
  }
}