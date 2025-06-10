import { expect } from 'chai';
class ProfilePage {
 static visitLoginPage() {
 cy.visit('/login');
 }

 static login(role, username, password) {
 this.visitLoginPage();
 cy.get('#username').type(username);
 cy.get('#password').type(password);
 cy.get('#loginBtn').click();
 cy.url().should('include', `/${role}/dashboard`);
 }

 static visitProfilePage() {
 cy.get('#profileLink').click();
 cy.url().should('include', '/profile');
 }

 static verifyReleaseLabel() {
 cy.get('#releaseLabel').should('be.visible');
 cy.get('#releaseLabelValue').should('not.be.empty');
 }

 static verifyLastDeployedDateLabel() {
 cy.get('#lastDeployedDateLabel').should('be.visible');
 cy.get('#lastDeployedDateLabelValue').should('not.be.empty');
 }

 static verifyProfileHeader(headerText) {
 cy.get('.profile-header').should('contain.text', headerText);
 }

 static updateProfileInfo(name, email) {
 cy.get('#nameInput').clear().type(name);
 cy.get('#emailInput').clear().type(email);
 cy.get('#saveProfileBtn').click();
 cy.get('.notification').should('contain.text', 'Profile updated successfully');
 }

 static verifyProfileInfo(name, email) {
 cy.get('#nameInput').should('have.value', name);
 cy.get('#emailInput').should('have.value', email);
 }

 static logout() {
 cy.get('#logoutBtn').click();
 cy.url().should('include', '/login');
 }
}
export default ProfilePage;