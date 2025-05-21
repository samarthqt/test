package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class PaymentInfoPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cardNumberField = By.id(card_number);
    private final By expiryDateField = By.id(expiry_date);
    private final By cvvField = By.id(cvv);
    private final By saveButton = By.id(save_button);
    private final By deleteButton = By.id(delete_button);

    public PaymentInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterCardNumber(String cardNumber) {
        WebElement cardNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField));
        cardNumberElement.clear();
        cardNumberElement.sendKeys(cardNumber);
        Assert.assertEquals(cardNumberElement.getAttribute(value), cardNumber, Card number entry failed);
    }

    public void enterExpiryDate(String expiryDate) {
        WebElement expiryDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(expiryDateField));
        expiryDateElement.clear();
        expiryDateElement.sendKeys(expiryDate);
        Assert.assertEquals(expiryDateElement.getAttribute(value), expiryDate, Expiry date entry failed);
    }

    public void enterCVV(String cvv) {
        WebElement cvvElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cvvField));
        cvvElement.clear();
        cvvElement.sendKeys(cvv);
        Assert.assertEquals(cvvElement.getAttribute(value), cvv, CVV entry failed);
    }

    public void clickSaveButton() {
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButtonElement.click();
        Assert.assertTrue(isSaveSuccessful(), Save operation failed);
    }

    public void clickDeleteButton() {
        WebElement deleteButtonElement = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButtonElement.click();
        Assert.assertTrue(isDeleteSuccessful(), Delete operation failed);
    }

    private boolean isSaveSuccessful() {
        // Implement logic to verify save success, e.g., checking for a success message
        return true; // Placeholder for actual implementation
    }

    private boolean isDeleteSuccessful() {
        // Implement logic to verify delete success, e.g., checking for a success message
        return true; // Placeholder for actual implementation
    }
}