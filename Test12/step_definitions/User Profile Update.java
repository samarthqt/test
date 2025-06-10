package com.cucumber.steps;

import com.page_objects.UserProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfileSteps extends UserProfilePage {

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the account dashboard")
    public void theUserNavigatesToTheAccountDashboard() {
        navigateToAccountDashboard();
    }

    @Then("the user should be able to access their profile")
    public void theUserShouldBeAbleToAccessTheirProfile() {
        verifyProfileAccess();
    }

    @Given("the user is on their profile page")
    public void theUserIsOnTheirProfilePage() {
        verifyProfilePage();
    }

    @When("the user updates their name, email, shipping/billing addresses, and phone number")
    public void theUserUpdatesTheirInformation() {
        updatePersonalInformation();
    }

    @When("the user saves the changes")
    public void theUserSavesTheChanges() {
        saveChanges();
    }

    @Then("the changes should be saved promptly")
    public void theChangesShouldBeSavedPromptly() {
        verifyChangesSaved();
    }

    @Given("the user is updating their email and phone number")
    public void theUserIsUpdatingEmailAndPhoneNumber() {
        verifyUpdatingEmailAndPhone();
    }

    @When("the user enters an invalid email or phone number format")
    public void theUserEntersInvalidEmailOrPhoneNumberFormat() {
        enterInvalidEmailOrPhone();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user has successfully updated their personal information")
    public void theUserHasSuccessfullyUpdatedTheirPersonalInformation() {
        verifySuccessfulUpdate();
    }

    @Then("the user should receive a notification confirming the successful update")
    public void theUserShouldReceiveNotification() {
        verifyNotificationReceived();
    }

    @Given("the user has made changes to their personal information")
    public void theUserHasMadeChangesToTheirPersonalInformation() {
        verifyChangesMade();
    }

    @Then("all changes should be logged for auditing purposes")
    public void allChangesShouldBeLoggedForAuditingPurposes() {
        verifyChangesLogged();
    }

    @Given("the user is updating sensitive personal information")
    public void theUserIsUpdatingSensitivePersonalInformation() {
        verifySensitiveInformationUpdate();
    }

    @Then("the system must ensure data encryption for this information")
    public void theSystemMustEnsureDataEncryption() {
        verifyDataEncryption();
    }

    @Given("the user has updated their personal information")
    public void theUserHasUpdatedTheirPersonalInformation() {
        verifyInformationUpdated();
    }

    @When("the user decides to revert the changes within the specified time frame")
    public void theUserDecidesToRevertChanges() {
        revertChanges();
    }

    @Then("the changes should be reverted successfully")
    public void theChangesShouldBeRevertedSuccessfully() {
        verifyChangesReverted();
    }
}