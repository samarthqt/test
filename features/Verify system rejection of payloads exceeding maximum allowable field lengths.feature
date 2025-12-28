Feature: Verify system rejection of payloads exceeding maximum allowable field lengths

  @TC-338
  Scenario Outline: Validate system behavior when payloads exceed maximum allowable field lengths
    Given the user triggers the inbound interface from Lisbon to S/4HANA using a payload with "<payload type>"
    Then the system rejects the payload and logs an error message indicating "<error type>"
    And no orders are created or updated in S/4HANA
    And the system halts processing entirely for the invalid payload

    Examples:
      | payload type                        | error type                                      |
      | field lengths exceeding limits      | field length violation                          |
      | excessive line items beyond capacity| line item limit violation                       |
      | schema violations                   | schema violation                                |

  @TC-338
  Scenario: Verify system provides clear error messages for payload rejection
    Given the user triggers the inbound interface from Lisbon to S/4HANA using a payload with invalid data
    Then the system provides clear error messages specifying the reasons for payload rejection

  @TC-338
  Scenario: Validate error logs are generated for rejected payloads
    Given the user monitors the inbound interface for error handling and rejection logs
    Then error logs are generated indicating the field length violation

  @TC-338
  Scenario: Validate system flags payloads with schema violations
    Given the user triggers the inbound interface from Lisbon to S/4HANA using a payload with schema violations
    Then the system flags and logs the schema violations appropriately