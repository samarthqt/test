import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user has valid credentials", () => {
 cy.fixture('user').then((user) => {
 cy.wrap(user).as('userData');
 });
});

When("the user logs in to their account", () => {
 cy.get('@userData').then((user) => {
 OrderHistoryPage.login(user.username, user.password);
 });
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged in", () => {
 cy.get('@userData').then((user) => {
 OrderHistoryPage.login(user.username, user.password);
 });
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the order history page is displayed with a list of past orders", () => {
 cy.url().should("include", "/order-history");
 OrderHistoryPage.verifyOrderList();
});

Given("the user is on the order history page", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

When("the user selects orders to be included in the PDF download", () => {
 OrderHistoryPage.selectOrdersForDownload();
});

Then("the selected orders are highlighted and ready for download", () => {
 OrderHistoryPage.verifySelectedOrders();
});

Given("the user has selected orders for download", () => {
 OrderHistoryPage.selectOrdersForDownload();
});

When("the user clicks on the 'Download PDF' button", () => {
 OrderHistoryPage.clickDownloadPDFButton();
});

Then("a prompt appears asking for confirmation to download the selected orders in PDF format", () => {
 OrderHistoryPage.verifyDownloadPrompt();
});

Given("the user is prompted to confirm the download", () => {
 OrderHistoryPage.verifyDownloadPrompt();
});

When("the user confirms the download action", () => {
 OrderHistoryPage.confirmDownload();
});

Then("the PDF file containing the order history is generated and downloaded successfully", () => {
 OrderHistoryPage.verifyPDFDownload();
});

Given("the PDF file is downloaded", () => {
 OrderHistoryPage.verifyPDFDownload();
});

When("the user opens the downloaded PDF file", () => {
 OrderHistoryPage.openDownloadedPDF();
});

Then("the PDF file opens correctly, displaying the selected order history", () => {
 OrderHistoryPage.verifyPDFContents();
});

Given("the PDF file is opened", () => {
 OrderHistoryPage.openDownloadedPDF();
});

When("the user views the contents of the PDF", () => {
 OrderHistoryPage.verifyPDFContents();
});

Then("the PDF contains accurate details of the selected orders including order ID, date, items, and total amount", () => {
 OrderHistoryPage.verifyPDFAccuracy();
});

Given("the PDF file is opened", () => {
 OrderHistoryPage.openDownloadedPDF();
});

When("the user checks the format and readability", () => {
 OrderHistoryPage.checkPDFFormatReadability();
});

Then("the PDF is well-formatted, readable, and free of any layout issues", () => {
 OrderHistoryPage.verifyPDFLayout();
});

Given("the user has downloaded the PDF", () => {
 OrderHistoryPage.verifyPDFDownload();
});

When("the user attempts to download the PDF again", () => {
 OrderHistoryPage.downloadPDFAgain();
});

Then("the system allows repeated downloads without errors", () => {
 OrderHistoryPage.verifyRepeatedDownload();
});

Given("the user is on the order history page", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

When("the user selects different orders for PDF download", () => {
 OrderHistoryPage.selectDifferentOrdersForDownload();
});

Then("the PDF download functionality works correctly for different selections", () => {
 OrderHistoryPage.verifyPDFDownloadFunctionality();
});

Given("the PDF file is downloaded", () => {
 OrderHistoryPage.verifyPDFDownload();
});

When("the user checks the file size and download speed", () => {
 OrderHistoryPage.checkFileSizeAndDownloadSpeed();
});

Then("the file size is reasonable and the download completes in a timely manner", () => {
 OrderHistoryPage.verifyFileSizeAndDownloadSpeed();
});

Given("the PDF file is downloaded", () => {
 OrderHistoryPage.verifyPDFDownload();
});

When("the user checks the file location", () => {
 OrderHistoryPage.checkFileLocation();
});

Then("the PDF file is saved in the user's designated download folder", () => {
 OrderHistoryPage.verifyFileLocation();
});

Given("the user is logged out", () => {
 OrderHistoryPage.logout();
});

When("the user attempts to download the PDF", () => {
 OrderHistoryPage.attemptPDFDownloadLoggedOut();
});

Then("the system prevents download attempts when the user is not logged in", () => {
 OrderHistoryPage.verifyDownloadPreventionLoggedOut();
});

Given("the user is downloading the PDF", () => {
 OrderHistoryPage.startPDFDownload();
});

When("the download process is underway", () => {
 OrderHistoryPage.verifyDownloadProcess();
});

Then("no error messages are displayed, indicating a smooth download process", () => {
 OrderHistoryPage.verifyNoDownloadErrors();
});

Given("the user is logged in on different browsers", () => {
 OrderHistoryPage.loginOnDifferentBrowsers();
});

When("the user attempts to download the PDF", () => {
 OrderHistoryPage.downloadPDFOnDifferentBrowsers();
});

Then("PDF download works consistently across different web browsers", () => {
 OrderHistoryPage.verifyCrossBrowserDownload();
});