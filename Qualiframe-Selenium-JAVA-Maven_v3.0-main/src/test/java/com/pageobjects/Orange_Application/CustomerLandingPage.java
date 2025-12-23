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
import java.util.List;

import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import com.framework.report.Status;
import java.util.List;
import java.awt.Container;

/**
 * Page Object for MSD CRM Customer Landing Page functionality
 * 
 * @author Automation Team
 * @version 1.0
 */
public class CustomerLandingPage extends WebReusableComponents {

    // Page locators
    private final By landingPageContainer = By.className("customerLandingPage");
    private final By pageTitle = By.tagName("h1");
    private final By customerInfoSection = By.className("customerInfoSection");
    private final By travelCardsSection = By.className("travelCardsSection");
    private final By travelCardsHeader = By.xpath("//h2[contains(text(),'Travel Cards')]");
    
    // Customer information fields
    private final By customerNameField = By.className("customerName");
    private final By customerIdField = By.className("customerId");
    private final By customerEmailField = By.className("customerEmail");
    private final By customerPhoneField = By.className("customerPhone");
    private final By customerAddressField = By.className("customerAddress");
    
    // Travel cards elements
    private final By travelCardRows = By.className("travelCardRow");
    private final By cardNumberField = By.className("cardNumber");
    private final By cardTypeField = By.className("cardType");
    private final By cardStatusField = By.className("cardStatus");
    private final By cardExpirationField = By.className("cardExpiration");
    private final By cardBalanceField = By.className("cardBalance");
    
    // Navigation elements
    private final By navigationMenu = By.className("navigationMenu");
    private final By profileMenuItem = By.xpath("//a[contains(text(),'Profile')]");
    private final By settingsMenuItem = By.xpath("//a[contains(text(),'Settings')]");
    private final By logoutMenuItem = By.xpath("//a[contains(text(),'Logout')]");

    public CustomerLandingPage(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }

    /**
     * Check if customer landing page is displayed
     * 
     * @return true if page is displayed, false otherwise
     */
    public boolean isCustomerLandingPageDisplayed() {
        try {
            return elementVisible(landingPageContainer, 10) && 
                   elementVisible(pageTitle, 10);
        } catch (Exception e) {
            addTestLog("Page Display", "Error checking if customer landing page is displayed: " + e.getMessage(), Status.WARNING);
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
     * Get customer information
     * 
     * @return Customer information as a formatted string
     */
    public String getCustomerInformation() {
        try {
            waitUntilElementVisible(customerInfoSection, 10);
            
            String customerName = getTextFromElement(customerNameField);
            String customerId = getTextFromElement(customerIdField);
            String customerEmail = getTextFromElement(customerEmailField);
            String customerPhone = getTextFromElement(customerPhoneField);
            String customerAddress = getTextFromElement(customerAddressField);
            
            String customerInfo = String.format("Name: %s, ID: %s, Email: %s, Phone: %s, Address: %s",
                customerName, customerId, customerEmail, customerPhone, customerAddress);
            
            addTestLog("Customer Info", "Retrieved customer information successfully", Status.PASS);
            return customerInfo;
            
        } catch (Exception e) {
            addTestLog("Customer Info", "Error getting customer information: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Navigate to Travel Cards section
     */
    public void navigateToTravelCardsSection() {
        try {
            // Check if travel cards section is already visible
            if (!elementVisible(travelCardsSection, 5)) {
                // Scroll to travel cards section
                WebElement travelCardsHeaderElement = driver.findElement(travelCardsHeader);
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", travelCardsHeaderElement);
                
                addTestLog("Navigation", "Scrolled to Travel Cards section", Status.PASS);
            }
            
            // Wait for travel cards section to be visible
            waitUntilElementVisible(travelCardsSection, 10);
            addTestLog("Navigation", "Successfully navigated to Travel Cards section", Status.PASS);
            
        } catch (Exception e) {
            addTestLog("Navigation", "Failed to navigate to Travel Cards section: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Check if Travel Cards section is displayed
     * 
     * @return true if section is displayed, false otherwise
     */
    public boolean isTravelCardsSectionDisplayed() {
        try {
            return elementVisible(travelCardsSection, 10);
        } catch (Exception e) {
            addTestLog("Travel Cards Section", "Error checking if Travel Cards section is displayed: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get all travel cards information
     * 
     * @return Array of travel card information strings
     */
    public String[] getAllTravelCards() {
        try {
            waitUntilElementVisible(travelCardsSection, 10);
            
            List<WebElement> cardRows = driver.findElements(travelCardRows);
            String[] cards = new String[cardRows.size()];
            
            for (int i = 0; i < cardRows.size(); i++) {
                WebElement cardRow = cardRows.get(i);
                
                String cardNumber = cardRow.findElement(cardNumberField).getText();
                String cardType = cardRow.findElement(cardTypeField).getText();
                String cardStatus = cardRow.findElement(cardStatusField).getText();
                String cardExpiration = cardRow.findElement(cardExpirationField).getText();
                String cardBalance = cardRow.findElement(cardBalanceField).getText();
                
                cards[i] = String.format("Card %d: %s, Type: %s, Status: %s, Exp: %s, Balance: %s",
                    i + 1, maskCardNumber(cardNumber), cardType, cardStatus, cardExpiration, cardBalance);
            }
            
            addTestLog("Travel Cards", "Retrieved " + cards.length + " travel cards", Status.PASS);
            return cards;
            
        } catch (Exception e) {
            addTestLog("Travel Cards", "Error getting all travel cards: " + e.getMessage(), Status.WARNING);
            return new String[0];
        }
    }

    /**
     * Check if specific OMNY card is linked
     * 
     * @param cardNumber The OMNY card number to check
     * @return true if card is linked, false otherwise
     */
    public boolean isOMNYCardLinked(String cardNumber) {
        try {
            waitUntilElementVisible(travelCardsSection, 10);
            
            List<WebElement> cardRows = driver.findElements(travelCardRows);
            
            for (WebElement cardRow : cardRows) {
                String currentCardNumber = cardRow.findElement(cardNumberField).getText();
                String cardType = cardRow.findElement(cardTypeField).getText();
                
                // Check if this is the OMNY card we're looking for
                if (currentCardNumber.equals(cardNumber) && "OMNY".equalsIgnoreCase(cardType)) {
                    addTestLog("OMNY Card", "Found OMNY card: " + maskCardNumber(cardNumber), Status.PASS);
                    return true;
                }
            }
            
            addTestLog("OMNY Card", "OMNY card not found: " + maskCardNumber(cardNumber), Status.WARNING);
            return false;
            
        } catch (Exception e) {
            addTestLog("OMNY Card", "Error checking if OMNY card is linked: " + e.getMessage(), Status.WARNING);
            return false;
        }
    }

    /**
     * Get OMNY card status
     * 
     * @param cardNumber The OMNY card number
     * @return The card status
     */
    public String getOMNYCardStatus(String cardNumber) {
        try {
            waitUntilElementVisible(travelCardsSection, 10);
            
            List<WebElement> cardRows = driver.findElements(travelCardRows);
            
            for (WebElement cardRow : cardRows) {
                String currentCardNumber = cardRow.findElement(cardNumberField).getText();
                String cardType = cardRow.findElement(cardTypeField).getText();
                
                // Check if this is the OMNY card we're looking for
                if (currentCardNumber.equals(cardNumber) && "OMNY".equalsIgnoreCase(cardType)) {
                    String cardStatus = cardRow.findElement(cardStatusField).getText();
                    addTestLog("OMNY Card Status", "Retrieved status for OMNY card: " + cardStatus, Status.PASS);
                    return cardStatus;
                }
            }
            
            addTestLog("OMNY Card Status", "OMNY card not found for status check", Status.WARNING);
            return "";
            
        } catch (Exception e) {
            addTestLog("OMNY Card Status", "Error getting OMNY card status: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Get OMNY card details
     * 
     * @param cardNumber The OMNY card number
     * @return The card details as a formatted string
     */
    public String getOMNYCardDetails(String cardNumber) {
        try {
            waitUntilElementVisible(travelCardsSection, 10);
            
            List<WebElement> cardRows = driver.findElements(travelCardRows);
            
            for (WebElement cardRow : cardRows) {
                String currentCardNumber = cardRow.findElement(cardNumberField).getText();
                String cardType = cardRow.findElement(cardTypeField).getText();
                
                // Check if this is the OMNY card we're looking for
                if (currentCardNumber.equals(cardNumber) && "OMNY".equalsIgnoreCase(cardType)) {
                    String cardStatus = cardRow.findElement(cardStatusField).getText();
                    String cardExpiration = cardRow.findElement(cardExpirationField).getText();
                    String cardBalance = cardRow.findElement(cardBalanceField).getText();
                    
                    String cardDetails = String.format("OMNY Card: %s, Status: %s, Expiration: %s, Balance: %s",
                        maskCardNumber(cardNumber), cardStatus, cardExpiration, cardBalance);
                    
                    addTestLog("OMNY Card Details", "Retrieved details for OMNY card", Status.PASS);
                    return cardDetails;
                }
            }
            
            addTestLog("OMNY Card Details", "OMNY card not found for details", Status.WARNING);
            return "";
            
        } catch (Exception e) {
            addTestLog("OMNY Card Details", "Error getting OMNY card details: " + e.getMessage(), Status.WARNING);
            return "";
        }
    }

    /**
     * Navigate to customer profile
     */
    public void navigateToCustomerProfile() {
        try {
            if (elementVisible(profileMenuItem)) {
                clickElement(profileMenuItem);
                addTestLog("Navigation", "Clicked on Profile menu item", Status.PASS);
                
                // Wait for page navigation
                waitUntilPageReadyStateComplete(10);
                
            } else {
                addTestLog("Navigation", "Profile menu item not available", Status.WARNING);
            }
            
        } catch (Exception e) {
            addTestLog("Navigation", "Failed to navigate to customer profile: " + e.getMessage(), Status.FAIL);
            throw e;
        }
    }

    /**
     * Logout from customer account
     */
    public void logoutFromCustomerAccount() {
        try {
            if (elementVisible(logoutMenuItem)) {
                clickElement(logoutMenuItem);
                addTestLog("Logout", "Clicked on Logout menu item", Status.PASS);
                
                // Wait for logout to complete
                waitUntilPageReadyStateComplete(10);
                
            } else {
                addTestLog("Logout", "Logout menu item not available", Status.WARNING);
            }
            
        } catch (Exception e) {
            addTestLog("Logout", "Failed to logout from customer account: " + e.getMessage(), Status.FAIL);
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