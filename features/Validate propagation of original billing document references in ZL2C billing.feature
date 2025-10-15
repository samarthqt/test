Feature: Validate propagation of original billing document references in ZL2C billing

  @TC-41
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-41
  Scenario: User navigates to the billing correction request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing correction request creation screen
    Then the billing correction request creation screen is displayed

  @TC-41
  Scenario Outline: User creates a billing correction request
    Given the user is on the billing correction request creation screen
    When the user enters the original billing document number "<originalBillingDocumentNumber>" 
      And the user selects billing correction request type "<correctionRequestType>"
      And the user saves the billing correction request
    Then the billing correction request is successfully created

    Examples:
      | originalBillingDocumentNumber | correctionRequestType |
      | 12345678                      | ZRK1                  |

  @TC-41
  Scenario: User generates a ZL2C billing document
    Given the billing correction request is successfully created
    When the user generates a ZL2C billing document linked to the billing correction request
    Then the ZL2C billing document is successfully generated

  @TC-41
  Scenario: User accesses VBFA table for ZL2C billing document
    Given the ZL2C billing document is successfully generated
    When the user accesses the VBFA table to locate the entries for the ZL2C billing document
    Then the VBFA table entries for the ZL2C billing document are displayed

  @TC-41
  Scenario Outline: User verifies fields in VBFA table for ZL2C billing document
    Given the VBFA table entries for the ZL2C billing document are displayed
    When the user verifies the "<field>" field in the VBFA table for "<expectedValue>"
    Then the "<field>" field correctly reflects "<expectedValue>"

    Examples:
      | field  | expectedValue |
      | VGBEL  | 12345678      |
      | VGPOS  | OriginalPos   |

  @TC-41
  Scenario: User checks document flow for ZL2C billing document
    Given the ZL2C billing document is successfully generated
    When the user checks the document flow for the ZL2C billing document
    Then the document flow accurately links the ZL2C billing document to the original billing document

  @TC-41
  Scenario: User generates a report for VBFA table consistency
    Given the ZL2C billing document is successfully generated
    When the user generates a report to review the VBFA table entries for consistency
    Then the report confirms accurate propagation of original billing document references

  @TC-41
  Scenario: User validates financial data in ZL2C billing document
    Given the ZL2C billing document is successfully generated
    When the user validates the financial data in the ZL2C billing document
    Then the financial data is consistent and accurately reflects the original billing document references

  @TC-41
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed their tasks in the SAP S/4HANA system
    When the user logs out of the SAP S/4HANA system
    Then the user is successfully logged out