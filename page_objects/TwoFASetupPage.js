import { expect } from 'chai';
import { Selector } from 'testcafe';

class TwoFASetupPage {
  static login(username, password) {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static navigateToSecuritySettings() {
    cy.get('#accountMenu').click();
    cy.get('#securitySettings').click();
  }

  static verifySecuritySettingsPage() {
    cy.url().should('include', '/security-settings');
    cy.contains('Enable 2FA').should('be.visible');
  }

  static selectEnable2FA() {
    cy.get('#enable2FA').click();
  }

  static verify2FAMethodPrompt() {
    cy.contains('Choose 2FA Method').should('be.visible');
  }

  static selectSMSOption() {
    cy.get('#smsOption').click();
  }

  static verifyMobileNumberPrompt() {
    cy.contains('Enter Mobile Number').should('be.visible');
  }

  static enterMobileNumber(number) {
    cy.get('#mobileNumber').type(number);
    cy.get('#submitMobileNumber').click();
  }

  static verifyCodeSent() {
    cy.contains('Verification code sent').should('be.visible');
  }

  static enterVerificationCode(code) {
    cy.get('#verificationCode').type(code);
    cy.get('#submitVerificationCode').click();
  }

  static verifySetupCompletion() {
    cy.contains('2FA setup complete').should('be.visible');
  }

  static logout() {
    cy.get('#logoutBtn').click();
  }

  static loginOnDevice(deviceType, username, password) {
    cy.visit(`/${deviceType}-login`);
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static verify2FACodePrompt() {
    cy.contains('Enter 2FA Code').should('be.visible');
  }

  static enter2FACode(code) {
    cy.get('#2FACode').type(code);
    cy.get('#submit2FACode').click();
  }

  static navigateToAccountSettings() {
    cy.get('#accountMenu').click();
    cy.get('#accountSettings').click();
  }

  static verify2FAEnabledOnAllDevices() {
    cy.contains('2FA enabled').should('be.visible');
  }

  static attemptDisable2FA() {
    cy.get('#disable2FA').click();
  }

  static verifyConfirmationCodePrompt() {
    cy.contains('Enter Confirmation Code').should('be.visible');
  }

  static enterConfirmationCode(code) {
    cy.get('#confirmationCode').type(code);
    cy.get('#submitConfirmationCode').click();
  }

  static verifyDisableConfirmation() {
    cy.contains('2FA disabled').should('be.visible');
  }

  static enable2FAUsingAuthenticatorApp() {
    cy.get('#authenticatorAppOption').click();
  }

  static verifyQRCodePrompt() {
    cy.contains('Scan QR Code').should('be.visible');
  }

  static scanQRCodeAndEnterGeneratedCode(code) {
    cy.get('#generatedCode').type(code);
    cy.get('#submitGeneratedCode').click();
  }

  static verifyAuthenticatorSetupCompletion() {
    cy.contains('Authenticator setup complete').should('be.visible');
  }

  static verifyLoginSuccessOnAllDevices() {
    cy.url().should('include', '/dashboard');
  }
}

export default TwoFASetupPage;