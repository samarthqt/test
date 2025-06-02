package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OptOutPage;

public class OptOutSteps extends OptOutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with personalized recommendations enabled")
    public void aUserAccountWithPersonalizedRecommendationsEnabled() {
        loginToAccount();
    }

    @When("the user logs in to the account")
    public void theUserLogsInToTheAccount() {
        verifyDashboardRedirection();
    }

    @Then("the user is directed to the dashboard")
    public void theUserIsDirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        navigateToDashboard();
    }

    @When("the user navigates to the account settings page")
    public void theUserNavigatesToTheAccountSettingsPage() {
        navigateToAccountSettings();
    }

    @Then("the user is able to access the account settings page")
    public void theUserIsAbleToAccessTheAccountSettingsPage() {
        verifyAccountSettingsAccess();
    }

    @Given("the user is on the account settings page")
    public void theUserIsOnTheAccountSettingsPage() {
        navigateToAccountSettings();
    }

    @When("the user locates the personalized recommendation settings")
    public void theUserLocatesThePersonalizedRecommendationSettings() {
        locatePersonalizedRecommendationSettings();
    }

    @Then("settings for personalized recommendations are visible")
    public void settingsForPersonalizedRecommendationsAreVisible() {
        verifyPersonalizedRecommendationSettingsVisibility();
    }

    @When("the user selects the option to opt out of personalized recommendations")
    public void theUserSelectsTheOptionToOptOutOfPersonalizedRecommendations() {
        selectOptOutOption();
    }

    @Then("the option to opt out is selectable")
    public void theOptionToOptOutIsSelectable() {
        verifyOptOutOptionSelectable();
    }

    @Given("the user has selected the opt-out option")
    public void theUserHasSelectedTheOptOutOption() {
        selectOptOutOption();
    }

    @When("the user saves the changes to the settings")
    public void theUserSavesTheChangesToTheSettings() {
        saveSettingsChanges();
    }

    @Then("changes are saved successfully with a confirmation message")
    public void changesAreSavedSuccessfullyWithAConfirmationMessage() {
        verifySettingsSavedConfirmation();
    }

    @Given("the user has saved the opt-out changes")
    public void theUserHasSavedTheOptOutChanges() {
        saveSettingsChanges();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("changes persist after logging back in")
    public void changesPersistAfterLoggingBackIn() {
        verifyChangesPersist();
    }

    @Given("the user has opted out of personalized recommendations")
    public void theUserHasOptedOutOfPersonalizedRecommendations() {
        selectOptOutOption();
        saveSettingsChanges();
    }

    @When("the user attempts to access personalized recommendations")
    public void theUserAttemptsToAccessPersonalizedRecommendations() {
        attemptAccessPersonalizedRecommendations();
    }

    @Then("personalized recommendations are no longer displayed")
    public void personalizedRecommendationsAreNoLongerDisplayed() {
        verifyNoPersonalizedRecommendations();
    }

    @When("the user checks for notifications regarding the opt-out")
    public void theUserChecksForNotificationsRegardingTheOptOut() {
        checkOptOutNotifications();
    }

    @Then("notification confirms successful opt-out")
    public void notificationConfirmsSuccessfulOptOut() {
        verifyOptOutNotification();
    }

    @Given("the user wants to understand opt-out procedures")
    public void theUserWantsToUnderstandOptOutProcedures() {
        navigateToPrivacyPolicy();
    }

    @When("the user reviews the privacy policy for opt-out information")
    public void theUserReviewsThePrivacyPolicyForOptOutInformation() {
        reviewPrivacyPolicy();
    }

    @Then("privacy policy outlines opt-out procedures clearly")
    public void privacyPolicyOutlinesOptOutProceduresClearly() {
        verifyPrivacyPolicyDetails();
    }

    @When("the user wants to re-enable personalized recommendations")
    public void theUserWantsToReEnablePersonalizedRecommendations() {
        reEnablePersonalizedRecommendations();
    }

    @Then("the user can re-enable recommendations at any time")
    public void theUserCanReEnableRecommendationsAtAnyTime() {
        verifyReEnableOption();
    }

    @When("the user tests the opt-out feature on different devices")
    public void theUserTestsTheOptOutFeatureOnDifferentDevices() {
        testOptOutOnDifferentDevices();
    }

    @Then("the opt-out feature works consistently across devices")
    public void theOptOutFeatureWorksConsistentlyAcrossDevices() {
        verifyOptOutConsistencyAcrossDevices();
    }

    @When("the user checks the system logs for opt-out actions")
    public void theUserChecksTheSystemLogsForOptOutActions() {
        checkSystemLogsForOptOut();
    }

    @Then("logs accurately reflect the opt-out action")
    public void logsAccuratelyReflectTheOptOutAction() {
        verifySystemLogs();
    }

    @When("the user checks for residual personalized data post opt-out")
    public void theUserChecksForResidualPersonalizedDataPostOptOut() {
        checkForResidualData();
    }

    @Then("no personalized data is used or displayed")
    public void noPersonalizedDataIsUsedOrDisplayed() {
        verifyNoResidualData();
    }

    @When("the user experiences the system post opt-out")
    public void theUserExperiencesTheSystemPostOptOut() {
        experienceSystemPostOptOut();
    }

    @Then("user experience remains unaffected aside from recommendation changes")
    public void userExperienceRemainsUnaffectedAsideFromRecommendationChanges() {
        verifyUserExperience();
    }

    @Given("multiple users have opted out of personalized recommendations")
    public void multipleUsersHaveOptedOutOfPersonalizedRecommendations() {
        optOutMultipleUsers();
    }

    @When("the system performance is assessed")
    public void theSystemPerformanceIsAssessed() {
        assessSystemPerformance();
    }

    @Then("system performance remains stable regardless of opt-out volume")
    public void systemPerformanceRemainsStableRegardlessOfOptOutVolume() {
        verifySystemPerformance();
    }
}