package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

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

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistrationPage() {
        driver.get(http://example.com/register);
    }

    public void register(String firstName, String lastName, String email, String password, String confirmPassword) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = driver.findElement(lastNameField);
        lastNameElement.sendKeys(lastName);

        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);

        WebElement confirmPasswordElement = driver.findElement(confirmPasswordField);
        confirmPasswordElement.sendKeys(confirmPassword);

        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        boolean isDisplayed = successMessageElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Registration failed - Success message not found);
        return isDisplayed;
    }
}