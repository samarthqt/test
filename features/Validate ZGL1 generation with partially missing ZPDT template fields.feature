Feature: Validate ZGL1 generation with partially missing ZPDT template fields

  @TC-409
  Scenario: User logs into the SAP system
    Given the user has valid billing administrator credentials
    When the user logs into the SAP system
    Then the user is successfully logged into the system

  @TC-409
  Scenario: User navigates to the billing output generation module
    Given the user is logged into the SAP system
    When the user navigates to the billing output generation module
    Then the billing output generation module is displayed

  @TC-409
  Scenario Outline: Validate ZGL1 generation with partially missing ZPDT template fields
    Given the ZPDT template configuration has some fields missing
    When the user attempts to generate a ZGL1 form
    Then the system displays an error message "<error_message>"
    And no ZGL1 outputs are generated
    And the system logs contain entries indicating the missing fields in the ZPDT template
    And the system remains stable after the error

    Examples:
      | error_message                              |
      | Missing fields in the ZPDT template       |

  @TC-409
  Scenario: Retry ZGL1 generation process after an error
    Given the system has displayed an error message for missing fields
    When the user retries the generation process
    Then the system consistently prevents the generation of the ZGL1 form
    And no ZGL1 outputs are generated

  @TC-409
  Scenario: Validate system stability after error
    Given the system has encountered an error during ZGL1 generation
    When the user performs other operations in the system
    Then the system remains stable and operational

  @TC-409
  Scenario: User logs out of the SAP system
    Given the user has completed their actions in the SAP system
    When the user logs out of the SAP system
    Then the user is successfully logged out

  @TC-409
  Scenario: Document findings and submit test results
    Given the user has completed the ZGL1 generation test
    When the user documents all findings and screenshots in the test report
    Then the findings and screenshots are documented successfully
    And the test results are successfully submitted for review