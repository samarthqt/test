package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstNameField = By.id(first_name);
    private final By lastNameField = By.id(last_name);
    private final By emailField = By.id(email);
    private final By passwordField = By.id(password);
    private final By confirmPasswordField = By.id(confirm_password);
    private final By registerButton = By.id(register_button);
    private final By successMessage = By.id(success_message);
    private final By errorMessage = By.id(error_message);
    private final By emailErrorMessage = By.id(email_error_message);
    private final By passwordErrorMessage = By.id(password_error_message);
    private final By requiredFieldsErrorMessage = By.id(required_fields_error_message);
    private final By emailFormatErrorMessage = By.id(email_format_error_message);
    private final By passwordMismatchErrorMessage = By.id(password_mismatch_error_message);

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameField);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordField);
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }

    public boolean isRegistrationSuccessful() {
        WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return successElement.isDisplayed();
    }

    public String getConfirmationMessage() {
        WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return successElement.getText();
    }

    public String getErrorMessage() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }

    public String getEmailErrorMessage() {
        WebElement emailErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrorMessage));
        return emailErrorElement.getText();
    }

    public String getPasswordErrorMessage() {
        WebElement passwordErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordErrorMessage));
        return passwordErrorElement.getText();
    }

    public String getRequiredFieldsErrorMessage() {
        WebElement requiredFieldsErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(requiredFieldsErrorMessage));
        return requiredFieldsErrorElement.getText();
    }

    public String getEmailFormatErrorMessage() {
        WebElement emailFormatErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFormatErrorMessage));
        return emailFormatErrorElement.getText();
    }

    public String getPasswordMismatchErrorMessage() {
        WebElement passwordMismatchErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordMismatchErrorMessage));
        return passwordMismatchErrorElement.getText();
    }

    public void leaveFieldEmpty(String field) {
        By fieldLocator = getFieldLocator(field);
        WebElement fieldElement = driver.findElement(fieldLocator);
        fieldElement.clear();
    }

    public void enterField(String value, String field) {
        By fieldLocator = getFieldLocator(field);
        WebElement fieldElement = driver.findElement(fieldLocator);
        fieldElement.clear();
        fieldElement.sendKeys(value);
    }

    public void submitForm() {
        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }

    private By getFieldLocator(String field) {
        switch (field.toLowerCase()) {
            case first name:
                return firstNameField;
            case last name:
                return lastNameField;
            case email:
                return emailField;
            case password:
                return passwordField;
            case confirm password:
                return confirmPasswordField;
            default:
                throw new IllegalArgumentException(Invalid field:  + field);
        }
    }
}