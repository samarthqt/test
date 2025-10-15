Feature: Validate system behavior when attempting to exceed maximum entries in condition table 911

  @TC-558
  Scenario Outline: Verify that the system prevents adding entries beyond the maximum capacity of condition table 911
    Given the user is logged into the SAP system with appropriate credentials
    And the user navigates to the condition table maintenance transaction
    And the condition table 911 is populated with the maximum allowed entries
    When the user selects condition table 911 for maintenance
    And the user attempts to add an additional entry with Sales Org "<Sales Org>", Billing Type "<Billing Type>", and Attribute 7 "<Attribute 7>"
    Then the system prevents the additional entry and displays an error message "<Error Message>"
    And all existing entries in the condition table remain intact
    And the system logs indicate the attempt to exceed capacity and the corresponding error handling
    And the system's performance remains stable without any degradation
    And the condition table enforces its maximum capacity effectively
    And no additional entries are present in the condition table beyond its maximum capacity
    And the system's error handling aligns with documented requirements

    Examples:
      | Sales Org | Billing Type | Attribute 7 | Error Message                  |
      | 1000      | F2           | Value1      | Capacity limit exceeded        |
      | 2000      | F3           | Value2      | Maximum table capacity reached |

  @TC-558
  Scenario: Verify that the system enforces maximum capacity for condition table 911 without any issues
    Given the user is logged into the SAP system with appropriate credentials
    And the user navigates to the condition table maintenance transaction
    And the condition table 911 is populated with the maximum allowed entries
    When the user selects condition table 911 for maintenance
    Then the condition table enforces its maximum capacity effectively
    And no additional entries are present in the condition table beyond its maximum capacity