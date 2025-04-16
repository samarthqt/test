class CustomerServicePage {
  visit() {
    cy.visit('/customer-service');
  }

  selectContactChannel() {
    cy.get('.contact-channel').first().click();
  }

  verifyChannelIsActive() {
    cy.get('.contact-channel.active').should('exist');
  }

  enterContactInformation() {
    cy.get('#contact-name').type('John Doe');
    cy.get('#contact-email').type('john.doe@example.com');
    cy.get('#contact-phone').type('1234567890');
  }

  clickButton(buttonName) {
    cy.contains('button', buttonName).click();
  }

  verifyConnectionWithRepresentative() {
    cy.get('.representative-connected').should('be.visible');
  }

  verifyConnectedWithRepresentative() {
    cy.get('.conversation-active').should('exist');
  }

  initiateConversation() {
    cy.get('#message-input').type('Hello, I need help with my account.');
    cy.get('#send-message').click();
  }

  verifyRepresentativeIsResponsive() {
    cy.get('.representative-response').should('be.visible');
  }

  makeInquiriesOrRequests() {
    cy.get('#message-input').type('Can you provide more details on my last transaction?');
    cy.get('#send-message').click();
  }

  verifyRepresentativeResponse() {
    cy.get('.representative-response').should('contain', 'Here are the details of your last transaction');
  }

  verifyInConversation() {
    cy.get('.conversation-active').should('exist');
  }

  endConversation() {
    cy.get('#end-conversation').click();
  }

  verifyConversationEnded() {
    cy.get('.conversation-ended').should('be.visible');
  }

  prepareForMultipleChannels() {
    cy.get('.contact-channel').each(($el) => {
      cy.wrap($el).click();
    });
  }

  repeatProcessForEachChannel() {
    cy.get('.contact-channel').each(($el) => {
      cy.wrap($el).click();
      this.verifyConnectionWithRepresentative();
    });
  }

  verifyConnectionThroughDifferentChannels() {
    cy.get('.representative-connected').should('have.length', 3); // Assuming 3 channels
  }

  verifyRepresentativeAvailability() {
    cy.get('.representative-available').should('exist');
  }

  verifyAvailabilityForEachChannel() {
    cy.get('.representative-available').should('have.length', 3); // Assuming 3 channels
  }

  verifyAvailabilityInformation() {
    cy.get('.availability-info').should('be.visible');
  }

  verifyConnectionInstructions() {
    cy.get('.connection-instructions').should('be.visible');
  }

  verifyAlternativeContactMethods(methods) {
    cy.contains(methods).should('be.visible');
  }

  verifyContactInformation(info) {
    cy.contains(info).should('be.visible');
  }
}

export default CustomerServicePage;