import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import SessionPage from '../page_objects/sessionPage';

const sessionPage = new SessionPage();

Given('a user is logged into their account', () => {
  sessionPage.login();
});

When('the user remains inactive for a specified period', () => {
  sessionPage.waitForInactivity();
});

Then('the user should be automatically logged out', () => {
  sessionPage.verifyLoggedOut();
});

Given('a user is logged into their account', () => {
  sessionPage.login();
});

And('the user is inactive', () => {
  sessionPage.simulateInactivity();
});

When('the session is about to timeout', () => {
  sessionPage.checkSessionTimeoutWarning();
});

Then('the user should receive a warning notification', () => {
  sessionPage.verifyWarningNotification();
});

When('the user performs any activity within the session', () => {
  sessionPage.performActivity();
});

Then('the session timeout should be reset', () => {
  sessionPage.verifySessionReset();
});

And('the user is inactive for a specified period', () => {
  sessionPage.waitForInactivity();
});

When('the session times out', () => {
  sessionPage.checkSessionTimeout();
});

Then('the user should be redirected to the login page', () => {
  sessionPage.verifyRedirectToLogin();
});

Given('a system administrator accesses the session settings', () => {
  sessionPage.accessSessionSettings();
});

When('the administrator adjusts the session timeout duration', () => {
  sessionPage.adjustSessionTimeout();
});

Then('the new session timeout duration should be applied to all user accounts', () => {
  sessionPage.verifyTimeoutAdjustment();
});

Given('a user is logged into their account on multiple devices', () => {
  sessionPage.loginMultipleDevices();
});

And('the user is inactive on one device', () => {
  sessionPage.simulateInactivityOnDevice();
});

When('the session times out on that device', () => {
  sessionPage.checkDeviceSessionTimeout();
});

Then('the user should remain logged in on the other devices', () => {
  sessionPage.verifyOtherDevicesLoggedIn();
});