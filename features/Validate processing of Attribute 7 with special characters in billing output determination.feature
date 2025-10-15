Feature: Validate processing of Attribute 7 with special characters in billing output determination

  @TC-281
  Scenario Outline: Validate the processing of Attribute 7 in payer master data with special characters
    Given the user logs into the SAP system with valid credentials
    And the field catalog for billing output (ZPDT) includes Attribute 7
    When the user navigates to the transaction for maintaining payer master data
    And the user populates Attribute 7 in the payer master data with "<special_characters>"
    And the user saves the changes to the payer master data
    Then Attribute 7 is updated with "<special_characters>" without errors

    Examples:
      | special_characters       |
      | !@#$%^&*()_+{}|:"<>?     |
      | ~`[];',./-=\             |

  @TC-281
  Scenario: Verify Attribute 7 is included in the field catalog
    Given the user navigates to the field catalog configuration screen (ZPDT)
    Then Attribute 7 is present in the field catalog

  @TC-281
  Scenario: Create and validate a billing document with Attribute 7
    Given the user creates a new billing document with standard data
    When the user triggers the output determination process for the billing document
    Then the output determination process is triggered without errors

  @TC-281
  Scenario: Verify output determination logs and generated output for Attribute 7
    Given the user inspects the output determination logs
    Then the logs show that Attribute 7 with special characters is processed successfully
    And the generated output reflects the processed Attribute 7 values correctly

  @TC-281
  Scenario: Check for data integrity in the generated output
    Given the user verifies the generated output
    Then no data integrity issues are identified in the output

  @TC-281
  Scenario: Document test results and close session
    Given the user documents the test results
    Then the session is closed successfully