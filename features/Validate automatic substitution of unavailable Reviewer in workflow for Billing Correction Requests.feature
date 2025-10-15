Feature: Validate automatic substitution of unavailable Reviewer in workflow for Billing Correction Requests

  @TC-244
  Scenario: User logs in to the SAP system as an administrator
    Given the user has administrator credentials with necessary permissions
    When the user logs in to the SAP system
    Then the user successfully logs in with required permissions

  @TC-244
  Scenario: User marks a designated Reviewer as unavailable for a specific period
    Given the user navigates to the user management section
    When the user marks a designated Reviewer as unavailable for a specific period
    Then the Reviewer is successfully marked as unavailable in the system

  @TC-244
  Scenario: User creates a Billing Correction Request with the designated Reviewer assigned
    Given the Reviewer is marked unavailable for a specific period
    When the user creates a Billing Correction Request with the designated Reviewer assigned
    Then the Billing Correction Request is successfully created and routed for workflow

  @TC-244
  Scenario: User submits the Billing Correction Request for workflow routing
    Given the Billing Correction Request is created and routed for workflow
    When the user submits the Billing Correction Request for workflow routing
    Then the request is successfully submitted for workflow routing

  @TC-244
  Scenario: System automatically assigns a substitute for the unavailable Reviewer
    Given the Billing Correction Request is submitted for workflow routing
    When the system identifies the unavailability of the Reviewer
    Then the system assigns a substitute automatically

  @TC-244
  Scenario: User verifies the workflow log for substitution process
    Given the system has assigned a substitute for the unavailable Reviewer
    When the user checks the workflow log
    Then the workflow log reflects the substitution of the unavailable Reviewer with the assigned substitute

  @TC-244
  Scenario: Workflow progresses without interruption
    Given the substitute Reviewer is assigned
    When the workflow progresses
    Then the workflow progresses seamlessly without any deadlocks or delays

  @TC-244
  Scenario: Approval sequence and levels are preserved in the workflow
    Given the workflow progresses without interruption
    When the user verifies the approval sequence and levels
    Then the approval sequence and required levels are maintained as per the configuration

  @TC-244
  Scenario: Substitute Reviewer receives the workflow notification
    Given the substitute Reviewer is assigned
    When the workflow notification is sent
    Then the substitute Reviewer receives the notification for the assigned task

  @TC-244
  Scenario: Substitute Reviewer approves the request
    Given the substitute Reviewer has received the workflow notification
    When the substitute Reviewer logs in and approves the request
    Then the substitute Reviewer successfully approves the request

  @TC-244
  Scenario: Workflow progresses to the next stage after approval
    Given the substitute Reviewer approves the request
    When the workflow progresses
    Then the workflow progresses to the next stage as per the defined process

  @TC-244
  Scenario: System logs are checked for errors or warnings during substitution process
    Given the workflow progresses to the next stage
    When the user checks the system logs
    Then no errors or warnings are logged during the substitution process