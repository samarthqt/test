Feature: Validate successful ZFR processing generates ZPB1 output and sends an email with the attached periodic billing form

  @TC-125
  Scenario: User logs into the SAP system successfully
    Given the user has valid credentials
    When the user logs into the SAP system
    Then the user is successfully logged into the SAP system

  @TC-125
  Scenario: User navigates to the periodic billing document processing transaction
    Given the user is logged into the SAP system
    When the user navigates to the periodic billing document processing transaction
    Then the periodic billing document processing transaction screen is displayed

  @TC-125
  Scenario Outline: User enters ZFR document ID and selects it for processing
    Given the user is on the periodic billing document processing screen
    When the user enters the ZFR document ID "<ZFR Document ID>" in the appropriate input field
    Then the ZFR document "<ZFR Document ID>" is selected for processing

    Examples:
      | ZFR Document ID  |
      | ZFR12345         |

  @TC-125
  Scenario: User triggers output processing for the selected ZFR document
    Given the user has selected a ZFR document for processing
    When the user triggers the output processing for the selected ZFR document
    Then the system initiates the output processing for the ZFR document

  @TC-125
  Scenario: System generates ZPB1 output for the ZFR document
    Given the system is processing the ZFR document
    When the output type is configured as ZPB1
    Then the ZPB1 output is successfully generated and attached to the ZFR document

  @TC-125
  Scenario: User navigates to the email dispatch logs
    Given the ZPB1 output has been generated for the ZFR document
    When the user navigates to the email dispatch logs in the system
    Then the email dispatch logs are displayed

  @TC-125
  Scenario Outline: User searches for the email sent with the attached ZPB1 form
    Given the email dispatch logs are displayed
    When the user searches for the email sent to "<Email Recipient>" with the attached ZPB1 form
    Then the email with the attached ZPB1 periodic billing form is found in the dispatch logs

    Examples:
      | Email Recipient        |
      | customer@example.com   |

  @TC-125
  Scenario Outline: User verifies email details and attachment
    Given the email with the attached ZPB1 form is found
    When the user opens the email
    Then the email contains the correct subject line "<Subject Line>"
    And the email contains the correct recipient address "<Recipient Address>"
    And the email contains the ZPB1 attachment

    Examples:
      | Subject Line                    | Recipient Address      |
      | Periodic Billing Notification  | customer@example.com   |

  @TC-125
  Scenario: User downloads the ZPB1 attachment from the email
    Given the email contains the ZPB1 attachment
    When the user downloads the ZPB1 attachment
    Then the ZPB1 attachment is successfully downloaded

  @TC-125
  Scenario: User verifies the contents of the downloaded ZPB1 form
    Given the ZPB1 attachment is downloaded
    When the user opens the downloaded ZPB1 form
    Then the ZPB1 form contains all the necessary data required for payment

  @TC-125
  Scenario: User checks if the periodic billing form matches the configured template
    Given the ZPB1 form is opened
    When the user verifies the periodic billing form
    Then the periodic billing form matches the configured ZPB1 template

  @TC-125
  Scenario: User verifies the email dispatch time
    Given the email with the ZPB1 attachment is sent
    When the user checks the email dispatch time
    Then the email dispatch time is within the configured time frame