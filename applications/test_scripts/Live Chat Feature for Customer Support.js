describe('Live Chat Feature for Customer Support', () => {
  const customerPortal = new CustomerPortal();

  before(() => {
    cy.visit('/login');
    customerPortal.login('customer', 'password');
  });

  it('should navigate to Support section and initiate live chat', () => {
    customerPortal.navigateToSupport();
    customerPortal.openLiveChat();
    customerPortal.enterInquiryMessage('Hello, I need help with my account.');
    customerPortal.sendMessage();
    customerPortal.verifyRepresentativeJoined();
    customerPortal.engageInConversation();
  });

  it('should request and download chat transcript', () => {
    customerPortal.requestChatTranscript();
    customerPortal.verifyTranscriptOption();
  });

  after(() => {
    customerPortal.logout();
  });
});