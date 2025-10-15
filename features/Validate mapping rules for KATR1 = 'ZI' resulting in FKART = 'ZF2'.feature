Feature: Validate mapping rules for KATR1 = 'ZI' resulting in FKART = 'ZF2'

  @TC-576
  Scenario Outline: Validate the mapping rules for KATR1 resulting in correct FKART value
    Given user logs in to SAP S/4HANA Cloud with valid credentials
    And user navigates to the Sales Order to Billing Document copy process
    When user selects the Sales Order with KATR1 = "<KATR1>"
    And user initiates the copy process to create the Billing Document
    Then the generated Billing Document type FKART should be "<FKART>"
    And the mapping rules for KATR1 = "<KATR1>" in the system configuration should correctly define FKART = "<FKART>"
    And no errors should be displayed during the copy process
    And user saves the Billing Document and verifies its status as "<Status>"
    And user generates a report of the Billing Document for auditing purposes
    Then the report should be generated successfully with correct FKART details
    And user logs out of the system
    And the audit trail for the Billing Document creation should confirm accurate mapping and process completion
    And the Billing Document type in downstream systems should correctly reflect FKART = "<FKART>"

    Examples:
      | KATR1 | FKART | Status     |
      | ZI    | ZF2   | Completed |

  @TC-576
  Scenario: Validate successful login to SAP S/4HANA Cloud
    Given user logs in to SAP S/4HANA Cloud with valid credentials
    Then user should be successfully logged in

  @TC-576
  Scenario: Verify Sales Order copy process screen display
    Given user navigates to the Sales Order to Billing Document copy process
    Then the Sales Order copy process screen should be displayed

  @TC-576
  Scenario: Review audit trail for Billing Document creation
    Given user reviews the audit trail for the Billing Document creation
    Then the audit trail should confirm accurate mapping and process completion

  @TC-576
  Scenario: Verify Billing Document type in downstream systems
    Given user verifies the Billing Document type in downstream systems
    Then downstream systems should correctly reflect FKART = 'ZF2'