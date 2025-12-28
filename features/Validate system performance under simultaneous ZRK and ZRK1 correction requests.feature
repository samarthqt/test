Feature: Validate system performance under simultaneous ZRK and ZRK1 correction requests

  @TC-412
  Scenario Outline: Validate batch upload of correction requests
    Given the user has test data containing "<requestType>" correction requests
    When the user uploads a batch of "<batchSize>" "<requestType>" correction requests into the system
    Then all "<requestType>" correction requests are uploaded successfully without any errors

    Examples:
      | requestType | batchSize |
      | ZRK         | 500       |
      | ZRK1        | 500       |

  @TC-412
  Scenario Outline: Validate processing of correction requests
    Given the user has uploaded "<requestType>" correction requests into the system
    When the user submits all "<requestType>" correction requests for processing
    Then the system processes all "<requestType>" requests and generates "<documentType>" documents for each correction

    Examples:
      | requestType | documentType |
      | ZRK         | ZG2C         |
      | ZRK1        | ZL2C         |

  @TC-412
  Scenario: Monitor system performance during simultaneous processing
    Given the user has submitted both ZRK and ZRK1 correction requests for processing
    When the user monitors system performance metrics during the simultaneous processing of ZRK and ZRK1 correction requests
    Then no significant performance degradation is observed, and the system operates within acceptable thresholds

  @TC-412
  Scenario: Validate accuracy of document generation
    Given the user has submitted ZRK and ZRK1 correction requests for processing
    When the user reviews the generated ZG2C and ZL2C documents
    Then all ZG2C and ZL2C documents contain accurate and complete information as per the correction requests

  @TC-412
  Scenario: Check system logs for errors or warnings
    Given the user has submitted ZRK and ZRK1 correction requests for processing
    When the user checks the system logs during the simultaneous processing of ZRK and ZRK1 correction requests
    Then no critical errors or warnings are logged

  @TC-412
  Scenario: Verify output of ZGC1 and ZGL1 documents
    Given the user has submitted ZRK and ZRK1 correction requests for processing
    When the user reviews the generated ZGC1 and ZGL1 documents
    Then all ZGC1 and ZGL1 outputs are generated correctly and linked to the corresponding correction requests

  @TC-412
  Scenario: Validate traceability of outputs
    Given the user has submitted ZRK and ZRK1 correction requests for processing
    When the user checks the traceability of generated outputs in the system
    Then all generated outputs are traceable to their respective correction requests

  @TC-412
  Scenario: Verify audit logs for the entire process
    Given the user has submitted ZRK and ZRK1 correction requests for processing
    When the user reviews the audit logs for the entire process
    Then audit logs accurately reflect the processing of all ZRK and ZRK1 correction requests

  @TC-412
  Scenario: Validate user interface for monitoring request statuses
    Given the user has submitted ZRK and ZRK1 correction requests for processing
    When the user navigates to the user interface for monitoring request statuses
    Then the user interface displays the correct statuses for all ZRK and ZRK1 correction requests

  @TC-412
  Scenario: Confirm no duplicate documents are generated
    Given the user has submitted ZRK and ZRK1 correction requests for processing
    When the user reviews the generated ZG2C and ZL2C documents
    Then each correction request results in exactly one ZG2C or ZL2C document, respectively