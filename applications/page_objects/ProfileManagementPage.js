class ProfileManagementPage {
  visit() {
    cy.visit('/profile');
  }

  updateName(name) {
    cy.get('#name').clear().type(name);
  }

  getName() {
    return cy.get('#name');
  }

  updateEmail(email) {
    cy.get('#email').clear().type(email);
  }

  getEmail() {
    return cy.get('#email');
  }

  updatePassword(password) {
    cy.get('#password').clear().type(password);
  }

  updatePreferences(receiveNewsletter) {
    cy.get('#newsletter').check(receiveNewsletter);
  }

  getPreferences() {
    return cy.get('#newsletter');
  }

  saveChanges() {
    cy.get('#saveChanges').click();
  }
}