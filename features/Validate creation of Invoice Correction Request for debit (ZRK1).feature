Feature: Validate creation of Invoice Correction Request for debit (ZRK1)

  @TC-74
  Scenario: Verify user login to the SAP S/4HANA system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user should be successfully logged in and have access to the Invoice Correction Request module

  @TC-74
  Scenario: Navigate to the Invoice Correction Request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Invoice Correction Request creation screen
    Then the Invoice Correction Request creation screen should be displayed

  @TC-74
  Scenario Outline: Select an existing sales invoice for correction
    Given the user is on the Invoice Correction Request creation screen
    When the user selects an existing sales invoice "<Invoice Number>" for correction
    Then the selected invoice details should be populated on the screen

    Examples:
      | Invoice Number |
      | INV-002        |

  @TC-74
  Scenario Outline: Enter correction type
    Given the user has selected an invoice for correction
    When the user enters the correction type as "<Correction Type>"
    Then the correction type "<Correction Type>" should be accepted and displayed

    Examples:
      | Correction Type |
      | ZRK1            |

  @TC-74
  Scenario Outline: Enter price adjustment
    Given the user has entered the correction type
    When the user enters the price adjustment as "<Price Adjustment>"
    Then the price adjustment "<Price Adjustment>" should be accepted and displayed

    Examples:
      | Price Adjustment |
      | +$100            |

  @TC-74
  Scenario Outline: Enter quantity adjustment
    Given the user has entered the price adjustment
    When the user enters the quantity adjustment as "<Quantity Adjustment>"
    Then the quantity adjustment "<Quantity Adjustment>" should be accepted and displayed

    Examples:
      | Quantity Adjustment |
      | +10 units           |

  @TC-74
  Scenario: Save the Invoice Correction Request
    Given the user has entered all required details for the Invoice Correction Request
    When the user saves the Invoice Correction Request
    Then the Invoice Correction Request should be saved successfully with a unique request number

  @TC-74
  Scenario Outline: Validate debit memo generation
    Given the Invoice Correction Request has been saved successfully
    When the system generates a debit memo "<Debit Memo>" for the correction request
    Then the debit memo "<Debit Memo>" should be generated successfully and linked to the correction request

    Examples:
      | Debit Memo |
      | ZL2C       |

  @TC-74
  Scenario: Verify linkage between correction request and original billing document
    Given the debit memo has been generated and linked to the correction request
    When the user views the document flow
    Then the linkage between the correction request and the original billing document should be correctly displayed

  @TC-74
  Scenario: Check financial postings for debit memo
    Given the debit memo has been generated
    When the user checks the financial postings for the debit memo
    Then the financial postings should reflect the price and quantity adjustments accurately

  @TC-74
  Scenario: Verify debit memo visibility in the customer account statement
    Given the debit memo has been generated
    When the user views the customer account statement
    Then the debit memo should be listed in the customer account statement

  @TC-74
  Scenario: Log out of the SAP S/4HANA system
    Given the user has completed all actions
    When the user logs out of the SAP S/4HANA system
    Then the user should be logged out successfully