import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import GDPRPage from "../pages/gdprPage";

Given("the application is running", () => {
 GDPRPage.visitApplication();
});

When("user data is stored in the application", () => {
 GDPRPage.storeUserData();
});

Then("the data must be stored in compliance with GDPR guidelines", () => {
 GDPRPage.verifyDataStorageCompliance();
});

When("user data is processed", () => {
 GDPRPage.processUserData();
});

Then("the processing must adhere to GDPR guidelines", () => {
 GDPRPage.verifyDataProcessingCompliance();
});

When("user data is accessed", () => {
 GDPRPage.accessUserData();
});

Then("the access must comply with GDPR guidelines", () => {
 GDPRPage.verifyDataAccessCompliance();
});

Given("a user accesses their account", () => {
 GDPRPage.accessUserAccount();
});

When("the user navigates to the privacy settings", () => {
 GDPRPage.navigateToPrivacySettings();
});

Then("the application must display information about their rights regarding data privacy", () => {
 GDPRPage.displayPrivacyRightsInformation();
});

Then("the user must be informed about how their data is being used", () => {
 GDPRPage.informDataUsage();
});

Given("the application is operational", () => {
 GDPRPage.verifyApplicationOperational();
});

When("a data protection impact assessment is scheduled", () => {
 GDPRPage.scheduleImpactAssessment();
});

Then("the assessment must be conducted regularly", () => {
 GDPRPage.conductRegularAssessment();
});

Then("the results must be documented and reviewed", () => {
 GDPRPage.documentAndReviewResults();
});

When("the user navigates to the consent management section", () => {
 GDPRPage.navigateToConsentManagement();
});

Then("the application must provide tools for managing consent", () => {
 GDPRPage.provideConsentManagementTools();
});

Then("the user should be able to easily give or withdraw consent", () => {
 GDPRPage.manageUserConsent();
});