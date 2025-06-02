import { expect } from 'chai';
import 'cypress';

class PreferencesPage {

 static ensureUserAccountWithPreferences() {
 cy.request('POST', '/api/user/preferences', { darkMode: true, notifications: false });
 }

 static ensureMultipleDevicesRegistered() {
 cy.request('POST', '/api/user/devices', { devices: [1, 2] });
 }

 static ensureAdditionalDevicesRegistered() {
 cy.request('POST', '/api/user/devices', { additionalDevices: [3, 4, 5] });
 }

 static ensureDeviceRegistered(deviceId) {
 cy.request('POST', '/api/user/devices', { deviceId: deviceId });
 }

 static loginToDevice(deviceId) {
 cy.visit(`/login/device/${deviceId}`);
 cy.get('#username').type('testuser');
 cy.get('#password').type('password');
 cy.get('#loginBtn').click();
 }

 static ensureLoggedIn(deviceId) {
 this.loginToDevice(deviceId);
 this.verifySuccessfulLogin();
 }

 static verifySuccessfulLogin() {
 cy.url().should('include', '/dashboard');
 }

 static verifyPreferences(preferences, deviceId) {
 cy.request(`/api/device/${deviceId}/preferences`).then((response) => {
 expect(response.body.darkMode).to.eq(preferences.darkMode);
 expect(response.body.notifications).to.eq(preferences.notifications);
 });
 }

 static changePreference(preferences, deviceId) {
 cy.request('PUT', `/api/device/${deviceId}/preferences`, preferences);
 }

 static refreshPreferences(deviceId) {
 cy.request('GET', `/api/device/${deviceId}/preferences/refresh`);
 }

 static verifyUpdatedPreferences(deviceId) {
 cy.request(`/api/device/${deviceId}/preferences`).then((response) => {
 expect(response.body.darkMode).to.eq(false);
 expect(response.body.notifications).to.eq(true);
 });
 }

 static logout(deviceId) {
 cy.visit(`/logout/device/${deviceId}`);
 }

 static repeatPreferenceChangeAndSync() {
 // Implementation of repeating the preference change and sync process
 }

 static verifyConsistentPreferencesAcrossDevices() {
 cy.request('/api/user/devices/preferences').then((response) => {
 response.body.devices.forEach(device => {
 expect(device.preferences.darkMode).to.eq(false);
 expect(device.preferences.notifications).to.eq(true);
 });
 });
 }
}

export default PreferencesPage;