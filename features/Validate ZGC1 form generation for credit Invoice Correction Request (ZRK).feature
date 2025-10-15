Feature: Validate ZGC1 form generation for credit Invoice Correction Request (ZRK)

  @TC-396
  Scenario Outline: Validate Invoice Correction Request creation and ZGC1 form generation
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    When the user navigates to the Invoice Correction Request creation screen
    And the user selects the Invoice Correction Request type as "<RequestType>"
    And the user enters the original billing document number "<OriginalBillingDocument>" and customer details "<Customer>"
    And the user specifies the correction amount as "<CorrectionAmount>"
    And the user saves the Invoice Correction Request
    Then the Invoice Correction Request is saved, and a request ID is generated
    And the system generates a ZGC1 form linked to the correction request
    And the ZGC1 form is linked to the original billing document

    Examples:
      | RequestType | OriginalBillingDocument | Customer   | CorrectionAmount |
      | ZRK         | 123456789               | ABC Corp   | -500.00          |

  @TC-396
  Scenario: Verify ZGC1 form content accuracy
    Given the user has generated a ZGC1 form linked to the Invoice Correction Request
    When the user opens the generated ZGC1 form
    Then the content of the ZGC1 form is accurate and matches the correction details

  @TC-396
  Scenario: Validate printing of the ZGC1 form
    Given the user has generated a ZGC1 form linked to the Invoice Correction Request
    When the user attempts to print the ZGC1 form
    Then the ZGC1 form is successfully printed

  @TC-396
  Scenario: Validate exporting of the ZGC1 form
    Given the user has generated a ZGC1 form linked to the Invoice Correction Request
    When the user attempts to export the ZGC1 form
    Then the ZGC1 form is successfully exported

  @TC-396
  Scenario: Verify ZGC1 form accessibility for future reference
    Given the user has generated a ZGC1 form linked to the Invoice Correction Request
    When the user searches for the ZGC1 form in the system
    Then the ZGC1 form is stored and accessible in the system