Feature: Validate error handling for missing mandatory fields in billing corrections

  @TC-103
  Scenario Outline: Validate that the system blocks the creation of billing corrections when mandatory fields are missing
    Given the user logs into the SAP system with valid credentials
    And the user navigates to the billing correction form using the appropriate transaction code
    And the user selects the option to create a new correction request
    When the user enters a document type "<Document Type>" and leaves the "<Missing Field>" field blank
    And the user attempts to submit the correction request
    Then the system prevents submission and displays an error message indicating the missing mandatory field "<Missing Field>"
    And the system does not create any correction request with missing mandatory fields
    And the user logs out of the SAP system

    Examples:
      | Document Type | Missing Field  |
      | ZG2C          | Customer ID    |