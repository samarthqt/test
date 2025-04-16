describe('Instant Messaging Functionality', () => {
  const user1 = { username: 'User1', password: 'password1' };
  const user2 = { username: 'User2', password: 'password2' };

  beforeEach(() => {
    cy.visit('/login');
  });

  it('User1 should send a message to User2', () => {
    cy.login(user1.username, user1.password);
    cy.get('.dashboard').should('be.visible');
    cy.get('.new-message').click();
    cy.get('.recipient-field').type(user2.username);
    cy.get('.message-body').type('Hello, how are you?');
    cy.get('.send-button').click();
    cy.get('.confirmation-message').should('contain', 'Message sent successfully');
  });

  it('User2 should receive the message from User1', () => {
    cy.login(user2.username, user2.password);
    cy.get('.dashboard').should('be.visible');
    cy.get('.inbox').click();
    cy.get('.message-list').should('contain', 'Hello, how are you?').within(() => {
      cy.get('.message-sender').should('contain', user1.username);
    });
    cy.get('.message-body').should('be.visible');
    cy.get('.reply-field').type('I am fine, thank you!');
    cy.get('.reply-send-button').click();
  });

  it('User1 should receive the response from User2', () => {
    cy.login(user1.username, user1.password);
    cy.get('.inbox').click();
    cy.get('.message-list').should('contain', 'I am fine, thank you!').within(() => {
      cy.get('.message-sender').should('contain', user2.username);
    });
  });

  after(() => {
    cy.logout();
  });
});