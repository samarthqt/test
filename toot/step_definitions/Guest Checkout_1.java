import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class GuestCheckoutSteps {
    WebDriver driver;
    WebDriverWait wait;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    public GuestCheckoutSteps() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        shoppingCartPage = new ShoppingCartPage(driver, wait);
        checkoutPage = new CheckoutPage(driver, wait);
    }

    public void givenUserHasItemsInShoppingCart() {
        shoppingCartPage.navigateToCart();
        Assert.assertTrue("Cart is empty", shoppingCartPage.hasItems());
    }

    public void whenUserOptsToCheckoutAsGuest() {
        checkoutPage.selectGuestCheckout();
    }

    public void andUserProvidesValidShippingAndPaymentInformation() {
        checkoutPage.enterShippingInformation("John Doe", "123 Main St", "City", "State", "12345");
        checkoutPage.enterPaymentInformation("4111111111111111", "12/23", "123");
    }

    public void thenPurchaseShouldBeCompletedSuccessfully() {
        checkoutPage.completePurchase();
        Assert.assertTrue("Purchase not completed", checkoutPage.isPurchaseSuccessful());
    }

    public void andUserShouldReceiveConfirmationMessage() {
        Assert.assertTrue("Confirmation message not received", checkoutPage.isConfirmationMessageDisplayed());
    }

    public void givenUserHasEmptyShoppingCart() {
        shoppingCartPage.navigateToCart();
        Assert.assertFalse("Cart is not empty", shoppingCartPage.hasItems());
    }

    public void thenUserShouldNotBeAbleToProceedWithCheckout() {
        Assert.assertFalse("Checkout proceeded", checkoutPage.canProceedWithCheckout());
    }

    public void andUserShouldBePromptedToAddItemsToCart() {
        Assert.assertTrue("Prompt not displayed", checkoutPage.isAddItemsPromptDisplayed());
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}