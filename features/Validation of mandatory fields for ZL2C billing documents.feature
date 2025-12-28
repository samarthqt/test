Feature: Validation of mandatory fields for ZL2C billing documents

  The system should handle missing mandatory fields gracefully when creating ZL2C billing documents, ensuring that errors are displayed, and invalid data is not processed.

  @TC-46
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-46
  Scenario: User navigates to the billing correction request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing correction request creation screen
    Then the billing correction request creation screen is displayed

  @TC-46
  Scenario: User enters original billing document number and selects billing correction request type
    Given the user is on the billing correction request creation screen
    When the user enters the original billing document number "12345678" and selects billing correction request type "ZRK1"
    Then the billing correction request is linked to the original document

  @TC-46
  Scenario Outline: Validation of missing mandatory fields in billing correction request
    Given the user is on the billing correction request creation screen
    When the user enters the original billing document number "<billingDocumentNumber>" and selects billing correction request type "<requestType>"
    And the user leaves mandatory fields "<mandatoryField>" blank
    Then the system displays a warning or error message indicating that "<errorMessage>"
    When the user attempts to save the billing correction request
    Then the system prevents the billing correction request from being saved

    Examples:
      | billingDocumentNumber | requestType | mandatoryField      | errorMessage                          |
      | 12345678              | ZRK1        | Customer number     | Customer number is missing            |
      | 12345678              | ZRK1        | Billing date        | Billing date is missing               |
      | 12345678              | ZRK1        | Customer number, Billing date | Customer number and Billing date are missing |

  @TC-46
  Scenario: System prevents generation of ZL2C billing document linked to invalid billing correction request
    Given the user has an invalid billing correction request with missing mandatory fields
    When the user attempts to generate a ZL2C billing document linked to the invalid billing correction request
    Then the system displays an error message and prevents the ZL2C billing document from being generated

  @TC-46
  Scenario: System logs detailed error messages for missing mandatory fields
    Given the user has attempted to save a billing correction request with missing mandatory fields
    When the user checks the system logs
    Then the system logs contain detailed error messages regarding the missing mandatory fields

  @TC-46
  Scenario: User logs out of the SAP S/4HANA system
    Given the user is logged into the SAP S/4HANA system
    When the user logs out of the SAP S/4HANA system
    Then the user is successfully logged out