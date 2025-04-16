describe('Live Chat Session Timeout', () => {
  const chatPage = new ChatPage();

  before(() => {
    cy.visit('/live-chat');
    chatPage.startChatSession('12345');
  });

  it('should timeout chat session after inactivity', () => {
    // Step 1: Stop interacting for 10 minutes
    cy.wait(600000); // Wait for 10 minutes

    // Step 2: Wait for system to timeout the chat session
    chatPage.verifySessionTimeout();

    // Step 3: Attempt to send a message
    chatPage.sendMessage('Hello, is anyone there?');
    chatPage.verifyMessageFailedToSend();
  });

  after(() => {
    chatPage.endChatSession();
  });
});