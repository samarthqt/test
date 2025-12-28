Feature: Validate creation of individual billing document ZF2 for orders with Attribute1 = 'ZI'

  Ensure that individual billing documents of type ZF2 are created successfully for orders with Attribute1 = 'ZI'. Sales Order type ZOR and billing document type ZF2 must be configured in the system.

  @TC-146
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the SAP system

  @TC-146
  Scenario: User navigates to the Sales Order creation module
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the Sales Order creation module
    Then the Sales Order creation screen is displayed

  @TC-146
  Scenario Outline: User creates a new Sales Order of type ZOR with Attribute1 = 'ZI'
    Given the user is on the Sales Order creation screen
    When the user creates a new Sales Order of type <SalesOrderType> and sets Attribute1 to <Attribute1>
    Then the Sales Order is created successfully with Attribute1 = <Attribute1>

    Examples:
      | SalesOrderType | Attribute1 |
      | ZOR            | ZI         |

  @TC-146
  Scenario: User saves the Sales Order and notes the generated Sales Order number
    Given the user has created a Sales Order with Attribute1 = 'ZI'
    When the user saves the Sales Order
    Then the Sales Order is saved, and a unique Sales Order number is generated

  @TC-146
  Scenario: User triggers the billing due program for the created Sales Order
    Given the user has a saved Sales Order with Attribute1 = 'ZI'
    When the user triggers the billing due program for the created Sales Order
    Then the billing due program is executed successfully

  @TC-146
  Scenario: Verify creation of an individual billing document of type ZF2 for the Sales Order
    Given the billing due program is executed successfully
    When the user verifies the billing documents
    Then an individual billing document of type ZF2 is created successfully for the Sales Order

  @TC-146
  Scenario: User opens the generated billing document and validates its content
    Given an individual billing document of type ZF2 is created
    When the user opens the generated billing document
    Then the billing document content matches the defined rules and mappings

  @TC-146
  Scenario: User checks the document flow for proper linkage
    Given an individual billing document of type ZF2 is created
    When the user checks the document flow
    Then the document flow shows correct linkage between the Sales Order and the billing document

  @TC-146
  Scenario: Validate that the billing document is posted successfully in the financial system
    Given an individual billing document of type ZF2 is created
    When the user checks the financial system
    Then the billing document is posted successfully, and financial entries are generated

  @TC-146
  Scenario: Verify accessibility of the billing document for further processing
    Given an individual billing document of type ZF2 is created
    When the user attempts to access the billing document
    Then the billing document is accessible and available for further processing

  @TC-146
  Scenario: Check for error messages in the system logs during billing document creation
    Given an individual billing document of type ZF2 is created
    When the user checks the system logs during the billing document creation process
    Then no error messages are found in the system logs

  @TC-146
  Scenario: Ensure billing document complies with formatting and content standards
    Given an individual billing document of type ZF2 is created
    When the user validates the document compliance
    Then the billing document complies with all formatting and content standards