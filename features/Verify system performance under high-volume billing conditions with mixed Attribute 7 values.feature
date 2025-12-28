Feature: Verify system performance under high-volume billing conditions with mixed Attribute 7 values

  @TC-265
  Scenario: User logs into the SAP S/4HANA system and accesses the Finance module
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user gains access to the Finance module

  @TC-265
  Scenario: User navigates to the Payer Business Partner master data maintenance screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Payer Business Partner master data maintenance screen
    Then the Payer Business Partner master data screen is displayed

  @TC-265
  Scenario Outline: User assigns mixed Attribute 7 values to Payer Business Partners
    Given the user is on the Payer Business Partner master data maintenance screen
    When the user assigns Attribute 7 value "<Attribute 7 Value>" to Payer Business Partner "<Payer ID>"
    Then Attribute 7 is successfully updated for the specified Payer Business Partner

    Examples:
      | Attribute 7 Value | Payer ID  |
      | 10                | PBP001    |
      | blank             | PBP002    |
      | 10                | PBP003    |
      | blank             | PBP004    |
      | 10                | PBP005    |
      | blank             | PBP006    |

  @TC-265
  Scenario: User creates a high volume of billing documents
    Given the user has updated Attribute 7 values for multiple Payer Business Partners
    When the user creates 10,000 billing documents for the specified Payer Business Partners
    Then high-volume billing documents are created successfully

  @TC-265
  Scenario: User triggers the output determination process for created billing documents
    Given the user has created high-volume billing documents
    When the user triggers the output determination process
    Then the output determination process is initiated for all billing documents

  @TC-265
  Scenario Outline: User inspects output logs for generated billing documents
    Given the output determination process has been triggered
    When the user inspects the output logs for billing documents with Attribute 7 value "<Attribute 7 Value>"
    Then ZPDT billing outputs are "<Output>" for the specified Attribute 7 value

    Examples:
      | Attribute 7 Value | Output      |
      | 10                | suppressed  |
      | blank             | generated   |

  @TC-265
  Scenario: User verifies system performance during high-volume processing
    Given the user has triggered the output determination process
    When the user monitors system performance metrics
    Then the system performance remains stable with no degradation

  @TC-265
  Scenario: User checks for error messages or warnings related to Attribute 7 configuration
    Given the user has triggered the output determination process
    When the user checks for error messages or warnings
    Then no errors or warnings are displayed for Attribute 7 configuration

  @TC-265
  Scenario: User validates the correctness of ZPDT outputs
    Given the user has triggered the output determination process
    When the user validates the ZPDT outputs
    Then the ZPDT outputs are correctly formatted and contain all required information

  @TC-265
  Scenario: User compares output determination behavior with expected logic
    Given the user has triggered the output determination process
    When the user compares the output determination behavior with the expected logic for mixed Attribute 7 values
    Then the output determination behavior aligns with the expected logic for mixed Attribute 7 values

  @TC-265
  Scenario: User generates a report summarizing output determination results
    Given the user has completed the output determination process
    When the user generates a report summarizing the output determination results
    Then the report is generated successfully, showing suppressed and generated ZPDT outputs based on Attribute 7 values

  @TC-265
  Scenario: User saves test results and documents observations
    Given the user has completed the test process
    When the user saves the test results and documents any observations or deviations
    Then the test results are saved, and observations are documented