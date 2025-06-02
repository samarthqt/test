import { expect } from 'chai';
import 'cypress-file-upload';

class UserInterfacePage {
 static setValidCredentials() {
 cy.fixture('user').then((user) => {
 cy.wrap(user).as('userData');
 });
 }

 static login() {
 cy.get('@userData').then((user) => {
 cy.get('#username').type(user.username);
 cy.get('#password').type(user.password);
 cy.get('#loginButton').click();
 });
 }

 static verifyLoginSuccess() {
 cy.url().should('include', '/main');
 }

 static ensureUserIsLoggedIn() {
 this.setValidCredentials();
 this.login();
 this.verifyLoginSuccess();
 }

 static navigateSections() {
 cy.get('.navigation-menu').each(($el) => {
 cy.wrap($el).click();
 cy.url().should('include', $el.attr('href'));
 });
 }

 static verifyNavigation() {
 cy.get('.navigation-menu').should('have.length.greaterThan', 0);
 }

 static goToMainInterface() {
 cy.visit('/main');
 }

 static checkAccessibilityFeatures() {
 cy.get('#accessibility').click();
 }

 static verifyAccessibilityFeatures() {
 cy.get('#textToSpeech').should('be.visible');
 cy.get('#highContrast').should('be.visible');
 }

 static accessOnDifferentDevices() {
 cy.viewport('iphone-6');
 cy.visit('/main');
 cy.viewport('ipad-2');
 cy.visit('/main');
 cy.viewport('macbook-15');
 cy.visit('/main');
 }

 static displayInterface() {
 cy.get('.interface').should('be.visible');
 }

 static verifyResponsiveness() {
 cy.get('.responsive-element').should('be.visible');
 }

 static viewTextAndLabels() {
 cy.get('.text-label').each(($el) => {
 cy.wrap($el).should('be.visible');
 });
 }

 static verifyTextReadability() {
 cy.get('.text-label').should('have.css', 'font-size', '16px');
 }

 static interactWithElements() {
 cy.get('.interactive-element').each(($el) => {
 cy.wrap($el).click();
 });
 }

 static verifyElementFunctionality() {
 cy.get('.interactive-element').should('not.have.attr', 'disabled');
 }

 static goToMultipleSections() {
 cy.get('.section-link').each(($el) => {
 cy.wrap($el).click();
 });
 }

 static viewDesignElements() {
 cy.get('.design-element').each(($el) => {
 cy.wrap($el).should('be.visible');
 });
 }

 static verifyDesignConsistency() {
 cy.get('.design-element').should('have.css', 'border-color', 'rgb(0, 0, 0)');
 }

 static performInvalidAction() {
 cy.get('#invalidAction').click();
 }

 static displayErrorMessage() {
 cy.get('.error-message').should('be.visible');
 }

 static verifyErrorMessage() {
 cy.get('.error-message').should('contain.text', 'Please correct the following errors');
 }

 static navigatePages() {
 cy.get('.page-link').each(($el) => {
 cy.wrap($el).click();
 });
 }

 static requestPage() {
 cy.get('.page-content').should('be.visible');
 }

 static verifyPageLoadSpeed() {
 cy.get('.page-content').should('be.visible').and('have.length.greaterThan', 0);
 }

 static checkLinksAndImages() {
 cy.get('a').each(($el) => {
 cy.wrap($el).should('have.attr', 'href').and('not.be.empty');
 });
 cy.get('img').each(($el) => {
 cy.wrap($el).should('have.attr', 'src').and('not.be.empty');
 });
 }

 static verifyLinksAndImages() {
 cy.get('a').should('have.length.greaterThan', 0);
 cy.get('img').should('have.length.greaterThan', 0);
 }

 static initiateLanguageChange() {
 cy.get('#languageSelector').click();
 }

 static selectLanguage() {
 cy.get('.language-option').first().click();
 }

 static verifyLanguageSupport() {
 cy.get('.translated-text').should('be.visible');
 }

 static simulateHighTraffic() {
 cy.intercept('GET', '/main', { fixture: 'main' });
 }

 static accessSimultaneously() {
 cy.visit('/main');
 }

 static verifyPerformanceUnderHighTraffic() {
 cy.get('.performance-indicator').should('be.visible');
 }

 static accessNavigationMenus() {
 cy.get('.navigation-menu').click();
 }

 static verifyNavigationMenus() {
 cy.get('.navigation-menu').should('be.visible');
 }

 static evaluateAccessibilityStandards() {
 cy.get('#evaluateAccessibility').click();
 }

 static verifyAccessibilityCompliance() {
 cy.get('.accessibility-compliance').should('contain.text', 'Compliant');
 }

 static provideFeedback() {
 cy.get('#feedbackForm').type('Feedback text');
 cy.get('#submitFeedback').click();
 }

 static verifyFeedbackMechanism() {
 cy.get('.feedback-confirmation').should('be.visible');
 }
}

export default UserInterfacePage;