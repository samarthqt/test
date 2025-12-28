package com.cucumber.steps;

import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.BillingDetailReportPage;
import com.pageobjects.PeriodicBillingPage;
import com.pageobjects.SAPLoginPage;
import com.pageobjects.SAPPage;
import com.pageobjects.VA01Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPSteps {

    private SAPLoginPage sapLoginPage = new SAPLoginPage();
    private SAPPage sapPage = new SAPPage();
    private VA01Page va01Page = new VA01Page();
    private BillingDetailReportPage billingDetailReportPage = new BillingDetailReportPage();
    private PeriodicBillingPage periodicBillingPage = new PeriodicBillingPage();
    private TestHarness testHarness = new TestHarness();

    @Given("user navigates to the SAP login page")
    public void userNavigatesToTheSAPLoginPage() {
        sapLoginPage.navigateToSAPLoginPage();
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        String username = "validUsername";
        String password = "validPassword";
        sapLoginPage.enterCredentials(username, password);
    }

    @Then("user is successfully logged into the SAP system")
    public void userIsSuccessfullyLoggedIntoTheSAPSystem() {
        sapLoginPage.verifySuccessfulLogin();
    }

    @Given("user is logged into the SAP system")
    public void userIsLoggedIntoTheSAPSystem() {
        sapLoginPage.verifySuccessfulLogin();
    }

    @When("user navigates to transaction VA01")
    public void userNavigatesToTransactionVA01() {
        va01Page.navigateToVA01();
    }

    @Then("the VA01 transaction screen is displayed")
    public void theVA01TransactionScreenIsDisplayed() {
        va01Page.verifyVA01ScreenDisplayed();
    }

    @Given("user is on the VA01 transaction screen")
    public void userIsOnTheVA01TransactionScreen() {
        va01Page.verifyVA01ScreenDisplayed();
    }

    @When("user enters the original Billing document number {string} as the reference")
    public void userEntersTheOriginalBillingDocumentNumberAsTheReference(String billingDocumentNumber) {
        va01Page.enterBillingDocumentNumber(billingDocumentNumber);
    }

    @Then("the Billing document details are retrieved successfully")
    public void theBillingDocumentDetailsAreRetrievedSuccessfully() {
        va01Page.verifyBillingDocumentDetailsRetrieved();
    }

    @Then("the header partner data includes complete data for Sold-to, Bill-to, Payer, and Ship-to")
    public void theHeaderPartnerDataIncludesCompleteData() {
        va01Page.verifyHeaderPartnerData();
    }

    @When("user navigates to the periodic billing document processing transaction")
    public void userNavigatesToThePeriodicBillingDocumentProcessingTransaction() {
        periodicBillingPage.navigateToPeriodicBillingPage();
    }

    @Then("the periodic billing document processing screen is displayed")
    public void thePeriodicBillingDocumentProcessingScreenIsDisplayed() {
        periodicBillingPage.verifyPeriodicBillingPageDisplayed();
    }

    @Given("user is on the periodic billing document processing screen")
    public void userIsOnThePeriodicBillingDocumentProcessingScreen() {
        periodicBillingPage.verifyPeriodicBillingPageDisplayed();
    }

    @When("user enters the ZFR document ID {string} in the input field")
    public void userEntersTheZFRDocumentIDInTheInputField(String zfrDocumentId) {
        periodicBillingPage.enterZFRDocumentID(zfrDocumentId);
    }

    @When("user triggers the output processing for the selected ZFR document")
    public void userTriggersTheOutputProcessingForTheSelectedZFRDocument() {
        periodicBillingPage.triggerOutputProcessing();
    }

    @Then("the system generates the ZPB1 output for the ZFR document")
    public void theSystemGeneratesTheZPB1OutputForTheZFRDocument() {
        periodicBillingPage.verifyZPB1OutputGenerated();
    }

    @When("user navigates to the 'display billing detail' report")
    public void userNavigatesToTheDisplayBillingDetailReport() {
        billingDetailReportPage.navigateToBillingDetailReport();
    }

    @Then("the 'display billing detail' report screen is displayed")
    public void theDisplayBillingDetailReportScreenIsDisplayed() {
        billingDetailReportPage.verifyBillingDetailReportScreen();
    }

    @When("user reviews the report")
    public void userReviewsTheReport() {
        billingDetailReportPage.reviewReport();
    }

    @Then("the referenced sales orders are displayed correctly in the report")
    public void theReferencedSalesOrdersAreDisplayedCorrectlyInTheReport() {
        billingDetailReportPage.verifyReferencedSalesOrders();
    }

    @When("user logs out of the SAP system")
    public void userLogsOutOfTheSAPSystem() {
        sapPage.logoutFromSAP();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        sapPage.verifyLogoutSuccess();
    }
}
