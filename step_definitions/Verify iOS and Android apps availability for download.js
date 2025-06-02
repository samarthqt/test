import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AppStorePage from "../pages/appStorePage";
import PlayStorePage from "../pages/playStorePage";

Given("I have access to the iOS App Store on an iOS device", () => {
  AppStorePage.ensureAccess();
});

When("I open the iOS App Store", () => {
  AppStorePage.open();
});

Then("the iOS App Store opens successfully", () => {
  AppStorePage.verifyOpen();
});

When("I search for the application using its name", () => {
  AppStorePage.searchForApp();
});

Then("the application appears in the search results", () => {
  AppStorePage.verifyAppInResults();
});

When("I select the application from the search results", () => {
  AppStorePage.selectApp();
});

Then("the application details page is displayed", () => {
  AppStorePage.verifyAppDetailsPage();
});

When("I initiate the download of the application", () => {
  AppStorePage.initiateDownload();
});

Then("the download starts successfully without errors", () => {
  AppStorePage.verifyDownloadStarts();
});

Given("I have access to the Google Play Store on an Android device", () => {
  PlayStorePage.ensureAccess();
});

When("I open the Google Play Store", () => {
  PlayStorePage.open();
});

Then("the Google Play Store opens successfully", () => {
  PlayStorePage.verifyOpen();
});

When("I search for the application using its name", () => {
  PlayStorePage.searchForApp();
});

Then("the application appears in the search results", () => {
  PlayStorePage.verifyAppInResults();
});

When("I select the application from the search results", () => {
  PlayStorePage.selectApp();
});

Then("the application details page is displayed", () => {
  PlayStorePage.verifyAppDetailsPage();
});

When("I initiate the download of the application", () => {
  PlayStorePage.initiateDownload();
});

Then("the download starts successfully without errors", () => {
  PlayStorePage.verifyDownloadStarts();
});

Given("the application is installed on both iOS and Android devices", () => {
  AppStorePage.verifyAppInstalled();
  PlayStorePage.verifyAppInstalled();
});

When("I open the application on both iOS and Android devices", () => {
  AppStorePage.openApp();
  PlayStorePage.openApp();
});

Then("the application launches successfully on both devices", () => {
  AppStorePage.verifyAppLaunch();
  PlayStorePage.verifyAppLaunch();
});

When("I complete the initial setup process on both devices", () => {
  AppStorePage.completeInitialSetup();
  PlayStorePage.completeInitialSetup();
});

Then("the setup completes successfully without errors", () => {
  AppStorePage.verifySetupComplete();
  PlayStorePage.verifySetupComplete();
});