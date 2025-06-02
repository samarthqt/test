import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ARPage from "../pages/arPage";

Given("the user has access to the application with AR functionality", () => {
 ARPage.visit();
});

When("the user logs in with a user account", () => {
 ARPage.login();
});

Then("the user is logged in and the main interface is displayed", () => {
 ARPage.verifyMainInterface();
});

Given("the user is logged in to the application", () => {
 ARPage.verifyLogin();
});

When("the user navigates to the AR feature section", () => {
 ARPage.navigateToARFeature();
});

Then("the AR feature interface is displayed with options to explore", () => {
 ARPage.verifyARFeatureInterface();
});

Given("the user is at the AR feature interface", () => {
 ARPage.verifyARFeatureInterface();
});

When("the user selects an AR-enabled product to view in AR mode", () => {
 ARPage.selectARProduct();
});

Then("the product is displayed in AR mode", () => {
 ARPage.verifyARMode();
});

Given("the product is displayed in AR mode", () => {
 ARPage.verifyARMode();
});

When("the user interacts with the AR model by rotating, zooming, or moving", () => {
 ARPage.interactWithARModel();
});

Then("the AR model responds smoothly to interactions", () => {
 ARPage.verifyARModelInteraction();
});

Given("the AR model is displayed in AR mode", () => {
 ARPage.verifyARMode();
});

When("the user evaluates the realism of the AR model in terms of texture and detail", () => {
 ARPage.evaluateARModelRealism();
});

Then("the AR model is realistic with high-quality texture and detail", () => {
 ARPage.verifyARModelQuality();
});

Given("the user has access to devices with different screen sizes and resolutions", () => {
 ARPage.accessDifferentDevices();
});

When("the user tests the AR experience on these devices", () => {
 ARPage.testARExperienceOnDevices();
});

Then("the AR experience is consistent and user-friendly across devices", () => {
 ARPage.verifyARConsistency();
});

Given("the user is interacting with the AR model", () => {
 ARPage.verifyARModelInteraction();
});

When("the user checks for lag or performance issues", () => {
 ARPage.checkPerformanceIssues();
});

Then("no lag or performance issues are observed", () => {
 ARPage.verifyNoPerformanceIssues();
});

Given("the user is a first-time user", () => {
 ARPage.verifyFirstTimeUser();
});

When("the user navigates the AR interface", () => {
 ARPage.navigateARInterface();
});

Then("the AR interface is intuitive and easy to navigate for new users", () => {
 ARPage.verifyEaseOfUse();
});

Given("the user is interacting with the AR model", () => {
 ARPage.verifyARModelInteraction();
});

When("the user tests the AR experience in different lighting conditions", () => {
 ARPage.testARInDifferentLighting();
});

Then("the AR experience remains realistic in varied lighting conditions", () => {
 ARPage.verifyLightingConsistency();
});

Given("the user has access to a device with low processing power", () => {
 ARPage.accessLowPowerDevice();
});

When("the user attempts to use AR on this device", () => {
 ARPage.useAROnLowPowerDevice();
});

Then("AR functions with minimal lag on low-power devices", () => {
 ARPage.verifyLowPowerPerformance();
});

Given("the user is using a device that does not support AR", () => {
 ARPage.verifyDeviceSupport();
});

When("the user attempts to access AR functionality", () => {
 ARPage.accessARFunctionality();
});

Then("the application provides a clear message indicating lack of support", () => {
 ARPage.verifyLackOfSupportMessage();
});

Given("the user is viewing AR content", () => {
 ARPage.verifyARContentViewing();
});

When("the user checks the AR content for updates and accuracy", () => {
 ARPage.checkARContentUpdates();
});

Then("the AR content is consistent with the latest product information", () => {
 ARPage.verifyARContentAccuracy();
});

Given("the user is testing the AR experience", () => {
 ARPage.verifyARExperienceTesting();
});

When("the user documents any issues or inconsistencies found", () => {
 ARPage.documentIssues();
});

Then("detailed documentation of issues with improvement suggestions is provided", () => {
 ARPage.verifyDocumentation();
});

Given("the user has completed testing the AR experience", () => {
 ARPage.verifyTestingCompletion();
});

When("the user evaluates the AR experience", () => {
 ARPage.evaluateARExperience();
});

Then("a comprehensive report on the realism and user-friendliness of AR is provided", () => {
 ARPage.verifyComprehensiveReport();
});

Given("the user has evaluated the AR experience", () => {
 ARPage.verifyEvaluationCompletion();
});

When("the user provides feedback and suggestions for enhancement", () => {
 ARPage.provideFeedback();
});

Then("feedback and suggestions are documented for future improvements", () => {
 ARPage.verifyFeedbackDocumentation();
});