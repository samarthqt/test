package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;
import .util.List;

public class UserProfilePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By editProfileButton = By.id(edit_profile_button);
    private final By saveButton = By.id(save_button);
    private final By cancelButton = By.id(cancel_button);
    private final By firstNameField = By.id(first_name);
    private final By lastNameField = By.id(last_name);
    private final By emailField = By.id(email);
    private final By confirmationMessage = By.id(confirmation_message);
    private final By errorMessage = By.id(error_message);
    private final By editHistorySection = By.id(edit_history_section);
    private final By editHistoryEntries = By.className(edit_history_entry);
    private final By noChangesMessage = By.id(no_changes_message);

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickEditProfileButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(editProfileButton));
        button.click();
    }

    public void updateProfileInformation(String firstName, String lastName, String email) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = driver.findElement(lastNameField);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);

        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void clickSaveButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        button.click();
    }

    public void clickCancelButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        button.click();
    }

    public void navigateToEditHistory() {
        WebElement section = wait.until(ExpectedConditions.elementToBeClickable(editHistorySection));
        section.click();
    }

    public boolean isProfileUpdated() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        boolean isDisplayed = message.isDisplayed();
        Assert.assertTrue(isDisplayed, Profile update confirmation message not displayed);
        return isDisplayed;
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        boolean isDisplayed = message.isDisplayed();
        Assert.assertTrue(isDisplayed, Confirmation message not displayed);
        return isDisplayed;
    }

    public boolean isErrorMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        boolean isDisplayed = message.isDisplayed();
        Assert.assertTrue(isDisplayed, Error message not displayed);
        return isDisplayed;
    }

    public boolean isRedirectedToProfilePage() {
        boolean isRedirected = driver.getCurrentUrl().contains(profile);
        Assert.assertTrue(isRedirected, Not redirected to profile page);
        return isRedirected;
    }

    public boolean isEditHistoryDisplayed() {
        List<WebElement> entries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editHistoryEntries));
        boolean isDisplayed = !entries.isEmpty();
        Assert.assertTrue(isDisplayed, Edit history not displayed);
        return isDisplayed;
    }

    public boolean isEditHistoryDateAndTimeDisplayed() {
        List<WebElement> entries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editHistoryEntries));
        for (WebElement entry : entries) {
            String text = entry.getText();
            Assert.assertTrue(text.contains(Date) && text.contains(Time), Date and Time not displayed in edit history entry);
        }
        return true;
    }

    public boolean isProfileUnchanged() {
        boolean isUnchanged = !driver.findElement(confirmationMessage).isDisplayed();
        Assert.assertTrue(isUnchanged, Profile has changed);
        return isUnchanged;
    }

    public boolean isNoChangesMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(noChangesMessage));
        boolean isDisplayed = message.isDisplayed();
        Assert.assertTrue(isDisplayed, No changes message not displayed);
        return isDisplayed;
    }
}