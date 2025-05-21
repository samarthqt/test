
package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By footerLocator = By.cssSelector(footer);
    private final By returnPolicyLinkLocator = By.linkText(Return Policy);
    private final By personalizedBannerLocator = By.id(personalized_banner);
    private final By defaultBannerLocator = By.id(default_banner);
    private final By updatedPersonalizedBannerLocator = By.id(updated_personalized_banner);
    private final By recommendationsLocator = By.id(recommendations);
    private final By personalizedTagLocator = By.id(personalized_tag);
    private final By explorationMessageLocator = By.id(exploration_message);
    private final By productItemLocator = By.cssSelector(.product-item);
    private final By updatedTagLocator = By.id(updated_tag);
    private final By viewRecommendationsLocator = By.id(view_recommendations);
    private final By popularProductsLocator = By.id(popular_products);
    private final By optOutButtonLocator = By.id(opt_out);
    private final By optInOptionLocator = By.id(opt_in_option);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(http://example.com);
    }

    public WebElement getFooter() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(footerLocator));
    }

    public WebElement getReturnPolicyLink() {
        return driver.findElement(returnPolicyLinkLocator);
    }

    public void clickReturnPolicyLink() {
        getReturnPolicyLink().click();
    }

    public boolean arePersonalizedBannersDisplayed() {
        WebElement personalizedBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(personalizedBannerLocator));
        Assert.assertTrue(personalizedBanner.isDisplayed(), Personalized banner is not displayed);
        return true;
    }

    public boolean areDefaultBannersDisplayed() {
        WebElement defaultBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(defaultBannerLocator));
        Assert.assertTrue(defaultBanner.isDisplayed(), Default banner is not displayed);
        return true;
    }

    public boolean areUpdatedPersonalizedBannersDisplayed() {
        WebElement updatedBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(updatedPersonalizedBannerLocator));
        Assert.assertTrue(updatedBanner.isDisplayed(), Updated personalized banner is not displayed);
        return true;
    }

    public boolean areRecommendationsDisplayed() {
        WebElement recommendations = wait.until(ExpectedConditions.visibilityOfElementLocated(recommendationsLocator));
        Assert.assertTrue(recommendations.isDisplayed(), Recommendations are not displayed);
        return true;
    }

    public boolean areRecommendationsPersonalized() {
        WebElement personalizedTag = driver.findElement(personalizedTagLocator);
        Assert.assertTrue(personalizedTag.isDisplayed(), Personalized tag is not displayed);
        return true;
    }

    public boolean isExplorationMessageDisplayed() {
        WebElement message = driver.findElement(explorationMessageLocator);
        Assert.assertTrue(message.isDisplayed(), Exploration message is not displayed);
        return true;
    }

    public void interactWithProduct() {
        WebElement product = driver.findElement(productItemLocator);
        product.click();
    }

    public boolean areRecommendationsUpdated() {
        WebElement updatedTag = driver.findElement(updatedTagLocator);
        Assert.assertTrue(updatedTag.isDisplayed(), Updated recommendations tag is not displayed);
        return true;
    }

    public void viewRecommendations() {
        WebElement recommendations = driver.findElement(viewRecommendationsLocator);
        recommendations.click();
    }

    public boolean arePopularProductsIncluded() {
        WebElement popularProducts = driver.findElement(popularProductsLocator);
        Assert.assertTrue(popularProducts.isDisplayed(), Popular products are not included);
        return true;
    }

    public void optOutOfRecommendations() {
        WebElement optOutButton = driver.findElement(optOutButtonLocator);
        optOutButton.click();
    }

    public boolean isOptInOptionAvailable() {
        WebElement optInOption = driver.findElement(optInOptionLocator);
        Assert.assertTrue(optInOption.isDisplayed(), Opt-in option is not available);
        return true;
    }

    public void navigateToHomepage() {
        driver.get(http://example.com/homepage);
    }
}
