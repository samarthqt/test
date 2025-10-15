Feature: Validate system behavior when mandatory fields are missing in ZRK correction request

  @TC-96
  Scenario Outline: Ensure the system rejects ZRK correction requests with missing mandatory fields
    Given the user logs in to the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "<Correction Request Type>" as the correction request type
    When the user leaves the mandatory fields "<Customer ID>" and "<Billing Document Number>" blank
    And the user submits the form
    Then the system prevents submission and displays an error message indicating mandatory fields are missing
    When the user attempts to bypass the error message and submits the form again
    Then the system continues to block submission and displays the same error message
    And no correction request is created in the system

    Examples:
      | Correction Request Type | Customer ID | Billing Document Number |
      | ZRK                    |             |                         |

  @TC-96
  Scenario: Verify system behavior when navigating away from the form with errors
    Given the user logs in to the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "ZRK" as the correction request type
    And the user leaves the mandatory fields blank
    When the user attempts to navigate away from the form without correcting the errors
    Then the system prompts the user to save or discard changes
    When the user discards the changes and exits the form
    Then the changes are discarded, and the user is redirected to the previous page

  @TC-96
  Scenario: Verify no incomplete correction requests exist after logging back in
    Given the user logs in to the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "ZRK" as the correction request type
    And the user leaves the mandatory fields blank
    When the user logs out of the SAP system
    And the user logs back in to the SAP system
    Then no incomplete correction requests are found in the system