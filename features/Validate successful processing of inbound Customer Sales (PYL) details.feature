Feature: Validate successful processing of inbound Customer Sales (PYL) details  
  Ensure the system processes inbound files with all mandatory fields, creating a ZOR sales order and mapping fields correctly.  

  @TC-322  
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has the appropriate credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is logged in successfully  
    And the user has access to the relevant modules  

  @TC-322  
  Scenario: User navigates to the interface processing module  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the interface processing module  
    Then the interface processing module is displayed  

  @TC-322  
  Scenario Outline: User uploads the inbound file containing Customer Sales (PYL) details  
    Given the user has a pipe-delimited inbound file with valid header, line, partner, and condition data  
    When the user uploads the inbound file  
    Then the file is uploaded successfully  
    And the default Sales Document Type "<SalesDocumentType>" and Sales Area "<SalesArea>" are applied  

    Examples:  
      | SalesDocumentType | SalesArea  |  
      | ZOR               | 1022/10/10 |  

  @TC-322  
  Scenario Outline: Verify mandatory fields in the inbound file  
    Given the user has uploaded the inbound file  
    When the user verifies the mandatory fields including the Lisbon Order ID  
    Then all mandatory fields are correctly populated  

    Examples:  
      | LisbonOrderID |  
      | VALID_ID_123  |  

  @TC-322  
  Scenario: User triggers the inbound interface processing manually  
    Given the user has uploaded the inbound file  
    When the user triggers the inbound interface processing manually  
    Then the inbound interface processing is triggered successfully  

  @TC-322  
  Scenario Outline: Ensure default Sales Document Type and Sales Area are applied where missing  
    Given the user has triggered the inbound interface processing  
    When the user checks for missing default values  
    Then the default Sales Document Type "<SalesDocumentType>" and Sales Area "<SalesArea>" are correctly applied  

    Examples:  
      | SalesDocumentType | SalesArea  |  
      | ZOR               | 1022/10/10 |  

  @TC-322  
  Scenario: Verify field mapping as per the mapping sheet  
    Given the user has triggered the inbound interface processing  
    When the user verifies the field mapping  
    Then all fields are mapped correctly as per the mapping sheet  

  @TC-322  
  Scenario: Check missing fields are labeled appropriately  
    Given the user has verified the field mapping  
    When the user checks for any missing fields  
    Then missing fields are labeled as 'Not specified in source'  

  @TC-322  
  Scenario: Validate the creation of the ZOR sales order  
    Given the user has completed the field mapping  
    When the user validates the creation of the ZOR sales order  
    Then the ZOR sales order is created successfully with all mapped fields  

  @TC-322  
  Scenario: Review system logs for errors or warnings  
    Given the user has validated the creation of the ZOR sales order  
    When the user reviews the system logs  
    Then no errors or warnings are found in the logs  

  @TC-322  
  Scenario: Document findings and share with the operations team  
    Given the user has reviewed the system logs  
    When the user documents the findings  
    Then the findings are shared with the operations team effectively  

  @TC-322  
  Scenario: User logs out of the SAP system  
    Given the user has completed the documentation  
    When the user logs out of the SAP system  
    Then the user is logged out successfully