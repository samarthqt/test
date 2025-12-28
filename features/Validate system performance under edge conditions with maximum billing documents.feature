Feature: Validate system performance under edge conditions with maximum billing documents

  @TC-181
  Scenario Outline: Ensure the system performs efficiently when processing maximum billing due documents in background mode
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the billing program "<BillingProgramName>" is available for use
    And a large set of billing due documents (e.g., maximum allowable records) is available for processing
    When the user navigates to the billing due program configuration screen
    And the user selects the option for background execution of the billing program
    And the user enters valid selection criteria "<SelectionCriteria>" for processing maximum allowable billing due documents
    And the user schedules the program as a background job with the entered criteria
    And the user executes the background job and monitors its status
    Then the background job execution starts successfully
    And the user accesses the job log to review progress and any messages
    And the job log displays progress and indicates successful processing of billing documents
    And all maximum allowable billing due documents are processed successfully
    And the system performance metrics indicate efficient processing without degradation
    And the system creates corresponding billing documents for all processed records
    And no errors occur during processing
    And the user documents the observed behavior and system performance for further analysis

    Examples:
      | BillingProgramName       | SelectionCriteria                     |
      | CustomBillingDueProgram  | Maximum allowable billing document IDs |