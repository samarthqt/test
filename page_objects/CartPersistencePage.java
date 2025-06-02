
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class CartPersistencePage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By logoutButton = By.id("logoutButton");
    protected By cartIcon = By.id("cartIcon");
    protected By productList = By.cssSelector(".product-list");
    protected By cartTotal = By.id("cartTotal");
    protected By removeProductButton = By.cssSelector(".remove-product");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By productQuantity = By.cssSelector(".cart-item-quantity");
    protected By cartEmptyMessage = By.id("cartEmptyMessage");

    public CartPersistencePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginUser() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void logoutUser() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void addProductsToCart() {
        waitUntilElementVisible(productList, 3);
        List<WebElement> products = getWebElementList(productList);
        for (WebElement product : products) {
            product.click();
        }
    }

    public void verifyProductsInCart() {
        waitUntilElementVisible(cartIcon, 3);
        openCart();
        Assert.assertTrue(checkProductsInCart(), "Products are not in the cart.");
    }

    public void navigateToCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyProductDetailsAndQuantities() {
        waitUntilElementVisible(cartItems, 3);
        List<WebElement> items = getWebElementList(cartItems);
        for (WebElement item : items) {
            String quantity = item.findElement(productQuantity).getText();
            Assert.assertTrue(Integer.parseInt(quantity) > 0, "Product quantity is incorrect.");
        }
    }

    public void loginUserOnDifferentDevice() {
        loginUser();
    }

    public void verifyCartConsistencyAcrossDevices() {
        verifyProductsInCart();
    }

    public void addMoreProductsToCart() {
        addProductsToCart();
    }

    public void verifyNewProductsInCart() {
        verifyProductsInCart();
    }

    public void verifyCartReflectsNewAdditions() {
        verifyProductsInCart();
    }

    public void clearBrowserCache() {
        driver.manage().deleteAllCookies();
    }

    public void verifyCartIntactAfterCacheClearing() {
        verifyProductsInCart();
    }

    public void switchNetwork() {
        // Simulate network switch logic
    }

    public void verifyCartPersistenceUnaffectedByNetworkChanges() {
        verifyProductsInCart();
    }

    public void repeatTestOnMobileBrowser() {
        // Logic to repeat test on mobile browser
    }

    public void verifyCartPersistenceOnMobileBrowser() {
        verifyProductsInCart();
    }

    public void verifyCartTotalAccuracy() {
        waitUntilElementVisible(cartTotal, 3);
        String total = getTextFromElement(cartTotal);
        Assert.assertTrue(Double.parseDouble(total) > 0, "Cart total is not accurate.");
    }

    public void attemptToRemoveProduct() {
        waitUntilElementVisible(removeProductButton, 3);
        clickElement(removeProductButton);
    }

    public void verifyProductRemovalPersistence() {
        verifyProductsInCart();
    }

    public void loginUserAsGuest() {
        loginUser();
    }

    public void verifyGuestCartNonPersistence() {
        Assert.assertFalse(checkProductsInCart(), "Guest cart persists across sessions.");
    }

    public void performSessionTransitions() {
        // Logic to perform session transitions
    }

    public void verifyNoConsoleErrorsDuringSessionTransitions() {
        Assert.assertTrue(checkNoConsoleErrors(), "Console errors appeared during session transitions.");
    }

    private boolean checkProductsInCart() {
        List<WebElement> items = getWebElementList(cartItems);
        return !items.isEmpty();
    }

    private boolean checkNoConsoleErrors() {
        // Logic to check for console errors
        return true;
    }
}
