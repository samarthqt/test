package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PromotionalBannersPage extends WebReusableComponents {

    protected By bannersContainer = By.id("bannersContainer");
    protected By salesInfo = By.cssSelector(".sales-info");
    protected By discountInfo = By.cssSelector(".discount-info");
    protected By bannerVisibility = By.cssSelector(".banner-visible");
    protected By bannerDesign = By.cssSelector(".banner-design");
    protected By bannerLink = By.cssSelector(".banner-link");
    protected By loadingError = By.cssSelector(".loading-error");

    public void waitForBannersToLoad() {
        waitUntilElementVisible(bannersContainer, 5);
    }

    public void verifySalesInformationDisplayed() {
        waitUntilElementVisible(salesInfo, 3);
        Assert.assertTrue(isElementDisplayed(salesInfo), "Sales information is not displayed.");
    }

    public void verifyDiscountInformationDisplayed() {
        waitUntilElementVisible(discountInfo, 3);
        Assert.assertTrue(isElementDisplayed(discountInfo), "Discount information is not displayed.");
    }

    public void verifyBannersVisibility() {
        waitUntilElementVisible(bannerVisibility, 3);
        Assert.assertTrue(isElementDisplayed(bannerVisibility), "Banners are not visible.");
    }

    public void verifyBannersDesign() {
        waitUntilElementVisible(bannerDesign, 3);
        Assert.assertTrue(isElementDisplayed(bannerDesign), "Banners design is not attractive.");
    }

    public void activateNewPromotion() {
        // Logic to activate new promotion
    }

    public void verifyBannersUpdate() {
        waitUntilElementVisible(bannersContainer, 3);
        Assert.assertTrue(isElementDisplayed(bannersContainer), "Banners did not update.");
    }

    public void clickPromotionalBanner() {
        waitUntilElementVisible(bannerLink, 3);
        clickElement(bannerLink);
    }

    public void verifyRedirectionToSalesPage() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("sales"), "User is not redirected to sales page.");
    }

    public void verifyNoLoadingErrors() {
        Assert.assertFalse(isElementDisplayed(loadingError), "There are loading errors.");
    }

    public void viewBannersOnDifferentDevices() {
        // Logic to view banners on different devices
    }

    public void verifyResponsiveDesign() {
        Assert.assertTrue(isElementDisplayed(bannersContainer), "Banners are not responsive.");
    }
}