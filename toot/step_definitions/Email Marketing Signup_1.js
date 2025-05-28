import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MarketingSignupPage from "../pages/marketingSignupPage";

Given("the user is on the marketing signup page", () => {
 MarketingSignupPage.visit();
});

When("the user enters a valid email address", () => {
 MarketingSignupPage.enterEmail('valid@example.com');
});

When("the user enters an invalid email address", () => {
 MarketingSignupPage.enterEmail('invalid-email');
});

When("the user enters the same email address", () => {
 MarketingSignupPage.enterEmail('subscribed@example.com');
});

When("the user checks the opt-in checkbox for newsletters and promotions", () => {
 MarketingSignupPage.checkOptIn();
});

When("the user does not check the opt-in checkbox for newsletters and promotions", () => {
 MarketingSignupPage.uncheckOptIn();
});

When("the user submits the signup form", () => {
 MarketingSignupPage.submitForm();
});

Then("the user should see a confirmation message stating that they have successfully signed up for email newsletters and promotions", () => {
 cy.contains('You have successfully signed up for email newsletters and promotions').should('be.visible');
});

Then("the user should see an error message indicating that the email address is invalid", () => {
 cy.contains('The email address is invalid').should('be.visible');
});

Then("the user should see a message indicating that they need to opt-in to receive newsletters and promotions", () => {
 cy.contains('You need to opt-in to receive newsletters and promotions').should('be.visible');
});

Then("the user should see a message indicating that the email is already subscribed", () => {
 cy.contains('The email is already subscribed').should('be.visible');
});

Then("the user's email should be added to the marketing mailing list", () => {
 // Assert email added logic here
});

Then("the user's email should not be added to the marketing mailing list", () => {
 // Assert email not added logic here
});

Then("no duplicate entry should be created in the marketing mailing list", () => {
 // Assert no duplicate entry logic here
});