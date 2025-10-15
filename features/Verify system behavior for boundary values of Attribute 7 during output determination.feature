Feature: Verify system behavior for boundary values of Attribute 7 during output determination

  @TC-261
  Scenario Outline: Validate the system's handling of boundary values for Attribute 7 during output determination
    Given the user is logged into the SAP system with appropriate permissions
    And the user has access to the Payer Business Partner master data with ID "<Payer Business Partner ID>"
    And Attribute 7 is available for configuration in the master data
    When the user navigates to the Payer Business Partner master data screen
    And the user sets Attribute 7 to "<Attribute 7 value>" and saves the changes
    Then Attribute 7 is successfully updated and changes are saved without errors
    When the user creates a new billing document for the Payer Business Partner with billing document type "<Billing document type>"
    Then the billing document is successfully created with the updated Attribute 7 value
    When the user triggers the output determination process for the billing document
    Then the output determination process is executed successfully
    And the output log indicates that the system handled the "<Attribute 7 value>" value correctly
    When the user checks the document flow for the billing document
    Then the document flow reflects the expected output behavior for the "<Attribute 7 value>" value
    When the user validates the system logs for any errors during the process
    Then the system logs confirm that the process executed without errors

    Examples:
      | Payer Business Partner ID | Attribute 7 value       | Billing document type |
      | PBP12349                  | Maximum allowable length | ZPDT                  |
      | PBP12349                  | Minimum allowable length | ZPDT                  |

  @TC-261
  Scenario: Document the results and compare them with the expected outcomes
    Given the user has completed the output determination process for Attribute 7's boundary values
    When the user documents the results and compares them with the expected outcomes
    Then the results align with the expected outcomes, confirming successful handling of boundary values

  @TC-261
  Scenario: Submit the test report for review
    Given the user has documented all results for the boundary value tests of Attribute 7
    When the user submits the test report for review
    Then the test report is submitted successfully with all results documented