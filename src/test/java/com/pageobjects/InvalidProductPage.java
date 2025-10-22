package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class InvalidProductPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By productIDField = By.id("productID");
    protected By addToCartButton = By.id("addToCart");
    protected By errorMessage = By.id("errorMessage");

    public void loginToApplication() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void attemptToAddInvalidProduct(String productID) {
        waitUntilElementVisible(productIDField, 3);
        enterText(productIDField, productID);
        clickElement(addToCartButton);
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Product cannot be added.", "Error message not displayed correctly.");
    }
}