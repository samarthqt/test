Feature: Validate email attachment dispatch with correct billing document for document type ZFR

  @TC-113
  Scenario Outline: Validate the dispatch of email with correct billing document attachment
    Given the user logs into the SAP S/4HANA Cloud system
    When the user navigates to the Billing document module
    And the user searches for the Billing document ID "<BillingDocumentID>"
    Then the Billing document details are displayed
    And the document type is verified as "<DocumentType>"
    When the user navigates to the email communication module
    And the user searches for the email sent to "<CustomerEmail>"
    Then the email record is displayed with status "<EmailStatus>"
    When the user opens the email record
    Then the attachment is present and accessible
    When the user downloads the attachment
    Then the attachment format is verified as "<AttachmentFormat>"
    And the attachment opens without errors
    When the user compares the attachment content with the Billing document "<BillingDocumentID>"
    Then the attachment content matches the Billing document details accurately
    When the user checks the email logs
    Then the logs confirm the email was successfully sent with the attachment
    When the user validates the linkage between the Billing document and the email in the system
    Then the system shows correct linkage between the email and the Billing document
    When the user verifies the overall workflow for email attachment dispatch
    Then the workflow functions correctly without errors or delays

    Examples:
      | BillingDocumentID | DocumentType | CustomerEmail         | EmailStatus | AttachmentFormat |
      | BD001             | ZFR          | customer@example.com  | Sent        | PDF              |