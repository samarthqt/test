import { expect } from 'chai';

class NotificationsPage {

 static verifyOrderId(orderId) {
 cy.get('#orderId').should('have.value', orderId);
 }

 static login() {
 cy.get('#loginButton').click();
 }

 static verifyLoginSuccess() {
 cy.url().should('include', '/dashboard');
 }

 static navigateOrderHistory() {
 cy.get('#orderHistoryLink').click();
 }

 static verifyOrderHistoryDisplayed() {
 cy.get('#orderList').should('be.visible');
 }

 static verifyTrackingNumber(trackingNumber) {
 cy.get('#trackingNumber').should('have.value', trackingNumber);
 }

 static selectOrderByTrackingNumber(trackingNumber) {
 cy.get(`.order-item[data-tracking=\${trackingNumber}\]`).click();
 }

 static verifyOrderDetailsDisplayed() {
 cy.get('#orderDetails').should('be.visible');
 }

 static verifyNotificationEmail(email) {
 cy.get('#notificationEmail').should('have.value', email);
 }

 static verifyNotificationPhone(phone) {
 cy.get('#notificationPhone').should('have.value', phone);
 }

 static checkNotificationSettings() {
 cy.get('#notificationSettings').click();
 }

 static verifyNotificationSettingsEnabled() {
 cy.get('#notificationEnabled').should('be.checked');
 }

 static simulateStatusChange(status) {
 cy.get('#statusChange').select(status);
 }

 static verifyNotificationSent() {
 cy.get('#notificationAlert').should('be.visible');
 }

 static checkEmailNotifications() {
 cy.get('#emailNotifications').click();
 }

 static verifyEmailNotificationReceived() {
 cy.get('#emailNotification').should('contain', 'Status updated');
 }

 static checkSMSNotifications() {
 cy.get('#smsNotifications').click();
 }

 static verifySMSNotificationReceived() {
 cy.get('#smsNotification').should('contain', 'Status updated');
 }

 static simulateDeliveryCompletion() {
 cy.get('#deliveryCompletion').click();
 }

 static verifyDeliveryNotificationSent() {
 cy.get('#deliveryNotificationAlert').should('be.visible');
 }

 static verifyEmailDeliveryNotificationReceived() {
 cy.get('#emailDeliveryNotification').should('contain', 'Delivery confirmed');
 }

 static verifySMSDeliveryNotificationReceived() {
 cy.get('#smsDeliveryNotification').should('contain', 'Delivery confirmed');
 }

 static logout() {
 cy.get('#logoutButton').click();
 }

 static verifyLogoutSuccess() {
 cy.url().should('include', '/login');
 }

 static checkNotificationHistory() {
 cy.get('#notificationHistory').click();
 }

 static verifyNotificationHistoryDisplayed() {
 cy.get('#notificationLog').should('be.visible');
 }

}

export default NotificationsPage;