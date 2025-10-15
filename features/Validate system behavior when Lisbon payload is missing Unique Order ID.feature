Feature: Validate system behavior when Lisbon payload is missing Unique Order ID

  @TC-562
  Scenario Outline: Verify system behavior when a payload is sent from Lisbon to S/4HANA with missing Unique Order ID
    Given the Lisbon system is configured to send payloads to S/4HANA
    When the user triggers the inbound interface from Lisbon to S/4HANA with a payload missing the Unique Order ID
    Then the interface is triggered successfully, and the payload is sent to S/4HANA with status "<payload_status>"
    And the interface logs an error indicating the missing Unique Order ID in the payload
    And no ZORF order is created in the S/4HANA system
    And the system logs contain detailed error messages indicating the missing Unique Order ID
    And the original ZOR order remains unaffected in the system
    And the system sends an error response back to the Lisbon system indicating the missing Unique Order ID
    And no financial postings are made for the invalid payload
    And alerts or notifications are triggered to inform relevant stakeholders about the missing Unique Order ID
    And the system processes the invalid payload gracefully without any crashes
    And other ongoing processes in the system remain unaffected by the invalid payload
    And the audit logs provide complete traceability of the invalid payload processing
    And the system provides recommendations or corrective actions for the missing Unique Order ID

    Examples:
      | payload_status        |
      | CANCELLED_SHIPPING    |