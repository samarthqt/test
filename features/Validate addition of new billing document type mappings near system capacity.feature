Feature: Validate addition of new billing document type mappings near system capacity

  @TC-31
  Scenario: User logs into the SAP S/4HANA system and navigates to the home screen
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user successfully navigates to the home screen

  @TC-31
  Scenario: User accesses the ZOTC_CROSSREFTAB table
    Given the ZOTC_CROSSREFTAB table contains a large number of mappings close to the system's maximum limit
    When the user accesses the ZOTC_CROSSREFTAB table using transaction SE16N
    Then the ZOTC_CROSSREFTAB table is displayed

  @TC-31
  Scenario Outline: User adds a new billing document type to the ZOTC_CROSSREFTAB table
    Given the user is on the ZOTC_CROSSREFTAB table
    When the user adds a new entry for billing document type "<billing_document_type>" with relevant details
    Then the new entry for "<billing_document_type>" is added successfully

    Examples:
      | billing_document_type |
      | ZF2                  |
      | S1                   |
      | ZG2C                 |
      | ZL2C                 |

  @TC-31
  Scenario: User verifies the total number of entries in the table
    Given the user has added new billing document types to the ZOTC_CROSSREFTAB table
    When the user verifies the total number of entries in the table
    Then the total number of entries is confirmed to be near the system's maximum limit

  @TC-31
  Scenario: User saves changes and validates table entries
    Given the user has added new billing document types to the ZOTC_CROSSREFTAB table
    When the user saves the changes
    Then all new entries are saved and displayed correctly in the table

  @TC-31
  Scenario: User navigates to the ZOTC_SALES_ORDER program
    Given the ZOTC_CROSSREFTAB table contains the new billing document types
    When the user navigates to the ZOTC_SALES_ORDER program
    Then the ZOTC_SALES_ORDER program opens successfully

  @TC-31
  Scenario Outline: User creates a sales order using a new billing document type
    Given the user is in the ZOTC_SALES_ORDER program
    When the user creates a sales order using the billing document type "<billing_document_type>"
    Then the sales order is created successfully using "<billing_document_type>"

    Examples:
      | billing_document_type |
      | ZF2                  |
      | S1                   |
      | ZG2C                 |
      | ZL2C                 |

  @TC-31
  Scenario: User verifies the system processes sales orders without errors
    Given the user has created sales orders for all new billing document types
    When the user verifies the system processes the orders
    Then the system processes the sales orders without errors