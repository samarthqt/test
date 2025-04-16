describe('User Registration with Weak Password', () => {
 it('should prevent registration with a weak password', () => {
 cy.visit('/register');
 const registrationPage = new RegistrationPage();
 registrationPage.enterEmail('newuser@example.com');
 registrationPage.enterPassword('123');
 registrationPage.enterFirstName('Charlie');
 registrationPage.enterLastName('Brown');
 registrationPage.enterDateOfBirth('04/04/1994');
 registrationPage.clickRegister();
 registrationPage.verifyWeakPasswordError();
 });
});