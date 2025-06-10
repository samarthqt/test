import { expect } from 'chai';
import { Cypress } from 'cypress';

class UserProfilePage {

  static visitProfilePage() {
    cy.visit('/profile');
  }

  static verifyLogin() {
    cy.get('#loginStatus').should('be.visible');
  }

  static goToDashboard() {
    cy.get('#accountDashboardLink').click();
  }

  static accessProfile() {
    cy.get('#profileLink').click();
  }

  static updatePersonalInfo(name, email, shippingAddress, billingAddress, phoneNumber) {
    cy.get('#name').clear().type(name);
    cy.get('#email').clear().type(email);
    cy.get('#shippingAddress').clear().type(shippingAddress);
    cy.get('#billingAddress').clear().type(billingAddress);
    cy.get('#phoneNumber').clear().type(phoneNumber);
  }

  static saveChanges() {
    cy.get('#saveButton').click();
  }

  static verifyChangesSaved() {
    cy.get('#successMessage').should('be.visible');
  }

  static prepareEmailPhoneUpdate() {
    cy.get('#email').clear();
    cy.get('#phoneNumber').clear();
  }

  static enterInvalidEmailPhone(invalidEmail, invalidPhone) {
    cy.get('#email').type(invalidEmail);
    cy.get('#phoneNumber').type(invalidPhone);
  }

  static verifyErrorMessage() {
    cy.get('#errorMessage').should('be.visible');
  }

  static verifySuccessfulUpdate() {
    cy.get('#updateSuccess').should('be.visible');
  }

  static verifyNotificationReceived() {
    cy.get('#notification').should('contain', 'Update successful');
  }

  static verifyChangesMade() {
    cy.get('#changesMade').should('be.visible');
  }

  static verifyChangesLogged() {
    cy.get('#auditLog').should('contain', 'Changes logged');
  }

  static prepareSensitiveInfoUpdate() {
    cy.get('#sensitiveInfo').clear();
  }

  static verifyDataEncryption() {
    cy.get('#encryptionStatus').should('contain', 'Encrypted');
  }

  static verifyUpdateMade() {
    cy.get('#updateStatus').should('be.visible');
  }

  static revertChanges() {
    cy.get('#revertButton').click();
  }

  static verifyRevertSuccess() {
    cy.get('#revertSuccess').should('be.visible');
  }
}

export default UserProfilePage;