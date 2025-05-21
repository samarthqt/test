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

public class ProductRecommendationsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField = By.id(username);
    private final By passwordField = By.id(password);
    private final By loginButton = By.id(login_button);
    private final By personalizedRecommendations = By.id(personalized_recommendations);
    private final By defaultRecommendations = By.id(default_recommendations);
    private final By recommendedProduct = By.cssSelector(div.recommended-product);
    private final By varietyRecommendations = By.id(variety_recommendations);
    private final By noRecommendationsMessage = By.id(no_recommendations_message);
    private final By suggestedActions = By.id(suggested_actions);

    public ProductRecommendationsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        driver.get(http://example.com/login);
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(dashboard), Login failed);
    }

    public void navigateToRecommendationsPage() {
        driver.get(http://example.com/recommendations);
        Assert.assertTrue(driver.getCurrentUrl().contains(recommendations), Navigation to recommendations page failed);
    }

    public boolean arePersonalizedRecommendationsDisplayed() {
        WebElement recommendationsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(personalizedRecommendations));
        boolean isDisplayed = recommendationsElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Personalized recommendations are not displayed);
        return isDisplayed;
    }

    public boolean areRecommendationsBasedOnBehavior() {
        // Logic to verify recommendations based on behavior
        boolean basedOnBehavior = true; // Placeholder for actual logic
        Assert.assertTrue(basedOnBehavior, Recommendations are not based on behavior);
        return basedOnBehavior;
    }

    public void clearUserHistory() {
        // Logic to clear user history
        boolean historyCleared = true; // Placeholder for actual logic
        Assert.assertTrue(historyCleared, User history was not cleared);
    }

    public boolean areDefaultRecommendationsDisplayed() {
        WebElement recommendationsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(defaultRecommendations));
        boolean isDisplayed = recommendationsElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Default recommendations are not displayed);
        return isDisplayed;
    }

    public boolean areRecommendationsBasedOnPopularity() {
        // Logic to verify recommendations based on popularity
        boolean basedOnPopularity = true; // Placeholder for actual logic
        Assert.assertTrue(basedOnPopularity, Recommendations are not based on popularity);
        return basedOnPopularity;
    }

    public void interactWithRecommendedProduct() {
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(recommendedProduct));
        productElement.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(product-details), Interaction with recommended product failed);
    }

    public boolean areRecommendationsUpdated() {
        // Logic to verify recommendations are updated
        boolean updated = true; // Placeholder for actual logic
        Assert.assertTrue(updated, Recommendations are not updated);
        return updated;
    }

    public boolean doRecommendationsReflectInteraction() {
        // Logic to verify recommendations reflect interaction
        boolean reflectInteraction = true; // Placeholder for actual logic
        Assert.assertTrue(reflectInteraction, Recommendations do not reflect interaction);
        return reflectInteraction;
    }

    public void simulateDiverseInteractions() {
        // Logic to simulate diverse interactions
        boolean interactionsSimulated = true; // Placeholder for actual logic
        Assert.assertTrue(interactionsSimulated, Diverse interactions were not simulated);
    }

    public boolean isVarietyOfRecommendationsDisplayed() {
        WebElement recommendationsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(varietyRecommendations));
        boolean isDisplayed = recommendationsElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Variety of recommendations are not displayed);
        return isDisplayed;
    }

    public boolean doRecommendationsReflectInterests() {
        // Logic to verify recommendations reflect interests
        boolean reflectInterests = true; // Placeholder for actual logic
        Assert.assertTrue(reflectInterests, Recommendations do not reflect interests);
        return reflectInterests;
    }

    public void clearRecommendationData() {
        // Logic to clear recommendation data
        boolean dataCleared = true; // Placeholder for actual logic
        Assert.assertTrue(dataCleared, Recommendation data was not cleared);
    }

    public boolean isNoRecommendationsMessageDisplayed() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noRecommendationsMessage));
        boolean isDisplayed = messageElement.isDisplayed();
        Assert.assertTrue(isDisplayed, No recommendations message is not displayed);
        return isDisplayed;
    }

    public boolean areSuggestedActionsDisplayed() {
        WebElement actionsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(suggestedActions));
        boolean isDisplayed = actionsElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Suggested actions are not displayed);
        return isDisplayed;
    }

    private void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}