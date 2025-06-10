import { expect } from 'chai';
class AccountSecurityPage {
  static visit() {
    cy.visit('/account-security');
  }

  static performAccountActions() {
    cy.get('#accountAction').click();
  }

  static verifySecurityMeasures() {
    cy.contains('Security measures active').should('be.visible');
  }

  static checkTwoFactorAuthEnabled() {
    cy.get('#twoFactorAuthStatus').should('contain', 'Enabled');
  }

  static enableTwoFactorAuth() {
    cy.get('#enableTwoFactorAuthButton').click();
    cy.contains('Two-factor authentication enabled').should('be.visible');
  }

  static disableTwoFactorAuth() {
    cy.get('#disableTwoFactorAuthButton').click();
    cy.contains('Two-factor authentication disabled').should('be.visible');
  }

  static verifyAccountLockoutPolicy() {
    cy.contains('Account lockout policy').should('be.visible');
  }

  static updatePassword(newPassword) {
    cy.get('#passwordInput').clear().type(newPassword);
    cy.get('#updatePasswordButton').click();
    cy.contains('Password updated successfully').should('be.visible');
  }

  static verifyPasswordUpdated() {
    cy.contains('Password updated successfully').should('be.visible');
  }
}
export default AccountSecurityPage;