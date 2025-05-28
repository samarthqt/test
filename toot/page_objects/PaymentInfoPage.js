import { expect } from 'chai';
import { PaymentInfoPage } from './PaymentInfoPage';

class PaymentInfoPage {
 static visit() {
 cy.visit('/payment-info');
 }

 static enterPaymentDetails({ cardNumber, expiryDate, cvv }) {
 if (cardNumber) cy.get('#cardNumber').type(cardNumber);
 if (expiryDate) cy.get('#expiryDate').type(expiryDate);
 if (cvv) cy.get('#cvv').type(cvv);
 }

 static savePaymentInfo() {
 cy.get('#savePaymentInfoBtn').click();
 }

 static deletePaymentInfo() {
 cy.get('#deletePaymentInfoBtn').click();
 }

 static verifyPaymentSaved() {
 cy.get('#paymentSaved').should('exist');
 }

 static verifyPaymentNotSaved() {
 cy.get('#paymentSaved').should('not.exist');
 }

 static verifyPaymentRemoved() {
 cy.get('#paymentRemoved').should('exist');
 }

 static verifyConfirmationMessage(message) {
 cy.contains(message).should('be.visible');
 }

 static verifyErrorMessage(message) {
 cy.contains(message).should('be.visible');
 }

 static verifyFieldError(field, errorMessage) {
 cy.get(`#${field}Error`).should('contain', errorMessage);
 }

 static clearPaymentDetails() {
 cy.get('#cardNumber').clear();
 cy.get('#expiryDate').clear();
 cy.get('#cvv').clear();
 }

 static verifyFieldPresence(field) {
 cy.get(`#${field}`).should('exist');
 }

 static verifyFieldAbsence(field) {
 cy.get(`#${field}`).should('not.exist');
 }
}

export default PaymentInfoPage;