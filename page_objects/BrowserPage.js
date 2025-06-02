import { injectAxe, checkA11y } from 'axe-core'; 
class BrowserPage { 
  static visitStage() { 
    cy.visit('/stage'); 
  } 
  static openInIE11() { 
    cy.visit('/', { headers: { 'User-Agent': 'Mozilla/5.0 (compatible; MSIE 11.0; Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko' } }); 
  } 
  static openInFirefox45() { 
    cy.visit('/', { headers: { 'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0' } }); 
  } 
  static openInChrome49() { 
    cy.visit('/', { headers: { 'User-Agent': 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36' } }); 
  } 
  static openInOutdatedBrowser() { 
    cy.visit('/outdated'); 
  } 
  static navigateHomepage() { 
    cy.get('nav').find('a').each(link => { 
      cy.wrap(link).click(); 
      cy.go('back'); 
    }); 
  } 
  static navigateApplication() { 
    cy.get('nav').find('a').click({ multiple: true }); 
  } 
  static clickLinksAndButtons() { 
    cy.get('a, button').each(element => { 
      cy.wrap(element).click(); 
      cy.go('back'); 
    }); 
  } 
  static submitForms() { 
    cy.get('form').each(form => { 
      cy.wrap(form).submit(); 
    }); 
  } 
  static interactWithInteractiveElements() { 
    cy.get('input[type=range], select').each(element => { 
      cy.wrap(element).invoke('val', 50).trigger('change'); 
    }); 
  } 
  static loadMediaContent() { 
    cy.get('img, video').each(media => { 
      cy.wrap(media).should('be.visible'); 
    }); 
  } 
  static checkNoUIDistortions() { 
    cy.get('body').should('not.have.css', 'transform', 'none'); 
  } 
  static checkNoOverlapping() { 
    cy.get('body').should('not.have.css', 'overflow', 'hidden'); 
  } 
  static checkLinksButtonsFunctionality() { 
    cy.get('a, button').should('not.have.attr', 'disabled'); 
  } 
  static checkNoConsoleErrors() { 
    cy.window().then(win => { 
      cy.stub(win.console, 'error').as('consoleError'); 
    }); 
    cy.get('@consoleError').should('not.be.called'); 
  } 
  static observeCSSStyles() { 
    cy.get('head link[rel=stylesheet]').each(style => { 
      cy.wrap(style).should('have.attr', 'href'); 
    }); 
  } 
  static checkCSSConsistency() { 
    cy.get('body').should('have.css', 'color').and('match', /rgb/); 
  } 
  static checkFormSubmission() { 
    cy.url().should('not.include', 'error'); 
  } 
  static observeResponsiveElements() { 
    cy.viewport('iphone-6'); 
    cy.get('body').should('have.css', 'display', 'block'); 
  } 
  static checkResponsiveAdjustment() { 
    cy.get('body').should('not.have.css', 'overflow', 'hidden'); 
  } 
  static checkMediaContentLoading() { 
    cy.get('img').should('have.attr', 'src'); 
    cy.get('video').should('have.attr', 'src'); 
  } 
  static checkInteractiveFunctionality() { 
    cy.get('input[type=range], select').should('have.value', 50); 
  } 
  static checkHTMLCSSFeatures() { 
    cy.document().then(doc => { 
      const deprecated = doc.querySelectorAll('marquee, blink'); 
      expect(deprecated.length).to.equal(0); 
    }); 
  } 
  static checkNoDeprecatedFeatures() { 
    cy.get('marquee, blink').should('not.exist'); 
  } 
  static testAccessibilityFeatures() { 
    injectAxe(); 
    checkA11y(); 
  } 
  static checkAccessibilityFunctionality() { 
    cy.get('body').should('have.attr', 'role'); 
  } 
  static executeJavaScriptFunctions() { 
    cy.window().then(win => { 
      expect(win.someFunction).to.be.a('function'); 
      win.someFunction(); 
    }); 
  } 
  static checkJavaScriptExecution() { 
    cy.window().should('have.property', 'someFunctionExecuted', true); 
  } 
  static observeWarningsSuggestions() { 
    cy.window().then(win => { 
      cy.stub(win.console, 'warn').as('consoleWarn'); 
    }); 
    cy.get('@consoleWarn').should('not.be.called'); 
  } 
  static checkNoBrowserSpecificWarnings() { 
    cy.get('@consoleWarn').should('not.be.called'); 
  } 
  static repeatStepsInFirefox45() { 
    this.openInFirefox45(); 
    this.navigateHomepage(); 
    this.clickLinksAndButtons(); 
  } 
  static repeatStepsInChrome49() { 
    this.openInChrome49(); 
    this.navigateHomepage(); 
    this.clickLinksAndButtons(); 
  } 
} 
export default BrowserPage;