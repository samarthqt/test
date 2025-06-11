package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;

public class BuT_NachweisePage extends WebReusableComponents {

    protected By btnAttachmentClose = By.xpath("//button[@id='attachmentClose']");
    protected By lblManageAttachments = By.xpath("//h2[text()='Anlagen verwalten']");

    public BuT_NachweisePage() {
        PageFactory.initElements(driver, this);
    }

    public void uploadFile_Nachweise(String elementType, String name, String fileNameList) {
        Assert.assertNotNull(fileNameList, "File name list should not be null.");
        if (!fileNameList.isEmpty()) {
            String[] fileNames = fileNameList.split("@@");
            for (int i = 0; i < fileNames.length; i++) {
                if (i > 0) {
                    waitUntil(2);
                    sendKeysToWindow(Keys.ESCAPE);
                    clickCommonButton_Index("commonButton_Index", "Weiteren Nachweis hinzufügen", "last()");
                }
                String fileName = fileNames[i];
                String element = "(" + replaceLocator(getValue(this, elementType), name) + ")[last()]";
                String jsGetElementByXpath = "function getElementByXpath(path) {return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;};";
                String jsScript = "getElementByXpath(\"" + element + "\").style.display='block';"
                        + "getElementByXpath(\"" + element + "\").style.opacity='1';";
                waitUntil(3);
                sendKeysToWindow(Keys.ESCAPE);
                ((JavascriptExecutor) driver).executeScript(jsGetElementByXpath + jsScript);
                waitUntilElementLocated(By.xpath(element), 10);
                uploadFile(generateLocator("XPATH", element), fileName);
                isLabelManageAttachments();
                clickAttachmentClose();
                waitUntil(3);
            }
        }
    }

    public void clickAttachmentClose() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnAttachmentClose));
        Assert.assertNotNull(closeButton, "Close button should be visible.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
        handlePageLoading();
    }

    private void isLabelManageAttachments() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(lblManageAttachments));
        Assert.assertNotNull(label, "Manage Attachments label should be visible.");
    }
}