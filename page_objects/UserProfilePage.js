import { Selector } from 'testcafe';




class UserProfilePage {


  static visit() {


    cy.visit('/user-profile');


  }




  static verifyPageDisplayedInSpanish() {


    cy.get('#userProfilePage').should('contain', 'Perfil de usuario');


  }




  static getUserName() {


    return cy.get('.user-name');


  }




  static getUserEmail() {


    return cy.get('.user-email');


  }




  static clickEditProfileButton() {


    cy.get('.edit-profile-btn').click();


  }




  static updateUserName(name) {


    cy.get('.user-name-input').clear().type(name);


  }




  static updateUserEmail(email) {


    cy.get('.user-email-input').clear().type(email);


  }




  static saveProfileChanges() {


    cy.get('.save-profile-btn').click();


  }




  static verifyProfileUpdated() {


    cy.get('.success-message').should('be.visible');


  }


}




export default UserProfilePage;