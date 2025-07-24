package com.qt.pshop.pageobjs;
import org.openqa.selenium.By;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.support.PageFactory;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
    }

    public void callGetFreeTrial() {
        // Implement the logic to call Get Free Trial
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(scaleAgileLearnMore);
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(explorerTestingLearnMore);
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(distributedTeamLearnMore);
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore, 3);
        clickElement(integrationAPIsLearnMore);
    }
}