Feature: Verify error message for unauthorized access to locked Credit Memo Request

  @TC-255
  Scenario Outline: Validate error messages for unauthorized actions on a locked Credit Memo Request
    Given the user logs into the SAP system with a user account "<user_account>"
    When the user navigates to transaction VA02
    And the user enters the locked Credit Memo Request ID "<credit_memo_request_id>" and accesses the document
    Then the system displays the Credit Memo Request details
    When the user attempts to edit any field in the Credit Memo Request
    Then the system prevents the user from making changes and displays an error message "<edit_error_message>"
    When the user attempts to save changes made to the Credit Memo Request
    Then the system does not allow saving changes and displays an error message "<save_error_message>"
    And the error message content clearly indicates the reason for the restriction "<restriction_reason>"

    Examples:
      | user_account        | credit_memo_request_id | edit_error_message                       | save_error_message                       | restriction_reason                |
      | without edit access | CMR12345               | Insufficient permissions or locked status | Insufficient permissions or locked status | Insufficient permissions          |
      | without edit access | CMR67890               | Insufficient permissions or locked status | Insufficient permissions or locked status | Locked status                      |

  @TC-255
  Scenario: Verify successful login and logout actions
    Given the user logs into the SAP system with a user account "without edit access"
    Then the user is successfully logged in
    When the user logs out of the SAP system
    Then the user is successfully logged out