import { ensureUserIsLoggedIn, ensureUserIsSubscribed, simulateDeliveryDateApproaching } from './helperFunctions'; 
class SubscriptionPage { 
  static ensureUserIsLoggedIn() { 
    ensureUserIsLoggedIn(); 
  } 
  
  static goToSubscriptionServices() { 
    cy.get('#subscriptionServicesLink').click(); 
  } 
  
  static selectProductToSubscribe() { 
    cy.get('.product-list .product-item').first().click(); 
  } 
  
  static chooseDeliveryFrequency(frequency = 'Weekly') { 
    cy.get('#deliveryFrequencyDropdown').select(frequency); 
  } 
  
  static verifySubscriptionSuccess() { 
    cy.get('.subscription-success-message').should('be.visible'); 
  } 
  
  static ensureUserIsSubscribed() { 
    ensureUserIsSubscribed(); 
  } 
  
  static simulateDeliveryDateApproaching() { 
    simulateDeliveryDateApproaching(); 
  } 
  
  static verifyNotificationReceived() { 
    cy.get('.notification-message').should('contain', 'upcoming delivery'); 
  } 
  
  static goToSubscriptionManagement() { 
    cy.get('#subscriptionManagementLink').click(); 
  } 
  
  static verifySubscriptionManagementAccess() { 
    cy.get('.subscription-management').should('be.visible'); 
  } 
  
  static selectSubscriptionToCancel() { 
    cy.get('.subscription-item .cancel-button').first().click(); 
  } 
  
  static verifyCancellationSuccess() { 
    cy.get('.cancellation-success-message').should('be.visible'); 
  } 
  
  static selectSubscriptionToModify() { 
    cy.get('.subscription-item .modify-button').first().click(); 
  } 
  
  static modifySubscriptionDetails(frequency = 'Monthly') { 
    cy.get('#deliveryFrequencyDropdown').select(frequency); 
  } 
  
  static verifyUpdateSuccess() { 
    cy.get('.update-success-message').should('be.visible'); 
  } 
} 

export default SubscriptionPage;