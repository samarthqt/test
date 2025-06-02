package com.cucumber.steps;

import com.page_objects.ProfilePage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfileEmailUpdateSteps extends ProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with valid login credentials")
    public void aUserAccountWithValidLoginCredentials() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(userName, password);
    }

    @When("the user logs in to the account")
    public void theUserLogsInToTheAccount() {
        verifyDashboardRedirection();
    }

    @Then("the user is redirected to the dashboard")
    public void theUserIsRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @When("the user navigates to the profile settings page")
    public void theUserNavigatesToTheProfileSettingsPage() {
        navigateToProfileSettings();
    }

    @Then("the profile settings page is displayed with current user details")
    public void theProfileSettingsPageIsDisplayedWithCurrentUserDetails() {
        verifyProfileSettingsPage();
    }

    @When("the user attempts to update the email field with {string}")
    public void theUserAttemptsToUpdateTheEmailFieldWith(String email) {
        updateEmailField(email);
    }

    @Then("the system displays an error message indicating invalid email format")
    public void theSystemDisplaysAnErrorMessageIndicatingInvalidEmailFormat() {
        verifyInvalidEmailErrorMessage();
    }

    @Then("changes cannot be saved with the invalid email")
    public void changesCannotBeSavedWithTheInvalidEmail() {
        verifySaveButtonDisabled();
    }

    @Then("the save button is disabled or error prevents saving changes")
    public void theSaveButtonIsDisabledOrErrorPreventsSavingChanges() {
        verifySaveButtonDisabled();
    }

    @When("the user corrects the email format")
    public void theUserCorrectsTheEmailFormat() {
        String validEmail = testHarness.getData("ProfileData", "ValidEmail");
        updateEmailField(validEmail);
    }

    @When("attempts to save changes")
    public void attemptsToSaveChanges() {
        saveProfileChanges();
    }

    @Then("the changes are saved successfully after correcting the email format")
    public void theChangesAreSavedSuccessfullyAfterCorrectingTheEmailFormat() {
        verifyChangesSavedSuccessfully();
    }
}