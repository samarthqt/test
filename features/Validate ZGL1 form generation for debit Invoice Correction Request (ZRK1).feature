Feature: Validate ZGL1 form generation for debit Invoice Correction Request (ZRK1)

  @TC-397
  Scenario: User logs into the SAP S/4HANA system successfully
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-397
  Scenario: User navigates to the Invoice Correction Request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Invoice Correction Request creation screen
    Then the Invoice Correction Request creation screen is displayed

  @TC-397
  Scenario Outline: User creates a debit Invoice Correction Request
    Given the user is on the Invoice Correction Request creation screen
    When the user selects the Invoice Correction Request type as "<request_type>"
    And the user enters the original billing document number "<billing_document>" and customer details "<customer>"
    And the user specifies the correction amount as "<correction_amount>"
    And the user saves the Invoice Correction Request
    Then the Invoice Correction Request is saved, and a request ID is generated

    Examples:
      | request_type | billing_document | customer  | correction_amount |
      | ZRK1         | 987654321        | XYZ Ltd   | 300.00            |

  @TC-397
  Scenario: System generates ZGL1 form linked to the correction request
    Given the user has created a debit Invoice Correction Request
    When the user verifies the system generates a ZGL1 form linked to the correction request
    Then the ZGL1 form is generated and linked to the Invoice Correction Request

  @TC-397
  Scenario: ZGL1 form is linked to the original billing document
    Given the ZGL1 form is generated
    When the user verifies the ZGL1 form is linked to the original billing document
    Then the ZGL1 form is correctly linked to the original billing document

  @TC-397
  Scenario: User reviews the content of the generated ZGL1 form
    Given the ZGL1 form is generated
    When the user opens the generated ZGL1 form
    Then the ZGL1 form content is accurate and matches the correction details

  @TC-397
  Scenario: User prints the ZGL1 form
    Given the ZGL1 form is generated
    When the user attempts to print the ZGL1 form
    Then the ZGL1 form is successfully printed

  @TC-397
  Scenario: User exports the ZGL1 form
    Given the ZGL1 form is generated
    When the user attempts to export the ZGL1 form
    Then the ZGL1 form is successfully exported

  @TC-397
  Scenario: ZGL1 form is accessible in the system for future reference
    Given the ZGL1 form is generated
    When the user verifies the ZGL1 form is accessible in the system
    Then the ZGL1 form is stored and accessible in the system