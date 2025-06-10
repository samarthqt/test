package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SupportTicketPage;

public class SupportTicketSteps extends SupportTicketPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is on the support ticket submission page on the web platform")
    public void userOnSupportTicketPageWeb() {
        navigateToSupportTicketPage("web");
    }

    @Given("a user is on the support ticket submission page on the mobile platform")
    public void userOnSupportTicketPageMobile() {
        navigateToSupportTicketPage("mobile");
    }

    @Given("a user is submitting a support ticket")
    public void userSubmittingSupportTicket() {
        navigateToSupportTicketPage("web");
    }

    @Given("a user encounters an issue while submitting a support ticket")
    public void userEncountersIssue() {
        simulateSubmissionIssue();
    }

    @Given("a user has submitted a support ticket")
    public void userHasSubmittedTicket() {
        submitSupportTicket();
    }

    @When("the user provides necessary details for ticket creation")
    public void userProvidesDetails() {
        enterTicketDetails();
    }

    @When("submits the ticket")
    public void userSubmitsTicket() {
        submitSupportTicket();
    }

    @When("an error occurs during submission")
    public void errorOccursDuringSubmission() {
        simulateSubmissionError();
    }

    @When("the ticket is being managed by the support system")
    public void ticketManagedBySupportSystem() {
        verifyTicketManagementIntegration();
    }

    @When("there is an update on the ticket status or responses")
    public void updateOnTicketStatus() {
        simulateTicketUpdate();
    }

    @Then("the system should acknowledge ticket receipt immediately")
    public void systemAcknowledgesReceipt() {
        verifyAcknowledgement();
    }

    @Then("the user should be able to track ticket status and responses")
    public void userCanTrackTicket() {
        verifyTicketTracking();
    }

    @Then("the system should ensure secure and private communication")
    public void systemEnsuresSecureCommunication() {
        verifySecureCommunication();
    }

    @Then("the system must display user-friendly messages for submission issues")
    public void systemDisplaysUserFriendlyMessages() {
        verifyUserFriendlyErrorMessages();
    }

    @Then("the integration with support systems for ticket management must be reliable")
    public void integrationIsReliable() {
        verifyReliableIntegration();
    }

    @Then("the user should receive notifications for ticket updates")
    public void userReceivesNotifications() {
        verifyNotificationReceived();
    }
}