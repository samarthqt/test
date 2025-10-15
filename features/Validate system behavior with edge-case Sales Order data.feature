Feature: Validate system behavior with edge-case Sales Order data

  @TC-216
  Scenario Outline: Validate the system's handling of edge-case Sales Order data during the Billing Document creation process
    Given the user logs in to SAP S/4HANA Cloud with valid credentials
    And the user navigates to the Billing Document creation screen
    When the user enters the Sales Order ID "<Sales Order ID>" with data "<Sales Order Data>" in the relevant field
    And the user attempts to execute the Sales Order to Billing Document copy process
    Then the system starts processing the copy-control mappings
    And the system processes edge-case data without errors
    And the default routine RV60C900 is executed successfully
    And the generated Billing Document is accurate and complete
    And the document flow linkage between the Sales Order and the Billing Document is accurate and complete
    And the system logs indicate that RV60C900 was executed successfully
    And no error messages are displayed during the process
    And the financial postings related to the Billing Document are accurate and complete
    And the system complies with all relevant business rules for Billing Document creation

    Examples:
      | Sales Order ID | Sales Order Data        |
      | SO00000        | Null                   |
      | SO00000        | Empty                  |
      | SO00000        | Valid edge-case values |