import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MobilePage from "../pages/mobilePage";

Given("the application is accessed via a mobile web browser", () => {
 MobilePage.accessViaMobileWeb();
});

Then("the web version should be fully responsive", () => {
 MobilePage.verifyResponsiveWebVersion();
});

Given("the user has an iOS device running iOS 12 or later", () => {
 MobilePage.verifyIOSDeviceSupport();
});

And("the user has an Android device running Android 8.0 or later", () => {
 MobilePage.verifyAndroidDeviceSupport();
});

Then("the dedicated apps should be supported on these devices", () => {
 MobilePage.verifyDedicatedAppSupport();
});

Given("the user accesses the app on a mobile device", () => {
 MobilePage.accessAppOnMobile();
});

Then("the app features should mirror those available on the desktop version", () => {
 MobilePage.verifyAppFeaturesMirrorDesktop();
});

Given("the user has installed the mobile app", () => {
 MobilePage.verifyAppInstallation();
});

When("a push notification is sent", () => {
 MobilePage.sendPushNotification();
});

Then("the notification should be received seamlessly", () => {
 MobilePage.verifyPushNotificationReception();
});

Given("the user searches for the app in the iOS App Store", () => {
 MobilePage.searchAppInIOSStore();
});

And("the user searches for the app in the Google Play Store", () => {
 MobilePage.searchAppInGooglePlayStore();
});

Then("the app should be available in both app stores", () => {
 MobilePage.verifyAppAvailabilityInStores();
});

Given("user testing is conducted on the mobile app", () => {
 MobilePage.conductUserTesting();
});

Then("the mobile experience should be validated as satisfactory", () => {
 MobilePage.validateMobileExperience();
});

Then("the navigation should be intuitive", () => {
 MobilePage.verifyIntuitiveNavigation();
});

Then("the app should support offline functionality", () => {
 MobilePage.verifyOfflineFunctionality();
});

Given("the app is listed in the app stores", () => {
 MobilePage.verifyAppListingInStores();
});

Then("updates should be regularly pushed to the app stores", () => {
 MobilePage.verifyRegularUpdates();
});