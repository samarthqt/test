Feature: Validate missing mandatory fields in Billing document and email settings

  @TC-118
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged in and navigates to the main dashboard

  @TC-118
  Scenario: User navigates to the Billing document module
    Given the user is on the main dashboard
    When the user navigates to the Billing document module
    Then the Billing document module is displayed

  @TC-118
  Scenario Outline: User searches for a Billing document and verifies details
    Given the user is in the Billing document module
    When the user searches for the Billing document ID "<BillingDocumentID>"
    Then the Billing document "<BillingDocumentID>" is displayed with details
    And the document type is correctly set to "<DocumentType>"

    Examples:
      | BillingDocumentID | DocumentType |
      | BD004             | ZFR          |

  @TC-118
  Scenario: User checks for missing mandatory fields in the Billing document
    Given the user has opened the Billing document BD004
    When the user checks for missing mandatory fields in the document
    Then the system displays warnings for missing mandatory fields

  @TC-118
  Scenario: User navigates to the email communication module
    Given the user is on the main dashboard
    When the user navigates to the email communication module
    Then the email communication module is displayed

  @TC-118
  Scenario Outline: User searches for an email record linked to a Billing document
    Given the user is in the email communication module
    When the user searches for the email record linked to the Billing document ID "<BillingDocumentID>"
    Then the email record is displayed with status "<EmailStatus>"

    Examples:
      | BillingDocumentID | EmailStatus |
      | BD004             | Error       |

  @TC-118
  Scenario: User checks the error message for the email record
    Given the user has opened the email record linked to BD004
    When the user checks the error message displayed for the email record
    Then the error message indicates missing mandatory email settings

  @TC-118
  Scenario: User reviews the system logs for additional error details
    Given the user has accessed the system logs
    When the user reviews the logs for errors related to BD004
    Then the system logs provide detailed information on missing fields and configurations

  @TC-118
  Scenario: User attempts to resend the email manually
    Given the user is in the email record linked to BD004
    When the user attempts to resend the email manually
    Then the system prevents manual resend due to missing configurations

  @TC-118
  Scenario Outline: User corrects missing fields and resends the email
    Given the user has corrected the missing fields and configurations
    When the user attempts to resend the email for the Billing document ID "<BillingDocumentID>"
    Then the email is successfully resent

    Examples:
      | BillingDocumentID |
      | BD004             |

  @TC-118
  Scenario: User validates the linkage between the Billing document and the corrected email
    Given the user has successfully resent the email for BD004
    When the user validates the linkage between the Billing document and the corrected email
    Then the linkage is accurate and complete