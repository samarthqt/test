Feature: Validate ZPB1 output generation for batch size exceeding 1000 documents

  @TC-542
  Scenario: User logs into the SAP S/4HANA Cloud system with valid credentials
    Given the user has valid credentials with appropriate access rights
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-542
  Scenario: User navigates to the periodic billing section
    Given a batch of slightly more than 1000 ZFR documents exists in the system
    And email routing and SMTP configurations are set up and tested
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-542
  Scenario: User selects a batch of slightly more than 1000 ZFR documents for processing
    Given a batch of slightly more than 1000 ZFR documents is available in the system
    And SMTP server details are configured for email routing
    When the user selects the batch for processing
    Then the batch of ZFR documents is successfully selected

  @TC-542
  Scenario: User triggers the periodic billing workflow with ZPB1 output type
    Given the user has selected the batch of slightly more than 1000 ZFR documents
    When the user triggers the periodic billing workflow ensuring ZPB1 output type is selected
    Then the workflow is triggered and ZPB1 output type is selected

  @TC-542
  Scenario: Monitor system performance during ZPB1 output generation
    Given the periodic billing workflow has been triggered
    When the user monitors the system performance during ZPB1 output generation
    Then the system performance remains within acceptable limits

  @TC-542
  Scenario: Verify ZPB1 outputs are generated for all ZFR documents in the batch
    Given the ZPB1 output generation process is ongoing
    When the user verifies the ZPB1 outputs for all ZFR documents in the batch
    Then ZPB1 outputs are successfully generated without errors

  @TC-542
  Scenario: Validate ZPB1 outputs are routed to correct email recipients
    Given the ZPB1 outputs are generated
    When the user validates the routing of ZPB1 outputs
    Then all ZPB1 outputs are routed to the correct email recipients

  @TC-542
  Scenario: Check system logs for warnings or errors during batch processing
    Given the batch processing is completed
    When the user checks the system logs for warnings or errors
    Then no warnings or errors are found in the system logs

  @TC-542
  Scenario: Verify batch processing time is within acceptable limits
    Given the batch processing is completed
    When the user verifies the time taken for batch processing
    Then the batch processing time is within acceptable limits

  @TC-542
  Scenario: Validate email contents for correct ZPB1 outputs as attachments
    Given the ZPB1 outputs are routed via email
    When the user validates the email contents
    Then emails contain the correct ZPB1 outputs as attachments

  @TC-542
  Scenario: Ensure batch processing does not impact other system operations
    Given the batch processing is completed
    When the user verifies the impact on other system operations
    Then other system operations are not impacted during batch processing

  @TC-542
  Scenario: Check audit logs to ensure all actions are recorded
    Given the batch processing is completed
    When the user checks the system's audit logs
    Then audit logs contain records of all actions performed during the batch processing