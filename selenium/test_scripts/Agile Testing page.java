import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("http://www.qasymphony.com/platform.html");
            AgileTestingSubMenu agileTesting = new AgileTestingSubMenu(driver);
            agileTesting.clickAgileTesting();
            
            FreeTrial freeTrial = new FreeTrial(driver);
            freeTrial.callGetFreeTrial();
            
            ScaleAgile scaleAgile = new ScaleAgile(driver);
            scaleAgile.clickLearnMore();
            
            ExplorerTesting explorerTesting = new ExplorerTesting(driver);
            explorerTesting.clickLearnMore();
            
            DistributedTeam distributedTeam = new DistributedTeam(driver);
            distributedTeam.clickLearnMore();
            
            IntegrationAPIs integrationAPIs = new IntegrationAPIs(driver);
            integrationAPIs.clickLearnMore();
        } finally {
            driver.quit();
        }
    }
}

class AgileTestingSubMenu {
    private WebDriver driver;
    
    public AgileTestingSubMenu(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickAgileTesting() {
        WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
        agileTestingMenu.click();
    }
}

class FreeTrial {
    private WebDriver driver;
    
    public FreeTrial(WebDriver driver) {
        this.driver = driver;
    }
    
    public void callGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
        getFreeTrialButton.click();
    }
}

class ScaleAgile {
    private WebDriver driver;
    
    public ScaleAgile(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickLearnMore() {
        WebElement learnMoreButton = driver.findElement(By.linkText("Learn More"));
        learnMoreButton.click();
    }
}

class ExplorerTesting {
    private WebDriver driver;
    
    public ExplorerTesting(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickLearnMore() {
        WebElement learnMoreButton = driver.findElement(By.linkText("Learn More"));
        learnMoreButton.click();
    }
}

class DistributedTeam {
    private WebDriver driver;
    
    public DistributedTeam(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickLearnMore() {
        WebElement learnMoreButton = driver.findElement(By.linkText("Learn More"));
        learnMoreButton.click();
    }
}

class IntegrationAPIs {
    private WebDriver driver;
    
    public IntegrationAPIs(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickLearnMore() {
        WebElement learnMoreButton = driver.findElement(By.linkText("Learn More"));
        learnMoreButton.click();
    }
}