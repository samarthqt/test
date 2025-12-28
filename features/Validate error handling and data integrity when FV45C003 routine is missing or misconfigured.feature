Feature: Validate error handling and data integrity when FV45C003 routine is missing or misconfigured

  @TC-193
  Scenario Outline: Verify system behavior during Sales document creation from Billing document when FV45C003 routine is missing or misconfigured
    Given the user navigates to the SAP system
    When the user attempts to create a Sales document "<SalesDocumentType>" from a Billing document "<BillingDocumentType>"
    Then the system displays an error message "<ErrorMessage>"
    And the system prevents the creation of the Sales document
    And no partner data "<PartnerData>" is incorrectly copied to the target Sales document

    Examples:
      | SalesDocumentType | BillingDocumentType | ErrorMessage                                | PartnerData                      |
      | ZCR               | ZL2                 | Copy control routine is missing or invalid | Sold-to, Bill-to, Payer, Ship-to |

  @TC-193
  Scenario: Verify detailed error messages in system logs for missing or misconfigured FV45C003 routine
    Given the user navigates to the SAP system logs
    When the user checks the logs for errors related to the missing or misconfigured FV45C003 routine
    Then the system logs contain detailed error messages explaining the issue

  @TC-193
  Scenario: Verify reassignment of FV45C003 routine to the Billing-to-Sales document pair
    Given the user navigates to the copy control configuration
    When the user reassigns the FV45C003 routine to the Billing-to-Sales document pair
    And the user saves the changes
    Then the routine is reassigned successfully
    And the system allows the creation of Sales documents without errors

  @TC-193
  Scenario: Verify successful Sales document creation after reassigning FV45C003 routine
    Given the user recreates the Billing document "<BillingDocumentType>"
    When the user attempts to generate the Sales document "<SalesDocumentType>"
    Then the Sales document is created successfully
    And the partner data "<PartnerData>" is copied accurately

    Examples:
      | SalesDocumentType | BillingDocumentType | PartnerData                      |
      | ZCR               | ZL2                 | Sold-to, Bill-to, Payer, Ship-to |

  @TC-193
  Scenario: Document test results and provide recommendations for FV45C003 routine configuration issues
    Given the user has completed the test execution
    When the user documents the test results
    And the user provides recommendations for resolving configuration issues
    Then the test results are documented successfully
    And recommendations are provided to prevent future misconfigurations