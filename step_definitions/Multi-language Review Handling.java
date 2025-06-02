package com.cucumber.steps;

import com.page_objects.ReviewPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReviewSteps extends ReviewPage {

    @Given("the system supports multiple languages")
    public void theSystemSupportsMultipleLanguages() {
        verifyLanguageSupport();
    }

    @When("a review is submitted in Spanish with content 'Producto excelente!'")
    public void aReviewIsSubmittedInSpanish() {
        submitReview("Spanish", "Producto excelente!");
    }

    @Then("the review is accepted and displayed correctly in Spanish")
    public void theReviewIsAcceptedAndDisplayedCorrectlyInSpanish() {
        verifyReviewDisplay("Spanish", "Producto excelente!");
    }

    @When("a review is submitted in French with content 'Produit exceptionnel!'")
    public void aReviewIsSubmittedInFrench() {
        submitReview("French", "Produit exceptionnel!");
    }

    @Then("the review is accepted and displayed correctly in French")
    public void theReviewIsAcceptedAndDisplayedCorrectlyInFrench() {
        verifyReviewDisplay("French", "Produit exceptionnel!");
    }

    @When("a review is submitted in Italian with content 'Ottimo prodotto!'")
    public void aReviewIsSubmittedInItalian() {
        submitReview("Italian", "Ottimo prodotto!");
    }

    @Then("the review is accepted and displayed correctly in Italian")
    public void theReviewIsAcceptedAndDisplayedCorrectlyInItalian() {
        verifyReviewDisplay("Italian", "Ottimo prodotto!");
    }

    @Given("admin credentials are 'admin_user' and 'secure_password'")
    public void adminCredentialsAreProvided() {
        setAdminCredentials("admin_user", "secure_password");
    }

    @When("the admin navigates to the dashboard")
    public void theAdminNavigatesToTheDashboard() {
        navigateToDashboard();
    }

    @Then("reviews are listed with language indicators")
    public void reviewsAreListedWithLanguageIndicators() {
        verifyReviewsListedWithLanguageIndicators();
    }

    @Given("the admin is on the review moderation page")
    public void theAdminIsOnTheReviewModerationPage() {
        navigateToReviewModerationPage();
    }

    @When("the admin approves a review submitted in Spanish")
    public void theAdminApprovesAReviewSubmittedInSpanish() {
        approveReview("Spanish");
    }

    @Then("the review status changes to 'Approved' and is visible to users")
    public void theReviewStatusChangesToApproved() {
        verifyReviewStatus("Approved");
    }

    @When("the admin edits a review submitted in French")
    public void theAdminEditsAReviewSubmittedInFrench() {
        editReview("French");
    }

    @Then("the review content is updated successfully")
    public void theReviewContentIsUpdatedSuccessfully() {
        verifyReviewContentUpdated();
    }

    @When("the admin deletes a review submitted in Italian")
    public void theAdminDeletesAReviewSubmittedInItalian() {
        deleteReview("Italian");
    }

    @Then("the review is removed from the system and no longer visible")
    public void theReviewIsRemovedFromTheSystem() {
        verifyReviewRemoved();
    }

    @When("a review with inappropriate content is submitted")
    public void aReviewWithInappropriateContentIsSubmitted() {
        submitInappropriateReview();
    }

    @Then("the system flags inappropriate content regardless of language")
    public void theSystemFlagsInappropriateContent() {
        verifyInappropriateContentFlagged();
    }

    @When("reviews are submitted simultaneously in different languages")
    public void reviewsAreSubmittedSimultaneously() {
        submitSimultaneousReviews();
    }

    @Then("the system processes and displays reviews without errors")
    public void theSystemProcessesReviewsWithoutErrors() {
        verifyReviewsProcessedWithoutErrors();
    }

    @Given("the admin is logged in")
    public void theAdminIsLoggedIn() {
        verifyAdminLoggedIn();
    }

    @When("the admin logs out")
    public void theAdminLogsOut() {
        adminLogout();
    }

    @Then("the admin is redirected to the login page")
    public void theAdminIsRedirectedToLoginPage() {
        verifyRedirectedToLoginPage();
    }

    @Given("the admin is on the login page")
    public void theAdminIsOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the admin logs back in")
    public void theAdminLogsBackIn() {
        adminLogin();
    }

    @Then("the admin can access multilingual reviews with updated list")
    public void theAdminCanAccessMultilingualReviews() {
        verifyAccessToMultilingualReviews();
    }

    @When("a review is submitted in an unsupported language")
    public void aReviewIsSubmittedInUnsupportedLanguage() {
        submitUnsupportedLanguageReview();
    }

    @Then("the system displays an error message indicating unsupported language")
    public void theSystemDisplaysUnsupportedLanguageError() {
        verifyUnsupportedLanguageError();
    }

    @When("a mixed-language review is submitted")
    public void aMixedLanguageReviewIsSubmitted() {
        submitMixedLanguageReview();
    }

    @Then("the system processes mixed-language reviews correctly")
    public void theSystemProcessesMixedLanguageReviewsCorrectly() {
        verifyMixedLanguageReviewProcessing();
    }

    @When("a review with language-specific characters is submitted")
    public void aReviewWithLanguageSpecificCharactersIsSubmitted() {
        submitReviewWithLanguageSpecificCharacters();
    }

    @Then("all characters are displayed correctly without encoding issues")
    public void allCharactersAreDisplayedCorrectly() {
        verifyCharacterDisplay();
    }

    @When("the admin filters reviews by language")
    public void theAdminFiltersReviewsByLanguage() {
        filterReviewsByLanguage();
    }

    @Then("the admin can view reviews based on language selection")
    public void theAdminCanViewReviewsBasedOnLanguageSelection() {
        verifyFilteredReviewsDisplay();
    }
}