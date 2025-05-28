import { expect } from 'chai'; 
import 'cypress-xpath'; 

class InventoryPage { 
  static visitInventoryPage() { 
    cy.visit('/inventory'); 
  } 

  static ensureSystemIsOperational() { 
    this.visitInventoryPage(); 
    cy.contains('Inventory System Operational').should('be.visible'); 
  } 

  static setProductThreshold(threshold) { 
    cy.get('#product-threshold').clear().type(threshold); 
  } 

  static setCurrentStockLevel(stockLevel) { 
    cy.get('#current-stock-level').clear().type(stockLevel); 
  } 

  static setProductStockLevels(productId, threshold, currentStock) { 
    cy.get(`#product-${productId}-threshold`).clear().type(threshold); 
    cy.get(`#product-${productId}-current-stock`).clear().type(currentStock); 
  } 

  static ensureWarningMessageIsDisplayed() { 
    cy.contains('Warning: Stock is low').should('be.visible'); 
  } 

  static checkStockLevel() { 
    cy.get('#check-stock-btn').click(); 
  } 

  static checkStockLevels() { 
    cy.get('#check-all-stocks-btn').click(); 
  } 

  static updateStockLevel(newStockLevel) { 
    cy.get('#update-stock-level').clear().type(newStockLevel); 
    cy.get('#update-stock-btn').click(); 
  } 

  static verifyWarningMessageDisplayed() { 
    cy.contains('Warning: Stock is low').should('be.visible'); 
  } 

  static verifyNoWarningMessageDisplayed() { 
    cy.contains('Warning: Stock is low').should('not.exist'); 
  } 

  static verifyWarningMessageRemoved() { 
    this.verifyNoWarningMessageDisplayed(); 
  } 

  static verifyWarningMessageDisplayedForProduct(productId) { 
    cy.get(`#product-${productId}-warning`).should('be.visible'); 
  } 

  static verifyNoWarningMessageDisplayedForProduct(productId) { 
    cy.get(`#product-${productId}-warning`).should('not.exist'); 
  } 
} 

export default InventoryPage;