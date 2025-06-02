import { expect } from 'chai';
import { Cypress } from 'cypress';

class SystemSettingsPage {
 static visit() {
 cy.visit('/settings');
 }

 static checkSystemLogs() {
 cy.get('#systemLogs').click();
 }

 static verifyLogs() {
 cy.get('#logs').should('not.contain.text', 'error');
 cy.get('#logs').should('contain.text', 'access attempt');
 }

 static checkBusinessHours() {
 cy.get('#businessHours').click();
 }

 static verifyBusinessHoursDisplay() {
 cy.get('#businessHoursDisplay').should('contain.text', '9 AM - 5 PM');
 }

 static changeBusinessHours(newHours = '8 AM - 4 PM') {
 cy.get('#editBusinessHours').click();
 cy.get('#businessHoursInput').clear().type(newHours);
 cy.get('#saveBusinessHours').click();
 }

 static checkNotifications() {
 cy.get('#notifications').click();
 }

 static verifyNotifications(message = 'business hours changed') {
 cy.get('#notificationMessage').should('contain.text', message);
 }

 static comparePerformance() {
 cy.get('#performanceMetrics').click();
 }

 static verifyPerformance() {
 cy.get('#performanceComparison').should('contain.text', 'unaffected');
 }
}

export default SystemSettingsPage;