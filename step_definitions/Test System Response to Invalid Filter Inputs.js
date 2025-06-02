import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductListingPage from "../pages/productListingPage";

Given("the application is open", () => {
 cy.visit("/");
});

When("I navigate to the product listing page", () => {
 ProductListingPage.visit();
});

Then("the product listing page should load successfully", () => {
 ProductListingPage.verifyPageLoad();
});

Given("I am on the product listing page", () => {
 ProductListingPage.visit();
});

When("I attempt to apply a filter using special characters", () => {
 ProductListingPage.applyFilter("@#$%^&*");
});

Then("the system should prevent the application of filters with special characters", () => {
 ProductListingPage.verifySpecialCharacterFilterPrevention();
});

When("I attempt to apply a filter using excessively long strings", () => {
 ProductListingPage.applyFilter("a".repeat(1000));
});

Then("the system should display an error message for excessively long filter inputs", () => {
 ProductListingPage.verifyLongStringFilterError();
});

When("I attempt to apply a filter with unsupported data types", () => {
 ProductListingPage.applyFilter(12345);
});

Then("the system should reject filters with unsupported data types", () => {
 ProductListingPage.verifyUnsupportedDataTypeFilterRejection();
});

Given("I have attempted invalid filter inputs", () => {
 // Simulating invalid filter inputs
 ProductListingPage.applyInvalidFilters();
});

When("I check the system logs", () => {
 ProductListingPage.checkSystemLogs();
});

Then("the system logs should capture invalid filter input attempts", () => {
 ProductListingPage.verifyLogsCaptureInvalidInputs();
});

When("an error message is displayed", () => {
 ProductListingPage.triggerErrorMessage();
});

Then("the error message should be clear and informative", () => {
 ProductListingPage.verifyErrorMessageClarity();
});

When("I measure the system's response time", () => {
 ProductListingPage.measureResponseTime();
});

Then("the system response time should be within acceptable limits", () => {
 ProductListingPage.verifyResponseTime();
});

When("I attempt to submit an invalid filter input multiple times", () => {
 ProductListingPage.submitInvalidFilterMultipleTimes();
});

Then("the system should consistently reject invalid filter inputs", () => {
 ProductListingPage.verifyConsistentRejection();
});

When("I use other functionalities", () => {
 ProductListingPage.useOtherFunctionalities();
});

Then("invalid filter inputs should not affect other functionalities", () => {
 ProductListingPage.verifyFunctionalityIntegrity();
});

When("I attempt to bypass filter validation using browser developer tools", () => {
 ProductListingPage.bypassValidationUsingDevTools();
});

Then("the system should prevent bypassing filter validation", () => {
 ProductListingPage.verifyBypassPrevention();
});

When("I apply multiple invalid filter inputs simultaneously", () => {
 ProductListingPage.applyMultipleInvalidFilters();
});

Then("the system should handle multiple invalid inputs gracefully", () => {
 ProductListingPage.verifyGracefulHandling();
});

Given("I have cleared the browser cache", () => {
 cy.clearCookies();
 cy.clearLocalStorage();
});

When("I attempt to apply invalid filter inputs", () => {
 ProductListingPage.applyInvalidFilters();
});

Then("invalid filter inputs should still be rejected after clearing cache", () => {
 ProductListingPage.verifyPostCacheClearRejection();
});

When("I apply a combination of valid and invalid filter inputs", () => {
 ProductListingPage.applyMixedFilters();
});

Then("only valid filter inputs should be applied", () => {
 ProductListingPage.verifyValidFilterApplication();
});

When("an error occurs", () => {
 ProductListingPage.triggerError();
});

Then("the error handling mechanism should be robust and effective", () => {
 ProductListingPage.verifyErrorHandlingMechanism();
});

When("I check the audit logs", () => {
 ProductListingPage.checkAuditLogs();
});

Then("invalid filter inputs should be logged for audit purposes", () => {
 ProductListingPage.verifyAuditLogEntries();
});