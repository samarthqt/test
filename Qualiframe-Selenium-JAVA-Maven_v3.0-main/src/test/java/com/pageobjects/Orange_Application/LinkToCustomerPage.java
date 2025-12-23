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

/**
 * Page Object for MSD CRM Link to Customer functionality
 * 
 * @author Automation Team
 * @version 1.0
 */
public class LinkToCustomerPage extends WebReusableComponents {

    // Page locators
    private final By pageTitle = By.tagName("h1");
    private final By customerSearchInput = By.id("customerSearchInput");
    private final By searchTypeDropdown = By.id("searchTypeDropdown");
    private final By customerSearchButton = By.id("customerSearchButton");
    private final By customerSearchResults = By.className("customerSearchResults");
    private final By customerResultRow = By.className("customerResultRow");
    private final By customerEllipsisMenu = By.className("customerEllipsisMenu");
    private final By linkToCustomerFromResults = By.xpath("//button[contains(text(),'Link to Customer')]");
    private final By customerVerificationSection = By.className("customerVerificationSection");
    
    // Customer information fields
    private final By customerNameField = By.className("customerName");
    private final By customerIdField = By.className("customerId");
    private final By customerEmailField = By.className("customerEmail");
    private final By customerPhoneField = By.className("customerPhone");

    public LinkToCustomerPage(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }

    /**
     * Check if Link to Customer page is displayed
     * 
     * @return true if page is displayed, false otherwise
     */
    public boolean isLinkToCustomerPageDisplayed() {
        try {
            return elementVisible(pageTitle, 10) && 
                   getTextFromElement(pageTitle).contains("Link ABP");
        } catch (Exception e) {
            addTestLog("Page Display", "Error checking if Link to Customer page is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get the page title
     * 
     * @return The page title text
     */
    public String getPageTitle() {
        try {
            waitUntilElementVisible(pageTitle, 10);
            return getTextFromElement(pageTitle);
        } catch (Exception e) {
            addTestLog("Page Title", "Error getting page title: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Search for customer using identifier and search type
     * 
     * @param customerIdentifier The customer identifier (ID, email, phone, etc.)
     * @param searchType The type of search to perform
     */
    public void searchCustomer(String customerIdentifier, String searchType) {
        try {
            // Wait for search elements to be visible
            waitUntilElementVisible(customerSearchInput, 10);
            waitUntilElementVisible(searchTypeDropdown, 10);
            waitUntilElementVisible(customerSearchButton, 10);
            
            // Select search type from dropdown
            if (searchType != null && !searchType.isEmpty()) {
                Select searchTypeSelect = new Select(driver.findElement(searchTypeDropdown));
                searchTypeSelect.selectByVisibleText(searchType);
                addTestLog("Search", "Selected search type: " + searchType, Status.PASS);
            }
            
            // Enter customer identifier
            enterText(customerSearchInput, customerIdentifier);
            addTestLog("Search", "Entered customer identifier: " + maskCustomerIdentifier(customerIdentifier), Status.PASS);
            
            // Click search button
            clickElement(customerSearchButton);
            addTestLog("Search", "Clicked customer search button", Status.PASS);
            
            // Wait for search results
            waitUntilElementVisible(customerSearchResults, 15);
            
        } catch (Exception e) {
            addTestLog("Search", "Failed to search for customer: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Check if customer search results are displayed
     * 
     * @return true if results are displayed, false otherwise
     */
    public boolean isCustomerSearchResultsDisplayed() {
        try {
            return elementVisible(customerSearchResults, 10);
        } catch (Exception e) {
            addTestLog("Search Results", "Error checking if customer search results are displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get customer information from search results
     * 
     * @param customerIndex The index of the customer in results (0-based)
     * @return Customer information as a string
     */
    public String getCustomerInformation(int customerIndex) {
        try {
            waitUntilElementVisible(customerSearchResults, 10);
            
            // Find customer result rows
            java.util.List<WebElement> customerRows = driver.findElements(customerResultRow);
            
            if (customerIndex >= 0 && customerIndex < customerRows.size()) {
                WebElement customerRow = customerRows.get(customerIndex);
                
                // Extract customer information
                String customerName = customerRow.findElement(customerNameField).getText();
                String customerId = customerRow.findElement(customerIdField).getText();
                
                return "Name: " + customerName + ", ID: " + customerId;
            } else {
                addTestLog("Customer Info", "Customer index " + customerIndex + " is out of range", Status.WARNING);
                return "";
            }
            
        } catch (Exception e) {
            addTestLog("Customer Info", "Error getting customer information: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Click customer ellipsis menu
     */
    public void clickCustomerEllipsisMenu() {
        try {
            waitUntilElementVisible(customerEllipsisMenu, 10);
            clickElement(customerEllipsisMenu);
            addTestLog("Menu", "Clicked customer ellipsis menu", Status.PASS);
        } catch (Exception e) {
            addTestLog("Menu", "Failed to click customer ellipsis menu: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Select Link to Customer action from customer results
     */
    public void selectLinkToCustomerFromResults() {
        try {
            waitUntilElementVisible(linkToCustomerFromResults, 10);
            clickElement(linkToCustomerFromResults);
            addTestLog("Action", "Selected Link to Customer from results", Status.PASS);
            
            // Wait for customer verification section to appear
            waitUntilElementVisible(customerVerificationSection, 15);
            
        } catch (Exception e) {
            addTestLog("Action", "Failed to select Link to Customer from results: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Check if customer verification section is displayed
     * 
     * @return true if verification section is displayed, false otherwise
     */
    public boolean isCustomerVerificationSectionDisplayed() {
        try {
            return elementVisible(customerVerificationSection, 10);
        } catch (Exception e) {
            addTestLog("Verification Section", "Error checking if customer verification section is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get customer details for verification
     * 
     * @return Customer details as a string
     */
    public String getCustomerDetailsForVerification() {
        try {
            waitUntilElementVisible(customerVerificationSection, 10);
            
            String customerName = getTextFromElement(customerNameField);
            String customerId = getTextFromElement(customerIdField);
            String customerEmail = getTextFromElement(customerEmailField);
            String customerPhone = getTextFromElement(customerPhoneField);
            
            return String.format("Name: %s, ID: %s, Email: %s, Phone: %s", 
                customerName, customerId, customerEmail, customerPhone);
                
        } catch (Exception e) {
            addTestLog("Customer Details", "Error getting customer details for verification: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Mask customer identifier for logging (security)
     * 
     * @param identifier The original customer identifier
     * @return Masked identifier
     */
    private String maskCustomerIdentifier(String identifier) {
        if (identifier == null || identifier.length() < 3) {
            return "***";
        }
        return identifier.substring(0, 3) + "***";
    }
}