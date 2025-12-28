Feature: Validate edge case with maximum allowable quantity in S1 invoices  
  Ensure that the system correctly applies sign conventions for maximum allowable quantity in S1 invoices.  

  @TC-385  
  Scenario Outline: Validate sales order creation and billing document consistency for S1 invoices  
    Given the user logs into the SAP system with valid credentials  
    And the user navigates to the Direct Sales processing program  
    When the user creates a sales order with <Order ID>, <Customer ID>, <Product ID>, <Quantity>, and <Price> using the S1 billing document type  
    Then the sales order is created successfully  
    And the user processes the created sales order  
    And the user navigates to the billing document generated for the sales order  
    Then the billing document is displayed successfully  
    And the amount in the billing document is displayed as positive  
    And the quantity in the billing document is displayed as negative  
    And the sign conventions are consistent with the ZOTC_CROSSREFTAB table mappings  
    When the user generates a report of the billing document details  
    Then the report is generated successfully showing the correct sign conventions  
    And the user exports the report for further validation  
    Then the report is exported successfully in the desired format  

    Examples:  
      | Order ID | Customer ID | Product ID | Quantity         | Price |  
      | 10005    | C005        | P005       | Maximum allowable | 500   |  

  @TC-385  
  Scenario: Log out of the SAP system  
    Given the user is logged into the SAP system  
    When the user logs out of the SAP system  
    Then the user is logged out of the SAP system successfully  

  @TC-385  
  Scenario: Document test results and observations  
    Given the user has completed the validation of the billing document  
    When the user documents the test results and observations  
    Then the test results and observations are documented accurately