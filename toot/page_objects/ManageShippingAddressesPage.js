import { expect } from 'chai'; 
class ManageShippingAddressesPage { 
  static visit() { 
    cy.visit('/manage-shipping-addresses'); 
  } 
  
  static clickAddNewAddress() { 
    cy.get('#add-new-address-btn').click(); 
  } 
  
  static enterValidShippingAddress(street, city, state, zip) { 
    cy.get('#address-form').within(() => { 
      cy.get('#street').type(street); 
      cy.get('#city').type(city); 
      cy.get('#state').select(state); 
      cy.get('#zip').type(zip); 
    }); 
  } 
  
  static saveNewAddress() { 
    cy.get('#save-address-btn').click(); 
  } 
  
  static verifyAddressAdded(address) { 
    cy.get('#address-list').should('contain', address); 
  } 
  
  static storeOneAddress() { 
    this.enterValidShippingAddress('123 Cypress Lane', 'Testville', 'CA', '90210'); 
    this.saveNewAddress(); 
  } 
  
  static storeMultipleAddresses() { 
    this.storeOneAddress(); 
    this.enterValidShippingAddress('456 Cypress Avenue', 'Sampletown', 'NY', '10001'); 
    this.saveNewAddress(); 
  } 
  
  static verifyMultipleAddressesVisible(addresses) { 
    addresses.forEach(address => { 
      cy.get('#address-list').should('contain', address); 
    }); 
  } 
  
  static proceedToCheckout() { 
    cy.get('#checkout-btn').click(); 
  } 
  
  static selectStoredAddress(address) { 
    cy.get('#address-list').contains(address).click(); 
  } 
  
  static verifyAddressUsedForOrder(address) { 
    cy.get('#order-summary').should('contain', address); 
  } 
  
  static selectAddressToEdit(address) { 
    cy.get('#address-list').contains(address).click(); 
    cy.get('#edit-address-btn').click(); 
  } 
  
  static updateAddressDetails(newStreet) { 
    cy.get('#address-form').within(() => { 
      cy.get('#street').clear().type(newStreet); 
    }); 
  } 
  
  static saveChanges() { 
    cy.get('#save-address-btn').click(); 
  } 
  
  static verifyUpdatedAddress(newAddress) { 
    cy.get('#address-list').should('contain', newAddress); 
  } 
  
  static selectAddressToDelete(address) { 
    cy.get('#address-list').contains(address).click(); 
    cy.get('#delete-address-btn').click(); 
  } 
  
  static confirmDeletion() { 
    cy.get('#confirm-delete-btn').click(); 
  } 
  
  static verifyAddressRemoved(address) { 
    cy.get('#address-list').should('not.contain', address); 
  } 
  
  static verifyRemainingAddressesVisible(address) { 
    cy.get('#address-list').should('contain', address); 
  } 
  
  static enterInvalidShippingAddress() { 
    cy.get('#address-form').within(() => { 
      cy.get('#street').type('Invalid Address'); 
      cy.get('#city').type(''); 
      cy.get('#state').select('--'); 
      cy.get('#zip').type('00000'); 
    }); 
  } 
  
  static attemptToSaveInvalidAddress() { 
    cy.get('#save-address-btn').click(); 
  } 
  
  static verifyErrorMessageDisplayed() { 
    cy.get('#error-message').should('be.visible').and('contain', 'Invalid address'); 
  } 
  
  static verifyInvalidAddressNotAdded() { 
    cy.get('#address-list').should('not.contain', 'Invalid Address'); 
  } 
} 

export default ManageShippingAddressesPage;