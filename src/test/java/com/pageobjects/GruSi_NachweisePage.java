package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.report.Status;
import java.util.*;

public class GruSi_NachweisePage extends WebReusableComponents {

    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");

    public GruSi_NachweisePage() {
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void uploadFile_Nachweise(String elementType, String name, String fileNameList) {
        if (!fileNameList.isEmpty()) {
            String[] fileNames = fileNameList.split("@@");
            for (int i = 0; i < fileNames.length; i++) {
                if (i > 0) {
                    waitUntil(2);
                    sendKeysToWindow(Keys.ESCAPE);
                    clickCommonButton_Index("commonButton_Index", "Weiteren Nachweis hinzufügen", "last()");
                    handlePageLoading();
                }
                String fileName = fileNames[i];
                String element = replaceLocator(getValue(this, elementType), name) + "[last()]";
                String jsScript = "getElementByXpath(\"" + element + "\").style.display='block';"
                        + "getElementByXpath(\"" + element + "\").style.opacity='1';";
                waitUntil(3);
                sendKeysToWindow(Keys.ESCAPE);
                addTestLog("JavaScript", "executing: " + jsGetElementByXpath + jsScript, Status.DONE);
                ((JavascriptExecutor) driver).executeScript(jsGetElementByXpath + jsScript);
                waitUntilElementVisible(By.xpath(element), 10);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(element)));

                uploadFile(generateLocator("XPATH", element), fileName);
                isLabelManageAttachments();
                clickAttachmentClose();

                waitUntil(3);
            }
        }
    }
}