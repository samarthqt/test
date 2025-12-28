Feature: Validate edge case for maximum line items in billing corrections

  @TC-104
  Scenario: User logs into the SAP system with valid credentials
    Given the user has valid credentials
    When the user logs into the SAP system
    Then the user successfully logs into the SAP system

  @TC-104
  Scenario: User navigates to the billing correction form
    Given the user is logged into the SAP system
    When the user navigates to the billing correction form using the appropriate transaction code
    Then the billing correction form is displayed

  @TC-104
  Scenario: User creates a new correction request
    Given the user is on the billing correction form
    When the user selects the option to create a new correction request
    Then the system displays the form for creating a new correction request

  @TC-104
  Scenario Outline: User enters ZG2C document number and validates line items
    Given the user is on the form to create a new correction request
    When the user enters a ZG2C document number with "<line_items>" line items
    Then the system retrieves the document details and displays all "<line_items>" line items

    Examples:
      | line_items |
      | 999        |

  @TC-104
  Scenario: User fills in all mandatory fields for the correction request
    Given the user has entered the document details
    When the user fills in all mandatory fields for the correction request
    Then all mandatory fields are populated without errors

  @TC-104
  Scenario: User submits the correction request
    Given the user has populated all mandatory fields
    When the user submits the correction request
    Then the system accepts the submission and processes the correction request

  @TC-104
  Scenario: System generates the appropriate output for the correction request
    Given the correction request has been submitted
    When the system processes the correction request
    Then the system generates the appropriate output for the correction request

  @TC-104
  Scenario: Validate document flow for all line items in the correction request
    Given the correction request has been processed
    When the user checks the document flow
    Then the document flow shows all line items linked to the correction request

  @TC-104
  Scenario: Validate system performance during correction request processing
    Given the correction request is being processed
    When the user monitors the system performance
    Then the system performance remains within acceptable limits

  @TC-104
  Scenario: Generate a report to confirm the accuracy of the correction request
    Given the correction request has been processed
    When the user generates a report for the correction request
    Then the report confirms the correction request includes all 999 line items

  @TC-104
  Scenario: User logs out of the SAP system
    Given the user has completed all required actions
    When the user logs out of the SAP system
    Then the user successfully logs out of the system