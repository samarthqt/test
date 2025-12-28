Feature: Verify unauthorized users cannot edit locked Credit Memo Request

  @TC-254
  Scenario Outline: Validate user without edit permissions cannot modify locked Credit Memo Request
    Given the user logs into the SAP system using a user account without edit permissions
    When the user navigates to transaction VA02
    And the user enters the locked Credit Memo Request ID "<CreditMemoRequestID>" and attempts to access the document
    Then the system displays the Credit Memo Request details
    When the user attempts to edit the "<Section>" section of the Credit Memo Request
    Then the system prevents the user from making changes and displays an error message "<ErrorMessage>"
    When the user attempts to save changes made to the Credit Memo Request
    Then the system does not allow saving changes and displays an appropriate error message "<SaveErrorMessage>"
    And the document remains in its original locked state

    Examples:
      | CreditMemoRequestID | Section       | ErrorMessage                      | SaveErrorMessage                     |
      | CMR12345            | header        | Insufficient permissions          | Changes cannot be saved              |
      | CMR12345            | line items    | Insufficient permissions          | Changes cannot be saved              |

  @TC-254
  Scenario: Verify user logs out successfully
    Given the user logs into the SAP system using a user account without edit permissions
    When the user logs out of the SAP system
    Then the user is successfully logged out