Feature: Validate error handling when attempting to cancel a non-existent invoice  
  Ensure the system prevents cancellation attempts for non-existent invoices and displays appropriate error messages. Ensure no invoice exists for the input invoice number in the system.

  @TC-2
  Scenario Outline: Validate cancellation of invoices with various invoice numbers
    Given the user navigates to the invoice cancellation screen (VF11)
    When the user enters the invoice number "<Invoice Number>"
    And the user selects the cancellation document type "<Cancellation Document Type>"
    And the user attempts to execute the cancellation process
    Then the system displays the message "<System Message>"
    And no cancellation billing document is created in the system
    And the system logs capture the error details accurately
    And the system maintains data integrity by preventing invalid cancellations

    Examples:
      | Invoice Number | Cancellation Document Type | System Message                          |
      | INV99999       | S1                         | Invoice does not exist                  |
      | INV00001       | S1                         | Cancellation process completed          |

  @TC-2
  Scenario: Validate that a clear and actionable error message is displayed for non-existent invoices
    Given the user navigates to the invoice cancellation screen (VF11)
    When the user enters the invoice number "INV99999"
    And the user selects the cancellation document type "S1"
    And the user attempts to execute the cancellation process
    Then the system displays a clear and actionable error message indicating the invoice does not exist

  @TC-2
  Scenario: Validate the search functionality for non-existent invoices
    Given the user navigates to the invoice search screen
    When the user searches for the invoice number "INV99999"
    Then the system confirms that the invoice does not exist

  @TC-2
  Scenario: Validate successful cancellation with a valid invoice number
    Given the user navigates to the invoice cancellation screen (VF11)
    When the user enters the invoice number "INV00001"
    And the user selects the cancellation document type "S1"
    And the user attempts to execute the cancellation process
    Then the system allows the cancellation process
    And a cancellation billing document is created in the system

  @TC-2
  Scenario: Validate error handling aligns with business rules
    Given the user attempts to cancel a non-existent invoice
    When the system prevents the cancellation process
    Then the error handling process aligns with business rules and prevents invalid operations

  @TC-2
  Scenario: Validate error handling scenario is documented for audit purposes
    Given the user attempts to cancel a non-existent invoice
    When the system prevents the cancellation process
    Then the error handling scenario is documented in audit logs