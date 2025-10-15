Feature: Validate FV45C003 copy routine for transferring header partner data  
  Ensure the FV45C003 copy routine correctly transfers header partner data from the Billing document to the Sales document. Ensure the original Billing document exists with complete header partner data (Sold-to, Bill-to, Payer, Ship-to).  

  @TC-187  
  Scenario: User successfully logs into the SAP S/4HANA Cloud system  
    Given the user is on the SAP S/4HANA Cloud login page  
    When the user enters valid login credentials  
    Then the user is logged into the system  

  @TC-187  
  Scenario: User navigates to transaction VA01 for creating Sales documents  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to transaction VA01  
    Then the VA01 transaction screen is displayed  

  @TC-187  
  Scenario Outline: User enters the original Billing document number as the reference  
    Given the user is on the VA01 transaction screen  
    When the user enters the original Billing document number "<BillingDocumentNumber>" as the reference  
    Then the Billing document details are retrieved successfully  
    And the header partner data includes complete data for Sold-to, Bill-to, Payer, and Ship-to  

    Examples:  
      | BillingDocumentNumber |  
      | 23456789              |  

  @TC-187  
  Scenario: User verifies the presence of header partner data in the Billing document  
    Given the user has entered the Billing document number as the reference  
    When the user views the header partner data  
    Then the system confirms complete header partner data  

  @TC-187  
  Scenario: User executes the Sales document creation process  
    Given the user has verified the header partner data  
    When the user initiates the Sales document creation process  
    Then the system begins processing the request  

  @TC-187  
  Scenario: User validates partner data is copied correctly based on the mappings  
    Given the user has initiated the Sales document creation process  
    When the user validates the partner data mappings  
    Then the partner data is copied accurately to the target document  

  @TC-187  
  Scenario: User saves the Sales document  
    Given the user has validated the copied partner data  
    When the user saves the Sales document  
    Then the Sales document is saved successfully  

  @TC-187  
  Scenario: User navigates to the 'display billing detail' report  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the 'display billing detail' report  
    Then the 'display billing detail' report screen is displayed  

  @TC-187  
  Scenario: User verifies the referenced sales orders are visible in the report  
    Given the user is on the 'display billing detail' report screen  
    When the user reviews the report  
    Then the referenced sales orders are displayed correctly in the report  

  @TC-187  
  Scenario: User checks the linkage between the Sales document and the original Billing document  
    Given the user has reviewed the referenced sales orders  
    When the user checks the linkage between the Sales document and the original Billing document  
    Then the linkage is established correctly, ensuring traceability  

  @TC-187  
  Scenario: User validates the completion of the copy routine  
    Given the user has checked the linkage between the Sales document and the Billing document  
    When the user validates the copy routine  
    Then the copy routine completes without errors  

  @TC-187  
  Scenario: User logs out of the SAP system  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user logs out of the system  
    Then the user logs out successfully