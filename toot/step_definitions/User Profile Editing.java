public class UserProfileSteps {

    WebDriver driver;
    UserProfilePage userProfilePage;

    @Given("a user is logged into their account")
    public void userIsLoggedIn() {
        // Assume user is already logged in
    }

    @Given("the user is on their profile page")
    public void userIsOnProfilePage() {
        driver.get("http://example.com/profile");
        userProfilePage = new UserProfilePage(driver);
    }

    @When("the user clicks on the \"Edit Profile\" button")
    public void userClicksEditProfile() {
        userProfilePage.clickEditProfileButton();
    }

    @When("the user updates their personal information with valid data")
    public void userUpdatesInformationWithValidData() {
        userProfilePage.updateProfileInformation("John", "Doe", "john.doe@example.com");
    }

    @When("the user updates their personal information with invalid data")
    public void userUpdatesInformationWithInvalidData() {
        userProfilePage.updateProfileInformation("", "Doe", "invalid-email");
    }

    @When("the user updates their personal information")
    public void userUpdatesInformation() {
        userProfilePage.updateProfileInformation("John", "Doe", "john.doe@example.com");
    }

    @When("the user clicks on the \"Save\" button")
    public void userClicksSaveButton() {
        userProfilePage.clickSaveButton();
    }

    @When("the user clicks on the \"Cancel\" button")
    public void userClicksCancelButton() {
        userProfilePage.clickCancelButton();
    }

    @When("the user navigates to the \"Edit History\" section")
    public void userNavigatesToEditHistory() {
        userProfilePage.navigateToEditHistory();
    }

    @Then("the user's profile should be updated with the new information")
    public void profileShouldBeUpdated() {
        Assert.assertTrue(userProfilePage.isProfileUpdated());
    }

    @Then("a confirmation message should be displayed")
    public void confirmationMessageShouldBeDisplayed() {
        Assert.assertTrue(userProfilePage.isConfirmationMessageDisplayed());
    }

    @Then("the user's profile should not be updated")
    public void profileShouldNotBeUpdated() {
        Assert.assertFalse(userProfilePage.isProfileUpdated());
    }

    @Then("an error message should be displayed indicating the invalid fields")
    public void errorMessageShouldBeDisplayed() {
        Assert.assertTrue(userProfilePage.isErrorMessageDisplayed());
    }

    @Then("the user should be redirected back to the profile page without changes")
    public void userShouldBeRedirectedBack() {
        Assert.assertTrue(userProfilePage.isRedirectedToProfilePage());
    }

    @Then("the user should see a list of previous changes made to their profile")
    public void userShouldSeeEditHistory() {
        Assert.assertTrue(userProfilePage.isEditHistoryDisplayed());
    }

    @Then("each entry should include the date and time of the change")
    public void eachEntryShouldIncludeDateAndTime() {
        Assert.assertTrue(userProfilePage.isEditHistoryDateAndTimeDisplayed());
    }

    @Then("the user's profile should remain unchanged")
    public void profileShouldRemainUnchanged() {
        Assert.assertTrue(userProfilePage.isProfileUnchanged());
    }

    @Then("a message should be displayed indicating no changes were made")
    public void noChangesMessageShouldBeDisplayed() {
        Assert.assertTrue(userProfilePage.isNoChangesMessageDisplayed());
    }
}