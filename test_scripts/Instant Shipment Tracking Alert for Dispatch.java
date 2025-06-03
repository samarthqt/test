import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dynamics365Automation {

    private WebDriver driver;

    public Dynamics365Automation() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void loginToDynamics365(String username, String password) {
        driver.get("https://dynamics365url.com");
        WebElement userField = driver.findElement(By.id("username"));
        WebElement passField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        userField.sendKeys(username);
        passField.sendKeys(password);
        loginButton.click();
    }

    public void navigateToOrdersModule() {
        WebElement ordersModule = driver.findElement(By.id("ordersModule"));
        ordersModule.click();
    }

    public void selectOrderById(String orderId) {
        WebElement order = driver.findElement(By.xpath("//tr[td/text()='" + orderId + "']"));
        order.click();
    }

    public void updateShipmentStatus(String status) {
        WebElement statusDropdown = driver.findElement(By.id("shipmentStatus"));
        statusDropdown.click();
        WebElement statusOption = driver.findElement(By.xpath("//option[text()='" + status + "']"));
        statusOption.click();
    }

    public void checkAlertSystem() {
        WebElement alertSystem = driver.findElement(By.id("alertSystem"));
        alertSystem.click();
    }

    public void verifyCustomerAlert(String expectedAlert) {
        WebElement alertMessage = driver.findElement(By.id("customerAlert"));
        String actualAlert = alertMessage.getText();
        Assert.assertEquals(actualAlert, expectedAlert, "Alert message does not match.");
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        Dynamics365Automation automation = new Dynamics365Automation();
        automation.loginToDynamics365("validUsername", "validPassword");
        automation.navigateToOrdersModule();
        automation.selectOrderById("12345");
        automation.updateShipmentStatus("Dispatched");
        automation.checkAlertSystem();
        automation.verifyCustomerAlert("Expected Alert Message");
        automation.closeBrowser();
    }
}