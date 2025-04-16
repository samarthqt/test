describe('Course Enrollment with Full Capacity Test', () => {
  const courseName = 'Data Science 101';
  const courseId = 'DS-101';

  before(() => {
    cy.login(); // Custom command for user login
  });

  it('Navigates to the course enrollment page', () => {
    cy.visit('/courses/enrollment');
    cy.url().should('include', '/courses/enrollment');
    cy.get('h1').should('contain', 'Course Enrollment');
  });

  it(`Searches for ${courseName} in the course search bar`, () => {
    cy.get('#course-search-bar').type(courseName);
    cy.get('#course-list').should('contain', courseName);
  });

  it(`Selects ${courseName} from the list`, () => {
    cy.get(`#course-${courseId}`).click();
    cy.url().should('include', `/courses/${courseId}`);
    cy.get('h1').should('contain', courseName);
  });

  it('Attempts to enroll in the course', () => {
    cy.get('#enroll-button').click();
    cy.get('.error-message').should('contain', 'Course is at full capacity');
  });
});