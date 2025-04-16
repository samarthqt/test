describe('Tenant Communication Portal Functionality', () => {
  const tenantCredentials = { username: 'tenantUser', password: 'tenantPass' };
  const landlordCredentials = { username: 'landlordUser', password: 'landlordPass' };
  const sampleMessage = 'Sample message content for testing communication.';

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow tenant to send and landlord to receive messages', () => {
    // Log in as tenant
    cy.login(tenantCredentials);
    cy.url().should('include', '/dashboard');

    // Navigate to Communication section
    cy.get('.nav-communication').click();
    cy.url().should('include', '/communication');

    // Select a landlord to communicate with
    cy.get('.contact-list .contact').first().click();
    cy.get('.contact-details').should('be.visible');

    // Compose and send a new message
    cy.get('.message-compose').type(sampleMessage);
    cy.get('.send-message-button').click();

    // Verify the message is in Sent items
    cy.get('.nav-sent-items').click();
    cy.contains('.sent-message', sampleMessage).should('be.visible');

    // Log out tenant
    cy.get('.logout-button').click();

    // Log in as landlord
    cy.login(landlordCredentials);
    cy.url().should('include', '/dashboard');

    // Check the Inbox for new messages
    cy.get('.nav-inbox').click();
    cy.contains('.inbox-message', sampleMessage).should('be.visible');

    // Reply to the message
    cy.get('.reply-button').click();
    cy.get('.message-compose').type('Reply to ' + sampleMessage);
    cy.get('.send-reply-button').click();

    // Log out landlord
    cy.get('.logout-button').click();

    // Log back in as tenant
    cy.login(tenantCredentials);
    cy.url().should('include', '/dashboard');

    // Check for the reply
    cy.get('.nav-inbox').click();
    cy.contains('.inbox-message', 'Reply to ' + sampleMessage).should('be.visible');

    // Verify the message thread
    cy.get('.message-thread').should('contain', sampleMessage);
    cy.get('.message-thread').should('contain', 'Reply to ' + sampleMessage);

    // Log out tenant
    cy.get('.logout-button').click();
  });
});