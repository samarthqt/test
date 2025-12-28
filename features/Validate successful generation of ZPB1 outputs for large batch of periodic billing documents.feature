Feature: Validate successful generation of ZPB1 outputs for large batch of periodic billing documents

  @TC-536
  Scenario: User logs into the SAP S/4HANA Cloud system using valid credentials
    Given the user has valid credentials with appropriate access rights
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-536
  Scenario: User navigates to the periodic billing section
    Given a large batch of periodic billing documents exists in the system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-536
  Scenario: User selects a batch of ZFR documents for processing
    Given a batch of 1000+ ZFR documents is available in the system
    And SMTP server details are configured for email routing
    When the user selects the batch of ZFR documents for processing
    Then the batch of ZFR documents is successfully selected

  @TC-536
  Scenario: User triggers the periodic billing workflow with ZPB1 output type
    Given the ZPB1 output type is defined and configured in the system
    When the user triggers the periodic billing workflow and selects the ZPB1 output type
    Then the workflow is triggered and ZPB1 output type is selected

  @TC-536
  Scenario Outline: Validate ZPB1 output generation and routing
    Given the user has triggered the periodic billing workflow
    When the user monitors the system performance during ZPB1 output generation
    Then the system performance remains within acceptable limits
    And ZPB1 outputs are successfully generated for all selected ZFR documents
    And all ZPB1 outputs are routed to the correct email recipients
    And the email routing process is completed without delays
    And emails contain the correct ZPB1 outputs as attachments
    And no system errors are encountered during the batch processing
    And the system logs do not show any warnings or performance issues
    And the batch processing time is within the acceptable threshold

    Examples:
      | Batch Size | Expected Outcome |
      | 1000+      | Successful       |
      | 0          | No Processing    |

  @TC-536
  Scenario: User checks the system logs for warnings or performance issues
    Given the ZPB1 outputs are generated
    When the user checks the system logs
    Then the system logs do not show any warnings or performance issues

  @TC-536
  Scenario: User validates batch processing time
    Given the batch processing is completed
    When the user verifies the batch processing time
    Then the batch processing time is within the acceptable threshold