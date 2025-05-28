import { should } from 'chai';

class SignupPage {
    static visit() {
        cy.visit('/signup');
    }

    static enterEmail(email) {
        cy.get('#email').type(email);
    }

    static submitForm() {
        cy.get('#signupForm').submit();
    }

    static clickPrivacyPolicy() {
        cy.get('#privacyPolicyLink').click();
    }

    static confirmationMessage() {
        return cy.get('#confirmationMessage');
    }

    static errorMessage() {
        return cy.get('#errorMessage');
    }

    static alreadyRegisteredMessage() {
        return cy.get('#alreadyRegisteredMessage');
    }

    static returnToSignupPage() {
        cy.get('#returnToSignup').click();
    }

    static checkEmailAdded(email) {
        cy.request('GET', '/api/emails').its('body').should('include', email);
    }

    static checkEmailNotAdded(email) {
        cy.request('GET', '/api/emails').its('body').should('not.include', email);
    }

    static checkEmailNotAddedAgain(email) {
        cy.request('GET', '/api/emails').its('body').should('not.include', email);
    }

    static verifyPrivacyPolicyLink() {
        cy.get('#privacyPolicyLink').should('have.attr', 'href').and('include', 'privacy');
    }

    static fillSignupForm(email, password) {
        this.enterEmail(email);
        cy.get('#password').type(password);
    }

    static verifyFormSubmission() {
        this.confirmationMessage().should('be.visible');
    }

    static verifyErrorMessage() {
        this.errorMessage().should('be.visible');
    }
}

export default SignupPage;