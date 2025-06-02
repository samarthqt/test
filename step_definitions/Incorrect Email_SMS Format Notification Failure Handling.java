package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.NotificationPage;

public class NotificationSteps extends NotificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user accesses the notification system")
    public void theUserAccessesTheNotificationSystem() {
        launchNotificationSystem();
    }

    @When("the user navigates to the notification system dashboard")
    public void theUserNavigatesToTheNotificationSystemDashboard() {
        navigateToDashboard();
    }

    @Then("the user should be successfully navigated to the dashboard")
    public void theUserShouldBeSuccessfullyNavigatedToTheDashboard() {
        verifyDashboardNavigation();
    }

    @Given("the user is on the notification system dashboard")
    public void theUserIsOnTheNotificationSystemDashboard() {
        verifyOnDashboard();
    }

    @When("the user selects \"Create New Notification\"")
    public void theUserSelectsCreateNewNotification() {
        selectCreateNewNotification();
    }

    @Then("the notification creation form should be displayed")
    public void theNotificationCreationFormShouldBeDisplayed() {
        verifyNotificationFormDisplayed();
    }

    @When("the user enters incorrect email format {string} in the email field")
    public void theUserEntersIncorrectEmailFormatInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the system should validate the email format and display an error message")
    public void theSystemShouldValidateTheEmailFormatAndDisplayAnErrorMessage() {
        verifyEmailFormatError();
    }

    @When("the user enters incorrect SMS format {string} in the SMS field")
    public void theUserEntersIncorrectSMSFormatInTheSMSField(String sms) {
        enterSMS(sms);
    }

    @Then("the system should validate the SMS format and display an error message")
    public void theSystemShouldValidateTheSMSFormatAndDisplayAnErrorMessage() {
        verifySMSFormatError();
    }

    @Given("the user has entered incorrect email and SMS formats")
    public void theUserHasEnteredIncorrectEmailAndSMSFormats() {
        verifyIncorrectFormatsEntered();
    }

    @When("the user attempts to send the notification")
    public void theUserAttemptsToSendTheNotification() {
        attemptToSendNotification();
    }

    @Then("the notification sending should be blocked due to incorrect formats")
    public void theNotificationSendingShouldBeBlockedDueToIncorrectFormats() {
        verifyNotificationBlocked();
    }

    @Given("the notification sending is blocked")
    public void theNotificationSendingIsBlocked() {
        verifyNotificationBlocked();
    }

    @When("the user checks the error logs")
    public void theUserChecksTheErrorLogs() {
        checkErrorLogs();
    }

    @Then("the error logs should contain messages about the incorrect formats")
    public void theErrorLogsShouldContainMessagesAboutTheIncorrectFormats() {
        verifyErrorLogsForIncorrectFormats();
    }

    @Given("the user is on the notification creation form")
    public void theUserIsOnTheNotificationCreationForm() {
        verifyNotificationFormDisplayed();
    }

    @When("the user enters incorrect email format {string} in the email field")
    public void theUserEntersIncorrectEmailFormatInTheEmailField(String email) {
        enterEmail(email);
    }

    @When("the user enters incorrect SMS format {string} in the SMS field")
    public void theUserEntersIncorrectSMSFormatInTheSMSField(String sms) {
        enterSMS(sms);
    }

    @Then("similar error messages should be displayed for the incorrect formats")
    public void similarErrorMessagesShouldBeDisplayedForTheIncorrectFormats() {
        verifySimilarErrorMessages();
    }

    @Given("the user enters multiple incorrect formats simultaneously")
    public void theUserEntersMultipleIncorrectFormatsSimultaneously() {
        enterMultipleIncorrectFormats();
    }

    @Then("the system should handle multiple errors gracefully and display appropriate messages")
    public void theSystemShouldHandleMultipleErrorsGracefullyAndDisplayAppropriateMessages() {
        verifyMultipleErrorsHandled();
    }

    @Given("the user enters correct email and SMS formats")
    public void theUserEntersCorrectEmailAndSMSFormats() {
        enterCorrectFormats();
    }

    @Then("the notifications should be sent successfully without errors")
    public void theNotificationsShouldBeSentSuccessfullyWithoutErrors() {
        verifyNotificationsSentSuccessfully();
    }

    @Given("the notifications are sent successfully")
    public void theNotificationsAreSentSuccessfully() {
        verifyNotificationsSentSuccessfully();
    }

    @Then("no unhandled exceptions should be present")
    public void noUnhandledExceptionsShouldBePresent() {
        verifyNoUnhandledExceptions();
    }

    @Given("the system has handled errors")
    public void theSystemHasHandledErrors() {
        verifyErrorsHandled();
    }

    @Then("the system should return to a stable and responsive state")
    public void theSystemShouldReturnToAStableAndResponsiveState() {
        verifySystemStability();
    }

    @Given("the user has entered incorrect email or SMS formats")
    public void theUserHasEnteredIncorrectEmailOrSMSFormats() {
        verifyIncorrectFormatsEntered();
    }

    @Then("the user should receive clear and informative feedback about the error")
    public void theUserShouldReceiveClearAndInformativeFeedbackAboutTheError() {
        verifyUserFeedback();
    }
}