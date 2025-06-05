import java.util.*;
import com.page_objects.AccountVerificationPage;

public class AccountVerificationSteps extends AccountVerificationPage {

    public AccountVerificationSteps() {
        super();
    }

    @Given("the customer is on the account verification page")
    public void theCustomerIsOnTheAccountVerificationPage() {
        navigateToAccountVerificationPage();
    }

    @When("the customer enters their account credentials")
    public void theCustomerEntersTheirAccountCredentials() {
        enterAccountCredentials();
    }

    @When("the customer enters incorrect account credentials")
    public void theCustomerEntersIncorrectAccountCredentials() {
        enterIncorrectAccountCredentials();
    }

    @When("clicks on the 'Verify Account' button")
    public void clicksOnTheVerifyAccountButton() {
        clickVerifyAccountButton();
    }

    @Then("the account verification is successful")
    public void theAccountVerificationIsSuccessful() {
        verifyAccountSuccess();
    }

    @Then("the account verification fails")
    public void theAccountVerificationFails() {
        verifyAccountFailure();
    }

    @Then("an error message is displayed indicating the account verification failed")
    public void anErrorMessageIsDisplayedIndicatingTheAccountVerificationFailed() {
        verifyErrorMessage();
    }

    @Then("the customer is redirected to their account details page")
    public void theCustomerIsRedirectedToTheirAccountDetailsPage() {
        verifyRedirectionToAccountDetailsPage();
    }

    @Then("the customer is not able to access their account details page")
    public void theCustomerIsNotAbleToAccessTheirAccountDetailsPage() {
        verifyNoAccessToAccountDetailsPage();
    }

    @Then("the account status is updated to 'Verified'")
    public void theAccountStatusIsUpdatedToVerified() {
        verifyAccountStatusUpdated();
    }

    @Then("the account status remains as 'Unverified'")
    public void theAccountStatusRemainsAsUnverified() {
        verifyAccountStatusUnchanged();
    }

    @Then("the customer can access account features")
    public void theCustomerCanAccessAccountFeatures() {
        verifyAccessToAccountFeatures();
    }

    @Then("the customer is able to logout from the account")
    public void theCustomerIsAbleToLogoutFromTheAccount() {
        logoutFromAccount();
    }
}