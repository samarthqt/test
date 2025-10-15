Feature: Verify workflow retriggering for updated Debit Memo Request

  @TC-221
  Scenario Outline: Ensure workflow is retriggered when price or data fields affecting the decision are updated in a Debit Memo Request
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the Debit Memo Request with ID "<Debit Memo Request ID>" exists with a workflow already triggered
    When the user navigates to the Debit Memo Request section
    And the user searches for and opens the Debit Memo Request with ID "<Debit Memo Request ID>"
    And the user updates the price field to "<Updated Price Field Value>"
    And the user updates the data field to include "<Updated Data Field Value>"
    And the user saves the changes to the Debit Memo Request
    Then the workflow is retriggered with the updated information
    And the previous workflow instance is closed or marked as obsolete
    When the user navigates to the workflow inbox of the designated approver
    Then the updated workflow request is visible in the approver's inbox
    And the updated price and data fields are displayed in the workflow request correctly
    When the designated approver approves or rejects the updated workflow request
    Then the workflow request is processed successfully based on the approver's action
    And the status of the Debit Memo Request is updated based on the workflow action

    Examples:
      | Debit Memo Request ID | Updated Price Field Value | Updated Data Field Value |
      | DMR002                | $2000                    | Tax rate 8%              |