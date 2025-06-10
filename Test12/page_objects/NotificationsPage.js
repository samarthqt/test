import { should } from 'chai';
import 'cypress-xpath';

class NotificationsPage {
  static visitNotificationsPage() {
    cy.visit('/notifications');
  }

  static updateAccountInfo() {
    cy.get('#updateInfo').click();
  }

  static verifyNotificationSent() {
    cy.contains('Notification sent').should('be.visible');
  }

  static clickNotificationBell() {
    cy.get('.notification-bell').click();
  }

  static verifyNotificationBellVisible() {
    cy.get('.notification-bell').should('be.visible');
  }

  static getNotificationCount() {
    return cy.get('.notification-count').invoke('text');
  }

  static verifyNotificationCount(expectedCount) {
    this.getNotificationCount().then((count) => {
      expect(count.trim()).to.equal(expectedCount.toString());
    });
  }

  static openNotificationSettings() {
    cy.get('.notification-settings').click();
  }

  static verifyNotificationSettingsOpened() {
    cy.url().should('include', '/notification-settings');
  }

  static toggleNotificationSwitch() {
    cy.get('.notification-switch').click();
  }

  static verifyNotificationSwitchState(expectedState) {
    cy.get('.notification-switch').should('have.class', expectedState ? 'switch-on' : 'switch-off');
  }
}

export default NotificationsPage;