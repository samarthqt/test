/*
 *  © [2024] Qualitest. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pageobjects.orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import com.framework.report.Status;
import java.lang.reflect.Method;
import java.awt.Container;

/**
 * Page Object for MSD CRM Customer Verification functionality
 * 
 * @author Automation Team
 * @version 1.0
 */
public class CustomerVerificationPage extends WebReusableComponents {

    // Page locators
    private final By verificationPageContainer = By.className("verificationPage");
    private final By verificationMethodDropdown = By.id("verificationMethodDropdown");
    private final By verificationValueInput = By.id("verificationValueInput");
    private final By verifyButton = By.id("verifyButton");
    private final By verificationStatus = By.className("verificationStatus");
    private final By customerLandingPageLink = By.className("customerLandingPageLink");
    
    // Verification method options
    private final By emailVerificationOption = By.xpath("//option[contains(text(),'Email')]");
    private final By phoneVerificationOption = By.xpath("//option[contains(text(),'Phone')]");
    private final By securityQuestionOption = By.xpath("//option[contains(text(),'Security Question')]");
    private final By documentVerificationOption = By.xpath("//option[contains(text(),'Document')]");
    
    // Verification status indicators
    private final By verificationSuccess = By.className("verificationSuccess");
    private final By verificationFailure = By.className("verificationFailure");
    private final By verificationPending = By.className("verificationPending");

    public CustomerVerificationPage(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }

    /**
     * Check if verification page is displayed
     * 
     * @return true if page is displayed, false otherwise
     */
    public boolean isVerificationPageDisplayed() {
        try {
            return elementVisible(verificationPageContainer, 10);
        } catch (Exception e) {
            addTestLog("Page Display", "Error checking if verification page is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get available verification methods
     * 
     * @return Array of available verification methods
     */
    public String[] getAvailableVerificationMethods() {
        try {
            waitUntilElementVisible(verificationMethodDropdown, 10);
            Select methodSelect = new Select(driver.findElement(verificationMethodDropdown));
            
            java.util.List<WebElement> options = methodSelect.getOptions();
            String[] methods = new String[options.size()];
            
            for (int i = 0; i < options.size(); i++) {
                methods[i] = options.get(i).getText();
            }
            
            addTestLog("Verification Methods", "Found " + methods.length + " verification methods", Status.PASS);
            return methods;
            
        } catch (Exception e) {
            addTestLog("Verification Methods", "Error getting available verification methods: " + e.getMessage(), Status.WARNING);
            return new String[0];
        }
    }

    /**
     * Select verification method
     * 
     * @param method The verification method to select
     */
    public void selectVerificationMethod(String method) {
        try {
            waitUntilElementVisible(verificationMethodDropdown, 10);
            
            Select methodSelect = new Select(driver.findElement(verificationMethodDropdown));
            methodSelect.selectByVisibleText(method);
            
            addTestLog("Verification Method", "Selected verification method: " + method, Status.PASS);
            
            // Wait for method-specific fields to appear
            waitUntilElementVisible(verificationValueInput, 10);
            
        } catch (Exception e) {
            addTestLog("Verification Method", "Failed to select verification method: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Enter verification value
     * 
     * @param value The verification value to enter
     */
    public void enterVerificationValue(String value) {
        try {
            waitUntilElementVisible(verificationValueInput, 10);
            enterText(verificationValueInput, value);
            addTestLog("Verification Value", "Entered verification value: " + maskVerificationValue(value), Status.PASS);
        } catch (Exception e) {
            addTestLog("Verification Value", "Failed to enter verification value: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Click verify button
     */
    public void clickVerifyButton() {
        try {
            waitUntilElementVisible(verifyButton, 10);
            clickElement(verifyButton);
            addTestLog("Verification", "Clicked verify button", Status.PASS);
            
            // Wait for verification process to complete
            waitUntilElementVisible(verificationStatus, 15);
            
        } catch (Exception e) {
            addTestLog("Verification", "Failed to click verify button: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Perform complete verification process
     * 
     * @param method The verification method to use
     * @param value The verification value
     */
    public void performVerification(String method, String value) {
        try {
            addTestLog("Verification Process", "Starting verification process with method: " + method, Status.INFO);
            
            // Select verification method
            selectVerificationMethod(method);
            
            // Enter verification value
            enterVerificationValue(value);
            
            // Click verify button
            clickVerifyButton();
            
            // Wait for verification to complete
            waitForVerificationCompletion();
            
            addTestLog("Verification Process", "Verification process completed successfully", Status.PASS);
            
        } catch (Exception e) {
            addTestLog("Verification Process", "Verification process failed: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Wait for verification completion
     */
    private void waitForVerificationCompletion() {
        try {
            // Wait for verification status to be displayed
            waitUntilElementVisible(verificationStatus, 30);
            
            // Check if verification was successful
            if (elementVisible(verificationSuccess, 5)) {
                addTestLog("Verification Status", "Verification completed successfully", Status.PASS);
            } else if (elementVisible(verificationFailure, 5)) {
                String failureMessage = getTextFromElement(verificationFailure);
                addTestLog("Verification Status", "Verification failed: " + failureMessage, Status.FAIL);
                throw new RuntimeException("Verification failed: " + failureMessage);
            } else if (elementVisible(verificationPending, 5)) {
                addTestLog("Verification Status", "Verification is pending", Status.WARNING);
                // Wait additional time for completion
                waitUntilElementVisible(verificationSuccess, 30);
            }
            
        } catch (Exception e) {
            addTestLog("Verification Status", "Error waiting for verification completion: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Check if verification was successful
     * 
     * @return true if verification was successful, false otherwise
     */
    public boolean isVerificationSuccessful() {
        try {
            return elementVisible(verificationSuccess, 5);
        } catch (Exception e) {
            addTestLog("Verification Success", "Error checking verification success: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get verification status message
     * 
     * @return The verification status message
     */
    public String getVerificationStatusMessage() {
        try {
            waitUntilElementVisible(verificationStatus, 10);
            return getTextFromElement(verificationStatus);
        } catch (Exception e) {
            addTestLog("Verification Status", "Error getting verification status message: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Check if customer landing page link is available
     * 
     * @return true if link is available, false otherwise
     */
    public boolean isCustomerLandingPageLinkAvailable() {
        try {
            return elementVisible(customerLandingPageLink, 5);
        } catch (Exception e) {
            addTestLog("Landing Page Link", "Error checking if customer landing page link is available: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Navigate to customer landing page
     */
    public void navigateToCustomerLandingPage() {
        try {
            if (isCustomerLandingPageLinkAvailable()) {
                clickElement(customerLandingPageLink);
                addTestLog("Navigation", "Clicked customer landing page link", Status.PASS);
                
                // Wait for page navigation
                waitUntilPageReadyStateComplete(15);
                
            } else {
                addTestLog("Navigation", "Customer landing page link not available", Status.WARNING);
            }
            
        } catch (Exception e) {
            addTestLog("Navigation", "Failed to navigate to customer landing page: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Mask verification value for logging (security)
     * 
     * @param value The original verification value
     * @return Masked verification value
     */
    private String maskVerificationValue(String value) {
        if (value == null || value.length() < 2) {
            return "**";
        }
        return value.substring(0, 2) + "***";
    }
}