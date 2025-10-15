Feature: Validate system behavior when exceeding maximum allowable line items for billing correction requests and documents

  @TC-50
  Scenario Outline: User attempts to create or process billing correction requests with line items exceeding the system limit
    Given the user is logged into the SAP S/4HANA system with access to the Finance module
    And an original billing document with <line_items> line items exists
    When the user navigates to the transaction for creating billing correction requests
    And the user enters the billing correction request type as <correction_request_type>
    And the user links the billing correction request to the existing billing document
    Then the system validates the number of line items and displays an error message
    When the user attempts to save the billing correction request
    Then the system prevents saving the correction request and displays an error message
    When the user attempts to generate the corresponding <billing_document_type> billing document
    Then the system prevents document generation and displays an error message
    And the system logs an error indicating the maximum line item limit was exceeded
    And the document flow shows no partial or incomplete documents
    And the system performance remains stable during the process
    And no financial postings are made for the failed document creation

    Examples:
      | line_items | correction_request_type | billing_document_type |
      | 1001       | ZRK                    | ZG2C                  |
      | 1001       | ZRK                    | ZL2C                  |

  @TC-50
  Scenario Outline: User modifies line items to comply with the system limit and resubmits the correction request
    Given the user is logged into the SAP S/4HANA system with access to the Finance module
    And an original billing document with <line_items> line items exists
    When the user modifies the line items to reduce the number below the limit
    And the user resubmits the modified billing correction request
    Then the system successfully processes the modified request with valid line items

    Examples:
      | line_items |
      | 999        |
      | 500        |