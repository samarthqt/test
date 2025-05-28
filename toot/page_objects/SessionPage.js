import { wait } from '../support/helpers';

class SessionPage {

  static visitDashboard() {
    cy.visit('/dashboard');
  }

  static clickLogin() {
    cy.get('#login').click();
  }

  static simulateInactivity(duration = 60000) {
    cy.wait(duration);
  }

  static verifyAutoLogout() {
    cy.get('#autoLogoutMessage').should('be.visible');
  }

  static checkSessionTimeoutWarning() {
    cy.get('#sessionWarning').should('be.visible');
  }

  static verifyWarningNotification() {
    cy.get('#warningNotification').should('be.visible');
  }

  static performActivity() {
    cy.get('#activityButton').click();
  }

  static verifyTimeoutReset() {
    cy.get('#timeoutResetMessage').should('be.visible');
  }

  static verifySessionTimeout() {
    cy.get('#sessionTimeoutMessage').should('be.visible');
  }

  static accessSessionSettings() {
    cy.visit('/admin/session-settings');
  }

  static adjustTimeoutDuration(duration = 30) {
    cy.get('#timeoutDuration').clear().type(duration.toString());
    cy.get('#saveSettings').click();
  }

  static verifyTimeoutDurationApplied() {
    cy.get('#timeoutAppliedMessage').should('be.visible');
  }

  static loginMultipleDevices() {
    this.visitDashboard();
    this.clickLogin();
  }

  static simulateInactivityOnOneDevice(duration = 60000) {
    this.simulateInactivity(duration);
  }

  static verifySessionTimeoutOnDevice() {
    cy.get('#timeoutDeviceMessage').should('be.visible');
  }

  static verifyUserLoggedInOnOtherDevices() {
    cy.get('#otherDevicesMessage').should('be.visible');
  }

}

export default SessionPage;