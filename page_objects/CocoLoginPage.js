import { Selector } from 'testcafe'; 
class CocoLoginPage { 
  constructor() { 
    this.loginScreen = Selector('.login-screen'); 
    this.ssoButton = Selector('#loginWithSSO'); 
    this.usernameInput = Selector('#username'); 
    this.passwordInput = Selector('#password'); 
    this.loginButton = Selector('#loginButton'); 
    this.errorMessage = Selector('.error-message'); 
  } 
  
  static visit() { 
    cy.visit('/coco-login'); 
  } 
  
  static verifyLoginScreenDisplayed() { 
    cy.get(this.loginScreen).should('be.visible'); 
  } 
  
  static verifySSOButtonVisible() { 
    cy.get(this.ssoButton).should('be.visible'); 
  } 
  
  static enterUsername(username) { 
    cy.get(this.usernameInput).type(username); 
  } 
  
  static enterPassword(password) { 
    cy.get(this.passwordInput).type(password); 
  } 
  
  static clickLoginButton() { 
    cy.get(this.loginButton).click(); 
  } 
  
  static verifyErrorMessageVisible() { 
    cy.get(this.errorMessage).should('be.visible'); 
  } 
} 

export default CocoLoginPage;