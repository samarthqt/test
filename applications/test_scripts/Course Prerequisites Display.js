describe('Course Prerequisites Display', () => {
  const userId = '23456';
  const courseId = 'CRS001';

  before(() => {
    cy.visit('/login');
    cy.get('#userId').type(userId);
    cy.get('#loginButton').click();
  });

  it('should navigate to Course Management module', () => {
    cy.get('#courseManagementNav').click();
    cy.url().should('include', '/course-management');
  });

  it('should display course details for selected course', () => {
    cy.get(`#course-${courseId}`).click();
    cy.get('.course-details').should('be.visible');
  });

  it('should display prerequisites for the course', () => {
    cy.get('.prerequisites').should('be.visible');
  });

  it('should allow enrollment if prerequisites are met', () => {
    cy.get('#enrollButton').click();
    cy.get('.enrollment-status').should('contain', 'Enrollment Successful');
  });
});