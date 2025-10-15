Feature: Validate Email Dispatch for Billing Document Creation

  Ensure the system sends an email with the billing form attachment upon creation of the billing document. Email configuration settings are correctly set up in the system.

  @TC-120
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-120
  Scenario: User navigates to the Billing Plan module and verifies the last billing plan is marked as 'Due'
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the Billing Plan module
    Then the last billing plan is confirmed as 'Due'

  @TC-120
  Scenario: User triggers the billing document creation for the last billing plan
    Given the last billing plan is marked as 'Due'
    When the user triggers the billing document creation for the last billing plan
    Then the billing document is created successfully

  @TC-120
  Scenario: User checks the email dispatch logs for the created billing document
    Given the billing document is created successfully
    When the user checks the email dispatch logs for the created billing document
    Then the logs display successful email dispatch for the billing document

  @TC-120
  Scenario: User verifies that the customer receives an email with the correct billing form attachment
    Given the email dispatch logs display successful email dispatch
    When the user verifies the customer receives an email
    Then the customer receives an email with the correct billing form attachment

  @TC-120
  Scenario Outline: User validates the details in the billing form attachment
    Given the customer receives an email with the billing form attachment
    When the user opens the email and validates the billing form attachment
    Then the billing form attachment contains accurate details matching the billing document

  @TC-120
  Scenario Outline: User confirms the email subject line and body text
    Given the email is dispatched to the customer
    When the user reviews the email subject line and body text
    Then the email subject line and body text are accurate and match the configuration

  @TC-120
  Scenario Outline: User verifies the email is sent to the correct customer email address
    Given the email is dispatched
    When the user validates the recipient email address
    Then the email is sent to the correct customer email address

  @TC-120
  Scenario Outline: User validates the timestamp of the email
    Given the email is sent to the customer
    When the user checks the email timestamp
    Then the email timestamp aligns with the billing document creation time

  @TC-120
  Scenario: User checks the email queue for pending or failed emails
    Given the email dispatch process is completed
    When the user checks the email queue for the billing document
    Then no pending or failed emails are found in the email queue

  @TC-120
  Scenario: User ensures the email dispatch process does not generate system errors
    Given the email dispatch process is initiated
    When the user monitors the email dispatch process
    Then the email dispatch process completes without any system errors

  @TC-120
  Scenario: User verifies the email dispatch is logged for audit purposes
    Given the email dispatch process is completed
    When the user checks the system logs
    Then the email dispatch is logged in the system with all relevant details