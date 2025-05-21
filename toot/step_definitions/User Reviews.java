import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class UserReviewsStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    public UserReviewsStepDefinitions() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userIsLoggedIntoTheirAccount() {
        driver.get("http://example.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("testuser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SecurePassword123");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Login failed - Dashboard not found", dashboardElement.isDisplayed());
    }

    public void userHasCompletedAPurchase() {
        driver.get("http://example.com/order-history");
        WebElement completedPurchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("completed_purchase")));
        Assert.assertTrue("No completed purchase found", completedPurchase.isDisplayed());
    }

    public void userNavigatesToOrderHistoryPage() {
        driver.get("http://example.com/order-history");
    }

    public void userSelectsACompletedPurchase() {
        WebElement completedPurchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("completed_purchase")));
        completedPurchase.click();
    }

    public void userClicksOnLeaveAReview() {
        WebElement leaveReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("leave_review_button")));
        leaveReviewButton.click();
    }

    public void userShouldBePresentedWithAReviewForm() {
        WebElement reviewForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("review_form")));
        Assert.assertTrue("Review form not displayed", reviewForm.isDisplayed());
    }

    public void userEntersARatingBetween1And5Stars() {
        WebElement ratingField = driver.findElement(By.id("rating"));
        ratingField.sendKeys("5");
    }

    public void userWritesACommentInTheFeedbackSection() {
        WebElement feedbackField = driver.findElement(By.id("feedback"));
        feedbackField.sendKeys("Great product!");
    }

    public void userSubmitsTheReview() {
        WebElement submitReviewButton = driver.findElement(By.id("submit_review_button"));
        submitReviewButton.click();
    }

    public void reviewShouldBeSavedAndDisplayedUnderTheProduct() {
        WebElement reviewConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("review_confirmation")));
        Assert.assertTrue("Review not saved", reviewConfirmation.isDisplayed());
    }

    public void userHasAlreadySubmittedAReviewForAProduct() {
        driver.get("http://example.com/product-page");
        WebElement existingReview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("existing_review")));
        Assert.assertTrue("No existing review found", existingReview.isDisplayed());
    }

    public void userNavigatesToTheProductPage() {
        driver.get("http://example.com/product-page");
    }

    public void userClicksOnEditReview() {
        WebElement editReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit_review_button")));
        editReviewButton.click();
    }

    public void userShouldBeAbleToModifyTheRatingAndFeedback() {
        WebElement ratingField = driver.findElement(By.id("rating"));
        WebElement feedbackField = driver.findElement(By.id("feedback"));
        Assert.assertTrue("Rating field not editable", ratingField.isEnabled());
        Assert.assertTrue("Feedback field not editable", feedbackField.isEnabled());
    }

    public void userSubmitsTheUpdatedReview() {
        WebElement submitReviewButton = driver.findElement(By.id("submit_review_button"));
        submitReviewButton.click();
    }

    public void updatedReviewShouldReplaceThePreviousReview() {
        WebElement updatedReviewConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updated_review_confirmation")));
        Assert.assertTrue("Updated review not saved", updatedReviewConfirmation.isDisplayed());
    }

    public void userClicksOnDeleteReview() {
        WebElement deleteReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete_review_button")));
        deleteReviewButton.click();
    }

    public void userShouldBePromptedToConfirmTheDeletion() {
        WebElement confirmDeletionPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm_deletion_prompt")));
        Assert.assertTrue("Deletion prompt not displayed", confirmDeletionPrompt.isDisplayed());
    }

    public void userConfirmsTheDeletion() {
        WebElement confirmDeletionButton = driver.findElement(By.id("confirm_deletion_button"));
        confirmDeletionButton.click();
    }

    public void reviewShouldBeRemovedFromTheProductPage() {
        WebElement reviewRemovedConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("review_removed_confirmation")));
        Assert.assertTrue("Review not removed", reviewRemovedConfirmation.isDisplayed());
    }

    public void userIsOnAProductPage() {
        driver.get("http://example.com/product-page");
    }

    public void productHasExistingReviews() {
        WebElement existingReviews = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("existing_reviews")));
        Assert.assertTrue("No existing reviews found", existingReviews.isDisplayed());
    }

    public void userShouldBeAbleToSeeTheAverageRating() {
        WebElement averageRating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("average_rating")));
        Assert.assertTrue("Average rating not displayed", averageRating.isDisplayed());
    }

    public void userShouldBeAbleToReadIndividualReviews() {
        WebElement individualReviews = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("individual_reviews")));
        Assert.assertTrue("Individual reviews not displayed", individualReviews.isDisplayed());
    }

    public void userIsBrowsingAProductPage() {
        driver.get("http://example.com/product-page");
    }

    public void userTriesToLeaveAReviewWithoutPurchasingTheProduct() {
        WebElement leaveReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("leave_review_button")));
        leaveReviewButton.click();
    }

    public void userShouldBeNotifiedThatOnlyVerifiedPurchasersCanLeaveReviews() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("purchase_verification_notification")));
        Assert.assertTrue("Notification not displayed", notification.isDisplayed());
    }
}