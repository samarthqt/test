Feature: Validate system behavior for maximum allowable ZRK1 correction request volume

  @TC-411
  Scenario Outline: Validate batch upload of ZRK1 correction requests
    Given the user uploads a batch of "<number_of_requests>" ZRK1 correction requests into the system
    Then the system successfully uploads all correction requests without errors

    Examples:
      | number_of_requests |
      | 1000               |
      | <system-defined limit> |

  @TC-411
  Scenario: Submit ZRK1 correction requests for processing
    Given the user submits all ZRK1 correction requests for processing
    Then the system processes all requests and generates ZL2C documents for each correction

  @TC-411
  Scenario: Verify linkage between ZL2C documents and ZRK1 correction requests
    Given the user views the generated ZL2C documents
    Then each ZL2C document is traceable to its originating ZRK1 correction request

  @TC-411
  Scenario: Monitor system performance during processing
    Given the user monitors system performance metrics during the processing of ZRK1 correction requests
    Then no significant performance degradation is observed
    And the system operates within acceptable thresholds

  @TC-411
  Scenario: Validate accuracy of ZL2C document generation
    Given the user reviews the generated ZL2C documents
    Then all ZL2C documents contain accurate and complete information as per the correction requests

  @TC-411
  Scenario: Check system logs for errors or warnings
    Given the user checks the system logs during the processing of ZRK1 correction requests
    Then no critical errors or warnings are logged

  @TC-411
  Scenario: Verify ZGL1 document generation and linkage
    Given the user views the generated ZGL1 documents for each ZRK1 correction request
    Then all ZGL1 outputs are generated correctly
    And each ZGL1 document is linked to the corresponding correction request

  @TC-411
  Scenario: Validate traceability of outputs in the system
    Given the user checks the traceability of generated outputs
    Then all outputs are traceable to their respective ZRK1 correction requests

  @TC-411
  Scenario Outline: Repeat batch upload process with different data
    Given the user uploads a new batch of "<number_of_requests>" ZRK1 correction requests into the system
    Then the system successfully handles the batch without errors

    Examples:
      | number_of_requests |
      | 1000               |
      | <system-defined limit> |

  @TC-411
  Scenario: Verify audit logs for the entire process
    Given the user reviews the audit logs after processing ZRK1 correction requests
    Then the audit logs accurately reflect the processing of all requests

  @TC-411
  Scenario: Validate user interface for monitoring request statuses
    Given the user navigates to the interface for monitoring ZRK1 correction request statuses
    Then the user interface displays the correct statuses for all requests

  @TC-411
  Scenario: Confirm no duplicate ZL2C documents are generated
    Given the user reviews the generated ZL2C documents
    Then each ZRK1 correction request results in exactly one ZL2C document