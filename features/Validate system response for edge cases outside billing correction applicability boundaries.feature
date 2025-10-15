Feature: Validate system response for edge cases outside billing correction applicability boundaries

  @TC-107
  Scenario Outline: Validate error messages for correction requests outside defined boundaries
    Given user logs into the SAP S/4HANA Cloud system with valid credentials
    When user navigates to the billing correction module
    And user selects the option to create a new correction request
    And user enters the document type "<DocumentType>"
    Then the system displays an error message "<DocumentTypeError>"
    When user provides the output type "<OutputType>"
    Then the system displays an error message "<OutputTypeError>"
    When user attaches the billing document "<BillingDocument>"
    Then the system displays an error message "<BillingDocumentError>"
    When user attempts to submit the correction request
    Then the system prevents submission and displays a consolidated error message "<ConsolidatedError>"
    And the error logs capture all issues related to the submission
    And the system sends a notification indicating the correction request was not processed
    And no output is generated for the correction request
    And the correction request is not saved in the system

    Examples:
      | DocumentType | DocumentTypeError                        | OutputType | OutputTypeError                  | BillingDocument | BillingDocumentError                  | ConsolidatedError                              |
      | BCR999       | Document type is not applicable         | OT999      | Output type is not configured    | BD999           | Billing document is not applicable    | Errors: Document type, Output type, Billing document |

  @TC-107
  Scenario: Validate successful login and logout
    Given user logs into the SAP S/4HANA Cloud system with valid credentials
    Then user is successfully logged into the system
    When user logs out of the system
    Then user is successfully logged out