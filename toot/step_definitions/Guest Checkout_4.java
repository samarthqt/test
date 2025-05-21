import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class GuestCheckoutSteps {
    WebDriver driver;
    WebDriverWait wait;
    CheckoutPage checkoutPage;

    @Given("the user is on the e-commerce website")
    public void user_on_ecommerce_website() {
        driver.get("http://example.com");
    }

    @Given("the shopping cart contains items")
    public void shopping_cart_contains_items() {
        // Assume items are already in the cart
    }

    @Given("the user selects \"Checkout as Guest\"")
    public void user_selects_checkout_as_guest() {
        checkoutPage.clickCheckoutAsGuest();
    }

    @When("the user enters valid shipping information")
    public void user_enters_valid_shipping_information() {
        checkoutPage.enterShippingInformation("John", "Doe", "123 Main St", "City", "State", "12345");
    }

    @When("the user enters valid payment information")
    public void user_enters_valid_payment_information() {
        checkoutPage.enterPaymentInformation("4111111111111111", "12/23", "123");
    }

    @When("the user reviews the order summary")
    public void user_reviews_order_summary() {
        checkoutPage.reviewOrderSummary();
    }

    @When("the user confirms the purchase")
    public void user_confirms_purchase() {
        checkoutPage.confirmPurchase();
    }

    @Then("the user should see a confirmation message")
    public void user_should_see_confirmation_message() {
        Assert.assertTrue(checkoutPage.isConfirmationMessageDisplayed());
    }

    @Then("the order should be placed successfully")
    public void order_should_be_placed_successfully() {
        Assert.assertTrue(checkoutPage.isOrderPlacedSuccessfully());
    }

    @When("the user enters invalid shipping information")
    public void user_enters_invalid_shipping_information() {
        checkoutPage.enterShippingInformation("", "", "", "", "", "");
    }

    @Then("the user should see an error message indicating invalid shipping information")
    public void user_should_see_error_message_invalid_shipping() {
        Assert.assertTrue(checkoutPage.isShippingErrorMessageDisplayed());
    }

    @Then("the user should be prompted to correct the shipping information")
    public void user_prompted_to_correct_shipping_information() {
        Assert.assertTrue(checkoutPage.isPromptToCorrectShippingDisplayed());
    }

    @When("the user enters invalid payment information")
    public void user_enters_invalid_payment_information() {
        checkoutPage.enterPaymentInformation("123", "12/23", "123");
    }

    @Then("the user should see an error message indicating invalid payment information")
    public void user_should_see_error_message_invalid_payment() {
        Assert.assertTrue(checkoutPage.isPaymentErrorMessageDisplayed());
    }

    @Then("the user should be prompted to correct the payment information")
    public void user_prompted_to_correct_payment_information() {
        Assert.assertTrue(checkoutPage.isPromptToCorrectPaymentDisplayed());
    }

    @When("the user leaves required fields empty")
    public void user_leaves_required_fields_empty() {
        checkoutPage.leaveRequiredFieldsEmpty();
    }

    @Then("the user should see an error message indicating missing information")
    public void user_should_see_error_message_missing_information() {
        Assert.assertTrue(checkoutPage.isMissingInformationErrorMessageDisplayed());
    }

    @Then("the user should be prompted to complete the required fields")
    public void user_prompted_to_complete_required_fields() {
        Assert.assertTrue(checkoutPage.isPromptToCompleteFieldsDisplayed());
    }

    @When("the user decides to cancel the checkout process")
    public void user_decides_to_cancel_checkout() {
        checkoutPage.cancelCheckout();
    }

    @Then("the user should be redirected back to the shopping cart")
    public void user_redirected_back_to_shopping_cart() {
        Assert.assertTrue(checkoutPage.isRedirectedToCart());
    }

    @Then("the items should still be in the shopping cart")
    public void items_should_still_be_in_shopping_cart() {
        Assert.assertTrue(checkoutPage.areItemsStillInCart());
    }

    @When("the user enters a valid promotional code")
    public void user_enters_valid_promotional_code() {
        checkoutPage.enterPromotionalCode("PROMO2023");
    }

    @Then("the discount should be applied to the order total")
    public void discount_applied_to_order_total() {
        Assert.assertTrue(checkoutPage.isDiscountApplied());
    }
}