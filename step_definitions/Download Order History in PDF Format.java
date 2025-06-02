package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;

public class OrderHistorySteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @When("the user logs in to their account")
    public void theUserLogsInToTheirAccount() {
        verifyLoginSuccessful();
    }

    @Then("the user is successfully logged in and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        verifyDashboardDisplayed();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyLoginSuccessful();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page is displayed with a list of past orders")
    public void theOrderHistoryPageIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPage() {
        navigateToOrderHistory();
    }

    @When("the user selects orders to be included in the PDF download")
    public void theUserSelectsOrdersToBeIncludedInThePDFDownload() {
        selectOrdersForPDFDownload();
    }

    @Then("the selected orders are highlighted and ready for download")
    public void theSelectedOrdersAreHighlightedAndReadyForDownload() {
        verifyOrdersSelectedForDownload();
    }

    @Given("the user has selected orders for download")
    public void theUserHasSelectedOrdersForDownload() {
        selectOrdersForPDFDownload();
    }

    @When("the user clicks on the 'Download PDF' button")
    public void theUserClicksOnTheDownloadPDFButton() {
        clickDownloadPDFButton();
    }

    @Then("a prompt appears asking for confirmation to download the selected orders in PDF format")
    public void aPromptAppearsAskingForConfirmationToDownloadTheSelectedOrdersInPDFFormat() {
        verifyDownloadConfirmationPrompt();
    }

    @Given("the user is prompted to confirm the download")
    public void theUserIsPromptedToConfirmTheDownload() {
        verifyDownloadConfirmationPrompt();
    }

    @When("the user confirms the download action")
    public void theUserConfirmsTheDownloadAction() {
        confirmDownloadAction();
    }

    @Then("the PDF file containing the order history is generated and downloaded successfully")
    public void thePDFFileContainingTheOrderHistoryIsGeneratedAndDownloadedSuccessfully() {
        verifyPDFDownloadedSuccessfully();
    }

    @Given("the PDF file is downloaded")
    public void thePDFFileIsDownloaded() {
        verifyPDFDownloadedSuccessfully();
    }

    @When("the user opens the downloaded PDF file")
    public void theUserOpensTheDownloadedPDFFile() {
        openDownloadedPDF();
    }

    @Then("the PDF file opens correctly, displaying the selected order history")
    public void thePDFFileOpensCorrectlyDisplayingTheSelectedOrderHistory() {
        verifyPDFContentDisplayed();
    }

    @Given("the PDF file is opened")
    public void thePDFFileIsOpened() {
        openDownloadedPDF();
    }

    @When("the user views the contents of the PDF")
    public void theUserViewsTheContentsOfThePDF() {
        verifyPDFContentDisplayed();
    }

    @Then("the PDF contains accurate details of the selected orders including order ID, date, items, and total amount")
    public void thePDFContainsAccurateDetailsOfTheSelectedOrdersIncludingOrderIDDateItemsAndTotalAmount() {
        verifyPDFContentAccuracy();
    }

    @Given("the PDF file is opened")
    public void thePDFFileIsOpenedAgain() {
        openDownloadedPDF();
    }

    @When("the user checks the format and readability")
    public void theUserChecksTheFormatAndReadability() {
        verifyPDFFormatAndReadability();
    }

    @Then("the PDF is well-formatted, readable, and free of any layout issues")
    public void thePDFIsWellFormattedReadableAndFreeOfAnyLayoutIssues() {
        verifyPDFFormatAndReadability();
    }

    @Given("the user has downloaded the PDF")
    public void theUserHasDownloadedThePDF() {
        verifyPDFDownloadedSuccessfully();
    }

    @When("the user attempts to download the PDF again")
    public void theUserAttemptsToDownloadThePDFAgain() {
        attemptRepeatedPDFDownload();
    }

    @Then("the system allows repeated downloads without errors")
    public void theSystemAllowsRepeatedDownloadsWithoutErrors() {
        verifyRepeatedDownloadAllowed();
    }

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPageAgain() {
        navigateToOrderHistory();
    }

    @When("the user selects different orders for PDF download")
    public void theUserSelectsDifferentOrdersForPDFDownload() {
        selectDifferentOrdersForPDFDownload();
    }

    @Then("the PDF download functionality works correctly for different selections")
    public void thePDFDownloadFunctionalityWorksCorrectlyForDifferentSelections() {
        verifyPDFDownloadForDifferentSelections();
    }

    @Given("the PDF file is downloaded")
    public void thePDFFileIsDownloadedAgain() {
        verifyPDFDownloadedSuccessfully();
    }

    @When("the user checks the file size and download speed")
    public void theUserChecksTheFileSizeAndDownloadSpeed() {
        checkFileSizeAndDownloadSpeed();
    }

    @Then("the file size is reasonable and the download completes in a timely manner")
    public void theFileSizeIsReasonableAndTheDownloadCompletesInATimelyManner() {
        verifyFileSizeAndDownloadSpeed();
    }

    @Given("the PDF file is downloaded")
    public void thePDFFileIsDownloadedYetAgain() {
        verifyPDFDownloadedSuccessfully();
    }

    @When("the user checks the file location")
    public void theUserChecksTheFileLocation() {
        checkFileLocation();
    }

    @Then("the PDF file is saved in the user's designated download folder")
    public void thePDFFileIsSavedInTheUsersDesignatedDownloadFolder() {
        verifyFileLocation();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        logout();
    }

    @When("the user attempts to download the PDF")
    public void theUserAttemptsToDownloadThePDF() {
        attemptPDFDownloadWhileLoggedOut();
    }

    @Then("the system prevents download attempts when the user is not logged in")
    public void theSystemPreventsDownloadAttemptsWhenTheUserIsNotLoggedIn() {
        verifyDownloadPreventionWhenLoggedOut();
    }

    @Given("the user is downloading the PDF")
    public void theUserIsDownloadingThePDF() {
        clickDownloadPDFButton();
    }

    @When("the download process is underway")
    public void theDownloadProcessIsUnderway() {
        verifyDownloadProcessUnderway();
    }

    @Then("no error messages are displayed, indicating a smooth download process")
    public void noErrorMessagesAreDisplayedIndicatingASmoothDownloadProcess() {
        verifyNoErrorMessagesDuringDownload();
    }

    @Given("the user is logged in on different browsers")
    public void theUserIsLoggedInOnDifferentBrowsers() {
        verifyLoginSuccessful();
    }

    @When("the user attempts to download the PDF")
    public void theUserAttemptsToDownloadThePDFOnDifferentBrowsers() {
        clickDownloadPDFButton();
    }

    @Then("PDF download works consistently across different web browsers")
    public void PDFDownloadWorksConsistentlyAcrossDifferentWebBrowsers() {
        verifyPDFDownloadOnDifferentBrowsers();
    }
}