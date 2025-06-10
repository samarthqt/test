import { should } from 'chai';

class PersonalInfoPage {
  static visit() {
    cy.visit('/personal-info');
  }

  static updateName(name) {
    cy.get('#name').clear().type(name);
  }

  static updatePhone(phone) {
    cy.get('#phone').clear().type(phone);
  }

  static saveInfo() {
    cy.get('#saveInfoBtn').click();
  }

  static verifyInfoUpdated() {
    cy.contains('Information updated successfully').should('be.visible');
  }

  static updateEmail(email) {
    cy.get('#email').clear().type(email);
  }

  static updateAddress(address) {
    cy.get('#address').clear().type(address);
  }

  static updatePersonalInfo(name, phone, email, address) {
    this.updateName(name);
    this.updatePhone(phone);
    this.updateEmail(email);
    this.updateAddress(address);
  }

  static verifyFieldError(fieldName, errorMessage) {
    cy.get(`#${fieldName}-error`).should('contain', errorMessage);
  }

  static verifyFieldValue(fieldName, expectedValue) {
    cy.get(`#${fieldName}`).should('have.value', expectedValue);
  }
}

export default PersonalInfoPage;