Feature: Validate processing of Attribute 7 with minimum boundary values in billing output determination

  @TC-282
  Scenario Outline: Validate Attribute 7 processing with minimum boundary values in payer master data and billing output determination
    Given the user is logged into the SAP system with valid credentials
    And the user navigates to the transaction for maintaining payer master data
    When the user populates Attribute 7 in the payer master data with "<attribute_7_value>"
    And the user saves the changes to the payer master data
    And the user navigates to the field catalog configuration screen (ZPDT)
    Then Attribute 7 is included in the field catalog
    When the user creates a new billing document with standard data
    And the user triggers the output determination process for the billing document
    Then the output determination logs show that Attribute 7 with "<attribute_7_value>" is processed successfully
    And the generated output is correct, reflecting the processed Attribute 7 values
    And there are no data integrity issues in the output
    And the user documents the test results and closes the session

    Examples:
      | attribute_7_value |
      | ''                |  # Empty string (minimum boundary value) |
      | 'A'               |  # Single character (minimum valid input) |