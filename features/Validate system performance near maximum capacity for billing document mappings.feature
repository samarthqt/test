Feature: Validate system performance near maximum capacity for billing document mappings

  @TC-32
  Scenario Outline: Validate sales order creation and billing document processing for various billing document types near maximum capacity
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the ZOTC_CROSSREFTAB table contains a large number of mappings close to the system's maximum limit
    When the user navigates to the ZOTC_SALES_ORDER program
    And the user creates a sales order using the billing document type "<Billing Document Type>"
    Then the sales order is created successfully using "<Billing Document Type>"
    When the user processes the sales order
    Then the billing document is created successfully without performance issues

    Examples:
      | Billing Document Type |
      | ZF2                  |
      | S1                   |
      | ZG2C                 |
      | ZL2C                 |

  @TC-32
  Scenario: Monitor system performance metrics during sales order creation and processing
    Given the user has created and processed sales orders for various billing document types near maximum capacity
    When the user monitors system performance metrics
    Then the system performance metrics remain within acceptable thresholds

  @TC-32
  Scenario: Verify no errors or delays occur during the entire process
    Given the user has created and processed sales orders for various billing document types near maximum capacity
    When the user verifies the process
    Then the system processes all sales orders and billing documents without errors or delays