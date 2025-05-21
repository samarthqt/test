import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TaxCalculationSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private CheckoutPage checkoutPage;

    public TaxCalculationSteps() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        this.checkoutPage = new CheckoutPage(driver);
    }

    @Given("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() {
        driver.get("http://example.com/checkout");
    }

    @When("the user enters their location as {string}")
    public void the_user_enters_their_location_as(String location) {
        checkoutPage.enterLocation(location);
    }

    @Then("the system should calculate the tax based on {string}")
    public void the_system_should_calculate_the_tax_based_on(String location) {
        checkoutPage.calculateTax();
    }

    @Then("the calculated tax should be {string}")
    public void the_calculated_tax_should_be(String expectedTax) {
        String actualTax = checkoutPage.getCalculatedTax();
        Assert.assertEquals(expectedTax, actualTax);
    }

    @When("the system calculates the tax")
    public void the_system_calculates_the_tax() {
        checkoutPage.calculateTax();
    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String errorMessage) {
        String actualMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(errorMessage, actualMessage);
    }

    @Given("the user does not enter any location")
    public void the_user_does_not_enter_any_location() {
        checkoutPage.clearLocationField();
    }
}