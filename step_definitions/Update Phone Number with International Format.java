package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfileSteps extends UserProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @Given("the user has an existing phone number {string} in the profile")
    public void theUserHasAnExistingPhoneNumberInTheProfile(String phoneNumber) {
        verifyExistingPhoneNumber(phoneNumber);
    }

    @When("the user navigates to the user profile page")
    public void theUserNavigatesToTheUserProfilePage() {
        navigateToUserProfilePage();
    }

    @Then("the user profile page is displayed")
    public void theUserProfilePageIsDisplayed() {
        verifyUserProfilePageDisplayed();
    }

    @When("the user clicks on the 'Edit' button next to the phone number field")
    public void theUserClicksOnTheEditButtonNextToThePhoneNumberField() {
        clickEditButton();
    }

    @Then("the phone number field becomes editable")
    public void thePhoneNumberFieldBecomesEditable() {
        verifyPhoneNumberFieldEditable();
    }

    @When("the user enters the new international phone number {string} in the phone number field")
    public void theUserEntersTheNewInternationalPhoneNumberInThePhoneNumberField(String newPhoneNumber) {
        enterNewPhoneNumber(newPhoneNumber);
    }

    @When("the user clicks on the 'Save' button to update the phone number")
    public void theUserClicksOnTheSaveButtonToUpdateThePhoneNumber() {
        clickSaveButton();
    }

    @Then("a confirmation message is displayed indicating the phone number has been updated")
    public void aConfirmationMessageIsDisplayedIndicatingThePhoneNumberHasBeenUpdated() {
        verifyConfirmationMessage();
    }

    @Then("the new international phone number {string} is displayed in the profile")
    public void theNewInternationalPhoneNumberIsDisplayedInTheProfile(String newPhoneNumber) {
        verifyUpdatedPhoneNumberInProfile(newPhoneNumber);
    }

    @Given("the user logs out and logs back into the system")
    public void theUserLogsOutAndLogsBackIntoTheSystem() {
        logoutAndLogin();
    }

    @When("the user checks the system logs for any errors during the update process")
    public void theUserChecksTheSystemLogsForAnyErrorsDuringTheUpdateProcess() {
        checkSystemLogsForErrors();
    }

    @Then("no errors related to phone number update are found in the system logs")
    public void noErrorsRelatedToPhoneNumberUpdateAreFoundInTheSystemLogs() {
        verifyNoErrorsInLogs();
    }

    @When("the user attempts to update the phone number again with a different international number")
    public void theUserAttemptsToUpdateThePhoneNumberAgainWithADifferentInternationalNumber() {
        updatePhoneNumberWithDifferentNumber();
    }

    @Then("the phone number is updated successfully with the new international number")
    public void thePhoneNumberIsUpdatedSuccessfullyWithTheNewInternationalNumber() {
        verifyPhoneNumberUpdatedSuccessfully();
    }

    @When("the user verifies the notification about the phone number update")
    public void theUserVerifiesTheNotificationAboutThePhoneNumberUpdate() {
        verifyNotificationForPhoneNumberUpdate();
    }

    @Then("the user receives a notification confirming the phone number update")
    public void theUserReceivesANotificationConfirmingThePhoneNumberUpdate() {
        verifyNotificationReceived();
    }

    @When("the user checks the database to ensure the phone number is updated")
    public void theUserChecksTheDatabaseToEnsureThePhoneNumberIsUpdated() {
        checkDatabaseForUpdatedPhoneNumber();
    }

    @Then("the database reflects the updated international phone number {string}")
    public void theDatabaseReflectsTheUpdatedInternationalPhoneNumber(String newPhoneNumber) {
        verifyDatabasePhoneNumber(newPhoneNumber);
    }

    @When("the user attempts to access the system using the new international phone number for verification")
    public void theUserAttemptsToAccessTheSystemUsingTheNewInternationalPhoneNumberForVerification() {
        accessSystemWithNewPhoneNumber();
    }

    @Then("the user is able to verify their identity using the new international phone number")
    public void theUserIsAbleToVerifyTheirIdentityUsingTheNewInternationalPhoneNumber() {
        verifyIdentityWithNewPhoneNumber();
    }

    @When("the user monitors the server performance during the phone number update process")
    public void theUserMonitorsTheServerPerformanceDuringThePhoneNumberUpdateProcess() {
        monitorServerPerformance();
    }

    @Then("the server performance remains stable during the phone number update")
    public void theServerPerformanceRemainsStableDuringThePhoneNumberUpdate() {
        verifyServerPerformanceStable();
    }

    @When("the user repeats the phone number update process with a different valid international number")
    public void theUserRepeatsThePhoneNumberUpdateProcessWithADifferentValidInternationalNumber() {
        repeatPhoneNumberUpdate();
    }

    @Then("the phone number is updated successfully with the new valid international number")
    public void thePhoneNumberIsUpdatedSuccessfullyWithTheNewValidInternationalNumber() {
        verifyPhoneNumberUpdatedSuccessfully();
    }

    @When("the user ensures the phone number update is reflected across all user-related services")
    public void theUserEnsuresThePhoneNumberUpdateIsReflectedAcrossAllUserRelatedServices() {
        ensureUpdateAcrossAllServices();
    }

    @Then("all user-related services reflect the updated international phone number")
    public void allUserRelatedServicesReflectTheUpdatedInternationalPhoneNumber() {
        verifyAllServicesUpdated();
    }
}