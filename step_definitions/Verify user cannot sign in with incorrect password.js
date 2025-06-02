import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignInPage from "../pages/signInPage";

Given("the user navigates to the application URL {string}", (url) => {
 cy.visit(url);
});

Given("the application homepage is displayed", () => {
 cy.get('body').should('be.visible');
});

When("the user clicks on the 'Sign In' button", () => {
 SignInPage.clickSignInButton();
});

Then("the sign-in page is displayed", () => {
 SignInPage.verifySignInPage();
});

Then("the user enters registered email {string} in the email field", (email) => {
 SignInPage.enterEmail(email);
});

Then("the user enters incorrect password {string} in the password field", (password) => {
 SignInPage.enterPassword(password);
});

When("the user clicks on 'Sign In' to proceed", () => {
 SignInPage.submitSignIn();
});

Then("the system processes the sign-in request", () => {
 cy.wait(2000); // Assume processing takes time
});

Then("the system checks password validity", () => {
 cy.get('.password-check').should('exist');
});

Then("an error message indicating incorrect password is displayed", () => {
 SignInPage.verifyErrorMessage();
});

Then("the error message includes guidance for password recovery or contacting support", () => {
 cy.get('.error-guidance').should('contain.text', 'recover your password or contact support');
});

Then("the system logs the incorrect sign-in attempt", () => {
 cy.get('.log-entry').should('contain.text', 'incorrect sign-in attempt');
});

Then("no alerts or notifications are displayed", () => {
 cy.get('.alert, .notification').should('not.exist');
});

Then("privacy policies are adhered to", () => {
 cy.get('.privacy-policy').should('be.visible');
});

Then("terms and conditions are displayed", () => {
 cy.get('.terms-conditions').should('be.visible');
});

Then("support contact information is available", () => {
 cy.get('.support-contact').should('be.visible');
});

Then("sign-in is successful with the correct password", () => {
 cy.url().should('include', '/dashboard');
});

Then("user dashboard is accessible", () => {
 cy.get('.dashboard').should('be.visible');
});