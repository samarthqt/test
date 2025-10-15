Feature: Verify suppression of ZPDT billing outputs for Attribute 7 set to '10' under high-volume conditions

  @TC-263
  Scenario: User logs into the SAP S/4HANA system and verifies access
    Given user logs into the SAP S/4HANA system with appropriate credentials
    Then user gains access to the Finance module

  @TC-263
  Scenario: User navigates to Payer Business Partner master data maintenance screen
    Given user navigates to the Payer Business Partner master data maintenance screen
    Then the Payer Business Partner master data screen is displayed

  @TC-263
  Scenario Outline: User assigns Attribute 7 the value '10' to multiple Payer Business Partners
    Given user selects Payer Business Partner IDs "<payer_id>"
    When user assigns Attribute 7 the value "<attribute_value>"
    Then Attribute 7 is successfully updated to "<attribute_value>" for the specified payers

    Examples:
      | payer_id       | attribute_value |
      | PBP001         | 10              |
      | PBP002         | 10              |
      | PBP003         | 10              |

  @TC-263
  Scenario: User creates a high volume of billing documents for specified payers
    Given user has updated Attribute 7 to '10' for specified payers
    When user creates a high volume of billing documents (e.g., 10,000 documents) for the specified payers
    Then high-volume billing documents are created successfully

  @TC-263
  Scenario: User triggers the output determination process for billing documents
    Given user has created high-volume billing documents
    When user triggers the output determination process for the created billing documents
    Then output determination process is initiated for all billing documents

  @TC-263
  Scenario: User inspects the output logs for generated billing documents
    Given user has triggered the output determination process
    When user inspects the output logs for the generated billing documents
    Then no ZPDT billing outputs are generated for payers with Attribute 7 set to '10'

  @TC-263
  Scenario: User verifies system performance metrics during high-volume processing
    Given user processes high-volume billing documents
    When user monitors system performance metrics
    Then system performance remains stable with no degradation

  @TC-263
  Scenario: User checks for error messages or warnings related to Attribute 7 configuration
    Given user has updated Attribute 7 for specified payers
    When user checks for error messages or warnings related to Attribute 7 configuration
    Then no errors or warnings are displayed for Attribute 7 configuration

  @TC-263
  Scenario: User validates that all other outputs (not ZPDT) are generated successfully
    Given user has triggered the output determination process
    When user validates the outputs for the billing documents
    Then all other outputs are generated correctly without any issues

  @TC-263
  Scenario: User compares the output determination behavior with expected suppression logic
    Given user has inspected output logs
    When user compares the output determination behavior with the expected suppression logic
    Then output determination behavior aligns with the expected suppression logic for Attribute 7 set to '10'

  @TC-263
  Scenario: User generates a report summarizing output determination results
    Given user has verified suppression of ZPDT billing outputs
    When user generates a report summarizing the output determination results for the processed billing documents
    Then report is generated successfully, showing suppressed ZPDT outputs for Attribute 7 set to '10'

  @TC-263
  Scenario: User saves test results and documents observations
    Given user has completed all validations and tests
    When user saves the test results and documents any observations or deviations
    Then test results are saved, and observations are documented