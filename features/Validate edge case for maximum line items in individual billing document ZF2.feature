Feature: Validate edge case for maximum line items in individual billing document ZF2

  @TC-148
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the SAP system

  @TC-148
  Scenario: User navigates to the Sales Order creation module
    Given the user is logged into the SAP system
    When the user navigates to the Sales Order creation module
    Then the Sales Order creation screen is displayed

  @TC-148
  Scenario Outline: User creates a Sales Order with maximum line items
    Given the user is on the Sales Order creation screen
    When the user creates a new Sales Order of type "<SalesOrderType>" with Attribute1 set to "<Attribute1>" and adds "<NumberOfLineItems>" line items
    Then the Sales Order is created successfully with "<NumberOfLineItems>" line items

    Examples:
      | SalesOrderType | Attribute1 | NumberOfLineItems |
      | ZOR            | ZI         | 999               |

  @TC-148
  Scenario: User saves the Sales Order and notes the generated Sales Order number
    Given the user has created a Sales Order with maximum line items
    When the user saves the Sales Order
    Then the Sales Order is saved, and a unique Sales Order number is generated

  @TC-148
  Scenario: User triggers the billing due program for the created Sales Order
    Given the user has a valid Sales Order number
    When the user triggers the billing due program for the created Sales Order
    Then the billing due program is executed successfully

  @TC-148
  Scenario: User verifies the creation of an individual billing document of type ZF2
    Given the billing due program has been executed successfully
    When the user verifies the creation of an individual billing document of type ZF2 for the Sales Order
    Then an individual billing document of type ZF2 is created successfully

  @TC-148
  Scenario Outline: User validates the content of the generated billing document
    Given an individual billing document of type "<BillingDocumentType>" is created
    When the user opens the generated billing document
    Then the billing document content matches the defined rules and includes "<NumberOfLineItems>" line items

    Examples:
      | BillingDocumentType | NumberOfLineItems |
      | ZF2                 | 999               |

  @TC-148
  Scenario: User checks the document flow for proper linkage
    Given the billing document is created
    When the user checks the document flow
    Then the document flow shows correct linkage between the Sales Order and the billing document

  @TC-148
  Scenario: User validates that the billing document is posted in the financial system
    Given the billing document is created
    When the user validates the posting of the billing document in the financial system
    Then the billing document is posted successfully, and financial entries are generated

  @TC-148
  Scenario: User verifies accessibility of the billing document for further processing
    Given the billing document is created
    When the user verifies the accessibility of the billing document
    Then the billing document is accessible and available for further processing

  @TC-148
  Scenario: User checks for error messages in system logs during billing document creation
    Given the billing document is created
    When the user checks the system logs for error messages during the billing document creation process
    Then no error messages are found in the system logs

  @TC-148
  Scenario: User ensures compliance of the billing document with formatting and content standards
    Given the billing document is created
    When the user ensures compliance of the billing document with the organization's formatting and content standards
    Then the billing document complies with all formatting and content standards