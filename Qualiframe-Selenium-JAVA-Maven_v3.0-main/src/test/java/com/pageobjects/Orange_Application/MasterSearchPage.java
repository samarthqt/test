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
import org.testng.Assert;

import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import com.framework.report.Status;
import java.util.Date;
import java.awt.Container;

/**
 * Page Object for MSD CRM Master Search functionality
 * 
 * @author Automation Team
 * @version 1.0
 */
public class MasterSearchPage extends WebReusableComponents {

    // Page locators
    private final By masterSearchDropdown = By.id("masterSearchDropdown");
    private final By cardNumberInput = By.id("cardNumberInput");
    private final By expirationDateInput = By.id("expirationDateInput");
    private final By searchButton = By.id("searchButton");
    private final By searchResultsContainer = By.className("searchResults");
    private final By customerResultField = By.className("customerResult");
    private final By cardTypeField = By.className("cardType");
    private final By cardStatusField = By.className("cardStatus");
    private final By riderClassField = By.className("riderClass");
    private final By accountField = By.className("account");
    private final By actionsMenu = By.className("actionsMenu");
    private final By linkToCustomerAction = By.xpath("//button[contains(text(),'Link to Customer')]");
    private final By ellipsisMenu = By.className("ellipsisMenu");
    
    // Page title and navigation
    private final By pageTitle = By.tagName("h1");
    private final By navigationMenu = By.className("navigationMenu");
    private final By searchMenuItem = By.xpath("//a[contains(text(),'Search')]");
    private final By masterSearchMenuItem = By.xpath("//a[contains(text(),'Master Search')]");

    public MasterSearchPage(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }

    /**
     * Navigate to MSD CRM application
     * 
     * @param msdCrmUrl The MSD CRM application URL
     */
    public void navigateToMSDCRM(String msdCrmUrl) {
        try {
            launchUrl(msdCrmUrl);
            addTestLog("Navigation", "Successfully navigated to MSD CRM: " + msdCrmUrl, Status.PASS);
        } catch (Exception e) {
            addTestLog("Navigation", "Failed to navigate to MSD CRM: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Navigate to Master Search section
     */
    public void navigateToMasterSearch() {
        try {
            // Click on Search menu
            if (elementVisible(searchMenuItem)) {
                clickElement(searchMenuItem);
                addTestLog("Navigation", "Clicked on Search menu", Status.PASS);
            }
            
            // Click on Master Search submenu
            if (elementVisible(masterSearchMenuItem)) {
                clickElement(masterSearchMenuItem);
                addTestLog("Navigation", "Clicked on Master Search submenu", Status.PASS);
            }
            
            // Wait for page to load
            waitUntilPageReadyStateComplete(10);
            
        } catch (Exception e) {
            addTestLog("Navigation", "Failed to navigate to Master Search: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Check if Master Search page is displayed
     * 
     * @return true if page is displayed, false otherwise
     */
    public boolean isMasterSearchPageDisplayed() {
        try {
            return elementVisible(pageTitle, 10) && 
                   getTextFromElement(pageTitle).contains("Master Search");
        } catch (Exception e) {
            addTestLog("Page Display", "Error checking if Master Search page is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get the default dropdown value
     * 
     * @return The default dropdown value
     */
    public String getDefaultDropdownValue() {
        try {
            waitUntilElementVisible(masterSearchDropdown, 10);
            WebElement dropdown = driver.findElement(masterSearchDropdown);
            return dropdown.getAttribute("value");
        } catch (Exception e) {
            addTestLog("Dropdown Value", "Error getting default dropdown value: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Search for OMNY card using card number and expiration date
     * 
     * @param cardNumber The OMNY card number
     * @param expirationDate The card expiration date
     */
    public void searchOMNYCard(String cardNumber, String expirationDate) {
        try {
            // Wait for page elements to be visible
            waitUntilElementVisible(cardNumberInput, 10);
            waitUntilElementVisible(expirationDateInput, 10);
            waitUntilElementVisible(searchButton, 10);
            
            // Enter card number
            enterText(cardNumberInput, cardNumber);
            addTestLog("Search", "Entered card number: " + maskCardNumber(cardNumber), Status.PASS);
            
            // Enter expiration date
            enterText(expirationDateInput, expirationDate);
            addTestLog("Search", "Entered expiration date: " + expirationDate, Status.PASS);
            
            // Click search button
            clickElement(searchButton);
            addTestLog("Search", "Clicked search button", Status.PASS);
            
            // Wait for search results
            waitUntilElementVisible(searchResultsContainer, 15);
            
        } catch (Exception e) {
            addTestLog("Search", "Failed to search for OMNY card: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Check if search results are displayed
     * 
     * @return true if results are displayed, false otherwise
     */
    public boolean isSearchResultsDisplayed() {
        try {
            return elementVisible(searchResultsContainer, 10);
        } catch (Exception e) {
            addTestLog("Search Results", "Error checking if search results are displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get customer search result
     * 
     * @return The customer search result
     */
    public String getCustomerSearchResult() {
        try {
            waitUntilElementVisible(customerResultField, 10);
            return getTextFromElement(customerResultField);
        } catch (Exception e) {
            addTestLog("Customer Result", "Error getting customer search result: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Check if card type is displayed
     * 
     * @return true if card type is displayed, false otherwise
     */
    public boolean isCardTypeDisplayed() {
        try {
            return elementVisible(cardTypeField, 5);
        } catch (Exception e) {
            addTestLog("Card Type", "Error checking if card type is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Check if card status is displayed
     * 
     * @return true if card status is displayed, false otherwise
     */
    public boolean isCardStatusDisplayed() {
        try {
            return elementVisible(cardStatusField, 5);
        } catch (Exception e) {
            addTestLog("Card Status", "Error checking if card status is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Check if rider class is displayed
     * 
     * @return true if rider class is displayed, false otherwise
     */
    public boolean isRiderClassDisplayed() {
        try {
            return elementVisible(riderClassField, 5);
        } catch (Exception e) {
            addTestLog("Rider Class", "Error checking if rider class is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Check if account is displayed
     * 
     * @return true if account is displayed, false otherwise
     */
    public boolean isAccountDisplayed() {
        try {
            return elementVisible(accountField, 5);
        } catch (Exception e) {
            addTestLog("Account", "Error checking if account is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Check if Link to Customer action is available
     * 
     * @return true if action is available, false otherwise
     */
    public boolean isLinkToCustomerActionAvailable() {
        try {
            return elementVisible(linkToCustomerAction, 5);
        } catch (Exception e) {
            addTestLog("Link Action", "Error checking if Link to Customer action is available: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Click the ellipsis menu
     */
    public void clickEllipsisMenu() {
        try {
            waitUntilElementVisible(ellipsisMenu, 10);
            clickElement(ellipsisMenu);
            addTestLog("Menu", "Clicked ellipsis menu", Status.PASS);
        } catch (Exception e) {
            addTestLog("Menu", "Failed to click ellipsis menu: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Select Link to Customer action from menu
     */
    public void selectLinkToCustomerAction() {
        try {
            waitUntilElementVisible(linkToCustomerAction, 10);
            clickElement(linkToCustomerAction);
            addTestLog("Action", "Selected Link to Customer action", Status.PASS);
            
            // Wait for page navigation
            waitUntilPageReadyStateComplete(10);
            
        } catch (Exception e) {
            addTestLog("Action", "Failed to select Link to Customer action: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Mask card number for logging (security)
     * 
     * @param cardNumber The original card number
     * @return Masked card number
     */
    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "****";
        }
        return "****" + cardNumber.substring(cardNumber.length() - 4);
    }
}