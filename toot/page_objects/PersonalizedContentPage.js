import { login, logout, setCategories, clearBehaviorData, setPurchaseHistory } from '../helpers/UserActions';
import { visitPage } from '../helpers/Navigation';

class PersonalizedContentPage {
  
  static login() {
    login();
  }
  
  static logout() {
    logout();
  }
  
  static visitHomepage() {
    visitPage('/homepage');
  }
  
  static visitPromotionsPage() {
    visitPage('/promotions');
  }
  
  static setUserCategories(categories = ['electronics', 'books']) {
    setCategories(categories);
  }
  
  static setPurchaseHistory(purchaseHistory = ['gadgets', 'furniture']) {
    setPurchaseHistory(purchaseHistory);
  }
  
  static updateUserCategories(categories = ['fashion', 'home']) {
    setCategories(categories);
  }
  
  static clearUserBehaviorData() {
    clearBehaviorData();
  }
  
  static verifyPersonalizedBanners(expectedCategories = ['electronics', 'books']) {
    cy.get('.banner').should('contain', expectedCategories[0]).and('contain', expectedCategories[1]);
  }
  
  static verifyPersonalizedPromotions(expectedPurchaseHistory = ['gadgets', 'furniture']) {
    cy.get('.promotion').should('contain', expectedPurchaseHistory[0]).and('contain', expectedPurchaseHistory[1]);
  }
  
  static verifyUpdatedBanners(expectedCategories = ['fashion', 'home']) {
    cy.get('.banner').should('contain', expectedCategories[0]).and('contain', expectedCategories[1]);
  }
  
  static verifyDefaultContent() {
    cy.get('.banner').should('contain', 'default');
    cy.get('.promotion').should('contain', 'default');
  }
  
  static verifyDefaultContentForUnauthenticated() {
    cy.get('.banner').should('contain', 'default');
    cy.get('.promotion').should('contain', 'default');
  }
}

export default PersonalizedContentPage;