Feature: Validate system behavior when ZPDT template is missing

  @TC-89
  Scenario: User successfully logs in to the SAP system
    Given the user has valid credentials
    When the user logs into the SAP system
    Then the user is successfully logged in

  @TC-89
  Scenario: User navigates to the Invoice Correction Request creation screen
    Given the user is logged into the SAP system
    When the user navigates to the Invoice Correction Request creation screen
    Then the Invoice Correction Request creation screen is displayed

  @TC-89
  Scenario: User creates an Invoice Correction Request (ZRK) for a credit adjustment
    Given the user is on the Invoice Correction Request creation screen
    When the user creates an Invoice Correction Request (ZRK) for a credit adjustment with a missing ZPDT template
    Then the Invoice Correction Request (ZRK) is created successfully

  @TC-89
  Scenario Outline: Validate system behavior when attempting to generate outputs with a missing ZPDT template
    Given the user has created an Invoice Correction Request (ZRK) with a missing ZPDT template
    When the user attempts to generate the "<output_type>" output using the Print Program "<print_program>"
    Then the system displays an error indicating the missing ZPDT template
    And the system logs indicate the absence of the ZPDT template

    Examples:
      | output_type | print_program          |
      | ZGC1        | SD_INVOICE_PRINT01     |
      | ZGL1        | SD_INVOICE_PRINT01     |

  @TC-89
  Scenario: Verify the system prevents printing of ZGC1 and ZGL1 outputs
    Given the ZPDT template is missing
    When the user attempts to print outputs ZGC1 and ZGL1
    Then the system does not allow printing of outputs without the ZPDT template

  @TC-89
  Scenario: Validate error handling process for missing templates
    Given the ZPDT template is missing
    When the user attempts to perform template-dependent operations
    Then the system provides clear and actionable error messages

  @TC-89
  Scenario: Ensure compliance with operational and billing standards
    Given the ZPDT template is missing
    When the user interacts with the system
    Then the system complies with operational and billing standards