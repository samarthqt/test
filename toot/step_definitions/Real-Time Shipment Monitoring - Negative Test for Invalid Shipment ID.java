import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentTrackingSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ShipmentTrackingPage shipmentTrackingPage;

    @Given("the user has a valid customer account with Customer ID {string}")
    public void the_user_has_a_valid_customer_account_with_Customer_ID(String customerId) {
        // Assume customer ID is valid and stored for reference
    }

    @When("the user logs in using valid credentials")
    public void the_user_logs_in_using_valid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
        loginPage.clickLoginButton();
    }

    @Then("the user is successfully logged into their account")
    public void the_user_is_successfully_logged_into_their_account() {
        Assert.assertTrue("Login failed", loginPage.isDashboardDisplayed());
    }

    @When("the user navigates to the {string} section")
    public void the_user_navigates_to_the_section(String section) {
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        shipmentTrackingPage.navigateToTrackShipmentSection();
    }

    @Then("the {string} section is displayed")
    public void the_section_is_displayed(String section) {
        Assert.assertTrue("Track Shipment section not displayed", shipmentTrackingPage.isTrackShipmentSectionDisplayed());
    }

    @When("the user enters the invalid Shipment ID {string} in the search bar")
    public void the_user_enters_the_invalid_Shipment_ID_in_the_search_bar(String shipmentId) {
        shipmentTrackingPage.enterShipmentId(shipmentId);
        shipmentTrackingPage.clickSearchButton();
    }

    @Then("the system displays an error message indicating the shipment ID is invalid")
    public void the_system_displays_an_error_message_indicating_the_shipment_ID_is_invalid() {
        Assert.assertTrue("Error message not displayed", shipmentTrackingPage.isErrorMessageDisplayed());
    }

    @When("the user attempts to refresh the page")
    public void the_user_attempts_to_refresh_the_page() {
        driver.navigate().refresh();
    }

    @Then("the error message persists and no shipment details are displayed")
    public void the_error_message_persists_and_no_shipment_details_are_displayed() {
        Assert.assertTrue("Error message not persistent", shipmentTrackingPage.isErrorMessageDisplayed());
        Assert.assertFalse("Shipment details should not be displayed", shipmentTrackingPage.areShipmentDetailsDisplayed());
    }

    @When("the user logs out of the customer account")
    public void the_user_logs_out_of_the_customer_account() {
        loginPage.clickLogoutButton();
    }

    @Then("the user is successfully logged out")
    public void the_user_is_successfully_logged_out() {
        Assert.assertTrue("Logout failed", loginPage.isLoginButtonDisplayed());
    }
}