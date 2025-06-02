import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProfilePage from "../pages/profilePage";
import DashboardPage from "../pages/dashboardPage";

Given("the user has valid login credentials", () => {
 cy.fixture('user').as('userData');
});

When("the user logs in to the account", function() {
 cy.visit('/login');
 cy.get('#username').type(this.userData.username);
 cy.get('#password').type(this.userData.password);
 cy.get('#loginBtn').click();
});

Then("the user is logged in successfully and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the profile settings page", () => {
 DashboardPage.goToProfileSettings();
});

Then("the profile settings page is displayed with current user details", () => {
 ProfilePage.verifyProfileDetails();
});

When("the user updates the name field with maximum allowed characters of 50", () => {
 ProfilePage.updateName('A'.repeat(50));
});

Then("the name field is updated with maximum allowed characters", () => {
 ProfilePage.verifyNameUpdate('A'.repeat(50));
});

When("the user updates the email field with maximum allowed characters of 100", () => {
 ProfilePage.updateEmail('a'.repeat(94) + '@mail.com');
});

Then("the email field is updated with maximum allowed characters", () => {
 ProfilePage.verifyEmailUpdate('a'.repeat(94) + '@mail.com');
});

When("the user updates the shipping address field with maximum allowed characters of 200", () => {
 ProfilePage.updateShippingAddress('A'.repeat(200));
});

Then("the shipping address field is updated with maximum allowed characters", () => {
 ProfilePage.verifyShippingAddressUpdate('A'.repeat(200));
});

When("the user updates the billing address field with maximum allowed characters of 200", () => {
 ProfilePage.updateBillingAddress('A'.repeat(200));
});

Then("the billing address field is updated with maximum allowed characters", () => {
 ProfilePage.verifyBillingAddressUpdate('A'.repeat(200));
});

When("the user updates the phone number field with maximum allowed characters of 15", () => {
 ProfilePage.updatePhoneNumber('123456789012345');
});

Then("the phone number field is updated with maximum allowed characters", () => {
 ProfilePage.verifyPhoneNumberUpdate('123456789012345');
});

When("the user saves the changes made to the profile", () => {
 ProfilePage.saveChanges();
});

Then("the changes are saved successfully and a confirmation message is displayed", () => {
 ProfilePage.verifyConfirmationMessage();
});

When("the user logs out and logs back in to verify updates", () => {
 cy.get('#logoutBtn').click();
 cy.visit('/login');
 cy.get('#username').type(this.userData.username);
 cy.get('#password').type(this.userData.password);
 cy.get('#loginBtn').click();
 DashboardPage.goToProfileSettings();
});

Then("the updated details are displayed correctly on the profile settings page", () => {
 ProfilePage.verifyProfileDetails();
});

When("the user checks email for confirmation of changes", () => {
 cy.task('checkEmailConfirmation');
});

Then("email confirmation for each updated detail is received", () => {
 cy.task('verifyEmailConfirmation');
});