Feature: Verify system behavior when workflow fails to retrigger for Credit Memo Request

  @TC-223
  Scenario: Ensure workflow configuration is active for Credit Memo Requests
    Given the user has logged into the SAP S/4HANA system with appropriate credentials
    When the user navigates to the Credit Memo Request section
    Then the Credit Memo Request section is displayed

  @TC-223
  Scenario: Verify Credit Memo Request details are displayed
    Given the user is in the Credit Memo Request section
    When the user searches for and opens the Credit Memo Request with ID "CMR004"
    Then the Credit Memo Request details are displayed

  @TC-223
  Scenario Outline: Verify system updates fields in Credit Memo Request
    Given the user has opened the Credit Memo Request with ID "CMR004"
    When the user updates the <field> to <value>
    Then the <field> is updated successfully

    Examples:
      | field   | value         |
      | price   | $1800         |
      | data    | Discount 15%  |

  @TC-223
  Scenario: Verify changes are saved to Credit Memo Request
    Given the user has updated the fields in the Credit Memo Request
    When the user saves the changes
    Then the changes are saved, and the system confirms the update

  @TC-223
  Scenario: Simulate and verify failure in workflow retriggering process
    Given a workflow request has already been triggered for the Credit Memo Request
    When the user simulates a failure in the workflow retriggering process
    Then the workflow retriggering fails due to the simulated error

  @TC-223
  Scenario: Verify error logs for workflow retriggering failure
    Given the workflow retriggering process has failed
    When the user checks the system logs for error messages
    Then the system logs an error message indicating the failure in workflow retriggering

  @TC-223
  Scenario: Verify user notification for workflow retriggering failure
    Given the workflow retriggering process has failed
    When the user checks for notifications
    Then the user is notified about the workflow retriggering failure

  @TC-223
  Scenario: Verify manual retriggering of workflow
    Given the workflow retriggering process has failed
    When the user attempts to manually retrigger the workflow for the Credit Memo Request
    Then the system allows the user to manually retrigger the workflow

  @TC-223
  Scenario: Verify manually retriggered workflow reflects updated information
    Given the user has manually retriggered the workflow
    When the user verifies the workflow
    Then the manually retriggered workflow reflects the updated price and data fields

  @TC-223
  Scenario: Verify status of previous workflow instance
    Given the workflow has been manually retriggered
    When the user checks the status of the previous workflow instance
    Then the previous workflow instance is closed or marked as obsolete