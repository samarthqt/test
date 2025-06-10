package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class GDPRCompliancePage extends WebReusableComponents {

    protected By applicationStatus = By.id("applicationStatus");
    protected By userDataStorage = By.id("userDataStorage");
    protected By privacySettings = By.id("privacySettings");
    protected By dataProtectionAssessment = By.id("dataProtectionAssessment");
    protected By consentManagement = By.id("consentManagement");

    public GDPRCompliancePage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyApplicationRunning() {
        waitUntilElementVisible(applicationStatus, 3);
        Assert.assertTrue(isElementDisplayed(applicationStatus), "Application is not running.");
    }

    public void storeUserData() {
        waitUntilElementVisible(userDataStorage, 3);
        clickElement(userDataStorage);
        Assert.assertTrue(isElementDisplayed(userDataStorage), "User data storage failed.");
    }

    public void verifyDataStorageCompliance() {
        waitUntilElementVisible(userDataStorage, 3);
        String complianceStatus = getTextFromElement(userDataStorage);
        Assert.assertEquals(complianceStatus, "Compliant", "Data storage is not compliant with GDPR.");
    }

    public void processUserData() {
        WebElement processButton = driver.findElement(By.id("processUserData"));
        waitUntilElementVisible(processButton, 3);
        clickElement(processButton);
        Assert.assertTrue(isElementDisplayed(processButton), "User data processing failed.");
    }

    public void verifyDataProcessingCompliance() {
        WebElement processingStatus = driver.findElement(By.id("processingStatus"));
        waitUntilElementVisible(processingStatus, 3);
        String status = getTextFromElement(processingStatus);
        Assert.assertEquals(status, "Compliant", "Data processing is not compliant with GDPR.");
    }

    public void accessUserData() {
        WebElement accessButton = driver.findElement(By.id("accessUserData"));
        waitUntilElementVisible(accessButton, 3);
        clickElement(accessButton);
        Assert.assertTrue(isElementDisplayed(accessButton), "Accessing user data failed.");
    }

    public void verifyDataAccessCompliance() {
        WebElement accessStatus = driver.findElement(By.id("accessStatus"));
        waitUntilElementVisible(accessStatus, 3);
        String status = getTextFromElement(accessStatus);
        Assert.assertEquals(status, "Compliant", "Data access is not compliant with GDPR.");
    }

    public void accessUserAccount() {
        WebElement accountButton = driver.findElement(By.id("accessUserAccount"));
        waitUntilElementVisible(accountButton, 3);
        clickElement(accountButton);
        Assert.assertTrue(isElementDisplayed(accountButton), "Accessing user account failed.");
    }

    public void navigateToPrivacySettings() {
        waitUntilElementVisible(privacySettings, 3);
        clickElement(privacySettings);
        Assert.assertTrue(isElementDisplayed(privacySettings), "Navigation to privacy settings failed.");
    }

    public void displayPrivacyRightsInformation() {
        WebElement privacyInfo = driver.findElement(By.id("privacyRightsInfo"));
        waitUntilElementVisible(privacyInfo, 3);
        String info = getTextFromElement(privacyInfo);
        Assert.assertNotNull(info, "Privacy rights information is not displayed.");
    }

    public void informDataUsage() {
        WebElement dataUsageInfo = driver.findElement(By.id("dataUsageInfo"));
        waitUntilElementVisible(dataUsageInfo, 3);
        String info = getTextFromElement(dataUsageInfo);
        Assert.assertNotNull(info, "Data usage information is not provided.");
    }

    public void verifyApplicationOperational() {
        WebElement operationalStatus = driver.findElement(By.id("operationalStatus"));
        waitUntilElementVisible(operationalStatus, 3);
        String status = getTextFromElement(operationalStatus);
        Assert.assertEquals(status, "Operational", "Application is not operational.");
    }

    public void scheduleDataProtectionImpactAssessment() {
        waitUntilElementVisible(dataProtectionAssessment, 3);
        clickElement(dataProtectionAssessment);
        Assert.assertTrue(isElementDisplayed(dataProtectionAssessment), "Scheduling data protection impact assessment failed.");
    }

    public void conductRegularAssessment() {
        WebElement assessmentButton = driver.findElement(By.id("conductAssessment"));
        waitUntilElementVisible(assessmentButton, 3);
        clickElement(assessmentButton);
        Assert.assertTrue(isElementDisplayed(assessmentButton), "Conducting regular assessment failed.");
    }

    public void documentAndReviewResults() {
        WebElement reviewButton = driver.findElement(By.id("reviewResults"));
        waitUntilElementVisible(reviewButton, 3);
        clickElement(reviewButton);
        Assert.assertTrue(isElementDisplayed(reviewButton), "Documenting and reviewing results failed.");
    }

    public void navigateToConsentManagement() {
        waitUntilElementVisible(consentManagement, 3);
        clickElement(consentManagement);
        Assert.assertTrue(isElementDisplayed(consentManagement), "Navigation to consent management failed.");
    }

    public void provideConsentManagementTools() {
        WebElement consentTools = driver.findElement(By.id("consentTools"));
        waitUntilElementVisible(consentTools, 3);
        String tools = getTextFromElement(consentTools);
        Assert.assertNotNull(tools, "Consent management tools are not provided.");
    }

    public void manageUserConsent() {
        WebElement manageConsentButton = driver.findElement(By.id("manageConsent"));
        waitUntilElementVisible(manageConsentButton, 3);
        clickElement(manageConsentButton);
        Assert.assertTrue(isElementDisplayed(manageConsentButton), "Managing user consent failed.");
    }
}