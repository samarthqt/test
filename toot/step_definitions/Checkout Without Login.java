import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class CheckoutStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    CheckoutPage checkoutPage;

    @Given("I am a guest user on the website")
    public void i_am_a_guest_user_on_the_website() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com");
        checkoutPage = new CheckoutPage(driver);
    }

    @Given("I have added items to my shopping cart")
    public void i_have_added_items_to_my_shopping_cart() {
        checkoutPage.addItemToCart();
    }

    @When("I proceed to the checkout page")
    public void i_proceed_to_the_checkout_page() {
        checkoutPage.goToCheckout();
    }

    @Then("I should be able to enter my shipping details")
    public void i_should_be_able_to_enter_my_shipping_details() {
        Assert.assertTrue(checkoutPage.enterShippingDetails("John", "Doe", "123 Main St", "City", "State", "12345"));
    }

    @Then("I should be able to enter my payment information")
    public void i_should_be_able_to_enter_my_payment_information() {
        Assert.assertTrue(checkoutPage.enterPaymentInformation("4111111111111111", "12/23", "123"));
    }

    @Then("I should be able to review my order")
    public void i_should_be_able_to_review_my_order() {
        Assert.assertTrue(checkoutPage.reviewOrder());
    }

    @Then("I should be able to place the order without logging in")
    public void i_should_be_able_to_place_the_order_without_logging_in() {
        Assert.assertTrue(checkoutPage.placeOrder());
    }

    @Given("my shopping cart is empty")
    public void my_shopping_cart_is_empty() {
        checkoutPage.emptyCart();
    }

    @Then("I should see a message indicating that my cart is empty")
    public void i_should_see_a_message_indicating_that_my_cart_is_empty() {
        Assert.assertTrue(checkoutPage.isCartEmptyMessageDisplayed());
    }

    @Then("I should not be able to proceed with the checkout")
    public void i_should_not_be_able_to_proceed_with_the_checkout() {
        Assert.assertFalse(checkoutPage.canProceedToCheckout());
    }

    @Given("I have entered invalid shipping details")
    public void i_have_entered_invalid_shipping_details() {
        checkoutPage.enterShippingDetails("", "", "", "", "", "");
    }

    @Then("I should see an error message indicating invalid shipping details")
    public void i_should_see_an_error_message_indicating_invalid_shipping_details() {
        Assert.assertTrue(checkoutPage.isInvalidShippingDetailsMessageDisplayed());
    }

    @Then("I should be prompted to correct the shipping details")
    public void i_should_be_prompted_to_correct_the_shipping_details() {
        Assert.assertTrue(checkoutPage.isPromptToCorrectShippingDetailsDisplayed());
    }

    @Given("I have entered invalid payment information")
    public void i_have_entered_invalid_payment_information() {
        checkoutPage.enterPaymentInformation("", "", "");
    }

    @Then("I should see an error message indicating invalid payment information")
    public void i_should_see_an_error_message_indicating_invalid_payment_information() {
        Assert.assertTrue(checkoutPage.isInvalidPaymentInformationMessageDisplayed());
    }

    @Then("I should be prompted to correct the payment information")
    public void i_should_be_prompted_to_correct_the_payment_information() {
        Assert.assertTrue(checkoutPage.isPromptToCorrectPaymentInformationDisplayed());
    }

    @Given("I have entered valid shipping and payment information")
    public void i_have_entered_valid_shipping_and_payment_information() {
        checkoutPage.enterShippingDetails("John", "Doe", "123 Main St", "City", "State", "12345");
        checkoutPage.enterPaymentInformation("4111111111111111", "12/23", "123");
    }

    @When("I review my order")
    public void i_review_my_order() {
        checkoutPage.reviewOrder();
    }

    @Then("I should see a summary of my order details")
    public void i_should_see_a_summary_of_my_order_details() {
        Assert.assertTrue(checkoutPage.isOrderSummaryDisplayed());
    }

    @Then("I should see the total cost including any taxes and shipping fees")
    public void i_should_see_the_total_cost_including_any_taxes_and_shipping_fees() {
        Assert.assertTrue(checkoutPage.isTotalCostDisplayed());
    }

    @Then("I should see an option to edit my order before placing it")
    public void i_should_see_an_option_to_edit_my_order_before_placing_it() {
        Assert.assertTrue(checkoutPage.isEditOrderOptionDisplayed());
    }
}