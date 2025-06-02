import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccessibilityPage from "../pages/accessibilityPage";

Given("the user interface is loaded", () => {
 AccessibilityPage.visit();
});

Given("the user interface is under high server load", () => {
 AccessibilityPage.simulateHighLoad();
});

Given("the user interface is loaded on a mobile device", () => {
 AccessibilityPage.visitMobile();
});

Given("the user interface is under low bandwidth conditions", () => {
 AccessibilityPage.simulateLowBandwidth();
});

When("accessibility features are enabled", () => {
 AccessibilityPage.enableAccessibilityFeatures();
});

When("a screen reader is used with the interface", () => {
 AccessibilityPage.useScreenReader();
});

When("navigating through the interface using a keyboard", () => {
 AccessibilityPage.navigateWithKeyboard();
});

When("checking color contrast settings", () => {
 AccessibilityPage.checkColorContrast();
});

When("checking images for alternative text", () => {
 AccessibilityPage.checkImagesForAltText();
});

When("using voice commands with the interface", () => {
 AccessibilityPage.useVoiceCommands();
});

When("accessing forms in the interface", () => {
 AccessibilityPage.accessForms();
});

When("using accessibility features", () => {
 AccessibilityPage.useAccessibilityFeatures();
});

When("verifying compliance with accessibility guidelines", () => {
 AccessibilityPage.verifyCompliance();
});

When("simulating various disabilities", () => {
 AccessibilityPage.simulateDisabilities();
});

When("checking documentation", () => {
 AccessibilityPage.checkDocumentation();
});

When("accessing the interface with different user roles", () => {
 AccessibilityPage.accessWithDifferentRoles();
});

When("checking accessibility features", () => {
 AccessibilityPage.checkAccessibilityFeatures();
});

Then("accessibility features should be enabled successfully", () => {
 AccessibilityPage.verifyAccessibilityEnabled();
});

Then("the screen reader should work seamlessly with the interface", () => {
 AccessibilityPage.verifyScreenReaderCompatibility();
});

Then("keyboard navigation should be smooth and functional", () => {
 AccessibilityPage.verifyKeyboardNavigation();
});

Then("color contrast settings should be appropriate for readability", () => {
 AccessibilityPage.verifyColorContrast();
});

Then("all images should have appropriate alternative text", () => {
 AccessibilityPage.verifyAltTextForImages();
});

Then("voice commands should work effectively with the interface", () => {
 AccessibilityPage.verifyVoiceCommands();
});

Then("forms should be accessible and navigable", () => {
 AccessibilityPage.verifyFormsAccessibility();
});

Then("accessibility features should remain functional during high load", () => {
 AccessibilityPage.verifyHighLoadAccessibility();
});

Then("the interface should comply with all accessibility guidelines", () => {
 AccessibilityPage.verifyGuidelineCompliance();
});

Then("accessibility features should be functional on mobile devices", () => {
 AccessibilityPage.verifyMobileAccessibility();
});

Then("the interface should be usable under different disability simulations", () => {
 AccessibilityPage.verifyDisabilitySimulations();
});

Then("accessibility compliance should be documented accurately", () => {
 AccessibilityPage.verifyDocumentation();
});

Then("the interface should be accessible for all user roles", () => {
 AccessibilityPage.verifyRoleAccessibility();
});

Then("all accessibility features should be enabled by default", () => {
 AccessibilityPage.verifyDefaultAccessibilityFeatures();
});

Then("accessibility features should remain functional under low bandwidth conditions", () => {
 AccessibilityPage.verifyLowBandwidthAccessibility();
});