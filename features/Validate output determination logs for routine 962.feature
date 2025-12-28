Feature: Validate output determination logs for routine 962

  Ensure output determination logs reflect the correct behavior of routine 962 for both invoice-list and non-invoice-list relevant orders. Routine 962 must be created and assigned to the output determination strategy for ZPDT.

  @TC-316
  Scenario Outline: Validate output determination logs for invoice-list and non-invoice-list relevant orders
    Given user logs into the SAP system with appropriate credentials
    When user navigates to the billing workflow module
    And user processes the "<order_type>" order with ID "<order_id>" through the billing workflow
    And user accesses the output determination logs for the processed orders
    Then logs for the "<order_type>" order confirm "<output_behavior>"
    And document flow reflects the correct output determination behavior for the "<order_type>" order
    And master data reflects the correct invoice-list relevancy attributes for the "<order_type>" order

    Examples:
      | order_type           | order_id    | output_behavior                                    |
      | invoice-list         | INV12345    | no outputs were triggered                         |
      | non-invoice-list     | NONINV56789 | outputs were triggered correctly                  |

  @TC-316
  Scenario: Verify the output determination strategy for ZPDT
    Given user logs into the SAP system with appropriate credentials
    When user verifies the output determination strategy for ZPDT
    Then the output determination strategy is correctly configured and routine 962 is assigned

  @TC-316
  Scenario: Document the results of the test case execution
    Given user has completed the test case execution
    When user documents the results of the test case execution
    Then the test case results are documented successfully

  @TC-316
  Scenario: Log out of the SAP system
    Given user is logged into the SAP system
    When user logs out of the SAP system
    Then user is logged out successfully