Feature: Validate error handling for ZPB1 output generation with missing email configuration  
  Ensure the system provides meaningful error messages when email configuration for ZPB1 output is missing.

  @TC-535
  Scenario Outline: User triggers ZPB1 output processing and validates error handling for missing email configuration
    Given the user logs into the SAP S/4HANA system with authorized credentials
    And the user navigates to the periodic billing document processing transaction
    And the user searches for the ZFR document with ID "<document_id>"
    When the user selects the ZFR document and triggers the output processing for "<output_type>"
    Then the system displays an error message indicating "<error_message>"
    And no email is dispatched for the ZFR document
    And the user logs out of the SAP S/4HANA system

    Examples:
      | document_id | output_type | error_message                                    |
      | ZFR99999    | ZPB1        | Missing email configuration for ZPB1 output     |