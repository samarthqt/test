import { expect } from 'chai'
import { cy } from 'cypress'

class OutdatedBrowserPage {

 static visitStage() {
 cy.visit('/stage')
 }

 static openInIE11() {
 cy.visit('/ie11')
 }

 static openInFirefox45() {
 cy.visit('/firefox45')
 }

 static openInChrome49() {
 cy.visit('/chrome49')
 }

 static openInOutdatedBrowser() {
 cy.visit('/outdated-browser')
 }

 static checkFunctionalityIssues() {
 cy.get('body').should('contain', 'functionality issues')
 }

 static navigateHomepage() {
 cy.get('#homepage').click()
 }

 static clickLinksAndButtons() {
 cy.get('a, button').click()
 }

 static repeatSteps() {
 this.checkFunctionalityIssues()
 this.navigateHomepage()
 this.clickLinksAndButtons()
 }

 static navigateApplication() {
 cy.get('#navigation').click()
 }

 static verifyCSSStyles() {
 cy.get('body').should('have.css', 'display', 'block')
 }

 static testFormSubmissions() {
 cy.get('form').submit()
 }

 static checkResponsiveDesign() {
 cy.get('#responsive').should('be.visible')
 }

 static testMediaContent() {
 cy.get('img, video').should('be.visible')
 }

 static verifyInteractiveElements() {
 cy.get('#slider, #dropdown').should('be.visible')
 }

 static checkDeprecatedFeatures() {
 cy.get('body').should('contain', 'deprecated')
 }

 static testAccessibilityFeatures() {
 cy.get('#accessibility').should('be.visible')
 }

 static verifyJavaScriptFunctions() {
 cy.window().then(win => {
 expect(win.someFunction).to.exist
 })
 }

 static checkBrowserWarnings() {
 cy.get('body').should('contain', 'warnings')
 }

 static verifyHomepageElements() {
 cy.get('#homepage-elements').should('not.be.visible')
 }

 static verifyLinksAndButtons() {
 cy.get('a, button').should('not.have.attr', 'disabled')
 }

 static verifyUIDistortions() {
 cy.get('body').should('contain', 'UI distortions')
 }

 static verifyConsoleErrors() {
 cy.log('Checking console errors...')
 }

 static verifyCSSInconsistencies() {
 cy.get('body').should('contain', 'CSS inconsistencies')
 }

 static verifyFormSubmissions() {
 cy.get('form').should('not.have.attr', 'submitted')
 }

 static verifyResponsiveDesign() {
 cy.get('#responsive').should('not.have.css', 'adjusted')
 }

 static verifyMediaContentLoading() {
 cy.get('img, video').should('not.be.visible')
 }

 static verifyInteractiveElementsFunctionality() {
 cy.get('#slider, #dropdown').should('not.be.visible')
 }

 static verifyDeprecatedFeatures() {
 cy.get('body').should('contain', 'deprecated')
 }

 static verifyAccessibilityFeatures() {
 cy.get('#accessibility').should('not.be.visible')
 }

 static verifyJavaScriptExecution() {
 cy.window().then(win => {
 expect(win.someFunction).to.not.exist
 })
 }

 static verifyBrowserWarnings() {
 cy.get('body').should('contain', 'warnings')
 }
}

export default OutdatedBrowserPage