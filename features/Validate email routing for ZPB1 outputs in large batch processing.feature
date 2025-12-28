Feature: Validate email routing for ZPB1 outputs in large batch processing

  @TC-537
  Scenario: User logs into the SAP S/4HANA Cloud system using valid credentials
    Given the user has valid credentials with appropriate access rights
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-537
  Scenario: User navigates to the periodic billing section
    Given a large batch of periodic billing documents (e.g., 1000+ ZFR documents) exists in the system
    And email routing and SMTP configurations are set up and tested
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-537
  Scenario Outline: User selects a batch of ZFR documents for processing
    Given the batch of <batch_size> ZFR documents is available in the system
    And SMTP server details are configured for email routing
    When the user selects the batch of ZFR documents for processing
    Then the batch of ZFR documents is successfully selected

    Examples:
      | batch_size |
      | 1000       |
      | 1500       |
      | 2000       |

  @TC-537
  Scenario: User triggers the periodic billing workflow with ZPB1 output type selected
    Given the user has selected a batch of ZFR documents for processing
    When the user triggers the periodic billing workflow ensuring ZPB1 output type is selected
    Then the workflow is triggered and ZPB1 output type is selected

  @TC-537
  Scenario: User monitors the email routing process during ZPB1 output generation
    Given the periodic billing workflow with ZPB1 output type is triggered
    When the user monitors the email routing process during ZPB1 output generation
    Then the email routing process starts without delays

  @TC-537
  Scenario Outline: User verifies that ZPB1 outputs are routed to the correct email addresses
    Given the email routing process has started
    When the user verifies the routing of ZPB1 outputs
    Then <validation_result> is observed

    Examples:
      | validation_result                |
      | All ZPB1 outputs are routed correctly |

  @TC-537
  Scenario: User validates the email contents to ensure ZPB1 outputs are attached correctly
    Given the ZPB1 outputs are routed to the correct email addresses
    When the user validates the email contents
    Then the emails contain the correct ZPB1 outputs as attachments

  @TC-537
  Scenario: User checks the system logs for email routing errors
    Given the ZPB1 outputs are routed to the correct email addresses
    When the user checks the system logs for email routing errors
    Then no email routing errors are found in the system logs

  @TC-537
  Scenario Outline: User verifies the time taken for email routing
    Given the email routing process is complete
    When the user verifies the time taken for email routing
    Then the time taken is <time_result>

    Examples:
      | time_result                  |
      | within acceptable limits     |

  @TC-537
  Scenario: User validates that all recipients receive the emails with ZPB1 outputs
    Given the ZPB1 outputs are routed to the correct email addresses
    When the user validates the receipt of emails by all recipients
    Then all recipients receive the emails with ZPB1 outputs successfully

  @TC-537
  Scenario: User checks the SMTP server logs for any issues during email dispatch
    Given the email routing process is complete
    When the user checks the SMTP server logs for issues
    Then SMTP server logs do not show any issues during email dispatch

  @TC-537
  Scenario: User verifies the integrity of the ZPB1 outputs attached to the emails
    Given the emails with ZPB1 outputs are dispatched
    When the user verifies the integrity of the ZPB1 outputs attached to the emails
    Then the ZPB1 outputs attached to the emails are intact and uncorrupted