public class QASymphonyPlatformPage {
    private WebDriver driver;
    
    // Constructor
    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Locators
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[text()='Learn More']");
    private By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[text()='Learn More']");
    private By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[text()='Learn More']");
    private By integrationAPIsLearnMoreButton = By.xpath("//section[@id='integration-apis']//a[text()='Learn More']");
    
    // Methods
    public void openUrl(String url) {
        driver.get(url);
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
    
    public void clickIntegrationAPIsLearnMore() {
        driver.findElement(integrationAPIsLearnMoreButton).click();
    }
}