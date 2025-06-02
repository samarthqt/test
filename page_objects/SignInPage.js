import { expect } from 'chai';

class SignInPage {
    static visit() {
        cy.visit('/signin');
    }

    static verifySignInPage() {
        cy.url().should('include', '/signin');
    }

    static enterEmail(email) {
        cy.get('#emailField').clear().type(email);
    }

    static enterPassword(password) {
        cy.get('#passwordField').clear().type(password);
    }

    static clickSignInButton() {
        cy.get('#signInBtn').click();
    }

    static submitSignIn() {
        cy.get('#submitSignIn').click();
    }

    static verifyErrorMessage(expectedMessage) {
        cy.get('.error-message').should('contain.text', expectedMessage);
    }

    static verifyPageTitle(expectedTitle) {
        cy.title().should('eq', expectedTitle);
    }

    static verifyFieldError(fieldName, expectedMessage) {
        cy.get(`#${fieldName}-error`).should('contain.text', expectedMessage);
    }
}

export default SignInPage;