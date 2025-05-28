import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MobilePage from "../pages/mobilePage";

Given("the website is deployed and accessible", () => {
 MobilePage.visit();
});

Given("I am using a {string} with {string} resolution", (device, resolution) => {
 MobilePage.setDeviceResolution(device, resolution);
});

Given("I am using a mobile device", () => {
 MobilePage.setMobileDevice();
});

When("I navigate to the homepage", () => {
 MobilePage.navigateToHomepage();
});

When("I view the website in portrait orientation", () => {
 MobilePage.setOrientation("portrait");
});

When("I switch to landscape orientation", () => {
 MobilePage.setOrientation("landscape");
});

When("I tap on a button or link", () => {
 MobilePage.tapButtonOrLink();
});

When("I focus on a text input field", () => {
 MobilePage.focusOnTextInput();
});

When("I play a video or audio file", () => {
 MobilePage.playMedia();
});

Then("the website should load without any layout issues", () => {
 MobilePage.verifyNoLayoutIssues();
});

Then("all interactive elements should be functional", () => {
 MobilePage.verifyInteractiveElementsFunctional();
});

Then("the navigation menu should be accessible and functional", () => {
 MobilePage.verifyNavigationMenu();
});

Then("the content should be readable without zooming", () => {
 MobilePage.verifyContentReadable();
});

Then("the website should display correctly without horizontal scrolling", () => {
 MobilePage.verifyNoHorizontalScrolling();
});

Then("the website should adjust and display correctly without vertical scrolling", () => {
 MobilePage.verifyNoVerticalScrolling();
});

Then("the corresponding action should be performed", () => {
 MobilePage.verifyActionPerformed();
});

Then("there should be no delay in response", () => {
 MobilePage.verifyNoDelay();
});

Then("the on-screen keyboard should appear", () => {
 MobilePage.verifyKeyboardAppearance();
});

Then("I should be able to enter text without issues", () => {
 MobilePage.verifyTextEntry();
});

Then("the media should play smoothly", () => {
 MobilePage.verifyMediaPlayback();
});

Then("the controls should be accessible and functional", () => {
 MobilePage.verifyMediaControls();
});