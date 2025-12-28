Feature: Verify Attribute 7 absence handling in output determination

  @TC-279
  Scenario Outline: Ensure the system handles the absence of Attribute 7 in the payer master data during output determination
    Given the user logs in to the SAP S/4 HANA system with valid credentials
    When the user navigates to the billing document creation screen
    And the user enters the details for a new billing document with billing document type "<BillingDocumentType>" and output determination rule "<OutputDeterminationRule>"
    And the user saves the billing document
    And the user accesses the output determination settings for the created billing document
    And the user attempts to configure an output determination rule using Attribute 7
    Then the system should "<SystemBehavior>" for the missing Attribute 7
    When the user triggers the output determination process
    Then the output determination process should "<OutputProcessResult>"
    And the user reviews the error logs for details
    Then the error logs should provide "<ErrorLogDetails>"
    And the user logs out of the system
    Then the user should be logged out successfully

    Examples:
      | BillingDocumentType | OutputDeterminationRule | SystemBehavior                     | OutputProcessResult                | ErrorLogDetails                           |
      | ZF2                 | Based on Attribute 7   | throw an error or apply default    | complete with default behavior     | detailed information about missing Attribute 7 |
      | ZF2                 | Based on Attribute 7   | apply default behavior             | complete with an error message     | detailed information about missing Attribute 7 |