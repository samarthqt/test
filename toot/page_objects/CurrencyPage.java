package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class CurrencyPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CurrencyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectCurrency(String currency) {
        WebElement currencyDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(currency_dropdown)));
        currencyDropdown.click();
        WebElement currencyOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//option[text()=' + currency + '])));
        currencyOption.click();
    }

    public String getDisplayedCurrency() {
        WebElement currencyDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(currency_display)));
        return currencyDisplay.getText();
    }

    public String getDefaultCurrency() {
        return USD;
    }

    public double getExpectedConversionRate(String currency) {
        switch (currency) {
            case JPY:
                return 110.0;
            default:
                return 1.0;
        }
    }

    public double getActualConversionRate() {
        WebElement conversionRateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conversion_rate)));
        return Double.parseDouble(conversionRateElement.getText());
    }

    public void logout() {
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(logout_button)));
        logoutButton.click();
    }

    public void login() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(login_button)));
        loginButton.click();
    }
}