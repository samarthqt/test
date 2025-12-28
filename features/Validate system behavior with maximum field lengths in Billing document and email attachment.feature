Feature: Validate system behavior with maximum field lengths in Billing document and email attachment  
  Ensure the system handles maximum field lengths in the Billing document and email attachment without errors.  

  @TC-117  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user is on the SAP S/4HANA Cloud login page  
    When the user enters valid credentials  
    Then the user is successfully logged in and navigates to the main dashboard  

  @TC-117  
  Scenario: User navigates to the Billing document module  
    Given the user is on the main dashboard  
    When the user navigates to the Billing document module  
    Then the Billing document module is displayed  

  @TC-117  
  Scenario Outline: User searches for a Billing document ID and verifies its details  
    Given the user is in the Billing document module  
    When the user searches for the Billing document ID "<BillingDocumentID>"  
    Then the Billing document "<BillingDocumentID>" is displayed with details  
    And the document type is correctly set to "<DocumentType>"  
    And fields are populated with maximum allowable lengths without errors  

    Examples:  
      | BillingDocumentID | DocumentType |  
      | BD003             | ZFR          |  

  @TC-117  
  Scenario: User navigates to the email communication module  
    Given the user is on the main dashboard  
    When the user navigates to the email communication module  
    Then the email communication module is displayed  

  @TC-117  
  Scenario Outline: User searches for an email record linked to a Billing document  
    Given the user is in the email communication module  
    When the user searches for the email record linked to the Billing document ID "<BillingDocumentID>"  
    Then the email record is displayed with status "<EmailStatus>"  

    Examples:  
      | BillingDocumentID | EmailStatus |  
      | BD003             | Sent        |  

  @TC-117  
  Scenario Outline: User verifies the attachment size and format in the email record  
    Given the user has accessed the email record linked to the Billing document ID "<BillingDocumentID>"  
    When the user verifies the attachment details  
    Then the attachment size is "<AttachmentSize>"  
    And the format is "<AttachmentFormat>"  

    Examples:  
      | BillingDocumentID | AttachmentSize | AttachmentFormat |  
      | BD003             | 25 MB          | PDF              |  

  @TC-117  
  Scenario Outline: User downloads the attachment and validates its content  
    Given the user has accessed the email record linked to the Billing document ID "<BillingDocumentID>"  
    When the user downloads the attachment  
    Then the attachment content matches the Billing document details accurately  

    Examples:  
      | BillingDocumentID |  
      | BD003             |  

  @TC-117  
  Scenario Outline: User checks the system logs for errors during attachment generation  
    Given the user has accessed the email record linked to the Billing document ID "<BillingDocumentID>"  
    When the user checks the system logs  
    Then no errors are logged during the process  

    Examples:  
      | BillingDocumentID |  
      | BD003             |  

  @TC-117  
  Scenario Outline: User validates the linkage between the Billing document and the email  
    Given the user has accessed the email record linked to the Billing document ID "<BillingDocumentID>"  
    When the user validates the linkage  
    Then the linkage between the Billing document and the email is accurate and complete  

    Examples:  
      | BillingDocumentID |  
      | BD003             |  

  @TC-117  
  Scenario: User verifies the overall workflow for handling maximum field lengths and data size  
    Given the user has completed the process for handling maximum field lengths and data size  
    When the user reviews the workflow  
    Then the workflow functions correctly without errors or delays