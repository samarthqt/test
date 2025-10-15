Feature: Validate system behavior for boundary correction amount (maximum allowable value)

  @TC-401
  Scenario Outline: Validate Invoice Correction Request creation and ZGC1 form generation for maximum allowable correction amount
    Given user logs into the SAP S/4HANA system with valid credentials
    When user navigates to the Invoice Correction Request creation screen
    And user selects the Invoice Correction Request type as <RequestType>
    And user enters the original billing document number <BillingDocumentNumber> and customer details <CustomerDetails>
    And user specifies the correction amount as <CorrectionAmount>
    Then user saves the Invoice Correction Request
    And the Invoice Correction Request is saved with a generated request ID
    And the system generates a ZGC1 form linked to the correction request
    And the ZGC1 form is correctly linked to the original billing document
    When user opens the generated ZGC1 form
    Then the form content matches the correction details
    When user attempts to print the ZGC1 form
    Then the ZGC1 form is successfully printed
    When user attempts to export the ZGC1 form
    Then the ZGC1 form is successfully exported
    And the ZGC1 form is stored and accessible in the system for future reference

    Examples:
      | RequestType | BillingDocumentNumber | CustomerDetails | CorrectionAmount |
      | ZRK         | 123456789             | ABC Corp        | -999999.99       |