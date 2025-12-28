Feature: Ensure system prevents email dispatch with misconfigured settings  
  Validate that the system blocks email dispatch and logs errors when settings are misconfigured.  

  @TC-116  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given user is on the SAP S/4HANA Cloud login page  
    When user enters valid credentials  
    Then user is successfully logged in and navigates to the main dashboard  

  @TC-116  
  Scenario: User navigates to the Billing document module  
    Given user is on the main dashboard  
    When user navigates to the Billing document module  
    Then the Billing document module is displayed  

  @TC-116  
  Scenario: User searches for a Billing document  
    Given user is in the Billing document module  
    When user searches for the Billing document ID "BD002"  
    Then the Billing document "BD002" is displayed with details  

  @TC-116  
  Scenario: User navigates to the email communication module  
    Given user is on the Billing document details page  
    When user navigates to the email communication module  
    Then the email communication module is displayed  

  @TC-116  
  Scenario: User searches for the email record linked to a Billing document  
    Given user is in the email communication module  
    When user searches for the email record linked to Billing document "BD002"  
    Then the email record is displayed with status "Error"  

  @TC-116  
  Scenario: User checks the error message for the email record  
    Given the email record linked to Billing document "BD002" has status "Error"  
    When user views the error message for the email record  
    Then the error message indicates misconfigured email settings  

  @TC-116  
  Scenario: User reviews the system logs for error details  
    Given the email record linked to Billing document "BD002" has an error status  
    When user reviews the system logs for the error  
    Then the system logs provide detailed information on the misconfiguration  

  @TC-116  
  Scenario: User attempts to resend the email manually with misconfigured settings  
    Given the email record linked to Billing document "BD002" has an error status  
    When user attempts to resend the email manually  
    Then the system prevents manual resend due to misconfiguration  

  @TC-116  
  Scenario Outline: User corrects email settings and resends the email  
    Given the email record linked to Billing document "<BillingDocumentID>" has an error status  
    When user corrects the email settings  
    And user attempts to resend the email  
    Then the email is successfully resent  
    And the linkage between the corrected email and Billing document "<BillingDocumentID>" is accurate and complete  

    Examples:  
      | BillingDocumentID |  
      | BD002             |  

  @TC-116  
  Scenario: User verifies the overall workflow for error handling during email dispatch  
    Given the system has handled an email dispatch error for Billing document "BD002"  
    When user reviews the workflow for error handling  
    Then the workflow functions correctly with proper error handling  

  @TC-116  
  Scenario: User validates system logs for tracking corrections and successful email dispatch  
    Given the email settings for Billing document "BD002" have been corrected  
    When user reviews the system logs  
    Then the logs confirm corrections and successful email dispatch