package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhoneNumberUpdateSteps extends UserProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @Given("the system is experiencing high server load")
    public void theSystemIsExperiencingHighServerLoad() {
        simulateHighServerLoad();
    }

    @Given("the existing phone number is {string}")
    public void theExistingPhoneNumberIs(String phoneNumber) {
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

    @When("the user clicks on the {string} button next to the phone number field")
    public void theUserClicksOnTheEditButton(String buttonName) {
        clickEditButton(buttonName);
    }

    @Then("the phone number field becomes editable")
    public void thePhoneNumberFieldBecomesEditable() {
        verifyPhoneNumberFieldEditable();
    }

    @When("the user enters the new phone number {string} in the phone number field")
    public void theUserEntersTheNewPhoneNumber(String newPhoneNumber) {
        enterNewPhoneNumber(newPhoneNumber);
    }

    @Then("the new phone number is entered in the field")
    public void theNewPhoneNumberIsEnteredInTheField() {
        verifyNewPhoneNumberEntered();
    }

    @When("the user clicks on the {string} button to update the phone number")
    public void theUserClicksOnTheSaveButton(String buttonName) {
        clickSaveButton(buttonName);
    }

    @Then("a confirmation message is displayed indicating the phone number has been updated")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @When("the user verifies that the new phone number is displayed in the profile")
    public void theUserVerifiesNewPhoneNumberInProfile() {
        verifyNewPhoneNumberInProfile();
    }

    @Then("the new phone number {string} is displayed in the profile")
    public void theNewPhoneNumberIsDisplayedInProfile(String newPhoneNumber) {
        verifyPhoneNumberInProfile(newPhoneNumber);
    }

    @When("the user logs out and logs back into the system")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the user is able to log back into the system successfully")
    public void theUserLogsBackInSuccessfully() {
        verifyLoginSuccess();
    }

    @When("the user navigates back to the user profile page")
    public void theUserNavigatesBackToUserProfilePage() {
        navigateToUserProfilePage();
    }

    @Then("the user profile page is displayed with the updated phone number")
    public void theUserProfilePageDisplayedWithUpdatedPhoneNumber() {
        verifyUserProfilePageWithUpdatedPhoneNumber();
    }

    @When("the user checks the system logs for any errors during the update process")
    public void theUserChecksSystemLogsForErrors() {
        checkSystemLogsForErrors();
    }

    @Then("no errors related to phone number update are found in the system logs")
    public void noErrorsFoundInSystemLogs() {
        verifyNoErrorsInSystemLogs();
    }

    @When("the user attempts to update the phone number again during peak server load")
    public void theUserAttemptsToUpdatePhoneNumberAgain() {
        updatePhoneNumberDuringPeakLoad();
    }

    @Then("the phone number is updated successfully without any delay")
    public void phoneNumberUpdatedSuccessfullyWithoutDelay() {
        verifyPhoneNumberUpdatedWithoutDelay();
    }

    @When("the user verifies they receive a notification about the phone number update")
    public void theUserVerifiesNotificationReceived() {
        verifyNotificationReceived();
    }

    @Then("the user receives a notification confirming the phone number update")
    public void userReceivesNotificationConfirmingUpdate() {
        verifyNotificationConfirmation();
    }

    @When("the user checks the database to ensure the phone number is updated")
    public void theUserChecksDatabaseForUpdate() {
        checkDatabaseForPhoneNumberUpdate();
    }

    @Then("the database reflects the updated phone number {string}")
    public void databaseReflectsUpdatedPhoneNumber(String newPhoneNumber) {
        verifyDatabasePhoneNumber(newPhoneNumber);
    }

    @When("the user attempts to access the system using the new phone number for verification")
    public void theUserAttemptsAccessUsingNewPhoneNumber() {
        accessSystemUsingNewPhoneNumber();
    }

    @Then("the user is able to verify their identity using the new phone number")
    public void userVerifiesIdentityUsingNewPhoneNumber() {
        verifyIdentityUsingNewPhoneNumber();
    }

    @When("the user monitors the server performance during the phone number update process")
    public void theUserMonitorsServerPerformance() {
        monitorServerPerformance();
    }

    @Then("server performance remains stable during the phone number update")
    public void serverPerformanceRemainsStable() {
        verifyServerPerformanceStability();
    }

    @When("the user repeats the phone number update process with a different valid number")
    public void theUserRepeatsUpdateWithDifferentNumber() {
        repeatPhoneNumberUpdateWithDifferentNumber();
    }

    @Then("the phone number is updated successfully with the new valid number")
    public void phoneNumberUpdatedSuccessfullyWithNewNumber() {
        verifyPhoneNumberUpdatedWithNewNumber();
    }

    @When("the user ensures the phone number update is reflected across all user-related services")
    public void theUserEnsuresUpdateAcrossServices() {
        ensurePhoneNumberUpdateAcrossServices();
    }

    @Then("all user-related services reflect the updated phone number")
    public void allServicesReflectUpdatedPhoneNumber() {
        verifyServicesReflectUpdatedPhoneNumber();
    }
}