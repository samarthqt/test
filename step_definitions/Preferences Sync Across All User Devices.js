import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PreferencesPage from "../pages/preferencesPage";

Given("a user account with preferences set", () => {
 PreferencesPage.ensureUserAccountWithPreferences();
});

Given("multiple devices registered to the user account", () => {
 PreferencesPage.ensureMultipleDevicesRegistered();
});

When("the user logs into Device 1 using user credentials", () => {
 PreferencesPage.loginToDevice(1);
});

Then("the user is successfully logged in", () => {
 PreferencesPage.verifySuccessfulLogin();
});

Then("preferences on Device 1 are set to Dark Mode ON, Notifications OFF", () => {
 PreferencesPage.verifyPreferences({ darkMode: true, notifications: false }, 1);
});

Given("Device 2 is registered to the user account", () => {
 PreferencesPage.ensureDeviceRegistered(2);
});

When("the user logs into Device 2 using the same user credentials", () => {
 PreferencesPage.loginToDevice(2);
});

Then("preferences on Device 2 match those on Device 1: Dark Mode ON, Notifications OFF", () => {
 PreferencesPage.verifyPreferences({ darkMode: true, notifications: false }, 2);
});

Given("the user is logged into Device 1", () => {
 PreferencesPage.ensureLoggedIn(1);
});

When("the user changes preference on Device 1 to Dark Mode OFF", () => {
 PreferencesPage.changePreference({ darkMode: false }, 1);
});

When("refreshes preferences on Device 2", () => {
 PreferencesPage.refreshPreferences(2);
});

Then("preference changes are reflected on Device 2: Dark Mode OFF", () => {
 PreferencesPage.verifyPreferences({ darkMode: false }, 2);
});

Given("the user is logged into Device 2", () => {
 PreferencesPage.ensureLoggedIn(2);
});

When("the user changes notifications setting on Device 2 to ON", () => {
 PreferencesPage.changePreference({ notifications: true }, 2);
});

When("refreshes preferences on Device 1", () => {
 PreferencesPage.refreshPreferences(1);
});

Then("preference changes are reflected on Device 1: Notifications ON", () => {
 PreferencesPage.verifyPreferences({ notifications: true }, 1);
});

When("the user logs out from Device 1", () => {
 PreferencesPage.logout(1);
});

When("logs back into Device 1", () => {
 PreferencesPage.loginToDevice(1);
});

Then("the user is successfully logged in with updated preferences", () => {
 PreferencesPage.verifySuccessfulLogin();
 PreferencesPage.verifyUpdatedPreferences(1);
});

Then("preferences are consistent with last changes: Dark Mode OFF, Notifications ON", () => {
 PreferencesPage.verifyPreferences({ darkMode: false, notifications: true }, 1);
});

When("the user logs out from Device 2", () => {
 PreferencesPage.logout(2);
});

When("logs back into Device 2", () => {
 PreferencesPage.loginToDevice(2);
});

Then("preferences are consistent with last changes: Dark Mode OFF, Notifications ON", () => {
 PreferencesPage.verifyPreferences({ darkMode: false, notifications: true }, 2);
});

Given("additional devices are registered to the user account", () => {
 PreferencesPage.ensureAdditionalDevicesRegistered();
});

When("the user repeats the preference change and sync process", () => {
 PreferencesPage.repeatPreferenceChangeAndSync();
});

Then("preferences are consistently synced across all registered devices", () => {
 PreferencesPage.verifyConsistentPreferencesAcrossDevices();
});