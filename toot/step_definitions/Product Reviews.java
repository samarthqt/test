import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class ProductReviewsStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    ProductPage productPage;

    public ProductReviewsStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.productPage = new ProductPage(driver);
    }

    public void givenUserIsOnProductPage() {
        driver.get("http://example.com/product");
    }

    public void givenUserIsLoggedIn() {
        // Assume user is already logged in
    }

    public void whenUserNavigatesToProductReviewsSection() {
        productPage.navigateToReviewsSection();
    }

    public void whenUserClicksOnWriteAReview() {
        productPage.clickWriteReview();
    }

    public void whenUserEntersReviewTitle(String title) {
        productPage.enterReviewTitle(title);
    }

    public void whenUserEntersReviewDescription(String description) {
        productPage.enterReviewDescription(description);
    }

    public void whenUserSelectsRating(int stars) {
        productPage.selectRating(stars);
    }

    public void whenUserSubmitsReview() {
        productPage.submitReview();
    }

    public void thenReviewShouldBeSuccessfullySubmitted() {
        Assert.assertTrue(productPage.isReviewSubmitted());
    }

    public void thenReviewShouldBeVisibleUnderProductReviewsSection() {
        Assert.assertTrue(productPage.isReviewVisible());
    }

    public void thenUserShouldSeeListOfReviews() {
        Assert.assertTrue(productPage.isReviewListVisible());
    }

    public void thenEachReviewShouldDisplayDetails() {
        Assert.assertTrue(productPage.areReviewDetailsVisible());
    }

    public void givenUserIsNotLoggedIn() {
        // Assume user is not logged in
    }

    public void whenUserAttemptsToWriteAReview() {
        productPage.attemptToWriteReview();
    }

    public void thenUserShouldBePromptedToLogInOrRegister() {
        Assert.assertTrue(productPage.isLoginPromptVisible());
    }

    public void whenUserLeavesReviewDescriptionEmpty() {
        productPage.leaveReviewDescriptionEmpty();
    }

    public void thenUserShouldSeeErrorMessageForMissingDescription() {
        Assert.assertTrue(productPage.isErrorMessageVisible());
    }
}