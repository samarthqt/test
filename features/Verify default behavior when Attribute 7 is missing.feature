Feature: Verify default behavior when Attribute 7 is missing

  @TC-259
  Scenario Outline: Validate system behavior in the absence of Attribute 7 during output determination
    Given the user is logged into the SAP system with appropriate permissions
    And the Payer Business Partner master data for "<Payer Business Partner ID>" is accessible
    And Attribute 7 is not configured in the master data
    When the user navigates to the Payer Business Partner master data screen
    Then the master data screen for the Payer Business Partner is displayed
    And Attribute 7 is not present in the master data fields
    When the user creates a new billing document for the Payer Business Partner with billing document type "<Billing Document Type>"
    Then the billing document is successfully created without Attribute 7
    When the user triggers the output determination process for the billing document
    Then the output determination process is executed successfully
    And the output log indicates that the system used default behavior for output determination
    When the user checks the document flow for the billing document
    Then the document flow reflects the default output behavior
    And the system logs confirm that the process executed without errors

    Examples:
      | Payer Business Partner ID | Billing Document Type |
      | PBP12347                  | ZPDT                  |
      | PBP67890                  | ZPDT                  |

  @TC-259
  Scenario: Submit the test report for review
    Given the user has completed the validation of the system behavior for missing Attribute 7
    When the user documents the results and compares them with the expected outcomes
    Then the results align with the expected outcomes, confirming successful handling of missing Attribute 7
    And the user submits the test report for review
    Then the test report is submitted successfully with all results documented