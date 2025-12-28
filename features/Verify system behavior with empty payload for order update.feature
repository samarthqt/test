Feature: Verify system behavior with empty payload for order update

  Ensure the system handles an empty payload gracefully, logs appropriate errors, and prevents any updates to existing orders while maintaining system stability.

  @TC-334
  Scenario Outline: Validate system behavior when receiving an empty payload for order updates
    Given the Lisbon system is configured to send order updates
    When the user triggers the inbound interface from Lisbon to S/4HANA with a payload "<Payload>"
    Then the system validates the payload
    And the system logs an error message indicating "<ErrorMessage>"
    And the system rejects the payload without updating any orders
    And the system displays a user-friendly error message "<UserFriendlyMessage>"
    And all existing orders remain unchanged
    And the system logs the rejection event for audit purposes with details "<AuditDetails>"
    And the system remains stable without crashing or throwing unhandled exceptions

    Examples:
      | Payload  | ErrorMessage                  | UserFriendlyMessage              | AuditDetails         |
      | Empty    | Payload is empty             | The payload provided is empty.   | Rejected empty payload |