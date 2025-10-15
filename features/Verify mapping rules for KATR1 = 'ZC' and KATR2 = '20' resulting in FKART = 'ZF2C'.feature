Feature: Verify mapping rules for KATR1 = 'ZC' and KATR2 = '20' resulting in FKART = 'ZF2C'

  @TC-577
  Scenario Outline: Validate mapping rules and the generated Billing Document type FKART
    Given the user logs into SAP S/4HANA Cloud with valid credentials
    And the user creates a Sales Order with KATR1 = "<KATR1>" and KATR2 = "<KATR2>"
    When the user navigates to the Sales Order to Billing Document copy process
    And the user selects the Sales Order with KATR1 = "<KATR1>" and KATR2 = "<KATR2>"
    And the user initiates the copy process to create the Billing Document
    Then the generated Billing Document type FKART should be "<ExpectedFKART>"
    And the mapping rules for KATR1 = "<KATR1>" and KATR2 = "<KATR2>" in the system configuration should define FKART = "<ExpectedFKART>"
    And no error messages should be displayed during the copy process
    When the user saves the Billing Document
    Then the Billing Document should be saved successfully with status "<Status>"
    And the user generates a report of the Billing Document for auditing purposes
    Then the report should be generated successfully with correct FKART details
    And the user logs out of the system
    When the user reviews the audit trail for the Billing Document creation
    Then the audit trail should confirm accurate mapping and process completion
    And the Billing Document type in downstream systems should reflect "<ExpectedFKART>"

    Examples:
      | KATR1 | KATR2 | ExpectedFKART | Status     |
      | ZC    | 20    | ZF2C          | Completed  |