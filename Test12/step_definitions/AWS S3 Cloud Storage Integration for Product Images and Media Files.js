import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import S3Page from "../pages/s3Page";

Given("AWS S3 is available", () => {
 S3Page.checkAvailability();
});

When("configuring the S3 bucket for storage", () => {
 S3Page.configureBucket();
});

Then("the bucket must be set to store images and media securely", () => {
 S3Page.verifySecureStorage();
});

Given("images and media files are stored in AWS S3", () => {
 S3Page.checkFilesStored();
});

When("files are uploaded or accessed", () => {
 S3Page.uploadOrAccessFiles();
});

Then("data must be encrypted during transit and at rest", () => {
 S3Page.verifyEncryption();
});

When("attempting to access and retrieve files", () => {
 S3Page.accessAndRetrieveFiles();
});

Then("the files should be accessible and retrievable", () => {
 S3Page.verifyFileAccess();
});

Given("AWS S3 is configured for storage", () => {
 S3Page.checkConfiguration();
});

When("setting access control policies", () => {
 S3Page.setAccessControlPolicies();
});

Then("unauthorized access must be restricted", () => {
 S3Page.verifyAccessControl();
});

Given("various file types are ready for upload", () => {
 S3Page.prepareFileTypes();
});

When("uploading and retrieving files in AWS S3", () => {
 S3Page.uploadAndRetrieveFiles();
});

Then("the process should succeed for all file types", () => {
 S3Page.verifyProcessSuccess();
});

Given("AWS S3 is used for storing files", () => {
 S3Page.checkUsage();
});

When("configuring redundancy and backup", () => {
 S3Page.configureRedundancyBackup();
});

Then("there should be mechanisms in place for data redundancy and backup", () => {
 S3Page.verifyRedundancyBackup();
});

Given("AWS S3 is integrated with the application", () => {
 S3Page.checkIntegration();
});

When("interacting with the frontend and backend", () => {
 S3Page.interactWithApp();
});

Then("the integration should function seamlessly", () => {
 S3Page.verifyIntegration();
});

When("files are uploaded or retrieved", () => {
 S3Page.uploadOrRetrieveFiles();
});

Then("all operations should be logged for monitoring", () => {
 S3Page.verifyLogging();
});

When("storing and managing data", () => {
 S3Page.storeAndManageData();
});

Then("all operations must comply with data protection regulations", () => {
 S3Page.verifyCompliance();
});