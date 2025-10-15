Feature: Validate error handling for invalid Attribute 7 value during output determination

  @TC-260
  Scenario Outline: Verify system behavior for invalid Attribute 7 value in Payer Business Partner master data
    Given the user is logged into the SAP system with access to the Payer Business Partner master data
    And the Payer Business Partner master data screen is available
    When the user sets Attribute 7 to "<Attribute7Value>" and saves the changes
    And the user creates a new billing document for the Payer Business Partner with billing document type "<BillingDocumentType>"
    And the user triggers the output determination process for the billing document
    Then the output log should indicate "<OutputLogResult>"
    And the document flow should reflect "<DocumentFlowResult>"
    And the system logs should indicate "<SystemLogResult>"
    
    Examples:
      | Attribute7Value | BillingDocumentType | OutputLogResult                              | DocumentFlowResult                  | SystemLogResult                       |
      | INVALID         | ZPDT                | error or fallback to default behavior       | error or fallback behavior          | presence of an invalid Attribute 7 value |
      | INVALID         | ZPDX                | error or fallback to default behavior       | error or fallback behavior          | presence of an invalid Attribute 7 value |

  @TC-260
  Scenario: Verify system behavior with a different Payer Business Partner having an invalid Attribute 7 value
    Given the user is logged into the SAP system with access to the Payer Business Partner master data
    And the Payer Business Partner master data screen is available
    When the user sets Attribute 7 to "INVALID" for a different Payer Business Partner and saves the changes
    And the user creates a new billing document for this Payer Business Partner with billing document type "ZPDT"
    And the user triggers the output determination process for the billing document
    Then the system logs should indicate the presence of an invalid Attribute 7 value
    And the output log should indicate error or fallback to default behavior
    And the document flow should reflect error or fallback behavior

  @TC-260
  Scenario: Document the results and submit the test report
    Given the user has completed testing for invalid Attribute 7 value handling
    When the user documents the results and compares them with the expected outcomes
    Then the results should align with the expected outcomes, confirming successful handling of invalid Attribute 7 values
    And the user submits the test report for review
    Then the test report should be submitted successfully with all results documented