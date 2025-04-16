describe('Create and Track Support Tickets', () => {
  const supportTicketPage = new SupportTicketPage();

  before(() => {
    cy.login('12345'); // Assuming a custom command for login
  });

  it('should create and track a support ticket', () => {
    supportTicketPage.navigateToSupportTicketSystem();
    supportTicketPage.clickCreateNewTicket();
    supportTicketPage.enterDescription('Unable to access account settings');
    supportTicketPage.selectPriority('High');
    supportTicketPage.submitTicket();

    supportTicketPage.navigateToMyTickets();
    supportTicketPage.verifyTicketInList('Unable to access account settings', 'High');
    supportTicketPage.clickOnTicket();
    supportTicketPage.checkTicketStatus('Open');

    supportTicketPage.updateTicketWithComments('Additional comments');
    supportTicketPage.changeStatus('In Progress');
    supportTicketPage.verifyTicketHistory();

    supportTicketPage.closeTicket();
    supportTicketPage.checkClosedTicketInSection();
  });

  after(() => {
    cy.logout(); // Assuming a custom command for logout
  });
});