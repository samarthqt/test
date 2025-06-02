package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProfilePage;

public class ProfileUpdateSteps extends ProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid login credentials")
    public void theUserHasValidLoginCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(username);
        enterPassword(password);
    }

    @When("the user logs into the account")
    public void theUserLogsIntoTheAccount() {
        clickLoginButton();
    }

    @Then("the user is logged in successfully and redirected to the dashboard")
    public void theUserIsLoggedInSuccessfullyAndRedirectedToTheDashboard() {
        String expectedURL = testHarness.getData("LoginData", "DashboardURL");
        verifyDashboardRedirection(expectedURL);
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

    @Then("the save button is disabled or error prevents saving changes")
    public void theSaveButtonIsDisabledOrErrorPreventsSavingChanges() {
        verifySaveButtonDisabled();
    }

    @When("the user corrects the email format and attempts to save changes")
    public void theUserCorrectsTheEmailFormatAndAttemptsToSaveChanges() {
        String validEmail = testHarness.getData("ProfileData", "ValidEmail");
        updateEmailField(validEmail);
        clickSaveChangesButton();
    }

    @Then("the changes are saved successfully after correcting the email format")
    public void theChangesAreSavedSuccessfullyAfterCorrectingTheEmailFormat() {
        verifyChangesSavedSuccessfully();
    }
}