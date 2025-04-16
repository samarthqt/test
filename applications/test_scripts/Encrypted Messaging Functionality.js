describe('Encrypted Messaging Functionality', () => {
  const user1 = { username: 'User1', password: 'password1' };
  const user2 = { username: 'User2', password: 'password2' };
  const unauthorizedUser = { username: 'UnauthorizedUser', password: 'password3' };

  before(() => {
    cy.enableHighEncryptionModule();
  });

  it('User1 sends an encrypted message to User2', () => {
    cy.login(user1.username, user1.password);
    cy.navigateToMessagingDashboard();
    cy.newMessagePage.navigate();
    cy.newMessagePage.enterRecipient(user2.username);
    cy.newMessagePage.enterMessageBody('Hello, this is a secure message.');
    cy.newMessagePage.sendMessage();
    cy.verifyMessageSent();
    cy.logout();
  });

  it('User2 receives and reads the encrypted message', () => {
    cy.login(user2.username, user2.password);
    cy.navigateToMessagingDashboard();
    cy.inboxPage.navigate();
    cy.inboxPage.openMessageFrom(user1.username);
    cy.inboxPage.verifyMessageContent('Hello, this is a secure message.');
    cy.inboxPage.verifyMessageEncryptionStatus();
    cy.logout();
  });

  it('Unauthorized user cannot access the message', () => {
    cy.login(unauthorizedUser.username, unauthorizedUser.password);
    cy.navigateToMessagingDashboard();
    cy.inboxPage.verifyNoAccessToMessageFrom(user1.username);
    cy.logout();
  });

  it('User1 verifies sent message encryption status', () => {
    cy.login(user1.username, user1.password);
    cy.navigateToMessagingDashboard();
    cy.sentMessagesPage.verifyEncryptionStatusForMessageTo(user2.username);
    cy.sentMessagesPage.verifyDeliveryStatus('Delivered', 'Read');
    cy.logout();
  });
});