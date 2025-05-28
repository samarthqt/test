package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerServiceSteps extends CustomerServicePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the customer service contact page is displayed")
    public void theCustomerServiceContactPageIsDisplayed() {
        navigateToCustomerServicePage();
    }

    @When("a contact channel is selected")
    public void aContactChannelIsSelected() {
        String contactChannel = testHarness.getData("ContactData", "Channel");
        selectContactChannel(contactChannel);
    }

    @Then("the selected contact channel should be highlighted or marked as active")
    public void theSelectedContactChannelShouldBeHighlightedOrMarkedAsActive() {
        String contactChannel = testHarness.getData("ContactData", "Channel");
        verifyContactChannelActive(contactChannel);
    }

    @Given("the customer's contact information is entered correctly")
    public void theCustomersContactInformationIsEnteredCorrectly() {
        String name = testHarness.getData("ContactData", "Name");
        String email = testHarness.getData("ContactData", "Email");
        enterContactInformation(name, email);
    }

    @When("the 'Connect' button is clicked")
    public void theConnectButtonIsClicked() {
        clickConnectButton();
    }

    @Then("the system should connect the customer with an available customer service representative")
    public void theSystemShouldConnectTheCustomerWithAnAvailableCustomerServiceRepresentative() {
        verifyConnectionWithRepresentative();
    }

    @Given("the customer is connected with a customer service representative")
    public void theCustomerIsConnectedWithACustomerServiceRepresentative() {
        verifyConnectionWithRepresentative();
    }

    @Then("the customer should be able to initiate a conversation with the representative")
    public void theCustomerShouldBeAbleToInitiateAConversationWithTheRepresentative() {
        initiateConversation();
    }

    @Given("the customer service representative is responsive")
    public void theCustomerServiceRepresentativeIsResponsive() {
        verifyRepresentativeResponsiveness();
    }

    @When("the customer makes inquiries or requests")
    public void theCustomerMakesInquiriesOrRequests() {
        makeInquiriesOrRequests();
    }

    @Then("the representative should respond to the customer")
    public void theRepresentativeShouldRespondToTheCustomer() {
        verifyRepresentativeResponse();
    }

    @Given("the customer is in a conversation with the representative")
    public void theCustomerIsInAConversationWithTheRepresentative() {
        verifyConversationActive();
    }

    @When("the customer wants to end the conversation")
    public void theCustomerWantsToEndTheConversation() {
        endConversation();
    }

    @Then("the customer should be able to end the conversation")
    public void theCustomerShouldBeAbleToEndTheConversation() {
        verifyConversationEnded();
    }

    @Given("the conversation with the representative is ended")
    public void theConversationWithTheRepresentativeIsEnded() {
        verifyConversationEnded();
    }

    @Then("the conversation should be ended")
    public void theConversationShouldBeEnded() {
        verifyConversationEnded();
    }

    @Given("the customer wants to connect with a representative through different contact channels")
    public void theCustomerWantsToConnectWithARepresentativeThroughDifferentContactChannels() {
        navigateToCustomerServicePage();
    }

    @When("the process is repeated for each contact channel")
    public void theProcessIsRepeatedForEachContactChannel() {
        repeatProcessForEachChannel();
    }

    @Then("the customer should be able to connect with an available representative through different contact channels")
    public void theCustomerShouldBeAbleToConnectWithAnAvailableRepresentativeThroughDifferentContactChannels() {
        verifyConnectionThroughDifferentChannels();
    }

    @Given("there is at least one representative available for each contact channel")
    public void thereIsAtLeastOneRepresentativeAvailableForEachContactChannel() {
        verifyRepresentativeAvailabilityForEachChannel();
    }

    @Then("the customer service representative should be available for each contact channel")
    public void theCustomerServiceRepresentativeShouldBeAvailableForEachContactChannel() {
        verifyRepresentativeAvailabilityForEachChannel();
    }

    @Given("the customer service contact page is displayed")
    public void theCustomerServiceContactPageIsDisplayedAgain() {
        navigateToCustomerServicePage();
    }

    @Then("the page should accurately display information about the availability of representatives for each contact channel")
    public void thePageShouldAccuratelyDisplayInformationAboutTheAvailabilityOfRepresentativesForEachContactChannel() {
        verifyRepresentativeAvailabilityInfo();
    }

    @Then("the page should provide clear instructions on how to connect with a representative for each contact channel")
    public void thePageShouldProvideClearInstructionsOnHowToConnectWithARepresentativeForEachContactChannel() {
        verifyConnectionInstructions();
    }

    @Then("the page should provide alternative contact methods \(e.g. leave a message, schedule a callback\) in case all representatives are busy")
    public void thePageShouldProvideAlternativeContactMethodsInCaseAllRepresentativesAreBusy() {
        verifyAlternativeContactMethods();
    }

    @Then("the page should accurately display contact information \(e.g. phone number, email address\) for each contact channel")
    public void thePageShouldAccuratelyDisplayContactInformationForEachContactChannel() {
        verifyContactInformationDisplay();
    }
}