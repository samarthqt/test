import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GuestCheckoutSteps {
    WebDriver driver;
    WebDriverWait wait;
    CheckoutPage checkoutPage;

    @Given("the user has added items to the shopping cart")
    public void user_has_added_items_to_cart() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.addItemsToCart();
    }

    @When("the user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        checkoutPage.proceedToCheckout();
    }

    @Then("the user should see an option to checkout as a guest")
    public void user_sees_guest_checkout_option() {
        Assert.assertTrue(checkoutPage.isGuestCheckoutOptionVisible());
    }

    @Given("the user has chosen to checkout as a guest")
    public void user_chooses_guest_checkout() {
        checkoutPage.chooseGuestCheckout();
    }

    @When("the user enters the required shipping and payment information")
    public void user_enters_shipping_and_payment_info() {
        checkoutPage.enterShippingInformation();
        checkoutPage.enterPaymentInformation();
    }

    @When("the user confirms the order")
    public void user_confirms_order() {
        checkoutPage.confirmOrder();
    }

    @Then("the order should be placed successfully")
    public void order_is_placed_successfully() {
        Assert.assertTrue(checkoutPage.isOrderPlacedSuccessfully());
    }

    @Then("the user should receive an order confirmation")
    public void user_receives_order_confirmation() {
        Assert.assertTrue(checkoutPage.isOrderConfirmationReceived());
    }

    @Given("the user is on the guest checkout page")
    public void user_on_guest_checkout_page() {
        checkoutPage.navigateToGuestCheckoutPage();
    }

    @When("the user tries to proceed without entering required information")
    public void user_proceeds_without_required_info() {
        checkoutPage.proceedWithoutRequiredInformation();
    }

    @Then("the user should be prompted to enter the missing information")
    public void user_prompted_for_missing_info() {
        Assert.assertTrue(checkoutPage.isMissingInformationPromptVisible());
    }

    @When("the user enters invalid payment information")
    public void user_enters_invalid_payment_info() {
        checkoutPage.enterInvalidPaymentInformation();
    }

    @Then("the user should see an error message indicating the issue")
    public void user_sees_error_message() {
        Assert.assertTrue(checkoutPage.isErrorMessageVisible());
    }

    @Then("the user should be able to correct the information and try again")
    public void user_corrects_information_and_retries() {
        checkoutPage.correctInformationAndRetry();
    }

    @When("the user decides to log in")
    public void user_decides_to_log_in() {
        checkoutPage.decideToLogIn();
    }

    @Then("the user should be redirected to the login page")
    public void user_redirected_to_login_page() {
        Assert.assertTrue(checkoutPage.isRedirectedToLoginPage());
    }

    @Then("after logging in, the user should be redirected back to the checkout page")
    public void user_redirected_back_to_checkout_page() {
        Assert.assertTrue(checkoutPage.isRedirectedBackToCheckoutPage());
    }
}