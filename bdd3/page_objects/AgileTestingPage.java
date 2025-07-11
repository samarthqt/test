java
package bdd3.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void verifySubMenuVisible(String subMenu) {
        WebElement element = driver.findElement(agileTestingSubMenu);
        Assert.assertTrue(element.isDisplayed(), subMenu + " sub-menu is not visible.");
    }

    public void clickSubMenu(String subMenu) {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void verifyGetFreeTrial() {
        WebElement element = driver.findElement(getFreeTrialButton);
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not visible.");
    }

    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMore).click();
    }

    public void verifyScaleAgileDetails() {
        Assert.assertTrue(driver.getPageSource().contains("Scale Agile Details"), "Scale Agile details are not visible.");
    }

    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMore).click();
    }

    public void verifyExplorerTestingDetails() {
        Assert.assertTrue(driver.getPageSource().contains("Explorer Testing Details"), "Explorer Testing details are not visible.");
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMore).click();
    }

    public void verifyDistributedTeamDetails() {
        Assert.assertTrue(driver.getPageSource().contains("Distributed Team Details"), "Distributed Team details are not visible.");
    }

    public void clickIntegrationAPIsLearnMore() {
        driver.findElement(integrationAPIsLearnMore).click();
    }

    public void verifyIntegrationAPIsDetails() {
        Assert.assertTrue(driver.getPageSource().contains("Integration & APIs Details"), "Integration & APIs details are not visible.");
    }
}
