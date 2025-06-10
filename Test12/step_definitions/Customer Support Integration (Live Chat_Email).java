package com.cucumber.steps;

import com.page_objects.SupportPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SupportSteps extends SupportPage {

    @Given("a user is on the website or app")
    public void aUserIsOnTheWebsiteOrApp() {
        navigateToHomePage();
    }

    @When("the user accesses the live chat support feature")
    public void theUserAccessesTheLiveChatSupportFeature() {
        accessLiveChatSupport();
    }

    @Then("the live chat support should be available for the user")
    public void theLiveChatSupportShouldBeAvailableForTheUser() {
        verifyLiveChatAvailability();
    }

    @Given("a user has an inquiry or issue")
    public void aUserHasAnInquiryOrIssue() {
        prepareInquiry();
    }

    @When("the user sends a support inquiry via email")
    public void theUserSendsASupportInquiryViaEmail() {
        sendEmailInquiry();
    }

    @Then("the inquiry should be successfully sent to the support team")
    public void theInquiryShouldBeSuccessfullySentToTheSupportTeam() {
        verifyEmailSent();
    }

    @Given("a chat or email inquiry is received by the system")
    public void aChatOrEmailInquiryIsReceivedByTheSystem() {
        receiveInquiry();
    }

    @When("the system processes the inquiry")
    public void theSystemProcessesTheInquiry() {
        processInquiry();
    }

    @Then("the inquiry should be routed to the appropriate support agent")
    public void theInquiryShouldBeRoutedToTheAppropriateSupportAgent() {
        routeToSupportAgent();
    }

    @Given("a user has initiated a support interaction")
    public void aUserHasInitiatedASupportInteraction() {
        initiateSupportInteraction();
    }

    @When("the system acknowledges the inquiry")
    public void theSystemAcknowledgesTheInquiry() {
        acknowledgeInquiry();
    }

    @Then("the system should provide an estimated response time to the user")
    public void theSystemShouldProvideAnEstimatedResponseTimeToTheUser() {
        provideResponseTimeEstimate();
    }

    @Given("a support interaction has occurred")
    public void aSupportInteractionHasOccurred() {
        supportInteractionOccurred();
    }

    @When("the interaction is completed")
    public void theInteractionIsCompleted() {
        completeInteraction();
    }

    @Then("the system should log the interaction for future reference")
    public void theSystemShouldLogTheInteractionForFutureReference() {
        logInteraction();
    }

    @Given("an error occurs during a chat or email support interaction")
    public void anErrorOccursDuringAChatOrEmailSupportInteraction() {
        simulateError();
    }

    @When("the system detects the error")
    public void theSystemDetectsTheError() {
        detectError();
    }

    @Then("the system should handle the error gracefully and notify the user")
    public void theSystemShouldHandleTheErrorGracefullyAndNotifyTheUser() {
        handleErrorGracefully();
    }

    @Given("a user is using a desktop or mobile device")
    public void aUserIsUsingADesktopOrMobileDevice() {
        detectDeviceType();
    }

    @When("the user accesses support features")
    public void theUserAccessesSupportFeatures() {
        accessSupportFeatures();
    }

    @Then("the support features should be accessible on both devices")
    public void theSupportFeaturesShouldBeAccessibleOnBothDevices() {
        verifySupportFeaturesAccessibility();
    }

    @Given("a user is engaged in a support interaction")
    public void aUserIsEngagedInASupportInteraction() {
        engageInSupportInteraction();
    }

    @When("the interaction involves user data")
    public void theInteractionInvolvesUserData() {
        involveUserData();
    }

    @Then("the system must ensure the privacy and security of the user's data")
    public void theSystemMustEnsureThePrivacyAndSecurityOfTheUsersData() {
        ensureDataPrivacyAndSecurity();
    }
}