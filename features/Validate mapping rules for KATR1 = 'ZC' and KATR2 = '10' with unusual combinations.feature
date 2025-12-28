Feature: Validate mapping rules for KATR1 = 'ZC' and KATR2 = '10' with unusual combinations

  @TC-582
  Scenario Outline: Ensure correct mapping of Billing Document type FKART for Sales Orders with KATR1 = 'ZC' and KATR2 = '10'
    Given the user has logged in to SAP S/4HANA Cloud with appropriate credentials
    And Sales Orders are created with KATR1 as "<KATR1>" and KATR2 as "<KATR2>"
    When the user navigates to the Sales Order to Billing Document copy process
    And the user selects the Sales Order with KATR1 as "<KATR1>" and KATR2 as "<KATR2>"
    And the user initiates the copy process to create the Billing Document
    Then the generated Billing Document type FKART should be "<ExpectedFKART>"
    And no errors should be displayed during the copy process
    And the Billing Document should be saved successfully with status "<Status>"
    And the mapping rules for KATR1 = "<KATR1>" and KATR2 = "<KATR2>" should define FKART as "<ExpectedFKART>"
    And the Billing Document type should be correctly reflected in downstream systems as "<ExpectedFKART>"

    Examples:
      | KATR1 | KATR2 | ExpectedFKART | Status     |
      | ZC    | 10    | ZFCB          | Completed  |

  @TC-582
  Scenario: Generate a report of the Billing Document for auditing purposes
    Given the user has successfully created a Billing Document with FKART = 'ZFCB'
    When the user generates a report of the Billing Document
    Then the report should be generated successfully with correct FKART details

  @TC-582
  Scenario: Review the audit trail for the Billing Document creation
    Given the user has successfully created a Billing Document with FKART = 'ZFCB'
    When the user reviews the audit trail for the Billing Document creation
    Then the audit trail should confirm accurate mapping and process completion

  @TC-582
  Scenario: Log out of the system
    Given the user has completed all required actions in the system
    When the user logs out of the system
    Then the user should be logged out successfully