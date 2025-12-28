Feature: Validate workflow progression with unavailable Reviewer and Approver substitutions

  Ensure the workflow progresses seamlessly when both the designated Reviewer and Approver are unavailable, and substitutes are assigned automatically. The system is configured with substitution rules for both Reviewer and Approver unavailability.

  @TC-246
  Scenario: Administrator logs in to the SAP system
    Given the user has administrator credentials with necessary permissions
    When the user logs in to the SAP system
    Then the administrator successfully logs in with required permissions

  @TC-246
  Scenario Outline: Mark Reviewer and Approver as unavailable
    Given the user navigates to the user management section
    When the user marks the designated Reviewer and Approver as unavailable for a specific period
    Then the Reviewer and Approver are successfully marked as unavailable in the system

    Examples:
      | Reviewer Status | Approver Status | Period       |
      | Unavailable     | Unavailable     | Specific Time |

  @TC-246
  Scenario: Create Billing Correction Request with designated Reviewer and Approver
    Given the user has Billing Correction Request data (e.g., ZRK)
    When the user creates a Billing Correction Request with the designated Reviewer and Approver assigned
    Then the Billing Correction Request is successfully created and routed for workflow

  @TC-246
  Scenario: Submit Billing Correction Request for workflow routing
    Given the user has a Billing Correction Request ready for submission
    When the user submits the Billing Correction Request for workflow routing
    Then the request is successfully submitted for workflow routing

  @TC-246
  Scenario Outline: Verify automatic substitution of unavailable Reviewer and Approver
    Given the system is configured with substitution rules for Reviewer and Approver unavailability
    When the user verifies the system automatically assigns substitutes for the unavailable Reviewer and Approver
    Then the system identifies the unavailability of the Reviewer and Approver and assigns substitutes automatically

    Examples:
      | Reviewer Status | Approver Status | Substitute Assigned |
      | Unavailable     | Unavailable     | Yes                 |

  @TC-246
  Scenario: Check workflow log for substitution process
    Given the user accesses the workflow log
    When the user checks the workflow log to confirm the substitution process
    Then the workflow log reflects the substitution of the unavailable Reviewer and Approver with the assigned substitutes

  @TC-246
  Scenario: Verify seamless workflow progression
    Given the workflow has substitutes assigned for unavailable Reviewer and Approver
    When the user verifies the workflow progression
    Then the workflow progresses seamlessly without any deadlocks or delays

  @TC-246
  Scenario: Ensure approval sequence and levels are preserved
    Given the workflow has predefined approval sequence and levels
    When the user verifies the approval sequence and levels in the workflow
    Then the approval sequence and required levels are maintained as per the configuration

  @TC-246
  Scenario: Verify substitute Reviewer and Approver receive notifications
    Given substitutes are assigned for unavailable Reviewer and Approver
    When the user verifies the workflow notifications
    Then the substitute Reviewer and Approver receive notifications for their respective tasks

  @TC-246
  Scenario Outline: Substitute Reviewer approves the request
    Given the user logs in as the substitute Reviewer
    When the user approves the request
    Then the substitute Reviewer successfully approves the request

    Examples:
      | Reviewer Role | Approval Status |
      | Substitute    | Approved        |

  @TC-246
  Scenario Outline: Substitute Approver approves the request
    Given the user logs in as the substitute Approver
    When the user approves the request
    Then the substitute Approver successfully approves the request

    Examples:
      | Approver Role | Approval Status |
      | Substitute    | Approved        |

  @TC-246
  Scenario: Verify workflow progression to the next stage
    Given all approvals are completed
    When the user verifies the workflow progression
    Then the workflow progresses to the next stage as per the defined process