import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import FileUploadPage from "../pages/fileUploadPage";
import SystemMonitorPage from "../pages/systemMonitorPage";

Given("the user has valid credentials", () => {
 LoginPage.visit();
});

When("the user logs into the system", () => {
 LoginPage.login();
});

Then("the user is successfully logged in", () => {
 LoginPage.verifyLoginSuccess();
});

Given("the user is logged into the system", () => {
 LoginPage.verifyLoginSuccess();
});

When("the user navigates to the file upload section", () => {
 FileUploadPage.navigateToUploadSection();
});

Then("the file upload section is displayed", () => {
 FileUploadPage.verifyUploadSectionDisplayed();
});

Given("the user is in the file upload section", () => {
 FileUploadPage.verifyUploadSectionDisplayed();
});

When("the user selects File {string} for upload", (fileSize) => {
 FileUploadPage.selectFile(fileSize);
});

And("initiates the upload process for File {string}", (fileSize) => {
 FileUploadPage.initiateUpload(fileSize);
});

Then("File {string} uploads successfully without errors", (fileSize) => {
 FileUploadPage.verifyUploadSuccess(fileSize);
});

And("the integrity of File {string} is confirmed", (fileSize) => {
 FileUploadPage.verifyFileIntegrity(fileSize);
});

Given("multiple files are being uploaded", () => {
 FileUploadPage.uploadMultipleFiles();
});

When("the system resource utilization is checked", () => {
 SystemMonitorPage.checkResourceUtilization();
});

Then("resource utilization remains within acceptable limits", () => {
 SystemMonitorPage.verifyResourceUtilizationLimits();
});

Given("multiple files have been uploaded", () => {
 FileUploadPage.verifyMultipleFilesUploaded();
});

When("the system performance metrics are monitored", () => {
 SystemMonitorPage.monitorPerformanceMetrics();
});

Then("performance metrics indicate efficient handling of uploads", () => {
 SystemMonitorPage.verifyPerformanceEfficiency();
});

Given("files are being uploaded", () => {
 FileUploadPage.uploadFiles();
});

When("error messages or logs are generated", () => {
 SystemMonitorPage.generateErrorLogs();
});

Then("no critical errors or warnings are logged", () => {
 SystemMonitorPage.verifyNoCriticalErrors();
});

Given("a file upload is completed", () => {
 FileUploadPage.verifyUploadCompletion();
});

When("the system sends notifications", () => {
 SystemMonitorPage.sendNotifications();
});

Then("the user is notified accurately upon upload completion", () => {
 SystemMonitorPage.verifyUserNotification();
});

Given("an upload is interrupted", () => {
 FileUploadPage.interruptUpload();
});

When("the system attempts to recover", () => {
 SystemMonitorPage.attemptRecovery();
});

Then("the system recovers and resumes upload without data loss", () => {
 SystemMonitorPage.verifyRecoveryWithoutDataLoss();
});

Given("multiple large files are uploaded concurrently", () => {
 FileUploadPage.uploadLargeFilesConcurrently();
});

When("the system handles these uploads", () => {
 SystemMonitorPage.handleConcurrentUploads();
});

Then("the system handles concurrent uploads efficiently", () => {
 SystemMonitorPage.verifyConcurrentUploadEfficiency();
});