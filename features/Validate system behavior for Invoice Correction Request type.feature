Feature: Validate system behavior for Invoice Correction Request type

  @TC-399
  Scenario Outline: Verify Invoice Correction Request creation and form generation based on request type validity
    Given the user logs into the SAP S/4HANA system with valid credentials
    And the user navigates to the Invoice Correction Request creation screen
    When the user selects the Invoice Correction Request type "<RequestType>"
    And the user enters original billing document number "<BillingDocument>" and customer details "<Customer>"
    And the user specifies the correction amount as "<CorrectionAmount>"
    And the user attempts to save the Invoice Correction Request
    Then the system displays "<ErrorMessage>" if the request type is invalid
    And no form "<GeneratedForm>" is generated if the request type is invalid
    And the error logs contain "<ErrorLogDetails>" if the request type is invalid
    When the user resubmits the request with a valid type "<ValidRequestType>"
    Then the system allows the request to be submitted
    And the correct form "<ValidForm>" is generated upon resubmission
    And the form is correctly linked to the billing document "<BillingDocument>"
    And the error logs no longer contain "<ErrorLogDetails>" after resubmission

    Examples:
      | RequestType   | BillingDocument | Customer  | CorrectionAmount | ErrorMessage                         | GeneratedForm | ErrorLogDetails              | ValidRequestType | ValidForm | 
      | INVALID_TYPE  | 123456789       | ABC Corp  | -500.00          | Request type is invalid              | None          | Invalid request type details | VALID_TYPE       | ZGC1/ZGL1 | 
      | VALID_TYPE    | 123456789       | ABC Corp  | -500.00          | None                                 | ZGC1/ZGL1     | None                        | VALID_TYPE       | ZGC1/ZGL1 |