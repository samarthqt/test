import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecoveryPage from "../pages/recoveryPage";

Given("an invalid recovery link {string} is available", (link) => {
 RecoveryPage.setInvalidLink(link);
});

When("I attempt to access the password reset page using the invalid link", () => {
 RecoveryPage.visitInvalidLink();
});

Then("the system denies access to the password reset page", () => {
 RecoveryPage.verifyAccessDenied();
});

Then("an error message is displayed indicating the link is invalid", () => {
 RecoveryPage.verifyErrorMessage();
});

Then("the invalid link attempt is logged in the system", () => {
 RecoveryPage.verifyLinkAttemptLogged();
});

Then("the user is redirected to the login page or given an option to request a new link", () => {
 RecoveryPage.verifyRedirectionOrOption();
});

Then("the user is logged out successfully", () => {
 RecoveryPage.verifyLogout();
});