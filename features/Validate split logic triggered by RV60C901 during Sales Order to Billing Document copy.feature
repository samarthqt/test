Feature: Validate split logic triggered by RV60C901 during Sales Order to Billing Document copy

  @TC-548
  Scenario Outline: Validate the copy process and split logic for Sales Order to Billing Document
    Given the user is logged into the SAP system
    And the user navigates to the Sales Order to Billing Document copy process screen
    When the user selects a test Sales Order with item category "<ItemCategory>" and KATR1/KATR2 values "<KATR1>" and "<KATR2>"
    And the user initiates the copy process to create a Billing Document
    Then the system begins the copy process
    And the user monitors the copy process for errors or warnings
    Then the copy process completes "<ProcessOutcome>"
    And the user verifies that the split logic defined in RV60C901 is "<SplitLogicOutcome>"
    And the resulting Billing Document data in VBRK/VBRP tables "<DataValidation>"
    And all functional requirements for the split logic are "<FunctionalRequirements>"
    And the user repeats the copy process with different KATR1/KATR2 values to ensure consistent behavior
    Then the split logic behaves "<ConsistencyOutcome>"
  
    Examples:
      | ItemCategory | KATR1 | KATR2 | ProcessOutcome      | SplitLogicOutcome     | DataValidation          | FunctionalRequirements        | ConsistencyOutcome        |
      | ZOR          | A1    | B1    | without errors      | triggered as expected | matches specification    | satisfied                     | consistently as expected  |
      | ZORF         | C1    | D1    | with warnings       | triggered as expected | matches specification    | satisfied                     | consistently as expected  |
      | ZOR          | E1    | F1    | without errors      | triggered as expected | matches specification    | satisfied                     | consistently as expected  |
      | ZORF         | G1    | H1    | without errors      | triggered as expected | matches specification    | satisfied                     | consistently as expected  |
  
  @TC-548
  Scenario: Perform peer review of the copy process
    Given the user has completed the copy process
    When the user performs a peer review of the copy process
    Then the peer review confirms that the split logic is functioning as expected

  @TC-548
  Scenario: Document the copy process and split logic validation
    Given the user has validated the copy process and split logic
    When the user documents the copy process and split logic validation for audit purposes
    Then the documentation is complete and accurate

  @TC-548
  Scenario: Sign off on validation and update project tracker
    Given the user has completed the documentation and peer review
    When the user signs off on the validation
    And the user updates the status in the project tracker
    Then the validation is approved and the status is updated

  @TC-548
  Scenario: Prepare summary report for stakeholders
    Given the user has completed the validation and sign-off
    When the user analyzes the results of the copy process
    And the user prepares a summary report for stakeholders
    Then the summary report is prepared and shared with stakeholders