class UserRegistrationPage {
  enterEmail(email) {
    cy.get('#email').type(email);
  }

  enterPassword(password) {
    cy.get('#password').type(password);
  }

  confirmPassword(password) {
    cy.get('#confirmPassword').type(password);
  }

  enterFullName(fullName) {
    cy.get('#fullName').type(fullName);
  }

  enterPhoneNumber(phoneNumber) {
    cy.get('#phoneNumber').type(phoneNumber);
  }

  clickRegister() {
    cy.get('#registerButton').click();
  }
}

export default UserRegistrationPage;