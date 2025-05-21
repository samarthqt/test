import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoyaltyProgramSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoyaltyProgramPage loyaltyProgramPage;

    public LoyaltyProgramSteps() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        this.loyaltyProgramPage = new LoyaltyProgramPage(driver);
    }

    @Given("the user is logged into their account")
    public void userIsLoggedIn() {
        // Assume user is already logged in
    }

    @Given("the user is on the User Account page")
    public void userOnAccountPage() {
        driver.get("http://example.com/account");
    }

    @When("the user opts to join the Loyalty Program")
    public void userJoinsLoyaltyProgram() {
        loyaltyProgramPage.clickJoinLoyaltyProgram();
    }

    @Then("the user should be successfully enrolled in the Loyalty Program")
    public void userEnrolledInLoyaltyProgram() {
        Assert.assertTrue(loyaltyProgramPage.isEnrolled());
    }

    @Then("the user should receive a confirmation message")
    public void userReceivesConfirmationMessage() {
        Assert.assertTrue(loyaltyProgramPage.isConfirmationMessageDisplayed());
    }

    @Given("the user is enrolled in the Loyalty Program")
    public void userIsEnrolled() {
        Assert.assertTrue(loyaltyProgramPage.isEnrolled());
    }

    @When("the user makes a purchase")
    public void userMakesPurchase() {
        loyaltyProgramPage.makePurchase();
    }

    @Then("the user should earn loyalty points for the purchase")
    public void userEarnsPoints() {
        Assert.assertTrue(loyaltyProgramPage.arePointsEarned());
    }

    @Then("the points should be reflected in the user's account")
    public void pointsReflectedInAccount() {
        Assert.assertTrue(loyaltyProgramPage.arePointsReflected());
    }

    @Given("the user has accumulated loyalty points")
    public void userHasPoints() {
        Assert.assertTrue(loyaltyProgramPage.hasAccumulatedPoints());
    }

    @When("the user chooses to redeem points for a discount")
    public void userRedeemsPoints() {
        loyaltyProgramPage.redeemPoints();
    }

    @Then("the discount should be applied to the user's purchase")
    public void discountApplied() {
        Assert.assertTrue(loyaltyProgramPage.isDiscountApplied());
    }

    @Then("the redeemed points should be deducted from the user's account")
    public void pointsDeducted() {
        Assert.assertTrue(loyaltyProgramPage.arePointsDeducted());
    }

    @When("the user navigates to the Loyalty section of their account")
    public void userNavigatesToLoyaltySection() {
        loyaltyProgramPage.navigateToLoyaltySection();
    }

    @Then("the user should see their current loyalty points balance")
    public void userSeesPointsBalance() {
        Assert.assertTrue(loyaltyProgramPage.isPointsBalanceDisplayed());
    }

    @When("there are new rewards or discounts available")
    public void newRewardsAvailable() {
        loyaltyProgramPage.checkForNewRewards();
    }

    @Then("the user should receive a notification about the new offers")
    public void userReceivesNotification() {
        Assert.assertTrue(loyaltyProgramPage.isNotificationReceived());
    }

    @When("the user opts to leave the Loyalty Program")
    public void userLeavesLoyaltyProgram() {
        loyaltyProgramPage.leaveLoyaltyProgram();
    }

    @Then("the user should be successfully unenrolled from the Loyalty Program")
    public void userUnenrolled() {
        Assert.assertTrue(loyaltyProgramPage.isUnenrolled());
    }
}