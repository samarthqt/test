public class QASymphonyPage {
    private WebDriver driver;

    // Define locators
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[contains(text(), 'Learn More')]");
    private By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[contains(text(), 'Learn More')]");
    private By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[contains(text(), 'Learn More')]");

    // Constructor
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open URL
    public void openURL(String url) {
        driver.get(url);
    }

    // Click on Agile Testing sub-menu
    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    // Call Get Free Trial
    public void callGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    // Click on Scale Agile Learn More button
    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMoreButton).click();
    }

    // Click on eXplorer Testing Learn More button
    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMoreButton).click();
    }

    // Click on Distributed Team Learn More button
    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMoreButton).click();
    }
}