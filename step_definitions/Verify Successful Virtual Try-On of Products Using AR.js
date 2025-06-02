import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ARTryOnPage from "../pages/arTryOnPage";

Given("the user has access to the application with AR try-on feature", () => {
 ARTryOnPage.visit();
});

When("the user logs in using a user account", () => {
 ARTryOnPage.login();
});

Then("the user is logged in and the main interface is displayed", () => {
 ARTryOnPage.verifyMainInterface();
});

Given("the user is logged in", () => {
 ARTryOnPage.verifyLogin();
});

When("the user navigates to the product catalog with AR try-on options", () => {
 ARTryOnPage.navigateToProductCatalog();
});

Then("the product catalog is displayed with AR try-on enabled products", () => {
 ARTryOnPage.verifyProductCatalog();
});

Given("the product catalog is displayed with AR try-on enabled products", () => {
 ARTryOnPage.verifyProductCatalog();
});

When("the user selects a product with AR try-on capability", () => {
 ARTryOnPage.selectProduct();
});

Then("the product details page is displayed with try-on option", () => {
 ARTryOnPage.verifyProductDetailsPage();
});

Given("the product details page is displayed with try-on option", () => {
 ARTryOnPage.verifyProductDetailsPage();
});

When("the user activates the AR try-on feature for the selected product", () => {
 ARTryOnPage.activateARTryOn();
});

Then("the AR try-on interface is activated, displaying the product virtually", () => {
 ARTryOnPage.verifyARTryOnInterface();
});

Given("the AR try-on interface is activated", () => {
 ARTryOnPage.verifyARTryOnInterface();
});

When("the user aligns the product virtually with their image", () => {
 ARTryOnPage.alignProductWithImage();
});

Then("the product aligns accurately with the user's image", () => {
 ARTryOnPage.verifyAlignment();
});

Given("the user has access to multiple products with AR try-on capability", () => {
 ARTryOnPage.verifyMultipleProductsAccess();
});

When("the user tests the AR try-on feature with different products", () => {
 ARTryOnPage.testARTryOnWithDifferentProducts();
});

Then("the AR try-on works consistently across various products", () => {
 ARTryOnPage.verifyConsistencyAcrossProducts();
});

Given("the AR try-on feature is activated", () => {
 ARTryOnPage.verifyARTryOnInterface();
});

When("the user evaluates the realism and accuracy of the virtual try-on", () => {
 ARTryOnPage.evaluateRealismAndAccuracy();
});

Then("the virtual try-on is realistic and accurately represents the product", () => {
 ARTryOnPage.verifyRealismAndAccuracy();
});

When("the user checks for performance issues during the AR try-on process", () => {
 ARTryOnPage.checkForPerformanceIssues();
});

Then("there are no performance issues or lag during AR try-on", () => {
 ARTryOnPage.verifyNoPerformanceIssues();
});

When("the user tests the AR try-on feature in different lighting conditions", () => {
 ARTryOnPage.testInDifferentLightingConditions();
});

Then("the AR try-on performs well in varied lighting conditions", () => {
 ARTryOnPage.verifyPerformanceInLightingConditions();
});

Given("the user is using a device without a camera", () => {
 ARTryOnPage.verifyNoCameraDevice();
});

When("the user attempts to use the AR try-on feature", () => {
 ARTryOnPage.attemptARTryOnWithoutCamera();
});

Then("an appropriate message indicating camera requirement is displayed", () => {
 ARTryOnPage.verifyCameraRequirementMessage();
});

Given("the AR try-on feature is disabled", () => {
 ARTryOnPage.verifyARTryOnDisabled();
});

When("the user attempts to use the AR try-on feature", () => {
 ARTryOnPage.attemptARTryOnWhenDisabled();
});

Then("the application indicates AR try-on is not available", () => {
 ARTryOnPage.verifyARTryOnNotAvailableMessage();
});

When("the user checks the AR try-on content", () => {
 ARTryOnPage.checkARTryOnContent();
});

Then("the AR try-on content is current and reflects the latest product details", () => {
 ARTryOnPage.verifyContentAccuracy();
});

Given("the user is testing the AR try-on feature", () => {
 ARTryOnPage.verifyTestingARTryOn();
});

When("the user observes any issues or inconsistencies", () => {
 ARTryOnPage.observeIssues();
});

Then("the user documents detailed issues with suggestions for improvements", () => {
 ARTryOnPage.documentIssuesAndSuggestions();
});

Given("the user has completed testing the AR try-on feature", () => {
 ARTryOnPage.verifyCompletedTesting();
});

When("the user concludes the test", () => {
 ARTryOnPage.concludeTest();
});

Then("an evaluation report on the effectiveness and user experience of AR try-on is created", () => {
 ARTryOnPage.createEvaluationReport();
});

Given("the user has completed the evaluation of the AR try-on feature", () => {
 ARTryOnPage.verifyCompletedEvaluation();
});

When("the user provides feedback and suggestions", () => {
 ARTryOnPage.provideFeedbackAndSuggestions();
});

Then("feedback and suggestions for improvement are documented", () => {
 ARTryOnPage.verifyFeedbackDocumentation();
});