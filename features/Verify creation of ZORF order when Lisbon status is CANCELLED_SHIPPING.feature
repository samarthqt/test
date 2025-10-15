Feature: Verify creation of ZORF order when Lisbon status is CANCELLED_SHIPPING

  @TC-560
  Scenario Outline: Validate ZORF order creation and associated processes when Lisbon sends payload with CANCELLED_SHIPPING status
    Given the Lisbon system sends a payload with status "<PayloadStatus>" to S/4HANA
    When the user monitors the interface processing in S/4HANA
    Then the interface should process the payload successfully without errors
    And a ZORF order should be created in the S/4HANA system
    And the ZORF order should reference the original ZOR order correctly
    And the ZORF order should adhere to the Sales Area "<SalesArea>"
    And the original ZOR order status should be updated to reflect the cancellation
    And the system logs should not contain any errors or warnings during the order creation process
    And the ZORF order should contain all mandatory fields and data as per the business requirements
    And the integration between Lisbon and S/4HANA should function as expected
    And the ZORF order should be visible in the relevant order management reports
    And the financial postings related to the ZORF order should be accurate
    And the audit logs should provide complete traceability of the order creation process

    Examples:
      | PayloadStatus       | SalesArea  |
      | CANCELLED_SHIPPING  | 1022/10/10 |