Feature: Verify automatic creation of Billing document (Doc Type ZFR) upon billing plan due

  @TC-112
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged in and navigates to the main dashboard

  @TC-112
  Scenario: User navigates to the Billing Plan module
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the Billing Plan module
    Then the Billing Plan module is displayed with relevant options

  @TC-112
  Scenario Outline: User sets the billing plan status to 'Due'
    Given the user is in the Billing Plan module
    When the user sets the billing plan ID "<BillingPlanID>" as 'Due'
    Then the billing plan status is updated to 'Due'

    Examples:
      | BillingPlanID |
      | BP001         |

  @TC-112
  Scenario: System automatically triggers the creation of a Billing document
    Given the billing plan status is updated to 'Due'
    When the system processes the billing plan
    Then a Billing document is created automatically without errors

  @TC-112
  Scenario: Verify the SAP sales document type for the created Billing document
    Given a Billing document is created automatically
    When the user checks the SAP sales document type
    Then the document type is correctly set to ZFR

  @TC-112
  Scenario: Confirm readiness of the Billing document for revenue recognition
    Given a Billing document is created
    When the user verifies the Billing document status
    Then the Billing document status indicates readiness for revenue recognition

  @TC-112
  Scenario: User navigates to the email communication module
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the email communication module
    Then the email communication module is displayed

  @TC-112
  Scenario Outline: System sends an email with the billing form attachment
    Given a Billing document is created
    When the system sends an email with the billing form attachment to "<CustomerEmail>"
    Then the email is successfully sent with the correct attachment

    Examples:
      | CustomerEmail        |
      | customer@example.com |

  @TC-112
  Scenario: Verify the email logs for confirmation of successful dispatch
    Given an email with the billing form attachment is sent
    When the user checks the email logs
    Then the email logs confirm the email was successfully sent

  @TC-112
  Scenario: Validate the email attachment received by the customer
    Given the customer has received the email
    When the user opens the email and validates the attachment
    Then the attachment contains the correct billing form matching the Billing document

  @TC-112
  Scenario: Verify the linkage between the Billing document and the email
    Given a Billing document is created and an email is sent
    When the user verifies the linkage between the Billing document and the email in the system
    Then the system shows correct linkage between the email and Billing document

  @TC-112
  Scenario: Validate the overall workflow for automatic Billing document creation and email dispatch
    Given the billing plan is marked as 'Due'
    When the system processes the workflow for Billing document creation and email dispatch
    Then the workflow functions correctly without errors or delays