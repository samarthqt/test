import { } from 'cypress' 

class NavigationPage { 

  static visitAnyPage() { 
    cy.visit('/any-page') 
  } 

  static navigateToAnotherPage() { 
    cy.get('.nav-link').first().click() 
  } 

  static verifyConsistentNavigation() { 
    cy.get('.navbar').should('be.visible') 
  } 

  static visitHomePage() { 
    cy.visit('/') 
  } 

  static navigateToPageByName(pageName) { 
    cy.get(`.nav-link:contains(${pageName})`).click() 
  } 

  static verifyPageTitle(expectedTitle) { 
    cy.title().should('eq', expectedTitle) 
  } 

  static verifyElementVisibility(selector) { 
    cy.get(selector).should('be.visible') 
  } 

  static checkUrlContains(expectedUrlFragment) { 
    cy.url().should('include', expectedUrlFragment) 
  } 

  static clickOnElement(selector) { 
    cy.get(selector).click() 
  } 

  static verifyElementText(selector, expectedText) { 
    cy.get(selector).should('have.text', expectedText) 
  } 

  static verifyElementContainsText(selector, expectedText) { 
    cy.get(selector).should('contain.text', expectedText) 
  } 

} 

export default NavigationPage