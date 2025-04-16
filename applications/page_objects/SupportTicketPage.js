class SupportTicketPage {
  navigateToSupportTicketSystem() {
    cy.visit('/support-ticket-system');
  }

  clickCreateNewTicket() {
    cy.get('button#create-ticket').click();
  }

  enterDescription(description) {
    cy.get('textarea#description').type(description);
  }

  selectPriority(priority) {
    cy.get('select#priority').select(priority);
  }

  submitTicket() {
    cy.get('button#submit-ticket').click();
    cy.contains('Ticket successfully created').should('be.visible');
  }

  navigateToMyTickets() {
    cy.get('a#my-tickets').click();
  }

  verifyTicketInList(description, priority) {
    cy.contains(description).should('be.visible');
    cy.contains(priority).should('be.visible');
  }

  clickOnTicket() {
    cy.get('table#tickets tbody tr').first().click();
  }

  checkTicketStatus(expectedStatus) {
    cy.get('span#ticket-status').should('contain', expectedStatus);
  }

  updateTicketWithComments(comments) {
    cy.get('textarea#comments').type(comments);
    cy.get('button#save-comments').click();
    cy.contains('Comments added successfully').should('be.visible');
  }

  changeStatus(status) {
    cy.get('select#status').select(status);
    cy.get('button#update-status').click();
    cy.contains('Status updated').should('be.visible');
  }

  verifyTicketHistory() {
    cy.get('div#ticket-history').should('contain', 'Status changed to In Progress');
  }

  closeTicket() {
    cy.get('button#close-ticket').click();
    cy.contains('Ticket status changed to Closed').should('be.visible');
  }

  checkClosedTicketInSection() {
    cy.get('a#closed-tickets').click();
    cy.contains('Closed Tickets').should('be.visible');
  }
}