import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("I am logged in as an admin", () => {
  cy.loginAsAdmin();
});

Given("I navigate to the product addition section", () => {
  ProductPage.visit();
});

When("I attempt to add a product with a missing name field", () => {
  ProductPage.addProductWithMissingName();
});

Then("the system displays an error message indicating missing required fields", () => {
  ProductPage.verifyMissingNameErrorMessage();
});

When("I attempt to add a product with an invalid price format", () => {
  ProductPage.addProductWithInvalidPrice();
});

Then("the system displays an error message indicating invalid price format", () => {
  ProductPage.verifyInvalidPriceErrorMessage();
});

When("I attempt to add a product with missing category information", () => {
  ProductPage.addProductWithMissingCategory();
});

Then("the system displays an error message indicating missing category information", () => {
  ProductPage.verifyMissingCategoryErrorMessage();
});

When("I attempt to add a product with an excessively long description", () => {
  ProductPage.addProductWithLongDescription();
});

Then("the system displays an error message indicating description exceeds maximum length", () => {
  ProductPage.verifyLongDescriptionErrorMessage();
});

Given("I attempt to add products with invalid details", () => {
  ProductPage.attemptInvalidProductAdditions();
});

When("I check the system logs", () => {
  ProductPage.checkSystemLogs();
});

Then("the system logs record all invalid attempts with appropriate error messages", () => {
  ProductPage.verifySystemLogs();
});

When("I check the database", () => {
  ProductPage.checkDatabase();
});

Then("the database remains unchanged; no invalid product entries are stored", () => {
  ProductPage.verifyDatabaseUnchanged();
});

Given("I repeatedly attempt to add products with invalid details", () => {
  ProductPage.repeatedInvalidProductAdditions();
});

When("I monitor the system alerts", () => {
  ProductPage.monitorSystemAlerts();
});

Then("alerts are triggered for repeated invalid attempts", () => {
  ProductPage.verifySystemAlerts();
});

Given("I am an admin attempting to add products with invalid details", () => {
  ProductPage.attemptInvalidProductAdditions();
});

When("I receive feedback from the system", () => {
  ProductPage.receiveSystemFeedback();
});

Then("the admin receives clear feedback on invalid input without system crashes", () => {
  ProductPage.verifyAdminFeedback();
});

When("I check the security protocols", () => {
  ProductPage.checkSecurityProtocols();
});

Then("security protocols are enforced without compromise", () => {
  ProductPage.verifySecurityProtocols();
});

Given("I accidentally add a product with invalid details", () => {
  ProductPage.accidentalInvalidProductAddition();
});

When("I attempt to undo the addition", () => {
  ProductPage.undoInvalidAddition();
});

Then("admins can undo invalid product additions successfully", () => {
  ProductPage.verifyUndoFunctionality();
});

When("I review the audit trails", () => {
  ProductPage.reviewAuditTrails();
});

Then("audit trails accurately record all invalid attempts by admin", () => {
  ProductPage.verifyAuditTrails();
});

When("I check synchronization with external systems", () => {
  ProductPage.checkExternalSystemSync();
});

Then("no invalid product updates are synchronized with external systems", () => {
  ProductPage.verifyExternalSystemSync();
});

When("I monitor system performance", () => {
  ProductPage.monitorSystemPerformance();
});

Then("system performance remains stable without degradation", () => {
  ProductPage.verifySystemPerformance();
});

When("I receive error messages", () => {
  ProductPage.receiveErrorMessages();
});

Then("error messages provide clear guidance on correcting invalid input", () => {
  ProductPage.verifyErrorMessages();
});