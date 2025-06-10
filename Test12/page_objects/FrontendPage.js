import { defineConfig } from 'cypress'; 
import 'cypress-xpath'; 

class FrontendPage { 
    static visitWebApp() { 
        cy.visit('/webapp'); 
    } 
    
    static loadApplication() { 
        cy.get('#app').should('be.visible'); 
    } 
    
    static verifyHTML5CSS3JavaScript() { 
        cy.document().should('have.property', 'doctype'); 
        cy.get('head').should('contain', 'CSS3'); 
        cy.window().should('have.property', 'JavaScript'); 
    } 
    
    static visitDynamicWebApp() { 
        cy.visit('/dynamicwebapp'); 
    } 
    
    static requireInteractiveFeatures() { 
        cy.get('#interactive').should('exist'); 
    } 
    
    static verifyReactAngularImplementation() { 
        cy.window().should('have.property', 'React').or('have.property', 'Angular'); 
    } 
    
    static visitMobileApp() { 
        cy.visit('/mobileapp'); 
    } 
    
    static developForMultiplePlatforms() { 
        cy.get('#platforms').should('exist'); 
    } 
    
    static verifyReactNativeFlutterCompatibility() { 
        cy.window().should('have.property', 'ReactNative').or('have.property', 'Flutter'); 
    } 
    
    static visitFrontendApp() { 
        cy.visit('/frontendapp'); 
    } 
    
    static accessOnVariousDevices() { 
        cy.viewport('iphone-x'); 
        cy.viewport('macbook-15'); 
    } 
    
    static verifyResponsivenessAdaptability() { 
        cy.get('#responsive').should('be.visible'); 
    } 
    
    static verifyCodeOptimization() { 
        cy.get('#optimized').should('exist'); 
    } 
    
    static developApplication() { 
        cy.get('#development').should('exist'); 
    } 
    
    static verifySecurityBestPractices() { 
        cy.get('#security').should('exist'); 
    } 
    
    static errorDuringUserInteraction() { 
        cy.get('#error').should('exist'); 
    } 
    
    static verifyErrorHandling() { 
        cy.get('#errorHandling').should('exist'); 
    } 
    
    static accessThroughLatestBrowsers() { 
        cy.get('#browserCompatibility').should('exist'); 
    } 
    
    static verifyBrowserCompatibility() { 
        cy.get('#compatible').should('exist'); 
    } 
    
    static testOnWebAndMobile() { 
        cy.get('#webMobileTest').should('exist'); 
    } 
    
    static confirmFunctionality() { 
        cy.get('#functionality').should('exist'); 
    } 
    
    static visitFrontendProject() { 
        cy.visit('/frontendproject'); 
    } 
    
    static completeProject() { 
        cy.get('#completed').should('exist'); 
    } 
    
    static verifyDocumentation() { 
        cy.get('#documentation').should('exist'); 
    } 
} 

export default FrontendPage;