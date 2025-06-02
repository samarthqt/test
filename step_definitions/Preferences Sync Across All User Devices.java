package com.cucumber.steps;

import com.page_objects.PreferencesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PreferencesSyncSteps extends PreferencesPage {

    @Given("a user account with preferences set")
    public void aUserAccountWithPreferencesSet() {
        setUserPreferences();
    }

    @Given("multiple devices registered to the user account")
    public void multipleDevicesRegisteredToTheUserAccount() {
        registerDevices();
    }

    @When("the user logs into Device 1 using user credentials")
    public void theUserLogsIntoDevice1UsingUserCredentials() {
        loginToDevice("Device1");
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Then("preferences on Device 1 are set to Dark Mode ON, Notifications OFF")
    public void preferencesOnDevice1AreSetToDarkModeOnNotificationsOff() {
        verifyPreferences("Device1", true, false);
    }

    @Given("Device 2 is registered to the user account")
    public void device2IsRegisteredToTheUserAccount() {
        registerDevice("Device2");
    }

    @When("the user logs into Device 2 using the same user credentials")
    public void theUserLogsIntoDevice2UsingTheSameUserCredentials() {
        loginToDevice("Device2");
    }

    @Then("preferences on Device 2 match those on Device 1: Dark Mode ON, Notifications OFF")
    public void preferencesOnDevice2MatchThoseOnDevice1() {
        verifyPreferences("Device2", true, false);
    }

    @Given("the user is logged into Device 1")
    public void theUserIsLoggedIntoDevice1() {
        verifyLogin("Device1");
    }

    @When("the user changes preference on Device 1 to Dark Mode OFF")
    public void theUserChangesPreferenceOnDevice1ToDarkModeOff() {
        changePreference("Device1", false);
    }

    @When("refreshes preferences on Device 2")
    public void refreshesPreferencesOnDevice2() {
        refreshPreferences("Device2");
    }

    @Then("preference changes are reflected on Device 2: Dark Mode OFF")
    public void preferenceChangesAreReflectedOnDevice2() {
        verifyPreferences("Device2", false, false);
    }

    @Given("the user is logged into Device 2")
    public void theUserIsLoggedIntoDevice2() {
        verifyLogin("Device2");
    }

    @When("the user changes notifications setting on Device 2 to ON")
    public void theUserChangesNotificationsSettingOnDevice2ToOn() {
        changeNotificationSetting("Device2", true);
    }

    @When("refreshes preferences on Device 1")
    public void refreshesPreferencesOnDevice1() {
        refreshPreferences("Device1");
    }

    @Then("preference changes are reflected on Device 1: Notifications ON")
    public void preferenceChangesAreReflectedOnDevice1() {
        verifyPreferences("Device1", false, true);
    }

    @When("the user logs out from Device 1")
    public void theUserLogsOutFromDevice1() {
        logoutDevice("Device1");
    }

    @When("logs back into Device 1")
    public void logsBackIntoDevice1() {
        loginToDevice("Device1");
    }

    @Then("the user is successfully logged in with updated preferences")
    public void theUserIsSuccessfullyLoggedInWithUpdatedPreferences() {
        verifyLoginSuccess();
    }

    @Then("preferences are consistent with last changes: Dark Mode OFF, Notifications ON")
    public void preferencesAreConsistentWithLastChanges() {
        verifyPreferences("Device1", false, true);
    }

    @When("the user logs out from Device 2")
    public void theUserLogsOutFromDevice2() {
        logoutDevice("Device2");
    }

    @When("logs back into Device 2")
    public void logsBackIntoDevice2() {
        loginToDevice("Device2");
    }

    @Then("preferences are consistent with last changes: Dark Mode OFF, Notifications ON")
    public void preferencesAreConsistentWithLastChangesOnDevice2() {
        verifyPreferences("Device2", false, true);
    }

    @Given("additional devices are registered to the user account")
    public void additionalDevicesAreRegisteredToTheUserAccount() {
        registerAdditionalDevices();
    }

    @When("the user repeats the preference change and sync process")
    public void theUserRepeatsThePreferenceChangeAndSyncProcess() {
        repeatPreferenceChangeAndSync();
    }

    @Then("preferences are consistently synced across all registered devices")
    public void preferencesAreConsistentlySyncedAcrossAllRegisteredDevices() {
        verifyAllDevicesPreferences();
    }
}