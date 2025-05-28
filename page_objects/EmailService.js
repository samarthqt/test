import { Selector } from 'testcafe';

class EmailService {
  constructor() {
    this.emailInbox = Selector('.email-inbox');
    this.cxEmailInbox = Selector('.cx-email-inbox');
  }

  checkEmail(email) {
    cy.get(this.emailInbox).should('contain', email);
  }

  checkCXEmail() {
    cy.get(this.cxEmailInbox).should('exist');
  }

  verifyEmailSubject(subject) {
    cy.get(this.emailInbox).find('.subject').should('contain', subject);
  }

  verifyEmailSender(sender) {
    cy.get(this.emailInbox).find('.sender').should('contain', sender);
  }

  openEmail(email) {
    cy.get(this.emailInbox).contains(email).click();
  }

  deleteEmail(email) {
    cy.get(this.emailInbox).contains(email).parent().find('.delete-button').click();
  }

  markEmailAsRead(email) {
    cy.get(this.emailInbox).contains(email).parent().find('.mark-read-button').click();
  }

  searchEmail(keyword) {
    cy.get('.search-bar').type(keyword);
    cy.get('.search-button').click();
  }
}

export default EmailService;