Feature: Verify system behavior when all substitutes are unavailable for Reviewer and Approver roles

  @TC-253
  Scenario: Administrator logs into the SAP system
    Given the user has administrative credentials
    When the user logs into the SAP system
    Then the user should successfully access the system

  @TC-253
  Scenario: User navigates to the workflow management module
    Given the user is logged into the SAP system
    When the user navigates to the workflow management module
    Then the workflow management module should display active workflows

  @TC-253
  Scenario: User searches for a specific Billing Correction Request
    Given the user is in the workflow management module
    When the user searches for Billing Correction Request ID "BCR007"
    Then the details of Billing Correction Request ID "BCR007" should be displayed

  @TC-253
  Scenario: User marks all substitutes for Reviewer role as unavailable
    Given all substitutes for the Reviewer role are available
    When the user marks all substitutes for the Reviewer role as unavailable
    Then the system should update the status of all Reviewer substitutes to unavailable

  @TC-253
  Scenario: User marks all substitutes for Approver role as unavailable
    Given all substitutes for the Approver role are available
    When the user marks all substitutes for the Approver role as unavailable
    Then the system should update the status of all Approver substitutes to unavailable

  @TC-253
  Scenario: System flags an error for unavailability of substitutes
    Given all substitutes for Reviewer and Approver roles are marked as unavailable
    When the user verifies the system's response
    Then the system should flag an error indicating no available substitutes for the roles

  @TC-253
  Scenario: Workflow halts due to unavailability of substitutes
    Given all substitutes for Reviewer and Approver roles are unavailable
    When the user checks the workflow progression
    Then the workflow should halt and not progress further

  @TC-253
  Scenario: Administrator receives an error notification
    Given all substitutes for Reviewer and Approver roles are unavailable
    When the user verifies notifications sent by the system
    Then the administrator should receive a notification about the unavailability of all substitutes

  @TC-253
  Scenario: Workflow logs contain error details
    Given all substitutes for Reviewer and Approver roles are unavailable
    When the user checks the workflow logs
    Then the logs should contain detailed information about the unavailability of all substitutes

  @TC-253
  Scenario: User manually assigns a new substitute for Reviewer role
    Given all substitutes for the Reviewer role are unavailable
    When the user attempts to manually assign a new substitute for the Reviewer role
    Then the system should allow manual assignment of a new substitute for the Reviewer role

  @TC-253
  Scenario: User manually assigns a new substitute for Approver role
    Given all substitutes for the Approver role are unavailable
    When the user attempts to manually assign a new substitute for the Approver role
    Then the system should allow manual assignment of a new substitute for the Approver role

  @TC-253
  Scenario: Administrator logs out of the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the system
    Then the user should successfully log out