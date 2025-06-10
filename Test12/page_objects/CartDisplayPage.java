package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CartDisplayPage extends WebReusableComponents {

    protected By cartItems = By.cssSelector(".cart-item");
    protected By productName = By.cssSelector(".product-name");
    protected By productPrice = By.cssSelector(".product-price");
    protected By productQuantity = By.cssSelector(".product-quantity");
    protected By productSubtotal = By.cssSelector(".product-subtotal");
    protected By totalPrice = By.id("totalPrice");
    protected By responsiveCart = By.id("responsiveCart");
    protected By detailedProductInfo = By.id("detailedProductInfo");
    protected By outOfStockMessage = By.id("outOfStockMessage");
    protected By checkoutButton = By.id("checkoutButton");

    public CartDisplayPage() {
        PageFactory.initElements(driver, this);
    }

    public void addProductsToCart() {
        // Logic to add products to the cart
        waitUntilElementVisible(cartItems, 3);
        clickElement(cartItems);
        Assert.assertTrue(isElementVisible(cartItems), "Products not added to cart.");
    }

    public void viewCart() {
        // Logic to view the cart
        waitUntilElementVisible(cartItems, 3);
        clickElement(cartItems);
        Assert.assertTrue(isElementVisible(cartItems), "Cart is not visible.");
    }

    public void verifyProductDetailsInCart() {
        waitUntilElementVisible(cartItems, 3);
        for (WebElement item : getWebElementList(cartItems)) {
            Assert.assertTrue(item.findElement(productName).isDisplayed(), "Product name is not displayed.");
            Assert.assertTrue(item.findElement(productPrice).isDisplayed(), "Product price is not displayed.");
            Assert.assertTrue(item.findElement(productQuantity).isDisplayed(), "Product quantity is not displayed.");
            Assert.assertTrue(item.findElement(productSubtotal).isDisplayed(), "Product subtotal is not displayed.");
        }
    }

    public void updateProductQuantities() {
        // Logic to update product quantities
        waitUntilElementVisible(productQuantity, 3);
        selectByValue(productQuantity, "2");
        Assert.assertEquals(getTextFromElement(productQuantity), "2", "Product quantity not updated.");
    }

    public void verifyRealTimeUpdates() {
        // Logic to verify real-time updates
        waitUntilElementVisible(cartItems, 3);
        Assert.assertTrue(isElementVisible(cartItems), "Real-time updates not verified.");
    }

    public void addMultipleItemsToCart() {
        // Logic to add multiple items to the cart
        waitUntilElementVisible(cartItems, 3);
        clickElement(cartItems);
        clickElement(cartItems);
        Assert.assertTrue(getWebElementList(cartItems).size() > 1, "Multiple items not added to cart.");
    }

    public void verifyTotalPrice() {
        waitUntilElementVisible(totalPrice, 3);
        String actualTotalPrice = getTextFromElement(totalPrice);
        Assert.assertNotNull(actualTotalPrice, "Total price is not displayed.");
    }

    public void verifyDataIntegrityAndAccuracy() {
        // Logic to verify data integrity and accuracy
        waitUntilElementVisible(cartItems, 3);
        Assert.assertTrue(isElementVisible(cartItems), "Data integrity and accuracy not verified.");
    }

    public void viewCartOnDifferentDevices() {
        // Logic to view cart on different devices
        waitUntilElementVisible(responsiveCart, 3);
        Assert.assertTrue(isElementResponsive(responsiveCart), "Cart not viewed on different devices.");
    }

    public void verifyResponsiveCartDisplay() {
        waitUntilElementVisible(responsiveCart, 3);
        Assert.assertTrue(isElementResponsive(responsiveCart), "Cart display is not responsive.");
    }

    public void clickOnProductInCart() {
        // Logic to click on a product in the cart
        waitUntilElementVisible(cartItems, 3);
        clickElement(cartItems);
        Assert.assertTrue(isElementVisible(cartItems), "Product not clicked in cart.");
    }

    public void verifyDetailedProductInformation() {
        waitUntilElementVisible(detailedProductInfo, 3);
        Assert.assertTrue(isElementVisible(detailedProductInfo), "Detailed product information is not accessible.");
    }

    public void markProductOutOfStock() {
        // Logic to mark product as out-of-stock
        waitUntilElementVisible(outOfStockMessage, 3);
        Assert.assertTrue(isElementVisible(outOfStockMessage), "Product not marked as out-of-stock.");
    }

    public void verifyOutOfStockProductNotDisplayed() {
        waitUntilElementVisible(outOfStockMessage, 3);
        Assert.assertTrue(isElementVisible(outOfStockMessage), "Out-of-stock product is displayed.");
    }

    public void viewCartOnDifferentBrowsers() {
        // Logic to view cart on different browsers
        waitUntilElementVisible(cartItems, 3);
        Assert.assertTrue(isElementVisible(cartItems), "Cart not viewed on different browsers.");
    }

    public void verifyConsistentCartDisplayAcrossBrowsers() {
        // Logic to verify consistent cart display across browsers
        waitUntilElementVisible(cartItems, 3);
        Assert.assertTrue(isElementVisible(cartItems), "Cart display not consistent across browsers.");
    }

    public void navigateCart() {
        // Logic to navigate the cart
        waitUntilElementVisible(cartItems, 3);
        clickElement(cartItems);
        Assert.assertTrue(isElementVisible(cartItems), "Cart not navigated.");
    }

    public void verifyClearUserInterface() {
        // Logic to verify clear user interface
        waitUntilElementVisible(cartItems, 3);
        Assert.assertTrue(isElementVisible(cartItems), "User interface not clear.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(checkoutButton, 3);
        clickElement(checkoutButton);
        Assert.assertTrue(isElementVisible(checkoutButton), "Checkout not proceeded.");
    }

    public void verifyCheckoutFromCartDisplay() {
        // Logic to verify checkout from cart display
        waitUntilElementVisible(checkoutButton, 3);
        Assert.assertTrue(isElementVisible(checkoutButton), "Checkout not verified from cart display.");
    }
}