Feature: Validate data consistency for S1 invoices across Direct and Indirect Sales

  @TC-382
  Scenario: User logs into the SAP system successfully
    Given user has valid credentials
    When user logs into the SAP system
    Then user is logged into the SAP system successfully

  @TC-382
  Scenario: User navigates to the Direct Sales processing program
    Given user is logged into the SAP system
    When user navigates to the Direct Sales processing program
    Then Direct Sales processing program interface is displayed

  @TC-382
  Scenario Outline: User creates and processes a sales order with the S1 billing document type
    Given user is on the Direct Sales processing program interface
    When user enters the sales order details with Order ID "<OrderID>", Customer ID "<CustomerID>", Product ID "<ProductID>", Quantity "<Quantity>", and Price "<Price>"
    And user processes the sales order with the S1 billing document type
    Then sales order is created and processed successfully with the S1 billing document type

    Examples:
      | OrderID | CustomerID | ProductID | Quantity | Price |
      | 10001   | C001       | P001      | 10       | 100   |

  @TC-382
  Scenario: User navigates to the Indirect Sales processing program
    Given user is logged into the SAP system
    When user navigates to the Indirect Sales processing program
    Then Indirect Sales processing program interface is displayed

  @TC-382
  Scenario Outline: User processes an indirect sales transaction with the S1 billing document type
    Given user is on the Indirect Sales processing program interface
    When user enters the indirect sales transaction details with Transaction ID "<TransactionID>", Customer ID "<CustomerID>", Product ID "<ProductID>", Quantity "<Quantity>", and Price "<Price>"
    And user processes the indirect sales transaction with the S1 billing document type
    Then indirect sales transaction is processed successfully with the S1 billing document type

    Examples:
      | TransactionID | CustomerID | ProductID | Quantity | Price |
      | T10002        | C002       | P002      | 5        | 200   |

  @TC-382
  Scenario: User compares the generated data for Direct and Indirect Sales transactions
    Given user has processed both Direct and Indirect Sales transactions
    When user compares the generated data for Direct and Indirect Sales transactions
    Then generated data for Direct and Indirect Sales transactions is consistent and accurate

  @TC-382
  Scenario: User validates the consistency of the sign conventions with the ZOTC_CROSSREFTAB table mappings
    Given user has processed both Direct and Indirect Sales transactions
    When user validates the sign conventions with the ZOTC_CROSSREFTAB table mappings
    Then sign conventions are consistent with the ZOTC_CROSSREFTAB table mappings

  @TC-382
  Scenario: User generates consolidated reports for both Direct and Indirect Sales transactions
    Given user has processed both Direct and Indirect Sales transactions
    When user generates consolidated reports for both Direct and Indirect Sales transactions
    Then consolidated reports are generated successfully showing the correct sign conventions

  @TC-382
  Scenario: User exports the consolidated reports for further validation
    Given user has generated consolidated reports
    When user exports the consolidated reports in the desired format
    Then consolidated reports are exported successfully

  @TC-382
  Scenario: User logs out of the SAP system
    Given user is logged into the SAP system
    When user logs out of the SAP system
    Then user is logged out of the SAP system successfully

  @TC-382
  Scenario: User documents the test results and observations
    Given user has completed all test validations
    When user documents the test results and observations
    Then test results and observations are documented accurately