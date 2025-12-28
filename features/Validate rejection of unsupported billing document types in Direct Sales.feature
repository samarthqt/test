Feature: Validate rejection of unsupported billing document types in Direct Sales

  @TC-515
  Scenario Outline: Validate behavior for supported and unsupported billing document types
    Given the user navigates to the Direct Sales processing program "ZOTC_SALES_ORDER"
    When the user creates a sales order with billing document type "<Billing Document Type>"
    And the user attempts to process the sales order to generate a billing document
    Then the system "<System Behavior>" for the billing document type
    And the system displays "<Error Message>" if applicable
    And the system logs contain "<Log Details>" if applicable
    And no billing document is created if the type is unsupported
    And the system maintains data integrity by not allowing unsupported document types into the workflow
    And downstream systems like Model N remain unaffected by the processing outcome

    Examples:
      | Billing Document Type | System Behavior                              | Error Message                                     | Log Details                              |
      | Unsupported           | rejects the billing document type           | Billing document type is not supported          | Detailed error entries are logged        |
      | Supported             | processes the billing document type         | N/A                                              | N/A                                      |

  @TC-515
  Scenario Outline: Validate rejection process consistency across unsupported billing document types
    Given the user navigates to the Direct Sales processing program "ZOTC_SALES_ORDER"
    When the user creates a sales order with unsupported billing document type "<Unsupported Billing Document Type>"
    And the user attempts to process the sales order to generate a billing document
    Then the system rejects the unsupported billing document type
    And the system displays a clear error message indicating the billing document type is not supported
    And the system logs contain detailed error entries related to the unsupported document type
    And no billing document is created for the unsupported type
    And the rejection process is consistent across different unsupported billing document types

    Examples:
      | Unsupported Billing Document Type |
      | ZXY                               |
      | ABC                               |
      | DEF                               |

  @TC-515
  Scenario: Validate error message format for unsupported billing document types
    Given the user navigates to the Direct Sales processing program "ZOTC_SALES_ORDER"
    When the user creates a sales order with an unsupported billing document type "ZXY"
    And the user attempts to process the sales order to generate a billing document
    Then the system displays an error message with sufficient details for troubleshooting

  @TC-515
  Scenario: Confirm system handles unsupported billing document types gracefully
    Given the user navigates to the Direct Sales processing program "ZOTC_SALES_ORDER"
    When the user creates a sales order with an unsupported billing document type "ZXY"
    And the user attempts to process the sales order to generate a billing document
    Then the system handles the unsupported billing document type gracefully without crashes