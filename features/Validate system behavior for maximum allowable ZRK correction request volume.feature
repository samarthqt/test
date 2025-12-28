Feature: Validate system behavior for maximum allowable ZRK correction request volume

  @TC-410
  Scenario Outline: Validate batch upload of ZRK correction requests
    Given the user uploads a batch of "<number_of_requests>" ZRK correction requests into the system
    Then all correction requests are successfully uploaded without any errors

    Examples:
      | number_of_requests |
      | 1000               |
      | <system-defined limit> |

  @TC-410
  Scenario: Submit ZRK correction requests for processing
    Given the user submits all ZRK correction requests for processing
    Then the system processes all requests and generates ZG2C documents for each correction

  @TC-410
  Scenario: Verify linkage of ZG2C documents to ZRK correction requests
    Given the user reviews the ZG2C documents generated
    Then each ZG2C document is traceable to its originating ZRK correction request

  @TC-410
  Scenario: Monitor system performance during ZRK correction requests processing
    Given the user monitors the system performance metrics during processing
    Then no significant performance degradation is observed
    And the system operates within acceptable thresholds

  @TC-410
  Scenario: Validate accuracy of ZG2C document generation
    Given the user verifies the ZG2C documents generated
    Then all ZG2C documents contain accurate and complete information as per the correction requests

  @TC-410
  Scenario: Check system logs during ZRK correction request processing
    Given the user reviews the system logs
    Then no critical errors or warnings are logged during the processing of ZRK correction requests

  @TC-410
  Scenario: Verify ZGC1 document outputs for ZRK correction requests
    Given the user reviews the ZGC1 document outputs
    Then all ZGC1 outputs are generated correctly
    And each ZGC1 output is linked to the corresponding ZRK correction request

  @TC-410
  Scenario: Validate traceability of outputs in the system
    Given the user verifies the traceability of generated outputs
    Then all outputs are traceable to their respective ZRK correction requests

  @TC-410
  Scenario Outline: Repeat batch upload with a different set of ZRK correction requests
    Given the user uploads a second batch of "<number_of_requests>" ZRK correction requests into the system
    Then the system successfully handles the second batch without errors

    Examples:
      | number_of_requests |
      | 1000               |
      | <system-defined limit> |

  @TC-410
  Scenario: Verify audit logs for the entire process
    Given the user reviews the audit logs for the entire process
    Then audit logs accurately reflect the processing of all ZRK correction requests

  @TC-410
  Scenario: Validate user interface for monitoring request statuses
    Given the user navigates to the interface for monitoring request statuses
    Then the user interface displays the correct statuses for all ZRK correction requests

  @TC-410
  Scenario: Confirm no duplicate ZG2C documents are generated
    Given the user reviews the ZG2C documents generated
    Then each ZRK correction request results in exactly one ZG2C document