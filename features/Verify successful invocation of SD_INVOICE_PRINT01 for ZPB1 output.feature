Feature: Verify successful invocation of SD_INVOICE_PRINT01 for ZPB1 output

  @TC-134
  Scenario: User logs into the SAP S/4HANA system with authorized credentials
    Given the user has authorized credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in and navigates to the SAP home screen

  @TC-134
  Scenario: User navigates to the transaction for creating periodic billing documents
    Given the user is on the SAP home screen
    When the user navigates to the transaction for creating periodic billing documents
    Then the periodic billing document creation screen is displayed

  @TC-134
  Scenario Outline: User enters billing document details and creates a periodic billing document
    Given the user is on the periodic billing document creation screen
    When the user enters the billing document type as "<billingDocumentType>" and provides necessary details such as customer "<customer>", items, and amounts
    And the user saves the periodic billing document
    Then the periodic billing document is successfully created and a document number is generated

    Examples:
      | billingDocumentType | customer           |
      | ZPB                | customer@example.com |

  @TC-134
  Scenario: User navigates to the transaction for triggering output processing
    Given the user has created a periodic billing document
    When the user navigates to the transaction for triggering output processing
    Then the output processing screen is displayed

  @TC-134
  Scenario: User selects the created billing document and triggers the output process
    Given the user is on the output processing screen
    When the user selects the created billing document
    And the user triggers the output process
    Then the output process is triggered successfully

  @TC-134
  Scenario: Verify SD_INVOICE_PRINT01 program invocation
    Given the output process is triggered
    When the user verifies the program execution
    Then the SD_INVOICE_PRINT01 program is successfully invoked

  @TC-134
  Scenario: Verify the generated output matches the ZPB1 form template
    Given the SD_INVOICE_PRINT01 program is successfully invoked
    When the user checks the generated output
    Then the output matches the ZPB1 form template in terms of layout, fields, and data accuracy

  @TC-134
  Scenario: Attach the printed output to an email using the configured workflow
    Given the output matches the ZPB1 form template
    When the user attaches the printed output to an email using the configured workflow
    Then the printed output is successfully attached to the email

  @TC-134
  Scenario: Verify email workflow to ensure the form is sent to the customer
    Given the printed output is attached to the email
    When the user verifies the email workflow
    Then the email is sent successfully to the customer with the attached form

  @TC-134
  Scenario: Check email logs in the SAP system for errors or warnings
    Given the email is sent successfully
    When the user checks the email logs in the SAP system
    Then the email logs indicate successful dispatch without errors

  @TC-134
  Scenario: Verify customer’s email inbox for receipt of the email and attachment
    Given the email logs indicate successful dispatch
    When the user verifies the customer’s email inbox
    Then the customer receives the email with the attached periodic billing form