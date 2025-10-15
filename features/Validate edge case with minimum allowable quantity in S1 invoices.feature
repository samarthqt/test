Feature: Validate edge case with minimum allowable quantity in S1 invoices  
  Ensure that the system correctly applies sign conventions for minimum allowable quantity in S1 invoices.  

  @TC-386  
  Scenario: User logs into the SAP system successfully  
    Given the user has valid credentials  
    When the user logs into the SAP system  
    Then the user is logged into the SAP system successfully  

  @TC-386  
  Scenario: User navigates to the Direct Sales processing program  
    Given the user is logged into the SAP system  
    When the user navigates to the Direct Sales processing program (ZOTC_SALES_ORDER)  
    Then the Direct Sales processing program interface is displayed  

  @TC-386  
  Scenario Outline: User creates a sales order with minimum allowable quantity using S1 billing document type  
    Given the user is on the Direct Sales processing program interface  
    When the user creates a sales order with the following details:  
      | Order ID   | Customer ID   | Product ID   | Quantity           | Price | Billing Document Type |  
      | <Order ID> | <Customer ID> | <Product ID> | <Quantity>         | <Price> | <Billing Document Type> |  
    Then the sales order is created successfully  

    Examples:  
      | Order ID | Customer ID | Product ID | Quantity        | Price | Billing Document Type |  
      | 10006    | C006        | P006       | Minimum allowable | 100   | S1                   |  

  @TC-386  
  Scenario: User processes the created sales order  
    Given the user has created a sales order successfully  
    When the user processes the created sales order  
    Then the sales order is processed without any errors  

  @TC-386  
  Scenario: User navigates to the billing document generated for the sales order  
    Given the sales order is processed successfully  
    When the user navigates to the billing document generated for the sales order  
    Then the billing document for the sales order is displayed  

  @TC-386  
  Scenario Outline: User verifies the sign conventions in the billing document  
    Given the billing document for the sales order is displayed  
    When the user verifies the following details in the billing document:  
      | Field  | Expected Value |  
      | <Field> | <Expected Value> |  
    Then the values in the billing document are displayed as expected  

    Examples:  
      | Field     | Expected Value |  
      | Amount    | Positive       |  
      | Quantity  | Negative       |  

  @TC-386  
  Scenario: User validates the consistency of sign conventions with ZOTC_CROSSREFTAB table mappings  
    Given the billing document is displayed  
    When the user validates the consistency of the sign conventions with the ZOTC_CROSSREFTAB table mappings  
    Then the sign conventions are consistent with the ZOTC_CROSSREFTAB table mappings  

  @TC-386  
  Scenario: User generates a report of the billing document details  
    Given the sign conventions are validated successfully  
    When the user generates a report of the billing document details  
    Then the report is generated successfully showing the correct sign conventions  

  @TC-386  
  Scenario: User exports the report for further validation  
    Given the report is generated successfully  
    When the user exports the report in the desired format  
    Then the report is exported successfully  

  @TC-386  
  Scenario: User logs out of the SAP system  
    Given the user has completed all actions  
    When the user logs out of the SAP system  
    Then the user is logged out of the SAP system successfully  

  @TC-386  
  Scenario: User documents the test results and observations  
    Given the user has completed all test validations  
    When the user documents the test results and observations  
    Then the test results and observations are documented accurately