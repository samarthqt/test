import { expect } from 'chai';
class LogoutPage {
  constructor() {
    this.logoutButton = '#logoutButton';
    this.confirmationMessage = '#confirmationMessage';
  }

  clickLogoutButton() {
    cy.get(this.logoutButton).click();
  }

  verifyLogoutSuccess() {
    cy.get(this.confirmationMessage).should('be.visible');
    cy.get(this.confirmationMessage).invoke('text').then((text) => {
      expect(text).to.include('You have successfully logged out');
    });
  }

  performLogout() {
    this.clickLogoutButton();
    this.verifyLogoutSuccess();
  }
}

export default LogoutPage;