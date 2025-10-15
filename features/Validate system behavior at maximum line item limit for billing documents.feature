Feature: Validate system behavior at maximum line item limit for billing documents

  @TC-52
  Scenario Outline: Ensure the system handles billing documents with exactly the maximum number of allowable line items
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the user has access to the Finance module
    And the original billing document exists with exactly <maximum_line_items> line items of type <billing_document_type>
    When the user navigates to the transaction for creating billing correction requests
    And the user enters the billing correction request type as <billing_correction_request_type>
    And the user links the billing correction request to the original billing document
    And the user saves the billing correction request
    And the user generates the corresponding billing document of type <generated_billing_document_type>
    Then all line items in the generated billing document are correctly processed and linked to the original document
    And the document flow shows proper linkage between the correction request and the original document
    And the system log contains no errors or warnings
    And the financial postings for the generated billing document are accurate and reflect the corrections made
    And the billing document contains no discrepancies in line item processing
    And the system generates a success message indicating the billing document was created successfully

    Examples:
      | maximum_line_items | billing_document_type | billing_correction_request_type | generated_billing_document_type |
      | 999                | ZL2C                  | ZRK1                            | ZL2C                            |