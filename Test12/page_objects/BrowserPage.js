import { expect } from 'chai';
import { browser } from 'cypress';

class BrowserPage {
  static openInBrowser(browserName) {
    cy.visit('/', { browser: browserName });
  }

  static navigateThroughApplication() {
    cy.get('nav').find('a').each(($el) => {
      cy.wrap($el).click();
      cy.url().should('include', $el.attr('href'));
    });
  }

  static verifyApplicationFunctionality() {
    cy.get('button#start').click();
    cy.get('div#output').should('be.visible');
  }

  static checkForMajorUpdate() {
    cy.request('/api/version').then((response) => {
      expect(response.body.version).to.match(/^\d+\.\d+\.\d+$/);
    });
  }

  static executeCompatibilityTests() {
    const browsers = ['chrome', 'firefox', 'edge'];
    browsers.forEach((browserName) => {
      BrowserPage.openInBrowser(browserName);
      BrowserPage.verifyApplicationFunctionality();
    });
  }

  static openInDifferentBrowsers() {
    const browsers = ['chrome', 'firefox', 'edge'];
    browsers.forEach((browserName) => {
      BrowserPage.openInBrowser(browserName);
    });
  }

  static resizeBrowserWindow() {
    cy.viewport(800, 600);
    cy.get('header').should('be.visible');
    cy.viewport(1200, 800);
    cy.get('header').should('be.visible');
  }

  static verifyResponsiveDesign() {
    cy.viewport('iphone-x');
    cy.get('nav').should('have.css', 'display', 'none');
    cy.viewport('macbook-15');
    cy.get('nav').should('have.css', 'display', 'flex');
  }

  static checkUnsupportedFeatures() {
    cy.get('body').then(($body) => {
      if ($body.find('feature-unsupported').length) {
        cy.get('feature-unsupported').should('be.visible');
      }
    });
  }

  static accessWithUnsupportedBrowser() {
    cy.visit('/', { browser: 'unsupported-browser' });
    cy.get('body').should('contain', 'Unsupported browser');
  }

  static verifyFallbackSolutions() {
    cy.get('feature-fallback').should('be.visible');
  }
}

export default BrowserPage;