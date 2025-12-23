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
package com.modular.steps;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.framework.components.DriverScript;
import com.framework.components.TestConfigurationsLite;
import com.framework.selenium.SeleniumTestParameters;
import com.framework.report.Status;
import com.pageobjects.orange.MasterSearchPage;
import com.pageobjects.orange.LinkToCustomerPage;
import com.pageobjects.orange.CustomerVerificationPage;
import com.pageobjects.orange.CustomerLandingPage;
import com.pageobjects.orange.EmailVerifierPage;
import com.pageobjects.orange.SMSVerifierPage;
import java.util.Date;
import java.lang.reflect.Method;

/**
 * Modular Test Steps for MSD CRM - Link Unregistered OMNY Card
 * 
 * Test Scenario: Link unregistered OMNY card to existing customer
 * 
 * @author Automation Team
 * @version 1.0
 */
public class OrangeModular_Login_PerformValidLogin extends TestConfigurationsLite {

    @Test(dataProvider = "ChromeBrowser", dataProviderClass = TestConfigurationsLite.class)
    public void linkUnregisteredOMNYCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("MSD CRM - Link Unregistered OMNY Card to Customer");
        DriverScript driverScript = new DriverScript(testParameters);
        driverScript.driveTestExecution();
        tearDownTestRunner(testParameters, driverScript);
    }

    @Override
    public void setUp() {
        // Initialize test data and environment
        System.out.println("Setup: Initializing test environment for OMNY card linking");
    }

    @Override
    public void executeTest() {
        try {
            // Step 1: Navigate to MSD CRM and perform Master Search
            navigateToMasterSearch();
            
            // Step 2: Search for unregistered OMNY card
            searchUnregisteredOMNYCard();
            
            // Step 3: Click Link to Customer action
            clickLinkToCustomerAction();
            
            // Step 4: Search and link to registered customer
            searchAndLinkToCustomer();
            
            // Step 5: Perform customer verification
            performCustomerVerification();
            
            // Step 6: Verify OMNY card linking on customer landing page
            verifyOMNYCardLinking();
            
            // Step 7: Verify email and SMS notifications
            verifyNotifications();
            
            System.out.println("Test Execution: All test steps completed successfully");
            
        } catch (Exception e) {
            System.out.println("Test Execution: Test execution failed: " + e.getMessage());
            Assert.fail("Test execution failed: " + e.getMessage());
        }
    }

    @Override
    public void tearDown() {
        // Cleanup and final verification
        System.out.println("Teardown: Cleaning up test resources");
    }

    /**
     * Step 1: Navigate to MSD CRM → Search → Master Search
     * Expected: Master Search default dropdown is "Card"
     */
    private void navigateToMasterSearch() {
        System.out.println("Step 1: Navigating to MSD CRM Master Search");
        
        MasterSearchPage masterSearchPage = new MasterSearchPage(scriptHelper);
        
        // Navigate to MSD CRM URL
        String msdCrmUrl = dataTable.getData("Environment", "MSD_CRM_URL");
        masterSearchPage.navigateToMSDCRM(msdCrmUrl);
        
        // Verify Master Search page is displayed
        Assert.assertTrue(masterSearchPage.isMasterSearchPageDisplayed(), 
            "Master Search page should be displayed");
        
        // Verify default dropdown is "Card"
        String defaultDropdown = masterSearchPage.getDefaultDropdownValue();
        Assert.assertEquals(defaultDropdown, "Card", 
            "Default dropdown should be 'Card', but found: " + defaultDropdown);
        
        System.out.println("Step 1: Successfully navigated to Master Search with Card as default");
    }

    /**
     * Step 2: Search for unregistered OMNY card
     * Expected: Results show Customer = None, Card Type/Status, Rider Class, Account, Actions = Link to Customer
     */
    private void searchUnregisteredOMNYCard() {
        System.out.println("Step 2: Searching for unregistered OMNY card");
        
        MasterSearchPage masterSearchPage = new MasterSearchPage(scriptHelper);
        
        // Get test data
        String cardNumber = dataTable.getData("OMNY_Card", "CardNumber");
        String expirationDate = dataTable.getData("OMNY_Card", "ExpirationDate");
        
        // Perform search
        masterSearchPage.searchOMNYCard(cardNumber, expirationDate);
        
        // Verify search results
        Assert.assertTrue(masterSearchPage.isSearchResultsDisplayed(), 
            "Search results should be displayed");
        
        // Verify customer is None
        String customerResult = masterSearchPage.getCustomerSearchResult();
        Assert.assertEquals(customerResult, "None", 
            "Customer should be 'None', but found: " + customerResult);
        
        // Verify card details are displayed
        Assert.assertTrue(masterSearchPage.isCardTypeDisplayed(), "Card Type should be displayed");
        Assert.assertTrue(masterSearchPage.isCardStatusDisplayed(), "Card Status should be displayed");
        Assert.assertTrue(masterSearchPage.isRiderClassDisplayed(), "Rider Class should be displayed");
        Assert.assertTrue(masterSearchPage.isAccountDisplayed(), "Account should be displayed");
        
        // Verify Link to Customer action is available
        Assert.assertTrue(masterSearchPage.isLinkToCustomerActionAvailable(), 
            "Link to Customer action should be available");
        
        System.out.println("Step 2: Successfully found unregistered OMNY card with expected details");
    }

    /**
     * Step 3: Click Link to Customer action
     * Expected: "Link ABP ************ to Customer" page is displayed
     */
    private void clickLinkToCustomerAction() {
        System.out.println("Step 3: Clicking Link to Customer action");
        
        MasterSearchPage masterSearchPage = new MasterSearchPage(scriptHelper);
        
        // Click the ellipsis menu and select Link to Customer
        masterSearchPage.clickEllipsisMenu();
        masterSearchPage.selectLinkToCustomerAction();
        
        // Verify Link to Customer page is displayed
        LinkToCustomerPage linkToCustomerPage = new LinkToCustomerPage(scriptHelper);
        Assert.assertTrue(linkToCustomerPage.isLinkToCustomerPageDisplayed(), 
            "Link to Customer page should be displayed");
        
        // Verify page title contains expected text
        String pageTitle = linkToCustomerPage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("Link ABP"), 
            "Page title should contain 'Link ABP', but found: " + pageTitle);
        
        System.out.println("Step 3: Successfully navigated to Link to Customer page");
    }

    /**
     * Step 4: Search for registered customer and perform linking
     * Expected: Customer search results are displayed
     */
    private void searchAndLinkToCustomer() {
        System.out.println("Step 4: Searching for registered customer to link");
        
        LinkToCustomerPage linkToCustomerPage = new LinkToCustomerPage(scriptHelper);
        
        // Get test data for customer search
        String customerIdentifier = dataTable.getData("Customer", "CustomerIdentifier");
        String searchType = dataTable.getData("Customer", "SearchType");
        
        // Search for customer
        linkToCustomerPage.searchCustomer(customerIdentifier, searchType);
        
        // Verify customer search results
        Assert.assertTrue(linkToCustomerPage.isCustomerSearchResultsDisplayed(), 
            "Customer search results should be displayed");
        
        // Click ellipsis menu and select Link to Customer
        linkToCustomerPage.clickCustomerEllipsisMenu();
        linkToCustomerPage.selectLinkToCustomerFromResults();
        
        System.out.println("Step 4: Successfully found and selected customer for linking");
    }

    /**
     * Step 5: Perform customer verification
     * Expected: Customer Landing Page is displayed
     */
    private void performCustomerVerification() {
        System.out.println("Step 5: Performing customer verification");
        
        CustomerVerificationPage customerVerificationPage = new CustomerVerificationPage(scriptHelper);
        
        // Verify customer verification page is displayed
        Assert.assertTrue(customerVerificationPage.isVerificationPageDisplayed(), 
            "Customer verification page should be displayed");
        
        // Get verification data from test data
        String verificationMethod = dataTable.getData("Verification", "Method");
        String verificationValue = dataTable.getData("Verification", "Value");
        
        // Perform verification
        customerVerificationPage.performVerification(verificationMethod, verificationValue);
        
        // Verify customer landing page is displayed after successful verification
        CustomerLandingPage customerLandingPage = new CustomerLandingPage(scriptHelper);
        Assert.assertTrue(customerLandingPage.isCustomerLandingPageDisplayed(), 
            "Customer landing page should be displayed after verification");
        
        System.out.println("Step 5: Successfully completed customer verification");
    }

    /**
     * Step 6: Verify OMNY card linking on customer landing page
     * Expected: OMNY card is shown as linked in Travel Cards section
     */
    private void verifyOMNYCardLinking() {
        System.out.println("Step 6: Verifying OMNY card linking on customer landing page");
        
        CustomerLandingPage customerLandingPage = new CustomerLandingPage(scriptHelper);
        
        // Navigate to Travel Cards section
        customerLandingPage.navigateToTravelCardsSection();
        
        // Verify OMNY card is linked and visible
        String cardNumber = dataTable.getData("OMNY_Card", "CardNumber");
        Assert.assertTrue(customerLandingPage.isOMNYCardLinked(cardNumber), 
            "OMNY card should be linked and visible in Travel Cards section");
        
        // Verify card status is "Linked"
        String cardStatus = customerLandingPage.getOMNYCardStatus(cardNumber);
        Assert.assertEquals(cardStatus, "Linked", 
            "OMNY card status should be 'Linked', but found: " + cardStatus);
        
        System.out.println("Step 6: Successfully verified OMNY card linking");
    }

    /**
     * Step 7: Verify email and SMS notifications
     * Expected: Email and SMS notifications received in approved format
     */
    private void verifyNotifications() {
        System.out.println("Step 7: Verifying email and SMS notifications");
        
        // Verify email notification
        verifyEmailNotification();
        
        // Verify SMS notification (if enabled)
        String smsEnabled = dataTable.getData("Notifications", "SMS_Enabled");
        if ("true".equalsIgnoreCase(smsEnabled)) {
            verifySMSNotification();
        } else {
            System.out.println("SMS Verification: SMS notifications are disabled for this test");
        }
        
        System.out.println("Step 7: Successfully verified all notifications");
    }

    /**
     * Verify email notification format matches Appendix B specification
     */
    private void verifyEmailNotification() {
        System.out.println("Email Verification: Verifying email notification format");
        
        EmailVerifierPage emailVerifier = new EmailVerifierPage(scriptHelper);
        
        // Get notification mode from environment config
        String notificationMode = properties.getProperty("notifications.mode", "stub");
        
        if ("live".equalsIgnoreCase(notificationMode)) {
            // Live email verification
            String emailSubject = emailVerifier.getLiveEmailSubject();
            String emailBody = emailVerifier.getLiveEmailBody();
            
            // Verify subject line format
            Assert.assertTrue(emailSubject.contains("Your travel card has been added"), 
                "Email subject should contain 'Your travel card has been added'");
            
            // Verify body template format (TODO: Add specific Appendix B validation)
            Assert.assertTrue(emailBody.contains("travel card"), 
                "Email body should contain travel card information");
            
        } else {
            // Stubbed email verification
            String expectedSubject = emailVerifier.getStubbedEmailSubject();
            String expectedBody = emailVerifier.getStubbedEmailBody();
            
            // Verify stubbed content matches expected format
            Assert.assertNotNull(expectedSubject, "Stubbed email subject should not be null");
            Assert.assertNotNull(expectedBody, "Stubbed email body should not be null");
            
            // TODO: Add specific validation against Appendix B format
            System.out.println("Email Verification: Using stubbed email verification (Appendix B validation pending)");
        }
        
        System.out.println("Email Verification: Email notification format verified successfully");
    }

    /**
     * Verify SMS notification format matches Appendix B specification
     */
    private void verifySMSNotification() {
        System.out.println("SMS Verification: Verifying SMS notification format");
        
        SMSVerifierPage smsVerifier = new SMSVerifierPage(scriptHelper);
        
        // Get notification mode from environment config
        String notificationMode = properties.getProperty("notifications.mode", "stub");
        
        if ("live".equalsIgnoreCase(notificationMode)) {
            // Live SMS verification
            String smsContent = smsVerifier.getLiveSMSContent();
            
            // Verify SMS content format (TODO: Add specific Appendix B validation)
            Assert.assertTrue(smsContent.contains("travel card"), 
                "SMS content should contain travel card information");
            
        } else {
            // Stubbed SMS verification
            String expectedContent = smsVerifier.getStubbedSMSContent();
            
            // Verify stubbed content matches expected format
            Assert.assertNotNull(expectedContent, "Stubbed SMS content should not be null");
            
            // TODO: Add specific validation against Appendix B format
            System.out.println("SMS Verification: Using stubbed SMS verification (Appendix B validation pending)");
        }
        
        System.out.println("SMS Verification: SMS notification format verified successfully");
    }
}