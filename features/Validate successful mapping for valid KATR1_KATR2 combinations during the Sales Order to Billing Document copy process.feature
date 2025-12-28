Feature: Validate successful mapping for valid KATR1/KATR2 combinations during the Sales Order to Billing Document copy process

  @TC-549
  Scenario Outline: Validate mapping rules and successful creation of Billing Document
    Given the user logs into the SAP S/4HANA system with valid credentials
    And the user navigates to the Sales Order to Billing Document copy process
    And the user enters the Sales Order ID "<SalesOrderID>" in the input field
    Then the system retrieves the Sales Order details
    And KATR1 value is displayed as "<KATR1>" and KATR2 value is displayed as "<KATR2>"
    When the user initiates the copy process to create a Billing Document
    Then the copy process is initiated successfully
    And no errors are displayed in the system log
    And the Billing Document is created and displayed with the correct FKART value
    And the VBAK table contains the correct FKART value corresponding to the Sales Order
    And the mapping rules for KATR1 and KATR2 are applied correctly as per the configuration
    And data integrity is maintained in all related tables
    When the user generates a report of the Sales Order and Billing Document for audit purposes
    Then the report is generated successfully with accurate data
    When the user logs out of the SAP S/4HANA system
    Then the user is logged out successfully

    Examples:
      | SalesOrderID | KATR1 | KATR2 |
      | SO12345      | A1    | B2    |
      | SO67890      | C3    | D4    |
      | SO11111      | E5    | F6    |