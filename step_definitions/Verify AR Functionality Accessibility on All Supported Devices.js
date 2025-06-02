import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ARPage from "../pages/arPage";

Given("the user is on a supported device", () => {
 ARPage.verifySupportedDevice();
});

When("the user logs into the application", () => {
 ARPage.login();
});

Then("the user is logged in successfully", () => {
 ARPage.verifyLoginSuccess();
});

Then("the main menu is displayed", () => {
 ARPage.verifyMainMenu();
});

Given("the user has access to the application with AR functionality", () => {
 ARPage.verifyARAccess();
});

When("the user navigates to the AR feature section", () => {
 ARPage.navigateToARSection();
});

Then("the AR feature interface is displayed", () => {
 ARPage.verifyARInterface();
});

Then("options to explore AR content are available", () => {
 ARPage.verifyARContentOptions();
});

Given("the user is on the AR feature interface", () => {
 ARPage.verifyARInterface();
});

When("the user selects a product to view in AR mode", () => {
 ARPage.selectProductForAR();
});

Then("the product is displayed in AR mode without any issues", () => {
 ARPage.verifyProductInARMode();
});

Given("a product is displayed in AR mode", () => {
 ARPage.verifyProductInARMode();
});

When("the user interacts with the AR model by rotating or zooming", () => {
 ARPage.interactWithARModel();
});

Then("the AR model responds to interactions smoothly", () => {
 ARPage.verifyARModelInteractions();
});

Given("the application with AR functionality is accessible", () => {
 ARPage.verifyARAccess();
});

When("the user tests AR functionality on {string}", (device_model) => {
 ARPage.testARFunctionalityOnDevice(device_model);
});

Then("AR functionality is consistent across all supported devices", () => {
 ARPage.verifyARConsistency();
});

Given("the AR model is displayed", () => {
 ARPage.verifyProductInARMode();
});

When("the user checks the clarity and resolution of the AR model", () => {
 ARPage.checkARModelClarity();
});

Then("the AR model is clear and has high resolution on all devices", () => {
 ARPage.verifyARModelResolution();
});

Given("the user is interacting with the AR model", () => {
 ARPage.interactWithARModel();
});

When("the user observes the performance during interactions", () => {
 ARPage.observePerformance();
});

Then("no lag or performance issues are observed", () => {
 ARPage.verifyPerformance();
});

Given("the user is on an unsupported device", () => {
 ARPage.verifyUnsupportedDevice();
});

When("the user attempts to access AR functionality", () => {
 ARPage.attemptARAccess();
});

Then("an appropriate error message is displayed", () => {
 ARPage.verifyErrorMessage();
});

Then("access is denied", () => {
 ARPage.verifyAccessDenied();
});

Given("the user is using AR functionality", () => {
 ARPage.verifyARUsage();
});

When("the user tests AR under varied lighting conditions", () => {
 ARPage.testARUnderLightingConditions();
});

Then("AR functionality performs well under varied lighting conditions", () => {
 ARPage.verifyARLightingPerformance();
});

Given("AR functionality is disabled", () => {
 ARPage.verifyARDisabled();
});

When("the user attempts to access AR features", () => {
 ARPage.attemptARAccess();
});

Then("the application provides a clear message indicating AR is disabled", () => {
 ARPage.verifyARDisabledMessage();
});

Given("the user accesses AR content", () => {
 ARPage.accessARContent();
});

When("the user checks the content across devices", () => {
 ARPage.checkARContentAcrossDevices();
});

Then("AR content is consistent and up-to-date across devices", () => {
 ARPage.verifyARContentConsistency();
});

Given("the user is using a device with the latest OS updates", () => {
 ARPage.verifyLatestOS();
});

When("the user accesses AR functionality", () => {
 ARPage.accessARFunctionality();
});

Then("AR functionality remains compatible with the latest OS updates", () => {
 ARPage.verifyARCompatibility();
});

Given("the user is testing AR functionality", () => {
 ARPage.testARFunctionality();
});

When("the user finds any device-specific issues or inconsistencies", () => {
 ARPage.findDeviceIssues();
});

Then("detailed documentation of issues with device-specific recommendations is provided", () => {
 ARPage.provideIssueDocumentation();
});

Given("the user has completed testing AR functionality", () => {
 ARPage.completeARTesting();
});

When("the user evaluates device support coverage", () => {
 ARPage.evaluateDeviceSupport();
});

Then("a comprehensive report on device support and AR functionality accessibility is generated", () => {
 ARPage.generateSupportReport();
});

Given("the user has tested AR functionality", () => {
 ARPage.testARFunctionality();
});

When("the user provides feedback and suggestions for improvement", () => {
 ARPage.provideFeedback();
});

Then("feedback and improvement suggestions are documented", () => {
 ARPage.documentFeedback();
});