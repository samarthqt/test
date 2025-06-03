package com.cucumber.steps;

import com.framework.components.Settings;
import com.framework.cucumber.TestHarness;
import com.framework.reusable.ApiResuableComponents;
import com.pageobjects.DemoTestPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;


public class DemoTestWebSteps extends DemoTestPage  {
    protected TestHarness testHarness = new TestHarness();
    protected Properties properties = Settings.getInstance();

    @Given("I am on the OpenMRS login page using {string}")
    public void launch_Application(String tcid) {
        String url = properties.getProperty("ApplicationUrl");
        testHarness.initializeTestData(tcid);
        launchApp(url);
    }

    @When("I enter Username {string}")
    public void iEnterUsername(String user_id) {
        enterUserNameTxt(user_id);

    }

    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        clickContinueBtn();

    }

    @When("I enter valid credentials")
    public void userEntersPasswordForUser() {
        String username = testHarness.getData("General_Data", "userName");
        String password = testHarness.getData("General_Data", "password");
        enterUserNameTxt(username);
        clickContinueBtn();
        enterPasswordTxt(password);
    }

    @And("I click on LogIn button")
    public void iClickOnLogInButton() {
        clickLogInBtn();
    }


    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        checkAndPerformActions();
    }

    @When("I navigate to the user administration section")
    public void iNavigateToTheUserAdministrationSection() {
        clickOnAppMenu();
        clickOnSystemAdministration();
        clickOnLegacyAdmin();
        clickOnManageUsers();
        clickOnAddUser();
        clickOnNextBtn();
    }

    @Then("User able to see the User form")
    public void userAbleToSeeTheUserForm() {
        isFormDisplayedInUserPage();
    }

    @When("User enters valid details for creating the user account")
    public void userEntersValidDetailsForCreatingTheUserAccount() {
        enterGivenNameWithRandomNumber();
        clickOnGender();
        enterUserPasswordTxt("QTtest1234");
        enterConfirmUserPasswordTxt("QTtest1234");

    }

    @And("I click on Submit button")
    public void iClickOnSubmitButton() {
        clickOnSaveUser();
//        isUserSavedTxtDisplayed();
    }


    @Then("Confirmation message should displayed in the User Section")
    public void confirmationMessageShouldDisplayedInTheUserSection() {
        isUserSavedTxtDisplayed();
    }
}