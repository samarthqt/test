import { Selector } from 'testcafe';

class page_objects/MarketingSignupPage {

 static visit() {
  cy.visit('/marketing-signup');
 }

 static enterEmail(email) {
  cy.get('#email').type(email);
 }

 static checkOptIn() {
  cy.get('#optInCheckbox').check();
 }

 static uncheckOptIn() {
  cy.get('#optInCheckbox').uncheck();
 }

 static submitForm() {
  cy.get('#signupForm').submit();
 }

 static enterFirstName(firstName) {
  cy.get('#firstName').type(firstName);
 }

 static enterLastName(lastName) {
  cy.get('#lastName').type(lastName);
 }

 static selectCountry(country) {
  cy.get('#country').select(country);
 }

 static validateEmailError() {
  return cy.get('#emailError').should('be.visible');
 }

 static validateSuccessMessage() {
  return cy.get('#successMessage').should('be.visible');
 }

 static validateOptInChecked() {
  return cy.get('#optInCheckbox').should('be.checked');
 }

 static validateOptInUnchecked() {
  return cy.get('#optInCheckbox').should('not.be.checked');
 }

 static validateFormSubmission() {
  cy.get('#signupForm').within(() => {
   cy.get('#email').should('have.value', '');
   cy.get('#firstName').should('have.value', '');
   cy.get('#lastName').should('have.value', '');
  });
 }

}

export default page_objects/MarketingSignupPage;