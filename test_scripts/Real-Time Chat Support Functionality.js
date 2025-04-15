describe('Real-Time Chat Support Functionality', () => {
  const chatPage = new ChatPage();
  const loginPage = new LoginPage();

  it('should log in as user U12345 and verify chat support', () => {
    loginPage.login('U12345');
    chatPage.navigateToSupportSection();
    chatPage.startLiveChat('Product availability');
    chatPage.waitForAgentResponse();
    chatPage.engageWithAgent();
    chatPage.verifyAgentInformation();
    chatPage.endChatSession();
    chatPage.rateChatSupport();
  });

  it('should log out and log in as user U67890 to verify chat support', () => {
    loginPage.logout();
    loginPage.login('U67890');
    chatPage.navigateToSupportSection();
    chatPage.startLiveChat('Order status');
    chatPage.engageWithAgent();
    chatPage.verifyChatHistory();
  });

  it('should test chat support during non-business hours', () => {
    chatPage.testNonBusinessHours();
  });

  it('should test chat support with a non-registered user', () => {
    chatPage.testNonRegisteredUser();
  });
});