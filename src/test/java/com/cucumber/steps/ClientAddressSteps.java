package com.cucumber.steps;
import com.pageobjects.AddressEntryPage;
import com.pageobjects.LabelPrintPage;
import com.pageobjects.CourierSchedulePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientAddressSteps extends AddressEntryPage {

    @Given("the client is on the address entry page")
    public void theClientIsOnTheAddressEntryPage() {
        navigateToAddressEntryPage();
    }

    @When("the client enters their address {string}")
    public void theClientEntersTheirAddress(String clientAddress) {
        enterClientAddress(clientAddress);
    }

    @When("the client enters the addressee's address {string}")
    public void theClientEntersTheAddresseesAddress(String addresseeAddress) {
        enterAddresseeAddress(addresseeAddress);
    }

    @Then("the system should accept both addresses")
    public void theSystemShouldAcceptBothAddresses() {
        verifyAddressesAccepted();
    }

    @Given("the client has entered both their address and the addressee's address")
    public void theClientHasEnteredBothAddresses() {
        verifyAddressesEntered();
    }

    @When("the client selects the option to print the label")
    public void theClientSelectsTheOptionToPrintTheLabel() {
        selectPrintLabelOption();
    }

    @Then("the system should generate a label with the provided addresses")
    public void theSystemShouldGenerateALabelWithTheProvidedAddresses() {
        verifyLabelGenerated();
    }

    @Then("the label should be ready for printing")
    public void theLabelShouldBeReadyForPrinting() {
        verifyLabelReadyForPrinting();
    }

    @Given("the client has printed the parcel label")
    public void theClientHasPrintedTheParcelLabel() {
        verifyLabelPrinted();
    }

    @When("the client selects the option to schedule a courier")
    public void theClientSelectsTheOptionToScheduleACourier() {
        selectScheduleCourierOption();
    }

    @When("the client chooses a convenient time {string}")
    public void theClientChoosesAConvenientTime(String time) {
        chooseCourierTime(time);
    }

    @Then("the system should confirm the courier visit at the selected time")
    public void theSystemShouldConfirmTheCourierVisitAtTheSelectedTime() {
        verifyCourierVisitConfirmed();
    }

    @Given("the client has scheduled a courier visit")
    public void theClientHasScheduledACourierVisit() {
        verifyCourierVisitScheduled();
    }

    @When("the client reviews the courier visit details")
    public void theClientReviewsTheCourierVisitDetails() {
        reviewCourierVisitDetails();
    }

    @When("the client confirms the courier scheduling")
    public void theClientConfirmsTheCourierScheduling() {
        confirmCourierScheduling();
    }

    @Then("the system should display a confirmation message")
    public void theSystemShouldDisplayAConfirmationMessage() {
        verifyConfirmationMessageDisplayed();
    }

    @Then("the courier visit should be listed in the client's scheduled deliveries")
    public void theCourierVisitShouldBeListedInTheClientsScheduledDeliveries() {
        verifyCourierVisitListed();
    }
}