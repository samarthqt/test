Feature: Validate system behavior with missing ZPB1 output type configuration during large batch processing

  @TC-145
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user successfully logs into the system

  @TC-145
  Scenario: User navigates to the periodic billing section
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-145
  Scenario Outline: User selects a batch of periodic billing documents for processing
    Given the user is in the periodic billing section
    When the user selects a batch of <batch_size> ZFR documents for processing
    Then the batch of ZFR documents is successfully selected

    Examples:
      | batch_size |
      | 1000+      |

  @TC-145
  Scenario: User triggers the periodic billing workflow for the selected batch
    Given the user has selected a batch of periodic billing documents
    When the user triggers the periodic billing workflow for the selected batch
    Then the workflow is triggered successfully

  @TC-145
  Scenario: User attempts to generate ZPB1 output for the batch
    Given the periodic billing workflow is triggered
    When the user attempts to generate ZPB1 output for the batch
    Then the system attempts to generate output

  @TC-145
  Scenario: System displays an error message for missing ZPB1 output type
    Given the user attempts to generate ZPB1 output for the batch
    When the system identifies the absence of ZPB1 output type
    Then the system displays a clear error message indicating the absence of ZPB1 output type

  @TC-145
  Scenario: Workflow halts at the output generation step
    Given the system displays an error message for missing ZPB1 output type
    When the user observes the periodic billing workflow
    Then the workflow halts at the output generation step for the batch

  @TC-145
  Scenario: User checks system logs for detailed error messages
    Given the workflow halts at the output generation step
    When the user checks the system logs
    Then the logs contain detailed error messages about the missing ZPB1 output configuration

  @TC-145
  Scenario: User captures screenshots of the error messages
    Given the system displays an error message for missing ZPB1 output type
    When the user captures screenshots of the error messages
    Then the screenshots are captured successfully

  @TC-145
  Scenario: User attempts to configure ZPB1 output type and re-trigger the workflow
    Given the user identifies the missing ZPB1 output type
    When the user configures the ZPB1 output type manually
    And the user re-triggers the workflow for the batch
    Then the system allows configuration and workflow re-triggering for the batch

  @TC-145
  Scenario: User validates successful workflow completion with ZPB1 output type
    Given the user has re-triggered the workflow with the correct ZPB1 configuration
    When the system processes the batch
    Then the workflow completes successfully with ZPB1 output generation for the batch

  @TC-145
  Scenario: User documents the resolution steps
    Given the issue is resolved with the correct ZPB1 configuration
    When the user documents the resolution steps
    Then the resolution steps are documented successfully