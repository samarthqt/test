import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicsLogin {

    private WebDriver driver;

    public DynamicsLogin() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void loginToDynamics(String username, String password) {
        driver.get("https://dynamics365.com/login");
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
        WebElement order = driver.findElement(By.xpath("//tr[@data-id='" + orderId + "']"));
        order.click();
    }

    public void updateShipmentStatus(String status) {
        WebElement shipmentStatusDropdown = driver.findElement(By.id("shipmentStatus"));
        shipmentStatusDropdown.sendKeys(status);
        WebElement updateButton = driver.findElement(By.id("updateButton"));
        updateButton.click();
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
        DynamicsLogin dynamicsLogin = new DynamicsLogin();
        dynamicsLogin.loginToDynamics("validUsername", "validPassword");
        dynamicsLogin.navigateToOrdersModule();
        dynamicsLogin.selectOrderById("12345");
        dynamicsLogin.updateShipmentStatus("Dispatched");
        dynamicsLogin.checkAlertSystem();
        dynamicsLogin.verifyCustomerAlert("Expected Alert Message");
        dynamicsLogin.closeBrowser();
    }
}