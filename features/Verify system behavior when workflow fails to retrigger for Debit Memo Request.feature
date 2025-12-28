Feature: Verify system behavior when workflow fails to retrigger for Debit Memo Request

  @TC-224
  Scenario: Ensure the user can log in to the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs in to the SAP S/4HANA system
    Then the user successfully gains access to the system

  @TC-224
  Scenario: Ensure the user can navigate to the Debit Memo Request section
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Debit Memo Request section
    Then the Debit Memo Request section is displayed

  @TC-224
  Scenario Outline: Verify the user can search for and open a Debit Memo Request
    Given the user is in the Debit Memo Request section
    When the user searches for the Debit Memo Request with ID "<DebitMemoRequestID>"
    Then the details of the Debit Memo Request with ID "<DebitMemoRequestID>" are displayed

    Examples:
      | DebitMemoRequestID |
      | DMR005            |

  @TC-224
  Scenario Outline: Verify the user can update the price and data fields of the Debit Memo Request
    Given the user has opened the Debit Memo Request with ID "<DebitMemoRequestID>"
    When the user updates the price field to "<UpdatedPrice>"
    Then the price field is updated successfully
    When the user updates the data field to include a tax rate of "<TaxRate>"
    Then the data field is updated successfully

    Examples:
      | DebitMemoRequestID | UpdatedPrice | TaxRate |
      | DMR005            | $2200        | 5%      |

  @TC-224
  Scenario: Verify the user can save changes to the Debit Memo Request
    Given the user has updated the price and data fields of the Debit Memo Request
    When the user saves the changes to the Debit Memo Request
    Then the changes are saved, and the system confirms the update

  @TC-224
  Scenario: Verify the system logs an error when workflow retriggering fails
    Given the user has saved changes to the Debit Memo Request
    When the workflow retriggering process fails due to a simulated error
    Then the system logs an error message indicating the failure in workflow retriggering

  @TC-224
  Scenario: Verify the user is notified of the workflow retriggering failure
    Given the workflow retriggering process has failed
    When the system logs an error message
    Then the user is notified about the workflow retriggering failure

  @TC-224
  Scenario: Verify the user can manually retrigger the workflow for the Debit Memo Request
    Given the user has been notified about the workflow retriggering failure
    When the user attempts to manually retrigger the workflow for the Debit Memo Request
    Then the system allows the user to manually retrigger the workflow

  @TC-224
  Scenario: Verify the manually retriggered workflow reflects the updated information
    Given the user has manually retriggered the workflow for the Debit Memo Request
    When the workflow is retriggered
    Then the manually retriggered workflow reflects the updated price and data fields

  @TC-224
  Scenario: Verify the previous workflow instance is closed or marked as obsolete
    Given the workflow has been manually retriggered
    When the user checks the status of the previous workflow instance
    Then the previous workflow instance is closed or marked as obsolete