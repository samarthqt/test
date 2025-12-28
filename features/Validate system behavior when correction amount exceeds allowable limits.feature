Feature: Validate system behavior when correction amount exceeds allowable limits

  @TC-400
  Scenario Outline: User attempts to create an Invoice Correction Request with various correction amounts
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Invoice Correction Request creation screen
    And the user selects the Invoice Correction Request type as "<Correction Request Type>"
    And the user enters the original billing document number "<Billing Document>" and customer details "<Customer>"
    And the user specifies the correction amount as "<Correction Amount>"
    And the user attempts to save the Invoice Correction Request
    Then the system displays "<Error Message>"
    And "<Form Generation Status>"
    And "<Log Details>"

    Examples:
      | Correction Request Type | Billing Document | Customer  | Correction Amount | Error Message                                    | Form Generation Status                       | Log Details                                    |
      | ZRK                    | 123456789        | ABC Corp  | -1000000.00       | Correction amount exceeds allowable limits      | No form is generated, and the request is not saved | Error logs contain details about the exceeded correction amount |
      | ZRK                    | 123456789        | ABC Corp  | -5000.00          | No error message                                | Correct form (ZGC1/ZGL1) is generated upon resubmission | Error logs no longer contain the exceeded correction amount error |

  @TC-400
  Scenario: User verifies the linkage of the form to the billing document
    Given the user has successfully submitted the Invoice Correction Request with an allowable correction amount
    When the user verifies the generated form
    Then the form is correctly linked to the billing document