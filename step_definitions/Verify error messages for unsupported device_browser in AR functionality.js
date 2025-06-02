import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ARPage from "../pages/arPage";

Given("I have opened the application on an unsupported browser", () => {
 ARPage.openUnsupportedBrowser();
});

Then("the application should display a clear error message indicating that the browser is unsupported for AR functionality", () => {
 ARPage.verifyBrowserUnsupportedError();
});

Given("I attempt to access AR features using an unsupported device", () => {
 ARPage.useUnsupportedDevice();
});

Then("an error message should be displayed indicating that the device is not supported for AR functionality", () => {
 ARPage.verifyDeviceUnsupportedError();
});

Given("I check the application documentation", () => {
 ARPage.checkDocumentation();
});

Then("the documentation should clearly list supported devices and browsers for AR functionality", () => {
 ARPage.verifySupportedDevicesAndBrowsersInDocumentation();
});

Given("I try accessing AR features using a supported device and browser", () => {
 ARPage.accessARWithSupportedDeviceAndBrowser();
});

Then("AR functionality should work without displaying any error messages", () => {
 ARPage.verifyARFunctionalityWorks();
});

Given("AR functionality is active", () => {
 ARPage.activateARFunctionality();
});

When("I switch to an unsupported browser", () => {
 ARPage.switchToUnsupportedBrowser();
});

Then("the application should immediately display an error message indicating the browser is unsupported", () => {
 ARPage.verifyImmediateBrowserUnsupportedError();
});

Given("I attempt to access non-AR features on an unsupported browser", () => {
 ARPage.accessNonARFeaturesOnUnsupportedBrowser();
});

Then("non-AR features should function normally without error messages", () => {
 ARPage.verifyNonARFeaturesFunctionNormally();
});

Given("I change device settings to simulate unsupported device conditions", () => {
 ARPage.simulateUnsupportedDeviceConditions();
});

Then("the application should detect the unsupported conditions and display an appropriate error message", () => {
 ARPage.verifyUnsupportedConditionsError();
});

Given("an error message is displayed for unsupported browser/device", () => {
 ARPage.displayErrorMessageForUnsupportedBrowserDevice();
});

Then("the error message should include guidance or links to supported browsers/devices", () => {
 ARPage.verifyGuidanceInErrorMessage();
});

Given("there are different unsupported conditions", () => {
 ARPage.differentUnsupportedConditions();
});

Then("error messages should be consistent and clear regardless of the unsupported condition", () => {
 ARPage.verifyConsistencyOfErrorMessages();
});

Given("I attempt to use AR functionality with outdated device software", () => {
 ARPage.useARWithOutdatedSoftware();
});

Then("an error message should indicate the software version is unsupported for AR functionality", () => {
 ARPage.verifyOutdatedSoftwareError();
});

Given("I attempt to access AR functionality with unsupported conditions", () => {
 ARPage.accessARWithUnsupportedConditions();
});

Then("the application should log unsupported access attempts for auditing purposes", () => {
 ARPage.verifyLoggingOfUnsupportedAccessAttempts();
});

Given("an unsupported condition is detected", () => {
 ARPage.detectUnsupportedCondition();
});

Then("error messages should be displayed promptly without delay", () => {
 ARPage.verifyPromptErrorMessageDisplay();
});

Given("there is a network failure during AR functionality access on an unsupported device", () => {
 ARPage.networkFailureOnUnsupportedDevice();
});

Then("the application should prioritize displaying the unsupported device error message over network failure messages", () => {
 ARPage.verifyPriorityOfUnsupportedDeviceError();
});

Given("I test the application on a device with unsupported hardware specifications", () => {
 ARPage.testOnUnsupportedHardware();
});

Then("an error message should clearly indicate the hardware specifications are unsupported", () => {
 ARPage.verifyUnsupportedHardwareError();
});

Given("an error message is displayed", () => {
 ARPage.displayErrorMessage();
});

Then("the error message should be available in multiple languages based on user settings", () => {
 ARPage.verifyLocalizationOfErrorMessages();
});