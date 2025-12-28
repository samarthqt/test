Feature: Validate error handling for missing partner data during Sales document creation

  @TC-196
  Scenario Outline: Validate system behavior for missing partner data and non-unique reference items during Sales document creation
    Given the user logs in to the SAP system with valid credentials
    And the user navigates to the transaction code for creating Sales documents "<transaction_code>"
    When the user inputs the Billing document ID "<billing_document_id>" in the reference field
    And the user selects the Sales document type "<sales_document_type>" for creation
    And the user executes the FV45C003 routine for copying partner data
    Then the system processes the Billing document and identifies missing partner data "<missing_partner_data>"
    And the system identifies non-unique partner data and aborts the process
    And the system displays a detailed error message "<error_message>"
    When the user attempts to save the Sales document despite the error
    Then the system prevents saving the Sales document
    And the system logs the error in the audit trail
    When the user generates a report of the attempted Sales document creation
    Then the report shows the attempt failed due to "<failure_reason>"
    When the user logs out of the SAP system
    Then the user is logged out successfully
    And the user notifies the relevant team about the error for resolution

    Examples:
      | transaction_code | billing_document_id | sales_document_type | missing_partner_data      | error_message                                       | failure_reason                                    |
      | VA01             | ZL2                 | ZCR                 | Bill-to and Ship-to       | Missing partner data and non-unique reference data | Missing partner data and non-unique reference data |