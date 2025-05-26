```java
// DynamicsLoginPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicsLoginPage {
    WebDriver driver;

    @FindBy(id = "googleLoginButton")
    WebElement googleLoginButton;

    public DynamicsLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWithGoogle() {
        googleLoginButton.click();
        // Add Google login steps here
    }
}

// OrdersPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/orders']")
    WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[td[text()='98765']]//button[@class='editOrder']")
    WebElement editOrderButton;

    @FindBy(id = "shipmentStatus")
    WebElement shipmentStatusDropdown;

    @FindBy(id = "saveOrder")
    WebElement saveOrderButton;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrdersModule() {
        ordersModuleLink.click();
    }

    public void selectOrderById(String orderId) {
        editOrderButton.click();
    }

    public void updateShipmentStatus(String status) {
        shipmentStatusDropdown.sendKeys(status);
        saveOrderButton.click();
    }
}

// AlertsPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    WebDriver driver;

    @FindBy(id = "outgoingAlerts")
    WebElement outgoingAlertsSection;

    @FindBy(id = "customerAlerts")
    WebElement customerAlertsSection;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkOutgoingAlerts() {
        outgoingAlertsSection.click();
    }

    public boolean verifyCustomerAlerts() {
        return customerAlertsSection.isDisplayed();
    }
}

// TestDynamics.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDynamics {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dynamics365.example.com");

        DynamicsLoginPage loginPage = new DynamicsLoginPage(driver);
        loginPage.loginWithGoogle();

        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.navigateToOrdersModule();
        ordersPage.selectOrderById("98765");
        ordersPage.updateShipmentStatus("Dispatch Ready");

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.checkOutgoingAlerts();
        boolean alertsVerified = alertsPage.verifyCustomerAlerts();

        System.out.println("Alerts verified: " + alertsVerified);

        driver.quit();
    }
}
```