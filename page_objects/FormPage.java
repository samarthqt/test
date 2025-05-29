package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import .io.File;
import .io.IOException;
import .time.Duration;

public class FormPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By nameFieldLocator = By.id(name);
    private final By emailFieldLocator = By.id(email);
    private final By messageFieldLocator = By.id(message);
    private final By submitButtonLocator = By.id(submit);
    private final By confirmationMessageLocator = By.id(confirmation_message);

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToFormPage() {
        driver.get(http://example.com/form);
    }

    public void fillForm(String name, String email, String message) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        nameField.sendKeys(name);

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(email);

        WebElement messageField = driver.findElement(messageFieldLocator);
        messageField.sendKeys(message);
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
        Assert.assertTrue(Form submission failed, isConfirmationMessageDisplayed());
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
        return confirmationMessage.isDisplayed();
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}