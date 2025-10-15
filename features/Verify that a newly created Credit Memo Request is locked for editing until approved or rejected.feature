Feature: Verify that a newly created Credit Memo Request is locked for editing until approved or rejected

  @TC-485
  Scenario: User logs into the SAP system with appropriate permissions
    Given the user has a valid account with permissions to create Credit Memo Requests
    When the user logs into the SAP system
    Then the user is successfully logged into the SAP system

  @TC-485
  Scenario: User navigates to the transaction for creating a Credit Memo Request
    Given the user is logged into the SAP system
    When the user navigates to the transaction for creating a Credit Memo Request
    Then the Credit Memo Request creation screen is displayed

  @TC-485
  Scenario: User creates and saves a Credit Memo Request
    Given the user is on the Credit Memo Request creation screen
    When the user completes the required fields such as reference billing document and reason for request
    And the user saves the Credit Memo Request
    Then the Credit Memo Request is successfully created and saved
    And a unique document number is generated

  @TC-485
  Scenario Outline: User attempts to edit the Credit Memo Request at different stages
    Given the user has created a Credit Memo Request
    When the user attempts to edit the Credit Memo Request <stage>
    Then the system <editOutcome>

    Examples:
      | stage                         | editOutcome                                       |
      | immediately after creation    | prevents any edits and displays a locked error   |
      | during the approval workflow  | prevents any edits and displays a locked error   |
      | after approval                | allows editing based on the next process steps   |
      | after rejection               | allows editing based on the next process steps   |

  @TC-485
  Scenario: User submits the Credit Memo Request for approval
    Given the user has created a Credit Memo Request
    When the user submits the Credit Memo Request for approval
    Then the Credit Memo Request is successfully submitted for approval

  @TC-485
  Scenario Outline: User approves or rejects the Credit Memo Request
    Given the Credit Memo Request is in the approval workflow
    When the user <action> the Credit Memo Request using the workflow process
    Then the Credit Memo Request is successfully <outcome>

    Examples:
      | action    | outcome  |
      | approves  | approved |
      | rejects   | rejected |

  @TC-485
  Scenario: Verify system logs for unauthorized editing attempts
    Given the Credit Memo Request is in the approval/rejection workflow
    When the user checks the system logs for unauthorized editing attempts
    Then the system logs show no unauthorized edits were made during the workflow process

  @TC-485
  Scenario: Validate the integrity of Credit Memo Request data
    Given the Credit Memo Request is in the approval/rejection workflow
    When the user verifies the integrity of the Credit Memo Request data
    Then the system maintains the integrity of the Credit Memo Request data with no unauthorized changes