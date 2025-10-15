Feature: Validate system behavior when no substitute is configured for unavailable Reviewer

  @TC-553
  Scenario: Administrator marks a Reviewer as unavailable
    Given the administrator is logged into the SAP system
    When the administrator marks a designated Reviewer as unavailable for a specific period
    Then the Reviewer is successfully marked as unavailable in the system

  @TC-553
  Scenario: User creates a Billing Correction Request with no substitute configured
    Given the user is logged into the system and accesses the Billing Correction Request creation screen
    When the user creates and submits a ZRK document for workflow routing
    Then the system flags an error or warning indicating the absence of a configured substitute
    And the workflow does not progress, leaving the request in a pending state

  @TC-553
  Scenario Outline: Verify system response to unavailable Reviewer
    Given the user has submitted a ZRK document for workflow routing
    When the system identifies an unavailable Reviewer
    Then the system displays an error or warning message clearly indicating the absence of a substitute
    And the workflow remains in a pending state

  @TC-553
  Scenario: Administrator reassigns the Reviewer or configures a substitute
    Given the administrator is logged into the SAP system
    When the administrator reassigns the Reviewer or configures a substitute
    Then the workflow progresses for the ZRK document

  @TC-553
  Scenario: Verify system logs for the ZRK document
    Given the ZRK document encountered an error due to an unavailable Reviewer
    When the system logs are reviewed
    Then the logs show the error or warning message and the subsequent resolution

  @TC-553
  Scenario: Verify impact on other workflow requests
    Given there are multiple workflow requests in the system
    When one Reviewer is unavailable
    Then other workflow requests are not impacted by the unavailable Reviewer

  @TC-553
  Scenario: Document findings and report the issue
    Given the system flagged an error due to an unavailable Reviewer
    When findings are documented
    Then the issue is reported to the workflow configuration team for corrective measures