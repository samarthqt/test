import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class TrackingStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    TrackingPage trackingPage;

    @Given("the user has a valid customer account")
    public void the_user_has_a_valid_customer_account() {
        // Assume user account is valid
    }

    @Given("the user logs in using valid credentials")
    public void the_user_logs_in_using_valid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.login("validUsername", "validPassword");
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void the_user_navigates_to_the_track_shipment_section() {
        trackingPage = new TrackingPage(driver);
        trackingPage.navigateToTrackShipment();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void the_track_shipment_section_is_displayed() {
        Assert.assertTrue(trackingPage.isTrackShipmentSectionDisplayed());
    }

    @When("the user enters the Shipment ID {string} in the search bar")
    public void the_user_enters_the_shipment_id_in_the_search_bar(String shipmentId) {
        trackingPage.enterShipmentId(shipmentId);
    }

    @Then("the shipment details are displayed for {string}")
    public void the_shipment_details_are_displayed_for(String shipmentId) {
        Assert.assertTrue(trackingPage.isShipmentDetailsDisplayed(shipmentId));
    }

    @Then("the current status of the shipment is displayed as {string}")
    public void the_current_status_of_the_shipment_is_displayed_as(String status) {
        Assert.assertEquals(status, trackingPage.getShipmentStatus());
    }

    @When("the user refreshes the tracking information")
    public void the_user_refreshes_the_tracking_information() {
        trackingPage.refreshTrackingInformation();
    }

    @Then("the tracking information updates immediately to reflect real-time changes")
    public void the_tracking_information_updates_immediately_to_reflect_real_time_changes() {
        Assert.assertTrue(trackingPage.isTrackingInformationUpdated());
    }

    @When("the user logs out of the customer account")
    public void the_user_logs_out_of_the_customer_account() {
        loginPage.logout();
    }

    @Then("the user is successfully logged out")
    public void the_user_is_successfully_logged_out() {
        Assert.assertTrue(loginPage.isLoggedOut());
    }
}