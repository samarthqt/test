package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.report.Status;
import java.util.*;

public class BelehrungDatenschutzhinweisPage extends WebReusableComponents {

    protected By btnAttachmentClose = By.xpath("//button[@id='attachmentClose_header']");
    protected By lblManageAttachments = By.xpath("//h2[text()='Manage Attachments']");
    public static final String uploadFileBelehrung = "//*[text()='var1']//ancestor::div[contains(@id,'lip_segment-instance:SeiteEinreichen')]//following-sibling::div[1]//input";

    public BelehrungDatenschutzhinweisPage() {
        PageFactory.initElements(driver, this);
    }

    public void uploadFileInBelehrung(String elementType, String name, String fileName) {
        String element = replaceLocator(getValue(this, elementType), name);
        uploadFile(generateLocator("XPATH", element), fileName);
    }

    public void uploadFile(By by, String fileName) {
        try {
            WebElement fileInput = waitUntilElementVisible(by, 10);
            fileInput.sendKeys(System.getProperty("user.dir") + "/src/test/resources/pdf/" + fileName + ".pdf");
            addTestLog("File Upload", fileName + " is uploaded successfully", Status.PASS);
        } catch (Exception e) {
            addTestLog("File Upload", fileName + " is NOT uploaded. Error - " + e.getMessage(), Status.FAIL);
            Assert.fail("File upload failed: " + e.getMessage());
        }
    }

    public void clickAttachmentClose() {
        try {
            WebElement closeButton = waitUntilElementVisible(btnAttachmentClose, 10);
            closeButton.click();
            addTestLog("Attachment Close", "Attachment close button clicked successfully", Status.PASS);
        } catch (Exception e) {
            addTestLog("Attachment Close", "Failed to click attachment close button. Error - " + e.getMessage(), Status.FAIL);
            Assert.fail("Failed to click attachment close button: " + e.getMessage());
        }
    }

    public boolean isLabelManageAttachments() {
        try {
            boolean isVisible = elementVisible(lblManageAttachments, 20);
            Assert.assertTrue(isVisible, "Manage Attachments label is not visible.");
            return isVisible;
        } catch (Exception e) {
            addTestLog("Manage Attachments Label", "Label visibility check failed. Error - " + e.getMessage(), Status.FAIL);
            Assert.fail("Manage Attachments label visibility check failed: " + e.getMessage());
            return false;
        }
    }

    private WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private boolean elementVisible(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String replaceLocator(String locator, String replacement) {
        return locator.replace("var1", replacement);
    }

    private By generateLocator(String type, String locator) {
        switch (type.toUpperCase()) {
            case "XPATH":
                return By.xpath(locator);
            case "ID":
                return By.id(locator);
            case "CSS":
                return By.cssSelector(locator);
            default:
                throw new IllegalArgumentException("Invalid locator type: " + type);
        }
    }

    private String getValue(BelehrungDatenschutzhinweisPage page, String elementType) {
        // Placeholder for actual implementation to retrieve locator value
        return uploadFileBelehrung;
    }

    private void addTestLog(String action, String message, Status status) {
        // Placeholder for actual implementation to log test actions
    }
}