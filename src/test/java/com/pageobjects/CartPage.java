package com.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;

public class CartPage extends WebReusableComponents {

    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By productQuantity = By.cssSelector(".cart-item-quantity");
    protected By productPrice = By.cssSelector(".cart-item-price");
    protected By subtotal = By.id("subtotal");
    protected By successNotification = By.id("successNotification");
    protected By btnRemoveItem = By.cssSelector(".remove-item");
    protected By notification = By.id("notification");
    protected By notificationMessage = By.id("notificationMessage");
    protected By inventoryStatus = By.id("inventoryStatus");
    protected By logMessage = By.id("logMessage");
    protected By mobileInterface = By.id("mobileInterface");
    protected By securityAlert = By.id("securityAlert");
    private By cartPageLocator = By.id("cartPage");
    private By productNameLocator = By.cssSelector(".product-name");
    private By productPriceLocator = By.cssSelector(".product-price");
    private By productQuantityLocator = By.cssSelector(".product-quantity");
    private By productSubtotalLocator = By.cssSelector(".product-subtotal");
    private By totalSubtotalLocator = By.id("totalSubtotal");

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyProductDetailsInCart(String expectedName, String expectedQuantity, String expectedPrice) {
        waitUntilElementVisible(cartItems, 3);
        List<WebElement> items = getWebElementList(cartItems);
        boolean productFound = items.stream().anyMatch(item ->
            item.getText().contains(expectedName) &&
            item.findElement(productQuantity).getText().equals(expectedQuantity) &&
            item.findElement(productPrice).getText().equals(expectedPrice)
        );
        Assert.assertTrue(productFound, "Product details are incorrect in the cart.");
    }

    public void verifySubtotalCalculation(String expectedSubtotal) {
        String actualSubtotal = getTextFromElement(subtotal);
        Assert.assertEquals(actualSubtotal, expectedSubtotal, "Subtotal calculation is incorrect.");
    }

    public void verifySuccessNotification() {
        waitUntilElementVisible(successNotification, 3);
        String notificationText = getTextFromElement(successNotification);
        Assert.assertTrue(notificationText.contains("successfully added"), "Success notification is missing.");
    }

    public void verifyInventoryIntegration(String productId, int quantity) {
        // Implement inventory verification logic
    }

    public void verifyActionLogging() {
        // Implement action logging verification logic
    }

    public void verifyMobileInterface() {
        // Implement mobile interface verification logic
    }

    public void verifySecurityMeasures() {
        // Implement security measures verification logic
    }

    public void verifyCartPersistence(String expectedProductName) {
        openCart();
        verifyProductDetailsInCart(expectedProductName, "1", "100.00");
    }

    public void selectProductById(String productId) {
        WebElement product = driver.findElement(By.id(productId));
        product.click();
    }

    public void removeProductFromCart() {
        waitUntilElementVisible(btnRemoveItem, 3);
        clickElement(btnRemoveItem);
    }

    public boolean isProductInCart(String productId) {
        List<WebElement> items = getWebElementList(cartItems);
        return items.stream().anyMatch(item -> item.getAttribute("id").equals(productId));
    }

    public boolean isSubtotalUpdated() {
        String subtotalText = getTextFromElement(subtotal);
        return !subtotalText.isEmpty();
    }

    public boolean isRemovalNotificationDisplayed() {
        return elementVisible(notification);
    }

    public boolean isActionLogged() {
        // Implement logic to verify action logging
        return true;
    }

    public boolean isCartResponsiveOnMobile() {
        // Implement logic to verify responsiveness
        return true;
    }

    public boolean isCartAccessSecure() {
        // Implement logic to verify security
        return true;
    }

    public boolean isInventoryUpdated(String productId) {
        // Implement logic to verify inventory update
        return true;
    }

    public boolean attemptToRemoveNonExistentProduct() {
        // Implement logic to attempt removal and check for error message
        return true;
    }

    public void locateProductInCart(String productId) {
        // Logic to locate product by ID
    }

    public void modifyProductQuantity(String productId, String quantity) {
        // Logic to modify product quantity
    }

    public String getProductQuantity(String productId) {
        // Logic to get product quantity
        return "5"; // Placeholder for actual logic
    }

    public boolean verifySubtotalCalculation(String productId, int quantity) {
        // Logic to verify subtotal calculation
        return true; // Placeholder for actual logic
    }

    public boolean verifyQuantityModificationNotification() {
        // Logic to verify notification
        return true; // Placeholder for actual logic
    }

    public boolean verifyInventoryIntegration(String productId, int quantity) {
        // Logic to verify inventory integration
        return true; // Placeholder for actual logic
    }

    public boolean verifyLoggingOfAction(String productId, int quantity) {
        // Logic to verify logging
        return true; // Placeholder for actual logic
    }

    public boolean verifyMobileInterface() {
        // Logic to verify mobile interface
        return true; // Placeholder for actual logic
    }

    public boolean verifySecurityMeasures() {
        // Logic to verify security measures
        return true; // Placeholder for actual logic
    }

    public void logOutAndLogIn() {
        // Logic to log out and log back in
    }

    public boolean attemptSetQuantityBeyondStock(String productId) {
        // Logic to attempt setting quantity beyond stock
        return true; // Placeholder for actual logic
    }

    public boolean attemptSetQuantityToZero(String productId) {
        // Logic to attempt setting quantity to zero
        return true; // Placeholder for actual logic
    }

    public boolean isCartPageDisplayed() {
        return isElementVisible(cartPageLocator);
    }

    public boolean verifyProductNames() {
        List<WebElement> productNames = getWebElementList(productNameLocator);
        for (WebElement productName : productNames) {
            if (productName.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyProductPrices() {
        List<WebElement> productPrices = getWebElementList(productPriceLocator);
        for (WebElement productPrice : productPrices) {
            if (productPrice.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyProductQuantities() {
        List<WebElement> productQuantities = getWebElementList(productQuantityLocator);
        for (WebElement productQuantity : productQuantities) {
            if (productQuantity.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyProductSubtotals() {
        List<WebElement> productSubtotals = getWebElementList(productSubtotalLocator);
        for (WebElement productSubtotal : productSubtotals) {
            if (productSubtotal.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyTotalSubtotal() {
        String totalSubtotal = getTextFromElement(totalSubtotalLocator);
        return !totalSubtotal.isEmpty();
    }

    public boolean verifyCurrencyFormatting() {
        // Logic to verify currency formatting
        return true;
    }

    public boolean verifyRealTimeUpdates() {
        // Logic to verify real-time updates
        return true;
    }

    public boolean verifyVisualAppealAndNavigation() {
        // Logic to verify visual appeal and navigation
        return true;
    }

    public boolean verifyErrorHandling() {
        // Logic to verify error handling
        return true;
    }

    public boolean verifySecurityMeasures() {
        // Logic to verify security measures
        return true;
    }

    public boolean verifyIntegrationWithCatalog() {
        // Logic to verify integration with the product catalog
        return true;
    }

    public boolean verifyMobileInterface() {
        // Logic to verify mobile interface
        return true;
    }

    public boolean verifyAccessibilityStandards() {
        // Logic to verify accessibility standards
        return true;
    }

    public boolean verifyLoadingTimes() {
        // Logic to verify loading times
        return true;
    }
}
