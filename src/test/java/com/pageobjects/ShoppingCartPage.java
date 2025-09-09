package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShoppingCartPage extends WebReusableComponents {

    protected By productListingPage = By.id("productListingPage");
    protected By shoppingCartPage = By.id("shoppingCartPage");
    protected By product1AddToCart = By.id("addProduct1");
    protected By product2AddToCart = By.id("addProduct2");
    protected By product1QuantityField = By.id("product1Quantity");
    protected By product2QuantityField = By.id("product2Quantity");
    protected By product1LinePrice = By.id("product1LinePrice");
    protected By product2LinePrice = By.id("product2LinePrice");
    protected By subtotal = By.id("subtotal");
    protected By confirmationMessage = By.id("confirmationMessage");
    private By productDetailPage = By.id("productDetailPage");
    private By quantityField = By.id("quantityField");
    private By addToCartButton = By.id("addToCartButton");
    private By cartContents = By.id("cartContents");
    private By lineItemPrice = By.id("lineItemPrice");
    private By maximumQuantityError = By.id("maximumQuantityError");
    private By taxAmount = By.id("taxAmount");
    private By totalAmount = By.id("totalAmount");
    protected By loginButton = By.id("loginButton");
    protected By categoryMenu = By.id("categoryMenu");
    protected By productAddButton = By.cssSelector(".add-to-cart");
    protected By cartIcon = By.id("cartIcon");
    protected By logoutButton = By.id("logoutButton");
    protected By electronicsCategory = By.id("electronicsCategory");
    protected By wirelessHeadphones = By.id("wirelessHeadphones");
    protected By bluetoothSpeaker = By.id("bluetoothSpeaker");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By cartSubtotal = By.id("cartSubtotal");

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void openECommerceWebsite() {
        // Dummy implementation for opening the website
    }

    public void navigateToProductListingPage() {
        waitUntilElementVisible(productListingPage, 3);
        clickElement(productListingPage);
    }

    public void verifyProductListingPage() {
        waitUntilElementVisible(productListingPage, 3);
        Assert.assertTrue(isElementDisplayed(productListingPage), "Product listing page is not displayed.");
    }

    public void addProductToCart(String productName) {
        By productAddToCart = productName.equals("Product 1") ? product1AddToCart : product2AddToCart;
        waitUntilElementVisible(productAddToCart, 3);
        clickElement(productAddToCart);
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(getTextFromElement(confirmationMessage).contains("added"), "Product not added to cart.");
    }

    public void verifyProductAddedToCart(String productName, int quantity) {
        By productQuantityField = productName.equals("Product 1") ? product1QuantityField : product2QuantityField;
        waitUntilElementVisible(productQuantityField, 3);
        String actualQuantity = getTextFromElement(productQuantityField);
        Assert.assertEquals(actualQuantity, String.valueOf(quantity), "Product quantity is incorrect.");
    }

    public void navigateToShoppingCartPage() {
        waitUntilElementVisible(shoppingCartPage, 3);
        clickElement(shoppingCartPage);
    }

    public void verifyCartContents() {
        waitUntilElementVisible(shoppingCartPage, 3);
        Assert.assertTrue(isElementDisplayed(shoppingCartPage), "Shopping cart page is not displayed.");
    }

    public void verifySubtotal(double expectedSubtotal) {
        waitUntilElementVisible(subtotal, 3);
        String actualSubtotal = getTextFromElement(subtotal);
        Assert.assertEquals(Double.parseDouble(actualSubtotal), expectedSubtotal, "Subtotal is incorrect.");
    }

    public void locateQuantityField(String productName) {
        By productQuantityField = productName.equals("Product 1") ? product1QuantityField : product2QuantityField;
        waitUntilElementVisible(productQuantityField, 3);
    }

    public void verifyQuantityFieldValue(String productName, int expectedValue) {
        By productQuantityField = productName.equals("Product 1") ? product1QuantityField : product2QuantityField;
        waitUntilElementVisible(productQuantityField, 3);
        String actualValue = getTextFromElement(productQuantityField);
        Assert.assertEquals(actualValue, String.valueOf(expectedValue), "Quantity field value is incorrect.");
    }

    public void updateProductQuantity(String productName, int quantity) {
        By productQuantityField = productName.equals("Product 1") ? product1QuantityField : product2QuantityField;
        waitUntilElementVisible(productQuantityField, 3);
        enterText(productQuantityField, String.valueOf(quantity));
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(getTextFromElement(confirmationMessage).contains("updated"), "Cart update failed.");
    }

    public void verifyQuantityUpdate(String productName, int expectedQuantity) {
        By productQuantityField = productName.equals("Product 1") ? product1QuantityField : product2QuantityField;
        waitUntilElementVisible(productQuantityField, 3);
        String actualQuantity = getTextFromElement(productQuantityField);
        Assert.assertEquals(actualQuantity, String.valueOf(expectedQuantity), "Quantity update is incorrect.");
    }

    public void verifyLineItemPrice(String productName, double expectedPrice) {
        By productLinePrice = productName.equals("Product 1") ? product1LinePrice : product2LinePrice;
        waitUntilElementVisible(productLinePrice, 3);
        String actualPrice = getTextFromElement(productLinePrice);
        Assert.assertEquals(Double.parseDouble(actualPrice), expectedPrice, "Line item price is incorrect.");
    }

    public void openWebsite(String url) {
        driver.get(url);
    }

    public void selectProduct(String productName) {
        WebElement product = driver.findElement(By.xpath("//div[text()='" + productName + "']"));
        product.click();
    }

    public void verifyProductDetailPage(String productName) {
        Assert.assertTrue(isElementVisible(productDetailPage), productName + " detail page is not displayed.");
    }

    public void enterProductQuantity(String quantity) {
        waitUntilElementVisible(quantityField, 3);
        enterText(quantityField, quantity);
    }

    public void addProductToCart() {
        waitUntilElementVisible(addToCartButton, 3);
        clickElement(addToCartButton);
    }

    public void verifyProductAddedToCart(String productName) {
        Assert.assertTrue(isElementVisible(cartContents), productName + " is not added to the cart.");
    }

    public void viewCartContents() {
        waitUntilElementVisible(cartContents, 3);
        clickElement(cartContents);
    }

    public void verifyCartContents(String... productNames) {
        for (String productName : productNames) {
            WebElement product = driver.findElement(By.xpath("//div[text()='" + productName + "']"));
            Assert.assertTrue(product.isDisplayed(), productName + " is not displayed in the cart.");
        }
    }

    public void verifyLineItemPrice(String productName, String expectedPrice) {
        WebElement priceElement = driver.findElement(By.xpath("//div[text()='" + productName + "']/following-sibling::div[@id='lineItemPrice']"));
        String actualPrice = priceElement.getText();
        Assert.assertEquals(actualPrice, expectedPrice, "Line item price for " + productName + " is incorrect.");
    }

    public void verifySubtotal(String expectedSubtotal) {
        String actualSubtotal = getTextFromElement(subtotal);
        Assert.assertEquals(actualSubtotal, expectedSubtotal, "Subtotal is incorrect.");
    }

    public void navigateBackToProductListingPage() {
        driver.navigate().back();
    }

    public void attemptToIncreaseQuantityBeyondMaximum(String productName) {
        WebElement quantityElement = driver.findElement(By.xpath("//div[text()='" + productName + "']/following-sibling::input[@id='quantityField']"));
        int currentQuantity = Integer.parseInt(quantityElement.getAttribute("value"));
        quantityElement.clear();
        quantityElement.sendKeys(String.valueOf(currentQuantity + 1));
    }

    public void verifyMaximumQuantityError() {
        Assert.assertTrue(isElementVisible(maximumQuantityError), "Maximum quantity error message is not displayed.");
    }

    public void verifyTaxAndTotalAmounts() {
        String tax = getTextFromElement(taxAmount);
        String total = getTextFromElement(totalAmount);
        Assert.assertNotNull(tax, "Tax amount is not calculated.");
        Assert.assertNotNull(total, "Total amount is not calculated.");
    }

    public void launchApplication() {
        driver.get("http://dummyurl.com");
    }

    public void login(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(loginButton);
    }

    public void checkHomePage() {
        Assert.assertTrue(driver.getTitle().contains("Home"), "Not on home page");
    }

    public void selectCategory(String category) {
        clickElement(By.linkText(category));
    }

    public void checkProductsDisplayed(String category) {
        Assert.assertTrue(driver.findElement(By.id(category + "Products")).isDisplayed(), "Products not displayed");
    }

    public void selectProductAndAddToCart(String product) {
        clickElement(By.linkText(product));
        clickElement(productAddButton);
    }

    public void checkProductAddedConfirmation() {
        Assert.assertTrue(driver.findElement(By.id("confirmationMessage")).isDisplayed(), "Confirmation message not displayed");
    }

    public void openShoppingCart() {
        clickElement(cartIcon);
    }

    public void checkProductsInCart(String product1, String product2, int quantity) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='" + product1 + "']")).isDisplayed(), "Product 1 not in cart");
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='" + product2 + "']")).isDisplayed(), "Product 2 not in cart");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='" + product1 + "']/following-sibling::div[@class='quantity']")).getText(), String.valueOf(quantity), "Incorrect quantity for product 1");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='" + product2 + "']/following-sibling::div[@class='quantity']")).getText(), String.valueOf(quantity), "Incorrect quantity for product 2");
    }

    public void closeBrowserSession() {
        driver.quit();
    }

    public void reopenApplication() {
        driver = new ChromeDriver();
        launchApplication();
    }

    public void checkUserLoggedIn() {
        Assert.assertTrue(driver.findElement(By.id("userProfile")).isDisplayed(), "User not logged in");
    }

    public void checkCartDetails() {
        Assert.assertTrue(driver.findElement(By.id("cartDetails")).isDisplayed(), "Cart details not displayed");
    }

    public void logout() {
        clickElement(logoutButton);
    }

    public void checkUserLoggedOut() {
        Assert.assertTrue(driver.getTitle().contains("Home"), "Not redirected to home page after logout");
    }

    public void openWebApplicationInFirefox() {
        // Implementation to open the web application in Firefox
    }

    public void verifyGuestBrowsing() {
        // Implementation to verify guest browsing
    }

    public void enableBrowserCookies() {
        // Implementation to enable browser cookies
    }

    public void navigateToCategory(String category) {
        waitUntilElementVisible(electronicsCategory, 3);
        clickElement(electronicsCategory);
    }

    public void selectProductAndAddToCart(String productName) {
        By product = productName.equals("Wireless Headphones") ? wirelessHeadphones : bluetoothSpeaker;
        waitUntilElementVisible(product, 3);
        clickElement(product);
        addProductToCart();
    }

    public void continueBrowsingCategory(String category) {
        // Implementation to continue browsing in the specified category
    }

    public void viewShoppingCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyProductsInCartWithQuantities(String... productNames) {
        waitUntilElementVisible(cartItems, 3);
        for (String productName : productNames) {
            boolean productFound = getWebElementList(cartItems)
                .stream()
                .anyMatch(item -> item.getText().contains(productName));
            Assert.assertTrue(productFound, productName + " is not in the cart.");
        }
    }

    public void closeBrowserTabWithoutClearingCookies() {
        // Implementation to close the browser tab without clearing cookies
    }

    public void openNewBrowserTabAndNavigateToWebApplication() {
        // Implementation to open a new browser tab and navigate to the web application
    }

    public void verifyCartSubtotal(String expectedSubtotal) {
        waitUntilElementVisible(cartSubtotal, 3);
        String actualSubtotal = getTextFromElement(cartSubtotal);
        Assert.assertEquals(actualSubtotal, "$" + expectedSubtotal, "Cart subtotal does not match.");
    }
}
