
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class MobileCompatibilityPage extends WebReusableComponents {

    private final By appStoreSearchBox = By.id("appStoreSearch");
    private final By googlePlaySearchBox = By.id("googlePlaySearch");
    private final By pushNotificationButton = By.id("pushNotification");
    private final By mobileBrowserAccess = By.id("mobileBrowserAccess");
    private final By appOfflineAccess = By.id("appOfflineAccess");
    private final By appListingVerification = By.id("appListingVerification");
    private final By appUpdateVerification = By.id("appUpdateVerification");
    private final By iosCompatibilityCheck = By.id("iosCompatibilityCheck");
    private final By androidCompatibilityCheck = By.id("androidCompatibilityCheck");
    private final By webVersionResponsivenessCheck = By.id("webVersionResponsivenessCheck");
    private final By dedicatedAppSupportCheck = By.id("dedicatedAppSupportCheck");
    private final By intuitiveNavigationCheck = By.id("intuitiveNavigationCheck");
    private final By mobilePerformanceCheck = By.id("mobilePerformanceCheck");
    private final By appFeaturesCheck = By.id("appFeaturesCheck");
    private final By mobileExperienceValidation = By.id("mobileExperienceValidation");
    private final By mobileInstallationCheck = By.id("mobileInstallationCheck");
    private final By pushNotificationReceptionCheck = By.id("pushNotificationReceptionCheck");
    private final By appAvailabilityCheck = By.id("appAvailabilityCheck");
    private final By userTestingConduct = By.id("userTestingConduct");

    public MobileCompatibilityPage() {
        PageFactory.initElements(driver, this);
    }

    public void accessApplicationViaMobileBrowser() {
        waitUntilElementVisible(mobileBrowserAccess, 3);
        clickElement(mobileBrowserAccess);
        Assert.assertTrue(isElementDisplayed(mobileBrowserAccess), "Failed to access application via mobile browser.");
    }

    public void verifyWebVersionResponsiveness() {
        waitUntilElementVisible(webVersionResponsivenessCheck, 3);
        Assert.assertTrue(isElementDisplayed(webVersionResponsivenessCheck), "Web version is not responsive.");
    }

    public void verifyIOSDeviceCompatibility() {
        waitUntilElementVisible(iosCompatibilityCheck, 3);
        Assert.assertTrue(isElementDisplayed(iosCompatibilityCheck), "iOS device compatibility failed.");
    }

    public void verifyAndroidDeviceCompatibility() {
        waitUntilElementVisible(androidCompatibilityCheck, 3);
        Assert.assertTrue(isElementDisplayed(androidCompatibilityCheck), "Android device compatibility failed.");
    }

    public void verifyDedicatedAppSupport() {
        waitUntilElementVisible(dedicatedAppSupportCheck, 3);
        Assert.assertTrue(isElementDisplayed(dedicatedAppSupportCheck), "Dedicated app support verification failed.");
    }

    public void accessAppOnMobileDevice() {
        waitUntilElementVisible(mobileBrowserAccess, 3);
        clickElement(mobileBrowserAccess);
        Assert.assertTrue(isElementDisplayed(mobileBrowserAccess), "Failed to access app on mobile device.");
    }

    public void verifyAppFeaturesMirrorDesktop() {
        waitUntilElementVisible(appFeaturesCheck, 3);
        Assert.assertTrue(isElementDisplayed(appFeaturesCheck), "App features do not mirror desktop.");
    }

    public void verifyMobileAppInstallation() {
        waitUntilElementVisible(mobileInstallationCheck, 3);
        Assert.assertTrue(isElementDisplayed(mobileInstallationCheck), "Mobile app installation verification failed.");
    }

    public void sendPushNotification() {
        waitUntilElementVisible(pushNotificationButton, 3);
        clickElement(pushNotificationButton);
        Assert.assertTrue(isElementDisplayed(pushNotificationButton), "Failed to send push notification.");
    }

    public void verifyPushNotificationReception() {
        waitUntilElementVisible(pushNotificationReceptionCheck, 3);
        Assert.assertTrue(isElementDisplayed(pushNotificationReceptionCheck), "Push notification reception failed.");
    }

    public void searchAppInIOSAppStore() {
        waitUntilElementVisible(appStoreSearchBox, 3);
        enterText(appStoreSearchBox, "AppName");
        Assert.assertTrue(isElementDisplayed(appStoreSearchBox), "Failed to search app in iOS App Store.");
    }

    public void searchAppInGooglePlayStore() {
        waitUntilElementVisible(googlePlaySearchBox, 3);
        enterText(googlePlaySearchBox, "AppName");
        Assert.assertTrue(isElementDisplayed(googlePlaySearchBox), "Failed to search app in Google Play Store.");
    }

    public void verifyAppAvailabilityInStores() {
        waitUntilElementVisible(appAvailabilityCheck, 3);
        Assert.assertTrue(isElementDisplayed(appAvailabilityCheck), "App is not available in stores.");
    }

    public void verifyMobilePerformanceMatchesDesktop() {
        waitUntilElementVisible(mobilePerformanceCheck, 3);
        Assert.assertTrue(isElementDisplayed(mobilePerformanceCheck), "Mobile performance does not match desktop.");
    }

    public void conductUserTestingOnMobileApp() {
        waitUntilElementVisible(userTestingConduct, 3);
        Assert.assertTrue(isElementDisplayed(userTestingConduct), "User testing on mobile app failed.");
    }

    public void validateMobileExperience() {
        waitUntilElementVisible(mobileExperienceValidation, 3);
        Assert.assertTrue(isElementDisplayed(mobileExperienceValidation), "Mobile experience validation failed.");
    }

    public void verifyIntuitiveNavigation() {
        waitUntilElementVisible(intuitiveNavigationCheck, 3);
        Assert.assertTrue(isElementDisplayed(intuitiveNavigationCheck), "Intuitive navigation verification failed.");
    }

    public void accessAppOffline() {
        waitUntilElementVisible(appOfflineAccess, 3);
        clickElement(appOfflineAccess);
        Assert.assertTrue(isElementDisplayed(appOfflineAccess), "Failed to access app offline.");
    }

    public void verifyOfflineFunctionalitySupport() {
        waitUntilElementVisible(appOfflineAccess, 3);
        Assert.assertTrue(isElementDisplayed(appOfflineAccess), "Offline functionality support verification failed.");
    }

    public void verifyAppListingInStores() {
        waitUntilElementVisible(appListingVerification, 3);
        Assert.assertTrue(isElementDisplayed(appListingVerification), "App listing in stores verification failed.");
    }

    public void verifyRegularUpdatesToAppStores() {
        waitUntilElementVisible(appUpdateVerification, 3);
        Assert.assertTrue(isElementDisplayed(appUpdateVerification), "Regular updates to app stores verification failed.");
    }
}
