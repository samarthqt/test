import { should } from 'chai'; 
class OrderDetailsPage {
  verifyOrderDetailsDisplayed(orderId) {
    cy.get('#orderDetails').should('contain.text', orderId);
  }
  
  selectOrder(orderId) {
    cy.get(`.order-item[data-order-id=${orderId}]`).click();
  }
  
  updateShipmentStatus(status) {
    cy.get('#shipmentStatus').select(status);
    cy.get('#updateStatusButton').click();
  }
  
  verifyShipmentStatus(status) {
    cy.get('#shipmentStatus').should('have.value', status);
  }
  
  checkAlertSystemForOutgoingAlerts() {
    cy.get('#checkAlertsButton').click();
  }
  
  verifyNoAlertSent() {
    cy.get('#alertMessage').should('not.exist');
  }
  
  verifyErrorLogForAlertFailure(email) {
    cy.get('#errorLog').should('contain', `Failure to send alert to ${email}`);
  }
  
  initiateReturn(accessCode) {
    cy.get(`.access-code[data-access-code=${accessCode}]`).within(() => {
      cy.get('.initiate-return-button').click();
    });
  }
  
  completeReturnForm(reason) {
    cy.get('#return-form').within(() => {
      cy.get('input[name=reason]').type(reason);
      cy.get('button[type=submit]').click();
    });
  }
}
export default OrderDetailsPage;