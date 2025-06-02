package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AppStorePage extends WebReusableComponents {

    protected By iosAppStoreIcon = By.id("iosAppStoreIcon");
    protected By googlePlayStoreIcon = By.id("googlePlayStoreIcon");
    protected By searchBox = By.id("searchBox");
    protected By searchResult = By.cssSelector(".search-result");
    protected By appDetailsPage = By.id("appDetailsPage");
    protected By downloadButton = By.id("downloadButton");
    protected By installButton = By.id("installButton");
    protected By initialSetupScreen = By.id("initialSetupScreen");

    public AppStorePage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyIOSAppStoreAccess() {
        Assert.assertTrue(isElementPresent(iosAppStoreIcon), "iOS App Store is not accessible.");
    }

    public void openIOSAppStore() {
        clickElement(iosAppStoreIcon);
    }

    public void verifyIOSAppStoreOpened() {
        Assert.assertTrue(isElementVisible(searchBox), "iOS App Store did not open successfully.");
    }

    public void searchApplication() {
        enterText(searchBox, "AppName");
        pressEnter(searchBox);
    }

    public void verifyApplicationInSearchResults() {
        Assert.assertTrue(isElementVisible(searchResult), "Application not found in search results.");
    }

    public void selectApplicationFromResults() {
        clickElement(searchResult);
    }

    public void verifyApplicationDetailsPage() {
        Assert.assertTrue(isElementVisible(appDetailsPage), "Application details page is not displayed.");
    }

    public void verifyDownloadButton() {
        Assert.assertTrue(isElementClickable(downloadButton), "Download button is not clickable.");
    }

    public void initiateDownload() {
        clickElement(downloadButton);
    }

    public void verifyDownloadStarted() {
        Assert.assertTrue(isElementVisible(installButton), "Download did not start successfully.");
    }

    public void verifyApplicationInstalled() {
        Assert.assertTrue(isElementVisible(initialSetupScreen), "Application is not accessible after installation.");
    }

    public void verifyGooglePlayStoreAccess() {
        Assert.assertTrue(isElementPresent(googlePlayStoreIcon), "Google Play Store is not accessible.");
    }

    public void openGooglePlayStore() {
        clickElement(googlePlayStoreIcon);
    }

    public void verifyGooglePlayStoreOpened() {
        Assert.assertTrue(isElementVisible(searchBox), "Google Play Store did not open successfully.");
    }

    public void verifyApplicationInstalledOnBothDevices() {
        Assert.assertTrue(isElementVisible(initialSetupScreen), "Application is not installed on both devices.");
    }

    public void openApplicationOnBothDevices() {
        clickElement(initialSetupScreen);
    }

    public void verifyApplicationLaunchOnBothDevices() {
        Assert.assertTrue(isElementVisible(initialSetupScreen), "Application did not launch successfully on both devices.");
    }

    public void verifyInitialSetupScreens() {
        Assert.assertTrue(isElementVisible(initialSetupScreen), "Initial setup screens are not displayed correctly.");
    }

    public void completeInitialSetupOnBothDevices() {
        clickElement(initialSetupScreen);
    }

    public void verifySetupCompletion() {
        Assert.assertTrue(isElementVisible(initialSetupScreen), "Setup did not complete successfully.");
    }
}