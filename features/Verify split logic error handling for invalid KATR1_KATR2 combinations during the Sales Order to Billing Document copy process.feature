Feature: Verify split logic error handling for invalid KATR1/KATR2 combinations during the Sales Order to Billing Document copy process

  @TC-449
  Scenario Outline: Validate system behavior for invalid KATR1/KATR2 combinations during Sales Order to Billing Document copy
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    When the user navigates to the Sales Order module and selects the option to create a new Sales Order
    And the user enters the required details for the Sales Order with KATR1 "<KATR1>" and KATR2 "<KATR2>"
    And the user saves the Sales Order and notes the Sales Order number
    And the user navigates to the Billing module and selects the option to create a Billing Document
    And the user enters the Sales Order number created in the previous step
    And the user executes the process to copy the Sales Order to a Billing Document
    Then the system displays a clear and meaningful error message indicating the invalid attribute values
    And the Billing Document is not created, and the process is halted

    Examples:
      | KATR1      | KATR2 |
      | ''         | '10'  |
      | 'INVALID'  | ''    |
      | 'INVALID'  | 'INVALID' |
      | ''         | ''    |

  @TC-449
  Scenario: Verify successful login to the SAP S/4HANA system
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    Then the user is successfully logged in and navigates to the SAP home screen

  @TC-449
  Scenario: Verify logout from the SAP S/4HANA system
    Given the user is logged into the SAP S/4HANA system
    When the user logs out of the SAP system
    Then the user is successfully logged out of the system

  @TC-449
  Scenario: Document error messages and system behavior for analysis
    Given the user has completed the validation of invalid KATR1/KATR2 combinations
    When the user documents the error messages and system behavior
    Then the error messages and system behavior are documented for review