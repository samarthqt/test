Feature: Verify workflow retriggering for minimum field update in Credit Memo Request

  @TC-226
  Scenario: Ensure the user can log in to the SAP S/4HANA system
    Given the user has valid credentials
    When the user logs in to the SAP S/4HANA system
    Then the user gains access to the system

  @TC-226
  Scenario: Navigate to the Credit Memo Request section
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Credit Memo Request section
    Then the Credit Memo Request section is displayed

  @TC-226
  Scenario: Search and open a Credit Memo Request
    Given the user is in the Credit Memo Request section
    When the user searches for and opens the Credit Memo Request with ID "CMR007"
    Then the Credit Memo Request details are displayed

  @TC-226
  Scenario Outline: Update fields in the Credit Memo Request
    Given the user has opened the Credit Memo Request with ID "CMR007"
    When the user updates the "<field>" field to "<value>"
    Then the "<field>" field is updated successfully

    Examples:
      | field             | value                          |
      | price             | $0.01                          |
      | data (Correction reason) | Minimum allowable value |

  @TC-226
  Scenario: Save changes to the Credit Memo Request
    Given the user has updated the required fields in the Credit Memo Request
    When the user saves the changes
    Then the changes are saved, and the system confirms the update

  @TC-226
  Scenario: Verify workflow retriggering with updated information
    Given the user has saved the changes to the Credit Memo Request
    When the user verifies the workflow
    Then a new workflow instance is triggered reflecting the updated price and data fields

  @TC-226
  Scenario: Confirm the previous workflow instance is closed or marked as obsolete
    Given the user has verified the new workflow instance
    When the user checks the workflow history
    Then the previous workflow instance is closed or marked as obsolete

  @TC-226
  Scenario: Verify the updated workflow request in the approver's inbox
    Given the user is a designated approver
    When the user navigates to the workflow inbox
    Then the updated workflow request is visible in the approver's inbox

  @TC-226
  Scenario: Verify the updated fields in the workflow request
    Given the updated workflow request is visible in the approver's inbox
    When the user reviews the workflow request
    Then the workflow request displays the updated price and data fields correctly

  @TC-226
  Scenario Outline: Process the updated workflow request
    Given the user is a designated approver
    When the user "<action>" the updated workflow request
    Then the workflow request is processed successfully based on the approver's action

    Examples:
      | action   |
      | approves |
      | rejects  |

  @TC-226
  Scenario: Verify the status of the Credit Memo Request after workflow action
    Given the workflow request has been processed
    When the user checks the status of the Credit Memo Request
    Then the Credit Memo Request status is updated based on the workflow action