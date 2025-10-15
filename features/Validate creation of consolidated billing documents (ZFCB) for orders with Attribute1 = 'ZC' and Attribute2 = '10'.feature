Feature: Validate creation of consolidated billing documents (ZFCB) for orders with Attribute1 = 'ZC' and Attribute2 = '10'

  @TC-426
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-426
  Scenario: User navigates to the Sales Order creation module
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the Sales Order creation module
    Then the Sales Order creation module is displayed

  @TC-426
  Scenario Outline: User creates multiple Sales Orders with specified attributes
    Given the user is in the Sales Order creation module
    When the user creates Sales Orders with Attribute1 = "<Attribute1>" and Attribute2 = "<Attribute2>"
    Then the Sales Orders are created successfully with the specified attributes

    Examples:
      | Attribute1 | Attribute2 |
      | ZC         | 10         |

  @TC-426
  Scenario: User triggers the billing due program for created Sales Orders
    Given the user has created Sales Orders with Attribute1 = 'ZC' and Attribute2 = '10'
    When the user triggers the billing due program for the created Sales Orders
    Then the billing due program is executed successfully

  @TC-426
  Scenario: User verifies the system generates a consolidated billing document of type ZFCB
    Given the billing due program is executed successfully
    When the user checks the generated billing document
    Then a consolidated billing document of type ZFCB is generated successfully

  @TC-426
  Scenario: User opens the generated billing document and validates its content
    Given a consolidated billing document of type ZFCB is generated
    When the user opens the billing document
    Then the billing document content aligns with the defined rules and mappings

  @TC-426
  Scenario: User checks the format of the billing document
    Given the billing document is generated
    When the user reviews the format of the billing document
    Then the billing document format complies with the predefined standards

  @TC-426
  Scenario: User verifies all linked Sales Orders are included in the consolidated billing document
    Given the billing document is generated
    When the user checks the linked Sales Orders in the billing document
    Then all Sales Orders with Attribute1 = 'ZC' and Attribute2 = '10' are consolidated into the billing document

  @TC-426
  Scenario: User validates the document number and type in the billing document header
    Given the billing document is generated
    When the user reviews the document header
    Then the document number and type are correctly populated as per system configuration

  @TC-426
  Scenario: User checks the audit logs for the billing document creation process
    Given the billing document is generated
    When the user reviews the audit logs for the billing document creation process
    Then the audit logs show successful creation of the billing document without errors

  @TC-426
  Scenario: User verifies the billing document is posted to the financial module
    Given the billing document is generated
    When the user checks the financial module for the billing document
    Then the billing document is successfully posted to the financial module

  @TC-426
  Scenario: User validates the status of the billing document in the system
    Given the billing document is posted to the financial module
    When the user checks the status of the billing document in the system
    Then the billing document status is updated to 'Completed'