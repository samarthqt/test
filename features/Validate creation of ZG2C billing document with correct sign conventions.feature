Feature: Validate creation of ZG2C billing document with correct sign conventions

  @TC-516
  Scenario: User logs into the SAP S/4HANA system with billing document creation permissions
    Given the user has billing document creation permissions
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-516
  Scenario: User navigates to the billing document creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing document creation screen using transaction code VF01
    Then the billing document creation screen is displayed

  @TC-516
  Scenario Outline: User selects billing document type ZG2C and enters an original billing document number
    Given the user is on the billing document creation screen
    When the user selects billing document type "<BillingDocumentType>" and enters the original billing document number "<OriginalBillingDocumentNumber>"
    Then the billing document type and original document number are accepted

    Examples:
      | BillingDocumentType | OriginalBillingDocumentNumber |
      | ZG2C                | 123456789                     |

  @TC-516
  Scenario Outline: User adds item categories with specified details
    Given the user is creating a billing document of type ZG2C
    When the user adds item category "<ItemCategory>" with quantity "<Quantity>" and price "<Price>"
    Then the item category "<ItemCategory>" is added successfully with the specified details

    Examples:
      | ItemCategory | Quantity | Price  |
      | L2N          | 10       | 100    |
      | G2N          | 5        | -50    |

  @TC-516
  Scenario: User saves the billing document
    Given the user has added item categories to the billing document
    When the user saves the billing document
    Then the billing document is saved successfully, and a unique document number is generated

  @TC-516
  Scenario: User verifies the newly created billing document in the VBFA table
    Given the billing document is successfully created
    When the user navigates to the VBFA table and searches for the newly created billing document
    Then the original billing document numbers and positions are correctly linked in the VGBEL and VGPOS fields

  @TC-516
  Scenario: User verifies the sign conventions in the VBRP table
    Given the billing document is successfully created
    When the user verifies the sign conventions in the VBRP table
    Then the L2N items are positive, and G2N items are negative in the VBRP table

  @TC-516
  Scenario: User checks the consistency of data in the VBRP table
    Given the billing document is successfully created
    When the user checks the consistency of data in the VBRP table
    Then the data is consistent, and no discrepancies are found

  @TC-516
  Scenario: User generates a report to validate the financial impact of the billing document
    Given the billing document is successfully created
    When the user generates a report to validate the financial impact of the billing document
    Then the report shows accurate financial entries corresponding to the billing document

  @TC-516
  Scenario: User exports the billing document details to a file for audit purposes
    Given the billing document is successfully created
    When the user exports the billing document details to a file
    Then the billing document details are successfully exported

  @TC-516
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed all billing document-related tasks
    When the user logs out of the SAP S/4HANA system
    Then the user is logged out successfully