import { expect } from 'chai'; 
class OrderConfirmationPage { 
  static completeCheckout() { 
    cy.visit('/checkout'); 
    cy.get('#completeCheckoutButton').click(); 
  } 
  
  static placeOrder() { 
    cy.get('#placeOrderButton').click(); 
  } 
  
  static verifyEmailConfirmation() { 
    cy.get('#emailConfirmation').should('be.visible'); 
  } 
  
  static verifySmsConfirmation() { 
    cy.get('#smsConfirmation').should('be.visible'); 
  } 
  
  static receiveOrderConfirmation() { 
    cy.wait(2000); 
  } 
  
  static verifyOrderNumber() { 
    cy.get('#orderNumber').should('contain.text', 'Order Number'); 
  } 
  
  static verifyShippingAddress() { 
    cy.get('#shippingAddress').should('contain.text', 'Shipping Address'); 
  } 
  
  static verifyItemsPurchased() { 
    cy.get('#itemsPurchased').should('contain.text', 'Items Purchased'); 
  } 
  
  static verifyEstimatedDeliveryDate() { 
    cy.get('#estimatedDeliveryDate').should('contain.text', 'Estimated Delivery Date'); 
  } 
  
  static ensureTimelyDelivery() { 
    cy.get('#confirmationDeliveryTime').should('be.visible'); 
  } 
  
  static verifyMessageFormatting() { 
    cy.get('#confirmationMessage').should('have.class', 'formatted'); 
  } 
  
  static accessOrderDetails() { 
    cy.get('#orderDetailsLink').click(); 
  } 
  
  static logConfirmationMessage() { 
    cy.get('#confirmationLog').should('exist'); 
  } 
  
  static verifyOrderConfirmationDetails() { 
    this.verifyOrderNumber(); 
    this.verifyShippingAddress(); 
    this.verifyItemsPurchased(); 
    this.verifyEstimatedDeliveryDate(); 
  } 
  
  static confirmAllNotifications() { 
    this.verifyEmailConfirmation(); 
    this.verifySmsConfirmation(); 
  } 
} 

export default OrderConfirmationPage;