import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import BrowserPage from "../pages/browserPage";

Given("the application is opened in the latest version of {string}", (browser) => {
 BrowserPage.openInBrowser(browser);
});

When("the user navigates through the application", () => {
 BrowserPage.navigateThroughApplication();
});

Then("the application should function correctly without any layout or functionality issues", () => {
 BrowserPage.verifyApplicationFunctionality();
});

Given("a major update has been released for the application", () => {
 BrowserPage.checkForMajorUpdate();
});

When("browser compatibility tests are executed across Chrome, Firefox, Safari, and Edge", () => {
 BrowserPage.executeCompatibilityTests();
});

Given("the application is opened in different browsers", () => {
 BrowserPage.openInDifferentBrowsers();
});

When("the user resizes the browser window", () => {
 BrowserPage.resizeBrowserWindow();
});

Then("the responsive design should adapt correctly to each browser's requirements", () => {
 BrowserPage.verifyResponsiveDesign();
});

Given("the application uses features not supported by all browsers", () => {
 BrowserPage.checkUnsupportedFeatures();
});

When("a user accesses the application with a browser that does not support certain features", () => {
 BrowserPage.accessWithUnsupportedBrowser();
});

Then("the application should provide appropriate fallback solutions to ensure functionality is maintained", () => {
 BrowserPage.verifyFallbackSolutions();
});