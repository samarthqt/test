import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class PromotionalBannerSteps {
    WebDriver driver;
    PromotionalBannerPage bannerPage;
    WebDriverWait wait;

    public PromotionalBannerSteps(WebDriver driver) {
        this.driver = driver;
        this.bannerPage = PageFactory.initElements(driver, PromotionalBannerPage.class);
        this.wait = new WebDriverWait(driver, 10);
    }

    public void userIsOnHomepage() {
        driver.get("http://example.com");
    }

    public void userVisitsHomepage() {
        driver.get("http://example.com");
    }

    public void promotionalBannerShouldBeDisplayed() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOf(bannerPage.getPromotionalBanner()));
        Assert.assertTrue("Promotional banner is not displayed", banner.isDisplayed());
    }

    public void bannerDisplaysAccurateInformation() {
        String bannerText = bannerPage.getPromotionalBanner().getText();
        Assert.assertTrue("Banner information is incorrect", bannerText.contains("sales") && bannerText.contains("discounts"));
    }

    public void promotionalBannerUpdatedWithNewInfo() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOf(bannerPage.getPromotionalBanner()));
        Assert.assertTrue("Banner is not updated", banner.getText().contains("new sales") && banner.getText().contains("new discounts"));
    }

    public void userClicksPromotionalBanner() {
        bannerPage.getPromotionalBanner().click();
    }

    public void userRedirectedToPromotionsPage() {
        wait.until(ExpectedConditions.urlContains("promotions"));
        Assert.assertTrue("Not redirected to promotions page", driver.getCurrentUrl().contains("promotions"));
    }

    public void bannerResponsiveOnDevices() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOf(bannerPage.getPromotionalBanner()));
        Assert.assertTrue("Banner is not responsive", banner.isDisplayed());
    }

    public void bannerDoesNotObstructContent() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOf(bannerPage.getPromotionalBanner()));
        Assert.assertTrue("Banner obstructs content", bannerPage.isContentVisible());
    }
}