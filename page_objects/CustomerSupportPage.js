import 'cypress-xpath';

class CustomerSupportPage {

  static visit() {
    cy.visit('/customer-support');
  }

  static verifyPageUrl() {
    cy.url().should('include', '/customer-support');
  }

  static verifyContactInformation() {
    this.verifyPageUrl();
    cy.get('#contactInfo').should('be.visible');
  }

  static clickContactSupport() {
    cy.get('#contactSupportButton').click();
  }

  static fillContactForm(name, email, message) {
    cy.get('#nameField').type(name);
    cy.get('#emailField').type(email);
    cy.get('#messageField').type(message);
  }

  static submitContactForm() {
    cy.get('#submitContactFormButton').click();
  }

  static verifyContactSuccess() {
    cy.get('#contactSuccessMessage').should('be.visible');
  }

  static verifyErrorMessage() {
    cy.get('#contactErrorMessage').should('be.visible');
  }

  static contactSupport(name, email, message) {
    this.clickContactSupport();
    this.fillContactForm(name, email, message);
    this.submitContactForm();
  }

}

export default CustomerSupportPage;