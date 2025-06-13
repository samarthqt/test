package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class UserLogoutSteps extends LogoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user clicks on \"LogOut\" in the top menu")
    public void theUserClicksOnLogOutInTheTopMenu() {
        clickLogout();
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        verifyRedirectionToLoginPage();
    }

    @Then("the user session should be terminated")
    public void theUserSessionShouldBeTerminated() {
        verifySessionTermination();
    }

    @When("the user tries to access a secured page")
    public void theUserTriesToAccessASecuredPage() {
        attemptAccessSecuredPage();
    }

    @Then("any further requests should not be authenticated")
    public void anyFurtherRequestsShouldNotBeAuthenticated() {
        verifyNoAuthenticationForFurtherRequests();
    }
}

