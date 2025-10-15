package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.SAPFieldCatalogPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPFieldCatalogSteps extends SAPFieldCatalogPage {

    @Given("user has appropriate credentials")
    public void userHasAppropriateCredentials() {
        navigateToLoginPage();
        enterCredentials("validUsername", "validPassword");
    }

    @When("user logs in to the SAP S/4 HANA system")
    public void userLogsInToTheSAPSystem() {
        clickLoginButton();
    }

    @Then("user is successfully logged in to the system")
    public void userIsSuccessfullyLoggedInToTheSystem() {
        verifySuccessfulLogin();
    }

    @Given("user is logged in to the SAP S/4 HANA system")
    public void userIsLoggedInToTheSAPSystem() {
        navigateToHomePage();
    }

    @When("user navigates to the configuration screen for billing output determination")
    public void userNavigatesToConfigurationScreen() {
        navigateToConfigurationScreen();
    }

    @Then("the configuration screen for billing output determination is displayed")
    public void configurationScreenIsDisplayed() {
        verifyConfigurationScreenDisplayed();
    }

    @Given("user is on the configuration screen for billing output determination")
    public void userIsOnConfigurationScreen() {
        verifyConfigurationScreenDisplayed();
    }

    @When("user accesses the field catalog settings")
    public void userAccessesFieldCatalogSettings() {
        navigateToFieldCatalogSettings();
    }

    @Then("field catalog settings are accessible")
    public void fieldCatalogSettingsAreAccessible() {
        verifyFieldCatalogSettingsAccessible();
    }

    @Given("user is in the field catalog settings")
    public void userIsInFieldCatalogSettings() {
        verifyFieldCatalogSettingsAccessible();
    }

    @When("user searches for Attribute 7 in the field catalog list")
    public void userSearchesForAttribute7() {
        searchForAttribute("Attribute 7");
    }

    @Then("Attribute 7 is not visible in the field catalog list")
    public void attribute7IsNotVisible() {
        verifyAttributeNotVisible("Attribute 7");
    }

    @When("user attempts to configure an output determination rule using Attribute 7")
    public void userAttemptsToConfigureRuleUsingAttribute7() {
        attemptToConfigureRuleUsingAttribute("Attribute 7");
    }

    @Then("system throws an error indicating the absence of Attribute 7 in the field catalog")
    public void systemThrowsErrorForAttribute7Absence() {
        verifyErrorForAttributeAbsence("Attribute 7");
    }

    @Given("user has made configuration changes")
    public void userHasMadeConfigurationChanges() {
        makeConfigurationChanges();
    }

    @When("user attempts to save the configuration changes")
    public void userAttemptsToSaveChanges() {
        attemptToSaveChanges();
    }

    @Then("system prevents saving and displays an error message")
    public void systemPreventsSavingChanges() {
        verifyErrorOnSaveAttempt();
    }

    @Given("user has completed their actions in the system")
    public void userHasCompletedActions() {
        navigateToHomePage();
    }

    @When("user logs out of the system")
    public void userLogsOutOfSystem() {
        clickLogoutButton();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifySuccessfulLogout();
    }
}