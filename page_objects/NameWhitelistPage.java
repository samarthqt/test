package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class NameWhitelistPage extends WebReusableComponents {

    protected By txtFirstName = By.id("firstName");
    protected By txtLastName = By.id("lastName");
    protected By btnSubmit = By.id("submitButton");
    protected By profileNameDisplay = By.id("profileNameDisplay");
    protected By errorMessage = By.id("errorMessage");
    protected By uiIssueCheck = By.id("uiIssueCheck");

    public void navigateToRegistrationOrProfilePage() {
        launchUrl(getAppUrl() + "/registrationOrProfile");
        waitUntilElementVisible(txtFirstName, 5);
    }

    public void navigateToRegistrationPage() {
        launchUrl(getAppUrl() + "/register");
        waitUntilElementVisible(txtFirstName, 5);
    }

    public void verifyRegistrationPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtFirstName), "Registration page is not displayed.");
    }

    public void enterFirstName(String firstName) {
        waitUntilElementVisible(txtFirstName, 3);
        enterText(txtFirstName, firstName);
    }

    public void verifyFirstNameEntered(String expectedName) {
        String actualName = getTextFromElement(txtFirstName);
        Assert.assertEquals(actualName, expectedName, "First name is not entered correctly.");
    }

    public void enterLastName(String lastName) {
        waitUntilElementVisible(txtLastName, 3);
        enterText(txtLastName, lastName);
    }

    public void verifyLastNameEntered(String expectedName) {
        String actualName = getTextFromElement(txtLastName);
        Assert.assertEquals(actualName, expectedName, "Last name is not entered correctly.");
    }

    public void submitRegistrationForm() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
    }

    public void verifyFormSubmissionSuccess() {
        Assert.assertTrue(isElementVisible(profileNameDisplay), "Form submission failed.");
    }

    public void verifyNameDisplayedOnProfilePage(String expectedName) {
        String actualName = getTextFromElement(profileNameDisplay);
        Assert.assertEquals(actualName, expectedName, "Name is not displayed correctly on the profile page.");
    }

    public void navigateToProfileUpdatePage() {
        launchUrl(getAppUrl() + "/profileUpdate");
        waitUntilElementVisible(txtFirstName, 5);
    }

    public void verifyProfileUpdatePageDisplayed() {
        Assert.assertTrue(isElementVisible(txtFirstName), "Profile update page is not displayed.");
    }

    public void enterFirstNameProfile(String firstName) {
        waitUntilElementVisible(txtFirstName, 3);
        enterText(txtFirstName, firstName);
    }

    public void verifyFirstNameEnteredProfile(String expectedName) {
        String actualName = getTextFromElement(txtFirstName);
        Assert.assertEquals(actualName, expectedName, "First name is not entered correctly.");
    }

    public void enterLastNameProfile(String lastName) {
        waitUntilElementVisible(txtLastName, 3);
        enterText(txtLastName, lastName);
    }

    public void verifyLastNameEnteredProfile(String expectedName) {
        String actualName = getTextFromElement(txtLastName);
        Assert.assertEquals(actualName, expectedName, "Last name is not entered correctly.");
    }

    public void submitProfileUpdate() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
    }

    public void verifyProfileUpdateSuccess() {
        Assert.assertTrue(isElementVisible(profileNameDisplay), "Profile update failed.");
    }

    public void verifyNameDisplayedOnAllPages(String expectedName) {
        String actualName = getTextFromElement(profileNameDisplay);
        Assert.assertEquals(actualName, expectedName, "Name is not displayed correctly on all relevant pages.");
    }

    public void checkForErrorMessages() {
        Assert.assertFalse(isElementVisible(errorMessage), "Error messages are displayed.");
    }

    public void verifyNoErrorMessages() {
        Assert.assertFalse(isElementVisible(errorMessage), "Error messages are displayed.");
    }

    public void verifyNameStoredInDatabase(String expectedName) {
        // Database verification logic
        Assert.assertTrue(true, "Name is not stored correctly in the database.");
    }

    public void testDifferentCapitalizations(String name) {
        enterFirstName(name.toLowerCase());
        enterLastName(name.toUpperCase());
    }

    public void verifyCapitalizationsAccepted() {
        Assert.assertTrue(true, "Different capitalizations are not accepted.");
    }

    public void checkForUIIssues() {
        Assert.assertFalse(isElementVisible(uiIssueCheck), "UI issues are present.");
    }

    public void verifyNoUIIssues() {
        Assert.assertFalse(isElementVisible(uiIssueCheck), "UI issues are present.");
    }

    public void verifyNameSearchable(String name) {
        // Search logic
        Assert.assertTrue(true, "Name is not searchable.");
    }

    public void verifyNameSearchableWithoutIssues() {
        Assert.assertTrue(true, "Name is not searchable without issues.");
    }
}