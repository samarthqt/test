package com.cucumber.steps;

import com.page_objects.HelpCenterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelpCenterSteps extends HelpCenterPage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginUser();
    }

    @Given("the user is on the Help Center page")
    public void theUserIsOnTheHelpCenterPage() {
        navigateToHelpCenter();
    }

    @Given("the network condition is {string}")
    public void theNetworkConditionIs(String networkType) {
        setNetworkCondition(networkType);
    }

    @Given("the user has selected a language")
    public void theUserHasSelectedALanguage() {
        selectLanguage("English");
    }

    @When("the user navigates to the Help Center page")
    public void theUserNavigatesToTheHelpCenterPage() {
        navigateToHelpCenter();
    }

    @When("the user selects {string} from the language options")
    public void theUserSelectsFromTheLanguageOptions(String language) {
        selectLanguage(language);
    }

    @When("the user loads Help Center content")
    public void theUserLoadsHelpCenterContent() {
        loadHelpCenterContent();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutUser();
        loginUser();
    }

    @When("the user tests accessibility features in different languages")
    public void theUserTestsAccessibilityFeaturesInDifferentLanguages() {
        testAccessibilityFeatures();
    }

    @When("the user reviews the language translations")
    public void theUserReviewsTheLanguageTranslations() {
        reviewTranslations();
    }

    @When("the user tests responsiveness in different languages")
    public void theUserTestsResponsivenessInDifferentLanguages() {
        testResponsiveness();
    }

    @When("the user checks content synchronization across languages")
    public void theUserChecksContentSynchronizationAcrossLanguages() {
        checkContentSynchronization();
    }

    @When("the user selects an unsupported language")
    public void theUserSelectsAnUnsupportedLanguage() {
        selectUnsupportedLanguage();
    }

    @When("the user's session expires")
    public void theUserSessionExpires() {
        expireSession();
    }

    @Then("the Help Center page is displayed")
    public void theHelpCenterPageIsDisplayed() {
        verifyHelpCenterPageDisplayed();
    }

    @Then("the Help Center content is displayed in {string}")
    public void theHelpCenterContentIsDisplayedIn(String language) {
        verifyContentLanguage(language);
    }

    @Then("the Help Center content loads within acceptable time limits")
    public void theHelpCenterContentLoadsWithinAcceptableTimeLimits() {
        verifyContentLoadTime();
    }

    @Then("the selected language persists across user sessions")
    public void theSelectedLanguagePersistsAcrossUserSessions() {
        verifyLanguagePersistence();
    }

    @Then("the accessibility features are functional in all languages")
    public void theAccessibilityFeaturesAreFunctionalInAllLanguages() {
        verifyAccessibilityFeatures();
    }

    @Then("the translations are accurate and error-free")
    public void theTranslationsAreAccurateAndErrorFree() {
        verifyTranslationsAccuracy();
    }

    @Then("the Help Center is responsive in all languages")
    public void theHelpCenterIsResponsiveInAllLanguages() {
        verifyResponsiveness();
    }

    @Then("the content is synchronized and consistent across languages")
    public void theContentIsSynchronizedAndConsistentAcrossLanguages() {
        verifyContentSynchronization();
    }

    @Then("the system displays an error message for unsupported language")
    public void theSystemDisplaysAnErrorMessageForUnsupportedLanguage() {
        verifyUnsupportedLanguageError();
    }

    @Then("the system prompts the user to re-login and select language again")
    public void theSystemPromptsTheUserToReLoginAndSelectLanguageAgain() {
        verifyReLoginPrompt();
    }
}