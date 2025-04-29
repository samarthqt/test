import { VerificationPage } from '../page_objects/VerificationPage';

const verificationPage = new VerificationPage();

Given('User has a verification code prompt active', () => {
  verificationPage.verifyCodePromptIsActive();
});

When('User enters an incorrect verification code {string} into the system', (code) => {
  verificationPage.enterVerificationCode(code);
});

Then('System displays an error message indicating incorrect code entry', () => {
  verificationPage.verifyErrorMessageDisplayed();
});

Given('User sees an error message for incorrect code entry', () => {
  verificationPage.verifyErrorMessageDisplayed();
});

When('User retries entering the correct verification code {string}', (code) => {
  verificationPage.enterVerificationCode(code);
});

Then('System accepts the correct code and grants access', () => {
  verificationPage.verifyAccessGranted();
});

Then('Error message clearly states the issue and next steps', () => {
  verificationPage.verifyErrorMessageClarity();
});

Given('User enters an incorrect verification code', () => {
  verificationPage.enterIncorrectVerificationCode();
});

Then('System logs the incorrect attempt with timestamp and user ID', () => {
  verificationPage.verifyIncorrectAttemptLogged();
});

Given('User enters multiple incorrect verification codes', () => {
  verificationPage.enterMultipleIncorrectCodes();
});

Then('System allows retries without locking the user out', () => {
  verificationPage.verifyRetriesAllowed();
});

Given('User enters an incorrect verification code on different devices', () => {
  verificationPage.enterCodeOnDifferentDevices();
});

Then('Error message displays correctly on all devices', () => {
  verificationPage.verifyErrorMessageConsistency();
});

Given('High traffic condition occurs', () => {
  verificationPage.simulateHighTraffic();
});

When('User enters an incorrect verification code', () => {
  verificationPage.enterIncorrectVerificationCode();
});

Then('Error messages are displayed promptly without delay', () => {
  verificationPage.verifyPromptErrorMessage();
});

Given('User has made multiple incorrect verification code attempts', () => {
  verificationPage.enterMultipleIncorrectCodes();
});

Then('System prompts for alternative verification method after multiple failures', () => {
  verificationPage.verifyAlternativeMethodPrompt();
});

Given('User enters a verification code with special characters', () => {
  verificationPage.enterCodeWithSpecialCharacters();
});

Then('System rejects entries with special characters and displays a relevant error message', () => {
  verificationPage.verifySpecialCharacterRejection();
});

Given('User has customized error message settings', () => {
  verificationPage.applyCustomErrorSettings();
});

Then('Error messages reflect user preferences where applicable', () => {
  verificationPage.verifyCustomErrorMessages();
});

Given('User enters an incorrect verification code from different geographic locations', () => {
  verificationPage.enterCodeFromDifferentLocations();
});

Then('Error message displays consistently regardless of location', () => {
  verificationPage.verifyLocationConsistency();
});

Given('Network delay occurs', () => {
  verificationPage.simulateNetworkDelay();
});

When('User enters an incorrect verification code', () => {
  verificationPage.enterIncorrectVerificationCode();
});

Then('Error message is displayed without network-induced delays', () => {
  verificationPage.verifyNoNetworkDelay();
});

Given('User enters a verification code with incorrect length', () => {
  verificationPage.enterCodeWithIncorrectLength();
});

Then('System rejects codes of incorrect length and displays a relevant error message', () => {
  verificationPage.verifyLengthRejection();
});

Given('Multiple users enter incorrect verification codes concurrently', () => {
  verificationPage.enterCodesConcurrently();
});

Then('Each user's incorrect attempt is handled separately and accurately', () => {
  verificationPage.verifyConcurrentHandling();
});