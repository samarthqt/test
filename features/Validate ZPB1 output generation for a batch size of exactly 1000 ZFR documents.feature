Feature: Validate ZPB1 output generation for a batch size of exactly 1000 ZFR documents

  @TC-541
  Scenario: User logs into the SAP S/4HANA Cloud system using valid credentials
    Given the user has valid credentials with appropriate access rights
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-541
  Scenario: User navigates to the periodic billing section
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-541
  Scenario Outline: User selects a batch of exactly 1000 ZFR documents for processing
    Given a batch of exactly 1000 ZFR documents is available in the system
      And email routing and SMTP configurations are set up and tested
    When the user selects a batch of exactly 1000 ZFR documents for processing
    Then the batch of ZFR documents is successfully selected

  Examples:
    | BatchSize | SMTPConfigured |
    | 1000      | true           |

  @TC-541
  Scenario: User triggers the periodic billing workflow with ZPB1 output type
    Given the user has selected a batch of exactly 1000 ZFR documents
    When the user triggers the periodic billing workflow, ensuring ZPB1 output type is selected
    Then the workflow is triggered and ZPB1 output type is selected

  @TC-541
  Scenario: User monitors the system performance during ZPB1 output generation
    Given the periodic billing workflow is triggered
    When the user monitors the system performance during ZPB1 output generation
    Then the system performance remains within acceptable limits

  @TC-541
  Scenario: User verifies ZPB1 outputs are generated for all 1000 ZFR documents
    Given the periodic billing workflow is triggered
    When the user verifies ZPB1 outputs are generated for all 1000 ZFR documents
    Then ZPB1 outputs are successfully generated without errors

  @TC-541
  Scenario: User validates ZPB1 outputs are routed to the correct email recipients
    Given ZPB1 outputs are generated for all 1000 ZFR documents
    When the user validates that the ZPB1 outputs are routed to the correct email recipients
    Then all ZPB1 outputs are routed to the correct email recipients

  @TC-541
  Scenario: User checks the system logs for warnings or errors during batch processing
    Given ZPB1 outputs are generated for all 1000 ZFR documents
    When the user checks the system logs for any warnings or errors during the batch processing
    Then no warnings or errors are found in the system logs

  @TC-541
  Scenario: User verifies the time taken for batch processing
    Given ZPB1 outputs are generated for all 1000 ZFR documents
    When the user verifies the time taken for batch processing
    Then the batch processing time is within acceptable limits

  @TC-541
  Scenario: User validates email contents for ZPB1 outputs
    Given ZPB1 outputs are routed to the correct email recipients
    When the user validates the email contents
    Then the emails contain the correct ZPB1 outputs as attachments

  @TC-541
  Scenario: User ensures batch processing does not impact other system operations
    Given the periodic billing workflow is triggered
    When the user ensures that the batch processing does not impact other system operations
    Then other system operations are not impacted during batch processing

  @TC-541
  Scenario: User checks the system's audit logs
    Given the periodic billing workflow is triggered
    When the user checks the system's audit logs
    Then the audit logs contain records of all actions performed during the batch processing