import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import WebAppPage from "../pages/webAppPage";

Given("the web application is deployed using HTML5, CSS3, and JavaScript", () => {
  WebAppPage.verifyDeployment();
});

Given("the web application is open", () => {
  WebAppPage.open();
});

When("I open the web application in {string}", (browser) => {
  WebAppPage.openInBrowser(browser);
});

When("I navigate through the {string}", (page) => {
  WebAppPage.navigate(page);
});

When("I check CSS3 {string}", (animationOrTransition) => {
  WebAppPage.checkCSS3(animationOrTransition);
});

When("I verify HTML5 {string} playback", (mediaType) => {
  WebAppPage.verifyHTML5Playback(mediaType);
});

When("I test JavaScript {string}", (interactionType) => {
  WebAppPage.testJavaScript(interactionType);
});

Then("the application loads successfully", () => {
  WebAppPage.verifyLoadSuccess();
});

Then("the {string} displays correctly with all elements visible", (page) => {
  WebAppPage.verifyPageDisplay(page);
});

Then("the {string} play smoothly without lag", (animationOrTransition) => {
  WebAppPage.verifySmoothPlay(animationOrTransition);
});

Then("the {string} plays without issues", (mediaType) => {
  WebAppPage.verifyMediaPlayback(mediaType);
});

Then("the forms respond correctly to user inputs", () => {
  WebAppPage.verifyFormResponse();
});

Then("the validation works correctly, preventing incorrect submissions", () => {
  WebAppPage.verifyValidation();
});

Then("the layout adjusts correctly across different screen sizes", () => {
  WebAppPage.verifyLayoutAdjustment();
});

Then("the local storage retains data accurately", () => {
  WebAppPage.verifyLocalStorage();
});

Then("the events trigger correctly without errors", () => {
  WebAppPage.verifyEventHandling();
});