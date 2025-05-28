import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserProfilePage from "../pages/userProfilePage";

Given("a user is logged into their account", () => {
 UserProfilePage.ensureLoggedIn();
});

Given("the user is on their profile page", () => {
 UserProfilePage.visitProfilePage();
});

When("the user clicks on the \"Edit Profile\" button", () => {
 UserProfilePage.clickEditProfile();
});

When("the user updates their personal information with valid data", () => {
 UserProfilePage.updatePersonalInfoValid();
});

When("the user updates their personal information with invalid data", () => {
 UserProfilePage.updatePersonalInfoInvalid();
});

When("the user updates their personal information", () => {
 UserProfilePage.updatePersonalInfo();
});

When("the user clicks on the \"Save\" button", () => {
 UserProfilePage.clickSave();
});

When("the user clicks on the \"Cancel\" button", () => {
 UserProfilePage.clickCancel();
});

When("the user navigates to the \"Edit History\" section", () => {
 UserProfilePage.navigateToEditHistory();
});

Then("the user's profile should be updated with the new information", () => {
 UserProfilePage.verifyProfileUpdated();
});

Then("a confirmation message should be displayed", () => {
 UserProfilePage.verifyConfirmationMessage();
});

Then("the user's profile should not be updated", () => {
 UserProfilePage.verifyProfileNotUpdated();
});

Then("an error message should be displayed indicating the invalid fields", () => {
 UserProfilePage.verifyErrorMessage();
});

Then("the user should be redirected back to the profile page without changes", () => {
 UserProfilePage.verifyRedirectedToProfilePage();
});

Then("the user should see a list of previous changes made to their profile", () => {
 UserProfilePage.verifyEditHistoryList();
});

Then("each entry should include the date and time of the change", () => {
 UserProfilePage.verifyEditHistoryDetails();
});

Then("the user's profile should remain unchanged", () => {
 UserProfilePage.verifyProfileUnchanged();
});

Then("a message should be displayed indicating no changes were made", () => {
 UserProfilePage.verifyNoChangesMessage();
});