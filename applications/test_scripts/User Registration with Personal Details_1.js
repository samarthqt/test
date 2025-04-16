describe('User Registration Test', () => {
  const registrationPage = new RegistrationPage();
  const email = 'user@example.com';
  const password = 'StrongPass123!';
  const firstName = 'John';
  const lastName = 'Doe';
  const dateOfBirth = '01/01/1990';

  it('should register a user with valid details', () => {
    cy.visit('/registration');

    registrationPage.enterEmail(email);
    registrationPage.enterPassword(password);
    registrationPage.enterFirstName(firstName);
    registrationPage.enterLastName(lastName);
    registrationPage.enterDateOfBirth(dateOfBirth);
    registrationPage.clickRegisterButton();

    cy.url().should('include', '/welcome');
  });

  it('should receive a confirmation email and activate account', () => {
    cy.checkEmailInbox(email).then((link) => {
      cy.visit(link);
      cy.url().should('include', '/account-activated');
    });
  });

  it('should login with registered email and password', () => {
    cy.visit('/login');

    registrationPage.login(email, password);

    cy.url().should('include', '/dashboard');
  });
});