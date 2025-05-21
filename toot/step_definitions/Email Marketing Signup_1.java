public class EmailMarketingSignupSteps {

    WebDriver driver;
    MarketingSignupPage marketingSignupPage;

    @Given("the user is on the marketing signup page")
    public void userIsOnMarketingSignupPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://example.com/marketing-signup");
        marketingSignupPage = new MarketingSignupPage(driver);
    }

    @When("the user enters a valid email address")
    public void userEntersValidEmailAddress() {
        marketingSignupPage.enterEmail("valid.email@example.com");
    }

    @When("the user enters an invalid email address")
    public void userEntersInvalidEmailAddress() {
        marketingSignupPage.enterEmail("invalid-email");
    }

    @When("the user checks the opt-in checkbox for newsletters and promotions")
    public void userChecksOptInCheckbox() {
        marketingSignupPage.checkOptInCheckbox();
    }

    @When("the user does not check the opt-in checkbox for newsletters and promotions")
    public void userDoesNotCheckOptInCheckbox() {
        marketingSignupPage.uncheckOptInCheckbox();
    }

    @When("the user submits the signup form")
    public void userSubmitsSignupForm() {
        marketingSignupPage.submitForm();
    }

    @Then("the user should see a confirmation message stating that they have successfully signed up for email newsletters and promotions")
    public void userSeesConfirmationMessage() {
        Assert.assertTrue(marketingSignupPage.isConfirmationMessageDisplayed());
    }

    @Then("the user should see an error message indicating that the email address is invalid")
    public void userSeesErrorMessageForInvalidEmail() {
        Assert.assertTrue(marketingSignupPage.isErrorMessageDisplayed());
    }

    @Then("the user should see a message indicating that they need to opt-in to receive newsletters and promotions")
    public void userSeesOptInRequiredMessage() {
        Assert.assertTrue(marketingSignupPage.isOptInRequiredMessageDisplayed());
    }

    @Then("the user should see a message indicating that the email is already subscribed")
    public void userSeesAlreadySubscribedMessage() {
        Assert.assertTrue(marketingSignupPage.isAlreadySubscribedMessageDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}