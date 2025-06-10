import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import InsuranceAppPage from "../pages/insuranceAppPage";

Given("the application is deployed", () => {
 InsuranceAppPage.visit();
});

When("the user accesses the application", () => {
 InsuranceAppPage.accessApplication();
});

Then("the app load time should be under 3 seconds", () => {
 cy.window().then((win) => {
 const loadTime = win.performance.timing.loadEventEnd - win.performance.timing.navigationStart;
 expect(loadTime).to.be.lessThan(3000);
 });
});

When("10,000 users access the application simultaneously", () => {
 InsuranceAppPage.simultaneousAccess(10000);
});

Then("the application should support all users without performance degradation", () => {
 InsuranceAppPage.verifyPerformance();
});

Given("the application handles sensitive data", () => {
 InsuranceAppPage.handleSensitiveData();
});

When("sensitive data is stored or transmitted", () => {
 InsuranceAppPage.storeOrTransmitData();
});

Then("the data should be encrypted to ensure security", () => {
 InsuranceAppPage.verifyEncryption();
});

Given("the application handles user data", () => {
 InsuranceAppPage.handleUserData();
});

When("processing or storing user data", () => {
 InsuranceAppPage.processOrStoreUserData();
});

Then("GDPR compliance must be maintained", () => {
 InsuranceAppPage.verifyGDPRCompliance();
});

Given("the user has an account", () => {
 InsuranceAppPage.userHasAccount();
});

When("the user attempts to log in", () => {
 InsuranceAppPage.attemptLogin();
});

Then("two-factor authentication must be implemented for the account", () => {
 InsuranceAppPage.verifyTwoFactorAuthentication();
});

Given("the application is running", () => {
 InsuranceAppPage.isRunning();
});

When("an error occurs during performance processes", () => {
 InsuranceAppPage.errorOccurs();
});

Then("error handling must be robust to prevent system failure", () => {
 InsuranceAppPage.verifyErrorHandling();
});

When("scalability and security tests are conducted", () => {
 InsuranceAppPage.conductTests();
});

Then("testing must confirm scalability and security features", () => {
 InsuranceAppPage.confirmFeatures();
});

When("the system is running", () => {
 InsuranceAppPage.systemRunning();
});

Then("logging must be implemented to monitor system performance", () => {
 InsuranceAppPage.verifyLogging();
});

When("there are security changes", () => {
 InsuranceAppPage.securityChanges();
});

Then("notifications should alert users to these changes", () => {
 InsuranceAppPage.verifyNotifications();
});

Given("the application is developed", () => {
 InsuranceAppPage.isDeveloped();
});

When("non-functional requirements are specified", () => {
 InsuranceAppPage.specifyRequirements();
});

Then("documentation must be provided for these requirements", () => {
 InsuranceAppPage.verifyDocumentation();
});