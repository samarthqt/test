import { Selector } from 'testcafe';

class OrangeHRMPage {
  static visit(url) {
    cy.visit(url);
  }

  static login(username, password) {
    cy.get('#txtUsername').type(username);
    cy.get('#txtPassword').type(password);
    cy.get('#btnLogin').click();
  }

  static navigateToModule(module) {
    cy.contains(module).click();
  }

  static clickButton(button) {
    cy.contains(button).click();
  }

  static enterEmployeeDetails(firstName, middleName, lastName) {
    cy.get('#firstName').type(firstName);
    cy.get('#middleName').type(middleName);
    cy.get('#lastName').type(lastName);
  }

  static saveEmployeeDetails() {
    cy.get('#btnSave').click();
  }

  static verifySuccessMessage(message) {
    cy.contains(message).should('be.visible');
  }

  static verifyEmployeeInList(list) {
    cy.contains(list).should('be.visible');
  }
}

export default OrangeHRMPage;