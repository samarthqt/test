describe('Live Chat Support Availability', () => {
  before(() => {
    // Assuming user is already logged in
    cy.login('test_user');
  });

  it('should initiate a live chat during business hours', () => {
    const customerServicePage = new CustomerServicePage();

    customerServicePage.navigateToCustomerServicePage();
    customerServicePage.clickLiveChatButton();
    customerServicePage.enterChatInquiry('General Inquiry');
    customerServicePage.verifyChatResponse();
  });
});