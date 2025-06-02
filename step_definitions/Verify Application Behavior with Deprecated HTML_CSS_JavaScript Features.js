import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import DeprecatedFeaturesPage from "../pages/deprecatedFeaturesPage";

Given("the application source code is available in the development environment", () => {
 DeprecatedFeaturesPage.accessSourceCode();
});

Then("the source code should be accessible without errors", () => {
 DeprecatedFeaturesPage.verifySourceCodeAccess();
});

Given("access to the application source code", () => {
 DeprecatedFeaturesPage.accessSourceCode();
});

When("identifying sections of the code using deprecated HTML tags", () => {
 DeprecatedFeaturesPage.identifyDeprecatedHTMLTags();
});

Then("deprecated HTML tags should be identified correctly", () => {
 DeprecatedFeaturesPage.verifyDeprecatedHTMLTags();
});

Given("sections of the code using deprecated HTML tags", () => {
 DeprecatedFeaturesPage.accessDeprecatedHTMLSections();
});

When("attempting to render pages with these tags", () => {
 DeprecatedFeaturesPage.renderPagesWithDeprecatedTags();
});

Then("pages should render with errors or warnings indicating deprecated usage", () => {
 DeprecatedFeaturesPage.verifyPageRenderErrors();
});

When("identifying sections of the code using outdated CSS properties", () => {
 DeprecatedFeaturesPage.identifyOutdatedCSSProperties();
});

Then("outdated CSS properties should be identified correctly", () => {
 DeprecatedFeaturesPage.verifyOutdatedCSSProperties();
});

Given("sections of the code using outdated CSS properties", () => {
 DeprecatedFeaturesPage.accessOutdatedCSSSections();
});

When("attempting to apply styles with these properties", () => {
 DeprecatedFeaturesPage.applyStylesWithOutdatedProperties();
});

Then("styles should not apply correctly, with errors or warnings displayed", () => {
 DeprecatedFeaturesPage.verifyStyleApplicationErrors();
});

When("identifying sections of the code using deprecated JavaScript functions", () => {
 DeprecatedFeaturesPage.identifyDeprecatedJSFunctions();
});

Then("deprecated JavaScript functions should be identified correctly", () => {
 DeprecatedFeaturesPage.verifyDeprecatedJSFunctions();
});

Given("sections of the code using deprecated JavaScript functions", () => {
 DeprecatedFeaturesPage.accessDeprecatedJSSections();
});

When("executing scripts with these functions", () => {
 DeprecatedFeaturesPage.executeScriptsWithDeprecatedFunctions();
});

Then("scripts should execute with errors or warnings indicating deprecated usage", () => {
 DeprecatedFeaturesPage.verifyScriptExecutionErrors();
});

Given("the application is running in a browser", () => {
 DeprecatedFeaturesPage.runApplicationInBrowser();
});

When("checking the browser console for deprecated usage", () => {
 DeprecatedFeaturesPage.checkBrowserConsole();
});

Then("the console should display relevant warnings or errors", () => {
 DeprecatedFeaturesPage.verifyConsoleWarningsErrors();
});

Given("browsers known to have removed support for deprecated features", () => {
 DeprecatedFeaturesPage.accessUnsupportedBrowsers();
});

When("testing application functionality in these browsers", () => {
 DeprecatedFeaturesPage.testFunctionalityInUnsupportedBrowsers();
});

Then("the application should fail to function correctly", () => {
 DeprecatedFeaturesPage.verifyFunctionalityFailure();
});

Given("UI elements styled using deprecated CSS", () => {
 DeprecatedFeaturesPage.accessUIElementsWithDeprecatedCSS();
});

When("attempting to interact with these elements", () => {
 DeprecatedFeaturesPage.interactWithUIElements();
});

Then("UI elements should not respond correctly due to styling issues", () => {
 DeprecatedFeaturesPage.verifyUIInteractionIssues();
});

Given("the application uses deprecated features", () => {
 DeprecatedFeaturesPage.accessApplicationWithDeprecatedFeatures();
});

When("verifying error handling mechanisms", () => {
 DeprecatedFeaturesPage.verifyErrorHandling();
});

Then("error handling should catch and log issues related to deprecated features", () => {
 DeprecatedFeaturesPage.verifyErrorLogging();
});

When("ensuring application stability", () => {
 DeprecatedFeaturesPage.ensureApplicationStability();
});

Then("the application should remain stable despite deprecated feature usage", () => {
 DeprecatedFeaturesPage.verifyApplicationStability();
});

Given("the use of deprecated features in the application", () => {
 DeprecatedFeaturesPage.accessApplicationWithDeprecatedFeatures();
});

When("documenting these features and their impact", () => {
 DeprecatedFeaturesPage.documentDeprecatedFeatures();
});

Then("documentation should clearly outline the impact of deprecated features", () => {
 DeprecatedFeaturesPage.verifyDocumentationImpact();
});

Given("findings from testing deprecated features", () => {
 DeprecatedFeaturesPage.accessTestingFindings();
});

When("reporting to the development team", () => {
 DeprecatedFeaturesPage.reportToDevelopmentTeam();
});

Then("the development team should receive a detailed report for necessary code updates", () => {
 DeprecatedFeaturesPage.verifyReportDelivery();
});

Given("updated code from the development team", () => {
 DeprecatedFeaturesPage.accessUpdatedCode();
});

When("verifying the updated code", () => {
 DeprecatedFeaturesPage.verifyUpdatedCode();
});

Then("the updated code should no longer contain deprecated features", () => {
 DeprecatedFeaturesPage.verifyCodeRemoval();
});