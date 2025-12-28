Feature: Verify successful configuration and functionality of FV45C003 routine for Billing-to-Sales document pairs

  @TC-192
  Scenario Outline: Validate configuration and execution of FV45C003 routine for Billing-to-Sales document pairs
    Given the user navigates to the SAP configuration for copy control routines
    When the user locates the mapping table for Billing-to-Sales document pairs
    And the user assigns FV45C003 to the Billing document type "<BillingDocument>" and Sales document type "<SalesDocument>"
    And the user saves the configuration changes
    And the user creates a test Billing document using type "<BillingDocument>"
    And the user generates a corresponding Sales document using the configured copy control routine
    Then the Sales document "<SalesDocument>" is generated successfully using the FV45C003 routine
    And the partner data "<PartnerData>" is accurately copied to the Sales document
    And the document flow shows the correct linkage between the Billing and Sales documents
    And no errors or warnings are logged related to the process
    And the routine FV45C003 is active and functional in the system

    Examples:
      | BillingDocument | SalesDocument | PartnerData             |
      | ZL2             | ZCR           | Sold-to, Bill-to, Payer, Ship-to |
      | ZLC             | ZCR           | Sold-to, Bill-to, Payer, Ship-to |
      | ZF2             | ZDR           | Sold-to, Bill-to, Payer, Ship-to |

  @TC-192
  Scenario: Document the test results and obtain stakeholder approval
    Given the user has completed testing the FV45C003 routine for all specified Billing-to-Sales document pairs
    When the user documents the test results
    Then stakeholders approve the successful configuration