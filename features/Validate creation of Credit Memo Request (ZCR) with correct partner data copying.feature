Feature: Validate creation of Credit Memo Request (ZCR) with correct partner data copying

  @TC-183
  Scenario: User navigates to transaction VA01 for creating Credit Memo Request
    Given the user navigates to transaction VA01
    Then the transaction VA01 screen is displayed

  @TC-183
  Scenario Outline: Validate input of the original Billing document number
    Given the user enters the original Billing document number "<BillingDocumentNumber>" as the reference
    Then the Billing document number "<BillingDocumentNumber>" is accepted and reference details are loaded

    Examples:
      | BillingDocumentNumber |
      | 100000001             |

  @TC-183
  Scenario: Verify header-level partner data in the Billing document
    Given the user verifies the header-level partner data in the Billing document
    Then the partner data matches the expected values:
      | PartnerType | PartnerName |
      | Sold-to     | Partner A   |
      | Bill-to     | Partner B   |
      | Payer       | Partner C   |
      | Ship-to     | Partner D   |

  @TC-183
  Scenario: Execute the creation process for the Credit Memo Request
    When the user executes the creation process for the Credit Memo Request
    Then the Credit Memo Request is created successfully

  @TC-183
  Scenario: Validate partner data copying from CVBPA to XVBPA
    Given the user validates that the partner data is copied correctly from CVBPA to XVBPA
    Then the copied partner data matches the expected values:
      | PartnerType | PartnerName |
      | Sold-to     | Partner A   |
      | Bill-to     | Partner B   |
      | Payer       | Partner C   |
      | Ship-to     | Partner D   |

  @TC-183
  Scenario: Navigate to the 'display billing detail' report
    Given the user navigates to the 'display billing detail' report
    Then the 'display billing detail' report is accessible

  @TC-183
  Scenario: Verify referenced sales orders in the 'display billing detail' report
    Given the user verifies the referenced sales orders in the 'display billing detail' report
    Then the referenced sales orders are displayed correctly in the report

  @TC-183
  Scenario: Check linkage between Credit Memo Request and original Billing document
    Given the user checks the linkage between the Credit Memo Request and the original Billing document in the document flow
    Then the document flow shows correct linkage between the Credit Memo Request and the original Billing document

  @TC-183
  Scenario: Validate financial postings for the Credit Memo Request
    Given the user validates the financial postings associated with the Credit Memo Request
    Then the financial postings are accurate and aligned with the Credit Memo Request

  @TC-183
  Scenario: Verify adherence to configured copy routine FV45C003
    Given the user verifies that the Credit Memo Request adheres to the configured copy routine FV45C003
    Then the copy routine FV45C003 is applied correctly

  @TC-183
  Scenario: Check for errors or warnings during the creation process
    Given the user checks for any errors or warnings in the system during the creation process
    Then no errors or warnings are observed

  @TC-183
  Scenario: Validate the audit trail for the creation of the Credit Memo Request
    Given the user validates the audit trail for the creation of the Credit Memo Request
    Then the audit trail reflects accurate creation details for the Credit Memo Request