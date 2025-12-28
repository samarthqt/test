Feature: Validate system behavior for unsupported document types in billing corrections

  To verify that the system prevents submission of correction requests for unsupported document types and displays appropriate error messages. The system is configured to restrict billing corrections to ZG2C and ZL2C document types.

  @TC-102
  Scenario Outline: Validate behavior for supported and unsupported document types in billing corrections
    Given the user logs into the SAP system with valid credentials
    When the user navigates to the billing correction form using the appropriate transaction code
    And the user selects the option to create a new correction request
    And the user enters "<DocumentType>" in the document type field
    And the user fills in the mandatory fields: Customer ID, Billing Date, and Amount
    And the user submits the correction request
    Then the system "<ValidationResult>" and "<Outcome>"

    Examples:
      | DocumentType | ValidationResult                 | Outcome                                                                 |
      | ZG2C         | accepts the document type       | successfully creates a correction request                              |
      | ZL2C         | accepts the document type       | successfully creates a correction request                              |
      | ZXYZ         | flags the document type as unsupported | prevents submission and displays an error message indicating unsupported document type |
      |              | flags the document type as unsupported | prevents submission and displays an error message indicating unsupported document type |

  @TC-102
  Scenario: Verify that no correction request is created for unsupported document types
    Given the user has attempted to submit a correction request with an unsupported document type
    When the user generates a report to confirm entries in the system
    Then the report confirms no entries exist for the unsupported document type

  @TC-102
  Scenario: Ensure successful logout from the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the system
    Then the user successfully logs out of the system