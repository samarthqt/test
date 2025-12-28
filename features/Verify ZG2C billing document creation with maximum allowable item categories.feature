Feature: Verify ZG2C billing document creation with maximum allowable item categories  
  Ensure that the system can handle the creation of ZG2C billing documents with the maximum allowable number of item categories.

  @TC-521
  Scenario: User logs into the SAP S/4HANA system with billing document creation permissions
    Given the user has valid credentials with billing document creation permissions
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-521
  Scenario: User navigates to the billing document creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing document creation screen using transaction code VF01
    Then the billing document creation screen is displayed

  @TC-521
  Scenario Outline: User selects billing document type ZG2C and enters the original billing document number
    Given the user is on the billing document creation screen
    When the user selects billing document type "<billingDocumentType>" and enters the original billing document number "<originalBillingDocumentNumber>"
    Then the billing document type and original document number are accepted

    Examples:
      | billingDocumentType | originalBillingDocumentNumber |
      | ZG2C                | 3344556677                   |

  @TC-521
  Scenario: User adds maximum allowable item categories to the billing document
    Given the user has selected billing document type ZG2C and entered the original billing document number
    When the user adds 999 item categories, including a mix of L2N and G2N, to the billing document
    Then the system accepts all 999 item categories without errors

  @TC-521
  Scenario: User saves the billing document
    Given the user has added 999 item categories to the billing document
    When the user saves the billing document
    Then the billing document is saved successfully
    And a unique document number is generated

  @TC-521
  Scenario: User verifies item categories in the VBRP table
    Given the billing document is saved successfully
    When the user verifies the item categories in the VBRP table
    Then all 999 item categories are correctly reflected in the VBRP table

  @TC-521
  Scenario: User checks the linkage between the billing document and the original document in the VBFA table
    Given the billing document is saved successfully
    When the user checks the linkage between the billing document and the original document in the VBFA table
    Then the linkage is accurate and consistent

  @TC-521
  Scenario: User generates a report to validate the financial impact of the billing document
    Given the billing document is saved successfully
    When the user generates a report to validate the financial impact of the billing document
    Then the report shows accurate financial entries corresponding to the billing document

  @TC-521
  Scenario: User exports the billing document details to a file for audit purposes
    Given the billing document is saved successfully
    When the user exports the billing document details to a file for audit purposes
    Then the billing document details are successfully exported

  @TC-521
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed their tasks in the SAP S/4HANA system
    When the user logs out of the system
    Then the user is logged out successfully