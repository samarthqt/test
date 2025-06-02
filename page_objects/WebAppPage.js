import { expect } from 'chai';
import { Cypress } from 'cypress';

class WebAppPage {
  static open() {
    cy.visit('/');
  }

  static openInBrowser(browser) {
    cy.visit('/', { browser });
  }

  static navigate(page) {
    cy.get(`[data-page=${page}]`).click();
  }

  static verifyDeployment() {
    cy.get('body').should('exist');
  }

  static verifyLoadSuccess() {
    cy.get('body').should('be.visible');
  }

  static verifyPageDisplay(page) {
    cy.get(`[data-page=${page}]`).should('be.visible');
  }

  static checkCSS3(animationOrTransition) {
    cy.get(`[data-animation=${animationOrTransition}]`).should('have.css', 'animation-name');
  }

  static verifySmoothPlay(animationOrTransition) {
    cy.get(`[data-transition=${animationOrTransition}]`).should('have.css', 'transition-duration');
  }

  static verifyHTML5Playback(mediaType) {
    cy.get(`[data-media=${mediaType}]`).should('have.prop', 'paused', false);
  }

  static verifyMediaPlayback(mediaType) {
    cy.get(`[data-media=${mediaType}]`).should('have.prop', 'ended', false);
  }

  static testJavaScript(interactionType) {
    cy.get(`[data-interaction=${interactionType}]`).click().should('not.exist');
  }

  static verifyFormResponse() {
    cy.get('form').submit().then(() => {
      cy.get('.response').should('be.visible');
    });
  }

  static verifyValidation() {
    cy.get('input').type('test').blur().should('have.class', 'valid');
  }

  static verifyLayoutAdjustment() {
    cy.viewport(1024, 768).get('body').should('have.css', 'width', '1024px');
  }

  static verifyLocalStorage() {
    cy.window().then((win) => {
      expect(win.localStorage.getItem('key')).to.exist;
    });
  }

  static verifyEventHandling() {
    cy.get('button').click().should('have.class', 'clicked');
  }
}

export default WebAppPage;