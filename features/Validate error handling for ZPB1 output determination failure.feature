Feature: Validate error handling for ZPB1 output determination failure  
  Ensure the system prevents further processing when ZPB1 output determination fails.

  @TC-123
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has authorized credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the system  

  @TC-123
  Scenario: User navigates to the periodic billing document processing transaction  
    Given the user has the necessary authorization to process periodic billing documents  
    When the user navigates to the periodic billing document processing transaction (VF31)  
    Then the VF31 transaction screen is displayed  

  @TC-123
  Scenario Outline: Validate ZPB1 output determination failure during processing  
    Given the output type configuration is "<output_configuration>"  
      And the user has credentials with VF31 access  
    When the user enters the ZFR document number "<document_number>" in the appropriate field  
    Then the system retrieves the ZFR document details  
    When the user selects the ZFR document for processing  
    Then the ZFR document is selected and highlighted for processing  
    When the user triggers the output processing for the ZFR document  
    Then the system attempts to process the output for the ZFR document  
    When the user attempts to manually override the output determination settings  
    Then the system prevents manual overrides and maintains the error state  
    When the user attempts to process the ZFR document with an alternative output type  
    Then the system blocks further processing and displays an error message  
    When the user verifies the system logs for any additional error messages  
    Then the logs confirm the failure of ZPB1 output determination and the prevention of further processing  
    When the user checks the ZFR document status in the system  
    Then the ZFR document remains unprocessed for output  

    Examples:  
      | output_configuration | document_number |  
      | ZPB1 disabled         | ZFR67890        |  

  @TC-123
  Scenario Outline: Validate error handling for processing another ZFR document  
    Given the output type configuration is "<output_configuration>"  
      And the user has credentials with VF31 access  
    When the user attempts to process another ZFR document with the same output settings  
    Then the system displays the same error message for the second document  

    Examples:  
      | output_configuration |  
      | ZPB1 disabled         |  

  @TC-123
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user is logged into the SAP S/4HANA system  
    When the user logs out of the SAP S/4HANA system  
    Then the user is successfully logged out of the system  

  @TC-123
  Scenario: User reports the issue to the support team  
    Given the user identifies the issue with ZPB1 output determination  
    When the user reports the issue to the support team for further investigation  
    Then the support team is notified about the issue for further investigation