Feature: Validate routine 962 behavior for boundary conditions with maximum allowed line items

  @TC-319
  Scenario: User logs into the SAP system successfully
    Given the user has valid credentials
    When the user logs into the SAP system
    Then the user is successfully logged in and has access to the relevant modules

  @TC-319
  Scenario Outline: User creates orders with maximum allowed line items
    Given the user navigates to the sales order creation module
    When the user creates a "<orderType>" order with the maximum allowed line items using the provided test data
    Then the "<orderType>" order with maximum line items is created successfully

    Examples:
      | orderType               |
      | invoice-list relevant   |
      | non-invoice-list relevant |

  @TC-319
  Scenario: User navigates to the billing workflow module
    Given the user has created orders with maximum allowed line items
    When the user navigates to the billing workflow module
    Then the billing workflow screen is displayed

  @TC-319
  Scenario Outline: User processes orders through the billing workflow
    Given the user is on the billing workflow screen
    When the user processes the "<orderType>" order through the billing workflow
    Then the "<orderType>" order is processed successfully without any issues

    Examples:
      | orderType               |
      | invoice-list relevant   |
      | non-invoice-list relevant |

  @TC-319
  Scenario: Routine 962 does not trigger outputs for invoice-list relevant orders
    Given the user has processed an invoice-list relevant order through the billing workflow
    When the user verifies the output determination for the invoice-list relevant order
    Then routine 962 does not trigger outputs for the invoice-list relevant order, as expected

  @TC-319
  Scenario: Routine 962 triggers outputs correctly for non-invoice-list relevant orders
    Given the user has processed a non-invoice-list relevant order through the billing workflow
    When the user verifies the output determination for the non-invoice-list relevant order
    Then routine 962 triggers outputs correctly for the non-invoice-list relevant order, as expected

  @TC-319
  Scenario: User checks output determination logs for processed orders
    Given the user has processed both invoice-list relevant and non-invoice-list relevant orders
    When the user checks the output determination logs for both orders
    Then the logs confirm the correct output determination behavior for both orders

  @TC-319
  Scenario: User validates document flow for processed orders
    Given the user has processed both invoice-list relevant and non-invoice-list relevant orders
    When the user validates the document flow for both orders
    Then the document flow reflects the correct output determination behavior for both orders

  @TC-319
  Scenario: User documents the results of the test case execution
    Given the user has completed all test steps for routine 962 validation
    When the user documents the results of the test case execution
    Then the test case results are documented successfully