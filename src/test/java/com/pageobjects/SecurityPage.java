package com.page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SecurityPage extends WebReusableComponents {

    private By creditCardDetails = By.id("creditCardDetails");
    private By networkLogs = By.id("networkLogs");
    private By exportButton = By.id("exportButton");
    private By errorMessage = By.id("errorMessage");

    public SecurityPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isAccessDeniedForCreditCardDetails() {
        waitUntilElementVisible(creditCardDetails, 3);
        WebElement element = getWebElement(creditCardDetails);
        return element == null || !element.isDisplayed();
    }

    public boolean checkNetworkLogsForSensitiveInfo() {
        waitUntilElementVisible(networkLogs, 3);
        List<WebElement> logs = getWebElementList(networkLogs);
        return logs.stream().noneMatch(log -> log.getText().contains("sensitive"));
    }

    public boolean isExportBlocked() {
        waitUntilElementVisible(exportButton, 3);
        clickElement(exportButton);
        waitUntilElementVisible(errorMessage, 3);
        WebElement error = getWebElement(errorMessage);
        return error != null && error.isDisplayed();
    }
}