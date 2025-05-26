public class QASymphonyPlatformPage {

    private WebDriver driver;

    // Locators
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]");
    private By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]");
    private By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]");

    // Constructor
    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openPlatformPage() {
        driver.get("http://www.qasymphony.com/platform.html");
    }

    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void callGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMoreButton).click();
    }

    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMoreButton).click();
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMoreButton).click();
    }
}