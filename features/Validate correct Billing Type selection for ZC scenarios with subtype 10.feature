Feature: Validate correct Billing Type selection for ZC scenarios with subtype 10

  @TC-156
  Scenario Outline: Ensure the billing due program generates a billing document of type ZFCB when Attribute 1 is ZC and Subtype is 10
    Given the user logs into the SAP S/4HANA Cloud system with appropriate credentials
    And the user navigates to the billing due program
    When the user enters Attribute 1 as "<Attribute1>"
    And the user enters Subtype as "<Subtype>"
    And the user populates Attribute 2 with "<Attribute2>"
    And the user executes the billing due program
    Then the system generates a billing document of type "<BillingDocumentType>"
    And the document details show proper mapping for Attribute 1 "<Attribute1>" and Subtype "<Subtype>"
    And the document flow shows correct linkage without errors
    And the financial postings are accurate and reflect the correct billing type
    And the system logs do not show any warnings or errors
    And the billing document is marked as ready for further processing

    Examples:
      | Attribute1 | Subtype | Attribute2 | BillingDocumentType |
      | ZC         | 10      | ValidData  | ZFCB               |