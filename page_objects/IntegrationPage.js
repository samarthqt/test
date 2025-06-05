import { Selector } from 'testcafe'; 
class IntegrationPage {
  constructor() {
    this.contentButton = Selector('#contentButton');
    this.learnMoreButton = Selector('#learnMoreButton');
    this.submitButton = Selector('#submitButton');
    this.cancelButton = Selector('#cancelButton');
    this.inputField = Selector('#inputField');
  }
  
  clickContentButton() {
    return cy.get(this.contentButton).click();
  }

  clickLearnMoreButton() {
    return cy.get(this.learnMoreButton).click();
  }

  clickSubmitButton() {
    return cy.get(this.submitButton).click();
  }

  clickCancelButton() {
    return cy.get(this.cancelButton).click();
  }

  typeIntoInputField(text) {
    return cy.get(this.inputField).type(text);
  }

  verifyContentButtonVisible() {
    return cy.get(this.contentButton).should('be.visible');
  }

  verifyLearnMoreButtonVisible() {
    return cy.get(this.learnMoreButton).should('be.visible');
  }

  verifySubmitButtonVisible() {
    return cy.get(this.submitButton).should('be.visible');
  }

  verifyCancelButtonVisible() {
    return cy.get(this.cancelButton).should('be.visible');
  }

  verifyInputFieldVisible() {
    return cy.get(this.inputField).should('be.visible');
  }
}

export default IntegrationPage;