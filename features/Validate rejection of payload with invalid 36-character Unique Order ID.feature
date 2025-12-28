Feature: Validate rejection of payload with invalid 36-character Unique Order ID

  @TC-333
  Scenario Outline: Verify system behavior for payload with invalid 36-character Unique Order ID
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing a Unique Order ID "<Unique Order ID>" and order details "<Order Details>"
    When the system begins validation of the payload
    Then the system identifies the Unique Order ID as "<Validation Result>"
    And the system logs an error message indicating the issue with the Unique Order ID
    And the system rejects the payload and prevents updates to any orders
    And no changes are made to existing orders in the system
    And the system displays a user-friendly error message "<Error Message>"
    And the system logs the rejection event for audit purposes

    Examples:
      | Unique Order ID                              | Order Details                                  | Validation Result | Error Message                            |
      | INVALID1234567890123456789012345678          | {"Item": "Product B", "Quantity": 5, "Price": 50} | Invalid          | "Invalid Unique Order ID provided."      |
      | BLANK                                        | {"Item": "Product B", "Quantity": 5, "Price": 50} | Invalid          | "Unique Order ID cannot be blank."       |
      | 12345678901234567890123456789012345678901234 | {"Item": "Product B", "Quantity": 5, "Price": 50} | Invalid          | "Unique Order ID exceeds the valid length of 36 characters." |
      | VALID123456789012345678901234567890123456    | {"Item": "Product B", "Quantity": 5, "Price": 50} | Valid            | "No error message displayed."            |