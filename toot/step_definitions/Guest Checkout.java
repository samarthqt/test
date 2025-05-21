import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class GuestCheckoutSteps {
    WebDriver driver;
    WebDriverWait wait;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    public GuestCheckoutSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.shoppingCartPage = new ShoppingCartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    public void givenIHaveItemsInMyShoppingCart() {
        shoppingCartPage.navigateToCart();
        Assert.assertTrue("Shopping cart is empty", shoppingCartPage.isCartNotEmpty());
    }

    public void whenIProceedToCheckout() {
        shoppingCartPage.clickProceedToCheckout();
    }

    public void andISelectTheOptionToCheckoutAsAGuest() {
        checkoutPage.selectGuestCheckoutOption();
    }

    public void andIEnterMyShippingAndPaymentInformation() {
        checkoutPage.enterShippingInformation("John Doe", "123 Main St", "City", "State", "12345");
        checkoutPage.enterPaymentInformation("4111111111111111", "12/23", "123");
    }

    public void andIReviewMyOrder() {
        checkoutPage.reviewOrder();
    }

    public void andIConfirmTheOrder() {
        checkoutPage.confirmOrder();
    }

    public void thenIShouldSeeAConfirmationMessage() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message")));
        Assert.assertTrue("Confirmation message not displayed", confirmationMessage.isDisplayed());
    }

    public void andIShouldReceiveAnOrderConfirmationEmail() {
        // Logic to verify email receipt
    }

    public void andIEnterInvalidPaymentInformation() {
        checkoutPage.enterPaymentInformation("1234567890123456", "12/23", "123");
    }

    public void thenIShouldSeeAnErrorMessageIndicatingPaymentFailure() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_error_message")));
        Assert.assertTrue("Payment error message not displayed", errorMessage.isDisplayed());
    }

    public void andILeaveTheShippingInformationBlank() {
        checkoutPage.enterShippingInformation("", "", "", "", "");
    }

    public void thenIShouldSeeAnErrorMessageIndicatingMissingShippingInformation() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping_error_message")));
        Assert.assertTrue("Shipping error message not displayed", errorMessage.isDisplayed());
    }

    public void andIEnterAnInvalidEmailFormat() {
        checkoutPage.enterEmail("invalid-email");
    }

    public void thenIShouldSeeAnErrorMessageIndicatingInvalidEmailFormat() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_error_message")));
        Assert.assertTrue("Email error message not displayed", errorMessage.isDisplayed());
    }

    public void andIChooseToCreateAnAccountWithTheProvidedInformation() {
        checkoutPage.chooseToCreateAccount();
    }

    public void andIShouldReceiveAnAccountCreationConfirmationEmail() {
        // Logic to verify account creation email receipt
    }
}