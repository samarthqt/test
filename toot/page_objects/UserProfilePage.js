import { expect } from 'chai';

class UserProfilePage {

  static ensureLoggedIn() {
    cy.get('#loggedInIndicator').should('be.visible');
  }

  static visitProfilePage() {
    cy.visit('/user/profile');
  }

  static clickEditProfile() {
    cy.get('#editProfileBtn').click();
  }

  static updatePersonalInfo(name, email) {
    cy.get('#nameInput').clear().type(name);
    cy.get('#emailInput').clear().type(email);
  }

  static clickSave() {
    cy.get('#saveBtn').click();
  }

  static clickCancel() {
    cy.get('#cancelBtn').click();
  }

  static navigateToEditHistory() {
    cy.get('#editHistorySection').click();
  }

  static verifyProfileUpdated() {
    cy.get('#profileUpdatedIndicator').should('be.visible');
    cy.get('#confirmationMessage').should('contain', 'Profile updated successfully');
  }

  static verifyProfileNotUpdated() {
    cy.get('#profileNotUpdatedIndicator').should('be.visible');
    cy.get('#errorMessage').should('contain', 'Invalid fields');
  }

  static verifyRedirectedToProfilePage() {
    cy.url().should('include', '/user/profile');
  }

  static verifyEditHistoryList() {
    cy.get('#editHistoryList').should('be.visible');
  }

  static verifyEditHistoryDetails() {
    cy.get('#editHistoryList .entry').each(($entry) => {
      cy.wrap($entry).should('contain', 'Date').and('contain', 'Time');
    });
  }

  static verifyProfileUnchanged() {
    cy.get('#profileUnchangedIndicator').should('be.visible');
    cy.get('#noChangesMessage').should('contain', 'No changes made');
  }
}

export default UserProfilePage;