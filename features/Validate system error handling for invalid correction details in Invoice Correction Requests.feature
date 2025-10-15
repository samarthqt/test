Feature: Validate system error handling for invalid correction details in Invoice Correction Requests

  @TC-394
  Scenario: User logs into the SAP S/4HANA system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-394
  Scenario: User navigates to the Invoice Correction Request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Invoice Correction Request creation screen
    Then the Invoice Correction Request creation screen is displayed

  @TC-394
  Scenario: User selects an existing sales invoice for correction
    Given the user is on the Invoice Correction Request creation screen
    When the user selects an existing sales invoice with invoice number "INV12345" for correction
    Then the selected invoice details are populated on the correction request screen

  @TC-394
  Scenario Outline: Validate system behavior for invalid correction details
    Given the user has selected an existing sales invoice for correction
    When the user enters invalid correction details with <correction_type> and <invalid_detail>
    Then the entered invalid details are displayed in the respective fields
    And the user attempts to save the Invoice Correction Request
    Then the system prevents saving the correction request
    And the system displays an error message "<error_message>"
    And no new Invoice Correction Request is created in the system
    And the system logs contain detailed entries about the invalid input attempt

    Examples:
      | correction_type | invalid_detail        | error_message                          |
      | ZRK            | Negative Quantity -10 | Negative quantity is not allowed.      |
      | ZRK            | Negative Price -100   | Negative price is not allowed.         |

  @TC-394
  Scenario: User attempts to navigate away from the Invoice Correction Request screen
    Given the user has entered invalid correction details
    When the user attempts to navigate away from the Invoice Correction Request screen
    Then the system prompts the user to confirm navigation without saving

  @TC-394
  Scenario: User confirms navigation without saving
    Given the system prompts the user to confirm navigation without saving
    When the user confirms navigation without saving
    Then the user is redirected to the previous screen without saving the request

  @TC-394
  Scenario Outline: Validate consistent system behavior across different invalid inputs
    Given the user has selected an existing sales invoice for correction
    When the user enters invalid correction details with <correction_type> and <invalid_detail>
    And the user attempts to save the Invoice Correction Request
    Then the system prevents saving the correction request
    And the system displays an error message "<error_message>"
    And no new Invoice Correction Request is created in the system

    Examples:
      | correction_type | invalid_detail        | error_message                          |
      | ZRK            | Negative Quantity -10 | Negative quantity is not allowed.      |
      | ZRK            | Negative Price -100   | Negative price is not allowed.         |