describe('User Registration Test', () => {
  const email = 'testuser@example.com';
  const password = 'Test@1234';

  before(() => {
    cy.visit('/registration');
  });

  it('Should display registration page with all required fields', () => {
    cy.get('form').should('be.visible');
    cy.get('input[name="email"]').should('exist');
    cy.get('input[name="password"]').should('exist');
    cy.get('input[name="confirmPassword"]').should('exist');
  });

  it('Should register a user with valid email and password', () => {
    cy.get('input[name="email"]').type(email);
    cy.get('input[name="password"]').type(password);
    cy.get('input[name="confirmPassword"]').type(password);
    cy.get('button[type="submit"]').click();
    cy.url().should('include', '/welcome');
  });

  it('Should receive a confirmation email and activate account', () => {
    cy.wait(5000); // Wait for email delivery
    cy.task('getLastEmail').then(email => {
      expect(email.to).to.equal(email);
      expect(email.subject).to.include('Registration Confirmation');
      cy.visit(email.body.match(/https?:\/\/\S+/)[0]);
      cy.url().should('include', '/activated');
    });
  });
});