package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateMobileNumberSteps extends UpdateMobileNumberPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to their email account")
    public void theUserHasAccessToTheirEmailAccount() {
        loginToEmailAccount();
    }

    @Given("the user receives an email with the subject \"Update Your Mobile Number\" at user@example.com")
    public void theUserReceivesAnEmailWithSubject() {
        verifyEmailReceived("Update Your Mobile Number", "user@example.com");
    }

    @When("the user opens the email client")
    public void theUserOpensTheEmailClient() {
        openEmailClient();
    }

    @When("the user locates the email in the inbox")
    public void theUserLocatesTheEmailInTheInbox() {
        locateEmailInInbox("Update Your Mobile Number");
    }

    @When("the user opens the email to view its contents")
    public void theUserOpensTheEmailToViewItsContents() {
        openEmail();
    }

    @Then("the email content is displayed with a link to update the mobile number")
    public void theEmailContentIsDisplayedWithLink() {
        verifyEmailContentWithLink();
    }

    @When("the user clicks on the link provided in the email")
    public void theUserClicksOnTheLinkProvidedInTheEmail() {
        clickOnUpdateLink();
    }

    @Then("the browser opens and starts loading the 'Update Mobile Number' page")
    public void theBrowserOpensAndStartsLoadingThePage() {
        verifyPageLoading();
    }

    @Then("the correct URL \"https://example.com/update-number\" is displayed in the browser's address bar")
    public void theCorrectURLIsDisplayed() {
        verifyURL("https://example.com/update-number");
    }

    @Then("the page title is \"Update Mobile Number\"")
    public void thePageTitleIs() {
        verifyPageTitle("Update Mobile Number");
    }

    @Then("there is a form to update the mobile number present on the page")
    public void thereIsAFormToUpdateMobileNumber() {
        verifyFormPresence();
    }

    @Then("the form fields for entering the new mobile number are available and editable")
    public void theFormFieldsAreAvailableAndEditable() {
        verifyFormFieldsEditable();
    }

    @Then("there is a 'Submit' button visible and clickable on the form")
    public void thereIsASubmitButtonVisibleAndClickable() {
        verifySubmitButton();
    }

    @Then("instructions or help text related to updating the mobile number is displayed")
    public void instructionsOrHelpTextIsDisplayed() {
        verifyHelpText();
    }

    @When("the user attempts to navigate away from the page and return using the browser's back button")
    public void theUserAttemptsToNavigateAwayAndReturn() {
        navigateAwayAndReturn();
    }

    @Then("the user is able to return to the 'Update Mobile Number' page without issues")
    public void theUserIsAbleToReturnToThePage() {
        verifyReturnToPage();
    }

    @Then("the page is responsive on different devices and screen sizes")
    public void thePageIsResponsive() {
        verifyPageResponsiveness();
    }

    @Then("no security warnings or certificate issues are present in the browser")
    public void noSecurityWarningsOrCertificateIssues() {
        verifyNoSecurityWarnings();
    }

    @Then("the page loads quickly and efficiently")
    public void thePageLoadsQuicklyAndEfficiently() {
        verifyPageLoadSpeed();
    }

    @When("the user attempts to refresh the page")
    public void theUserAttemptsToRefreshThePage() {
        refreshPage();
    }

    @Then("the page refreshes and reloads without errors")
    public void thePageRefreshesAndReloadsWithoutErrors() {
        verifyPageRefresh();
    }

    @When("the user logs out and logs back into the email account")
    public void theUserLogsOutAndLogsBackIntoEmailAccount() {
        logoutAndLoginEmailAccount();
    }

    @Then("the link remains valid and directs to the correct page after logging back in")
    public void theLinkRemainsValid() {
        verifyLinkValidityAfterLogin();
    }
}