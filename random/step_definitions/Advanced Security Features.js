import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import BiometricPage from '../page_objects/BiometricPage';
import FraudDetectionPage from '../page_objects/FraudDetectionPage';

const biometricPage = new BiometricPage();
const fraudDetectionPage = new FraudDetectionPage();

Given('the user has registered biometric data', () => {
  biometricPage.registerBiometricData();
});

When('the user attempts to log in using fingerprint or face ID', () => {
  biometricPage.loginWithBiometric();
});

Then('the user should be successfully logged in', () => {
  biometricPage.verifyLoginSuccess();
});

Given('the user is logged in', () => {
  fraudDetectionPage.verifyUserLoggedIn();
});

When('suspicious activity is detected', () => {
  fraudDetectionPage.detectSuspiciousActivity();
});

Then('the system should alert the user within 1 minute', () => {
  fraudDetectionPage.verifyAlertWithinOneMinute();
});

Given('the user has been alerted of suspicious activity', () => {
  fraudDetectionPage.userAlertedOfSuspiciousActivity();
});

When('the user chooses to freeze their account', () => {
  fraudDetectionPage.freezeAccount();
});

Then('the account should be automatically frozen', () => {
  fraudDetectionPage.verifyAccountFrozen();
});

Given('the user has provided biometric data', () => {
  biometricPage.provideBiometricData();
});

Then('the biometric data should be stored securely', () => {
  biometricPage.verifyBiometricDataStorage();
});

Then('the storage should comply with data protection regulations', () => {
  biometricPage.verifyDataProtectionCompliance();
});

When('the alert is sent', () => {
  fraudDetectionPage.sendAlert();
});

Then('the user should receive an email with details of the suspicious activity', () => {
  fraudDetectionPage.verifyEmailReceived();
});

Then('the user should receive an SMS with details of the suspicious activity', () => {
  fraudDetectionPage.verifySMSReceived();
});