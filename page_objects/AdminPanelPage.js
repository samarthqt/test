import { expect } from 'chai';
import { cy } from 'cypress';

class AdminPanelPage {
  static visit() {
    cy.visit('/admin');
  }

  static login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static navigateToSettings() {
    cy.get('#settingsMenu').click();
  }

  static verifySettingsSection() {
    cy.get('#settingsSection').should('be.visible');
  }

  static locateConfirmationMessageOptions() {
    cy.get('#confirmationMessageOptions').click();
  }

  static verifyCustomizationOptionsVisible() {
    cy.get('#customizationOptions').should('be.visible');
  }

  static selectConfirmationTemplate() {
    cy.get('#templateSelect').click();
  }

  static verifyTemplateReadyForCustomization() {
    cy.get('#templateEditor').should('be.visible');
  }

  static modifyConfirmationText(newText) {
    cy.get('#confirmationText').clear().type(newText);
  }

  static verifyTextUpdated(expectedText) {
    cy.get('#confirmationText').should('have.value', expectedText);
  }

  static changeFontStyle(fontStyle) {
    cy.get('#fontStyleSelect').select(fontStyle);
  }

  static verifyFontStyleChanged(expectedFont) {
    cy.get('#confirmationMessage').should('have.css', 'font-family', expectedFont);
  }

  static updateColorScheme(color) {
    cy.get('#colorSchemePicker').invoke('val', color).trigger('change');
  }

  static verifyColorSchemeUpdated(expectedColor) {
    cy.get('#confirmationMessage').should('have.css', 'background-color', expectedColor);
  }

  static saveChanges() {
    cy.get('#saveBtn').click();
  }

  static verifyChangesSaved() {
    cy.get('#saveConfirmation').should('be.visible');
  }

  static previewConfirmationMessage() {
    cy.get('#previewBtn').click();
  }

  static verifyPreviewUpdated(expectedText) {
    cy.get('#previewMessage').should('contain', expectedText);
  }

  static revertToDefaultSettings() {
    cy.get('#revertBtn').click();
  }

  static verifyRevertedToDefault(expectedText) {
    cy.get('#confirmationMessage').should('contain', expectedText);
  }

  static logout() {
    cy.get('#logoutBtn').click();
  }
}

export default AdminPanelPage;