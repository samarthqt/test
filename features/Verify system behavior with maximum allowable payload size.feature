Feature: Verify system behavior with maximum allowable payload size

  @TC-500
  Scenario Outline: Validate order creation with maximum payload size
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a payload of size "<Payload Size>" and unique order ID "<Order ID>"
    And the payload includes all required fields including Sales Area "<Sales Area>"
    When the interface processes the payload
    Then the system creates a new standard order (ZOR) in S/4HANA
    And the new order is assigned the correct Sales Area "<Sales Area>"
    And the order details match the information provided in the payload
    And the system generates a unique order number for the new ZOR order
    And the order creation event is logged in the system for traceability
    And the interface logs show successful processing without critical warnings
    And the created order adheres to the standard order format (ZOR)
    And an acknowledgment is sent to Lisbon confirming the successful order creation
    And the system processes the payload efficiently without performance degradation

    Examples:
      | Payload Size              | Order ID                                | Sales Area  |
      | Maximum allowable size    | 123e4567-e89b-12d3-a456-426614174003    | 1022/10/10  |