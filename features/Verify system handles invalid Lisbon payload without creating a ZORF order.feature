Feature: Verify system handles invalid Lisbon payload without creating a ZORF order

  @TC-561
  Scenario Outline: Validate the system behavior for Lisbon payload with invalid status
    Given the Lisbon system is configured to send payloads to S/4HANA
    When the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing the status "<payload_status>"
    Then the interface logs an error indicating "<error_message>"
    And no ZORF order is created in the S/4HANA system
    And the system logs contain detailed error messages related to "<error_message>"
    And the original ZOR order remains unaffected in the system
    And the system sends an "<response_type>" back to the Lisbon system
    And no financial postings are made for the invalid payload
    And alerts or notifications are triggered to inform relevant stakeholders about the invalid payload
    And the system handles the invalid payload gracefully without crashing
    And other ongoing processes in the system remain unaffected by the invalid payload
    And the audit logs provide complete traceability of the invalid payload processing
    And the system provides recommendations or corrective actions for the invalid payload

    Examples:
      | payload_status   | error_message                     | response_type       |
      | INVALID_STATUS   | invalid status in the payload     | error response      |