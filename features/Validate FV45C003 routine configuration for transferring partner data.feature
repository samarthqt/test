Feature: Validate FV45C003 routine configuration for transferring partner data  
  Ensure the FV45C003 routine is correctly configured and successfully transfers partner data during Sales document creation. Ensure the original Billing document exists with complete partner data at the header level.

  @TC-189
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user is on the SAP S/4HANA Cloud login page  
    When the user enters valid login credentials  
    Then the user successfully logs into the system  

  @TC-189
  Scenario: User navigates to transaction VA01 for creating Sales documents  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to transaction "VA01"  
    Then the VA01 transaction screen is displayed  

  @TC-189
  Scenario Outline: User enters the original Billing document number as a reference  
    Given the user is on the VA01 transaction screen  
    When the user enters the original Billing document number "<billingDocumentNumber>" as the reference  
    Then the billing document details are retrieved successfully  
    And the partner data mappings "<partnerMapping>" are displayed  

    Examples:  
      | billingDocumentNumber | partnerMapping                                      |  
      | 45678901              | CVBPA-KUNNR PARVW = 'AG' to XVBPA-KUNNR PARVW = 'AG' |  

  @TC-189
  Scenario: Verify the presence of header partner data in the Billing document  
    Given the user has retrieved the billing document details  
    When the user verifies the header partner data in the Billing document  
    Then the system confirms the presence of complete header partner data  

  @TC-189
  Scenario: Execute the Sales document creation process  
    Given the user is on the VA01 transaction screen with valid billing document details  
    When the user initiates the Sales document creation process  
    Then the system begins processing the request  

  @TC-189
  Scenario: Validate that the partner data is copied correctly  
    Given the Sales document creation process has started  
    When the user verifies the partner data in the target document  
    Then the partner data is copied accurately based on the mappings  

  @TC-189
  Scenario: Save the Sales document  
    Given the Sales document is ready to be saved  
    When the user saves the Sales document  
    Then the Sales document is saved successfully  

  @TC-189
  Scenario: Navigate to the 'display billing detail' report  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the 'display billing detail' report  
    Then the 'display billing detail' report screen is displayed  

  @TC-189
  Scenario: Verify referenced sales orders are visible in the report  
    Given the user is on the 'display billing detail' report screen  
    When the user verifies the referenced sales orders in the report  
    Then the referenced sales orders are displayed correctly in the report  

  @TC-189
  Scenario: Check linkage between the Sales document and the original Billing document  
    Given the Sales document and the original Billing document exist  
    When the user verifies the linkage between the two documents  
    Then the linkage is established correctly, ensuring traceability  

  @TC-189
  Scenario: Validate completion of the FV45C003 routine  
    Given the Sales document creation process has completed  
    When the user verifies the completion of the FV45C003 routine  
    Then the routine completes successfully without errors  

  @TC-189
  Scenario: User logs out of the SAP system  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user logs out of the system  
    Then the user logs out successfully