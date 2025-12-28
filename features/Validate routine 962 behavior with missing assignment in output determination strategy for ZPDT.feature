Feature: Validate routine 962 behavior with missing assignment in output determination strategy for ZPDT

  @TC-318
  Scenario: User logs into the SAP system and verifies access to relevant modules
    Given user has valid credentials
    When user logs into the SAP system
    Then user is successfully logged in and has access to the relevant modules

  @TC-318
  Scenario: User navigates to the sales order creation module
    Given user is logged into the SAP system
    When user navigates to the sales order creation module
    Then the sales order creation screen is displayed

  @TC-318
  Scenario Outline: User creates invoice-list or non-invoice-list relevant orders
    Given user is on the sales order creation screen
    When user creates an order with the following details:
      | Order Type | Order ID        |
      | <type>     | <order_id>      |
    Then the <type> order is created successfully

    Examples:
      | type                  | order_id     |
      | Invoice-list relevant | INV54321     |
      | Non-invoice-list      | NONINV09876  |

  @TC-318
  Scenario: User navigates to the billing workflow module
    Given user is logged into the SAP system
    When user navigates to the billing workflow module
    Then the billing workflow screen is displayed

  @TC-318
  Scenario Outline: User processes orders through the billing workflow
    Given user is on the billing workflow screen
    When user processes the <type> order with ID <order_id>
    Then the <type> order is processed successfully without any issues

    Examples:
      | type                  | order_id     |
      | Invoice-list relevant | INV54321     |
      | Non-invoice-list      | NONINV09876  |

  @TC-318
  Scenario: User verifies that routine 962 does not trigger outputs for processed orders
    Given both invoice-list and non-invoice-list orders have been processed
    When user checks if routine 962 triggers outputs for either order
    Then routine 962 does not trigger any outputs due to missing assignment

  @TC-318
  Scenario: User checks the output determination logs for processed orders
    Given both invoice-list and non-invoice-list orders have been processed
    When user reviews the output determination logs
    Then logs confirm that no outputs were triggered for either order due to missing routine 962 assignment

  @TC-318
  Scenario: User verifies the output determination strategy configuration for ZPDT
    Given routine 962 is expected to be part of the output determination strategy
    When user reviews the configuration for ZPDT
    Then routine 962 is found to be missing from the output determination strategy

  @TC-318
  Scenario: User documents the results of the test case execution
    Given the test case execution has been completed
    When user documents the results
    Then the test case results are documented successfully

  @TC-318
  Scenario: User logs out of the SAP system
    Given user has completed all tasks
    When user logs out of the SAP system
    Then user is logged out successfully