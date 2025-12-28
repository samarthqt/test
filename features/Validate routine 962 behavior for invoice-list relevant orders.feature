Feature: Validate routine 962 behavior for invoice-list relevant orders

  @TC-314
  Scenario: User logs into the SAP system with appropriate credentials
    Given the user has valid credentials
    When the user logs into the SAP system
    Then the user is successfully logged in and has access to the relevant modules

  @TC-314
  Scenario: User navigates to the sales order creation module
    Given the user is logged into the SAP system
    When the user navigates to the sales order creation module
    Then the sales order creation screen is displayed

  @TC-314
  Scenario: User navigates to the billing workflow module
    Given the user has created an invoice-list relevant order
    When the user navigates to the billing workflow module
    Then the billing workflow screen is displayed

  @TC-314
  Scenario Outline: Validate creation of invoice-list relevant orders
    Given the user is on the sales order creation screen
    When the user creates an invoice-list relevant order using "<test_data>"
    Then the invoice-list relevant order is created successfully
    And routine 962 assignment details are verified

    Examples:
      | test_data      |
      | Valid test data|

  @TC-314
  Scenario: Process invoice-list relevant order through billing workflow
    Given the user has created an invoice-list relevant order
    When the user processes the created invoice-list relevant order through the billing workflow
    Then the order is processed successfully without any issues

  @TC-314
  Scenario: Verify routine 962 does not trigger outputs for invoice-list relevant orders
    Given the user has processed an invoice-list relevant order
    When the user verifies routine 962 behavior
    Then routine 962 does not trigger outputs for the invoice-list relevant order, as expected

  @TC-314
  Scenario: Check output determination logs for processed order
    Given the user has processed an invoice-list relevant order
    When the user checks the output determination logs for the processed order
    Then the logs confirm that no outputs were triggered for the invoice-list relevant order

  @TC-314
  Scenario: Validate document flow for processed order
    Given the user has processed an invoice-list relevant order
    When the user validates the document flow for the processed order
    Then the document flow does not show any output-related entries for routine 962

  @TC-314
  Scenario: Verify output determination strategy for ZPDT
    Given the user has access to billing workflow configuration
    When the user verifies the output determination strategy for ZPDT
    Then the output determination strategy for ZPDT is correctly configured
    And routine 962 is assigned

  @TC-314
  Scenario: Validate master data for created order
    Given the user has created an invoice-list relevant order
    When the user validates the master data for the created order
    Then the master data reflects the invoice-list relevancy attribute correctly

  @TC-314
  Scenario: Document the results of the test case execution
    Given the user has completed all test steps
    When the user documents the results of the test case execution
    Then the test case results are documented successfully

  @TC-314
  Scenario: User logs out of the SAP system
    Given the user has completed all required activities
    When the user logs out of the SAP system
    Then the user is logged out successfully