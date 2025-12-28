Feature: Verify workflow retriggering for updated Billing Correction Request

  @TC-222
  Scenario: User logs into the SAP S/4HANA system and navigates to the Billing Correction Request section
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user gains access to the system
    And the Billing Correction Request section is displayed

  @TC-222
  Scenario: User searches for and opens the Billing Correction Request
    Given the user is on the Billing Correction Request section
    When the user searches for the Billing Correction Request with ID "BCR003"
    Then the Billing Correction Request details are displayed

  @TC-222
  Scenario Outline: User updates the price and data fields in the Billing Correction Request
    Given the user has opened the Billing Correction Request with ID "<BillingCorrectionRequestID>"
    When the user updates the price field to "<UpdatedPrice>"
    And the user updates the data field to "<UpdatedDataField>"
    And the user saves the changes to the Billing Correction Request
    Then the changes are saved successfully
    And the system confirms the update

    Examples:
      | BillingCorrectionRequestID | UpdatedPrice | UpdatedDataField          |
      | BCR003                     | $2500        | Correction reason: Pricing error |

  @TC-222
  Scenario: Verify that the workflow is retriggered with updated information
    Given the Billing Correction Request has been updated
    When the user verifies the workflow status
    Then a new workflow instance is triggered
    And the updated price and data fields are reflected in the new workflow instance

  @TC-222
  Scenario: Confirm the previous workflow instance is closed or marked as obsolete
    Given a new workflow instance has been triggered
    When the user checks the workflow history
    Then the previous workflow instance is closed or marked as obsolete

  @TC-222
  Scenario: Verify the updated workflow request is visible in the approver's inbox
    Given the workflow instance has been retriggered
    When the user navigates to the workflow inbox of the designated approver
    Then the updated workflow request is visible in the approver's inbox

  @TC-222
  Scenario: Verify the updated price and data fields are displayed in the workflow request
    Given the updated workflow request is visible in the approver's inbox
    When the user views the workflow request
    Then the updated price and data fields are displayed correctly

  @TC-222
  Scenario Outline: Approve or reject the updated workflow request
    Given the workflow request is displayed to the designated approver
    When the user performs the action "<WorkflowAction>" on the workflow request
    Then the workflow request is processed successfully based on the approver's action

    Examples:
      | WorkflowAction |
      | Approve        |
      | Reject         |

  @TC-222
  Scenario: Verify the status of the Billing Correction Request after workflow action
    Given the workflow request has been processed
    When the user checks the status of the Billing Correction Request
    Then the Billing Correction Request status is updated based on the workflow action