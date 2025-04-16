describe('TC-362 273 Validate Gamification Elements for Student Engagement', () => {
  const studentId = 'S001';
  const assignmentId = 'A001';
  const quizId = 'Q001';
  const courseId = 'C001';

  before(() => {
    cy.visit('/login');
    cy.get('#student-id').type(studentId);
    cy.get('#login-button').click();
  });

  it('should log in and navigate to the dashboard', () => {
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to assignments and complete assignment A001', () => {
    cy.get('#assignments-section').click();
    cy.get(`#assignment-${assignmentId}`).click();
    cy.get('#submit-assignment').click();
    cy.get('#assignment-confirmation').should('be.visible');
  });

  it('should verify badges or points for assignment completion', () => {
    cy.get('#profile').click();
    cy.get('#badges-points').should('contain', 'Assignment A001');
  });

  it('should navigate to quizzes and complete quiz Q001', () => {
    cy.get('#quizzes-section').click();
    cy.get(`#quiz-${quizId}`).click();
    cy.get('#submit-quiz').click();
    cy.get('#quiz-confirmation').should('be.visible');
  });

  it('should verify additional badges or points for quiz completion', () => {
    cy.get('#profile').click();
    cy.get('#badges-points').should('contain', 'Quiz Q001');
  });

  it('should navigate to courses and complete course C001', () => {
    cy.get('#courses-section').click();
    cy.get(`#course-${courseId}`).click();
    cy.get('#submit-course').click();
    cy.get('#course-confirmation').should('be.visible');
  });

  it('should verify badges or points for course completion', () => {
    cy.get('#profile').click();
    cy.get('#badges-points').should('contain', 'Course C001');
  });

  it('should not award badge for incomplete assignment', () => {
    cy.get('#claim-badge').click();
    cy.get('#error-message').should('contain', 'Incomplete assignment');
  });

  it('should not award points for unattempted quiz', () => {
    cy.get('#claim-points').click();
    cy.get('#error-message').should('contain', 'Unattempted quiz');
  });

  it('should verify badge and point persistence after re-login', () => {
    cy.get('#logout').click();
    cy.get('#login').click();
    cy.get('#student-id').type(studentId);
    cy.get('#login-button').click();
    cy.get('#profile').click();
    cy.get('#badges-points').should('be.visible');
  });

  it('should allow admin to adjust badges or points', () => {
    cy.get('#admin-login').click();
    cy.get('#adjust-badges-points').click();
    cy.get('#profile').click();
    cy.get('#badges-points').should('be.visible');
  });

  it('should prevent awarding badge for non-existent course', () => {
    cy.get('#award-badge').click();
    cy.get('#error-message').should('contain', 'Non-existent course');
  });
});