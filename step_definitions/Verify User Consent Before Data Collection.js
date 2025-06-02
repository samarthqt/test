import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("the user account is active with User ID: {int}", (userId) => {
 // Mock or set up the user account as active with the given User ID
});

When("the user navigates to account settings", () => {
 AccountSettingsPage.navigateToSettings();
});

Then("the user account settings page is displayed", () => {
 AccountSettingsPage.verifySettingsPageDisplayed();
});

Then("a consent form must be available", () => {
 AccountSettingsPage.verifyConsentFormAvailable();
});

Given("the user is on the account settings page", () => {
 AccountSettingsPage.verifySettingsPageDisplayed();
});

When("the user locates the consent section", () => {
 AccountSettingsPage.locateConsentSection();
});

Then("the consent section is visible with options", () => {
 AccountSettingsPage.verifyConsentSectionVisible();
});

Then("the consent form version is {float}", (version) => {
 AccountSettingsPage.verifyConsentFormVersion(version);
});

When("the user selects the option to provide consent", () => {
 AccountSettingsPage.selectProvideConsentOption();
});

Then("the consent option is selected", () => {
 AccountSettingsPage.verifyConsentOptionSelected();
});

Then("the consent status is 'Not Given'", () => {
 AccountSettingsPage.verifyConsentStatus('Not Given');
});

When("the user submits the consent form", () => {
 AccountSettingsPage.submitConsentForm();
});

Then("the consent form is submitted successfully", () => {
 AccountSettingsPage.verifyConsentFormSubmitted();
});

Given("the consent form is submitted successfully", () => {
 AccountSettingsPage.verifyConsentFormSubmitted();
});

When("the user verifies the status of consent in the user profile", () => {
 AccountSettingsPage.verifyConsentStatusInProfile();
});

Then("the consent status is updated to 'Given'", () => {
 AccountSettingsPage.verifyConsentStatus('Given');
});

When("the user attempts to collect data", () => {
 AccountSettingsPage.attemptDataCollection();
});

Then("data collection proceeds as consent is given", () => {
 AccountSettingsPage.verifyDataCollectionProceeds();
});

Then("the consent record is logged with a timestamp", () => {
 AccountSettingsPage.verifyConsentRecordLogged();
});

Given("data collection proceeds", () => {
 AccountSettingsPage.verifyDataCollectionProceeds();
});

When("the user verifies data processing initiation", () => {
 AccountSettingsPage.verifyDataProcessingInitiation();
});

Then("data processing starts as per the consent", () => {
 AccountSettingsPage.verifyDataProcessingStarts();
});

When("the user checks for consent confirmation notification", () => {
 AccountSettingsPage.checkConsentConfirmationNotification();
});

Then("the user receives confirmation notification", () => {
 AccountSettingsPage.verifyConfirmationNotificationReceived();
});

Given("the user receives confirmation notification", () => {
 AccountSettingsPage.verifyConfirmationNotificationReceived();
});

When("the user verifies the audit trail for consent", () => {
 AccountSettingsPage.verifyAuditTrailForConsent();
});

Then("the audit trail includes consent details", () => {
 AccountSettingsPage.verifyAuditTrailIncludesConsentDetails();
});

Given("the user can revoke consent", () => {
 AccountSettingsPage.verifyUserCanRevokeConsent();
});

When("the user revokes consent successfully", () => {
 AccountSettingsPage.revokeConsent();
});

Then("the user attempts data collection after revoking consent", () => {
 AccountSettingsPage.attemptDataCollectionAfterRevocation();
});

Then("data collection is blocked as consent is revoked", () => {
 AccountSettingsPage.verifyDataCollectionBlocked();
});

Given("data collection is blocked", () => {
 AccountSettingsPage.verifyDataCollectionBlocked();
});

When("the user checks system response to consent revocation", () => {
 AccountSettingsPage.checkSystemResponseToRevocation();
});

Then("the system updates consent status to 'Revoked'", () => {
 AccountSettingsPage.verifyConsentStatus('Revoked');
});

When("the user verifies notification for consent revocation", () => {
 AccountSettingsPage.verifyNotificationForRevocation();
});

Then("the user receives notification of consent revocation", () => {
 AccountSettingsPage.verifyRevocationNotificationReceived();
});

Given("the user receives notification of consent revocation", () => {
 AccountSettingsPage.verifyRevocationNotificationReceived();
});

When("the user checks audit trail for consent revocation", () => {
 AccountSettingsPage.checkAuditTrailForRevocation();
});

Then("the audit trail includes revocation details", () => {
 AccountSettingsPage.verifyAuditTrailIncludesRevocationDetails();
});