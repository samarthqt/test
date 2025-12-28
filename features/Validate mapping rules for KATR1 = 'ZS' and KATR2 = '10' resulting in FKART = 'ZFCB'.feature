Feature: Validate mapping rules for KATR1 = 'ZS' and KATR2 = '10' resulting in FKART = 'ZFCB'

  @TC-578
  Scenario: User logs into SAP S/4HANA Cloud
    Given user has appropriate credentials
    When user logs into the SAP S/4HANA Cloud system
    Then user is successfully logged in

  @TC-578
  Scenario Outline: Validate Sales Order creation with KATR1 and KATR2 mapping rules
    Given user has navigated to the Sales Order creation screen
    When user creates a Sales Order with KATR1 = "<KATR1>" and KATR2 = "<KATR2>"
    Then the Sales Order is created successfully with the correct mapping rules

    Examples:
      | KATR1 | KATR2 |
      | ZS    | 10    |

  @TC-578
  Scenario: User navigates to the Sales Order to Billing Document copy process
    Given user is on the SAP S/4HANA Cloud homepage
    When user navigates to the Sales Order to Billing Document copy process
    Then Sales Order copy process screen is displayed

  @TC-578
  Scenario Outline: Validate Billing Document creation from Sales Order
    Given user is on the Sales Order copy process screen
    When user selects the Sales Order with KATR1 = "<KATR1>" and KATR2 = "<KATR2>"
    And user initiates the copy process to create the Billing Document
    Then the Billing Document type FKART is "<FKART>"
    And no errors are displayed during the copy process

    Examples:
      | KATR1 | KATR2 | FKART |
      | ZS    | 10    | ZFCB  |

  @TC-578
  Scenario: Validate mapping rules in system configuration
    Given user has access to system configuration
    When user validates the mapping rules for KATR1 = 'ZS' and KATR2 = '10'
    Then mapping rules correctly define FKART = 'ZFCB'

  @TC-578
  Scenario: Save the Billing Document and verify its status
    Given user has successfully created a Billing Document
    When user saves the Billing Document
    Then the Billing Document is saved successfully with status 'Completed'

  @TC-578
  Scenario: Generate a report of the Billing Document for auditing purposes
    Given user has a completed Billing Document
    When user generates a report for the Billing Document
    Then the report is generated successfully with correct FKART details

  @TC-578
  Scenario: User logs out of the system
    Given user has completed all tasks
    When user logs out of the SAP S/4HANA Cloud system
    Then user is logged out successfully

  @TC-578
  Scenario: Review the audit trail for Billing Document creation
    Given user has access to the audit trail
    When user reviews the audit trail for the Billing Document creation
    Then audit trail confirms accurate mapping and process completion

  @TC-578
  Scenario Outline: Verify Billing Document type in downstream systems
    Given user has completed the Billing Document creation process
    When user verifies the Billing Document type in downstream systems
    Then downstream systems correctly reflect FKART = "<FKART>"

    Examples:
      | FKART |
      | ZFCB  |