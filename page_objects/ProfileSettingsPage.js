import { expect } from 'chai';
import { Cypress } from 'cypress';

class ProfileSettingsPage {
  static verifyPage() {
    cy.url().should('include', '/profile-settings');
  }

  static updateEmail(newEmail) {
    cy.get('#emailField').clear().type(newEmail);
  }

  static updateAnotherField(newValue) {
    cy.get('#anotherField').clear().type(newValue);
  }

  static saveChanges() {
    cy.get('#saveChangesButton').click();
  }

  static performUpdate() {
    cy.get('#updateButton').click();
  }

  static verifyEmailUpdated(expectedEmail) {
    cy.get('#emailField').should('have.value', expectedEmail);
  }

  static verifyChangesSaved() {
    cy.get('#successMessage').should('be.visible');
  }

  static verifyConfirmationMessage() {
    cy.get('#confirmationMessage').should('be.visible');
  }

  static verifyConfirmationMessageClarity() {
    cy.get('#confirmationMessage').should('contain', 'update was successful');
  }

  static verifyNoConfirmationMessage() {
    cy.get('#confirmationMessage').should('not.exist');
  }

  static verifyNoErrorMessages() {
    cy.get('#errorMessages').should('not.exist');
  }

  static verifyErrorHandling() {
    cy.get('#errorHandlingMessage').should('be.visible');
  }
}

export default ProfileSettingsPage;