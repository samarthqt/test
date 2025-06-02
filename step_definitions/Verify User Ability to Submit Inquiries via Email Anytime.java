package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.EmailClientPage;

public class EmailInquirySteps extends EmailClientPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to an email client")
    public void theUserHasAccessToAnEmailClient() {
        openEmailClient();
    }

    @When("the user opens the email client application")
    public void theUserOpensTheEmailClientApplication() {
        verifyEmailClientOpened();
    }

    @Then("the email client opens successfully")
    public void theEmailClientOpensSuccessfully() {
        assertEmailClientIsOpen();
    }

    @When("the user composes a new email")
    public void theUserComposesANewEmail() {
        composeNewEmail();
    }

    @Then("the email composition window is displayed")
    public void theEmailCompositionWindowIsDisplayed() {
        assertEmailCompositionWindowDisplayed();
    }

    @When("the user enters the support email address in the 'To' field")
    public void theUserEntersTheSupportEmailAddressInTheToField() {
        String supportEmail = testHarness.getData("EmailData", "SupportEmail");
        enterEmailAddress(supportEmail);
    }

    @Then("the support email address is entered correctly")
    public void theSupportEmailAddressIsEnteredCorrectly() {
        assertEmailAddressEnteredCorrectly();
    }

    @When("the user enters a subject for the inquiry")
    public void theUserEntersASubjectForTheInquiry() {
        String subject = testHarness.getData("EmailData", "Subject");
        enterEmailSubject(subject);
    }

    @Then("the subject is entered correctly")
    public void theSubjectIsEnteredCorrectly() {
        assertSubjectEnteredCorrectly();
    }

    @When("the user composes the body of the inquiry email with relevant details")
    public void theUserComposesTheBodyOfTheInquiryEmailWithRelevantDetails() {
        String body = testHarness.getData("EmailData", "Body");
        enterEmailBody(body);
    }

    @Then("the email body is composed with all necessary details")
    public void theEmailBodyIsComposedWithAllNecessaryDetails() {
        assertEmailBodyComposedCorrectly();
    }

    @When("the user sends the email")
    public void theUserSendsTheEmail() {
        sendEmail();
    }

    @Then("the email is sent successfully without any errors")
    public void theEmailIsSentSuccessfullyWithoutAnyErrors() {
        assertEmailSentSuccessfully();
    }

    @Then("no delivery failure notifications are received")
    public void noDeliveryFailureNotificationsAreReceived() {
        assertNoDeliveryFailures();
    }

    @Then("an automated acknowledgment email is received confirming receipt of the inquiry")
    public void anAutomatedAcknowledgmentEmailIsReceivedConfirmingReceiptOfTheInquiry() {
        assertAcknowledgmentEmailReceived();
    }

    @Then("any response from the support team is logged for reference")
    public void anyResponseFromTheSupportTeamIsLoggedForReference() {
        logSupportTeamResponse();
    }

    @Given("the user tests submitting an inquiry email at different times of the day")
    public void theUserTestsSubmittingAnInquiryEmailAtDifferentTimesOfTheDay() {
        testEmailSubmissionAtDifferentTimes();
    }

    @Then("inquiry emails can be submitted successfully at any time of the day")
    public void inquiryEmailsCanBeSubmittedSuccessfullyAtAnyTimeOfTheDay() {
        assertEmailSubmissionAtAnyTime();
    }

    @Given("the user attempts to submit an inquiry with a large attachment")
    public void theUserAttemptsToSubmitAnInquiryWithALargeAttachment() {
        attachLargeFile();
    }

    @Then("the inquiry email with attachment is sent successfully, or appropriate error is displayed if size limit is exceeded")
    public void theInquiryEmailWithAttachmentIsSentSuccessfullyOrAppropriateErrorIsDisplayedIfSizeLimitIsExceeded() {
        assertLargeAttachmentHandling();
    }

    @Given("the user verifies the support email address is correctly displayed in the application's support section")
    public void theUserVerifiesTheSupportEmailAddressIsCorrectlyDisplayedInTheApplicationsSupportSection() {
        verifySupportEmailAddressDisplay();
    }

    @Then("the support email address is displayed correctly and is clickable")
    public void theSupportEmailAddressIsDisplayedCorrectlyAndIsClickable() {
        assertSupportEmailAddressClickable();
    }

    @Given("the user checks the email submission feature on different email clients")
    public void theUserChecksTheEmailSubmissionFeatureOnDifferentEmailClients() {
        testEmailSubmissionOnDifferentClients();
    }

    @Then("inquiry emails can be submitted successfully using different email clients")
    public void inquiryEmailsCanBeSubmittedSuccessfullyUsingDifferentEmailClients() {
        assertEmailSubmissionOnAllClients();
    }

    @Given("the user tests submitting an inquiry with special characters in the subject or body")
    public void theUserTestsSubmittingAnInquiryWithSpecialCharactersInTheSubjectOrBody() {
        testSpecialCharactersInEmail();
    }

    @Then("the inquiry email with special characters is sent successfully without issues")
    public void theInquiryEmailWithSpecialCharactersIsSentSuccessfullyWithoutIssues() {
        assertSpecialCharactersHandled();
    }

    @Given("the user verifies the email submission feature with a slow internet connection")
    public void theUserVerifiesTheEmailSubmissionFeatureWithASlowInternetConnection() {
        testEmailSubmissionWithSlowInternet();
    }

    @Then("inquiry emails can be submitted successfully, albeit with possible delays")
    public void inquiryEmailsCanBeSubmittedSuccessfullyAlbeitWithPossibleDelays() {
        assertEmailSubmissionWithDelays();
    }
}