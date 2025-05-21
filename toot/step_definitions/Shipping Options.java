import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.*;
import java.time.Duration;

public class ShippingOptionsStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    CheckoutPage checkoutPage;

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/checkout");
        checkoutPage = new CheckoutPage(driver, wait);
    }

    @When("I enter my delivery location as {string}")
    public void i_enter_my_delivery_location_as(String location) {
        checkoutPage.enterDeliveryLocation(location);
    }

    @Then("I should see the following shipping options:")
    public void i_should_see_the_following_shipping_options(io.cucumber.datatable.DataTable dataTable) {
        checkoutPage.verifyShippingOptions(dataTable);
    }

    @Then("the options should be sorted by delivery speed")
    public void the_options_should_be_sorted_by_delivery_speed() {
        checkoutPage.verifyOptionsSortedBySpeed();
    }

    @When("I choose {string}")
    public void i_choose(String option) {
        checkoutPage.selectShippingOption(option);
    }

    @Then("the selected shipping option should be {string}")
    public void the_selected_shipping_option_should_be(String option) {
        Assert.assertEquals(option, checkoutPage.getSelectedShippingOption());
    }

    @Then("the estimated delivery date should be updated accordingly")
    public void the_estimated_delivery_date_should_be_updated_accordingly() {
        checkoutPage.verifyEstimatedDeliveryDate();
    }

    @Then("I should see a message indicating {string}")
    public void i_should_see_a_message_indicating(String message) {
        Assert.assertTrue(checkoutPage.isMessageDisplayed(message));
    }

    @Then("I should only see the following available options:")
    public void i_should_only_see_the_following_available_options(io.cucumber.datatable.DataTable dataTable) {
        checkoutPage.verifyAvailableOptions(dataTable);
    }

    @Then("the shipping cost should be calculated based on the selected option")
    public void the_shipping_cost_should_be_calculated_based_on_the_selected_option() {
        checkoutPage.verifyShippingCostCalculation();
    }

    @Then("the total cost should reflect the added shipping cost")
    public void the_total_cost_should_reflect_the_added_shipping_cost() {
        checkoutPage.verifyTotalCost();
    }

    @When("I proceed to checkout without selecting a shipping option")
    public void i_proceed_to_checkout_without_selecting_a_shipping_option() {
        checkoutPage.proceedToCheckout();
    }

    @Then("{string} should be selected by default")
    public void should_be_selected_by_default(String option) {
        Assert.assertEquals(option, checkoutPage.getDefaultShippingOption());
    }
}