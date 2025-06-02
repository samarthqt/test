import { expect } from 'chai'; 
import 'cypress-file-upload'; 

class ResponsivePage { 
  static openApplication() { 
    cy.visit('/application'); 
  } 
  
  static navigateThroughApplication() { 
    // Implement navigation logic 
    cy.get('.nav-link').each(($el) => { 
      cy.wrap($el).click(); 
      cy.url().should('include', $el.attr('href')); 
    }); 
  } 
  
  static checkLayoutAndAlignment() { 
    cy.get('body').should('have.css', 'display', 'flex'); 
  } 
  
  static checkImagesAndMultimedia() { 
    cy.get('img').each(($img) => { 
      cy.wrap($img).should('be.visible').and(($img) => { 
        expect($img[0].naturalWidth).to.be.greaterThan(0); 
      }); 
    }); 
  } 
  
  static testInteractiveElements() { 
    cy.get('button').should('not.be.disabled').click({ multiple: true }); 
  } 
  
  static scrollThroughApplication() { 
    cy.scrollTo('bottom'); 
    cy.scrollTo('top'); 
  } 
  
  static checkFontSizesAndReadability() { 
    cy.get('body').should('have.css', 'font-size').and('match', /[1-9]\d*px/); 
  } 
  
  static identifyResponsivenessIssues() { 
    cy.viewport('iphone-6'); 
    cy.get('body').should('be.visible'); 
    cy.viewport('ipad-2'); 
    cy.get('body').should('be.visible'); 
  } 
  
  static switchOrientations() { 
    cy.viewport('iphone-6', 'landscape'); 
    cy.get('body').should('be.visible'); 
    cy.viewport('iphone-6', 'portrait'); 
    cy.get('body').should('be.visible'); 
  } 
  
  static verifyApplicationLoad() { 
    cy.window().should('have.property', 'loadTime').and('be.lt', 3000); 
  } 
  
  static verifyNavigationSmoothness() { 
    cy.get('.nav-link').first().click(); 
    cy.window().its('scrollY').should('equal', 0); 
  } 
  
  static verifyUIAlignment() { 
    cy.get('.container').should('have.css', 'text-align', 'center'); 
  } 
  
  static verifyImageResizing() { 
    cy.viewport(320, 480); 
    cy.get('img').should('have.css', 'width', '100%'); 
  } 
  
  static verifyInteractiveElements() { 
    cy.get('input[type=text]').type('Test').should('have.value', 'Test'); 
  } 
  
  static verifyScrollingSmoothness() { 
    cy.window().then((win) => { 
      const scrollableElement = win.document.scrollingElement || win.document.body; 
      expect(scrollableElement.scrollTop).to.be.eq(0); 
    }); 
  } 
  
  static verifyFontConsistency() { 
    cy.get('body').then(($body) => { 
      const font = $body.css('font-family'); 
      cy.get('*').each(($el) => { 
        expect($el).to.have.css('font-family', font); 
      }); 
    }); 
  } 
  
  static documentAndReportIssues() { 
    cy.log('Documenting issues...'); 
    cy.screenshot('issues_screenshot'); 
    cy.task('generateReport'); 
  } 
  
  static verifyOrientationAdaptability() { 
    cy.viewport(1280, 720); 
    cy.get('body').should('be.visible'); 
    cy.viewport(720, 1280); 
    cy.get('body').should('be.visible'); 
  } 
} 

export default ResponsivePage;