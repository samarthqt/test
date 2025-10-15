Feature: Validate system behavior for routine 962 with incorrect configuration for edge cases

  @TC-323
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is logged in successfully
    And the user has access to the relevant modules

  @TC-323
  Scenario: User navigates to the output determination strategy configuration for ZPDT
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the output determination strategy configuration for ZPDT
    Then the output determination strategy screen is displayed

  @TC-323
  Scenario: User assigns routine 962 to the output determination strategy
    Given the user is on the output determination strategy screen for ZPDT
    When the user assigns routine 962 to the output determination strategy
    Then routine 962 is successfully assigned

  @TC-323
  Scenario Outline: User creates and processes orders with maximum and minimum field values
    Given the user has test data for order types with "<field value type>" field values
    When the user creates an order with "<field value type>" field values
    And the user processes the order through the billing workflow
    Then the system processes the order and generates outputs based on the configuration of routine 962

    Examples:
      | field value type |
      | maximum          |
      | minimum          |

  @TC-323
  Scenario: User verifies the outputs generated for orders
    Given the user has processed orders with maximum and minimum field values
    When the user verifies the outputs generated for both orders
    Then outputs are generated correctly for both orders
    And any issues with routine 962 are highlighted

  @TC-323
  Scenario: User checks the system logs for error messages related to routine 962
    Given routine 962 is assigned with incomplete or incorrect configuration
    When the user checks the system logs for error messages related to routine 962
    Then error messages are logged indicating the misconfiguration of routine 962

  @TC-323
  Scenario: User validates system handling of edge cases
    Given routine 962 is assigned with incomplete or incorrect configuration
    When the user processes edge cases
    Then the system handles edge cases effectively without crashes or unexpected behavior

  @TC-323
  Scenario: User documents findings and shares them with the configuration team
    Given the user has verified outputs and checked system logs
    When the user documents the findings
    And the user shares the findings with the configuration team
    Then findings are documented and communicated effectively

  @TC-323
  Scenario: User logs out of the SAP system
    Given the user has completed all tasks
    When the user logs out of the SAP system
    Then the user is logged out successfully