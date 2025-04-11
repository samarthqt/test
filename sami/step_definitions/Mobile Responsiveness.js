const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const MobilePage = require('../../page_objects/MobilePage');

Given('the website is deployed and accessible', () => {
  cy.visit('/');
});

Given('I am using a {string} with {string} resolution', (device, resolution) => {
  cy.viewport(device, resolution);
});

When('I navigate to the homepage', () => {
  MobilePage.navigateToHomepage();
});

Then('the website should load without any layout issues', () => {
  MobilePage.verifyNoLayoutIssues();
});

Then('all interactive elements should be functional', () => {
  MobilePage.verifyInteractiveElements();
});

Then('the navigation menu should be accessible and functional', () => {
  MobilePage.verifyNavigationMenu();
});

Then('the content should be readable without zooming', () => {
  MobilePage.verifyContentReadability();
});

Given('I am using a mobile device', () => {
  cy.viewport('iphone-x');
});

When('I view the website in portrait orientation', () => {
  MobilePage.verifyPortraitOrientation();
});

Then('the website should display correctly without horizontal scrolling', () => {
  MobilePage.verifyNoHorizontalScrolling();
});

When('I switch to landscape orientation', () => {
  MobilePage.switchToLandscape();
});

Then('the website should adjust and display correctly without vertical scrolling', () => {
  MobilePage.verifyNoVerticalScrolling();
});

When('I tap on a button or link', () => {
  MobilePage.tapButtonOrLink();
});

Then('the corresponding action should be performed', () => {
  MobilePage.verifyActionPerformed();
});

Then('there should be no delay in response', () => {
  MobilePage.verifyNoDelayInResponse();
});

When('I focus on a text input field', () => {
  MobilePage.focusOnTextInput();
});

Then('the on-screen keyboard should appear', () => {
  MobilePage.verifyKeyboardAppearance();
});

Then('I should be able to enter text without issues', () => {
  MobilePage.verifyTextInput();
});

When('I play a video or audio file', () => {
  MobilePage.playMediaFile();
});

Then('the media should play smoothly', () => {
  MobilePage.verifyMediaPlayback();
});

Then('the controls should be accessible and functional', () => {
  MobilePage.verifyMediaControls();
});