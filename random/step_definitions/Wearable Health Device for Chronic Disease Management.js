import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import WearableDevicePage from '../pageObjects/WearableDevicePage';

const wearableDevicePage = new WearableDevicePage();

Given('a wearable health device', () => {
  wearableDevicePage.verifyDevicePresence();
});

When('the device is tracking vital signs', () => {
  wearableDevicePage.startTrackingVitalSigns();
});

Then('it should accurately measure heart rate', () => {
  wearableDevicePage.verifyHeartRateMeasurement();
});

Then('it should accurately measure glucose levels', () => {
  wearableDevicePage.verifyGlucoseMeasurement();
});

When('a vital sign exceeds the threshold', () => {
  wearableDevicePage.exceedVitalSignThreshold();
});

Then('a real-time alert must be sent to the patient', () => {
  wearableDevicePage.verifyPatientAlert();
});

Then('a real-time alert must be sent to the healthcare provider', () => {
  wearableDevicePage.verifyProviderAlert();
});

When('the device is worn by a user', () => {
  wearableDevicePage.wearDevice();
});

Then('the device must be comfortable', () => {
  wearableDevicePage.verifyComfort();
});

Then('the device must be suitable for long-term wear', () => {
  wearableDevicePage.verifyLongTermSuitability();
});

When('sensitive health information is recorded', () => {
  wearableDevicePage.recordSensitiveInfo();
});

Then('data security protocols must be in place to protect it', () => {
  wearableDevicePage.verifyDataSecurity();
});

When('a user sets alert thresholds', () => {
  wearableDevicePage.setAlertThresholds();
});

Then('the system should allow customization of these thresholds', () => {
  wearableDevicePage.verifyThresholdCustomization();
});

When('data is recorded', () => {
  wearableDevicePage.recordData();
});

Then('it should be integrated with healthcare provider systems for data sharing', () => {
  wearableDevicePage.verifyDataIntegration();
});

When('disease management data is available', () => {
  wearableDevicePage.provideDiseaseData();
});

Then('the device must provide feedback on its effectiveness', () => {
  wearableDevicePage.verifyFeedbackEffectiveness();
});

When('the device is fully charged', () => {
  wearableDevicePage.chargeDevice();
});

Then('the battery life should support continuous monitoring for at least 24 hours', () => {
  wearableDevicePage.verifyBatteryLife();
});

When('the device is developed', () => {
  wearableDevicePage.developDevice();
});

Then('it must comply with medical device regulations and standards', () => {
  wearableDevicePage.verifyRegulatoryCompliance();
});