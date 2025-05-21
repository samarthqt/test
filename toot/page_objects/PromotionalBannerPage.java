package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class PromotionalBannerPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = promotional_banner)
    private WebElement promotionalBanner;

    @FindBy(id = important_content)
    private WebElement importantContent;

    public PromotionalBannerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Retrieves the promotional banner element.
     * @return WebElement representing the promotional banner.
     */
    public WebElement getPromotionalBanner() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOf(promotionalBanner));
        Assert.assertNotNull(banner, Promotional banner is not visible);
        return banner;
    }

    /**
     * Checks if the important content is visible.
     * @return true if the important content is displayed, false otherwise.
     */
    public boolean isContentVisible() {
        boolean isVisible = wait.until(ExpectedConditions.visibilityOf(importantContent)).isDisplayed();
        Assert.assertTrue(isVisible, Important content is not visible);
        return isVisible;
    }
}