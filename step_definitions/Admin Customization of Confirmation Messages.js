import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminPanelPage from "../pages/adminPanelPage";
import UserPage from "../pages/userPage";

Given("the admin has access to the system", () => {
 AdminPanelPage.visit();
});

When("the admin logs in to the admin panel using valid admin credentials", () => {
 AdminPanelPage.login("admin", "password");
});

Then("the admin is successfully logged into the system", () => {
 cy.url().should("include", "/dashboard");
});

When("the admin navigates to the settings section of the admin panel", () => {
 AdminPanelPage.navigateToSettings();
});

Then("the settings section is displayed", () => {
 AdminPanelPage.verifySettingsSection();
});

When("the admin locates the confirmation message customization options", () => {
 AdminPanelPage.locateConfirmationMessageOptions();
});

Then("the customization options for confirmation messages are visible", () => {
 AdminPanelPage.verifyCustomizationOptionsVisible();
});

When("the admin selects a confirmation message template to customize", () => {
 AdminPanelPage.selectConfirmationTemplate();
});

Then("the selected template is ready for customization", () => {
 AdminPanelPage.verifyTemplateReadyForCustomization();
});

When("the admin modifies the text of the confirmation message", () => {
 AdminPanelPage.modifyConfirmationText("New Confirmation Text");
});

Then("the text of the confirmation message is updated", () => {
 AdminPanelPage.verifyTextUpdated();
});

When("the admin changes the font style of the confirmation message", () => {
 AdminPanelPage.changeFontStyle("Arial");
});

Then("the font style is successfully changed", () => {
 AdminPanelPage.verifyFontStyleChanged();
});

When("the admin updates the color scheme of the confirmation message", () => {
 AdminPanelPage.updateColorScheme("#FFFFFF");
});

Then("the color scheme is updated as per the selection", () => {
 AdminPanelPage.verifyColorSchemeUpdated();
});

When("the admin saves the changes made to the confirmation message", () => {
 AdminPanelPage.saveChanges();
});

Then("the changes are saved successfully", () => {
 AdminPanelPage.verifyChangesSaved();
});

When("the admin previews the customized confirmation message", () => {
 AdminPanelPage.previewConfirmationMessage();
});

Then("the preview shows the updated confirmation message with all applied customizations", () => {
 AdminPanelPage.verifyPreviewUpdated();
});

When("the admin reverts the changes to the default confirmation message settings", () => {
 AdminPanelPage.revertToDefaultSettings();
});

Then("the confirmation message is reverted to default settings", () => {
 AdminPanelPage.verifyRevertedToDefault();
});

When("the admin logs out from the admin panel", () => {
 AdminPanelPage.logout();
});

Then("the admin is logged out successfully", () => {
 cy.url().should("include", "/login");
});

Given("the admin has customized the confirmation message", () => {
 // Assume admin has already customized the message
});

When("a regular user logs in and performs an action that triggers a confirmation message", () => {
 UserPage.loginAndTriggerConfirmation();
});

Then("the customized confirmation message is displayed to the user", () => {
 UserPage.verifyConfirmationMessageDisplayed();
});

When("the user verifies the content, font, and color of the confirmation message", () => {
 UserPage.verifyMessageContentFontColor();
});

Then("the confirmation message matches the customizations made by the admin", () => {
 UserPage.verifyMessageMatchesCustomizations();
});

When("the user checks if the confirmation message is clear and understandable", () => {
 UserPage.verifyMessageClarity();
});

Then("the confirmation message is clear and provides necessary information", () => {
 UserPage.verifyMessageProvidesInformation();
});

When("the user ensures that the confirmation message is appropriately aligned and formatted", () => {
 UserPage.verifyMessageAlignmentAndFormat();
});

Then("the confirmation message is well-aligned and formatted correctly", () => {
 UserPage.verifyMessageAlignmentAndFormatCorrect();
});