import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UnsupportedBrowserPage from "../pages/unsupportedBrowserPage";

Given("a mobile device with an unsupported browser", () => {
 UnsupportedBrowserPage.setupUnsupportedBrowser();
});

When("I open the unsupported browser on the mobile device", () => {
 UnsupportedBrowserPage.openBrowser();
});

Then("the browser opens successfully", () => {
 UnsupportedBrowserPage.verifyBrowserOpens();
});

Given("the browser is open on the mobile device", () => {
 UnsupportedBrowserPage.browserIsOpen();
});

When("I navigate to the application's URL using the browser", () => {
 UnsupportedBrowserPage.navigateToApplicationURL();
});

Then("the URL is entered correctly", () => {
 UnsupportedBrowserPage.verifyURLEntered();
});

Given("the URL is entered in the browser", () => {
 UnsupportedBrowserPage.urlIsEntered();
});

When("I attempt to load the application in the browser", () => {
 UnsupportedBrowserPage.loadApplication();
});

Then("the application fails to load, displaying an error message", () => {
 UnsupportedBrowserPage.verifyApplicationFailsToLoad();
});

Given("the application fails to load", () => {
 UnsupportedBrowserPage.applicationFailsToLoad();
});

When("I check if any application components are visible", () => {
 UnsupportedBrowserPage.checkVisibilityOfComponents();
});

Then("no application components are visible", () => {
 UnsupportedBrowserPage.verifyNoComponentsVisible();
});

Given("an error message is displayed", () => {
 UnsupportedBrowserPage.errorMessageIsDisplayed();
});

When("I verify the error message provides information about unsupported browser", () => {
 UnsupportedBrowserPage.verifyErrorMessageInfo();
});

Then("the error message clearly states browser is unsupported", () => {
 UnsupportedBrowserPage.verifyErrorMessageUnsupported();
});

Given("no application components are visible", () => {
 UnsupportedBrowserPage.noComponentsVisible();
});

When("I attempt to interact with any visible elements", () => {
 UnsupportedBrowserPage.interactWithVisibleElements();
});

Then("interactions fail or are not possible", () => {
 UnsupportedBrowserPage.verifyInteractionsFail();
});

When("I check browser console for error logs related to application loading", () => {
 UnsupportedBrowserPage.checkConsoleErrorLogs();
});

Then("error logs are present indicating loading issues", () => {
 UnsupportedBrowserPage.verifyErrorLogsPresent();
});

When("I try refreshing the page to reload the application", () => {
 UnsupportedBrowserPage.refreshPage();
});

Then("page refresh does not resolve loading issues", () => {
 UnsupportedBrowserPage.verifyRefreshNotResolve();
});

When("I verify network requests for application resources", () => {
 UnsupportedBrowserPage.verifyNetworkRequests();
});

Then("network requests fail or return errors", () => {
 UnsupportedBrowserPage.verifyNetworkRequestsFail();
});

Given("the application fails to load on unsupported browser", () => {
 UnsupportedBrowserPage.applicationFailsOnUnsupportedBrowser();
});

When("I attempt to access the application on a supported browser", () => {
 UnsupportedBrowserPage.accessApplicationOnSupportedBrowser();
});

Then("the application loads successfully on supported browser", () => {
 UnsupportedBrowserPage.verifyApplicationLoadsOnSupportedBrowser();
});

Given("the application is accessed on both browsers", () => {
 UnsupportedBrowserPage.applicationAccessedOnBothBrowsers();
});

When("I compare the behavior between supported and unsupported browsers", () => {
 UnsupportedBrowserPage.compareBrowserBehavior();
});

Then("supported browser functionality is complete; unsupported browser shows errors", () => {
 UnsupportedBrowserPage.verifySupportedBrowserFunctionality();
});

When("I document the unsupported browser's version and behavior", () => {
 UnsupportedBrowserPage.documentBrowserVersionAndBehavior();
});

Then("documentation is complete with browser details", () => {
 UnsupportedBrowserPage.verifyDocumentationComplete();
});

When("I check for any browser-specific settings that could affect loading", () => {
 UnsupportedBrowserPage.checkBrowserSpecificSettings();
});

Then("settings do not resolve loading issues", () => {
 UnsupportedBrowserPage.verifySettingsNotResolveIssues();
});

When("I attempt to install any browser extensions to improve compatibility", () => {
 UnsupportedBrowserPage.installBrowserExtensions();
});

Then("extensions do not resolve loading issues", () => {
 UnsupportedBrowserPage.verifyExtensionsNotResolveIssues();
});

When("I confirm unsupported browser behavior with development team", () => {
 UnsupportedBrowserPage.confirmBehaviorWithDevTeam();
});

Then("development team confirms browser is unsupported", () => {
 UnsupportedBrowserPage.verifyDevTeamConfirmation();
});