Feature: Validate correct Billing Type selection for ZC scenarios with subtype 20

  @TC-157
  Scenario Outline: Ensure the billing due program generates a billing document of type ZF2C for Attribute 1 as ZC and Subtype 20
    Given the user logs into the SAP S/4HANA Cloud system with appropriate credentials
    And Attribute 1 is set to "<Attribute1>"
    And Attribute 2 is correctly configured in the system
    When the user navigates to the billing due program
    And the user enters Attribute 1 as "<Attribute1>" in the relevant field
    And the user enters Subtype as "<Subtype>" in the respective field
    And the user populates Attribute 2 with "<Attribute2>"
    And the user executes the billing due program
    Then the billing due program executes without errors
    And a billing document of type "<BillingDocumentType>" is generated
    And the document details ensure proper mapping for Attribute 1 ("<Attribute1>") and Subtype ("<Subtype>")
    And the document flow shows correct linkage and no errors
    And the financial postings associated with the billing document are accurate and reflect the correct billing type
    And the system logs do not contain any warnings or errors
    And the billing document is marked as ready for further processing

    Examples:
      | Attribute1 | Subtype | Attribute2 | BillingDocumentType |
      | ZC         | 20      | ValidData  | ZF2C               |