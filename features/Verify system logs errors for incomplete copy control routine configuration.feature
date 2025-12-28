Feature: Verify system logs errors for incomplete copy control routine configuration

  @TC-219
  Scenario: User logs into the SAP S/4HANA system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-219
  Scenario: Source sales order exists with required fields populated
    Given a source sales order with number "54321" exists
    And the VBRK-KUNAG field is populated with "Customer003"
    And the VBRK-REGIO field is populated with "Region003"
    Then the source sales order is valid and ready for processing

  @TC-219
  Scenario: User navigates to the billing document creation transaction
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing document creation transaction
    Then the billing document creation screen is displayed

  @TC-219
  Scenario: User sets the target billing document type
    Given the user is on the billing document creation screen
    When the user sets the target billing document type to "ZF2C"
    Then the billing document type is set successfully

  @TC-219
  Scenario: User enters source sales order and billing document type
    Given the user is on the billing document creation screen
    When the user enters the source sales order number "54321"
    And the user enters the target billing document type "ZF2C"
    Then the entered sales order and billing document type are accepted

  @TC-219
  Scenario Outline: Attempt to execute copy control routine with incomplete configuration
    Given the system is partially configured with the copy control routine for data transfer
    When the user attempts to execute the copy control routine
    Then the system displays an error message indicating "<error_message>"
    And no billing document is created

    Examples:
      | error_message                     |
      | incomplete configuration detected |

  @TC-219
  Scenario: User checks system logs for error details
    Given the user encounters an error during the copy control routine execution
    When the user checks the system logs
    Then the system logs provide detailed error information related to the incomplete configuration

  @TC-219
  Scenario: User documents the configuration issues for resolution
    Given the system logs indicate incomplete configuration
    When the user documents the configuration issues
    Then the issues are recorded for further analysis and resolution

  @TC-219
  Scenario: User notifies the configuration team
    Given the configuration issues are documented
    When the user notifies the configuration team about the incomplete setup
    Then the configuration team is alerted, and the issue is escalated

  @TC-219
  Scenario: User re-tests billing document creation after configuration correction
    Given the configuration team has corrected the incomplete setup
    When the user re-tests the billing document creation process
    Then the billing document is successfully created
    And the VBRK-KUNAG and VBRK-REGIO fields are cleared

  @TC-219
  Scenario: User ensures error logs are cleared after configuration correction
    Given the configuration is corrected
    When the user checks the system logs
    Then all error logs are cleared
    And the system functions as expected

  @TC-219
  Scenario: User updates test documentation with resolved configuration issue
    Given the configuration issue is resolved
    When the user updates the test documentation
    Then the resolved configuration issue is documented

  @TC-219
  Scenario: User performs regression testing to ensure no other modules are affected
    Given the configuration issue is resolved
    When the user performs regression testing
    Then no other modules are affected