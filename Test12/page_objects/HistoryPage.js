import { expect } from 'chai'; 
class HistoryPage { 
  static visitCompletePurchase() { 
    cy.visit('/complete-purchase'); 
  } 
  
  static visitPurchaseHistory() { 
    cy.visit('/history'); 
  } 
  
  static verifyHistoryIsVisible() { 
    cy.get('#historyList').should('be.visible'); 
  } 
  
  static verifyPurchaseEntryExists(entryText) { 
    cy.get('#historyList').contains(entryText).should('exist'); 
  } 
  
  static verifyNoDuplicateEntries(entryText) { 
    cy.get('#historyList').contains(entryText).then(entries => { 
      expect(entries.length).to.equal(1); 
    }); 
  } 
  
  static getHistoryEntries() { 
    return cy.get('#historyList').children(); 
  } 
  
  static verifyEntryDetails(entryText, expectedDetails) { 
    cy.get('#historyList').contains(entryText).parent().within(() => { 
      cy.get('.entry-details').should('contain', expectedDetails); 
    }); 
  } 
} 

export default HistoryPage;