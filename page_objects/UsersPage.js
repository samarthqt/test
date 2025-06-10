import { expect } from 'chai';
import 'cypress';

class UsersPage {
  static visit() {
    cy.visit('/users');
  }

  static verifyRedirectionToUsersPage() {
    cy.url().should('include', '/users');
  }

  static verifyCreateNewUserOption() {
    cy.get('#createNewUser').should('be.visible');
  }

  static verifyUserListIsVisible() {
    cy.get('#userList').should('be.visible');
  }

  static verifyUserDetails(userName) {
    cy.get('.user-details').contains(userName).should('be.visible');
  }

  static clickCreateNewUser() {
    cy.get('#createNewUser').click();
  }

  static fillUserForm(userData) {
    cy.get('#username').type(userData.username);
    cy.get('#email').type(userData.email);
    cy.get('#password').type(userData.password);
  }

  static submitUserForm() {
    cy.get('#submitUserForm').click();
  }

  static verifyUserCreated(userName) {
    cy.get('.user-details').contains(userName).should('exist');
  }

  static deleteUser(userName) {
    cy.get(`.user-details:contains(${userName})`).find('.delete-user').click();
  }

  static verifyUserDeleted(userName) {
    cy.get('.user-details').contains(userName).should('not.exist');
  }
}

export default UsersPage;