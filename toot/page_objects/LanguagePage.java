package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class LanguagePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By languageDropdownLocator = By.id(language_dropdown);
    private final By displayedLanguageLocator = By.id(displayed_language);

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void selectLanguage(String language) {
        WebElement languageDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(languageDropdownLocator));
        languageDropdown.click();
        WebElement languageOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//option[text()=' + language + '])));
        languageOption.click();
        Assert.assertEquals(getDisplayedLanguage(), language, Language selection failed);
    }

    public String getDisplayedLanguage() {
        WebElement languageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(displayedLanguageLocator));
        return languageElement.getText();
    }

    public boolean isLanguageDropdownVisible() {
        WebElement languageDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(languageDropdownLocator));
        return languageDropdown.isDisplayed();
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}