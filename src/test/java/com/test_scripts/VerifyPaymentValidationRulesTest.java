package com.cucumber.test_scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.page_objects.CheckoutPage;
import org.testng.Assert;

public class VerifyPaymentValidationRulesTest {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://example.com/shopping-cart");
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void testPaymentValidationRules() {
        checkoutPage.proceedToCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("payment-options"), "User is not redirected to payment options page.");

        checkoutPage.selectPaymentMethod("Credit Card");
        Assert.assertTrue(checkoutPage.isCreditCardOptionSelected(), "Credit card option is not selected.");

        checkoutPage.enterCreditCardDetails("1234567890123456", "12/23", "123");
        checkoutPage.clickPayNow();

        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid payment details.");
        Assert.assertFalse(checkoutPage.canProceedWithPayment(), "User can proceed with payment despite invalid details.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}