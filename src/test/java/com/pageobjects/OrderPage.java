package src.test.java.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class OrderPage extends WebReusableComponents {

    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By thankYouPage = By.id("thankYouPage");
    protected By orderConfirmationDetails = By.id("orderConfirmationDetails");

    public OrderPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToProductPage(String productName) {
        // Logic to navigate to product page
        // Assuming a method to find and click on the product link
        WebElement productLink = driver.findElement(By.linkText(productName));
        productLink.click();
    }

    public void addProductToCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyProductInCart(String expectedProductName) {
        waitUntilElementVisible(cartItems, 3);
        boolean productFound = getWebElementList(cartItems)
            .stream()
            .anyMatch(item -> item.getText().contains(expectedProductName));
        Assert.assertTrue(productFound, "Product is not in the cart.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyThankYouPage() {
        waitUntilElementVisible(thankYouPage, 3);
        Assert.assertTrue(isElementDisplayed(thankYouPage), "Thank You page is not displayed.");
    }

    public void verifyOrderConfirmationDetails() {
        waitUntilElementVisible(orderConfirmationDetails, 3);
        String actualDetails = getTextFromElement(orderConfirmationDetails);
        Assert.assertTrue(actualDetails.contains("Order confirmed"), "Order confirmation details are incorrect.");
    }
}