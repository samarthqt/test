Feature: Validate error handling when email settings for customer communication are misconfigured

  @TC-115
  Scenario Outline: Ensure the system displays appropriate error messages and prevents email dispatch when email settings are misconfigured
    Given the user is logged into the SAP S/4HANA Cloud system
    And the user navigates to the Billing Plan module
    And the user sets the billing plan ID "<billingPlanID>" as "<billingStatus>"
    When the system attempts to trigger the creation of a Billing document
    Then the billing document creation is initiated without errors
    And the user navigates to the email communication module
    And the user searches for the email record linked to "<billingPlanID>"
    Then the email record is displayed with status "<emailStatus>"
    And the error message displayed for the email record indicates "<errorMessage>"
    When the user reviews the system logs for additional details
    Then the system logs provide detailed information on the misconfiguration
    When the user attempts to resend the email manually
    Then the system prevents manual resend due to misconfiguration
    When the user corrects the email settings and attempts to resend the email
    Then the email is successfully resent after correcting the settings
    And the linkage between the corrected email and Billing document is validated as "<linkageStatus>"
    And the overall workflow for error handling during email dispatch is verified to function correctly

    Examples:
      | billingPlanID | billingStatus | emailStatus | errorMessage                     | linkageStatus |
      | BP002         | Due           | Error       | Misconfigured email settings    | Accurate      |