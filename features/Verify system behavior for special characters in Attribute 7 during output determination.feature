Feature: Verify system behavior for special characters in Attribute 7 during output determination

  @TC-262
  Scenario Outline: Validate system handling of special characters in Attribute 7
    Given the user is logged into the SAP system with access to the Payer Business Partner master data
    And the Payer Business Partner ID "<PayerBusinessPartnerID>" is available
    And Attribute 7 is available for configuration in the master data
    When the user navigates to the Payer Business Partner master data screen
    And the user sets Attribute 7 to "<Attribute7Value>" and saves the changes
    Then Attribute 7 is successfully updated with the value "<Attribute7Value>" and changes are saved without errors
    When the user creates a new billing document for the Payer Business Partner with billing document type "<BillingDocumentType>"
    Then the billing document is successfully created with the updated Attribute 7 value
    When the user triggers the output determination process for the billing document
    Then the output determination process is executed successfully
    When the user verifies the output log for the billing document
    Then the output log indicates that the system handled the special characters correctly
    When the user checks the document flow for the billing document
    Then the document flow reflects the expected output behavior for the special characters
    When the user validates the system logs for any errors during the process
    Then the system logs confirm that the process executed without errors

    Examples:
      | PayerBusinessPartnerID | Attribute7Value       | BillingDocumentType |
      | PBP12350               | @#$%^&*              | ZPDT                |
      | PBP12350               | <>?/|\~              | ZPDT                |
      | PBP12350               | Special!@#           | ZPDT                |
      | PBP12350               | ( ){}[]              | ZPDT                |
      | PBP12350               | +-=_:;'"             | ZPDT                |

  @TC-262
  Scenario: Document the results and submit the test report for review
    Given the test results have been documented and compared with the expected outcomes
    Then the results align with the expected outcomes, confirming successful handling of special characters
    When the user submits the test report for review
    Then the test report is submitted successfully with all results documented