package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class InventoryPage extends WebReusableComponents {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    private By homePageLocator = By.id("homePage");
    private By productListingPageLocator = By.id("productListingPage");
    private By product1Locator = By.id("product1");
    private By productDetailPageLocator = By.id("productDetailPage");
    private By quantitySelectorLocator = By.id("quantitySelector");
    private By addToCartButtonLocator = By.id("addToCartButton");
    private By cartIconLocator = By.id("cartIcon");
    private By cartQuantityFieldLocator = By.id("cartQuantityField");
    private By confirmationMessageLocator = By.id("confirmationMessage");
    private By errorMessageLocator = By.id("errorMessage");

    public void openHomePage() {
        driver.get("http://ecommerce-website.com");
        waitUntilElementVisible(homePageLocator, 5);
    }

    public void navigateToProductListingPage() {
        clickElement(productListingPageLocator);
        waitUntilElementVisible(productListingPageLocator, 5);
    }

    public void verifyProductListingPage() {
        Assert.assertTrue(isElementVisible(productListingPageLocator), "Product listing page is not displayed.");
    }

    public void selectProduct1() {
        clickElement(product1Locator);
        waitUntilElementVisible(productDetailPageLocator, 5);
    }

    public void verifyProductDetailPage() {
        Assert.assertTrue(isElementVisible(productDetailPageLocator), "Product detail page is not displayed.");
    }

    public void locateQuantitySelector() {
        waitUntilElementVisible(quantitySelectorLocator, 5);
    }

    public void enterQuantity(String quantity) {
        WebElement quantityField = driver.findElement(quantitySelectorLocator);
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void verifyQuantityField(String expectedQuantity) {
        String actualQuantity = driver.findElement(quantitySelectorLocator).getAttribute("value");
        Assert.assertEquals(actualQuantity, expectedQuantity, "Quantity field does not display the expected value.");
    }

    public void addToCart() {
        clickElement(addToCartButtonLocator);
    }

    public void verifyProductAddedToCart(String expectedQuantity) {
        // Implement logic to verify product added to cart with expected quantity
    }

    public void verifyConfirmationMessage() {
        Assert.assertTrue(isElementVisible(confirmationMessageLocator), "Confirmation message is not displayed.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = driver.findElement(errorMessageLocator).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match expected.");
    }

    public void clickCartIcon() {
        clickElement(cartIconLocator);
    }

    public void verifyCartContents(String productName, String expectedQuantity) {
        // Implement logic to verify cart contents
    }

    public void locateCartQuantityField() {
        waitUntilElementVisible(cartQuantityFieldLocator, 5);
    }

    public void updateCartQuantity(String quantity) {
        WebElement quantityField = driver.findElement(cartQuantityFieldLocator);
        quantityField.clear();
        quantityField.sendKeys(quantity);
        // Implement logic to update cart
    }

    public void verifyCartQuantity(String expectedQuantity) {
        String actualQuantity = driver.findElement(cartQuantityFieldLocator).getAttribute("value");
        Assert.assertEquals(actualQuantity, expectedQuantity, "Cart quantity does not match expected.");
    }

    public void navigateToProductDetailPage() {
        driver.get("http://ecommerce-website.com/product1");
        waitUntilElementVisible(productDetailPageLocator, 5);
    }
}