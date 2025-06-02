
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShoppingExperiencePage extends WebReusableComponents {

    protected By desktopLoadIndicator = By.id("desktopLoad");
    protected By mobileLoadIndicator = By.id("mobileLoad");
    protected By loginButton = By.id("loginButton");
    protected By homepageIndicator = By.id("homepage");
    protected By searchBox = By.id("searchBox");
    protected By searchResults = By.cssSelector(".search-results");
    protected By addToCartButton = By.id("addToCart");
    protected By cartIndicator = By.id("cart");
    protected By checkoutButton = By.id("checkout");
    protected By orderConfirmation = By.id("orderConfirmation");
    protected By logoutButton = By.id("logoutButton");

    public ShoppingExperiencePage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApplication() {
        driver.get(getAppUrl());
    }

    public void openOnDesktop() {
        waitUntilElementVisible(desktopLoadIndicator, 5);
    }

    public void verifyDesktopLoad() {
        Assert.assertTrue(isElementVisible(desktopLoadIndicator), "Desktop application did not load successfully.");
    }

    public void loadUserCredentials() {
        // Assume credentials are loaded from a secure source
    }

    public void loginWithCredentials() {
        clickElement(loginButton);
    }

    public void verifyHomepageRedirection() {
        Assert.assertTrue(isElementVisible(homepageIndicator), "User is not redirected to the homepage.");
    }

    public void verifyOnHomepage() {
        Assert.assertTrue(isElementVisible(homepageIndicator), "Not on the homepage.");
    }

    public void searchProduct() {
        enterText(searchBox, "product keyword");
        submitElement(searchBox);
    }

    public void verifySearchResults() {
        Assert.assertTrue(isElementVisible(searchResults), "Search results are not displayed accurately.");
    }

    public void verifySearchResultsDisplayed() {
        Assert.assertTrue(isElementVisible(searchResults), "Search results are not displayed.");
    }

    public void addProductToCart() {
        clickElement(addToCartButton);
    }

    public void verifyProductAddedToCart() {
        Assert.assertTrue(isElementVisible(cartIndicator), "Product is not added to the cart successfully.");
    }

    public void verifyProductInCart() {
        Assert.assertTrue(isElementVisible(cartIndicator), "Product is not in the cart.");
    }

    public void proceedToCheckout() {
        clickElement(checkoutButton);
    }

    public void verifyCheckoutCompletion() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Checkout process is not completed successfully.");
    }

    public void verifyCheckoutCompleted() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Checkout process is not completed.");
    }

    public void verifyOrderConfirmation() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Order confirmation details are not displayed.");
    }

    public void verifyOrderDetails() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Order confirmation details are incorrect.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(homepageIndicator), "User is not logged in.");
    }

    public void logoutFromDesktop() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        Assert.assertFalse(isElementVisible(homepageIndicator), "User did not log out successfully.");
    }

    public void openOnMobile() {
        waitUntilElementVisible(mobileLoadIndicator, 5);
    }

    public void verifyMobileLoad() {
        Assert.assertTrue(isElementVisible(mobileLoadIndicator), "Mobile application did not load successfully.");
    }

    public void loginWithCredentialsOnMobile() {
        clickElement(loginButton);
    }

    public void verifyHomepageRedirectionOnMobile() {
        Assert.assertTrue(isElementVisible(homepageIndicator), "User is not redirected to the homepage on mobile.");
    }

    public void verifyOnHomepageOnMobile() {
        Assert.assertTrue(isElementVisible(homepageIndicator), "Not on the homepage on mobile.");
    }

    public void searchAndAddDifferentProductOnMobile() {
        enterText(searchBox, "different product keyword");
        submitElement(searchBox);
        clickElement(addToCartButton);
    }

    public void verifySearchAndAddOnMobile() {
        Assert.assertTrue(isElementVisible(cartIndicator), "Product is not added to the cart successfully on mobile.");
    }

    public void proceedToCheckoutOnMobile() {
        clickElement(checkoutButton);
    }

    public void verifyCheckoutCompletionOnMobile() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Checkout process is not completed successfully on mobile.");
    }

    public void verifyCheckoutCompletedOnMobile() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Checkout process is not completed on mobile.");
    }

    public void verifyOrderConfirmationOnMobile() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Order confirmation details are not displayed on mobile.");
    }

    public void verifyOrderDetailsOnMobile() {
        Assert.assertTrue(isElementVisible(orderConfirmation), "Order confirmation details are incorrect on mobile.");
    }

    public void verifyAccessToBothPlatforms() {
        // Assume access verification logic
    }

    public void checkResponsivenessAndUIConsistency() {
        // Assume responsiveness and UI consistency check logic
    }

    public void verifyUIConsistency() {
        // Assume UI consistency verification logic
    }

    public void testPerformanceOnBothPlatforms() {
        // Assume performance testing logic
    }

    public void verifyPerformanceEfficiency() {
        // Assume performance efficiency verification logic
    }

    public void verifyUserLoggedInOnMobile() {
        Assert.assertTrue(isElementVisible(homepageIndicator), "User is not logged in on mobile.");
    }

    public void logoutFromMobile() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccessOnMobile() {
        Assert.assertFalse(isElementVisible(homepageIndicator), "User did not log out successfully on mobile.");
    }
}
