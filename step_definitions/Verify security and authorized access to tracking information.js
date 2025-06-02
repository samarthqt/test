import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SecurityPage from "../pages/securityPage";

Given("the user has valid credentials", () => {
 SecurityPage.enterCredentials();
});

When("the user logs into the application", () => {
 SecurityPage.login();
});

Then("the user is successfully logged into the application", () => {
 SecurityPage.verifyLoginSuccess();
});

Given("the user is logged into the application", () => {
 SecurityPage.verifyLogin();
});

When("the user navigates to the 'Order History' section", () => {
 SecurityPage.navigateToOrderHistory();
});

Then("the Order History section is displayed with a list of past orders", () => {
 SecurityPage.verifyOrderHistoryDisplayed();
});

Given("the user is in the 'Order History' section", () => {
 SecurityPage.verifyInOrderHistory();
});

When("the user selects an order with tracking information available", () => {
 SecurityPage.selectOrderWithTracking();
});

Then("the order details page is displayed with tracking information visible", () => {
 SecurityPage.verifyOrderDetailsWithTracking();
});

Given("the user has accessed the order details page", () => {
 SecurityPage.verifyOrderDetailsAccessed();
});

When("the user views tracking information", () => {
 SecurityPage.viewTrackingInformation();
});

Then("tracking information is accessed securely with SSL/TLS encryption", () => {
 SecurityPage.verifySecureTrackingAccess();
});

Given("the user is not authenticated", () => {
 SecurityPage.verifyNotAuthenticated();
});

When("the user attempts to access tracking information", () => {
 SecurityPage.attemptTrackingAccess();
});

Then("access to tracking information is denied", () => {
 SecurityPage.verifyAccessDenied();
});

Given("the user has appropriate authorization", () => {
 SecurityPage.verifyAuthorization();
});

When("the user accesses tracking information", () => {
 SecurityPage.accessTrackingInformation();
});

Then("tracking information is accessible", () => {
 SecurityPage.verifyTrackingAccessible();
});

Given("the user accesses tracking information", () => {
 SecurityPage.accessTracking();
});

When("the security protocols are verified", () => {
 SecurityPage.verifySecurityProtocols();
});

Then("safe access to tracking information is ensured", () => {
 SecurityPage.ensureSafeTrackingAccess();
});

When("checking for vulnerabilities", () => {
 SecurityPage.checkVulnerabilities();
});

Then("no vulnerabilities are found", () => {
 SecurityPage.verifyNoVulnerabilities();
});

Given("tracking information updates are available", () => {
 SecurityPage.verifyUpdatesAvailable();
});

When("updates are communicated", () => {
 SecurityPage.communicateUpdates();
});

Then("updates are securely communicated and protected", () => {
 SecurityPage.verifySecureUpdates();
});

Given("the user wants to access tracking information", () => {
 SecurityPage.verifyAccessIntent();
});

When("user authentication is verified", () => {
 SecurityPage.verifyUserAuthentication();
});

Then("user authentication is required for access", () => {
 SecurityPage.ensureAuthenticationRequired();
});

Given("an unauthorized user attempts access", () => {
 SecurityPage.verifyUnauthorizedAttempt();
});

When("the system responds", () => {
 SecurityPage.systemResponse();
});

Then("the system blocks unauthorized access attempts", () => {
 SecurityPage.verifyUnauthorizedBlocked();
});

Given("tracking information is available", () => {
 SecurityPage.verifyTrackingAvailable();
});

When("unauthorized users attempt access", () => {
 SecurityPage.attemptUnauthorizedAccess();
});

Then("tracking information is not visible or accessible", () => {
 SecurityPage.verifyTrackingNotExposed();
});

Given("access attempts to tracking information occur", () => {
 SecurityPage.verifyAccessAttempts();
});

When("logging is checked", () => {
 SecurityPage.checkLogging();
});

Then("access attempts are logged for auditing", () => {
 SecurityPage.verifyAccessLogging();
});

Given("tracking information access occurs", () => {
 SecurityPage.verifyTrackingAccess();
});

When("compliance with data protection regulations is verified", () => {
 SecurityPage.verifyCompliance();
});

Then("tracking information access complies with relevant regulations", () => {
 SecurityPage.verifyRegulationCompliance();
});

Given("tracking information is transmitted", () => {
 SecurityPage.verifyTransmission();
});

When("encryption is applied", () => {
 SecurityPage.applyEncryption();
});

Then("tracking information is encrypted to protect data integrity", () => {
 SecurityPage.verifyEncryption();
});