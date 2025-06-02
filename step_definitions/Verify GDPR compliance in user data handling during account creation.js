import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountCreationPage from "../pages/accountCreationPage";

Given("the user navigates to the account creation page", () => {
 AccountCreationPage.visit();
});

Then("the account creation page is displayed", () => {
 AccountCreationPage.verifyPageDisplayed();
});

Given("the user is on the account creation page", () => {
 AccountCreationPage.verifyPageDisplayed();
});

When("the user enters personal information into the required fields", () => {
 AccountCreationPage.enterPersonalInformation();
});

Then("personal information is entered successfully", () => {
 AccountCreationPage.verifyPersonalInformationEntered();
});

Then("a consent checkbox for data processing is available and unchecked by default", () => {
 AccountCreationPage.verifyConsentCheckboxUnchecked();
});

When("the user attempts to proceed without checking the consent box", () => {
 AccountCreationPage.proceedWithoutConsent();
});

Then("the system prevents proceeding without consent", () => {
 AccountCreationPage.verifyProceedBlocked();
});

When("the user checks the consent box and proceeds", () => {
 AccountCreationPage.checkConsentAndProceed();
});

Then("the user is allowed to proceed with account creation", () => {
 AccountCreationPage.verifyProceedAllowed();
});

Then("the privacy policy is accessible and details GDPR compliance", () => {
 AccountCreationPage.verifyPrivacyPolicyAccessible();
});

Given("the user has checked the consent box", () => {
 AccountCreationPage.checkConsentBox();
});

When("the user completes the account creation process", () => {
 AccountCreationPage.completeAccountCreation();
});

Then("the account is created successfully with GDPR compliance", () => {
 AccountCreationPage.verifyAccountCreated();
});

Given("the user has created an account", () => {
 AccountCreationPage.verifyAccountCreated();
});

Then("user data is stored securely and in compliance with GDPR", () => {
 AccountCreationPage.verifyDataStorageCompliance();
});

Given("the user has an account", () => {
 AccountCreationPage.verifyAccountExists();
});

Then("the option to request data deletion is available", () => {
 AccountCreationPage.verifyDataDeletionOption();
});

Given("the user requests data deletion", () => {
 AccountCreationPage.requestDataDeletion();
});

Then("user data is deleted upon request in compliance with GDPR", () => {
 AccountCreationPage.verifyDataDeletion();
});

Then("access logs show compliant handling of user data", () => {
 AccountCreationPage.verifyAccessLogsCompliance();
});

Given("there is user data stored", () => {
 AccountCreationPage.verifyUserDataStored();
});

When("a user attempts to access user data without consent", () => {
 AccountCreationPage.attemptAccessWithoutConsent();
});

Then("access is denied without user consent", () => {
 AccountCreationPage.verifyAccessDenied();
});

Given("the system stores user data", () => {
 AccountCreationPage.verifyUserDataStored();
});

Then("no data breaches or vulnerabilities are detected", () => {
 AccountCreationPage.verifyNoDataBreaches();
});

Given("the system operates in different regions", () => {
 AccountCreationPage.verifySystemRegions();
});

Then("the system complies with GDPR across different regions", () => {
 AccountCreationPage.verifyRegionalCompliance();
});

Given("the system transfers user data", () => {
 AccountCreationPage.verifyDataTransfer();
});

Then("data transfer complies with GDPR requirements", () => {
 AccountCreationPage.verifyDataTransferCompliance();
});