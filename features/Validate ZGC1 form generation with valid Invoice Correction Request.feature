Feature: Validate ZGC1 form generation with valid Invoice Correction Request

  @TC-78
  Scenario Outline: System generates ZGC1 form for a valid Invoice Correction Request
    Given the user is logged into the SAP S/4HANA system with valid credentials
    And a valid Invoice Correction Request "<Invoice Correction Request ID>" exists in the system
    When the user navigates to the Billing Correction Output form generation screen
    And the user selects the Invoice Correction Request with "<Billing Document Reference>" and "<Correction Type>"
    And the user attempts to generate the ZGC1 form
    Then the system successfully generates the ZGC1 form
    And the generated ZGC1 form is linked to the Invoice Correction Request and original billing document
    And the ZGC1 form contains accurate and complete information

    Examples:
      | Invoice Correction Request ID | Billing Document Reference | Correction Type |
      | 67890                         | Valid                      | Credit          |