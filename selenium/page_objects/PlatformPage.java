
package selenium.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlatformPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMoreButton = By.id("integrationAPIsLearnMore");

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened.");
    }

    public void enterPlatformUrl(String url) {
        navigateToUrl(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not match the expected value.");
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(isElementClicked(element), "Agile Testing Sub Menu was not clicked.");
    }

    public void callGetFreeTrial() {
        callFreeTrial();
        Assert.assertTrue(isFreeTrialCalled(), "Free trial was not called successfully.");
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), "Scale Agile Learn More button was not clicked.");
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), "Explorer Testing Learn More button was not clicked.");
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), "Distributed Team Learn More button was not clicked.");
    }

    public void clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationAPIsLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), "Integration APIs Learn More button was not clicked.");
    }

    private boolean isNewWindowOpened() {
        // Implement logic to verify if a new window is opened
        return true;
    }

    private boolean isElementClicked(WebElement element) {
        // Implement logic to verify if the element was clicked
        return true;
    }

    private boolean isFreeTrialCalled() {
        // Implement logic to verify if the free trial was called
        return true;
    }
}
