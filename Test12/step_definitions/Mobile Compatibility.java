package com.cucumber.steps;

import com.page_objects.MobileCompatibilityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileCompatibilitySteps extends MobileCompatibilityPage {

    @Given("the application is accessed via a mobile web browser")
    public void theApplicationIsAccessedViaAMobileWebBrowser() {
        accessApplicationViaMobileBrowser();
    }

    @Then("the web version should be fully responsive")
    public void theWebVersionShouldBeFullyResponsive() {
        verifyWebVersionResponsiveness();
    }

    @Given("the user has an iOS device running iOS 12 or later")
    public void theUserHasAnIOSDeviceRunningIOS12OrLater() {
        verifyIOSDeviceCompatibility();
    }

    @Given("the user has an Android device running Android 8.0 or later")
    public void theUserHasAnAndroidDeviceRunningAndroid80OrLater() {
        verifyAndroidDeviceCompatibility();
    }

    @Then("the dedicated apps should be supported on these devices")
    public void theDedicatedAppsShouldBeSupportedOnTheseDevices() {
        verifyDedicatedAppSupport();
    }

    @Given("the user accesses the app on a mobile device")
    public void theUserAccessesTheAppOnAMobileDevice() {
        accessAppOnMobileDevice();
    }

    @Then("the app features should mirror those available on the desktop version")
    public void theAppFeaturesShouldMirrorThoseAvailableOnTheDesktopVersion() {
        verifyAppFeaturesMirrorDesktop();
    }

    @Given("the user has installed the mobile app")
    public void theUserHasInstalledTheMobileApp() {
        verifyMobileAppInstallation();
    }

    @When("a push notification is sent")
    public void aPushNotificationIsSent() {
        sendPushNotification();
    }

    @Then("the notification should be received seamlessly")
    public void theNotificationShouldBeReceivedSeamlessly() {
        verifyPushNotificationReception();
    }

    @Given("the user searches for the app in the iOS App Store")
    public void theUserSearchesForTheAppInTheIOSAppStore() {
        searchAppInIOSAppStore();
    }

    @Given("the user searches for the app in the Google Play Store")
    public void theUserSearchesForTheAppInTheGooglePlayStore() {
        searchAppInGooglePlayStore();
    }

    @Then("the app should be available in both app stores")
    public void theAppShouldBeAvailableInBothAppStores() {
        verifyAppAvailabilityInStores();
    }

    @Then("the performance should match that of the desktop version")
    public void thePerformanceShouldMatchThatOfTheDesktopVersion() {
        verifyMobilePerformanceMatchesDesktop();
    }

    @Given("user testing is conducted on the mobile app")
    public void userTestingIsConductedOnTheMobileApp() {
        conductUserTestingOnMobileApp();
    }

    @Then("the mobile experience should be validated as satisfactory")
    public void theMobileExperienceShouldBeValidatedAsSatisfactory() {
        validateMobileExperience();
    }

    @Then("the navigation should be intuitive")
    public void theNavigationShouldBeIntuitive() {
        verifyIntuitiveNavigation();
    }

    @Given("the user accesses the app without an internet connection")
    public void theUserAccessesTheAppWithoutAnInternetConnection() {
        accessAppOffline();
    }

    @Then("the app should support offline functionality")
    public void theAppShouldSupportOfflineFunctionality() {
        verifyOfflineFunctionalitySupport();
    }

    @Given("the app is listed in the app stores")
    public void theAppIsListedInTheAppStores() {
        verifyAppListingInStores();
    }

    @Then("updates should be regularly pushed to the app stores")
    public void updatesShouldBeRegularlyPushedToTheAppStores() {
        verifyRegularUpdatesToAppStores();
    }
}