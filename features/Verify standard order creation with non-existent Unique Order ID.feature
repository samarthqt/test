Feature: Verify standard order creation with non-existent Unique Order ID

  @TC-497
  Scenario Outline: Validate standard order creation when a non-existent 36-character Unique Order ID is provided
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing the Unique Order ID "<UniqueOrderID>"
    And the payload includes all mandatory fields including Sales Area "<SalesArea>"
    When the interface processes the payload in S/4HANA
    Then a new standard order (ZOR) is created in the S/4HANA system
    And the created order is assigned the correct Sales Area "<SalesArea>"
    And the order details match the information provided in the payload
    And the system generates a unique order number for the new ZOR order
    And the order creation is logged in the system for traceability
    And the interface logs indicate successful processing without critical warnings
    And the integration between Lisbon and S/4HANA is seamless and error-free
    And the created order adheres to the standard order format (ZOR)
    And the system sends an acknowledgment back to Lisbon confirming the successful creation of the order

    Examples:
      | UniqueOrderID                            | SalesArea   |
      | 123e4567-e89b-12d3-a456-426614174000     | 1022/10/10  |