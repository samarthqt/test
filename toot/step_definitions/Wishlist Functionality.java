import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class WishlistStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    WishlistPage wishlistPage;

    @Given("I am logged into my user account")
    public void iAmLoggedIntoMyUserAccount() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("testuser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
        wishlistPage = new WishlistPage(driver);
    }

    @Given("I am on a product page")
    public void iAmOnAProductPage() {
        driver.get("http://example.com/product");
    }

    @When("I click on the \"Add to Wishlist\" button")
    public void iClickOnTheAddToWishlistButton() {
        wishlistPage.clickAddToWishlist();
    }

    @Then("the product should be added to my wishlist")
    public void theProductShouldBeAddedToMyWishlist() {
        Assert.assertTrue("Product not added to wishlist", wishlistPage.isProductInWishlist());
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        Assert.assertTrue("Confirmation message not displayed", wishlistPage.isConfirmationMessageDisplayed());
    }

    @When("I navigate to the wishlist page")
    public void iNavigateToTheWishlistPage() {
        wishlistPage.navigateToWishlistPage();
    }

    @Then("I should see a list of all products I have added to my wishlist")
    public void iShouldSeeAListOfAllProductsIHaveAddedToMyWishlist() {
        Assert.assertTrue("Wishlist is empty", wishlistPage.isWishlistNotEmpty());
    }

    @Given("I have products in my wishlist")
    public void iHaveProductsInMyWishlist() {
        wishlistPage.ensureProductInWishlist();
    }

    @When("I click on the \"Remove\" button next to a product")
    public void iClickOnTheRemoveButtonNextToAProduct() {
        wishlistPage.clickRemoveFromWishlist();
    }

    @Then("the product should be removed from my wishlist")
    public void theProductShouldBeRemovedFromMyWishlist() {
        Assert.assertFalse("Product not removed from wishlist", wishlistPage.isProductInWishlist());
    }

    @Given("I am not logged into my user account")
    public void iAmNotLoggedIntoMyUserAccount() {
        driver.get("http://example.com/logout");
    }

    @When("I attempt to add a product to the wishlist")
    public void iAttemptToAddAProductToTheWishlist() {
        wishlistPage.clickAddToWishlist();
    }

    @Then("I should be prompted to log in or create an account")
    public void iShouldBePromptedToLogInOrCreateAnAccount() {
        Assert.assertTrue("Login prompt not displayed", wishlistPage.isLoginPromptDisplayed());
    }

    @When("I log out and then log back into my account")
    public void iLogOutAndThenLogBackIntoMyAccount() {
        driver.get("http://example.com/logout");
        iAmLoggedIntoMyUserAccount();
    }

    @Then("I should see all previously added products still in my wishlist")
    public void iShouldSeeAllPreviouslyAddedProductsStillInMyWishlist() {
        Assert.assertTrue("Wishlist does not persist", wishlistPage.isWishlistNotEmpty());
    }

    @Given("I have a product already in my wishlist")
    public void iHaveAProductAlreadyInMyWishlist() {
        wishlistPage.ensureProductInWishlist();
    }

    @When("I attempt to add the same product to my wishlist again")
    public void iAttemptToAddTheSameProductToMyWishlistAgain() {
        wishlistPage.clickAddToWishlist();
    }

    @Then("I should not see duplicate entries in my wishlist")
    public void iShouldNotSeeDuplicateEntriesInMyWishlist() {
        Assert.assertFalse("Duplicate entries found", wishlistPage.hasDuplicateEntries());
    }

    @Then("I should see a message indicating the product is already in the wishlist")
    public void iShouldSeeAMessageIndicatingTheProductIsAlreadyInTheWishlist() {
        Assert.assertTrue("Duplicate message not displayed", wishlistPage.isDuplicateMessageDisplayed());
    }
}