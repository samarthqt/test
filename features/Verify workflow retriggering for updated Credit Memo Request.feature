Feature: Verify workflow retriggering for updated Credit Memo Request

  Ensure that the workflow is retriggered when price or data fields affecting the decision are updated in a Credit Memo Request. Ensure the workflow configuration is active for Credit Memo Requests.

  @TC-220
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user successfully gains access to the system

  @TC-220
  Scenario: User navigates to the Credit Memo Request section
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Credit Memo Request section
    Then the Credit Memo Request section is displayed

  @TC-220
  Scenario: User searches for and opens a Credit Memo Request
    Given the user is in the Credit Memo Request section
    When the user searches for and opens the Credit Memo Request with ID "CMR001"
    Then the Credit Memo Request details are displayed

  @TC-220
  Scenario Outline: User updates fields in the Credit Memo Request
    Given the user has opened the Credit Memo Request with ID "<Credit Memo Request ID>"
    When the user updates the price field to "<Updated Price>"
    And the user updates the data field to include "<Updated Data Field>"
    And the user saves the changes to the Credit Memo Request
    Then the changes are saved, and the system confirms the update

    Examples:
      | Credit Memo Request ID | Updated Price | Updated Data Field |
      | CMR001                 | $1500         | Discount 10%       |

  @TC-220
  Scenario: Verify workflow retriggering with updated information
    Given the user has updated the Credit Memo Request
    When the user verifies the workflow retriggering
    Then a new workflow instance is triggered, reflecting the updated price and data fields

  @TC-220
  Scenario: Verify previous workflow instance status
    Given the user has triggered a new workflow instance
    When the user checks the workflow history
    Then the previous workflow instance is closed or marked as obsolete

  @TC-220
  Scenario: Verify updated workflow request in approver's inbox
    Given the user has triggered a new workflow instance
    When the user navigates to the workflow inbox of the designated approver
    Then the updated workflow request is visible in the approver's inbox

  @TC-220
  Scenario: Verify updated fields in workflow request
    Given the updated workflow request is visible in the approver's inbox
    When the user verifies the updated price and data fields in the workflow request
    Then the workflow request displays the updated price and data fields correctly

  @TC-220
  Scenario Outline: Approve or reject the updated workflow request
    Given the designated approver has reviewed the updated workflow request
    When the approver "<Approver Action>" the workflow request
    Then the workflow request is processed successfully based on the approver's action

    Examples:
      | Approver Action |
      | approves        |
      | rejects         |

  @TC-220
  Scenario: Verify Credit Memo Request status after workflow action
    Given the workflow request has been processed
    When the user checks the status of the Credit Memo Request
    Then the Credit Memo Request status is updated based on the workflow action