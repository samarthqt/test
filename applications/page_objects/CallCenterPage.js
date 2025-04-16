class CallCenterPage {
  dialSupportLine(phoneNumber) {
    cy.get('#dialer-input').type(phoneNumber);
    cy.get('#dial-button').click();
  }

  verifyAutomatedMessage(expectedMessage) {
    cy.get('#automated-message').should('contain.text', expectedMessage);
  }
}

export default CallCenterPage;