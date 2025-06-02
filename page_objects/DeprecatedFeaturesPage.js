import { expect } from 'chai';
import { cy } from 'cypress';

class DeprecatedFeaturesPage {

 static visitPage(url) {
 cy.visit(url);
 }

 static verifyElementExists(selector) {
 cy.get(selector).should('exist');
 }

 static verifyElementContains(selector, text) {
 cy.get(selector).should('contain', text);
 }

 static verifyElementNotContains(selector, text) {
 cy.get(selector).should('not.contain', text);
 }

 static identifyDeprecatedHTMLTags() {
 cy.get('body').then((body) => {
 const deprecatedTags = body.find('font, center, b');
 expect(deprecatedTags.length).to.be.greaterThan(0);
 });
 }

 static verifyDeprecatedHTMLTags() {
 this.verifyElementContains('body', 'font');
 }

 static renderPagesWithDeprecatedTags() {
 cy.get('body').then((body) => {
 const errors = body.find('.error');
 expect(errors.length).to.be.greaterThan(0);
 });
 }

 static verifyPageRenderErrors() {
 this.verifyElementExists('.error');
 }

 static identifyOutdatedCSSProperties() {
 cy.get('style').then((style) => {
 const outdatedProperties = style.text().match(/border-spacing|float/);
 expect(outdatedProperties).to.not.be.null;
 });
 }

 static verifyOutdatedCSSProperties() {
 this.verifyElementContains('style', 'float');
 }

 static applyStylesWithOutdatedProperties() {
 cy.get('body').then((body) => {
 const warnings = body.find('.warning');
 expect(warnings.length).to.be.greaterThan(0);
 });
 }

 static verifyStyleApplicationErrors() {
 this.verifyElementExists('.warning');
 }

 static identifyDeprecatedJSFunctions() {
 cy.get('script').then((script) => {
 const deprecatedFunctions = script.text().match(/escape|unescape/);
 expect(deprecatedFunctions).to.not.be.null;
 });
 }

 static verifyDeprecatedJSFunctions() {
 this.verifyElementContains('script', 'escape');
 }

 static executeScriptsWithDeprecatedFunctions() {
 cy.get('body').then((body) => {
 const errors = body.find('.error');
 expect(errors.length).to.be.greaterThan(0);
 });
 }

 static verifyScriptExecutionErrors() {
 this.verifyElementExists('.error');
 }

 static checkBrowserConsole() {
 cy.window().then((win) => {
 const consoleWarnings = win.console.warn;
 expect(consoleWarnings.length).to.be.greaterThan(0);
 });
 }

 static verifyConsoleWarningsErrors() {
 cy.window().its('console.warn').should('exist');
 }

 static testFunctionalityInUnsupportedBrowsers() {
 cy.get('body').then((body) => {
 const errors = body.find('.error');
 expect(errors.length).to.be.greaterThan(0);
 });
 }

 static verifyFunctionalityFailure() {
 this.verifyElementExists('.error');
 }

 static interactWithUIElements() {
 cy.get('button').click();
 }

 static verifyUIInteractionIssues() {
 this.verifyElementExists('.ui-error');
 }

 static verifyErrorHandling() {
 cy.get('body').then((body) => {
 const errors = body.find('.error');
 expect(errors.length).to.be.greaterThan(0);
 });
 }

 static verifyErrorLogging() {
 this.verifyElementExists('.error-log');
 }

 static ensureApplicationStability() {
 this.verifyElementExists('body');
 }

 static documentDeprecatedFeatures() {
 this.verifyElementExists('body');
 }

 static verifyDocumentationImpact() {
 this.verifyElementContains('.documentation', 'deprecated');
 }

 static verifyReportDelivery() {
 this.verifyElementExists('.report');
 }

 static verifyUpdatedCode() {
 this.verifyElementExists('body');
 }

 static verifyCodeRemoval() {
 this.verifyElementNotContains('body', 'deprecated');
 }
}

export default DeprecatedFeaturesPage;