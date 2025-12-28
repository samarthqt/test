Feature: Verify system behavior for payloads with maximum allowable field lengths

  @TC-339
  Scenario Outline: Validate system processing for payloads with maximum allowable field lengths
    Given the inbound interface in S/4HANA is operational
    And the Lisbon system is active and configured to send payloads
    When the user triggers the inbound interface with a payload having field lengths "<field_length>" and "<line_items>"
    Then the payload is successfully processed without errors
    And the interface processes the payload without performance degradation
    And the order is created or updated in S/4HANA with all data accurately reflected
    And no warnings or errors are logged during processing
    And all data fields in the order match the payload values accurately
    And the system processes all line items without splitting or truncation
    And the system performance remains within acceptable thresholds

    Examples:
      | field_length         | line_items                                 |
      | Maximum allowable    | Exact maximum number supported by system   |