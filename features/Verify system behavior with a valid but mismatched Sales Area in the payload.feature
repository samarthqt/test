Feature: Verify system behavior with a valid but mismatched Sales Area in the payload

  @TC-336
  Scenario Outline: Validate system behavior for mismatched Sales Area in the payload
    Given the Lisbon system is configured to send inbound payloads
    And the S/4HANA interface is active and ready to process inbound data
    When the user triggers the inbound interface from Lisbon with the payload containing Sales Area "<SalesArea>"
    Then the system captures the payload and starts processing
    And the system generates error logs indicating the mismatched Sales Area
    And no order is created or updated in the system using the provided Unique Order ID "<OrderID>"
    And the error message specifies the issue with the Sales Area mismatch
    And notifications are sent to the relevant team about the mismatched Sales Area
    And the system maintains the integrity of existing data
    And the system remains responsive and handles the error without performance degradation
    And the error is logged with a unique identifier for traceability
    And the audit logs reflect the error event and subsequent resolution steps
    And the system prevents processing of any payloads with invalid Sales Areas
    And the system logs the error once per payload and avoids duplication

    Examples:
      | SalesArea    | OrderID                              |
      | 1023/20/30   | 12345678-1234-1234-1234-123456789012 |
      | 9999/99/99   | 87654321-4321-4321-4321-210987654321 |

  @TC-336
  Scenario: Verify successful processing of corrected Sales Area in the payload
    Given the Lisbon system is configured to send inbound payloads
    And the S/4HANA interface is active and ready to process inbound data
    When the user triggers the inbound interface from Lisbon with the payload containing corrected Sales Area "1022/10/10"
    Then the system processes the corrected payload successfully
    And no error logs are generated
    And the audit logs reflect the successful processing of the payload