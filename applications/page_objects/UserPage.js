class UserPage {
  static elements = {
    userData: '.user-data',
  };

  static visitUserPage(userId) {
    cy.visit(`/user/${userId}`);
  }

  static verifyUserDataVisible() {
    cy.get(this.elements.userData).should('be.visible');
  }
}

module.exports = UserPage;