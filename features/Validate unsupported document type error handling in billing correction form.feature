Feature: Validate unsupported document type error handling in billing correction form

  @TC-105
  Scenario: User logs into the SAP system
    Given user has valid credentials
    When user logs into the SAP system
    Then user successfully accesses the SAP system

  @TC-105
  Scenario: User navigates to the billing correction form
    Given user is logged into the SAP system
    When user navigates to the billing correction form using the appropriate transaction code
    Then the billing correction form is displayed

  @TC-105
  Scenario: User selects the option to create a new correction request
    Given user is on the billing correction form
    When user selects the option to create a new correction request
    Then the system displays the form for creating a new correction request

  @TC-105
  Scenario Outline: User enters an unsupported document type
    Given user is on the form for creating a new correction request
    When user enters the document type "<document_type>"
    Then the system validates the document type and flags it as unsupported

    Examples:
      | document_type                                                                 |
      | Z@#1234567890123456789012345678901234567890123456789012345678901234567890      |
      | Z@#                                                                          |
      | 1234567890123456789012345678901234567890123456789012345678901234567890123456  |

  @TC-105
  Scenario: User attempts to submit the correction request with unsupported document type
    Given user has entered an unsupported document type
    When user attempts to submit the correction request
    Then the system prevents submission and displays an error message indicating the unsupported document type

  @TC-105
  Scenario: System does not create a correction request for unsupported document type
    Given user has attempted to submit a correction request with an unsupported document type
    When the submission is prevented
    Then the system does not create any correction request for the unsupported document type

  @TC-105
  Scenario: User logs out of the SAP system
    Given user has completed their session in the SAP system
    When user logs out of the SAP system
    Then user successfully logs out of the system