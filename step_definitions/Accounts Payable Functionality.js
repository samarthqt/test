import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LoginPage from '../pageObjects/LoginPage';
import DashboardPage from '../pageObjects/DashboardPage';
import AccountsPayablePage from '../pageObjects/AccountsPayablePage';

const loginPage = new LoginPage();
const dashboardPage = new DashboardPage();
const accountsPayablePage = new AccountsPayablePage();

Given('I am a Finance user', () => {
  // Assume user is a Finance user
});

When('I login to the system', () => {
  loginPage.login('financeUser', 'password123');
});

Then('I should be successfully logged in and directed to the system dashboard', () => {
  dashboardPage.verifyDashboard();
});

Given('I am on the system dashboard', () => {
  dashboardPage.verifyDashboard();
});

When('I navigate to the Accounts Payable module', () => {
  dashboardPage.goToAccountsPayable();
});

Then('I should be able to navigate to the module without any errors or issues', () => {
  accountsPayablePage.verifyPage();
});

Given('I am on the Accounts Payable module', () => {
  accountsPayablePage.verifyPage();
});

Then('I should be able to see and access all necessary options and features related to Accounts Payable, such as creating invoices, managing payments, and generating reports', () => {
  accountsPayablePage.verifyOptionsAndFeatures();
});

When('I create a new invoice with all the required information', () => {
  accountsPayablePage.createInvoice({
    invoiceNumber: 'INV123',
    vendor: 'Vendor A',
    amount: 1000
  });
});

Then('the invoice should be successfully saved in the system', () => {
  accountsPayablePage.verifyInvoiceSaved('INV123');
});

When('I create a new invoice', () => {
  accountsPayablePage.createInvoice({
    invoiceNumber: 'INV124',
    vendor: 'Vendor B',
    amount: 1500
  });
});

Then('the system should display the newly created invoice in the invoice list with all the relevant details, such as invoice number, vendor information, and amount', () => {
  accountsPayablePage.verifyInvoiceInList('INV124');
});

When('I edit an existing invoice and update the necessary information', () => {
  accountsPayablePage.editInvoice('INV123', { amount: 1200 });
});

Then('the changes should be successfully saved in the system', () => {
  accountsPayablePage.verifyInvoiceUpdated('INV123');
});

When('I edit an existing invoice', () => {
  accountsPayablePage.editInvoice('INV124', { dueDate: '2023-12-31' });
});

Then('the system should display the updated information for the edited invoice, such as the modified invoice amount or due date', () => {
  accountsPayablePage.verifyInvoiceUpdated('INV124');
});

When('I delete an existing invoice', () => {
  accountsPayablePage.deleteInvoice('INV123');
});

Then('the invoice should be successfully deleted from the system', () => {
  accountsPayablePage.verifyInvoiceDeleted('INV123');
});

Then('the system should not display the deleted invoice in the invoice list, and it should be permanently removed from the system', () => {
  accountsPayablePage.verifyInvoiceNotInList('INV123');
});

When('I generate a payment for an invoice', () => {
  accountsPayablePage.generatePayment('INV124');
});

Then('the payment process should be completed successfully', () => {
  accountsPayablePage.verifyPaymentProcessed('INV124');
});

Then('the system should record and update the payment information for the invoice, such as payment date and amount', () => {
  accountsPayablePage.verifyPaymentRecorded('INV124');
});

When('I view and download reports related to Accounts Payable', () => {
  accountsPayablePage.viewAndDownloadReports();
});

Then('I should be able to view and download the reports without any issues', () => {
  accountsPayablePage.verifyReportsDownloaded();
});

Given('I have downloaded reports related to Accounts Payable', () => {
  accountsPayablePage.verifyReportsDownloaded();
});

When('I review the downloaded reports', () => {
  accountsPayablePage.reviewReports();
});

Then('the reports should contain accurate and complete information related to Accounts Payable, such as correct invoice details or payment records', () => {
  accountsPayablePage.verifyReportAccuracy();
});

Given('I am logged in to the system', () => {
  dashboardPage.verifyDashboard();
});

When('I logout', () => {
  dashboardPage.logout();
});

Then('I should be successfully logged out from the system and directed to the login page', () => {
  loginPage.verifyLogout();
});

Given('I am not authorized to access the Accounts Payable functionality', () => {
  loginPage.login('unauthorizedUser', 'password123');
});

When('I attempt to access the functionality', () => {
  dashboardPage.goToAccountsPayable();
});

Then('the system should restrict access and display an appropriate error message or notification', () => {
  accountsPayablePage.verifyAccessRestricted();
});