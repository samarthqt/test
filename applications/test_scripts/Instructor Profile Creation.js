describe('Instructor Profile Creation', () => {
  const instructorName = 'John Doe';
  const bio = 'Experienced instructor in mathematics';
  const teachingExpertise = 'Algebra, Calculus';
  const coursesTaught = 'Algebra 101, Calculus 201';

  before(() => {
    cy.visit('/login');
    cy.login('instructor_username', 'password');
  });

  it('should create an instructor profile successfully', () => {
    cy.get('.dashboard').should('be.visible');
    cy.get('.profile-link').click();
    cy.get('.create-profile-button').click();

    cy.get('#instructorName').type(instructorName);
    cy.get('#bio').type(bio);
    cy.get('#teachingExpertise').type(teachingExpertise);
    cy.get('#coursesTaught').type(coursesTaught);
    cy.get('.submit-profile-button').click();

    cy.get('.confirmation-message').should('contain', 'Profile successfully created');

    cy.get('.profile-details').within(() => {
      cy.get('.instructor-name').should('contain', instructorName);
      cy.get('.bio').should('contain', bio);
      cy.get('.teaching-expertise').should('contain', teachingExpertise);
      cy.get('.courses-taught').should('contain', coursesTaught);
    });
  });

  after(() => {
    cy.logout();
  });
});