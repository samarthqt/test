import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserProfilePage from "../pages/userProfilePage";

Given("the user is logged into their account", () => {
 UserProfilePage.verifyLogin();
});

When("the user navigates to the account dashboard", () => {
 UserProfilePage.goToDashboard();
});

Then("the user should be able to access their profile", () => {
 UserProfilePage.accessProfile();
});

Given("the user is on their profile page", () => {
 UserProfilePage.visitProfilePage();
});

When("the user updates their name, email, shipping/billing addresses, and phone number", () => {
 UserProfilePage.updatePersonalInfo();
});

And("the user saves the changes", () => {
 UserProfilePage.saveChanges();
});

Then("the changes should be saved promptly", () => {
 UserProfilePage.verifyChangesSaved();
});

Given("the user is updating their email and phone number", () => {
 UserProfilePage.prepareEmailPhoneUpdate();
});

When("the user enters an invalid email or phone number format", () => {
 UserProfilePage.enterInvalidEmailPhone();
});

Then("an error message should be displayed", () => {
 UserProfilePage.verifyErrorMessage();
});

Given("the user has successfully updated their personal information", () => {
 UserProfilePage.verifySuccessfulUpdate();
});

Then("the user should receive a notification confirming the successful update", () => {
 UserProfilePage.verifyNotificationReceived();
});

Given("the user has made changes to their personal information", () => {
 UserProfilePage.verifyChangesMade();
});

Then("all changes should be logged for auditing purposes", () => {
 UserProfilePage.verifyChangesLogged();
});

Given("the user is updating sensitive personal information", () => {
 UserProfilePage.prepareSensitiveInfoUpdate();
});

Then("the system must ensure data encryption for this information", () => {
 UserProfilePage.verifyDataEncryption();
});

Given("the user has updated their personal information", () => {
 UserProfilePage.verifyUpdateMade();
});

When("the user decides to revert the changes within the specified time frame", () => {
 UserProfilePage.revertChanges();
});

Then("the changes should be reverted successfully", () => {
 UserProfilePage.verifyRevertSuccess();
});