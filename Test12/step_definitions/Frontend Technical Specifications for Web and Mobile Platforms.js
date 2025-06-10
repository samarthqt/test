import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import FrontendPage from "../pages/frontendPage";

Given("a web application frontend", () => {
 FrontendPage.visitWebApp();
});

When("the application is loaded", () => {
 FrontendPage.loadApplication();
});

Then("it should utilize HTML5, CSS3, and JavaScript effectively", () => {
 FrontendPage.verifyHTML5CSS3JavaScript();
});

Given("a dynamic web application", () => {
 FrontendPage.visitDynamicWebApp();
});

When("the application requires interactive features", () => {
 FrontendPage.requireInteractiveFeatures();
});

Then("React.js or Angular.js should be implemented", () => {
 FrontendPage.verifyReactAngularImplementation();
});

Given("a mobile application frontend", () => {
 FrontendPage.visitMobileApp();
});

When("the application is developed for multiple platforms", () => {
 FrontendPage.developForMultiplePlatforms();
});

Then("it should use React Native or Flutter for cross-platform compatibility", () => {
 FrontendPage.verifyReactNativeFlutterCompatibility();
});

Given("a frontend application", () => {
 FrontendPage.visitFrontendApp();
});

When("the application is accessed on various devices", () => {
 FrontendPage.accessOnVariousDevices();
});

Then("it should be responsive and adapt to different screen sizes", () => {
 FrontendPage.verifyResponsivenessAdaptability();
});

When("the application is loaded", () => {
 FrontendPage.loadApplication();
});

Then("the code should be optimized for performance ensuring quick load times", () => {
 FrontendPage.verifyCodeOptimization();
});

When("the application is developed", () => {
 FrontendPage.developApplication();
});

Then("security best practices must be adhered to", () => {
 FrontendPage.verifySecurityBestPractices();
});

When("an error occurs during user interaction", () => {
 FrontendPage.errorDuringUserInteraction();
});

Then("error handling must be implemented", () => {
 FrontendPage.verifyErrorHandling();
});

When("accessed through the latest web browsers", () => {
 FrontendPage.accessThroughLatestBrowsers();
});

Then("it should be compatible with them", () => {
 FrontendPage.verifyBrowserCompatibility();
});

When("tested on both web and mobile platforms", () => {
 FrontendPage.testOnWebAndMobile();
});

Then("functionality should be confirmed", () => {
 FrontendPage.confirmFunctionality();
});

Given("a frontend project", () => {
 FrontendPage.visitFrontendProject();
});

When("the project is completed", () => {
 FrontendPage.completeProject();
});

Then("documentation must be provided for frontend technologies used", () => {
 FrontendPage.verifyDocumentation();
});