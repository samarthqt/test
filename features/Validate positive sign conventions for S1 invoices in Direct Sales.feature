Feature: Validate positive sign conventions for S1 invoices in Direct Sales

  @TC-380
  Scenario: User logs into the SAP system successfully
    Given user has valid credentials
    When user logs into the SAP system
    Then user is logged into the SAP system successfully

  @TC-380
  Scenario: User navigates to the Direct Sales processing program
    Given user is logged into the SAP system
    When user navigates to the Direct Sales processing program "ZOTC_SALES_ORDER"
    Then Direct Sales processing program interface is displayed

  @TC-380
  Scenario Outline: User creates a new sales order with the S1 billing document type
    Given user is on the Direct Sales processing program interface
    When user creates a new sales order with the following details:
      | Billing Document Type | Order ID | Customer ID | Product ID | Quantity | Price |
      | <Billing Document Type> | <Order ID> | <Customer ID> | <Product ID> | <Quantity> | <Price> |
    Then sales order is created successfully with the S1 billing document type

    Examples:
      | Billing Document Type | Order ID | Customer ID | Product ID | Quantity | Price |
      | S1                   | 10001    | C001        | P001       | 10       | 100   |

  @TC-380
  Scenario: User processes the created sales order
    Given sales order is created successfully
    When user processes the created sales order
    Then sales order is processed without any errors

  @TC-380
  Scenario: User navigates to the billing document generated for the sales order
    Given sales order is processed successfully
    When user navigates to the billing document generated for the sales order
    Then billing document for the sales order is displayed

  @TC-380
  Scenario: Verify that the amount in the billing document is displayed as positive
    Given billing document for the sales order is displayed
    When user views the amount in the billing document
    Then amount in the billing document is displayed as positive

  @TC-380
  Scenario: Verify that the quantity in the billing document is displayed as negative
    Given billing document for the sales order is displayed
    When user views the quantity in the billing document
    Then quantity in the billing document is displayed as negative

  @TC-380
  Scenario: Validate the consistency of the sign conventions with the ZOTC_CROSSREFTAB table mappings
    Given billing document for the sales order is displayed
    When user validates the sign conventions with the ZOTC_CROSSREFTAB table mappings
    Then sign conventions are consistent with the ZOTC_CROSSREFTAB table mappings

  @TC-380
  Scenario: User generates a report of the billing document details
    Given billing document for the sales order is displayed
    When user generates a report of the billing document details
    Then report is generated successfully showing the correct sign conventions

  @TC-380
  Scenario: User exports the report for further validation
    Given report of the billing document details is generated
    When user exports the report in the desired format
    Then report is exported successfully

  @TC-380
  Scenario: User logs out of the SAP system
    Given user has completed all required actions
    When user logs out of the SAP system
    Then user is logged out of the SAP system successfully

  @TC-380
  Scenario: User documents the test results and observations
    Given all test steps are completed
    When user documents the test results and observations
    Then test results and observations are documented accurately