import { expect } from 'chai';

class AccountSettingsPage {

  static verifyUserLoggedIn() {
    cy.get('#account').should('exist');
  }

  static navigateToSettings() {
    cy.get('#settings').click();
  }

  static enterCurrentPassword(password) {
    cy.get('#currentPassword').type(password);
  }

  static enterNewPassword(password) {
    cy.get('#newPassword').type(password);
  }

  static confirmNewPassword(password) {
    cy.get('#confirmPassword').type(password);
  }

  static changePassword(currentPassword, newPassword) {
    this.enterCurrentPassword(currentPassword);
    this.enterNewPassword(newPassword);
    this.confirmNewPassword(newPassword);
    cy.get('#changePasswordButton').click();
  }

  static verifyPasswordChanged() {
    cy.get('#successMessage').should('contain', 'Password changed successfully');
    cy.get('#confirmationMessage').should('contain', 'Your password has been changed');
    cy.get('#auditLog').should('contain', 'Password change logged');
  }

  static verifyErrorMessage() {
    cy.get('#errorMessage').should('contain', 'Incorrect current password');
  }

  static verifyPasswordNotChanged() {
    cy.get('#passwordStatus').should('not.contain', 'Password changed');
  }

  static verifyGDPRCompliance() {
    cy.get('#gdprCompliance').should('contain', 'Complies with GDPR');
  }

  static ensurePasswordChangeSectionVisible() {
    cy.get('#changePassword').should('exist');
  }

}

export default AccountSettingsPage;