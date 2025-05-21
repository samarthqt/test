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

    public void givenTheOnlineStoreIsOpen() {
        driver.get("http://example.com");
    }

    public void givenTheUserIsOnTheShoppingCartPageWithItemsAdded() {
        shoppingCartPage.navigateToShoppingCart();
        Assert.assertTrue("Shopping cart is empty", shoppingCartPage.isCartNotEmpty());
    }

    public void givenTheUserOptsForGuestCheckout() {
        shoppingCartPage.clickGuestCheckout();
    }

    public void whenTheUserEntersValidShippingInformation() {
        checkoutPage.enterShippingInformation("John Doe", "123 Main St", "City", "State", "12345");
    }

    public void whenTheUserEntersInvalidShippingInformation() {
        checkoutPage.enterShippingInformation("", "", "", "", "");
    }

    public void whenTheUserEntersValidPaymentInformation() {
        checkoutPage.enterPaymentInformation("4111111111111111", "12/23", "123");
    }

    public void whenTheUserEntersInvalidPaymentInformation() {
        checkoutPage.enterPaymentInformation("", "", "");
    }

    public void whenTheUserLeavesMandatoryFieldsEmpty() {
        checkoutPage.leaveMandatoryFieldsEmpty();
    }

    public void whenTheUserFillsInOnlyTheMandatoryFields() {
        checkoutPage.fillMandatoryFieldsOnly();
    }

    public void whenTheUserEntersAValidPromotionalCode() {
        checkoutPage.enterPromotionalCode("VALIDCODE");
    }

    public void whenTheUserEntersAnExpiredPromotionalCode() {
        checkoutPage.enterPromotionalCode("EXPIREDCODE");
    }

    public void whenTheUserReviewsTheOrderSummary() {
        checkoutPage.reviewOrderSummary();
    }

    public void thenTheUserShouldBeAbleToPlaceTheOrderSuccessfully() {
        Assert.assertTrue("Order not placed successfully", checkoutPage.isOrderPlacedSuccessfully());
    }

    public void thenTheUserReceivesAnOrderConfirmationWithDetails() {
        Assert.assertTrue("Order confirmation not received", checkoutPage.isOrderConfirmationReceived());
    }

    public void thenTheUserShouldSeeAnErrorMessageForInvalidShippingDetails() {
        Assert.assertTrue("Error message not displayed", checkoutPage.isShippingErrorMessageDisplayed());
    }

    public void thenTheUserShouldNotBeAbleToProceedToPayment() {
        Assert.assertFalse("User can proceed to payment", checkoutPage.canProceedToPayment());
    }

    public void thenTheUserShouldSeeAnErrorMessageForInvalidPaymentDetails() {
        Assert.assertTrue("Error message not displayed", checkoutPage.isPaymentErrorMessageDisplayed());
    }

    public void thenTheUserShouldNotBeAbleToPlaceTheOrder() {
        Assert.assertFalse("Order placed", checkoutPage.isOrderPlacedSuccessfully());
    }

    public void thenTheUserShouldSeeAnErrorMessageIndicatingTheRequiredFields() {
        Assert.assertTrue("Error message not displayed", checkoutPage.isMandatoryFieldsErrorMessageDisplayed());
    }

    public void thenTheUserShouldNotBeAbleToProceedToTheNextStep() {
        Assert.assertFalse("User can proceed", checkoutPage.canProceedToNextStep());
    }

    public void thenTheUserShouldBeAbleToProceedWithTheCheckout() {
        Assert.assertTrue("User cannot proceed", checkoutPage.canProceedWithCheckout());
    }

    public void thenTheUserShouldNotBePromptedToFillOptionalFields() {
        Assert.assertFalse("User prompted for optional fields", checkoutPage.isPromptedForOptionalFields());
    }

    public void thenTheDiscountShouldBeAppliedToTheOrderTotal() {
        Assert.assertTrue("Discount not applied", checkoutPage.isDiscountApplied());
    }

    public void thenTheUserShouldSeeTheUpdatedOrderTotal() {
        Assert.assertTrue("Order total not updated", checkoutPage.isOrderTotalUpdated());
    }

    public void thenTheUserShouldSeeAnErrorMessageForTheExpiredCode() {
        Assert.assertTrue("Error message not displayed", checkoutPage.isExpiredCodeErrorMessageDisplayed());
    }

    public void thenTheOrderTotalShouldNotReflectAnyDiscount() {
        Assert.assertFalse("Order total reflects discount", checkoutPage.isDiscountApplied());
    }
}